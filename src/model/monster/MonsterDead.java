package model.monster;

import java.io.Serializable;


/**
 * This subclass implements a behaviour associated with a state of the Monster.
 */
public class MonsterDead implements MonsterState, Serializable {

	/**
	 * Instantiates a new monster dead.
	 */
	public MonsterDead(){}
	
	/**
	 * Die.
	 *
	 * @return the monster state
	 */
	public MonsterState die(){
		return this;
	}
	
	/**
	 * Replies monster health.
	 *
	 * @return true if monster is dead
	 */
	public boolean isDead(){
		return true;
	}

}

//end MonsterDead