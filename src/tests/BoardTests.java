package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.board.Board;
import model.board.BoardExit;
import model.board.BoardFactory;
import model.board.Item;
import model.board.ItemActive;
import model.board.ItemDetonating;
import model.board.ItemExploding;
import model.board.ItemHidden;
import model.board.ItemInactive;
import model.board.ItemPath;
import model.board.ItemState;
import model.board.UndestructibleWall;

import org.junit.Test;


/**
 * The Class BoardTests.
 *
 */
public class BoardTests {

	
	
	
	/**
	 * Item State change.
	 */
	@Test
	public void itemStateTest(){
		
		ItemState itemState01 = new ItemHidden();
		
		/* Hidden State Tests */
		itemState01 = itemState01.pickUp();
		assertTrue(ItemHidden.class == itemState01.getClass());
		
		itemState01 = itemState01.explosionEnds();
		assertTrue(ItemHidden.class == itemState01.getClass());
		
		itemState01 = itemState01.explode();
		assertTrue(ItemDetonating.class == itemState01.getClass());
		
		/* Detonating State Tests */
		itemState01 = itemState01.pickUp();
		assertTrue(ItemDetonating.class == itemState01.getClass());
		
		itemState01 = itemState01.explode();
		assertTrue(ItemDetonating.class == itemState01.getClass());
		
		itemState01 = itemState01.explosionEnds();
		assertTrue(ItemActive.class == itemState01.getClass());
		
		/* Active State Tests */
		itemState01 = itemState01.explosionEnds();
		assertTrue(ItemActive.class == itemState01.getClass());
		
		itemState01 = itemState01.pickUp();
		assertTrue(ItemInactive.class == itemState01.getClass());
		
		ItemState itemState02 = new ItemActive();
		
		itemState02 = itemState02.explode();
		assertTrue(ItemExploding.class == itemState02.getClass());
		
		itemState02 = itemState02.explosionEnds();
		assertTrue(ItemActive.class == itemState02.getClass());
		
		/* Inactive State Tests */
		itemState01 = itemState01.explosionEnds();
		assertTrue(ItemInactive.class == itemState01.getClass());
		
		itemState01 = itemState01.pickUp();
		assertTrue(ItemInactive.class == itemState01.getClass());
		
		itemState01 = itemState01.explode();
		assertTrue(ItemExploding.class == itemState01.getClass());	
		
		/* Exploding State Tests */
		itemState01 = itemState01.pickUp();
		assertTrue(ItemExploding.class == itemState01.getClass());
		
		itemState01 = itemState01.explode();
		assertTrue(ItemExploding.class == itemState01.getClass());
		
		itemState01 = itemState01.explosionEnds();
		assertTrue(ItemActive.class == itemState01.getClass());
		
		
	}
	
	
	/**
	 * Path test.
	 * 
	 * Neste teste pretende-se testar a criacao, alteracao de estados e parametros do objeto path.
	 * Mais concretamente, quando e detonado (nos possiveis estados), quando e visitado por um jogador 
	 * ou um monstro e quando e colocado uma bomba.
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
		
		assertTrue(path.isActive());	
		
	}	

	/**
	 * Board exit test.
	 * 
	 * Neste teste pretende-se testar a criacao (limite de objectos), alteracao de estados e parametros do objeto BoardExit.
	 * Mais concretamente, quando e detonado (nos possiveis estado), quando e visitado por um jogador, sem que a saida esteja activa
	 * (quando existem monstros vivos no jogo) e quando esta activo (quando nao existem monstros vivos no jogo), ou seja fim do jogo.
	 */
	@Test
	public void boardExitTest(){

		
		Item boardExit = new BoardExit();

		assertTrue(ItemInactive.class == boardExit.getCurrentState().getClass());
		
		boardExit.explode();
		assertEquals(ItemInactive.class, boardExit.getCurrentState().getClass());
		assertFalse(boardExit.isExploding());
		assertFalse(boardExit.isActive());
		
		try {
			Thread.sleep(3100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertFalse(boardExit.isActive());		
		

			
		boardExit.explode();
		assertEquals(ItemInactive.class, boardExit.getCurrentState().getClass());
		assertFalse(boardExit.isExploding());
		
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
	 * Neste teste pretende-se testar a criacao, a nao alteracao de estados e parametros do objeto UndestrutibleWall.
	 * Mais concretamente, quando e detonado uma bomba nas celulas vizinhas (cima, baixo, esquerda, direita).
	 */
	@Test
	public void undestructibleWallTest(){
		
		Item undestructibleWall = new UndestructibleWall();

		assertTrue(ItemInactive.class == undestructibleWall.getCurrentState().getClass());
		
		undestructibleWall.explode();
		assertEquals(ItemInactive.class, undestructibleWall.getCurrentState().getClass());
		assertFalse(undestructibleWall.isExploding());
		assertFalse(undestructibleWall.isActive());
		
		try {
			Thread.sleep(3100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertFalse(undestructibleWall.isActive());		
		

			
		undestructibleWall.explode();
		assertEquals(ItemInactive.class, undestructibleWall.getCurrentState().getClass());
		assertFalse(undestructibleWall.isExploding());
		
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
	 * Neste teste pretende-se testar a geracao de tabuleiro
	 */
	@Test
	public void boardBuildTest(){
		
		int board_size = 11;
		int boardInt [][] = {
				{0,0,0,0,0,0,0,0,0,0,0},
				{3,1,2,1,1,1,1,1,1,1,0},
				{0,1,0,2,0,2,0,2,0,1,0},
				{0,1,1,1,2,1,2,1,1,1,0},
				{0,1,0,2,0,2,0,2,0,1,0},
				{0,1,1,1,2,1,2,1,1,1,0},
				{0,1,0,2,0,2,0,2,0,1,0},
				{0,1,1,1,2,1,1,1,1,1,0},
				{0,1,0,2,0,2,0,2,0,1,0},
				{0,1,1,1,1,1,1,1,1,1,0},
				{0,0,0,0,0,0,0,0,0,0,0},
		};
		
		BoardFactory bf_t = new BoardFactory(board_size, boardInt);
		Board b_t = bf_t.getResult();
		
		assertEquals(11, b_t.getMaze().length);
		
		//UndestructibleWall
		assertEquals(UndestructibleWall.class, b_t.getMaze()[0][0].getClass());
		
		//Path
		assertEquals(ItemPath.class, b_t.getMaze()[1][1].getClass());
		
		//Inactive Path
		assertEquals(ItemInactive.class, b_t.getMaze()[1][2].getCurrentState().getClass());
		
		//Board Exit
		assertEquals(BoardExit.class, b_t.getMaze()[1][0].getClass());

	}
	
	
	
}

//end BoardTests