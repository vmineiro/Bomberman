package model;

/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a PlayerState subclass that defines the current state.
 */
public class Player {

	private int score = 0;
	private int lives = 3;
	private int speed;
	private Position boardPosition;
	private Position drawPosition;
	private PlayerState state;
	//private Animation animation;
	private boolean manualBomb = false;
	private int bombPower = 1;
	private int nBombs = 1;
	private boolean imortal = true;
	public Bomb m_Bomb;

	public Player(){

	}

	public void finalize() throws Throwable {

	}
	public void dropBomb(){
		//new Bomb()


	}

	/**
	 * 
	 * @param bomb
	 */
	public void detonateBomb(Bomb bomb){

	}

	public void increaseSpeed(){

	}

	public void increasePowerBomb(){

	}

	public void lifeLost(){

	}

	public void addBomb(){

	}

	public void updateBoardPosition(){

	}

	public void respawn(){

	}

	/**
	 * 
	 * @param state
	 */
	public void setCurrentState(PlayerState state){

	}

	public void setAnimation(){

	}

	public void draw(){

	}

	public void update(){

	}

}//end Player