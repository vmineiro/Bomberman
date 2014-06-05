package model.player;

/**
 * This subclass implements a behaviour associated with a state of the PlayerStationary
 */
public class PlayerStationary implements PlayerState{
	
	/**
	 * Instantiates a new player down.
	 */
	public PlayerStationary(){}
	
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
	 * Turn stationary.
	 */
	public PlayerState turnStationary(){
		return this;
	}

	/**
	 * Die.
	 */
	public PlayerState die(){
		return new PlayerDead();
	}
}