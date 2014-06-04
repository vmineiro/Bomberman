package model.board;

import java.awt.image.BufferedImage;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;

/**
 *  The Extra Bomb class
 */
public class ExtraBomb extends Item {

	public ExtraBomb(){

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

		player.visitExtraBomb(this);


	}

	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	@Override
	public void accept(Monster monster){
		
		monster.visitExtraBomb(this);


	}

	@Override
	public void setAnimation(BufferedImage animation) {

		if (this.state.getClass() == ItemExploding.class){
			this.setAnimation(GameModel.getInstance().getBoard().getAnimation("explosion"));
			return;
		}

		if (this.state.getClass() == ItemHidden.class){
			this.setAnimation(GameModel.getInstance().getBoard().getAnimation("wall"));
			return;
		}

		if (this.state.getClass() == ItemActive.class){
			this.setAnimation(GameModel.getInstance().getBoard().getAnimation("extraBomb"));
			return;
		}


		this.setAnimation(GameModel.getInstance().getBoard().getAnimation("path"));

	}


}//end ExtraBomb