package model.monster;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.GameChar;
import model.GameModel;
import model.Position;
import model.board.Item;
import model.board.BoardExit;
import model.board.ItemPath;
import model.board.UndestructibleWall;
import model.player.Player;
import java.io.Serializable;


/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a MonsterState subclass that defines the current state.
 * 
 */
public class Monster implements GameChar, Serializable{

	//Random Monster Movement
	/** The Constant UP. */
	private final Position UP = new Position(-1,0);
	
	/** The Constant DOWN. */
	private final Position DOWN = new Position(1,0);
	
	/** The Constant LEFT. */
	private final Position LEFT = new Position(0,-1);
	
	/** The Constant RIGHT. */
	private final Position RIGHT = new Position(0,1);
	
	/** The Constant UPDATE_RATE. */
	private final int UPDATE_RATE = 3;
	

	/** The state. */
	private MonsterState state;
	
	/** The board position. */
	private Position boardPosition;
	
	/**  The next board position. */
	private Position nextMonsterPosition; 
	
	/** The Animation of the Item. */
	private transient BufferedImage monsterImg;
	
	/** The next update counter. */
	private int nextUpdateCounter;
	
	/** The moved. */
	private boolean moved;

	// =============================================================
	
	/**
	 * Instantiates a new monster.
	 */
	public Monster(){
		this.state = new MonsterAlive();
		this.boardPosition = new Position();
		this.nextMonsterPosition = new Position();
		this.nextUpdateCounter = UPDATE_RATE;
		this.moved = false;
		
		try 
		{
			monsterImg = ImageIO.read(new File("img/monster_s.png"));			
		} catch (IOException e) {}
	}
	
	/**
	 * Get Monster board position.
	 *
	 * @return the board position
	 */
	public Position getBoardPosition(){
		return boardPosition;
	}
	
	/**
	 * Set Monster board position.
	 *
	 * @param n_pos the new Monster board position
	 */
	public void setBoardPosition(Position n_pos){
		this.boardPosition = n_pos;
	}
	
	/**
	 * Gets the current state.
	 *
	 * @return the current state
	 */
	public MonsterState getCurrentState(){
		return state;
	}
	
	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public void setCurrentState(MonsterState state){
		this.state = state;
	}

	/**
	 * Update Monster.
	 */
	public void update(){
		
		if (nextUpdateCounter == 0) {
			while (!moved){
				nextMonsterPosition = generateNextMov();
				GameModel.getInstance().getBoard().getItem(nextMonsterPosition).accept(this);
			}
			moved = false;
			nextUpdateCounter = UPDATE_RATE;
		} else {
			nextUpdateCounter--;
		}
		
		
	}

	/**
	 * Generate randomly next monster movement.
	 *
	 * @return newPosMonster
	 */
	public Position generateNextMov() {
		Position mov_options[] = {UP,DOWN,LEFT,RIGHT};
		Position mov_selected = mov_options[(int)(Math.random() * mov_options.length)]; 
		Position newPosMonster = boardPosition.add(mov_selected);
		return newPosMonster;
	}
	
	/**
	 * Check if monster is killed by detonation and change MonsterStatus.
	 *
	 * @param itemPos the item pos
	 * @return true, if successful
	 */
	public boolean checkDeath(Item itemPos){
		if(itemPos.isExploding()){
			setCurrentState(getCurrentState().die());
			return true;
		}
		return false;
	}
	
	/**
	 * Checks collisions with players.
	 *
	 * @return true, if successful
	 */
	public boolean checkCollision(){
		if(!getCurrentState().isDead()){
			if(boardPosition.equals(GameModel.getInstance().getPlayers().getBoardPosition())){
				collidesWith(GameModel.getInstance().getPlayers());
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Moves to new board item.
	 *
	 * @param mov_item the mov_item
	 */
	public void moveMonster(Item mov_item){		
		// Change boardPosition to nextBoardPosition
		setBoardPosition(nextMonsterPosition);
	}
	
	/**
	 * Monster visits board exit item in game board.
	 *
	 * @param item the item
	 */
	public void visitBoardExit(BoardExit item){
		moveMonster(item);
		checkDeath(item);
		checkCollision();
	}
	
	/**
	 * Monster visits path item in game board.
	 *
	 * @param item the item
	 */
	public void visitPath(ItemPath item){
		moved = true;
		moveMonster(item);
		checkDeath(item);
		checkCollision();
	}
	
	/**
	 * Monster visits undestructible wall item in game board.
	 *
	 * @param item the item
	 */
	public void visitUndestructibleWall(UndestructibleWall item){
		moveMonster(item);
		checkDeath(item);
		checkCollision();
	}
	
	/**
	 * Collision Management.
	 *
	 * @param gameChar the game char
	 */
	public void collidesWith(GameChar gameChar){
		gameChar.visit(this);
	}
	
	/**
	 * Visited by Player.
	 *
	 * @param vPlayer the v player
	 */
	public void visit(Player vPlayer){
		if(!getCurrentState().isDead())
		{
			vPlayer.setCurrentState(vPlayer.getCurrentState().die());
		}		
	}
	
	/**
	 * Visited by Monster.
	 *
	 * @param vMonster the v monster
	 */
	public void visit(Monster vMonster){}
	
	/**
	 * Sets the animation.
	 *
	 * @param animation the new animation
	 */
	public void setAnimation(BufferedImage animation){
		this.monsterImg = animation;
	}
	
	/**
	 * Draw.
	 *
	 * @param g the g
	 * @param width the width
	 * @param height the height
	 */
	public void draw(Graphics g, int width, int height){
		int n = GameModel.getInstance().getBoard().getMaze().length;
		int dstImgWid = width / n;
		int dstImgHei = height / n;
		
		g.drawImage(monsterImg, boardPosition.getCol()*dstImgWid, boardPosition.getLine()*dstImgHei, 
				(boardPosition.getCol()*dstImgWid)+dstImgWid, (boardPosition.getLine()*dstImgHei)+dstImgHei, 0, 0, 124, 115, null);
	}
	
}

//end Monster
