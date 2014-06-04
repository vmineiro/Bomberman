package model.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class Path.
 */
public class Path extends Item {

	BufferedImage wallImg;
	BufferedImage pathImg;
	BufferedImage explosionImg;
	
	
	
	/**
	 * Instantiates a new path.
	 */
	public Path(){

		try {
			
			wallImg = ImageIO.read(new File("img/wall01.png"));
			pathImg = ImageIO.read(new File("img/wall01.png"));
			explosionImg = ImageIO.read(new File("img/wall01.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		
		if (this.state.getClass() == ItemHidden.class){
			this.setAnimation(wallImg);
			return;
		}
		
		if (this.state.getClass() == ItemExploding.class){
			this.setAnimation(explosionImg);
			return;
		}
			
		this.setAnimation(pathImg);
		
	}

	
	
}//end Path