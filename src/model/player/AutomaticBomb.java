package model.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.GameModel;
import model.Position;


/**
 * The Class AutomaticBomb.
 */
public class AutomaticBomb implements Bomb {
	
	/** The range of explosion */
	private int range;
	
	/** The range counter - UP */
	private int range_counter_up;
	
	/** The range counter - DOWN */
	private int range_counter_down;
	
	/** The range counter - LEFT */
	private int range_counter_left;
	
	/** The range counter - RIGHT */
	private int range_counter_right;
	
	/** The player who dropped the bomb */
	private Player dropPlayer;
	
	/** The board position where the bomb was dropped */
	private Position boardPosition;
	
	/** The bomb timer */
	private Timer bombTimer;
	
	/** The propagation timer */
	private Timer proTimer;
	
	/** The animation for the bomb */
	//private Animation animation;
	
	//=======================================================

	/**
	 * Instantiates a new automatic bomb.
	 */
	public AutomaticBomb(Player dropPlayer){
		this.range = 3;
		this.range_counter_up = 0;
		this.range_counter_down = 0;
		this.range_counter_left = 0;
		this.range_counter_right = 0;
		this.dropPlayer = dropPlayer;
		this.boardPosition = dropPlayer.getBoardPosition();
		
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
	 * This method trigger the explosion of the bomb and detonates the cell where the bomb 
	 * was dropped and the cells got in the bomb range. This object is destroyed.
	 * 
	 */
	public void detonate(){
		
		// First Explosion
		GameModel.getInstance().getBoard().getItem(boardPosition).explode();
		
		//TODO: Removed bomb from item
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
	 * Verify if bomb propagation is over
	 */
	public boolean bombPropagationIsOver(){
		return (range_counter_up == range && range_counter_down == range && range_counter_left == range && range_counter_right == range);
	}
	
	/**
	 * Propagate bomb explosion
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
	 * Explodes board item
	 * 
	 * @param incLine
	 * @param incCol
	 * @return true if explosion propagates
	 */
	public boolean explodeItem(int incLine, int incCol){
		return GameModel.getInstance().getBoard().getItem(new Position(boardPosition.getLine()+incLine, boardPosition.getCol()+incCol)).explode();
	}

	/**
	 * Draw.
	 * This method is called by GUI and is responsible for draw the bomb in the game window.
	 * 
	 */
	public void draw(){}	

}//end AutomaticBomb