package model.board;

import model.monster.Monster;
import model.player.Player;



/**
 * The Class Path.
 */
public class ItemPath extends Item {
	

	
	/**
	 * Instantiates a new path.
	 */
	public ItemPath(){
		
		super();

		setCurrentState(new ItemHidden());
		
	}



	/**
	 * Accept.
	 *
	 * @param player the player
	 */
	public void accept(Player player){
		
		if (this.state.getClass() == ItemHidden.class  || this.bomb != null) return;
		
		player.visitPath(this);


	}

	
	
	/**
	 * Accept.
	 *
	 * @param monster the monster
	 */
	public void accept(Monster monster){

		if (this.state.getClass() == ItemHidden.class  || this.bomb != null) return;
		
		monster.visitPath(this);
		
	}

	
	
	/* (non-Javadoc)
	 * @see model.board.Item#setCurrentState(model.board.ItemState)
	 */
	@Override
	public void setCurrentState(ItemState state) {
		this.state = state;

		if (this.state.getClass() == ItemHidden.class) {
			setAnimation(wallImg);
		} else if (this.state.getClass() == ItemDetonating.class || this.state.getClass() == ItemExploding.class) {
			setAnimation(explosionImg);
		} else {
			setAnimation(pathImg);
		}
		
	}

	
	
}//end Path