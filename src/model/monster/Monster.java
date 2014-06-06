package model.monster;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.GameChar;
import model.GameModel;
import model.Position;
import model.board.Item;
import model.board.BoardExit;
import model.board.BombControl;
import model.board.BombPowerUp;
import model.board.BoostSpeed;
import model.board.ExtraBomb;
import model.board.ItemPath;
import model.board.UndestructibleWall;

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
	
	/** The next board position */
	private Position nextMonsterPosition;
	
	/** The speed. */
	//private int speed = 1; 
	
	/** The Animation of the Item. */
	private BufferedImage monsterImg;

	// =============================================================
	
	/**
	 * Instantiates a new monster.
	 */
	public Monster(){
		this.state = new MonsterAlive();
		this.boardPosition = new Position();
		this.nextMonsterPosition = new Position();
		this.drawPosition = new Position();
	}
	
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
		nextMonsterPosition = generateNextMov();
		GameModel.getInstance().getBoard().getItem(nextMonsterPosition).accept(this);
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
	 * Check if monster is killed by detonation and change MonsterStatus
	 */
	public boolean checkDeath(Item itemPos){
		if(itemPos.isExploding()){
			setCurrentState(getCurrentState().die());
			return true;
		}
		return false;
	}
	
	/**
	 * Moves to new board item
	 */
	public void moveMonster(Item mov_item){
		// Leaves previews item
		GameModel.getInstance().getBoard().getItem(getBoardPosition()).monsterOut();
		GameModel.getInstance().getBoard().getItem(nextMonsterPosition).monsterIn();
		
		// Change boardPosition to nextBoardPosition
		setBoardPosition(nextMonsterPosition);
	}
	
	/**
	 * Monster visits bomb control item in game board
	 */
	public void visitBombControl(BombControl item){
		moveMonster(item);
		checkDeath(item);
	}
	
	/**
	 * Monster visits extra bomb item in game board
	 */
	public void visitExtraBomb(ExtraBomb item){
		moveMonster(item);
		checkDeath(item);
	}
	
	/**
	 * Monster visits bomb power up item in game board
	 */
	public void visitBombPowerUp(BombPowerUp item){
		moveMonster(item);
		checkDeath(item);
	}
	
	/**
	 * Monster visits boost speed item in game board
	 */
	public void visitBoostSpeed(BoostSpeed item){
		moveMonster(item);
		checkDeath(item);
	}
	
	/**
	 * Monster visits board exit item in game board
	 */
	public void visitBoardExit(BoardExit item){
		moveMonster(item);
		checkDeath(item);
	}
	
	/**
	 * Monster visits path item in game board
	 */
	public void visitPath(ItemPath item){
		moveMonster(item);
		checkDeath(item);
	}
	
	/**
	 * Monster visits undestructible wall item in game board
	 */
	public void visitUndestructibleWall(UndestructibleWall item){
		moveMonster(item);
		checkDeath(item);
	}
	
	/**
	 * Sets the animation.
	 */
	public void setAnimation(BufferedImage animation){
		this.monsterImg = animation;
	}
	
	/**
	 * Draw.
	 */
	public void draw(Graphics g, int width, int height){
		int n = GameModel.getInstance().getBoard().getMaze().length;
		int dstImgWid = width / n;
		int dstImgHei = height / n;
		
		g.drawImage(monsterImg, boardPosition.getCol()*dstImgWid, boardPosition.getLine()*dstImgHei, 
				(boardPosition.getCol()*dstImgWid)+dstImgWid, (boardPosition.getLine()*dstImgHei)+dstImgHei, 0, 0, 130, 115, null);
	}
	
}

//end Monster
