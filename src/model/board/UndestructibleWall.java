package model.board;

import java.awt.image.BufferedImage;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class UndestructibleWall.
 */
public class UndestructibleWall extends Item {

	/**
	 * Instantiates a new undestructible wall.
	 */
	public UndestructibleWall(){}

	
	
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
		this.setAnimation(GameModel.getInstance().getBoard().getAnimation("steel"));	
	}


}//end UndestructibleWall