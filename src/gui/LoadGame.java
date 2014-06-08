package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class LoadGame extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public LoadGame() {
		setBounds(100, 100, 200, 175);
		setTitle("Load Game");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		contentPanel.add(panel_1);
		
		String loadGameList[] = {"Rodolfo's Game", "Vitor's Game", "Daniel's Game"};
		JComboBox comboBox = new JComboBox(loadGameList); 
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		contentPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnLoadGame = new JButton("Load Game");
		panel_2.add(btnLoadGame);
		
		JSeparator separator = new JSeparator();
		contentPanel.add(separator);
		
		JPanel panel_4 = new JPanel();
		contentPanel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JButton btnReturnToMain = new JButton("Return to Main Menu");
		panel_4.add(btnReturnToMain);
	}

}
