package model.board;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;



/**
 * The Class Path.
 */
public class ItemPath extends Item {
	
	/** The path image. */
	BufferedImage pathImg;
	
	/** The path exploding image */
	BufferedImage explodingImg;
	
	/**
	 * Instantiates a new path.
	 */
	public ItemPath(){
		
		super();

		setCurrentState(new ItemHidden());
		
		try {
			pathImg = ImageIO.read(new File("img/path.png"));
			explodingImg = ImageIO.read(new File("img/explosion_center.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}



	/**
	 * Accept.
	 *
	 * @param player the player
	 */
	public void accept(Player player){
		
		if (this.state.getClass() == ItemHidden.class  || this.bomb != null) return;
		
		player.visitPath(this);
	}

	
	
	/**
	 * Accept.
	 *
	 * @param monster the monster
	 */
	public void accept(Monster monster){

		if (this.state.getClass() == ItemHidden.class  || this.bomb != null) return;
		
		monster.visitPath(this);
		
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
			setAnimation(pathImg);
		}
		
	}

	/**
	 * Draw Path
	 */
	public void draw(Graphics g, int pos_l, int pos_c, int width, int height){
		if(this.bomb != null){
			g.drawImage(bomb.getImgBomb(), pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 124, 114, null);
			//bomb.draw(g, width, height);
		}else if(isExploding()){
			g.drawImage(explodingImg, pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 96, 97, null);
		}else{
			g.drawImage(pathImg, pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 124, 113, null);
		}
		
	}
	
	
}//end Path