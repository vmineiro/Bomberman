package model.board;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.monster.Monster;
import model.player.Player;

/**
 * This class represents the exit of the maze.
 */
public class BoardExit extends Item {
	
	/** The board exit image. */
	BufferedImage boardExitImg;
	
	/** The board exit open image */
	BufferedImage exitOpenImg;

	/**
	 * Instantiates a new board exit.
	 */
	public BoardExit(){
		
		super();
		setCurrentState(new ItemHidden());
		
		try {	
			boardExitImg = ImageIO.read(new File("img/exit.png"));
			exitOpenImg = ImageIO.read(new File("img/path.png"));			
		} catch (IOException e) {}
	}

	/**
	 * Manages the visit by the player.
	 *
	 * @param player the player visitor
	 */
	@Override
	public void accept(Player player){
		
		if (this.state.getClass() == ItemHidden.class || this.bomb != null) return;
		player.visitBoardExit(this);
	}

	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	public void accept(Monster monster){
		if (this.state.getClass() == ItemHidden.class || this.bomb != null) return;
		monster.visitBoardExit(this);
	}

	public void setCurrentState(ItemState state) {
		this.state = state;
		
		if (this.state.getClass() == ItemHidden.class) {
			setAnimation(wallImg);
		} else if (this.state.getClass() == ItemDetonating.class || this.state.getClass() == ItemExploding.class) {
			setAnimation(explosionImg);
		} else {
			setAnimation(boardExitImg);
		}		
	}

	/**
	 * Draw Board Exit
	 */
	public void draw(Graphics g, int pos_l, int pos_c, int width, int height)
	{
		g.drawImage(boardExitImg, pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 112, 112, null);
	}
	
}

//end BoardExit