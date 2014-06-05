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
 * 
 */
public class BombPowerUp extends Item {
	
	
	public BombPowerUp(){
		super();
		
		try {
			
			BufferedImage wallImg = ImageIO.read(new File("img/wall01.png"));
			BufferedImage pathImg = ImageIO.read(new File("img/wall01.png"));
			BufferedImage bombPowerUpImg = ImageIO.read(new File("img/wall01.png"));
			BufferedImage explosionImg = ImageIO.read(new File("img/wall01.png"));
			
			itemImages = new HashMap<Class<? extends ItemState>, BufferedImage>();
			
			itemImages.put(ItemHidden.class, wallImg);
			itemImages.put(ItemDetonating.class, explosionImg);
			itemImages.put(ItemActive.class, bombPowerUpImg);
			itemImages.put(ItemExploding.class, explosionImg);
			itemImages.put(ItemInactive.class, pathImg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setCurrentState(new ItemHidden());
		
	}

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

		player.visitBombPowerUp(this);
		


	}

	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	@Override
	public void accept(Monster monster){
		
		monster.visitBombPowerUp(this);


	}

	
	
}//end BombPowerUp