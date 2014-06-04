package model.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;



import javax.swing.Timer;

import model.monster.Monster;
import model.player.Player;


/**
 * This class represents the exit of the maze.
 */
public class BoardExit extends Item {

	/**
	 * Instantiates a new board exit.
	 */
	public BoardExit(){
		
		super();

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
		player.updateBoardPosition();


	}


	/**
	 * Manages the visit by the monster
	 * @param player the monster visitor
	 */
	public void accept(Monster monster){

		if (this.state.getClass() == ItemHidden.class) return;

	}


	/**
	 * Sets a new animation to be draw in the game window, according the Item current state
	 * @param player the player visitor
	 */
	public void setAnimation(/*Animation animation*/){

	}

	
	
}//end BoardExit