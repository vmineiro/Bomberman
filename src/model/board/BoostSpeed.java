package model.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;

/**
 *The Boost Speed class
 */
public class BoostSpeed extends Item {

	BufferedImage wallImg;
	BufferedImage pathImg;
	BufferedImage boostSpeedlImg;
	BufferedImage explosionImg;

	
	public BoostSpeed(){
		
		try {
			
			wallImg = ImageIO.read(new File("img/wall01.png"));
			pathImg = ImageIO.read(new File("img/wall01.png"));
			boostSpeedlImg = ImageIO.read(new File("img/wall01.png"));
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

	/**
	 * Sets the animation to be draw in the game window.
	 */
	@Override
	public void setAnimation(BufferedImage animation){

		if (this.state.getClass() == ItemExploding.class){
			this.setAnimation(explosionImg);
			return;
		}

		if (this.state.getClass() == ItemHidden.class){
			this.setAnimation(wallImg);
			return;
		}

		if (this.state.getClass() == ItemActive.class){
			this.setAnimation(boostSpeedlImg);
			return;
		}


		this.setAnimation(pathImg);

	}

}//end BoostSpeed