package model.monster;

// TODO: Auto-generated Javadoc
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

}

//end MonsterState