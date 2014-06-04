package model.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Thread.State;







import javax.imageio.ImageIO;
import javax.swing.Timer;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;


/**
 * This class represents the exit of the maze.
 */
public class BoardExit extends Item {
	

	BufferedImage wallImg;
	BufferedImage boardExitImg;
	BufferedImage explosionImg;


	/**
	 * Instantiates a new board exit.
	 */
	public BoardExit(){
		super();
		
		try {
			
			wallImg = ImageIO.read(new File("img/wall01.png"));
			boardExitImg = ImageIO.read(new File("img/wall01.png"));
			explosionImg = ImageIO.read(new File("img/wall01.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	public void setAnimation(BufferedImage animation) {

		if (this.state.getClass() == ItemHidden.class){
			this.setAnimation(wallImg);
			return;
		}
		
		if (this.state.getClass() == ItemExploding.class){
			this.setAnimation(explosionImg);
			return;
		}
		
		this.setAnimation(boardExitImg);
		
	}	
	
}//end BoardExit