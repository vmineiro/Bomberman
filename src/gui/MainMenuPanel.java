package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import model.GameModel;



/**
 * The Class MainMenuPanel.
 */
public class MainMenuPanel extends JPanel {
	
	/** The new game. */
	private boolean newGame = false;
	
	/** The load game. */
	private boolean loadGame = false;
	
	/** The config settings. */
	private boolean configSettings = false;
	
	/** The main window. */
	private MainWindow mainWindow;
	


	/**
	 * Create the dialog.
	 *
	 * @param mainWindow the main window
	 */
	public MainMenuPanel(final MainWindow mainWindow)  {
		
		super();
		this.mainWindow = mainWindow;
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(25, 50, 25, 50));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		{
			JPanel panel = new JPanel();
			this.add(panel);
			{
				JLabel lblBomberman = new JLabel("BOMBERMAN");
				lblBomberman.setFont(new Font("Courier New", Font.TRUETYPE_FONT, 20));
				panel.add(lblBomberman);
			}
		}
		{
			this.add(Box.createVerticalStrut(20));
		}
		{
			JPanel panel = new JPanel();
			this.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnNewGame = new JButton("New Game");
				btnNewGame.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						setVisible(false);
						MainMenuPanel.this.mainWindow.startNewGame();
						
					}
				});
				panel.add(btnNewGame);
			}
		}
		{
			JPanel panel = new JPanel();
			this.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnLoadGame = new JButton("Load Game");
				btnLoadGame.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
											
						MainMenuPanel.this.mainWindow.loadGame();
						
					}
				});
				panel.add(btnLoadGame);
			}
		}
		{
			JPanel panel = new JPanel();
			this.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnGameSettings = new JButton("Game Settings");
				btnGameSettings.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					
						MainMenuPanel.this.mainWindow.configSettings();
					}
				});
				panel.add(btnGameSettings, BorderLayout.CENTER);
			}
		}
		{
			this.add(Box.createVerticalStrut(25));
		}
		{
			JPanel panel = new JPanel();
			this.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnExitGame = new JButton("Exit Game");
				btnExitGame.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
				
						String msg = "Exit Game?";
						
						int reply = JOptionPane.showConfirmDialog(MainMenuPanel.this.mainWindow.getFrame(),msg,"Exit Game",JOptionPane.YES_NO_OPTION);

						if(reply == JOptionPane.YES_OPTION)
						{
							MainMenuPanel.this.mainWindow.getFrame().getContentPane().setVisible(false);
							System.exit(0);
						}
					}
				});
				panel.add(btnExitGame, BorderLayout.CENTER);
			}
		}
	}
	
}
