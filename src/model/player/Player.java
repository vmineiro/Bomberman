package model.player;

import model.GameChar;
import model.GameModel;
import model.Position;
import model.board.BoardExit;
import model.board.BombControl;
import model.board.BombPowerUp;
import model.board.BoostSpeed;
import model.board.ExtraBomb;
import model.board.ItemPath;
import model.board.UndestructibleWall;
import model.monster.MonsterState;

/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a PlayerState subclass that defines the current state.
 */
public class Player implements GameChar{

	/** The score. */
	private int score = 0;
	
	/** The lives. */
	private int lives = 3;
	
	/** The speed. */
	private int speed;
	
	/** The board position. */
	private Position boardPosition;
	
	/** The next board position */
	private Position nextPlayerPosition;
	
	/** The draw position. */
	private Position drawPosition;
	
	/** The state. */
	private PlayerState state;
	
	/** The animation. */
	//private Animation animation;
	
	/** The manual bomb. */
	private boolean manualBomb = false;
	
	/** The bomb power. */
	private int bombPower = 1;
	
	/** The n bombs. */
	private int nBombs = 1;
	
	/** The imortal. */
	private boolean imortal = true;
	
	//TODO: Bombs Queue field
	
	//============================================================================
	
	/**
	 * Instantiates a new player.
	 */
	public Player(){
		boardPosition = new Position();
		drawPosition = new Position();
		state = new PlayerDown();
	}
	
	/**
	 * Get board position
	 */
	public Position getBoardPosition(){
		return boardPosition;
	}
	
	/**
	 * Update board position.
	 */
	public void updateBoardPosition(Position n_pos){
		this.boardPosition = n_pos;
	}
	
	/**
	 * Gets the current state
	 */
	public PlayerState getCurrentState(){
		return state;
	}
	
	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public void setCurrentState(PlayerState state){
		this.state = state;
	}
	
	/**
	 * Update.
	 */
	public void update(){
		nextPlayerPosition = getCurrentState().generateNextMov(this);
		GameModel.getInstance().getBoard().getItem(nextPlayerPosition).accept(this);
	}
	
	//TODO: Implement this functions ========================================
	/**
	 * Drop bomb.
	 */
	public void dropBomb(){
		//new Bomb()
	}

	/**
	 * Detonate bomb.
	 *
	 * @param bomb the bomb
	 */
	public void detonateBomb(Bomb bomb){

	}

	/**
	 * Increase speed.
	 */
	public void increaseSpeed(){

	}

	/**
	 * Increase power bomb.
	 */
	public void increasePowerBomb(){

	}

	/**
	 * Life lost.
	 */
	public void lifeLost(){}

	/**
	 * Adds the bomb.
	 */
	public void addBomb(){}

	/**
	 * Respawn. Set the player in start position.
	 */
	public void respawn(){
		 // if the player died should reset his power ups.
	}

	/**
	 * Sets the animation.
	 */
	public void setAnimation(){}

	/**
	 * Draw.
	 */
	public void draw(){}

	/**
	 * Monster visits bomb control item in game board
	 */
	public void visitBombControl(BombControl item){}
	
	/**
	 * Monster visits extra bomb item in game board
	 */
	public void visitExtraBomb(ExtraBomb item){}
	
	/**
	 * Monster visits bomb power up item in game board
	 */
	public void visitBombPowerUp(BombPowerUp item){}
	
	/**
	 * Monster visits boost speed item in game board
	 */
	public void visitBoostSpeed(BoostSpeed item){}
	
	/**
	 * Monster visits board exit item in game board
	 */ 
	public void visitBoardExit(BoardExit item){
		//TODO: Add check isActive()
	}
	
	/**
	 * Monster visits path item in game board
	 */
	public void visitPath(ItemPath item){}
	
	/**
	 * Monster visits undestructible wall item in game board
	 */
	public void visitUndestructibleWall(UndestructibleWall item){}

}

//end Player