package model;

// TODO: Auto-generated Javadoc
/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a PlayerState subclass that defines the current state.
 */
public class Player {

	/** The score. */
	private int score = 0;
	
	/** The lives. */
	private int lives = 3;
	
	/** The speed. */
	private int speed;
	
	/** The board position. */
	private Position boardPosition;
	
	/** The draw position. */
	private Position drawPosition;
	
	/** The state. */
	private PlayerState state;
	
	/** The animation. */
	//private Animation animation;
	
	/** The manual bomb. */
	private boolean manualBomb = false;
	
	/** The bomb power. */
	private int bombPower = 1;
	
	/** The n bombs. */
	private int nBombs = 1;
	
	/** The imortal. */
	private boolean imortal = true;
	
	/** The m_ bomb. */
	public Bomb m_Bomb;

	/**
	 * Instantiates a new player.
	 */
	public Player(){

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}
	
	/**
	 * Drop bomb.
	 */
	public void dropBomb(){
		//new Bomb()


	}

	/**
	 * Detonate bomb.
	 *
	 * @param bomb the bomb
	 */
	public void detonateBomb(Bomb bomb){

	}

	/**
	 * Increase speed.
	 */
	public void increaseSpeed(){

	}

	/**
	 * Increase power bomb.
	 */
	public void increasePowerBomb(){

	}

	/**
	 * Life lost.
	 */
	public void lifeLost(){

	}

	/**
	 * Adds the bomb.
	 */
	public void addBomb(){

	}

	/**
	 * Update board position.
	 */
	public void updateBoardPosition(){

	}

	/**
	 * Respawn. Set the player in start position.
	 */
	public void respawn(){
		 // if the player died should reset his power ups.

	}

	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public void setCurrentState(PlayerState state){

	}

	/**
	 * Sets the animation.
	 */
	public void setAnimation(){

	}

	/**
	 * Draw.
	 */
	public void draw(){

	}

	/**
	 * Update.
	 */
	public void update(){

	}

}//end Player