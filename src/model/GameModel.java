package model;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.swing.Timer;

import model.board.Board;
import model.board.BoardExit;
import model.board.BoardFactory;
import model.board.Item;
import model.board.ItemActive;
import model.board.ItemHidden;
import model.board.ItemInactive;
import model.board.ItemPath;
import model.board.UndestructibleWall;
import model.monster.Monster;
import model.player.Player;

//TODO: Add Comments to all function
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
	
	/** Game Logic Timer */
	private Timer gameTimer;
	
	/** Game Logic refresh rate */
	private static final int LOGIC_RATE = 250;
	
	/** Key Pressed Up */
	private boolean pressedUp = false;
	
	/** Key Pressed Down */
	private boolean pressedDown = false;
	
	/** Key Pressed Left */
	private boolean pressedLeft = false;
	
	/** Key Pressed Right */
	private boolean pressedRight = false;
	
	//Player Movement Increments
	public static final Position UP = new Position(-1,0);
	public static final Position DOWN = new Position(1,0);
	public static final Position LEFT = new Position(0,-1);
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
	 * Initializes all game elements
	 * @param board_number is the of the 
	 */
	public void initGame(int board_number){
		
		readBoardFile(board_number);

		ActionListener gameTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				GameModel.getInstance().update();	
			}
		};

		gameTimer = new Timer(LOGIC_RATE, gameTimerListener);
		gameTimer.start();

	}
	
	/**
	 * Reads board file and launches game
	 * @param boardNumber
	 */
	public void readBoardFile(int boardNumber){

		int board_size = 0;
		int nMonsters = 0; 
		int boardInt [][];

		StringBuilder sb = new StringBuilder();
		sb.append("board_files/board_");
		sb.append(boardNumber);
		sb.append(".txt");
		String fileName = sb.toString();

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
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds monsters to the game
	 * @param nMonsters is the number of game monsters
	 */
	public void addMonsters(int nMonsters){
		for(int i=0; i<nMonsters; i++){
			Monster monst = new Monster();
			monst.setBoardPosition(new Position(1,1));
			monsters.add(monst);
		}
	}	
	
	/**
	 * Add a player to the game
	 * 
	 * @param player the player to be added.
	 */
	public void addPlayer(int boardSize){		
		this.players.updateBoardPosition(new Position(boardSize-2,boardSize-2));
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
		
		if(GameModel.getInstance().gameOver()){
			gameTimer.stop();
			
			//TODO: DELETE AFTER TESTING
			System.out.println("GAME OVER");
		}		
	}
	
	/**
	 * Update key pressed to UP 
	 */
	public void updateKeyUp(){
		this.pressedUp = true;
		players.update();
	}
	
	/**
	 * Update key pressed to DOWN 
	 */
	public void updateKeyDown(){
		this.pressedDown = true;
		players.update();
	}
	
	/**
	 * Update key pressed to LEFT 
	 */
	public void updateKeyLeft(){
		this.pressedLeft = true;
		players.update();
	}
	
	/**
	 * Update key pressed to RIGHT 
	 */
	public void updateKeyRight(){
		this.pressedRight = true;
		players.update();
	}
	
	/**
	 * Update key released  
	 */
	public void updateKeyReleased(){
		this.pressedUp = false;
		this.pressedDown = false;
		this.pressedLeft = false;
		this.pressedRight = false;
	}
	
	/**
	 * Get player next movement
	 * 
	 * @param player moving
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
	 * Get board
	 */
	public Board getBoard(){
		return board;
	}	
	
	/**
	 * Sets the board.
	 *
	 * @param board the new board
	 */
	public void setBoard(Board board2){
		this.board = board2;
	}
	
	/**
	 * Get players 
	 */
	public Player getPlayers(){
		return players;
	}
	
	/**
	 * Sets the players
	 * @param player2
	 */
	public void setPlayers(Player player2){
		this.players = player2;
	}	
	
	/**
	 * Get monsters
	 */
	public ArrayList<Monster> getMonsters(){
		return monsters;
	}
	
	/**
	 * Sets the monsters
	 * @param monsters2
	 */
	public void setMonsters(ArrayList<Monster> monsters2){
		this.monsters = monsters2;
	}
	
	/**
	  * Special hook provided by serialization where developer can control what object needs to sent.
	  * However this method is invoked on the new object instance created by de serialization process.
	  * @return
	  * @throws ObjectStreamException
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
		os.writeObject(this);

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
		GameModel tempGame = (GameModel)is.readObject();

		is.close();
		fileIn.close();

		/* Change the Current Game */
		setGame(tempGame);
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
			//TODO: Delete System.out
			System.out.println("Player won");
			return true;
		}
		
		return false;
	}
	
	/**
	 * Draw Game - Calls draw method of all objects.
	 */
	public void draw(Graphics g, int width, int height){
		
		GameModel.getInstance().getBoard().draw(g, width, height);
		
		GameModel.getInstance().getPlayers().draw(g, width, height);
		
		for(Monster monster : monsters){
			monster.draw(g, width, height);
		}
		
		
	}
}

//end GameModel
