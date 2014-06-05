package model.player;

import model.Position;

/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Player.
 */
public interface PlayerState {

	//Player Movement Increments
	public static final Position UP = new Position(-1,0);
	public static final Position DOWN = new Position(1,0);
	public static final Position LEFT = new Position(0,-1);
	public static final Position RIGHT = new Position(0,1);
	
	/**
	 * Turn up.
	 */
	public abstract PlayerState turnUp();

	/**
	 * Turn left.
	 */
	public abstract PlayerState turnLeft();

	/**
	 * Turn down.
	 */
	public abstract PlayerState turnDown();

	/**
	 * Turn right.
	 */
	public abstract PlayerState turnRight();
	
	/**
	 * Turn stationary.
	 */
	public abstract PlayerState turnStationary();

	/**
	 * Die.
	 */
	public abstract PlayerState die();
	
	/**
	 * Generate player next movement
	 * 
	 * @param player moving
	 * @return newPosPlayer
	 */
	public abstract Position generateNextMov(Player playerMoving);

}

//end PlayerState