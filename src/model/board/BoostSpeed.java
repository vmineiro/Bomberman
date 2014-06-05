package model.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import model.GameModel;
import model.monster.Monster;
import model.player.Player;

/**
 *The Boost Speed class
 */
public class BoostSpeed extends Item {


	BufferedImage boostSpeedlImg;


	public BoostSpeed(){
		super();
		
		try {
			
			boostSpeedlImg = ImageIO.read(new File("img/wall01.png"));
	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setCurrentState(new ItemHidden());
		
	}

	/* (non-Javadoc)
	 * @see model.Item#finalize()
	 */
	public void finalize() throws Throwable {
		
		super.finalize();
	}


	/**
	 * Manages the visit by the player.
	 *
	 * @param player the player
	 */
	@Override
	public void accept(Player player){

		if (this.state.getClass() == ItemHidden.class || this.hasBomb) return;

		setCurrentState(this.state.pickUp());
			
		player.visitBoostSpeed(this);
	}

	
	
	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	@Override
	public void accept(Monster monster){
		
		monster.visitBoostSpeed(this);
	}

	@Override
	public void setCurrentState(ItemState state) {
		this.state = state;

		if (this.state.getClass() == ItemHidden.class) {
			setAnimation(wallImg);
		} else if (this.state.getClass() == ItemDetonating.class || this.state.getClass() == ItemExploding.class) {
			setAnimation(explosionImg);
		} else {
			setAnimation(boostSpeedlImg);
		}
		
	}



}//end BoostSpeed