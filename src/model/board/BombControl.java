package model.board;

import java.awt.image.BufferedImage;

import model.GameModel;
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
	 * Manages the visit by the player.
	 *
	 * @param player the player
	 */
	@Override
	public void accept(Player player){

		if (this.state.getClass() == ItemHidden.class || this.hasBomb) return;
				
		setCurrentState(this.state.pickUp());

		player.visitBombControl(this);

	}

	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	@Override
	public void accept(Monster monster){
		
		if (this.state.getClass() == ItemHidden.class) return;

		monster.visitBombControl(this);

	}

	/**
	 * Sets the animation to be draw in the game window.
	 */
	@Override
	public void setAnimation(BufferedImage animation){

		
		if (this.state.getClass() == ItemExploding.class){
			this.setAnimation(GameModel.getInstance().getBoard().getAnimation("explosion"));
			return;
		}
		
		if (this.state.getClass() == ItemHidden.class){
			this.setAnimation(GameModel.getInstance().getBoard().getAnimation("wall"));
			return;
		}
		
		if (this.state.getClass() == ItemActive.class){
			this.setAnimation(GameModel.getInstance().getBoard().getAnimation("bombControl"));
			return;
		}
		
			
		this.setAnimation(GameModel.getInstance().getBoard().getAnimation("path"));
	}
}//end BombControl