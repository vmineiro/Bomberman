package gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

/**
 * The Class GameType.
 */
public class GameType extends JDialog {

	/** The content panel. */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public GameType() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 200, 175);
		setTitle("Game Type");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewGame = new JLabel("Select Game Type:");
				panel.add(lblNewGame);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnNormalGame = new JButton("Normal Game");
				panel.add(btnNormalGame);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnBattleGame = new JButton("Battle Game");
				panel.add(btnBattleGame);
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
				JButton btnReturnToMain = new JButton("Return to Main Menu");
				panel.add(btnReturnToMain);
			}
		}
	}

}
