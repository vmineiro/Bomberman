package tests;

import model.Position;
import model.monster.Monster;
import model.monster.MonsterAlive;

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

		monster_T.setBoardPosition(new Position(0, 0));
		monster_T.setBoardPosition(monster_T.getBoardPosition().add(new Position(3, 3)));

		assertEquals(monster_T.getBoardPosition().getLine(), 3);
		assertEquals(monster_T.getBoardPosition().getCol(), 3);
		
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
	 * Neste teste pretende-se testar a morte dos montros, ser serao apenas quando a celula, onde o monstro se situa, explode. 
	 */
	@Test
	public void deathTest(){

	}
}//end MonsterTests