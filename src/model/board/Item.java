package model.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.Timer;

import model.Position;
import model.monster.Monster;
import model.player.Player;






// TODO: Auto-generated Javadoc
/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a ItemState subclass that defines the current state.
 */
public abstract class Item {
	
	
	HashMap<Class<? extends ItemState>, BufferedImage> itemImages;

	/** The state. */
	protected ItemState state;
	
	/** The Animation of the Item. */
	protected BufferedImage animation;
	
	/** The has player. */
	protected int monsterInThisItem = 0;

	
	/** The has bomb. */
	protected boolean hasBomb = false;

	
	
	/**
	 * Instantiates a new item.
	 */
	public Item(){}


	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}
	
	
	public ItemState getCurrentState(){	
		return this.state;
	}


	public boolean hasMonsters() {
		return monsterInThisItem > 0;
	}
	
	
	public boolean isDetonating() {
		return state.getClass() == ItemExploding.class;
	}
	
	
	public boolean isActive() {
		return state.getClass() == ItemActive.class;
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
	 * Explode
	 * 
	 */
	public void explode() {
		
		setCurrentState(state.explode());
		
		Timer countDown = new Timer(3000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrentState(state.explosionEnds());
			}
		});
		countDown.setRepeats(false);
		countDown.start();
		
		this.hasBomb = false;
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


	
	public void setAnimation(BufferedImage animation) {
		this.animation = animation;
	}

	
	public void setCurrentState(ItemState state) {
		this.state = state;
		setAnimation(itemImages.get(state));
	}

	
}//end Item