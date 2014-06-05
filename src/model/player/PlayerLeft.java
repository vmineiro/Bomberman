package model.player;

import model.Position;

/**
 * This subclass implements a behaviour associated with a state of the PlayerAlive.
 */
public class PlayerLeft implements PlayerAlive {

	/**
	 * Instantiates a new player left.
	 */
	public PlayerLeft(){}

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
		return this;
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
		return playerMoving.getBoardPosition().add(LEFT);
	}
	
}

//end PlayerLeft