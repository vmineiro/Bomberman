package model.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.monster.Monster;
import model.player.Player;


/**
 *  The Extra Bomb class.
 */
public class ExtraBomb extends Item {


	
	/** The extra bomb image. */
	BufferedImage extraBombImg;


	/**
	 * Instantiates a new extra bomb.
	 */
	public ExtraBomb(){
		super();
		
		try {
			
			extraBombImg = ImageIO.read(new File("img/wall01.png"));

			setCurrentState(new ItemHidden());

			
		} catch (IOException e) {}
		
		
		
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

		player.visitExtraBomb(this);


	}

	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	@Override
	public void accept(Monster monster){
		
		if (this.state.getClass() == ItemHidden.class || this.bomb != null) return;
		
		monster.visitExtraBomb(this);

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
			setAnimation(extraBombImg);
		}
		
	}


}//end ExtraBomb