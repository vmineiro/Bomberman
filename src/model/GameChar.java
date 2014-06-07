package model;

import model.board.*;
import model.monster.Monster;
import model.player.Player;

public interface GameChar {
	
	/**
	 * Collision Management
	 * @param gameChar
	 */
	public abstract void collidesWith(GameChar gameChar);
	
	/**
	 * Visited by Player
	 * @param vPlayer
	 */
	public abstract void visit(Player vPlayer);
	
	/**
	 * Visited by Monster
	 * @param vMonster
	 */
	public abstract void visit(Monster vMonster);
	
	/**
	 * Monster visits board exit item in game board
	 */
	public abstract void visitBoardExit(BoardExit item);
	
	/**
	 * Monster visits path item in game board
	 */
	public abstract void visitPath(ItemPath item);
	
	/**
	 * Monster visits undestructible wall item in game board
	 */
	public abstract void visitUndestructibleWall(UndestructibleWall item);
}
