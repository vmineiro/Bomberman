package model.monster;

import model.GameModel;

// TODO: Auto-generated Javadoc
/**
 * This subclass implements a behaviour associated with a state of the Monster.
 */
public class MonsterAlive extends MonsterState {

	/**
	 * Instantiates a new monster alive.
	 */
	public MonsterAlive(){

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
		monster.setCurrentState(new MonsterDead());
	}

	/**
	 * Update.
	 *
	 * @param monster the monster
	 */
	public void update(Monster monster){
		
		// INCOMPLETE - Conditions for monster death
		die(monster);
		
		//INCOMPLETE - Create a GameModel Function for decrementing MonstersAlive
		GameModel.getInstance().getMonstersAlive();
	}
	
}//end MonsterAlive