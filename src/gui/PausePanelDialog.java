package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PausePanelDialog extends JDialog{

	private MainWindow mainWindow;

	public PausePanelDialog(MainWindow mainWindow, boolean modal){
		super(mainWindow.getFrame(),modal);

		setLocationRelativeTo(mainWindow.getFrame());
		KeyListener keyListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					PausePanelDialog.this.mainWindow.pauseGame();
					setVisible(false);
					
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					PausePanelDialog.this.mainWindow.pauseGame();
					setVisible(false);
					
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					PausePanelDialog.this.mainWindow.pauseGame();
					setVisible(false);
					
				}
				
			}
		};
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		getContentPane().addKeyListener(keyListener);
		
		
		//TODO remove comments
		//setUndecorated(true);
		this.mainWindow = mainWindow;


		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100,50));
		panel.setBorder(null);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));


		JLabel lblPausee = new JLabel("Pause");
		lblPausee.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPausee);

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(100,150));
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));

		JButton btnNewButton = new JButton("Resume");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PausePanelDialog.this.mainWindow.pauseGame();
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton);

		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PausePanelDialog.this.mainWindow.saveGame();
			}
		});
		panel_1.add(btnSaveGame);

		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PausePanelDialog.this.mainWindow.loadGame();
			}
		});
		panel_1.add(btnLoadGame);

		Component verticalStrut = Box.createVerticalStrut(20);
		getContentPane().add(verticalStrut);

		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(100,50));
		getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));


		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String msg = "<html>Do you want to return to Main Menu?<br> All progress in game will be lost.</html>";

				int reply = JOptionPane.showConfirmDialog(PausePanelDialog.this.mainWindow.getFrame(),msg,"Exit Game",JOptionPane.YES_NO_OPTION);

				if(reply == JOptionPane.YES_OPTION)
				{
					setVisible(false);
					PausePanelDialog.this.setVisible(false);
					PausePanelDialog.this.mainWindow.gameEnded();
				}

			}
		});
		panel_4.add(btnMainMenu);
		
		
		this.setVisible(true);
		this.requestFocusInWindow();
		setLocationRelativeTo(this.mainWindow.getFrame());
	}

}
