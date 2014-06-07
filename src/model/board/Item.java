package model.board;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import model.monster.Monster;
import model.player.Bomb;
import model.player.Player;


/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a ItemState subclass that defines the current state.
 */
public abstract class Item {
	
	private static final int EXPLOSION_DURATION = 3000;
	
	/** The state. */
	protected ItemState state;
	
	/** The Animation of the Item. */
	protected BufferedImage animation;

	/** The bomb in this item. */
	protected Bomb bomb;
	
	/** Timer to finish explosion */
	private Timer countDown;
	
	
	/** The wall image. */
	BufferedImage wallImg;
	
	/** The path image. */
	BufferedImage pathImg;
	
	/** The explosion image. */
	BufferedImage explosionImg;


	/**
	 * Instantiates a new item.
	 */
	public Item(){
		
		try {
			
			wallImg = ImageIO.read(new File("img/wall01.png"));
			pathImg = ImageIO.read(new File("img/wall01.png"));
			explosionImg = ImageIO.read(new File("img/wall01.png"));
			
		} catch (IOException e) {}
		
	}

	
	/**
	 * Gets the current state.
	 *
	 * @return the current state
	 */
	public ItemState getCurrentState(){	
		return this.state;
	}
	
	/**
	 * Checks if is this item exploding.
	 *
	 * @return true, if is exploding
	 */
	public boolean isExploding() {
		return state.getClass() == ItemExploding.class;
	}
	
	
	/**
	 * Checks if this item is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return state.getClass() == ItemActive.class;
	}		
	
	/**
	 * Bomb dropped in this item.
	 *
	 * @param bomb the bomb
	 */
	public void bombDropped(Bomb bomb){
		this.bomb = bomb;
	}
	
	
	/**
	 * Bomb dropped in this item.
	 *
	 * @param bomb the bomb
	 */
	public void bombExploded(){
		this.bomb = null;
		
	}

	
	
	/**
	 * Explode.
	 */
	public boolean explode() {

		boolean explosionContinue = true; 
		
		if (this.state.getClass() == ItemHidden.class ) 
			explosionContinue = false;
		
		if(this.state.getClass() == ItemInactive.class){
			explosionContinue = false;
		}
			
		setCurrentState(state.explode());
		
		ActionListener explodeListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrentState(state.explosionEnds());
				countDown.stop();
			}
		};

		countDown = new Timer(EXPLOSION_DURATION, explodeListener);
		countDown.setRepeats(false);
		countDown.start();

		this.bomb = null;
		
		return explosionContinue;
	}
	
	
	/**
	 * Sets the animation.
	 *
	 * @param animation the new animation
	 */
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

	
	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public abstract void setCurrentState(ItemState state);
	
	/**
	 * Draw game item
	 */
	public abstract void draw(Graphics g, int pos_l, int pos_c, int width, int height);
	
}//end Item