package model.monster;

import model.GameModel;

// TODO: Auto-generated Javadoc
/**
 * This subclass implements a behaviour associated with a state of the Monster.
 */
public class MonsterAlive implements MonsterState {

	/**
	 * Instantiates a new monster alive.
	 */
	public MonsterAlive(){}

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
	public MonsterState die(){
		GameModel.getInstance().decMonstersAlive();
		return new MonsterDead();
	}
	
}//end MonsterAlive