package model.player;

// TODO: Auto-generated Javadoc
/**
 * This subclass implements a behaviour associated with a state of the Player.
 */
public interface PlayerAlive extends PlayerState {
	
	/**
	 * Turn up.
	 */
	public PlayerState turnUp();

	/**
	 * Turn left.
	 */
	public PlayerState turnLeft();

	/**
	 * Turn down.
	 */
	public PlayerState turnDown();

	/**
	 * Turn right.
	 */
	public PlayerState turnRight();

	/**
	 * Die.
	 */
	public PlayerState die();

}

//end PlayerAlive