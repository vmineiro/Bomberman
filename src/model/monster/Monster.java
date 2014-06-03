package model.monster;

import model.Position;

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

	// =============================================================
	
	/**
	 * Instantiates a new monster.
	 */
	public Monster(){
		this.state = new MonsterAlive();
		this.boardPosition = new Position();
		this.drawPosition = new Position();
		this.speed = 1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {}
	
	/**
	 * Get Monster board position
	 */
	public Position getBoardPosition(){
		return boardPosition;
	}
	
	/**
	 * Set Monster board position
	 * 
	 * @param n_pos the new Monster board position
	 */
	public void setBoardPosition(Position n_pos){
		this.boardPosition = n_pos;
	}
	
	/**
	 * Gets the current state
	 */
	public MonsterState getCurrentState(){
		return state;
	}
	
	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public void setCurrentState(MonsterState state){
		this.state = state;
	}

	/**
	 * Draw.
	 */
	public void draw(){}

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