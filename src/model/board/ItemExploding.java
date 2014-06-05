package model.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.GameModel;



/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemExploding extends ItemState {
	
	
	/**
	 * Instantiates a new item detonating.
	 */
	public ItemExploding(){
		super();
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}

	
	@Override
	public ItemState explode() {
		return new ItemExploding();
	}
	
	@Override
	public ItemState pickUp() {
		return this;
	}

	@Override
	public ItemState explosionEnds() {
		return new ItemInactive();
	}


}//end ItemDetonating