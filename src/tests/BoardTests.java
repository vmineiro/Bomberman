package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.GameModel;
import model.Position;
import model.board.Board;
import model.board.BoardExit;
import model.board.Item;
import model.board.ItemActive;
import model.board.ItemDetonating;
import model.board.ItemExploding;
import model.board.ItemHidden;
import model.board.ItemInactive;
import model.board.ItemPath;
import model.board.ItemState;
import model.board.UndestructibleWall;
import model.monster.Monster;
import model.player.Player;

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
		assertTrue(ItemInactive.class == itemState02.getClass());
		
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
		assertTrue(ItemInactive.class == itemState01.getClass());
		
		
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
		assertFalse(boardExit.isExploding());
		assertFalse(boardExit.isActive());
		
		try {
			Thread.sleep(3100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertTrue(boardExit.isActive());		
		

			
		boardExit.explode();
		assertEquals(ItemExploding.class, boardExit.getCurrentState().getClass());
		assertTrue(boardExit.isExploding());
		
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
	 * Neste teste pretende-se testar a geração de tabuleiro, ou seja que o jogador não se encontra preso.
	 */
	@Test
	public void boardBuildTest(){
		
		

	}
	
	
	/**
	 * Visits test.
	 * 
	 * Neste teste pretende-se testar a alteracoes de estado de cada item aquando da visita de um player ou de um monstro.
	 */
	@Test
	public void visitTest(){
		
		
			
		Player player = new Player();
		player.updateBoardPosition(new Position(3,3));
		
		Monster monster = new Monster();
		monster.setBoardPosition(new Position(1,1));
		
		Item hiddenPath = new ItemPath();
		
		Item normalPath = new ItemPath();
		normalPath.setCurrentState(new ItemActive());
		
		Item boardExit = new BoardExit();
		
		Item undestructibleWall = new UndestructibleWall();
		
		
		Item[][] maze = new Item[][]{
				{undestructibleWall, undestructibleWall, undestructibleWall, undestructibleWall, undestructibleWall},
				{undestructibleWall, normalPath, normalPath, normalPath, undestructibleWall},
				{undestructibleWall, normalPath, undestructibleWall, normalPath, undestructibleWall},
				{undestructibleWall, normalPath, normalPath, normalPath, undestructibleWall},
				{undestructibleWall, undestructibleWall, undestructibleWall, undestructibleWall, undestructibleWall}		
		};
		
		Board board = new Board();
		board.setMaze(maze);
		
		GameModel game = GameModel.getInstance();		
		game.setBoard(board);
		game.addMonster(monster);
		game.addPlayer(player);
		
		
		/* Hidden Path Test */
		hiddenPath.accept(player);
		assertEquals("Expected to not change state", ItemHidden.class, hiddenPath.getCurrentState().getClass());
		hiddenPath.accept(monster);
		assertEquals("Expected to not change state", ItemHidden.class, hiddenPath.getCurrentState().getClass());
		
		/* Normal Path Test */
		hiddenPath.accept(player);
		assertEquals("Expected to not change state", ItemActive.class, normalPath.getCurrentState().getClass());
		hiddenPath.accept(monster);
		assertEquals("Expected to not change state", ItemActive.class, normalPath.getCurrentState().getClass());
		
		boardExit.setCurrentState(new ItemInactive());
		boardExit.accept(player);
		assertEquals("Expected to not change state", ItemInactive.class, boardExit.getCurrentState().getClass());
		
		boardExit.setCurrentState(new ItemActive());
		boardExit.accept(player);
		assertEquals("Expected to not change state", ItemActive.class, boardExit.getCurrentState().getClass());
		
	}
	
	
	
}//end BoardTests