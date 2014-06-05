package model.player;

// TODO: Auto-generated Javadoc
/**
 * This subclass implements a behaviour associated with a state of the PlayerAlive.
 */
public class PlayerUp implements PlayerState {

	/**
	 * Instantiates a new player up.
	 */
	public PlayerUp(){}
	
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

//end PlayerUp