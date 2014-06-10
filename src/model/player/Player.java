package model.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.GameChar;
import model.GameModel;
import model.Position;
import model.board.BoardExit;
import model.board.Item;
import model.board.ItemPath;
import model.board.UndestructibleWall;
import model.monster.Monster;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a PlayerState subclass that defines the current state.
 */
public class Player implements GameChar, Serializable{
	
	/** The board position. */
	private Position boardPosition;
	
	/**  The next board position. */
	private Position nextPlayerPosition;
	
	/** The Player draw position */
	private Position drawPlayerPosition;
	
	/** The state. */
	private PlayerState state;
	
	/** The numbers of available bombs. */
	private int availableBombs = 1;
	
	/** The Animation of the Item. */
	private int indexAnimArray = 0;
	
	private transient ArrayList<BufferedImage> animDown;
	private transient BufferedImage bm_down_0;
	private transient BufferedImage bm_down_1;
	private transient BufferedImage bm_down_2;
	
	private transient ArrayList<BufferedImage> animUp;
	private transient BufferedImage bm_up_0;
	private transient BufferedImage bm_up_1;
	private transient BufferedImage bm_up_2;
	
	private transient ArrayList<BufferedImage> animLeft;
	private transient BufferedImage bm_left_0;
	private transient BufferedImage bm_left_1;
	private transient BufferedImage bm_left_2;
	
	private transient ArrayList<BufferedImage> animRight;
	private transient BufferedImage bm_right_0;
	private transient BufferedImage bm_right_1;
	private transient BufferedImage bm_right_2;
	
	//============================================================================
	
	/**
	 * Instantiates a new player.
	 */
	public Player(){
		this.boardPosition = new Position();
		this.drawPlayerPosition = new Position();
		this.state = new PlayerAlive();
		
		this.animDown = new ArrayList<BufferedImage>();
		this.animUp = new ArrayList<BufferedImage>();
		this.animLeft = new ArrayList<BufferedImage>();
		this.animRight = new ArrayList<BufferedImage>();
		
		try 
		{
			bm_down_0 = ImageIO.read(new File("img/bm_down_0.png"));
			bm_down_1 = ImageIO.read(new File("img/bm_down_1.png"));
			bm_down_2 = ImageIO.read(new File("img/bm_down_2.png"));
			
			bm_up_0 = ImageIO.read(new File("img/bm_up_0.png"));
			bm_up_1 = ImageIO.read(new File("img/bm_up_1.png"));
			bm_up_2 = ImageIO.read(new File("img/bm_up_2.png"));
			
			bm_left_0 = ImageIO.read(new File("img/bm_left_0.png"));
			bm_left_1 = ImageIO.read(new File("img/bm_left_1.png"));
			bm_left_2 = ImageIO.read(new File("img/bm_left_2.png"));
			
			bm_right_0 = ImageIO.read(new File("img/bm_right_0.png"));
			bm_right_1 = ImageIO.read(new File("img/bm_right_1.png"));
			bm_right_2 = ImageIO.read(new File("img/bm_right_2.png"));
			
		} catch (IOException e) {}
		
		animDown.add(bm_down_0);
		animDown.add(bm_down_1);
		animDown.add(bm_down_2);
		
		animUp.add(bm_up_0);
		animUp.add(bm_up_1);
		animUp.add(bm_up_2);
		
		animLeft.add(bm_left_0);
		animLeft.add(bm_left_1);
		animLeft.add(bm_left_2);
		
		animRight.add(bm_right_0);
		animRight.add(bm_right_1);
		animRight.add(bm_right_2);
	}
	
	public void loadImgPlayer(){
		
		this.animDown = new ArrayList<BufferedImage>();
		this.animUp = new ArrayList<BufferedImage>();
		this.animLeft = new ArrayList<BufferedImage>();
		this.animRight = new ArrayList<BufferedImage>();
		
		try 
		{
			bm_down_0 = ImageIO.read(new File("img/bm_down_0.png"));
			bm_down_1 = ImageIO.read(new File("img/bm_down_1.png"));
			bm_down_2 = ImageIO.read(new File("img/bm_down_2.png"));
			
			bm_up_0 = ImageIO.read(new File("img/bm_up_0.png"));
			bm_up_1 = ImageIO.read(new File("img/bm_up_1.png"));
			bm_up_2 = ImageIO.read(new File("img/bm_up_2.png"));
			
			bm_left_0 = ImageIO.read(new File("img/bm_left_0.png"));
			bm_left_1 = ImageIO.read(new File("img/bm_left_1.png"));
			bm_left_2 = ImageIO.read(new File("img/bm_left_2.png"));
			
			bm_right_0 = ImageIO.read(new File("img/bm_right_0.png"));
			bm_right_1 = ImageIO.read(new File("img/bm_right_1.png"));
			bm_right_2 = ImageIO.read(new File("img/bm_right_2.png"));
			
		} catch (IOException e) {}

		animDown.add(bm_down_0);
		animDown.add(bm_down_1);
		animDown.add(bm_down_2);
		
		animUp.add(bm_up_0);
		animUp.add(bm_up_1);
		animUp.add(bm_up_2);
		
		animLeft.add(bm_left_0);
		animLeft.add(bm_left_1);
		animLeft.add(bm_left_2);
		
		animRight.add(bm_right_0);
		animRight.add(bm_right_1);
		animRight.add(bm_right_2);
	}
	
	/**
	 * Get board position.
	 *
	 * @return the board position
	 */
	public Position getBoardPosition(){
		return boardPosition;
	}
	
