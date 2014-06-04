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
 * The Class UndestructibleWall.
 */
public class UndestructibleWall extends Item {

	BufferedImage steelImg;

	/**
	 * Instantiates a new undestructible wall.
	 */
	public UndestructibleWall(){
		
		try {
			
			steelImg = ImageIO.read(new File("img/wall01.png"));
			
			setAnimation(steelImg);
			
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
	public void accept(Player player){}

	
	
	/**
	 * Accept.
	 *
	 * @param monster the monster
	 */
	public void accept(Monster monster){}

	
	
	@Override
	public void explode() {}
	
	
	
	@Override
	public void setAnimation(BufferedImage animation) {
		this.animation = animation;
	}


}//end UndestructibleWall