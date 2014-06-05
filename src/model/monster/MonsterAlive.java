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