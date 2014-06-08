package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import model.GameModel;
import model.Position;
import model.board.BoardExit;
import model.board.ItemExploding;
import model.board.ItemPath;
import model.board.UndestructibleWall;
import model.monster.MonsterAlive;
import model.monster.MonsterDead;
import model.player.Player;
import model.player.PlayerAlive;
import model.player.PlayerDead;

import org.junit.Test;


/**
 * The Class PlayerTests.
 *
 */
public class PlayerTests {


	/**
	 * Move tests.
	 * 
	 * Neste teste pretende-se testar as movimentacoes do jogador 
	 */
	@Test
	public void moveTests(){
		
		Player player_t = new Player();

		assertNotNull(player_t);
		assertNotNull(player_t.getBoardPosition());
		assertNotNull(player_t.getCurrentState());
		
		assertEquals("Player is Alive - Initial State", PlayerAlive.class, player_t.getCurrentState().getClass());
		
		//Player Movement Increments
		Position up = new Position(-1,0);
		Position down = new Position(1,0);
		Position left = new Position(0,-1);
		Position right = new Position(0,1);

		//Player moves down
		player_t.updateBoardPosition(new Position(0, 0));
		player_t.updateBoardPosition(player_t.getBoardPosition().add(down));
		assertTrue("DOWN MOV",player_t.getBoardPosition().equals(new Position(1, 0)));

		//Player moves up
		player_t.updateBoardPosition(player_t.getBoardPosition().add(up));
		assertTrue("UP MOV",player_t.getBoardPosition().equals(new Position(0,0)));

		//Player moves right
		player_t.updateBoardPosition(player_t.getBoardPosition().add(right));
		assertTrue("RIGHT MOV",player_t.getBoardPosition().equals(new Position(0,1)));

		//Player moves up
		player_t.updateBoardPosition(player_t.getBoardPosition().add(left));
		assertTrue("LEFT MOV",player_t.getBoardPosition().equals(new Position(0,0)));
	}

	/**
	 * Drop bomb test.
	 * 
	 * Neste teste pretende-se testar a utilizacao das bombas. Pretende -se testar a criacao das bombas, detonacao 
	 * das bombas. Incluindo testes para amorte do jogador 
	 * caso seja apanhado pela explosao.  
	 */
	@Test
	public void bombTest(){
		
		//Testing Game with no monsters - Bombs limited to 0 and 1
		GameModel.getInstance().standardInitGame(0);
		assertEquals(1, GameModel.getInstance().getPlayers().availableBombs());
		
		GameModel.getInstance().getPlayers().dropBomb();
		assertEquals(0, GameModel.getInstance().getPlayers().availableBombs());
		
		GameModel.getInstance().getPlayers().dropBomb();
		assertEquals(0, GameModel.getInstance().getPlayers().availableBombs());
		
		GameModel.getInstance().getPlayers().addBomb();
		assertEquals(1, GameModel.getInstance().getPlayers().availableBombs());
		
		//Check player death with bomb explosion
		Player player_t = new Player();
		
		ItemPath path_t = new ItemPath();
		UndestructibleWall uw_t = new UndestructibleWall();
		BoardExit be_t = new BoardExit();
		
		assertFalse("Player Alive", player_t.checkDeath(path_t));
		assertFalse("Player Alive", player_t.checkDeath(uw_t));
		assertFalse("Player Alive", player_t.checkDeath(be_t));
		
		be_t.setCurrentState(new ItemExploding());
		path_t.setCurrentState(new ItemExploding());
		uw_t.setCurrentState(new ItemExploding());
		
		assertTrue("Player Dead", player_t.checkDeath(path_t));
		assertTrue("Player Dead", player_t.checkDeath(uw_t));
		assertTrue("Player Dead", player_t.checkDeath(be_t));
		
		//Die with his own bomb
		GameModel.getInstance().standardInitGame(0);
		GameModel.getInstance().getPlayers().setCurrentState(new PlayerAlive());
		assertEquals("Player Alive - Own Bomb", PlayerAlive.class, GameModel.getInstance().getPlayers().getCurrentState().getClass());
		
		GameModel.getInstance().getPlayers().dropBomb();
		
		//Time for detonation
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		assertEquals("Player Dead - Own Bomb", PlayerDead.class, GameModel.getInstance().getPlayers().getCurrentState().getClass());
		
	}

