package model;

/**
 * This subclass implements a behaviour associated with a state of the Monster.
 */
public class MonsterDead extends MonsterState {

	public MonsterDead(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param monster
	 */
	public void die(Monster monster){

	}

	/**
	 * 
	 * @param monster
	 */
	public void update(Monster monster){

	}
}//end MonsterDead