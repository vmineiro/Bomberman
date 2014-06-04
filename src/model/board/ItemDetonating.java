package model.board;

import javax.swing.Timer;

public class ItemDetonating implements ItemState {

	
	/** */
	private Timer countDown;
	
	/** The count down for detonation end. */
	private int timeOut = 3000;

	/**
	 * Instantiates a new item detonating.
	 */
	public ItemDetonating(){
		
		


//		countDown = new Timer(timeOut, new ActionListener() {
//			  @Override
//			  public void actionPerformed(ActionEvent arg0) {
//				  
//				  if (item.getClass() == BoardExit.class){
//					  if (GameModel.getInstance().getMonstersAlive() == 0) {
//						  item.setCurrentState(new ItemActive());
//					  } else {
//						  item.setCurrentState(new ItemInactive());
//					  }
//				  }
//				 
//			  }
//			});
//		countDown.setRepeats(false); // Only execute once
//		countDown.start();
	
	}

	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable{
		super.finalize();
	}




	@Override
	public ItemState explode() {
		// TODO Auto-generated method stub
		return new ItemDetonating();
	}




	@Override
	public ItemState pickUp() {
		// TODO Auto-generated method stub
		return this;
	}
	

}
