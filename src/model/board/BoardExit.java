package model.board;

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


	/**
	 * Instantiates a new board exit.
	 */
	public BoardExit(){
		
		super();
		
		try {
			
			boardExitImg = ImageIO.read(new File("img/wall01.png"));
			
			setCurrentState(new ItemHidden());
			
		} catch (IOException e) {

			
		}


	}


	/**
	 * Manages the visit by the player.
	 *
	 * @param player the player visitor
	 */
	@Override
	public void accept(Player player){
		
		if (this.state.getClass() == ItemHidden.class) return;
		
		player.visitBoardExit(this);


	}


	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	public void accept(Monster monster){

		if (this.state.getClass() == ItemHidden.class) return;
		
		monster.visitBoardExit(this);
		

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
			setAnimation(boardExitImg);
		}
		
	}

	
	
}//end BoardExit