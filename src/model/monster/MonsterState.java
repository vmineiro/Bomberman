package model.monster;

/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Monster.
 */
public interface MonsterState {
	
	/**
	 * Die.
	 *
	 * @param monster the monster
	 */
	public abstract MonsterState die();
	
	/**
	 * Replies monster health
	 * @return true if monster is dead
	 */
	public abstract boolean isDead();

}

//end MonsterState