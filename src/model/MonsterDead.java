package model;

// TODO: Auto-generated Javadoc
/**
 * This subclass implements a behaviour associated with a state of the Monster.
 */
public class MonsterDead extends MonsterState {

	/**
	 * Instantiates a new monster dead.
	 */
	public MonsterDead(){

	}

	/* (non-Javadoc)
	 * @see model.MonsterState#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
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
}//end MonsterDead