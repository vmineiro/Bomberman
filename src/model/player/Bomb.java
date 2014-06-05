package model.player;

import model.Position;
import model.board.Item;


/**
 * The Class Bomb.
 */
public interface Bomb {

	//Random Monster Movement
	public static final Position UP = new Position(-1,0);
	public static final Position DOWN = new Position(1,0);
	public static final Position LEFT = new Position(0,-1);
	public static final Position RIGHT = new Position(0,1);
	
	/**
	 * This method trigger the explosion of the bomb and detonates the cell where the bomb 
	 * was dropped and the cells got in the bomb range. This object is destroyed.
	 * 
	 */
	public abstract void detonate();
	
	/**
	 * Propagate bomb explosion
	 */
	public void propagateExplosion(Position initPos, int range_counter);

	/**
	 * Draw.
	 * This method is called by GUI and is responsible for draw the bomb in the game window.
	 * 
	 */
	public abstract void draw();

}//end Bomb