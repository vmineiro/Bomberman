package model.monster;

import model.GameChar;
import model.GameModel;
import model.Position;
import model.board.BoardExit;
import model.board.BombControl;
import model.board.BombPowerUp;
import model.board.BoostSpeed;
import model.board.ExtraBomb;
import model.board.Path;
import model.board.UndestructibleWall;

// TODO: Auto-generated Javadoc
/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a MonsterState subclass that defines the current state.
 * 
 */
public class Monster implements GameChar{

	//Random Monster Movement
	private static final Position UP = new Position(-1,0);
	private static final Position DOWN = new Position(1,0);
	private static final Position LEFT = new Position(0,-1);
	private static final Position RIGHT = new Position(0,1);

	/** The state. */
	private MonsterState state;
	
	/** The draw position. */
	private Position drawPosition;
	
	/** The board position. */
	private Position boardPosition;
	
	/** The speed. */
	private int speed; 
	
	/** The animation to be draw */
	//private Animation animation;

	// =============================================================
	
	/**
	 * Instantiates a new monster.
	 */
	public Monster(){
		this.state = new MonsterAlive();
		this.boardPosition = new Position();
		this.drawPosition = new Position();
		this.speed = 1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {}
	
	/**
	 * Get Monster board position
	 */
	public Position getBoardPosition(){
		return boardPosition;
	}
	
	/**
	 * Set Monster board position
	 * 
	 * @param n_pos the new Monster board position
	 */
	public void setBoardPosition(Position n_pos){
		this.boardPosition = n_pos;
	}
	
	/**
	 * Gets the current state
	 */
	public MonsterState getCurrentState(){
		return state;
	}
	
	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public void setCurrentState(MonsterState state){
		this.state = state;
	}

	/**
	 * Update Monster
	 */
	public void update(){
			
		Position newPosMonster = generateNextMov();
		
		//Check Monster new position ---------------------------------------------------------- INCOMPLETE
		GameModel.getInstance().getBoard().getItem(newPosMonster).accept(this);
	}

	/**
	 * Generate randomly next monster movement
	 * 
	 * @return newPosMonster
	 */
	public Position generateNextMov() {
		Position mov_options[] = {UP,DOWN,LEFT,RIGHT};
		Position mov_selected = mov_options[(int)(Math.random() * mov_options.length)]; 
		Position newPosMonster = boardPosition.add(mov_selected);
		return newPosMonster;
	}
	
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
	public void visitBoardExit(BoardExit item){}
	
	/**
	 * Monster visits path item in game board
	 */
	public void visitPath(Path item){}
	
	/**
	 * Monster visits undestructible wall item in game board
	 */
	public void visitUndestructibleWall(UndestructibleWall item){}
	
	/**
	 * Draw.
	 */
	public void draw(){}
	
	/**
	 * Sets the animation.
	 */
	public void setAnimation(/*Animation animation*/){}
	
}

//end Monster