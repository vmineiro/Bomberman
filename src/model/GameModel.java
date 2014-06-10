package model;

import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import model.board.Board;
import model.board.BoardFactory;
import model.monster.Monster;
import model.player.Player;

/**
 * This class GameModel defines an Instance operation that lets clients access its
 * unique instance, and may be responsible for creating its own unique
 * instance.
 */
public class GameModel implements Serializable{

	/** The unique instance. */
	private static GameModel uniqueGameModel = null;
	
	/** The board. */
	private Board board;
	
	/** The players. */
	private Player players;
	
	/** The monsters. */
	private ArrayList<Monster> monsters;
	
	/**  Key Pressed Up. */
	private boolean pressedUp = false;
	
	/**  Key Pressed Down. */
	private boolean pressedDown = false;
	
	/**  Key Pressed Left. */
	private boolean pressedLeft = false;
	
	/**  Key Pressed Right. */
	private boolean pressedRight = false;
	
	//Player Movement Increments
	/** The Constant UP. */
	public static final Position UP = new Position(-1,0);
	
	/** The Constant DOWN. */
	public static final Position DOWN = new Position(1,0);
	
	/** The Constant LEFT. */
	public static final Position LEFT = new Position(0,-1);
	
	/** The Constant RIGHT. */
	public static final Position RIGHT = new Position(0,1);
	
	// =====================================================================
	
	/**
	 * Instantiates a new game model.
	 */
	private GameModel(){
		this.board = new Board();
		this.players = new Player();
		this.monsters = new ArrayList<Monster>();
	}	
	
	/**
	 * Instance.
	 *
	 * @return single instance of GameModel
	 */
	public static GameModel getInstance(){
			if(uniqueGameModel == null){
				return uniqueGameModel = new GameModel();
			}
			else{
				return uniqueGameModel;
			}
	}
	
	/**
	 * Initializes all game elements.
	 *
	 * @param board_number is the of the
	 */
	public void initGame(){
		
		standardInitGame(4);

	}

	
	/**
	 * Reads board file and launches game.
	 *
	 * @param boardNumber the board number
	 */
	public void readBoardFile(String boardPath) throws FileNotFoundException{
		
		int board_size = 0;
		int nMonsters = 0; 
		int boardInt [][];

		String fileName = boardPath;

		try 
		{
			File fileIn = new File(fileName);
			Scanner scanner = new Scanner(fileIn);

			board_size = scanner.nextInt();
			nMonsters = scanner.nextInt();

			boardInt = new int[board_size][board_size];

			for(int i=0; i<board_size; i++){
				for(int j=0; j<board_size; j++){
					boardInt[i][j] = scanner.nextInt();
				}
			}

			scanner.close();

			//Initializes board game
			BoardFactory boardBuilt = new BoardFactory(board_size, boardInt);
			setBoard(boardBuilt.getResult());

			//Initializes monsters and player
			addMonsters(nMonsters);
			addPlayer(board_size);

		} catch (FileNotFoundException e) {
			standardInitGame(4);
		}
	}
	
	/**
	 * Initializes standard game.
	 *
	 * @param n_Monsters the n_ monsters
	 */
	public void standardInitGame(int n_Monsters) {
		
		int board_size = 11;
		int boardInt [][] = {
				{0,0,0,0,0,0,0,0,0,0,0},
				{0,1,1,1,1,1,1,1,1,1,0},
				{0,2,0,2,0,2,0,2,0,2,0},
				{0,1,1,1,1,1,1,1,1,1,0},
				{0,2,0,2,0,2,0,2,0,2,0},
				{0,1,1,1,1,1,1,1,1,1,0},
				{0,2,0,2,0,2,0,2,0,2,0},
				{0,1,1,1,1,1,1,1,1,1,0},
				{0,2,0,2,0,2,0,2,0,2,0},
				{0,1,1,1,1,1,1,1,1,1,0},
				{0,0,0,0,0,3,0,0,0,0,0},
		};
		
		//Initializes board game
		BoardFactory boardBuilt = new BoardFactory(board_size, boardInt);
		setBoard(boardBuilt.getResult());

		//Initializes monsters and player
		addMonsters(n_Monsters);
		addPlayer(board_size);
	}
	
	/**
	 * Reset GameModel singleton instance (For testing use only).
	 */
	public void resetGameModel(){
		uniqueGameModel = new GameModel();
	}
	
	/**
	 * Adds monsters to the game.
	 *
	 * @param nMonsters is the number of game monsters
	 */
	public void addMonsters(int nMonsters){
		monsters.clear();
		for(int i=0; i<nMonsters; i++){
			Monster monst = new Monster();
			monst.setBoardPosition(new Position(1,1));
			monsters.add(monst);
		}
	}	
	
	/**
	 * Add a player to the game.
	 *
	 * @param boardSize the board size
	 */
	public void addPlayer(int boardSize){		
		this.players.updateBoardPosition(new Position(boardSize-2,boardSize-2));
		this.players.updateDrawPosition(this.players.getBoardPosition());
	}
	
	/**
	 * Update the game state. Calls update method of all objects.
	 */
	public void update(){
		
		for(int i=0; i<monsters.size(); i++)
		{
			if(monsters.get(i).getCurrentState().isDead())
			{
				monsters.remove(i);
			}
			else
			{
			monsters.get(i).update();
			}
		}
		
		if(getMonsters().isEmpty()){
			getBoard().getExitItem().setCurrentState(getBoard().getExitItem().getCurrentState().openExit());
		}
		
	}
	
