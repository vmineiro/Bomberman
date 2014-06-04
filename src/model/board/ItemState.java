package model.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Item.
 */
public abstract class ItemState {
	

	
	/**
	 * Explode. Trigger a state change.
	 *
	 * @param item the item
	 */
	public abstract ItemState explode();
	
	
	/**
	 * Explode. Trigger a state change.
	 *
	 * @param item the item
	 */
	public abstract ItemState explosionEnds();
	
	

	/**
	 * The item (power up item) is visited by the player. Trigger a state change.
	 * 
	 * @param item
	 */
	public abstract ItemState pickUp();


}//end ItemState