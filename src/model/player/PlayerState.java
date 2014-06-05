package model.player;

import model.Position;

/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Player.
 */
public interface PlayerState {
	
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