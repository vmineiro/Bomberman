package model.player;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import model.GameModel;
import model.Position;


/**
 * The Class Bomb.
 */
public class Bomb implements Serializable{

	// Bomb detonation timer
	/** The Constant TIME_TO_DETONATION. */
	public static final int TIME_TO_DETONATION = 1000;

	// Bomb propagation timer
	/** The Constant TIME_TO_PROPAGATION. */
	public static final int TIME_TO_PROPAGATION = 100;

	/**  The range of explosion. */
	private int range;

	/**  The range counter - UP. */
	private int range_counter_up;

	/**  The range counter - DOWN. */
	private int range_counter_down;

	/**  The range counter - LEFT. */
	private int range_counter_left;

	/**  The range counter - RIGHT. */
	private int range_counter_right;

	/**  The player who dropped the bomb. */
	private Player dropPlayer;

	/**  The board position where the bomb was dropped. */
	private Position boardPosition;

	/**  The bomb timer. */
	private Timer bombTimer;

	/**  The propagation timer. */
	private Timer proTimer;

	/**  The animation for the bomb. */
	private transient BufferedImage bombImg;

	//=======================================================

	/**
	 * Instantiates a new automatic bomb.
	 *
	 * @param dropPlayer the drop player
	 */
	public Bomb(Player dropPlayer){
		this.range = 3;
		this.range_counter_up = 0;
		this.range_counter_down = 0;
		this.range_counter_left = 0;
		this.range_counter_right = 0;
		this.dropPlayer = dropPlayer;
		this.boardPosition = dropPlayer.getBoardPosition();

		try 
		{
			bombImg = ImageIO.read(new File("img/bomb_1.png"));			
		} catch (IOException e) {}

		ActionListener bombTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				detonate();
				bombTimer.stop();
			}
		};

		bombTimer = new Timer(TIME_TO_DETONATION, bombTimerListener);	

		bombTimer.start();
	}

	/**
	 * Return bomb board position.
	 *
	 * @return the bomb pos
	 */
	public Position getBombPos(){
		return boardPosition;
	}

	/**
	 * This method trigger the explosion of the bomb and detonates the cell where the bomb 
	 * was dropped and the cells got in the bomb range. This object is destroyed.
	 * 
	 */
	public void detonate(){

		// First Explosion
		GameModel.getInstance().getBoard().getItem(boardPosition).explode();
		dropPlayer.addBomb();

		ActionListener proTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				propagateExplosion();
				if(bombPropagationIsOver()){
					proTimer.stop();
				}
			}
		};

		proTimer = new Timer(TIME_TO_PROPAGATION, proTimerListener);

		//Start Timer for next Explosion
		proTimer.start();

	}

	/**
	 * Verify if bomb propagation is over.
	 *
	 * @return true, if successful
	 */
	public boolean bombPropagationIsOver(){
		return (range_counter_up == range && range_counter_down == range && range_counter_left == range && range_counter_right == range);
	}

	/**
	 * Propagate bomb explosion.
	 */
	public void propagateExplosion(){

		if(range_counter_up != range)
		{
			if(!explodeItem(-range_counter_up, 0))
			{
				range_counter_up = range;
			}else{
				range_counter_up++;
			}
		}

		if(range_counter_down != range)
		{
			if(!explodeItem(range_counter_down, 0))
			{
				range_counter_down = range;
			}else{
				range_counter_down++;
			}

		}

		if(range_counter_left != range)
		{
			if(!explodeItem(0, range_counter_left))
			{
				range_counter_left = range;
			}else{
				range_counter_left++;
			}
		}

		if(range_counter_right != range)
		{
			if(!explodeItem(0, -range_counter_right))
			{
				range_counter_right = range;
			}else{
				range_counter_right++;
			}
		}
	}

	/**
	 * Explodes board item.
	 *
	 * @param incLine the inc line
	 * @param incCol the inc col
	 * @return true if explosion propagates
	 */
	public boolean explodeItem(int incLine, int incCol){
		Position explosionPos = new Position(boardPosition.getLine()+incLine, boardPosition.getCol()+incCol);
		
		if(GameModel.getInstance().getPlayers().getBoardPosition().equals(explosionPos)){
			GameModel.getInstance().getPlayers().setCurrentState(GameModel.getInstance().getPlayers().getCurrentState().die());
		}
		
		return GameModel.getInstance().getBoard().getItem(explosionPos).explode();
	}

	/**
	 * Draw.
	 * This method is called by GUI and is responsible for draw the bomb in the game window.
	 *
	 * @param g the g
	 * @param width the width
	 * @param height the height
	 */
	public void draw(Graphics g, int width, int height){
		int n = GameModel.getInstance().getBoard().getMaze().length;
		int dstImgWid = width / n;
		int dstImgHei = height / n;

		g.drawImage(this.bombImg, boardPosition.getCol()*dstImgWid, boardPosition.getLine()*dstImgHei, 
				(boardPosition.getCol()*dstImgWid)+dstImgWid, (boardPosition.getLine()*dstImgHei)+dstImgHei, 0, 0, 124, 114, null);
	}

	/**
	 * Return bomb image.
	 *
	 * @return bomb image
	 */
	public BufferedImage getImgBomb(){
		return bombImg;
	}

}

//end Bomb