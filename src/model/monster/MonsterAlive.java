package model.monster;

import model.GameModel;
import java.io.Serializable;

/**
 * This subclass implements a behaviour associated with a state of the Monster.
 */
public class MonsterAlive implements MonsterState, Serializable {

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
	
	/**
	 * Replies monster health
	 * @return true if monster is dead
	 */
	public boolean isDead(){
		return false;
	}
	
}//end MonsterAlive