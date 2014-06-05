package tests;

import model.Position;
import model.board.ItemDetonating;
import model.board.ItemPath;
import model.monster.Monster;
import model.monster.MonsterAlive;
import model.monster.MonsterDead;

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
		
		Monster monster_T = new Monster();

		assertNotNull(monster_T);
		assertNotNull(monster_T.getBoardPosition());
		assertNotNull(monster_T.getCurrentState());

		// Set monster start position in (3,3)
		monster_T.setBoardPosition(monster_T.getBoardPosition().add(new Position(3,3)));
		// Generates randomly monster next position
		monster_T.setBoardPosition(monster_T.generateNextMov());
		//Verifies monster next position
		assertTrue(monster_T.getBoardPosition().equals(new Position(4, 3)) || monster_T.getBoardPosition().equals(new Position(2, 3)) 
				|| monster_T.getBoardPosition().equals(new Position(3, 4)) || monster_T.getBoardPosition().equals(new Position(3, 2)));
	}

	/**
	 * Power up tests.
	 * 
	 * Neste teste pretende-se testar as alteracoes de estado dos tipos de monstros,
	 * quando visitam uma cas de PowerUp. 
	 */
	@Test
	public void powerUpTests(){

	}

	/**
	 * Death test.
	 * 
	 * Neste teste pretende-se testar a morte dos montros. 
	 */
	@Test
	public void deathTest(){
		Monster monster_T = new Monster();

		assertNotNull(monster_T);
		assertNotNull(monster_T.getBoardPosition());
		assertNotNull(monster_T.getCurrentState());
		
		// Verify alive state
		assertEquals("Monster is Alive", MonsterAlive.class, monster_T.getCurrentState().getClass());
		
		monster_T.setCurrentState(monster_T.getCurrentState().die());
		
		//Verify dead state
		assertEquals("Monster is Dead", MonsterDead.class, monster_T.getCurrentState().getClass());
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
		assertEquals("Monster is Alive before Detonation", MonsterAlive.class, monster_t.getCurrentState().getClass());

		ItemPath path_t = new ItemPath();
		path_t.setCurrentState(new ItemDetonating());
		monster_t.checkDeath(path_t);
		assertEquals("Monster is Dead after Detonation", MonsterDead.class, monster_t.getCurrentState().getClass());

	}
	
}

//end MonsterTests