package gui;

import model.GameModel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The Class GamePanel
 */
public class GamePanel extends JPanel implements KeyListener
{	
	/** Game refresh rate */
	private static final int REFRESH_RATE = 60;
	
	/** The game timer */
	private Timer refreshTimer;
	
	/** The key up. */
	private int keyUp = KeyEvent.VK_UP;
	
	/** The key down. */
	private int keyDown = KeyEvent.VK_DOWN;
	
	/** The key left. */
	private int keyLeft = KeyEvent.VK_LEFT;
	
	/** The key right. */
	private int keyRight = KeyEvent.VK_RIGHT;
	
	/** The key drop bomb. */
	private int keyDropBomb = KeyEvent.VK_SPACE;
	
	/** The key pauPause. */
	private int keyPause = KeyEvent.VK_ESCAPE;
	
	ActionListener gameTimerListener;

	private MainWindow mainWindow;
	
	//=============================================================
	
	public GamePanel(final MainWindow mainWindow)
	{
		GameModel.getInstance();		
		addKeyListener(this);
		this.mainWindow = mainWindow;
		
		gameTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				repaint();
				
				if(GameModel.getInstance().gameOver()){
					
					String exitGameMsg = "Exit Game?";
					int reply = JOptionPane.showConfirmDialog(mainWindow.getFrame(),exitGameMsg,"Exit Game",JOptionPane.YES_NO_OPTION);

					if(reply == JOptionPane.YES_OPTION)
					{
						setVisible(false);
					}
					else if(reply == JOptionPane.NO_OPTION || reply == JOptionPane.CLOSED_OPTION){}
					
					
					refreshTimer.stop();
				}
				
			}
		};
		refreshTimer = new Timer(REFRESH_RATE, gameTimerListener);
		refreshTimer.start();
	}
	
	/**
	 * Draw game state
	 */
	public void paintComponent(Graphics g) 
	{		
		super.paintComponent(g);
		GameModel.getInstance().draw(g, getWidth(), getHeight());
	}	
	
	@Override
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		
		if (!refreshTimer.isRunning())
		{
			if(key == keyPause) {
				refreshTimer.start();
				return;
			}
			return;
		}

		if(key == keyUp)
		{
			GameModel.getInstance().updateKeyUp();
		}
		else if(key == keyDown)
		{
			GameModel.getInstance().updateKeyDown();
		}
		else if (key == keyLeft)
		{
			GameModel.getInstance().updateKeyLeft();
		}
		else if(key == keyRight)
		{
			GameModel.getInstance().updateKeyRight();
		}
		else if(key == keyDropBomb)
		{
			GameModel.getInstance().getPlayers().dropBomb();
		}
		else if(key == keyPause)
		{
			refreshTimer.stop();
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		GameModel.getInstance().updateKeyReleased();
	}


	@Override
	public void keyTyped(KeyEvent e){}
}
