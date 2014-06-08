package gui;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.GameModel;

public class MainWindow {

	private JFrame frame;
	
	private MainMenuPanel mainMenu;
	
	/** The game panel */
	private GamePanel gamePanel;

	private SettingsDialog settingsPanel;

	private PausePanelDialog pausePanel;
	
	/** The game timer */
	private Timer refreshTimer;
	
	/** Game refresh rate */
	private static final int REFRESH_RATE = 60;
	
	private ActionListener gameTimerListener;
	
	private JFileChooser fileChooser;
	

	/**
	 * Launch the application.
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
		
		
		GameModel.getInstance();
		
		gotoMainMenu();	

		
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void gotoMainMenu() {
		
		frame.getContentPane().removeAll();
		
		mainMenu = new MainMenuPanel(this);
		
		frame.getContentPane().add(mainMenu);
		
		mainMenu.requestFocusInWindow();
		
		frame.getContentPane().repaint();
		
	}



	public void startNewGame() {
		
		frame.getContentPane().removeAll();
		
		//TODO integrate game model
		GameModel.getInstance().initGame(1);
		
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

	public void configSettings() {
		
		if (gamePanel == null) {
			gamePanel = new GamePanel(this);
		}
		
		settingsPanel = new SettingsDialog(this.frame,true, gamePanel);
		
	}

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

	public boolean isRunning() {
		return refreshTimer.isRunning();
	}

	public void runGame() {
		refreshTimer.start();		
	}
	
	
	public void gameEnded(){
		
		if (GameModel.getInstance().getMonsters().size() == 0){
			JOptionPane.showMessageDialog(frame,"You WIN!");
		} else {
			JOptionPane.showMessageDialog(frame,"You LOST!");
		}
		
		refreshTimer.stop();
		gamePanel.setVisible(false);
		gotoMainMenu();
		
	}
	
	
	public void loadGame() {
		
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
			}

			// TODO load the game
			startNewGame();
		}
		
	}

	public void saveGame() {
			
		FileFilter filter = new FileNameExtensionFilter("Game files only", "ser");
		
		fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileFilter(filter);
		
		int returnVal = fileChooser.showSaveDialog(frame.getContentPane());
		
		if (returnVal == JFileChooser.APPROVE_OPTION){
			
			String path = fileChooser.getSelectedFile().getAbsolutePath();

			try {
				GameModel.getInstance().saveGame(path);
				JOptionPane.showMessageDialog(frame,"Game Saved");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(frame,"Error while saving the game");
			}
			
		}
		
	}


}
