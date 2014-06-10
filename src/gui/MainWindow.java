package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.GameModel;


/**
 * The Class MainWindow.
 */
public class MainWindow {

	/** The frame. */
	private JFrame frame;
	
	/** The main menu. */
	private MainMenuPanel mainMenu;
	
	/**  The game panel. */
	private GamePanel gamePanel;

	/** The pause panel. */
	private PausePanelDialog pausePanel;
	
	/**  The game timer. */
	private Timer refreshTimer;
	
	/**  Game refresh rate. */
	private static final int REFRESH_RATE = 60;
	
	/** The game timer listener. */
	private ActionListener gameTimerListener;
	
	/** The file chooser. */
	private JFileChooser fileChooser;
	

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 50, 500, 450);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		
		
		gotoMainMenu();	

		
	}
	
	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Goto main menu.
	 */
	public void gotoMainMenu() {
		
		frame.getContentPane().removeAll();
		
		mainMenu = new MainMenuPanel(this);
		
		frame.getContentPane().add(mainMenu);
		
		mainMenu.requestFocusInWindow();
		
		frame.getContentPane().repaint();
		
	}
	
	/**
	 * Start new game.
	 */

	public void startNewGame() {
		
		frame.getContentPane().removeAll();
		
		GameModel.getInstance().initGame();
		
		gamePanel = new GamePanel(this);
		
		gameTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				
				GameModel.getInstance().update();
				gamePanel.repaint();
				
				if(GameModel.getInstance().gameOver()){
				
					gameEnded();
					
				}
				
			}
		};
		
		refreshTimer = new Timer(REFRESH_RATE, gameTimerListener);
		refreshTimer.start();
		
		frame.getContentPane().add(gamePanel);
		
		gamePanel.requestFocusInWindow();
		
		frame.getContentPane().repaint();
		
	}


	/**
	 * Config settings.
	 */
	public void configSettings() {
		
		if (gamePanel == null) {
			gamePanel = new GamePanel(this);
		}
		
		new SettingsDialog(this.frame,true, gamePanel);
		
	}

	/**
	 * Pause game.
	 */
	public void pauseGame() {
		
		if (refreshTimer.isRunning()){
			refreshTimer.stop();
			pausePanel = new PausePanelDialog(this,true);
			pausePanel.requestFocusInWindow();
		}
		else {
			gamePanel.requestFocusInWindow();
			refreshTimer.start();
			
		}
		
	}

	/**
	 * Checks if is running.
	 *
	 * @return true, if is running
	 */
	public boolean isRunning() {
		return refreshTimer.isRunning();
	}

	/**
	 * Run game.
	 */
	public void runGame() {
		refreshTimer.start();		
	}
	
	
	/**
	 * Game ended.
	 */
	public void gameEnded(){
		
		if (GameModel.getInstance().getMonsters().size() == 0){
			JOptionPane.showMessageDialog(frame,"You WIN!");
		} else {
			JOptionPane.showMessageDialog(frame,"You LOST!");
		}
		
		refreshTimer.stop();
		gamePanel.setVisible(false);
		GameModel.getInstance().resetGameModel();
		GameModel.getInstance();
		GameModel.getInstance().initGame();
		gotoMainMenu();
		
	}
	
	/**
	 * Load board
	 */
	public void loadBoard() {
		
		frame.getContentPane().removeAll();

		GameModel.getInstance().initGame();

		gamePanel = new GamePanel(this);

		gameTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				
				GameModel.getInstance().update();
				gamePanel.repaint();

				if(GameModel.getInstance().gameOver()){

					gameEnded();

				}

			}
		};	
		
		frame.getContentPane().add(gamePanel);
		gamePanel.requestFocusInWindow();
		frame.getContentPane().repaint();
		
		FileFilter filter = new FileNameExtensionFilter("Game files only", "txt");
		
		fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileFilter(filter);
		
		int returnVal = fileChooser.showOpenDialog(frame.getContentPane());
		
		if (returnVal == JFileChooser.APPROVE_OPTION){
			
			String path = fileChooser.getSelectedFile().getAbsolutePath();
			
			try {
				GameModel.getInstance().readBoardFile(path);
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(frame,"Error while loading the game");
				e1.printStackTrace();
			}
		}
		
		refreshTimer = new Timer(REFRESH_RATE, gameTimerListener);
		refreshTimer.start();		
	}
	
	
	/**
	 * Load game.
	 */
	public void loadGame() {
		
		frame.getContentPane().removeAll();

		GameModel.getInstance().initGame();

		gamePanel = new GamePanel(this);

		gameTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				
				GameModel.getInstance().update();
				gamePanel.repaint();

				if(GameModel.getInstance().gameOver()){

					gameEnded();

				}

			}
		};	
		
		frame.getContentPane().add(gamePanel);
		gamePanel.requestFocusInWindow();
		frame.getContentPane().repaint();
		
		FileFilter filter = new FileNameExtensionFilter("Game files only", "ser");
		
		fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileFilter(filter);
		
		int returnVal = fileChooser.showOpenDialog(frame.getContentPane());
		
		if (returnVal == JFileChooser.APPROVE_OPTION){
			
			String path = fileChooser.getSelectedFile().getAbsolutePath();
			
			try {
				GameModel.getInstance().loadGame(path);
			} catch (ClassNotFoundException | IOException e1) {
				JOptionPane.showMessageDialog(frame,"Error while loading the game");
				e1.printStackTrace();
			}
		}	
		
		refreshTimer = new Timer(REFRESH_RATE, gameTimerListener);
		refreshTimer.start();
	}

	/**
	 * Save game.
	 */
	public void saveGame() {
			
		FileFilter filter = new FileNameExtensionFilter("Game files only", "ser");
		
		fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileFilter(filter);
		
		int returnVal = fileChooser.showSaveDialog(frame.getContentPane());
		
		if (returnVal == JFileChooser.APPROVE_OPTION){
			
			String path = fileChooser.getSelectedFile().getAbsolutePath() + ".ser";
			
			try {
				GameModel.getInstance().saveGame(path);
				JOptionPane.showMessageDialog(frame,"Game Saved");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(frame,"Error while saving the game");
				e1.printStackTrace();
			}
			
		}
		
	}


}
