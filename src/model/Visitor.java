package model;

import model.monster.Monster;
import model.player.Player;

public interface Visitor {
	
	/**
	 * Player is visited
	 * 
	 * @param vPlayer
	 */
	public abstract void visit(Player vPlayer);
	
	/**
	 * Monster is visited
	 * 
	 * @param vMonster
	 */
	public abstract void visit(Monster vMonster);
	
	
}
