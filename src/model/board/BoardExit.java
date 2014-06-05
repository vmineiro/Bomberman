package model.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Thread.State;








import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;


/**
 * This class represents the exit of the maze.
 */
public class BoardExit extends Item {
	

	
	
	BufferedImage boardExitImg;


	/**
	 * Instantiates a new board exit.
	 */
	public BoardExit(){
		
		super();
		
		try {
			
			boardExitImg = ImageIO.read(new File("img/wall01.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setCurrentState(new ItemHidden());
		

	}

	/* (non-Javadoc)
	 * @see model.Item#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}


	/**
	 * Manages the visit by the player
	 * @param player the player visitor
	 */
	@Override
	public void accept(Player player){
		
		if (this.state.getClass() == ItemHidden.class) return;
		
		player.visitBoardExit(this);


	}


	/**
	 * Manages the visit by the monster
	 * @param player the monster visitor
	 */
	public void accept(Monster monster){

		if (this.state.getClass() == ItemHidden.class) return;
		
		monster.visitBoardExit(this);
		

	}

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