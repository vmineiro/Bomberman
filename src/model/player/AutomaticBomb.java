package model.player;

import model.board.Item;


/**
 * The Class AutomaticBomb.
 */
public class AutomaticBomb implements Bomb {
	
	/** The range of explosion */
	private int range;
	
	/** The cell where the bomb was dropped */
	private Item cell;
	
	/** The animation for the bomb */
	//private Animation animation;

	/** The time out. */
	private int timeOut = 5;
	
	//=======================================================

	/**
	 * Instantiates a new automatic bomb.
	 */
	public AutomaticBomb(){}
	
	/**
	 * This method trigger the explosion of the bomb and detonates the cell where the bomb 
	 * was dropped and the cells got in the bomb range. This object is destroyed.
	 * 
	 */
	public void detonate(){}

	/**
	 * Draw.
	 * This method is called by GUI and is responsible for draw the bomb in the game window.
	 * 
	 */
	public void draw(){}
	
	/**
	 * Update.
	 * This method is called by game loop and is responsible for update the count down for explosion.
	 * When timeOut == 0 detonates the bomb.
	 * 
	 */
	public void update(){}
	

}//end AutomaticBomb