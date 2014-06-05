package model.monster;

// TODO: Auto-generated Javadoc
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

}

//end MonsterDead