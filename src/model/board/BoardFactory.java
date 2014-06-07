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
	 * Returns the built board
	 * @return
	 */
	public Board getResult(){
		return boardBuilt;
	}

	/**
	 * Creates a new BoarExit
	 */
	public BoardExit createBoardExit(){
		BoardExit be = new BoardExit();
		be.setCurrentState(new ItemHidden());
		return be;		
	}

	/**
	 * Creates a new Path
	 */
	public ItemPath createPath(){
		ItemPath itemPath = new ItemPath();
		itemPath.setCurrentState(new ItemActive());
		return itemPath;
	}
	
	/**
	 * Creates a blocked path
	 */
	public ItemPath createBlockedPath(){
		ItemPath itemPath = new ItemPath();
		itemPath.setCurrentState(new ItemInactive());
		return itemPath;
	}
	
	/**
	 * Creates undestructable wall 
	 */
	public UndestructibleWall createUndWall(){
		return new UndestructibleWall();
	}
}

//end BoardFactory