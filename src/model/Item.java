package model;

/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a ItemState subclass that defines the current state.
 */
public class Item {

	private ItemState state;
	private Position drawPosition;
	private Position boardPosition;
	//private Animation animation;
	private boolean hasPlayer;
	private boolean hasMonsterAlive;
	private boolean hasBomb;

	public Item(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param state
	 */
	public void setCurrentState(ItemState state){

	}

	/**
	 * 
	 * @param player
	 */
	public void accept(Player player){
		//player->updateBoardPosition()


	}

	/**
	 * 
	 * @param monster
	 */
	public void accept(Monster monster){
		//monster->updateBoardPosition()


	}

	/**
	 * 
	 * @param animation
	 */
	public void setAnimation(/*Animation animation*/){

	}
}//end Item