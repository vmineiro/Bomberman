package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Bomberman_Window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bomberman_Window window = new Bomberman_Window();
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
	public Bomberman_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("BOMBERMAN");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel MenuBarPanel = new JPanel();
		frame.getContentPane().add(MenuBarPanel, BorderLayout.NORTH);
		MenuBarPanel.setLayout(new BoxLayout(MenuBarPanel, BoxLayout.X_AXIS));
		
		JMenuBar menuBar = new JMenuBar();
		MenuBarPanel.add(menuBar);
		
		JMenu mnBomberman = new JMenu("Bomberman");
		menuBar.add(mnBomberman);
		
		JMenuItem mntmLoadGame = new JMenuItem("Load Game");
		mnBomberman.add(mntmLoadGame);
		
		JMenuItem mntmSaveGame = new JMenuItem("Save Game");
		mnBomberman.add(mntmSaveGame);
		
		JMenuItem mntmGameSettings = new JMenuItem("Game Settings");
		mnBomberman.add(mntmGameSettings);
		
		JMenuItem mntmExitGame = new JMenuItem("Exit Game");
		mnBomberman.add(mntmExitGame);
		
		JPanel GamePanel = new JPanel();
		frame.getContentPane().add(GamePanel, BorderLayout.CENTER);
		GamePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBombermanPanel = new JLabel("Bomberman Panel - Displays Gameplay");
		lblBombermanPanel.setHorizontalAlignment(SwingConstants.CENTER);
		GamePanel.add(lblBombermanPanel);
	}

}
