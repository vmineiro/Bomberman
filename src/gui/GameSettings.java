package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class GameSettings extends JDialog {


	private MainWindow mainWindow;

	/**
	 * Create the dialog.
	 * @param mainWindow 
	 * @param modal 
	 */
	public GameSettings(MainWindow mainWindow, boolean modal) {
		super(mainWindow.getFrame(),modal);
		
		this.mainWindow = mainWindow;
		
		setBounds(100, 100, 450, 350);
		setTitle("Game Settings");
		
		createWidgets();
		
		this.setVisible(true);
		
	}

	private void createWidgets() {
		
		JPanel contentPanel = new JPanel();
		
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		panel.add(lblDifficulty);
		
		String difficultyList[] = {"Easy", "Normal", "Hard"};
		JComboBox comboBox = new JComboBox(difficultyList);
		panel.add(comboBox);
		
		JSeparator separator = new JSeparator();
		contentPanel.add(separator);
		
		JPanel panel_8 = new JPanel();
		contentPanel.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_8.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPlayerController = new JLabel("Player 1 Controller");
		lblPlayerController.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblPlayerController);
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		
		JLabel label2PlayerController = new JLabel("Player 2 Controller");
		label2PlayerController.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(label2PlayerController);
		
		String keySelList[] = {"UP Arrow", "DOWN Arrow", "LEFT Arrow", "RIGHT Arrow", "ENTER", "W", "S", "A", "D", "SPACE"};
		
		JPanel panel_10 = new JPanel();
		contentPanel.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_10.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblUpKey = new JLabel("Up:");
		panel_3.add(lblUpKey);
		
		JComboBox comboBox_1 = new JComboBox(keySelList);
		panel_3.add(comboBox_1);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JLabel lblDown = new JLabel("Down:");
		panel_4.add(lblDown);
		
		JComboBox comboBox_2 = new JComboBox(keySelList);
		panel_4.add(comboBox_2);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		JLabel lblLeft = new JLabel("Left");
		panel_5.add(lblLeft);
		
		JComboBox comboBox_3 = new JComboBox(keySelList);
		panel_5.add(comboBox_3);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JLabel lblRight = new JLabel("Right");
		panel_6.add(lblRight);
		
		JComboBox comboBox_4 = new JComboBox(keySelList);
		panel_6.add(comboBox_4);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JLabel lblBomb = new JLabel("Bomb");
		panel_7.add(lblBomb);
		
		JComboBox comboBox_5 = new JComboBox(keySelList);
		panel_7.add(comboBox_5);
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.Y_AXIS));
		
		JPanel panel_12 = new JPanel();
		panel_11.add(panel_12);
		
		JLabel label = new JLabel("Up:");
		panel_12.add(label);
		
		JComboBox comboBox_6 = new JComboBox(keySelList);
		panel_12.add(comboBox_6);
		
		JPanel panel_13 = new JPanel();
		panel_11.add(panel_13);
		
		JLabel label_1 = new JLabel("Down:");
		panel_13.add(label_1);
		
		JComboBox comboBox_7 = new JComboBox(keySelList);
		panel_13.add(comboBox_7);
		
		JPanel panel_14 = new JPanel();
		panel_11.add(panel_14);
		
		JLabel label_2 = new JLabel("Left");
		panel_14.add(label_2);
		
		JComboBox comboBox_8 = new JComboBox(keySelList);
		panel_14.add(comboBox_8);
		
		JPanel panel_15 = new JPanel();
		panel_11.add(panel_15);
		
		JLabel label_3 = new JLabel("Right");
		panel_15.add(label_3);
		
		JComboBox comboBox_9 = new JComboBox(keySelList);
		panel_15.add(comboBox_9);
		
		JPanel panel_16 = new JPanel();
		panel_11.add(panel_16);
		
		JLabel label_4 = new JLabel("Bomb");
		panel_16.add(label_4);
		
		JComboBox comboBox_10 = new JComboBox(keySelList);
		panel_16.add(comboBox_10);
		
		JSeparator separator_1 = new JSeparator();
		contentPanel.add(separator_1);
		
		JPanel panel_17 = new JPanel();
		contentPanel.add(panel_17);
		panel_17.setLayout(new BoxLayout(panel_17, BoxLayout.X_AXIS));
		
		JPanel panel_18 = new JPanel();
		panel_17.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		JButton btnSaveSettings = new JButton("Save Settings");
		panel_18.add(btnSaveSettings);
		
		JPanel panel_19 = new JPanel();
		panel_17.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JButton btnDiscardSettings = new JButton("Discard Settings");
		panel_19.add(btnDiscardSettings);
	}

}
