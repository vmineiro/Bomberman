package model;

/**
 * 
 */
public class Path extends Item {

	public Path(){

	}

	public void finalize() throws Throwable {
		super.finalize();
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
	 * @return 
	 */
	public void accept(Player player){
		//player->updateBoardPosition()


	}

	/**
	 * 
	 * @param monster
	 * @return 
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
}//end Path