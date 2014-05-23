package model;

/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Player.
 */
public abstract class PlayerState {

	private Player player;
	private int drawRate;

	public PlayerState(){

	}

	public void finalize() throws Throwable {

	}
	public void move(){
		//player->updateBoardPosition


	}

	public void turnUp(){

	}

	public void turnLeft(){

	}

	public void turnDown(){

	}

	public void turnRight(){

	}

	public void die(){

	}

	public void respawn(){

	}

	public void update(){

	}

	/**
	 * 
	 * @param rate
	 */
	public void updateDrawRate(int rate){

	}
}//end PlayerState