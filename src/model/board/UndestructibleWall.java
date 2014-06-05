package model.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.monster.Monster;
import model.player.Player;



/**
 * The Class UndestructibleWall.
 */
public class UndestructibleWall extends Item {
	
	
	/** The steel image. */
	BufferedImage steelImg;

	/**
	 * Instantiates a new undestructible wall.
	 */
	public UndestructibleWall(){
		super();
		
		try {
			
			steelImg = ImageIO.read(new File("img/wall01.png"));
			
			setCurrentState(new ItemInactive());
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
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

	
	
	/* (non-Javadoc)
	 * @see model.board.Item#explode()
	 */
	@Override
	public boolean explode() {
		return false;
	}



	/* (non-Javadoc)
	 * @see model.board.Item#setCurrentState(model.board.ItemState)
	 */
	@Override
	public void setCurrentState(ItemState state) {
		this.state = state;
		setAnimation(steelImg);
		
	}
	



}//end UndestructibleWall