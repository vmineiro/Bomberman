package model.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.GameModel;



/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemDetonating extends ItemState {
	
	/** */
	private Timer countDown;
	
	/** The count down for detonation end. */
	private int timeOut = 3000;

	/**
	 * Instantiates a new item detonating.
	 */
	public ItemDetonating(final Item item){


		countDown = new Timer(timeOut, new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent arg0) {
				  
				  if (item.getClass() == BoardExit.class){
					  if (GameModel.getInstance().getMonstersAlive() == 0) {
						  item.setCurrentState(new ItemActive());
					  } else {
						  item.setCurrentState(new ItemInactive());
					  }
				  }
				 
			  }
			});
		countDown.setRepeats(false); // Only execute once
		countDown.start();
		


		
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
	public void explode(Item item){

	}

	/**
	 * The item (power up item) is visited by the player. Trigger a state change.
	 * 
	 * @param item
	 */
	public void pickUp(Item item){

	}

	/**
	 * Change the BoardExit item to Active.
	 * 
	 * @param item
	 */
	public void openExit(Item item){

	}

	/**
	 * Updates the state of the item. Applies to ItemDetonating.
	 */
	public void update(){

	}
}//end ItemDetonating