package model.board;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.monster.Monster;
import model.player.Player;


/**
 * The Class BombPowerUp.
 */
public class BombPowerUp extends Item {
	
	
	
	/** The bomb power up image. */
	BufferedImage bombPowerUpImg;
	
	
	/**
	 * Instantiates a new bomb power up.
	 */
	public BombPowerUp(){
		super();
		
		try {
			
			bombPowerUpImg = ImageIO.read(new File("img/wall01.png"));
			
			setCurrentState(new ItemHidden());
			
		} catch (IOException e) {
			
			
		}

		
		
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

		player.visitBombPowerUp(this);
		


	}

	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	@Override
	public void accept(Monster monster){
		
		if (this.state.getClass() == ItemHidden.class || this.bomb != null) return;
		
		monster.visitBombPowerUp(this);


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
			setAnimation(bombPowerUpImg);
		}

	}

	/**
	 * Draw undestructible Wall
	 */
	public void draw(Graphics g, int pos_l, int pos_c, int width, int height)
	{
		//TODO: Set final image resolution
		g.drawImage(bombPowerUpImg, pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 512, 512, null);
	}
	
	
}//end BombPowerUp