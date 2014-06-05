package model.board;

import javax.swing.Timer;

public class ItemDetonating extends ItemState {



	/**
	 * Instantiates a new item detonating.
	 */
	public ItemDetonating(){
		super();
	
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable{
		super.finalize();
	}




	@Override
	public ItemState explode() {
		return new ItemDetonating();
	}




	@Override
	public ItemState pickUp() {
		return this;
	}



	@Override
	public ItemState explosionEnds() {
		return new ItemActive();
	}
	

}
