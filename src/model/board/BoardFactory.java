package model.board;

import java.io.Serializable;

import model.Position;

/**
 * A factory for creating Board objects.
 */
public class BoardFactory implements Serializable{
	
	/** The maze. */
	private Board boardBuilt = new Board();

	/**
	 * Instantiates a new board factory.
	 *
	 * @param boardSize the board size
	 * @param boardInt the board int
	 */
	public BoardFactory(int boardSize, int[][] boardInt){

		Item[][] maze = new Item[boardSize][boardSize];

		for(int i=0; i<boardInt.length; i++)
		{
			for(int j=0; j<boardInt.length; j++)
			{
				if(boardInt[i][j] == 0)
				{
					maze[i][j] = createUndWall();
				}
				else if(boardInt[i][j] == 1)
				{
					maze[i][j] = createPath();
				}
				else if(boardInt[i][j] == 2)
				{
					maze[i][j] = createBlockedPath();
				}
				else if(boardInt[i][j] == 3)
				{
					maze[i][j] = createBoardExit();					
					boardBuilt.setExitPos(new Position(i, j));
				}

			}
		}

		boardBuilt.setMaze(maze);
	}
	
	/**
	 * Returns the built board.
	 *
	 * @return the result
	 */
	public Board getResult(){
		return boardBuilt;
	}

	/**
	 * Creates a new BoarExit.
	 *
	 * @return the board exit
	 */
	public BoardExit createBoardExit(){
		BoardExit be = new BoardExit();
		return be;		
	}

	/**
	 * Creates a new Path.
	 *
	 * @return the item path
	 */
	public ItemPath createPath(){
		ItemPath itemPath = new ItemPath();
		itemPath.setCurrentState(new ItemActive());
		return itemPath;
	}
	
	/**
	 * Creates a blocked path.
	 *
	 * @return the item path
	 */
	public ItemPath createBlockedPath(){
		ItemPath itemPath = new ItemPath();
		itemPath.setCurrentState(new ItemInactive());
		return itemPath;
	}
	
	/**
	 * Creates undestructable wall.
	 *
	 * @return the undestructible wall
	 */
	public UndestructibleWall createUndWall(){
		return new UndestructibleWall();
	}
}

//end BoardFactory