	/**
	 * Update key pressed to UP.
	 */
	public void updateKeyUp(){
		this.pressedUp = true;
		players.update();
	}
	
	/**
	 * Update key pressed to DOWN.
	 */
	public void updateKeyDown(){
		this.pressedDown = true;
		players.update();
	}
	
	/**
	 * Update key pressed to LEFT.
	 */
	public void updateKeyLeft(){
		this.pressedLeft = true;
		players.update();
	}
	
	/**
	 * Update key pressed to RIGHT.
	 */
	public void updateKeyRight(){
		this.pressedRight = true;
		players.update();
	}
	
	/**
	 * Update key released.
	 */
	public void updateKeyReleased(){
		this.pressedUp = false;
		this.pressedDown = false;
		this.pressedLeft = false;
		this.pressedRight = false;
	}
	
	/**
	 * Get player next movement.
	 *
	 * @param playerMoving the player moving
	 * @return newPosPlayer
	 */
	public Position getNextMov(Player playerMoving){
		
		if((playerMoving.getBoardPosition().getCol() > 0) && (playerMoving.getBoardPosition().getCol() < board.getMaze().length))
		{
			if((playerMoving.getBoardPosition().getLine() > 0) && (playerMoving.getBoardPosition().getLine() < board.getMaze().length))
			{
				if(pressedUp){
					return playerMoving.getBoardPosition().add(UP);
				}
				else if(pressedDown){
					return playerMoving.getBoardPosition().add(DOWN);
				}
				else if(pressedLeft){
					return playerMoving.getBoardPosition().add(LEFT);
				}
				else if(pressedRight){
					return playerMoving.getBoardPosition().add(RIGHT);
				}
			}
		}
		
		return playerMoving.getBoardPosition();
	}
	
	/**
	 * Get board.
	 *
	 * @return the board
	 */
	public Board getBoard(){
		return board;
	}	
	
	/**
	 * Sets the board.
	 *
	 * @param board2 the new board
	 */
	public void setBoard(Board board2){
		this.board = board2;
	}
	
	/**
	 * Get players.
	 *
	 * @return the players
	 */
	public Player getPlayers(){
		return players;
	}
	
	/**
	 * Sets the players.
	 *
	 * @param player2 the new players
	 */
	public void setPlayers(Player player2){
		this.players = player2;
	}	
	
	/**
	 * Get monsters.
	 *
	 * @return the monsters
	 */
	public ArrayList<Monster> getMonsters(){
		return monsters;
	}
	
	/**
	 * Sets the monsters.
	 *
	 * @param monsters2 the new monsters
	 */
	public void setMonsters(ArrayList<Monster> monsters2){
		this.monsters = monsters2;
	}
	
	/**
	 * Special hook provided by serialization where developer can control what object needs to sent.
	 * However this method is invoked on the new object instance created by de serialization process.
	 *
	 * @return the object
	 * @throws ObjectStreamException the object stream exception
	 */
	 private Object readResolve() throws ObjectStreamException{
	  return uniqueGameModel;
	 }
	
	/**
	 * Sets the game.
	 *
	 * @param tempGame the new game
	 */
	public void setGame(GameModel tempGame) {
		setBoard(tempGame.getBoard());
		setPlayers(tempGame.getPlayers());
		setMonsters(tempGame.getMonsters());
	}

	/**
	 * Save game.
	 *
	 * @param path the path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveGame(String path) throws IOException {

		FileOutputStream fileOut = new FileOutputStream(path);
		ObjectOutputStream os = new ObjectOutputStream(fileOut);

		/* Write the game in a file */
		//os.writeObject(this);
		
		//TODO:
		GameBox gBox = new GameBox(players, board, monsters);
		os.writeObject(gBox);

		fileOut.close();
		os.close();
	}

	/**
	 * Load game.
	 *
	 * @param path the path
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	public void loadGame(String path) throws IOException, ClassNotFoundException {
		
		FileInputStream fileIn = new FileInputStream(path);
		ObjectInputStream is = new ObjectInputStream(fileIn);

		/* load the saved game in the file to the object tempGame */
		//GameModel tempGame = (GameModel)is.readObject();
		
		//TODO:
		GameBox gBox_t = (GameBox)is.readObject();
		
		Player player_t = gBox_t.getPlayerBox();
		player_t.loadImgPlayer();
		
		Board board_t = gBox_t.getBoardBox();
		board_t.loadImgBoard();
		
		ArrayList<Monster> mons_t = gBox_t.getMonsterBox();
		for(Monster monst_pos : mons_t){
			monst_pos.loadImgMons();
		}
		
		players = player_t;
		board = board_t;
		monsters = mons_t;

		is.close();
		fileIn.close();

	}

	/**
	 * Game over.
	 *
	 * @return true, if the game is over.
	 */
	public boolean gameOver(){
		
		if(getPlayers().getCurrentState().isDead()){
			return true;
		}
		
		if(getPlayers().getBoardPosition().equals(getBoard().getExitPos())){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Draw Game - Calls draw method of all objects.
	 *
	 * @param g the g
	 * @param width the width
	 * @param height the height
	 */
	public void draw(Graphics g, int width, int height){
		
		GameModel.getInstance().getBoard().draw(g, width, height);
				
		for(Monster monster : monsters){
			monster.draw(g, width, height);
		}
		
		GameModel.getInstance().getPlayers().draw(g, width, height);
	}
}

//end GameModel
