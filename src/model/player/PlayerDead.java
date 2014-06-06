package model.player;

/**
 * This subclass implements a behaviour associated with a state of the Player.
 */
public class PlayerDead implements PlayerState {

	/**
	 * Instantiates a new player dead.
	 */
	public PlayerDead(){}

	/**
	 * Die.
	 */
	public PlayerState die(){
		return this;
	}	
}

//end PlayerDead