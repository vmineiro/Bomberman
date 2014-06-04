package model.board;

import java.awt.image.BufferedImage;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class Path.
 */
public class Path extends Item {

	/**
	 * Instantiates a new path.
	 */
	public Path(){

	}

	/* (non-Javadoc)
	 * @see model.Item#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}


	/**
	 * Accept.
	 *
	 * @param player the player
	 */
	public void accept(Player player){
		
		if (this.getCurrentState().getClass() == ItemHidden.class) return;
		
		player.visitPath(this);


	}

	/**
	 * Accept.
	 *
	 * @param monster the monster
	 */
	public void accept(Monster monster){

		if (this.getCurrentState().getClass() == ItemHidden.class) return;
		
		monster.visitPath(this);
		
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
			
		this.setAnimation(GameModel.getInstance().getBoard().getAnimation("path"));
		
	}

	
	
}//end Path