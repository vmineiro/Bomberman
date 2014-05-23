package model;

/**
 * 
 */
public class UndestructibleWall extends Item {

	public UndestructibleWall(){

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
}//end UndestructibleWall