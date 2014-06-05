package model.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class Path.
 */
public class ItemPath extends Item {
	
	/**
	 * Instantiates a new path.
	 */
	public ItemPath(){
		
		super();

		try {
			
			BufferedImage wallImg = ImageIO.read(new File("img/wall01.png"));
			BufferedImage pathImg = ImageIO.read(new File("img/wall01.png"));
			BufferedImage explosionImg = ImageIO.read(new File("img/wall01.png"));
			
			itemImages = new HashMap<Class<? extends ItemState>, BufferedImage>();
			
			itemImages.put(ItemHidden.class, wallImg);
			itemImages.put(ItemDetonating.class, explosionImg);
			itemImages.put(ItemActive.class, pathImg);
			itemImages.put(ItemExploding.class, explosionImg);
			itemImages.put(ItemInactive.class, pathImg);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
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
		
		if (this.state.getClass() == ItemHidden.class) return;
		
		player.visitPath(this);


	}

	/**
	 * Accept.
	 *
	 * @param monster the monster
	 */
	public void accept(Monster monster){

		if (this.state.getClass() == ItemHidden.class) return;
		
		monster.visitPath(this);
		
	}

	
	
}//end Path