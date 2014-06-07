package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class SettingsDialog extends JDialog {

	private final JPanel keysPanel = new JPanel();
	private JTextField upP1;
	private JTextField upP2;
	private JTextField leftP1;
	private JTextField downP1;
	private JTextField rightP1;
	private JTextField dropBombP1;
	private JTextField detonateBombP1;
	private JTextField detonateBombP2;
	private JTextField dropBombP2;
	private JTextField rightP2;
	private JTextField downP2;
	private JTextField leftP2;


	/**
	 * Create the dialog.
	 */
	public SettingsDialog() {
		this.setTitle("Game Settings");
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(keysPanel, BorderLayout.CENTER);
		keysPanel.setLayout(new BoxLayout(keysPanel, BoxLayout.X_AXIS));
		{
			JPanel player1 = new JPanel();
			player1.setBorder(new EmptyBorder(5, 5, 5, 5));
			keysPanel.add(player1);
			player1.setLayout(new GridLayout(6, 2, 2, 2));
			{
				JLabel lblMoveUp = new JLabel("Move Up:");
				player1.add(lblMoveUp);
			}
			{
				upP1 = new JTextField();
				player1.add(upP1);
				upP1.setColumns(5);
			}
			{
				JLabel lblMoveLeft = new JLabel("Move Left:");
				player1.add(lblMoveLeft);
			}
			{
				leftP1 = new JTextField();
				player1.add(leftP1);
				leftP1.setColumns(5);
			}
			{
				JLabel lblMoveDown = new JLabel("Move Down:");
				player1.add(lblMoveDown);
			}
			{
				downP1 = new JTextField();
				player1.add(downP1);
				downP1.setColumns(5);
			}
			{
				JLabel lblMoveRight = new JLabel("Move Right:");
				player1.add(lblMoveRight);
			}
			{
				rightP1 = new JTextField();
				player1.add(rightP1);
				rightP1.setColumns(5);
			}
			{
				JLabel lblDropBomb = new JLabel("Drop Bomb:");
				player1.add(lblDropBomb);
			}
			{
				dropBombP1 = new JTextField();
				player1.add(dropBombP1);
				dropBombP1.setColumns(5);
			}
			{
				JLabel lblDetonateBomb = new JLabel("Detonate Bomb:");
				player1.add(lblDetonateBomb);
			}
			{
				detonateBombP1 = new JTextField();
				player1.add(detonateBombP1);
				detonateBombP1.setColumns(6);
			}
		}
		{
			JSeparator separator = new JSeparator();
			keysPanel.add(separator);
			separator.setOrientation(SwingConstants.VERTICAL);
		}
		{
			JPanel player2 = new JPanel();
			player2.setBorder(new EmptyBorder(5, 5, 5, 5));
			keysPanel.add(player2);
			player2.setLayout(new GridLayout(6, 2, 2, 2));
			{
				JLabel lblMoveUp_1 = new JLabel("Move Up");
				player2.add(lblMoveUp_1);
			}
			{
				upP2 = new JTextField();
				player2.add(upP2);
				upP2.setColumns(5);
			}
			{
				JLabel lblMoveLeft = new JLabel("Move Left:");
				player2.add(lblMoveLeft);
			}
			{
				leftP2 = new JTextField();
				player2.add(leftP2);
				leftP2.setColumns(5);
			}
			{
				JLabel lblMoveDown = new JLabel("Move Down:");
				player2.add(lblMoveDown);
			}
			{
				downP2 = new JTextField();
				player2.add(downP2);
				downP2.setColumns(5);
			}
			{
				JLabel lblMoveRight = new JLabel("Move Right:");
				player2.add(lblMoveRight);
			}
			{
				rightP2 = new JTextField();
				player2.add(rightP2);
				rightP2.setColumns(5);
			}
			{
				JLabel lblDropBomb = new JLabel("Drop Bomb:");
				player2.add(lblDropBomb);
			}
			{
				dropBombP2 = new JTextField();
				player2.add(dropBombP2);
				dropBombP2.setColumns(5);
			}
			{
				JLabel lblDetonateBomb = new JLabel("Detonate Bomb:");
				player2.add(lblDetonateBomb);
			}
			{
				detonateBombP2 = new JTextField();
				player2.add(detonateBombP2);
				detonateBombP2.setColumns(5);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel keyboardLblPanel = new JPanel();
			getContentPane().add(keyboardLblPanel, BorderLayout.NORTH);
			keyboardLblPanel.setLayout(new BoxLayout(keyboardLblPanel, BoxLayout.Y_AXIS));
		}
		
		this.pack();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
