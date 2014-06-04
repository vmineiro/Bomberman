package tests;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.board.ItemActive;
import model.board.ItemDetonating;
import model.board.ItemExploding;
import model.board.ItemHidden;
import model.board.ItemPath;
import model.board.ItemState;

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
		
		final ItemPath path = new ItemPath();
		
		assertEquals(ItemHidden.class, path.getCurrentState().getClass());
		
		path.explode();
		assertEquals(ItemDetonating.class, path.getCurrentState().getClass());
		assertFalse(path.isDetonating());
		
		assertTrue(path.isActive());		
		
		path.setCurrentState(new ItemActive());
		
		
		path.explode();
		assertEquals(ItemExploding.class, path.getCurrentState().getClass());
		assertTrue(path.isDetonating());

		
		
		
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

		ItemPath path = new ItemPath();
		
		assertEquals(ItemHidden.class, path.getCurrentState().getClass());
		
		path.explode();
		assertEquals(ItemDetonating.class, path.getCurrentState().getClass());
		assertFalse(path.isDetonating());
		
		path.setCurrentState(new ItemActive());
		assertTrue(path.isActive());
		
		path.explode();
		assertEquals(ItemExploding.class, path.getCurrentState().getClass());
		assertTrue(path.isDetonating());
		
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

	}

	/**
	 * Undestructible wall test.
	 * 
	 * Neste teste pretende-se testar a criação, a não alteração de estados e parametros do objeto UndestrutibleWall.
	 * Mais concretamente, quando é detonado uma bomba nas celulas vizinhas (cima, baixo, esquerda, direita).
	 */
	@Test
	public void undestructibleWallTest(){

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