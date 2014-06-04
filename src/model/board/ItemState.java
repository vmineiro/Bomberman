package model.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Item.
 */
public interface ItemState {
	

	
	/**
	 * Explode. Trigger a state change.
	 *
	 * @param item the item
	 */
	public ItemState explode();

	/**
	 * The item (power up item) is visited by the player. Trigger a state change.
	 * 
	 * @param item
	 */
	public ItemState pickUp();


}//end ItemState