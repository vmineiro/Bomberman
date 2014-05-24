package model;

// TODO: Auto-generated Javadoc
/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a MonsterState subclass that defines the current state.
 * 
 */
public class Monster {

	/** The state. */
	private MonsterState state;
	
	/** The draw position. */
	private Position drawPosition;
	
	/** The board position. */
	private Position boardPosition;
	
	/** The speed. */
	private int speed; 
	
	/** The animation to be draw */
	//private Animation animation;
	
	/** The m_ monster state. */
	public MonsterState m_MonsterState;

	/**
	 * Instantiates a new monster.
	 */
	public Monster(){

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}
	
	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public void setCurrentState(MonsterState state){

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

	/**
	 * Sets the animation.
	 */
	public void setAnimation(/*Animation animation*/){

	}
}//end Monster