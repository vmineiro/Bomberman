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
	 * Initializtion Tests
	 * 
	 * Neste teste pretende-se testar a criacao de monstros e avaliar o valor dos campos do objecto monstro
	 */
	@Test
	public void initMonsterTests(){
		
		Monster monster_T = new Monster();
		
		assertNotNull(monster_T);
		assertNotNull(monster_T.getBoardPosition());
		assertNotNull(monster_T.getCurrentState());
		
		Position pos_T = new Position();
		pos_T.setPosition(1,1);
		monster_T.setBoardPosition(pos_T);
		assertEquals(monster_T.getBoardPosition(),pos_T);
		
	}

	/**
	 * Move tests.
	 * 
	 * Neste teste pretende-se testar as movimentacoes dos tipos de monstros, incluindo colisoes contra as paredes, bombas. 
	 */
	@Test
	public void moveTests(){

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