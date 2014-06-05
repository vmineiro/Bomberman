package model.board;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemActive extends ItemState {

	
	public ItemActive(){
		super();

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}
	
	/**
	 * Explode. Trigger a state change.
	 *
	 * @param item the item
	 */
	public ItemState explode(){
		return new ItemExploding();
	}

	@Override
	public ItemState pickUp() {
		return new ItemInactive();
	}

	@Override
	public ItemState explosionEnds() {
		return this;
	}
}//end ItemActive