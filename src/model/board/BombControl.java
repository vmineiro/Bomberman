package model.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.monster.Monster;
import model.player.Player;



/**
 * The Class BombControl.
 */
public class BombControl extends Item {


	
	/** The bomb control image. */
	BufferedImage bombControlImg;

	
	/**
	 * Instantiates a new bomb control.
	 */
	public BombControl(){
		super();

		try {

			bombControlImg = ImageIO.read(new File("img/wall01.png"));

			setCurrentState(new ItemHidden());

		} catch (IOException e) {

			e.printStackTrace();
		}

		
	}



	/**
	 * Manages the visit by the player.
	 *
	 * @param player the player
	 */
	@Override
	public void accept(Player player){

		if (this.state.getClass() == ItemHidden.class || this.bomb != null) return;

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

	
	/* (non-Javadoc)
	 * @see model.board.Item#setCurrentState(model.board.ItemState)
	 */
	@Override
	public void setCurrentState(ItemState state) {

		this.state = state;

		if (this.state.getClass() == ItemHidden.class) {
			setAnimation(wallImg);
		} else if (this.state.getClass() == ItemDetonating.class || this.state.getClass() == ItemExploding.class) {
			setAnimation(explosionImg);
		} else {
			setAnimation(bombControlImg);
		}

	}


}//end BombControl