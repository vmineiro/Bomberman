package model.monster;

// TODO: Auto-generated Javadoc
/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Monster.
 */
public abstract class MonsterState {

	/**
	 * Instantiates a new monster state.
	 */
	public MonsterState(){

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}
	
	/**
	 * Die.
	 *
	 * @param monster the monster
	 */
	public void die(Monster monster){

	}

	/**
	 * Update.
	 *
	 * @param monster the monster
	 */
	public void update(Monster monster){

	}
}//end MonsterState