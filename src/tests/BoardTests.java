package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.board.BoardExit;
import model.board.BombControl;
import model.board.BombPowerUp;
import model.board.BoostSpeed;
import model.board.ExtraBomb;
import model.board.Item;
import model.board.ItemDetonating;
import model.board.ItemExploding;
import model.board.ItemHidden;
import model.board.ItemInactive;
import model.board.ItemPath;
import model.board.UndestructibleWall;

import org.junit.Test;


/**
 * The Class BoardTests.
 *
 */
public class BoardTests {

	
	
	
	/**
	 * Item State change
	 * 
	 */
	@Test
	public void itemStateTest(){
		
		
//		ItemState itemState = new ItemHidden();
//		
//		itemState.explode();
//		assertEquals(ItemDetonating.class, itemState.getClass());
		
		
		
		
	}
	
	
	/**
	 * Path test.
	 * 
	 * Neste teste pretende-se testar a criação, alteração de estados e parametros do objeto path.
	 * Mais concretamente, quando é detonado (nos possíveis estados), quando é visitado por um jogador 
	 * ou um monstro e quando é colocado uma bomba.
	 */
	@Test
	public void pathTest(){
		
		Item path = new ItemPath();
		
		assertTrue(ItemHidden.class == path.getCurrentState().getClass());
		
		path.explode();
		assertEquals(ItemDetonating.class, path.getCurrentState().getClass());
		assertFalse(path.isExploding());
		assertFalse(path.isActive());
		
		try {
			Thread.sleep(3100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue(path.isActive());		
		

			
		path.explode();
		assertEquals(ItemExploding.class, path.getCurrentState().getClass());
		assertTrue(path.isExploding());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		assertFalse(path.isActive());	
		
	}

	/**
	 * Extra bomb test.
	 * 
	 * Neste teste pretende-se testar a criação (limite de objectos), alteração de estados e parametros do objeto ExtraBomb.
	 * Mais concretamente, quando é detonado (nos possíveis estado), quando é visitado por um jogador, aumentando o número de
	 * disponiveis do jogador e quando é visitado por um monstro.
	 */
	@Test
	public void extraBombTest(){

		
		Item extraBomb = new ExtraBomb();
		
		assertTrue(ItemHidden.class == extraBomb.getCurrentState().getClass());
		
		extraBomb.explode();
		assertEquals(ItemDetonating.class, extraBomb.getCurrentState().getClass());
		assertFalse(extraBomb.isExploding());
		assertFalse(extraBomb.isActive());
		
		try {
			Thread.sleep(3100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue(extraBomb.isActive());		
		

			
		extraBomb.explode();
		assertEquals(ItemExploding.class, extraBomb.getCurrentState().getClass());
		assertTrue(extraBomb.isExploding());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		assertFalse(extraBomb.isActive());	

		
	}

	/**
	 * Bomb control test.
	 * 
	 * Neste teste pretende-se testar a criação (limite de objectos), alteração de estados e parametros do objeto BombControl.
	 * Mais concretamente, quando é detonado (nos possíveis estado), quando é visitado por um jogador, alterando o tipo
	 * das suas bombas e quando é visitado por um monstro.
	 */
	@Test
	public void bombControlTest(){
		
		Item bombControl = new BombControl();

		assertTrue(ItemHidden.class == bombControl.getCurrentState().getClass());
		
		bombControl.explode();
		assertEquals(ItemDetonating.class, bombControl.getCurrentState().getClass());
		assertFalse(bombControl.isExploding());
		assertFalse(bombControl.isActive());
		
		try {
			Thread.sleep(3100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue(bombControl.isActive());		
		

			
		bombControl.explode();
		assertEquals(ItemExploding.class, bombControl.getCurrentState().getClass());
		assertTrue(bombControl.isExploding());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		assertFalse(bombControl.isActive());	

	}

	/**
	 * Bomb power up test.
	 * 
	 * Neste teste pretende-se testar a criação (limite de objectos), alteração de estados e parametros do objeto BombPowerUp.
	 * Mais concretamente, quando é detonado (nos possíveis estado), quando é visitado por um jogador, aumentando a intensidade
	 * das suas bombas e quando é visitado por um monstro.
	 */
	@Test
	public void bombPowerUpTest(){

		Item bombPowerUp = new BombPowerUp();

		assertTrue(ItemHidden.class == bombPowerUp.getCurrentState().getClass());
		
		bombPowerUp.explode();
		assertEquals(ItemDetonating.class, bombPowerUp.getCurrentState().getClass());
		assertFalse(bombPowerUp.isExploding());
		assertFalse(bombPowerUp.isActive());
		
		try {
			Thread.sleep(3100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue(bombPowerUp.isActive());		
		

			
		bombPowerUp.explode();
		assertEquals(ItemExploding.class, bombPowerUp.getCurrentState().getClass());
		assertTrue(bombPowerUp.isExploding());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		assertFalse(bombPowerUp.isActive());
		
	}

	/**
	 * Boost speed test.
	 * 
	 * Neste teste pretende-se testar a criação (limite de objectos), alteração de estados e parametros do objeto BoostSpeed.
	 * Mais concretamente, quando é detonado (nos possíveis estado), quando é visitado por um jogador, aumentando a velocidade
	 * de deslocação do jogador e quando é visitado por um monstro.
	 */
	@Test
	public void boostSpeedTest(){
		
		Item boostSpeed = new BoostSpeed();

		assertTrue(ItemHidden.class == boostSpeed.getCurrentState().getClass());
		
		boostSpeed.explode();
		assertEquals(ItemDetonating.class, boostSpeed.getCurrentState().getClass());
		assertFalse(boostSpeed.isExploding());
		assertFalse(boostSpeed.isActive());
		
		try {
			Thread.sleep(3100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue(boostSpeed.isActive());		
		

			
		boostSpeed.explode();
		assertEquals(ItemExploding.class, boostSpeed.getCurrentState().getClass());
		assertTrue(boostSpeed.isExploding());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		assertFalse(boostSpeed.isActive());

	}

	/**
	 * Board exit test.
	 * 
	 * Neste teste pretende-se testar a criação (limite de objectos), alteração de estados e parametros do objeto BoardExit.
	 * Mais concretamente, quando é detonado (nos possíveis estado), quando é visitado por um jogador, sem que a saída esteja activa
	 * (quando existem monstros vivos no jogo) e quando está activo (quando não existem monstros vivos no jogo), ou seja fim do jogo.
	 */
	@Test
	public void boardExitTest(){

		
		Item boardExit = new BoardExit();

		assertTrue(ItemHidden.class == boardExit.getCurrentState().getClass());
		
		boardExit.explode();
		assertEquals(ItemDetonating.class, boardExit.getCurrentState().getClass());
		assertFalse(boardExit.isDetonating());
		assertFalse(boardExit.isActive());
		
		try {
			Thread.sleep(3100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue(boardExit.isActive());		
		

			
		boardExit.explode();
		assertEquals(ItemExploding.class, boardExit.getCurrentState().getClass());
		assertTrue(boardExit.isDetonating());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		assertFalse(boardExit.isActive());
		
	}

	/**
	 * Undestructible wall test.
	 * 
	 * Neste teste pretende-se testar a criação, a não alteração de estados e parametros do objeto UndestrutibleWall.
	 * Mais concretamente, quando é detonado uma bomba nas celulas vizinhas (cima, baixo, esquerda, direita).
	 */
	@Test
	public void undestructibleWallTest(){
		
		Item undestructibleWall = new UndestructibleWall();

		assertTrue(ItemInactive.class == undestructibleWall.getCurrentState().getClass());
		
		undestructibleWall.explode();
		assertEquals(ItemInactive.class, undestructibleWall.getCurrentState().getClass());
		assertFalse(undestructibleWall.isDetonating());
		assertFalse(undestructibleWall.isActive());
		
		try {
			Thread.sleep(3100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertFalse(undestructibleWall.isActive());		
		

			
		undestructibleWall.explode();
		assertEquals(ItemInactive.class, undestructibleWall.getCurrentState().getClass());
		assertFalse(undestructibleWall.isDetonating());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		assertFalse(undestructibleWall.isActive());

	}

	/**
	 * Board build test.
	 * 
	 * Neste teste pretende-se testar a geração de tabuleiro, ou seja que o jogador não se encontra preso.
	 */
	@Test
	public void boardBuildTest(){

	}
}//end BoardTests