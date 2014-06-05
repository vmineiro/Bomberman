package model.player;

// TODO: Auto-generated Javadoc
/**
 * This subclass implements a behaviour associated with a state of the Player.
 */
public class PlayerDead implements PlayerState {

	/**
	 * Instantiates a new player dead.
	 */
	public PlayerDead(){}
	
	/**
	 * Turn up.
	 */
	public PlayerState turnUp(){
		return this;
	}

	/**
	 * Turn left.
	 */
	public PlayerState turnLeft(){
		return this;
	}

	/**
	 * Turn down.
	 */
	public PlayerState turnDown(){
		return this;
	}

	/**
	 * Turn right.
	 */
	public PlayerState turnRight(){
		return this;
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
		return this;
	}
	
}

//end PlayerDead