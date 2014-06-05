package model.player;

// TODO: Auto-generated Javadoc
/**
 * This subclass implements a behaviour associated with a state of the Player.
 */
public class PlayerAlive implements PlayerState {

	/**
	 * Instantiates a new player alive.
	 */
	public PlayerAlive(){}
	
	/**
	 * Turn up.
	 */
	public PlayerState turnUp(){
		return new PlayerUp();
	}

	/**
	 * Turn left.
	 */
	public PlayerState turnLeft(){
		return new PlayerLeft();
	}

	/**
	 * Turn down.
	 */
	public PlayerState turnDown(){
		return new PlayerDown();
	}

	/**
	 * Turn right.
	 */
	public PlayerState turnRight(){
		return new PlayerRight();
	}

	/**
	 * Die.
	 */
	public PlayerState die(){
		return new PlayerDead();
	}

}

//end PlayerAlive