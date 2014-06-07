package model.player;

/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Player.
 */
public interface PlayerState {
	
	/**
	 * Die.
	 */
	public abstract PlayerState die();
	
	/**
	 * Check if player is dead
	 */
	public abstract boolean isDead();

}

//end PlayerState