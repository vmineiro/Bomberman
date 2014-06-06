package model.player;

import model.Position;

/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Player.
 */
public interface PlayerState {
	
	/**
	 * Die.
	 */
	public abstract PlayerState die();

}

//end PlayerState