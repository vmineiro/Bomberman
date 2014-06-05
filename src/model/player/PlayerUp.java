package model.player;

import model.Position;

// TODO: Auto-generated Javadoc
/**
 * This subclass implements a behaviour associated with a state of the PlayerAlive.
 */
public class PlayerUp implements PlayerAlive {

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
	 * Turn stationary.
	 */
	public PlayerState turnStationary(){
		return new PlayerStationary();
	}

	/**
	 * Die.
	 */
	public PlayerState die(){
		return new PlayerDead();
	}
	
	/**
	 * Generate player next movement
	 * 
	 * @param player moving
	 * @return newPosPlayer
	 */
	public Position generateNextMov(Player playerMoving){
		return playerMoving.getBoardPosition().add(UP);
	}
	
}

//end PlayerUp