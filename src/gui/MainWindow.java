package gui;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

import model.GameModel;

public class MainWindow {

	private JFrame frame;
	
	private MainMenuPanel mainMenu;
	
	/** The game panel */
	private GamePanel gamePanel;

	private GameSettings settingsPanel;
	
	

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
		frame.setBounds(200, 50, 700, 650);
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
		
		mainMenu = new MainMenuPanel(this);
		
		frame.getContentPane().add(mainMenu);
		
		mainMenu.requestFocusInWindow();
		
		frame.getContentPane().repaint();
		
	}



	public void startNewGame() {
		
		frame.getContentPane().removeAll();
		
		gamePanel = new GamePanel(this);
		
		frame.getContentPane().add(gamePanel);
		
		gamePanel.requestFocusInWindow();
		
		frame.getContentPane().repaint();
		
		
	}

	public void configSettings() {
		

		settingsPanel = new GameSettings(this,true);
		
		
	}

}
