package model;

import model.board.*;

public interface GameChar {
	
	/**
	 * Monster visits bomb control item in game board
	 */
	public abstract void visitBombControl(BombControl item);
	
	/**
	 * Monster visits extra bomb item in game board
	 */
	public abstract void visitExtraBomb(ExtraBomb item);
	
	/**
	 * Monster visits bomb power up item in game board
	 */
	public abstract void visitBombPowerUp(BombPowerUp item);
	
	/**
	 * Monster visits boost speed item in game board
	 */
	public abstract void visitBoostSpeed(BoostSpeed item);
	
	/**
	 * Monster visits board exit item in game board
	 */
	public abstract void visitBoardExit(BoardExit item);
	
	/**
	 * Monster visits path item in game board
	 */
	public abstract void visitPath(Path item);
	
	/**
	 * Monster visits undestructible wall item in game board
	 */
	public abstract void visitUndestructibleWall(UndestructibleWall item);
}
