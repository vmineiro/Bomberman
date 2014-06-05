package model.player;

// TODO: Auto-generated Javadoc
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

}

//end PlayerState