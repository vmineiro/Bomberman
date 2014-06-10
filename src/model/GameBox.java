package model;

import java.io.Serializable;
import java.util.ArrayList;

import model.board.Board;
import model.monster.Monster;
import model.player.Player;

public class GameBox implements Serializable{
	
	private Player player_box;
	private Board board_box;
	private ArrayList<Monster> monster_box = new ArrayList<Monster>();
	
	public GameBox(Player p_box, Board b_box, ArrayList<Monster> m_box){
		
		this.player_box = p_box;
		this.board_box = b_box;
		this.monster_box = m_box;
	}
	
	public Player getPlayerBox(){
		return player_box;
	}
	
	public Board getBoardBox(){
		return board_box;
	}
	
	public ArrayList<Monster> getMonsterBox(){
		return monster_box;
	}

}
