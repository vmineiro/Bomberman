package model.player;

import model.Position;
import model.board.Item;


/**
 * The Class ManualBomb.
 */
public class ManualBomb implements Bomb {
	
	/** The range of explosion */
	private int range;
	
	/** The range counter */
	private int range_counter;
	
	/** The board position where the bomb was dropped */
	private Position boardPosition;
	
	/** The animation for the bomb */
	//private Animation animation;
	
	//====================================================
	
	/**
	 * Instantiates a new manual bomb.
	 */
	public ManualBomb(Position dropPos){
		range = 3;
		boardPosition = dropPos;
	}
	
	/**
	 * This method trigger the explosion of the bomb and detonates the cell where the bomb 
	 * was dropped and the cells got in the bomb range. This object is destroyed.
	 * 
	 */
	public void detonate(){}
	
	/**
	 * Propagate bomb explosion
	 */
	public void propagateExplosion(Position initPos, int range_counter){}

	/**
	 * Draw.
	 * This method is called by GUI and is responsible for draw the bomb in the game window.
	 * 
	 */
	public void draw(){}
	
}

//end ManualBomb