package model;

// TODO: Auto-generated Javadoc
/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Player.
 */
public abstract class PlayerState {

	/** The player. */
	private Player player;
	
	/** The draw rate. */
	private int drawRate;

	/**
	 * Instantiates a new player state.
	 */
	public PlayerState(){

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}
	
	/**
	 * Move.
	 */
	public void move(){
		//player->updateBoardPosition


	}

	/**
	 * Turn up.
	 */
	public void turnUp(){

	}

	/**
	 * Turn left.
	 */
	public void turnLeft(){

	}

	/**
	 * Turn down.
	 */
	public void turnDown(){

	}

	/**
	 * Turn right.
	 */
	public void turnRight(){

	}

	/**
	 * Die.
	 */
	public void die(){

	}

	/**
	 * Respawn.
	 */
	public void respawn(){

	}

	/**
	 * Update.
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
}//end PlayerState