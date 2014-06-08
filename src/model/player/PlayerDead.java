package model.player;

import java.io.Serializable;


/**
 * This subclass implements a behaviour associated with a state of the Player.
 */
public class PlayerDead implements PlayerState, Serializable {

	/**
	 * Instantiates a new player dead.
	 */
	public PlayerDead(){}

	/**
	 * Die.
	 *
	 * @return the player state
	 */
	public PlayerState die(){
		return this;
	}	
	
	/**
	 * Check if player is dead.
	 *
	 * @return true, if is dead
	 */
	public boolean isDead(){
		return true;
	}
}

//end PlayerDead