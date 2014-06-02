package model.board;

import model.monster.Monster;
import model.player.Player;


/**
 * 
 */
public class BombPowerUp extends Item {

	public BombPowerUp(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	@Override
	public void setCurrentState(ItemState state){

	}

	/**
	 * Manages the visit by the player.
	 *
	 * @param player the player
	 */
	@Override
	public void accept(Player player){
		//player->updateBoardPosition()


	}

	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	@Override
	public void accept(Monster monster){
		//monster->updateBoardPosition()


	}

	/**
	 * Sets the animation to be draw in the game window.
	 */
	@Override
	public void setAnimation(/*Animation animation*/){

	}
}//end BombPowerUp