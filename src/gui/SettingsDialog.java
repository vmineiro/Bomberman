package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	KeyListener teclaPressionada;


	/**
	 * Create the dialog.
	 */
	public SettingsDialog(JFrame frame, boolean modal) {
		super(frame, modal);
		
		this.setTitle("Game Settings");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(panel);
			panel.add(keysPanel);
			keysPanel.setBorder(new TitledBorder(null, "Keyboard Settings ", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			keysPanel.setLayout(new BoxLayout(keysPanel, BoxLayout.X_AXIS));
			{
				JPanel player1 = new JPanel();
				player1.setBorder(new EmptyBorder(5, 5, 5, 5));
				keysPanel.add(player1);
				player1.setLayout(new GridLayout(7, 2, 2, 2));
				{
					JLabel lblP1 = new JLabel("Player 1");
					player1.add(lblP1);
				}
				{
					JLabel label = new JLabel("");
					player1.add(label);
				}
				{
					JLabel lblMoveUp = new JLabel("Move Up:");
					player1.add(lblMoveUp);
				}
				{
					upP1 = new JTextField();
					upP1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							teclaPressionada = new KeyListener() {
								
								@Override
								public void keyTyped(KeyEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void keyReleased(KeyEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void keyPressed(KeyEvent e) {
									novaTecla(upP1,e);			
								}
							};
						}
					});
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
				player2.setLayout(new GridLayout(7, 2, 2, 2));
				{
					JLabel lblP1 = new JLabel("Player 2");
					player2.add(lblP1);
				}
				{
					JLabel label = new JLabel("");
					player2.add(label);
				}
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
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
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
		
		this.pack();
		this.setLocationRelativeTo(frame);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	// TODO game mode
	private void novaTecla(JTextField tfld, KeyEvent e){
		
		tfld.setText(KeyEvent.getKeyText(e.getKeyCode()));
		tfld.setFocusable(false);
	}

}
