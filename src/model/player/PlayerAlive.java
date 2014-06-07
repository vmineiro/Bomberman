package model.player;

import java.io.Serializable;

public class PlayerAlive implements PlayerState, Serializable{
	
	/**
	 * Instantiates a new player dead.
	 */
	public PlayerAlive(){}
	
	/**
	 * Die.
	 */
	public PlayerState die(){
		return new PlayerDead();
	}
	
	/**
	 * Check if player is dead
	 */
	public boolean isDead(){
		return false;
	}
}
