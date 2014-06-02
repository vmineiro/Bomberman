package model.player;

// TODO: Auto-generated Javadoc
/**
 * This subclass implements a behaviour associated with a state of the Player.
 */
public class PlayerDead extends PlayerState {

	/**
	 * Instantiates a new player dead.
	 */
	public PlayerDead(){

	}

	/* (non-Javadoc)
	 * @see model.PlayerState#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}
	
	/* (non-Javadoc)
	 * @see model.PlayerState#move()
	 */
	public void move(){
		//player->updateBoardPosition


	}

	/* (non-Javadoc)
	 * @see model.PlayerState#turnUp()
	 */
	public void turnUp(){

	}

	/* (non-Javadoc)
	 * @see model.PlayerState#turnLeft()
	 */
	public void turnLeft(){

	}

	/* (non-Javadoc)
	 * @see model.PlayerState#turnDown()
	 */
	public void turnDown(){

	}

	/* (non-Javadoc)
	 * @see model.PlayerState#turnRight()
	 */
	public void turnRight(){

	}

	/* (non-Javadoc)
	 * @see model.PlayerState#die()
	 */
	public void die(){

	}

	/* (non-Javadoc)
	 * @see model.PlayerState#respawn()
	 */
	public void respawn(){

	}

	/* (non-Javadoc)
	 * @see model.PlayerState#update()
	 */
	public void update(){

	}

	/**
	 * Update draw rate.
	 *
	 * @param rate the rate
	 */
	public void updateDrawRate(int rate){

	}
}//end PlayerDead