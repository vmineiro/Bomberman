package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class MainMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MainMenu dialog = new MainMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MainMenu() {
		setBounds(100, 100, 225, 225);
		setTitle("Main Menu");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblBomberman = new JLabel("BOMBERMAN");
				panel.add(lblBomberman);
			}
		}
		{
			JSeparator separator = new JSeparator();
			contentPanel.add(separator);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnNewGame = new JButton("New Game");
				panel.add(btnNewGame);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnLoadGame = new JButton("Load Game");
				panel.add(btnLoadGame);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnGameSettings = new JButton("Game Settings");
				panel.add(btnGameSettings, BorderLayout.CENTER);
			}
		}
		{
			JSeparator separator = new JSeparator();
			contentPanel.add(separator);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnExitGame = new JButton("Exit Game");
				panel.add(btnExitGame, BorderLayout.CENTER);
			}
		}
	}

}
