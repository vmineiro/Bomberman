package model.board;

import model.monster.Monster;
import model.player.Player;


/**
 * The Class BombControl.
 */
public class BombControl extends Item {

	/**
	 * Instantiates a new bomb control.
	 */
	public BombControl(){

	}

	/* (non-Javadoc)
	 * @see model.Item#finalize()
	 */
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

		if (this.state.getClass() == ItemHidden.class || this.hasBomb) return;
		
		if (this.state.getClass() == ItemActive.class) {
			//TODO change method
			//player->updateBoardPosition(this)
			return;
		}

	}

	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	@Override
	public void accept(Monster monster){
		
		if (this.state.getClass() == ItemHidden.class) return;
		//TODO change method
		//monster->updateBoardPosition()


	}

	/**
	 * Sets the animation to be draw in the game window.
	 */
	@Override
	public void setAnimation(/*Animation animation*/){

	}
}//end BombControl