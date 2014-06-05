package model.player;

import model.Position;

/**
 * The Class Bomb.
 */
public interface Bomb {
	
	// Bomb detonation timer
	public static final int TIME_TO_DETONATION = 3000;
	
	// Bomb propagation timer
	public static final int TIME_TO_PROPAGATION = 500;
	
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