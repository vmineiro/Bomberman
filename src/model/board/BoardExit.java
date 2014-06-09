package model.board;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.monster.Monster;
import model.player.Player;

import java.io.Serializable;

/**
 * This class represents the exit of the maze.
 */
@SuppressWarnings("serial")
public class BoardExit extends Item implements Serializable{
	
	/** The board exit image. */
	private transient BufferedImage boardExitImg;
	
	/**  The board exit open image. */
	private transient BufferedImage exitOpenImg;

	/**
	 * Instantiates a new board exit.
	 */
	public BoardExit(){
		
		super();
		setCurrentState(new ItemInactive());
		
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
		
		if (this.state.getClass() == ItemInactive.class || this.bomb != null) return;
		player.visitBoardExit(this);
	}

	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	public void accept(Monster monster){

	}

	/* (non-Javadoc)
	 * @see model.board.Item#setCurrentState(model.board.ItemState)
	 */
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
	
	/* (non-Javadoc)
	 * @see model.board.Item#explode()
	 */
	public boolean explode() {
		return false;
	}

	/**
	 * Draw Board Exit.
	 *
	 * @param g the g
	 * @param pos_l the pos_l
	 * @param pos_c the pos_c
	 * @param width the width
	 * @param height the height
	 */
	public void draw(Graphics g, int pos_l, int pos_c, int width, int height)
	{
		if(getCurrentState().getClass() == ItemActive.class){
			g.drawImage(exitOpenImg, pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 112, 112, null);
		}else{
			g.drawImage(boardExitImg, pos_c*width, pos_l*height, (pos_c*width)+width, (pos_l*height)+height, 0, 0, 112, 112, null);
		}
	}
	
}

//end BoardExit