package model.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.GameModel;
import model.Position;


/**
 * The Class AutomaticBomb.
 */
public class AutomaticBomb implements Bomb {
	
	/** The range of explosion */
	private int range;
	
	/** The board position where the bomb was dropped */
	private Position boardPosition;
	
	/** The bomb timer */
	private Timer bombTimer;
	
	/** The animation for the bomb */
	//private Animation animation;
	
	//=======================================================

	/**
	 * Instantiates a new automatic bomb.
	 */
	public AutomaticBomb(Position dropPos){
		this.range = 3;
		this.boardPosition = dropPos;
		
		ActionListener bombTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				detonate();
				bombTimer.stop();
			}
		};
				
		bombTimer = new Timer(1000, bombTimerListener);	
	}
	
	/**
	 * This method trigger the explosion of the bomb and detonates the cell where the bomb 
	 * was dropped and the cells got in the bomb range. This object is destroyed.
	 * 
	 */
	public void detonate(){
		
		GameModel.getInstance().getBoard().getItem(boardPosition).explode();
	}

	/**
	 * Draw.
	 * This method is called by GUI and is responsible for draw the bomb in the game window.
	 * 
	 */
	public void draw(){}
	
	/**
	 * Update.
	 * This method is called by game loop and is responsible for update the count down for explosion.
	 * When timeOut == 0 detonates the bomb.
	 * 
	 */
	public void update(){}
	

}//end AutomaticBomb