	/**
	 * Monster collision test.
	 * 
	 * Neste teste pretende-se testar as colisoes do jogador com os monstros. Esperando que o jogador morra.
	 */
	@Test
	public void monsterCollisionTest(){

		//Check player death with monster colision
		GameModel.getInstance().standardInitGame(1);
		
		//Player in position(9,9)
		GameModel.getInstance().getPlayers().updateBoardPosition(new Position(9, 9));
		assertFalse(GameModel.getInstance().getPlayers().checkDeath(GameModel.getInstance().getBoard().getItem(new Position(9, 9))));
		assertEquals("Player Alive - Monster", PlayerAlive.class, GameModel.getInstance().getPlayers().getCurrentState().getClass());
		
		//Monster in position(9,9)
		GameModel.getInstance().getMonsters().get(0).setBoardPosition(new Position(9, 9));
		assertTrue(GameModel.getInstance().getPlayers().checkDeath(GameModel.getInstance().getBoard().getItem(new Position(9, 9))));
		assertEquals("Player Dead - Monster", PlayerDead.class, GameModel.getInstance().getPlayers().getCurrentState().getClass());
	}

	/**
	 * State tests.
	 * 
	 * Neste teste pretende testar as alteracoes de estado 
	 */
	@Test
	public void stateTests(){
		
		Player player_t = new Player();
		
		ItemPath path_t = new ItemPath();
		UndestructibleWall uw_t = new UndestructibleWall();
		BoardExit be_t = new BoardExit();
		
		player_t.visitBoardExit(be_t);
		
		//Verify alive state
		assertEquals("Player is Alive - Board Exit", PlayerAlive.class, player_t.getCurrentState().getClass());
		
		player_t.visitPath(path_t);
		
		//Verify alive state
		assertEquals("Player is Alive - Path", PlayerAlive.class, player_t.getCurrentState().getClass());
		
		player_t.visitUndestructibleWall(uw_t);
		
		//Verify alive state
		assertEquals("Player is Alive - Undestructible Wall", PlayerAlive.class, player_t.getCurrentState().getClass());
		
		be_t.setCurrentState(new ItemExploding());
		path_t.setCurrentState(new ItemExploding());
		uw_t.setCurrentState(new ItemExploding());
		
		player_t.visitBoardExit(be_t);
		
		//Verify dead state
		assertEquals("Player is Dead - Board Exit", PlayerDead.class, player_t.getCurrentState().getClass());
		
		player_t.visitPath(path_t);
		
		//Verify dead state
		assertEquals("Player is Dead - Path", PlayerDead.class, player_t.getCurrentState().getClass());
		
		player_t.visitUndestructibleWall(uw_t);
		
		//Verify dead state
		assertEquals("Player is Dead - Undestructible Wall", PlayerDead.class, player_t.getCurrentState().getClass());
	}

	/**
	 * Win tests.
	 * 
	 * Neste teste pretende-se testar as condicoes de vitoria. O jogador mata todos os monstros e encontra a saida.
	 */
	@Test
	public void winTests(){

		GameModel.getInstance().standardInitGame(0);
		GameModel.getInstance().addMonsters(1);
		GameModel.getInstance().getMonsters().get(0).setCurrentState(new MonsterAlive());
		GameModel.getInstance().getPlayers().setCurrentState(new PlayerAlive());
		assertFalse("Game not over - Monster alive", GameModel.getInstance().gameOver());
		
		GameModel.getInstance().getMonsters().get(0).setCurrentState(new MonsterDead());
		GameModel.getInstance().update();
		assertFalse("Game not over - Monster dead but player isnt on the exit position", GameModel.getInstance().gameOver());
		
		//Player in the exit position
		GameModel.getInstance().getPlayers().updateBoardPosition(GameModel.getInstance().getBoard().getExitPos());
		assertTrue("Game Over", GameModel.getInstance().gameOver());
		
	}
	
}

//end PlayerTests