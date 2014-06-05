package model.player;

import model.board.Item;


/**
 * The Class Bomb.
 */
public interface Bomb {
	
	/**
	 * This method trigger the explosion of the bomb and detonates the cell where the bomb 
	 * was dropped and the cells got in the bomb range. This object is destroyed.
	 * 
	 */
	public abstract void detonate();

	/**
	 * Draw.
	 * This method is called by GUI and is responsible for draw the bomb in the game window.
	 * 
	 */
	public abstract void draw();

}//end Bomb