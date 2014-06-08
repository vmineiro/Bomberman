package model.player;


/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Player.
 */
public interface PlayerState {
	
	/**
	 * Die.
	 *
	 * @return the player state
	 */
	public abstract PlayerState die();
	
	/**
	 * Check if player is dead.
	 *
	 * @return true, if is dead
	 */
	public abstract boolean isDead();

}

//end PlayerState