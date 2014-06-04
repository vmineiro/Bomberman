package model.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;


/**
 * The Class BombControl.
 */
public class BombControl extends Item {

	
	BufferedImage wallImg;
	BufferedImage pathImg;
	BufferedImage bombControlImg;
	BufferedImage explosionImg;

	
	
	/**
	 * Instantiates a new bomb control.
	 */
	public BombControl(){

		
		try {
			
			wallImg = ImageIO.read(new File("img/wall01.png"));
			pathImg = ImageIO.read(new File("img/wall01.png"));
			bombControlImg = ImageIO.read(new File("img/wall01.png"));
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

	
		
		if (this.state.getClass() == ItemHidden.class){
			this.setAnimation(wallImg);
			return;
		}
		
		if (this.state.getClass() == ItemActive.class){
			this.setAnimation(bombControlImg);
			return;
		}
		
		if (this.state.getClass() == ItemExploding.class){
			this.setAnimation(explosionImg);
			return;
		}
		
			
		this.setAnimation(pathImg);
	}
}//end BombControl