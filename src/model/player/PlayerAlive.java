package model.player;

import java.io.Serializable;


/**
 * The Class PlayerAlive.
 */
public class PlayerAlive implements PlayerState, Serializable{
	
	/**
	 * Instantiates a new player dead.
	 */
	public PlayerAlive(){}
	
	/**
	 * Die.
	 *
	 * @return the player state
	 */
	public PlayerState die(){
		return new PlayerDead();
	}
	
	/**
	 * Check if player is dead.
	 *
	 * @return true, if is dead
	 */
	public boolean isDead(){
		return false;
	}
}
