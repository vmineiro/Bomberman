package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;

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
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import model.GameModel;


public class MainMenuPanel extends JPanel {
	
	private boolean newGame = false;
	
	private boolean loadGame = false;
	
	private boolean configSettings = false;
	
	private MainWindow mainWindow;
	
	private JFileChooser loadFileChooser;
	

	/**
	 * Create the dialog.
	 */
	public MainMenuPanel(final MainWindow mainWindow)  {
		
		super();
		this.mainWindow = mainWindow;
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(75, 225, 100, 225));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		{
			JPanel panel = new JPanel();
			this.add(panel);
			{
				JLabel lblBomberman = new JLabel("BOMBERMAN");
				lblBomberman.setFont(new Font("Courier New", Font.TRUETYPE_FONT, 40));
				panel.add(lblBomberman);
			}
		}
		{
			this.add(Box.createVerticalStrut(50));
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
						newGame = true;
						loadGame = false;
						configSettings = false;
						
						setVisible(false);
						mainWindow.startNewGame();
						
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
						
						
//						JButton btnLoadGame = new JButton("Load Game");
						
						loadFileChooser = new JFileChooser();
						loadFileChooser.setMultiSelectionEnabled(false);
						loadFileChooser.showOpenDialog(mainWindow.getFrame().getContentPane());
								
						String path = loadFileChooser.getSelectedFile().getAbsolutePath();
						
						
						//TODO add path to loadGame() call
//						GameModel.getInstance().loadGame();
						
						setVisible(false);
						
						mainWindow.startNewGame();
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
						newGame = false;
						loadGame = false;
						configSettings = true;
						setVisible(false);
					}
				});
				panel.add(btnGameSettings, BorderLayout.CENTER);
			}
		}
		{
			this.add(Box.createVerticalStrut(75));
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
						newGame = false;
						loadGame = false;
						configSettings = false;
						
						String exitGameMsg = "Exit Game?";
						int reply = JOptionPane.showConfirmDialog(mainWindow.getFrame(),exitGameMsg,"Exit Game",JOptionPane.YES_NO_OPTION);

						if(reply == JOptionPane.YES_OPTION)
						{
							mainWindow.getFrame().getContentPane().setVisible(false);
							System.exit(0);
						}
						else if(reply == JOptionPane.NO_OPTION || reply == JOptionPane.CLOSED_OPTION){}

						mainWindow.getFrame().getContentPane().requestFocusInWindow();

					}
				});
				panel.add(btnExitGame, BorderLayout.CENTER);
			}
		}
	}
	
}
