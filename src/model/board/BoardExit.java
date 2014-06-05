package model.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.Thread.State;





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
		
		//TODO change method
//		player.updateBoardPosition();


	}


	/**
	 * Manages the visit by the monster
	 * @param player the monster visitor
	 */
	public void accept(Monster monster){

		if (this.state.getClass() == ItemHidden.class) return;
		
//		monster.updatePosition();

	}

	
	
	@Override
	public void setAnimation(BufferedImage animation) {

		if (this.state.getClass() == ItemExploding.class){
			this.setAnimation(GameModel.getInstance().getBoard().getAnimation("explosion"));
			return;
		}
		
		if (this.state.getClass() == ItemHidden.class){
			this.setAnimation(GameModel.getInstance().getBoard().getAnimation("wall"));
			return;
		}
		
		if (this.state.getClass() == ItemActive.class){
			this.setAnimation(GameModel.getInstance().getBoard().getAnimation("activeExit"));
			return;
		}
		
			
		this.setAnimation(GameModel.getInstance().getBoard().getAnimation("inactiveExit"));
		
	}	
	
}//end BoardExit