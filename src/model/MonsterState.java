package model;

/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Monster.
 */
public abstract class MonsterState {

	public MonsterState(){

	}

	public void finalize() throws Throwable {

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
}//end MonsterState