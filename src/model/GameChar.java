package model;

import model.board.*;
import model.monster.Monster;
import model.player.Player;


/**
 * The Interface GameChar.
 */
public interface GameChar {
	
	/**
	 * Collision Management.
	 *
	 * @param gameChar the game char
	 */
	public abstract void collidesWith(GameChar gameChar);
	
	/**
	 * Visited by Player.
	 *
	 * @param vPlayer the v player
	 */
	public abstract void visit(Player vPlayer);
	
	/**
	 * Visited by Monster.
	 *
	 * @param vMonster the v monster
	 */
	public abstract void visit(Monster vMonster);
	
	/**
	 * Monster visits board exit item in game board.
	 *
	 * @param item the item
	 */
	public abstract void visitBoardExit(BoardExit item);
	
	/**
	 * Monster visits path item in game board.
	 *
	 * @param item the item
	 */
	public abstract void visitPath(ItemPath item);
	
	/**
	 * Monster visits undestructible wall item in game board.
	 *
	 * @param item the item
	 */
	public abstract void visitUndestructibleWall(UndestructibleWall item);
}
