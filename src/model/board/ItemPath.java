package model.board;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import model.monster.Monster;
import model.player.Player;


/**
 * The Class Path.
 */
public class ItemPath extends Item implements Serializable{
	
	/**
	 * Instantiates a new path.
	 */
	public ItemPath(){
		super();
		setCurrentState(new ItemHidden());
	}

	/**
	 * Accept.
	 *
	 * @param player the player
	 */
	public void accept(Player player){
		
		if (this.state.getClass() == ItemInactive.class  || this.bomb != null) return;
		
		player.visitPath(this);
	}	
	
	/**
	 * Accept.
	 *
	 * @param monster the monster
	 */
	public void accept(Monster monster){

		if (this.state.getClass() == ItemInactive.class  || this.bomb != null) return;
		
		monster.visitPath(this);
		
	}
	
	/* (non-Javadoc)
	 * @see model.board.Item#setCurrentState(model.board.ItemState)
	 */
	@Override
	public void setCurrentState(ItemState state) {
		this.state = state;
	}

	/**
	 * Draw Path.
	 *
	 * @param g the g
	 * @param pos_l the pos_l
	 * @param pos_c the pos_c
	 * @param width the width
	 * @param height the height
	 */
	public void draw(Graphics g, int pos_l, int pos_c, int width, int height){
		if(this.bomb != null){
			g.drawImage(bomb.getImgBomb(), pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 124, 114, null);
		}else if(isExploding()){
			g.drawImage(explosionImg, pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 96, 97, null);
		}else if(!isActive()){
			g.drawImage(wallImg, pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 128, 128, null);
		}else{
			g.drawImage(pathImg, pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 124, 113, null);
		}
	}
	
	
}//end Path