package model.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
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
	

	
	/** The state. */
	protected ItemState state;
	
	/** The Animation of the Item. */
	protected BufferedImage animation;
	
	/** The has player. */
	protected int monsterInThisItem = 0;

	//TODO: Changed boolean to object type bomb
	/** The has bomb. */
	protected boolean hasBomb = false;
	
	
	BufferedImage wallImg;
	BufferedImage pathImg;
	BufferedImage explosionImg;

	
	
	/**
	 * Instantiates a new item.
	 */
	public Item(){
		
		try {
			wallImg = ImageIO.read(new File("img/wall01.png"));
			pathImg = ImageIO.read(new File("img/wall01.png"));
			explosionImg = ImageIO.read(new File("img/wall01.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


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
	
	
	public boolean isExploding() {
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
	
	
	//TODO: Receives a reference to the dropped bomb
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
		
		//TODO: change to null and detonate
		this.hasBomb = false;
	}
	
	
	public void setAnimation(BufferedImage animation) {
		this.animation = animation;
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

	
	public abstract void setCurrentState(ItemState state);

	
}//end Item