	public Position getNextBoardPosition(){
		return nextPlayerPosition;
	}
	
	public void updateDrawPosition(Position n_pos){
		this.drawPlayerPosition = n_pos;
	}
	
	/**
	 * Update board position.
	 *
	 * @param n_pos the n_pos
	 */
	public void updateBoardPosition(Position n_pos){
		this.boardPosition = n_pos;
	}
	
	/**
	 * Gets the current state.
	 *
	 * @return the current state
	 */
	public PlayerState getCurrentState(){
		return state;
	}
	
	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public void setCurrentState(PlayerState state){
		this.state = state;
	}
	
	/**
	 * Update.
	 */
	public void update(){
		nextPlayerPosition = GameModel.getInstance().getNextMov(this);
		GameModel.getInstance().getBoard().getItem(nextPlayerPosition).accept(this);
	}
	
	/**
	 * Drop bomb.
	 */
	public void dropBomb(){
		if(availableBombs != 0)
		{
			this.availableBombs--;
			GameModel.getInstance().getBoard().getItem(boardPosition).bombDropped(new Bomb(this));
		}
	}
	
	/**
	 * Returns available bombs.
	 *
	 * @return the int
	 */
	public int availableBombs(){
		return availableBombs;
	}
	
	/**
	 * Adds the bomb.
	 */
	public void addBomb(){
		this.availableBombs++;
	}
	
	/**
	 * Sets the animation.
	 *
	 * @param animation the new animation
	 */
	/*
	public void setAnimation(BufferedImage animation){
		this.bombermanImg = animation;
	}
	*/
	
	/**
	 * Checks player death.
	 *
	 * @param playerItem the player item
	 * @return true, if successful
	 */
	public boolean checkDeath(Item playerItem){
		//Checks explosion
		if(playerItem.isExploding())
		{
			setCurrentState(getCurrentState().die());
			return true;
		}

		//Checks collision with monsters
		for(Monster monster : GameModel.getInstance().getMonsters()){
			if(!monster.getCurrentState().isDead()){
				if(boardPosition.equals(monster.getBoardPosition())){
					collidesWith(monster);
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * Monster visits path item in game board.
	 *
	 * @param item the item
	 */
	public void visitPath(ItemPath item){
		updateBoardPosition(nextPlayerPosition);
		checkDeath(item);
	}
	
	/**
	 * Monster visits undestructible wall item in game board.
	 *
	 * @param item the item
	 */
	public void visitUndestructibleWall(UndestructibleWall item){}
	
	/**
	 * Monster visits board exit item in game board.
	 *
	 * @param item the item
	 */ 
	public void visitBoardExit(BoardExit item){
		updateBoardPosition(nextPlayerPosition);
		checkDeath(item);
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
	public void visit(Player vPlayer){}
	
	/**
	 * Visited by Monster.
	 *
	 * @param vMonster the v monster
	 */
	public void visit(Monster vMonster){
		setCurrentState(getCurrentState().die());
	}	

	/**
	 * Draw Player.
	 *
	 * @param g the g
	 * @param width the width
	 * @param height the height
	 */
	public void draw(Graphics g, int width, int height){
		
		int n = GameModel.getInstance().getBoard().getMaze().length;
		int dstImgWid = width / n;
		int dstImgHei = height / n;
		
		int linPixels = drawPlayerPosition.getLine() * dstImgHei;
		int colPixels = drawPlayerPosition.getCol() * dstImgWid;
		
		int linBPix = boardPosition.getLine() * dstImgHei;
		int colBPix = boardPosition.getCol() * dstImgWid;
		
		if(linBPix == linPixels && colBPix == colPixels)
		{
			g.drawImage(this.animDown.get(1), colPixels, linPixels, colPixels+dstImgWid, linPixels+dstImgHei, 0, 0, 25, 25, null);
			incAnimArray();
		}
		else if(colBPix != colPixels) 
		{
			if(colBPix > colPixels)
			{
				for(int i=0; i<dstImgWid; i++){
					g.drawImage(this.animRight.get(indexAnimArray), colPixels, linPixels, colPixels+dstImgWid, linPixels+dstImgHei, 0, 0, 25, 25, null);
					colPixels = colPixels + 1;				
					incAnimArray();
				}
			}
			else
			{
				for(int i=0; i<dstImgWid; i++){
					g.drawImage(this.animLeft.get(indexAnimArray), colPixels, linPixels, colPixels+dstImgWid, linPixels+dstImgHei, 0, 0, 25, 25, null);
					colPixels = colPixels - 1;				
					incAnimArray();
				}
			}
		}
		else if(linBPix != linPixels)
		{
			if(linBPix > linPixels)
			{
				for(int i=0; i<dstImgWid; i++){
					g.drawImage(this.animDown.get(indexAnimArray), colPixels, linPixels, colPixels+dstImgWid, linPixels+dstImgHei, 0, 0, 25, 25, null);
					linPixels = linPixels + 1;				
					incAnimArray();
				}
			}
			else
			{
				for(int i=0; i<dstImgWid; i++){
					g.drawImage(this.animUp.get(indexAnimArray), colPixels, linPixels, colPixels+dstImgWid, linPixels+dstImgHei, 0, 0, 25, 25, null);
					linPixels = linPixels - 1;				
					incAnimArray();
				}
			}
		}

		updateDrawPosition(boardPosition);		
	}
	
	public void incAnimArray(){
		indexAnimArray = (indexAnimArray + 1) % animDown.size();
	}

}

//end Player
