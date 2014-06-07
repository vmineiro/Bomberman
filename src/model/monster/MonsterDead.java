package model.monster;

/**
 * This subclass implements a behaviour associated with a state of the Monster.
 */
public class MonsterDead implements MonsterState {

	/**
	 * Instantiates a new monster dead.
	 */
	public MonsterDead(){}
	
	/**
	 * Die.
	 *
	 * @param monster the monster
	 */
	public MonsterState die(){
		return this;
	}
	
	/**
	 * Replies monster health
	 * @return true if monster is dead
	 */
	public boolean isDead(){
		return true;
	}

}

//end MonsterDead