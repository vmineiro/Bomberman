package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;


/**
 * The Class PausePanelDialog.
 */
public class PausePanelDialog extends JDialog{

	/** The main window. */
	private MainWindow mainWindow;

	/**
	 * Instantiates a new pause panel dialog.
	 *
	 * @param mainWindow the main window
	 * @param modal the modal
	 */
	public PausePanelDialog(MainWindow mainWindow, boolean modal){
		super(mainWindow.getFrame(),modal);

		setUndecorated(true);
		this.mainWindow = mainWindow;
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(150, 270));
		getContentPane().add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setPreferredSize(new Dimension(100,50));
		panel.setBorder(null);
		panel.setLayout(new GridLayout(0, 1, 0, 0));


		JLabel lblPausee = new JLabel("Pause");
		panel.add(lblPausee);
		lblPausee.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		panel_1.setPreferredSize(new Dimension(100,150));
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));

		JButton btnNewButton = new JButton("Resume");
		panel_1.add(btnNewButton);

		JButton btnSaveGame = new JButton("Save Game");
		panel_1.add(btnSaveGame);

		JButton btnLoadGame = new JButton("Load Game");
		panel_1.add(btnLoadGame);
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PausePanelDialog.this.mainWindow.loadGame();
			}
		});
		btnSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PausePanelDialog.this.mainWindow.saveGame();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PausePanelDialog.this.mainWindow.pauseGame();
				setVisible(false);
			}
		});

		Component verticalStrut = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setPreferredSize(new Dimension(100,50));
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

		this.pack();
		setLocationRelativeTo(mainWindow.getFrame());
		this.setVisible(true);
		this.requestFocusInWindow();
		setLocationRelativeTo(this.mainWindow.getFrame());
	}

}
