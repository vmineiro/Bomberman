package model;

import model.board.*;

public interface GameChar {
	public abstract void visitBombControl(BombControl item);
	public abstract void visitExtraBomb(ExtraBomb item);
	public abstract void visitBombPowerUp(BombPowerUp item);
	public abstract void visitBoostSpeed(BoostSpeed item);
	public abstract void visitBoardExit(BoardExit item);
	public abstract void visitPath(Path item);
	public abstract void visitUndestructibleWall(UndestructibleWall item);
}
