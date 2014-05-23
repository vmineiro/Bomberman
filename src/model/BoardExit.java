package model;

/**
 * 
 */
public class BoardExit extends Item {

	public BoardExit(){

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
}//end BoardExit