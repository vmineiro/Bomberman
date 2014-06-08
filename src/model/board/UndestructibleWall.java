package model.board;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;
import java.io.Serializable;


/**
 * The Class UndestructibleWall.
 */
public class UndestructibleWall extends Item implements Serializable{
	
	
	/** The steel image. */
	BufferedImage steelImg;

	/**
	 * Instantiates a new undestructible wall.
	 */
	public UndestructibleWall(){
		super();
		
		try {
			
			steelImg = ImageIO.read(new File("img/steel.png"));
			
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
	
	/**
	 * Draw undestructible Wall.
	 *
	 * @param g the g
	 * @param pos_l the pos_l
	 * @param pos_c the pos_c
	 * @param width the width
	 * @param height the height
	 */
	public void draw(Graphics g, int pos_l, int pos_c, int width, int height)
	{		
		g.drawImage(steelImg, pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 159, 159, null);
	}
	



}//end UndestructibleWall