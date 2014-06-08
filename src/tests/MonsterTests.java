package tests;

import model.GameModel;
import model.Position;
import model.board.BoardExit;
import model.board.ItemExploding;
import model.board.ItemPath;
import model.board.UndestructibleWall;
import model.monster.Monster;
import model.monster.MonsterAlive;
import model.monster.MonsterDead;
import model.player.Player;
import model.player.PlayerAlive;
import model.player.PlayerDead;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * The Class MonsterTests.
 *
 */
public class MonsterTests {

	/**
	 * Move tests.
	 * 
	 * Neste teste pretende-se testar as movimentacoes dos tipos de monstros, incluindo colisoes contra as paredes, bombas. 
	 */
	@Test
	public void moveTests(){
		
		Monster monster_t = new Monster();

		assertNotNull(monster_t);
		assertNotNull(monster_t.getBoardPosition());
		assertNotNull(monster_t.getCurrentState());

		// Set monster start position in (3,3)
		monster_t.setBoardPosition(monster_t.getBoardPosition().add(new Position(3,3)));
		
		// Generates randomly monster next position
		monster_t.setBoardPosition(monster_t.generateNextMov());
		
		//Verifies monster next position
		assertTrue(monster_t.getBoardPosition().equals(new Position(4, 3)) || monster_t.getBoardPosition().equals(new Position(2, 3)) 
				|| monster_t.getBoardPosition().equals(new Position(3, 4)) || monster_t.getBoardPosition().equals(new Position(3, 2)));
		
		//Check Collision Test
		Position pos_t = new Position(3,3);
		GameModel.getInstance().getPlayers().updateBoardPosition(pos_t);
		
		//Monster is Dead and in a different position
		monster_t.setBoardPosition(new Position(0, 0));
		monster_t.setCurrentState(new MonsterDead());
		assertFalse("Monster is Dead - Collision",monster_t.checkCollision());
		
		//Monster is Alive and in a different position
		monster_t.setCurrentState(new MonsterAlive());
		assertFalse("Monster is Alive - Collision",monster_t.checkCollision());
		
		//Monster is Alive and in a same position
		monster_t.setBoardPosition(pos_t);
		assertTrue("Monster is Alive and same position - Collision",monster_t.checkCollision());
	}

	/**
	 * Death test.
	 * 
	 * Neste teste pretende-se testar
	 */
	@Test
	public void deathTest(){

		Monster monster_T = new Monster();

		assertNotNull(monster_T);
		assertNotNull(monster_T.getBoardPosition());
		assertNotNull(monster_T.getCurrentState());
		
		// Verify alive state
		assertEquals("Monster is Alive - State", MonsterAlive.class, monster_T.getCurrentState().getClass());
		
		monster_T.setCurrentState(monster_T.getCurrentState().die());
		
		//Verify dead state
		assertEquals("Monster is Dead - State", MonsterDead.class, monster_T.getCurrentState().getClass());	
	}
	
	/**
	 * Visit by Player Tests
	 * 
	 * Avaliar a visita do player com diferentes estados dos monstros.
	 */
	@Test
	public void playerVisitTests(){

		Monster monster_T = new Monster();

		//Visit with player - Monster Dead
		Player player_t = new Player();
		monster_T.visit(player_t);

		//Verify alive state
		assertEquals("Monster is Alive - Visit", MonsterAlive.class, monster_T.getCurrentState().getClass());
		assertEquals("Player is Dead - Visit", PlayerDead.class, player_t.getCurrentState().getClass());
		
		monster_T.setCurrentState(new MonsterDead());
		player_t.setCurrentState(new PlayerAlive());
		monster_T.visit(player_t);

		//Verify dead state
		assertEquals("Monster is Dead - Visit", MonsterDead.class, monster_T.getCurrentState().getClass());
		assertEquals("Player is Alive - Visit", PlayerAlive.class, player_t.getCurrentState().getClass());		
	}
	
	/**
	 * Death by Detonation Test
	 * 
	 * Neste teste pretende-se testar a morte dos monstros, apenas quando a celula, onde o monstro se situa, explode.
	 */
	@Test
	public void deathDetonationTests(){
		
		Monster monster_t = new Monster();

		//Testing Check Death
		assertEquals("Monster is Alive before Explosion", MonsterAlive.class, monster_t.getCurrentState().getClass());
		
		ItemPath path_t = new ItemPath();
		path_t.setCurrentState(new ItemExploding());
		monster_t.checkDeath(path_t);
		
		assertEquals("Monster is Dead after Explosion", MonsterDead.class, monster_t.getCurrentState().getClass());
	}
	
	/**
	 * Items visit by monster Tests
	 * Nestes testes pretende-se verificar o comportamento do monstro nos varios items do tabuleiro.
	 */
	@Test
	public void itemsVisitTests(){
		
		Monster monster_t = new Monster();
		
		ItemPath path_t = new ItemPath();
		UndestructibleWall uw_t = new UndestructibleWall();
		BoardExit be_t = new BoardExit();
		
		monster_t.visitBoardExit(be_t);
		
		//Verify alive state
		assertEquals("Monster is Alive - Board Exit", MonsterAlive.class, monster_t.getCurrentState().getClass());
		
		monster_t.visitPath(path_t);
		
		//Verify alive state
		assertEquals("Monster is Alive - Path", MonsterAlive.class, monster_t.getCurrentState().getClass());
		
		monster_t.visitUndestructibleWall(uw_t);
		
		//Verify alive state
		assertEquals("Monster is Alive - Undestructible Wall", MonsterAlive.class, monster_t.getCurrentState().getClass());
		
		be_t.setCurrentState(new ItemExploding());
		path_t.setCurrentState(new ItemExploding());
		uw_t.setCurrentState(new ItemExploding());
		
		monster_t.visitBoardExit(be_t);
		
		//Verify alive state
		assertEquals("Monster is Dead - Board Exit", MonsterDead.class, monster_t.getCurrentState().getClass());
		
		monster_t.visitPath(path_t);
		
		//Verify alive state
		assertEquals("Monster is Dead - Path", MonsterDead.class, monster_t.getCurrentState().getClass());
		
		monster_t.visitUndestructibleWall(uw_t);
		
		//Verify alive state
		assertEquals("Monster is Dead - Undestructible Wall", MonsterDead.class, monster_t.getCurrentState().getClass());
	}
	
}

//end MonsterTests