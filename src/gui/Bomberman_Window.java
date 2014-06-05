package gui;

import java.awt.Container;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.BoxLayout;
import javax.swing.JMenuItem;

public class Bomberman_Window {

	/** The frame */
	private JFrame frame;

	/** The menu bar panel */ 
	private JPanel MenuBarPanel;

	/** The game panel */
	private JPanel GamePanel;

	/** The menu bar */
	private JMenuBar menuBar;
	private JMenu mnBomberman;
	private JMenuItem mntmLoadGame;
	private JMenuItem mntmSaveGame;
	private JMenuItem mntmGameSettings;
	private JMenuItem mntmExitGame;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try 
		{
			Bomberman_Window window = new Bomberman_Window();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Bomberman_Window() 
	{
		frame = new JFrame("BOMBERMAN");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(new BorderLayout(0,0));

		createWidgets();
		addWidgets(frame.getContentPane());

		//frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Creates the widgets
	 */
	private void createWidgets()
	{
		//Menu bar panel
		MenuBarPanel = new JPanel();
		MenuBarPanel.setLayout(new BoxLayout(MenuBarPanel, BoxLayout.X_AXIS));

		//Menu bar
		menuBar = new JMenuBar();

		//Menu Bomberman
		mnBomberman = new JMenu("Bomberman");

		//Load Game Option
		mntmLoadGame = new JMenuItem("Load Game");

		//Save Game Option
		mntmSaveGame = new JMenuItem("Save Game");

		//Game Settings Option
		mntmGameSettings = new JMenuItem("Game Settings");

		//Exit Game Option
		mntmExitGame = new JMenuItem("Exit Game");

		//Game Panel
		GamePanel = new JPanel();		

	}

	/**
	 * Add the widgets
	 * 
	 * @param cont the container
	 */
	private void addWidgets(Container cont)
	{
		mnBomberman.add(mntmLoadGame);
		mnBomberman.add(mntmSaveGame);
		mnBomberman.add(mntmGameSettings);
		mnBomberman.add(mntmExitGame);
		menuBar.add(mnBomberman);
		MenuBarPanel.add(menuBar);

		cont.add(MenuBarPanel, BorderLayout.NORTH);	
		cont.add(GamePanel, BorderLayout.CENTER);
	}
}
