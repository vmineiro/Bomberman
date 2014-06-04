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
 *The Boost Speed class
 */
public class BoostSpeed extends Item {


	public BoostSpeed(){
		super();
		
		try {
			
			BufferedImage wallImg = ImageIO.read(new File("img/wall01.png"));
			BufferedImage pathImg = ImageIO.read(new File("img/wall01.png"));
			BufferedImage boostSpeedlImg = ImageIO.read(new File("img/wall01.png"));
			BufferedImage explosionImg = ImageIO.read(new File("img/wall01.png"));

			itemImages = new HashMap<Class<? extends ItemState>, BufferedImage>();
			
			itemImages.put(ItemHidden.class, wallImg);
			itemImages.put(ItemDetonating.class, explosionImg);
			itemImages.put(ItemActive.class, boostSpeedlImg);
			itemImages.put(ItemExploding.class, explosionImg);
			itemImages.put(ItemInactive.class, pathImg);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			
		player.visitBoostSpeed(this);
	}

	
	
	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	@Override
	public void accept(Monster monster){
		
		monster.visitBoostSpeed(this);
	}



}//end BoostSpeed