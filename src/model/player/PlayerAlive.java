package model.player;

public class PlayerAlive implements PlayerState{
	
	/**
	 * Die.
	 */
	public PlayerState die(){
		return new PlayerDead();
	}
}
