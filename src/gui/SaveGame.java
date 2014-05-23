package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;

public class SaveGame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSavedGameName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SaveGame dialog = new SaveGame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SaveGame() {
		setBounds(100, 100, 325, 175);
		setTitle("Save Game");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			
			JLabel lblSavedGame = new JLabel("Enter Saved Game Name:");
			panel.add(lblSavedGame);
			
			txtSavedGameName = new JTextField();
			txtSavedGameName.setText("Saved Game Name");
			panel.add(txtSavedGameName);
			txtSavedGameName.setColumns(10);
		}
		
		JPanel panel = new JPanel();
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnSaveGame = new JButton("Save Game");
		panel.add(btnSaveGame);
		
		JSeparator separator = new JSeparator();
		contentPanel.add(separator);
		
		JPanel panel_1 = new JPanel();
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnRetMainMenu = new JButton("Return to Main Menu");
		panel_1.add(btnRetMainMenu);
	}

}
