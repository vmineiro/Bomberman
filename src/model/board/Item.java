package model.board;

import model.Position;
import model.monster.Monster;
import model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a ItemState subclass that defines the current state.
 */
public abstract class Item {

	/** The state. */
	protected ItemState state;
	
	/** The Animation of the Item. */
	//private Animation animation;
	
	/** The has player. */
	protected int monsterInThisItem = 0;
	
	/** The has monster alive. */
	protected boolean hasMonsterAlive = false;
	
	/** The has bomb. */
	protected boolean hasBomb = false;

	/**
	 * Instantiates a new item.
	 */
	public Item(){

	}


	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}


	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public void setCurrentState(ItemState state){	
		this.state = state;
	}
	
	
	public ItemState getCurrentState(){	
		return this.state;
	}


	public int getMonsterInThisItem() {
		return monsterInThisItem;
	}
	
	
	public void monsterIn() {
		monsterInThisItem++;
	}
	
	
	public void monsterOut() {
		monsterInThisItem--;
	}
	
	
	
	public void bombDropped(){
		this.hasBomb = true;
	}
	
	
	/**
	 * Manages the visit by the player.
	 *
	 * @param player the player
	 */
	public abstract void accept(Player player);


	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	public abstract void accept(Monster monster);


	/**
	 * Sets the animation to be draw in the game window.
	 */
	public abstract void setAnimation(/*Animation animation*/);
	
	/**
	 * Explode
	 * 
	 */
	public void explode() {
		this.state.explode(this);
		this.hasBomb = false;
	}
	
	
}//end Item