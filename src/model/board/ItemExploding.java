package model.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.GameModel;



/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemExploding implements ItemState {
	
	/**
	 * Instantiates a new item detonating.
	 */
	public ItemExploding(){
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}

	
	@Override
	public ItemState explode() {
		// TODO Auto-generated method stub
		return new ItemExploding();
	}
	
	@Override
	public ItemState pickUp() {
		// TODO Auto-generated method stub
		return this;
	}


}//end ItemDetonating