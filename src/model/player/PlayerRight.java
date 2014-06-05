package model.player;

import model.Position;

/**
 * This subclass implements a behaviour associated with a state of the PlayerAlive.
 */
public class PlayerRight implements PlayerState {

	/**
	 * Instantiates a new player right.
	 */
	public PlayerRight(){}

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
		return this;
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
		return playerMoving.getBoardPosition().add(RIGHT);
	}
	
}

//end PlayerRight