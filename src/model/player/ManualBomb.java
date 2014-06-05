package model.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.GameModel;
import model.Position;


/**
 * The Class ManualBomb.
 */
public class ManualBomb implements Bomb {
	
	/** The range of explosion */
	private int range;
	
	/** The range counter */
	private int range_counter;
	
	/** The player who dropped the bomb */
	private Player dropPlayer;
	
	/** The board position where the bomb was dropped */
	private Position boardPosition;
	
	/** The propagation timer */
	private Timer proTimer;
	
	/** The animation for the bomb */
	//private Animation animation;
	
	//====================================================
	
	/**
	 * Instantiates a new manual bomb.
	 */
	public ManualBomb(Player dropPlayer){
		this.range = 3;
		this.range_counter = 0;
		this.dropPlayer = dropPlayer;
		this.boardPosition = dropPlayer.getBoardPosition();
	}
	
	/**
	 * This method trigger the explosion of the bomb and detonates the cell where the bomb 
	 * was dropped and the cells got in the bomb range. This object is destroyed.
	 * 
	 */
	public void detonate(){
		// First Explosion
		GameModel.getInstance().getBoard().getItem(boardPosition).explode();

		//TODO: Removed bomb from item 
		dropPlayer.incBombs();

		ActionListener proTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				propagateExplosion(boardPosition, range_counter);
				range_counter++;

				if(range_counter == range){
					proTimer.stop();
				}
			}
		};

		proTimer = new Timer(TIME_TO_PROPAGATION, proTimerListener);

		//Start Timer for next Explosion
		proTimer.start();
	}
	
	/**
	 * Propagate bomb explosion
	 */
	public void propagateExplosion(Position initPos, int range_counter){
		//TODO: Review propagate algorithm
		GameModel.getInstance().getBoard().getItem(new Position(boardPosition.getLine()+range_counter, boardPosition.getCol())).explode();
		GameModel.getInstance().getBoard().getItem(new Position(boardPosition.getLine()-range_counter, boardPosition.getCol())).explode();
		GameModel.getInstance().getBoard().getItem(new Position(boardPosition.getLine(), boardPosition.getCol()+range_counter)).explode();
		GameModel.getInstance().getBoard().getItem(new Position(boardPosition.getLine(), boardPosition.getCol()-range_counter)).explode();
	}

	/**
	 * Draw.
	 * This method is called by GUI and is responsible for draw the bomb in the game window.
	 * 
	 */
	public void draw(){}
	
}

//end ManualBomb