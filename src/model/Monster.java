package model;

/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a MonsterState subclass that defines the current state.
 * 
 */
public class Monster {

	private MonsterState state;
	private Position drawPosition;
	private Position boardPosition;
	private int speed;
	//private Animation animation;
	public MonsterState m_MonsterState;

	public Monster(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param state
	 */
	public void setCurrentState(MonsterState state){

	}

	public void draw(){

	}

	public void update(){

	}

	/**
	 * 
	 * @param animation
	 */
	public void setAnimation(/*Animation animation*/){

	}
}//end Monster