package model.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;


/**
 * The Class BombControl.
 */
public class BombControl extends Item {


	BufferedImage bombControlImg;

	/**
	 * Instantiates a new bomb control.
	 */
	public BombControl(){
		super();

		try {

			bombControlImg = ImageIO.read(new File("img/wall01.png"));

		} catch (IOException e) {

			e.printStackTrace();
		}

		setCurrentState(new ItemHidden());

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