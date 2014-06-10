package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


/**
 * The Class SettingsDialog.
 */
public class SettingsDialog extends JDialog {

	/** The keys panel. */
	private JPanel keysPanel = new JPanel();
	
	//TODO:
	private JPanel boardPanel;
	private JList boardList;
	private JLabel boardName;
	private JScrollPane boardScroller;
	
	/** The new settings. */
	private boolean newSettings = false;
	
	/** The up p1. */
	private JTextField upP1;
	
	/** The selected up key. */
    private int upKeyP1;
    
    /** The selected down key. */
    private int downKeyP1;
    
    /** The selected left key. */
    private int leftKeyP1;
    
    /** The selected right key. */
    private int rightKeyP1;
    
    /** The drop bomb key. */
    private int bombKeyP1;
    
    /** The drop bomb key. */
    private int explodeBombKeyP1;
    
	/** The explode bomb key p2. */
	private int explodeBombKeyP2;

	/** The bomb key p2. */
	private int bombKeyP2;

	/** The right key p2. */
	private int rightKeyP2;

	/** The down key p2. */
	private int downKeyP2;

	/** The left key p2. */
	private int leftKeyP2;

	/** The up key p2. */
	private int upKeyP2;
    
	/** The left p1. */
	private JTextField leftP1;
	
	/** The down p1. */
	private JTextField downP1;
	
	/** The right p1. */
	private JTextField rightP1;
	
	/** The drop bomb p1. */
	private JTextField dropBombP1;
	
	/** The detonate bomb p1. */
	private JTextField detonateBombP1;
	
	/** The up p2. */
	private JTextField upP2;
	
	/** The detonate bomb p2. */
	private JTextField detonateBombP2;
	
	/** The drop bomb p2. */
	private JTextField dropBombP2;
	
	/** The right p2. */
	private JTextField rightP2;
	
	/** The down p2. */
	private JTextField downP2;
	
	/** The left p2. */
	private JTextField leftP2;

	/** The game panel. */
	private GamePanel gamePanel;
	
	public void createWidgets(){
		boardPanel = new JPanel();
		
		boardName = new JLabel("Select board: ");
		
		String[] data = {"Board 1", "Board 2"};
		boardList = new JList(data);
		boardList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		boardList.setLayoutOrientation(JList.VERTICAL);
		boardList.setVisibleRowCount(-1);
		
		boardScroller = new JScrollPane(boardList);
		boardScroller.setPreferredSize(new Dimension(100, 80));
		
	}
	
	public void addWidgets(Container cont){
		boardPanel.add(boardName);
		boardPanel.add(boardScroller);
		cont.add(boardPanel);
	}

	/**
	 * Create the dialog.
	 *
	 * @param frame the frame
	 * @param modal the modal
	 * @param gamePanel the game panel
	 */
	public SettingsDialog(JFrame frame, boolean modal, GamePanel gamePanel) {
		super(frame, modal);
		this.gamePanel = gamePanel;
		
		loadGameSettings();
		
		this.setTitle("Game Settings");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		//TODO:
		createWidgets();
		addWidgets(getContentPane());
		
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
					JButton lblMoveUp = new JButton("Move Up:");
					lblMoveUp.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							upKeyP1 = e.getKeyCode();
							upP1.setText(KeyEvent.getKeyText(upKeyP1));
							
						}
					});
					player1.add(lblMoveUp);
				}
				{
					upP1 = new JTextField();
					upP1.setEnabled(false);
					upP1.setText(KeyEvent.getKeyText(upKeyP1));
					player1.add(upP1);
					upP1.setColumns(5);
				}
				{
					JButton lblMoveLeft = new JButton("Move Left:");
					lblMoveLeft.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							leftKeyP1 = e.getKeyCode();
							leftP1.setText(KeyEvent.getKeyText(leftKeyP1));
							
						}
					});
					player1.add(lblMoveLeft);
				}
				{
					leftP1 = new JTextField();
					leftP1.setEnabled(false);
					leftP1.setText(KeyEvent.getKeyText(leftKeyP1));
					player1.add(leftP1);
					leftP1.setColumns(5);
				}
				{
					JButton lblMoveDown = new JButton("Move Down:");
					lblMoveDown.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							downKeyP1 = e.getKeyCode();
							downP1.setText(KeyEvent.getKeyText(downKeyP1));
							
						}
					});
					player1.add(lblMoveDown);
				}
				{
					downP1 = new JTextField();
					downP1.setEnabled(false);
					downP1.setText(KeyEvent.getKeyText(downKeyP1));
					player1.add(downP1);
					downP1.setColumns(5);
				}
				{
					JButton lblMoveRight = new JButton("Move Right:");
					lblMoveRight.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							rightKeyP1 = e.getKeyCode();
							rightP1.setText(KeyEvent.getKeyText(rightKeyP1));
							
						}
					});
					player1.add(lblMoveRight);
				}
				{
					rightP1 = new JTextField();
					rightP1.setEnabled(false);
					rightP1.setText(KeyEvent.getKeyText(rightKeyP1));
					player1.add(rightP1);
					rightP1.setColumns(5);
				}
				{
					JButton lblDropBomb = new JButton("Drop Bomb:");
					lblDropBomb.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							bombKeyP1= e.getKeyCode();
							dropBombP1.setText(KeyEvent.getKeyText(bombKeyP1));
							
						}
					});
					player1.add(lblDropBomb);
				}
				{
					dropBombP1 = new JTextField();
					dropBombP1.setEnabled(false);
					dropBombP1.setText(KeyEvent.getKeyText(bombKeyP1));
					player1.add(dropBombP1);
					dropBombP1.setColumns(5);
				}
				{
					JButton lblDetonateBomb = new JButton("Detonate Bomb:");
					lblDetonateBomb.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							explodeBombKeyP1 = e.getKeyCode();
							detonateBombP1.setText(KeyEvent.getKeyText(explodeBombKeyP1));
							
						}
					});
					player1.add(lblDetonateBomb);
				}
				{
					detonateBombP1 = new JTextField();
					detonateBombP1.setEnabled(false);
					detonateBombP1.setText(KeyEvent.getKeyText(explodeBombKeyP1));				
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
					JLabel lblP2 = new JLabel("Player 1");
					player2.add(lblP2);
				}
				{
					JLabel label = new JLabel("");
					player2.add(label);
				}
				{
					JButton lblMoveUp = new JButton("Move Up:");
					lblMoveUp.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							upKeyP2 = e.getKeyCode();
							upP2.setText(KeyEvent.getKeyText(upKeyP2));
							
						}
					});
					player2.add(lblMoveUp);
				}
				{
					upP2 = new JTextField();
					upP2.setEnabled(false);
					upP2.setText(KeyEvent.getKeyText(upKeyP2));
					player2.add(upP2);
					upP2.setColumns(5);
				}
				{
					JButton lblMoveLeft = new JButton("Move Left:");
					lblMoveLeft.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							leftKeyP2 = e.getKeyCode();
							leftP2.setText(KeyEvent.getKeyText(leftKeyP2));
							
						}
					});
					player2.add(lblMoveLeft);
				}
				{
					leftP2 = new JTextField();
					leftP2.setEnabled(false);
					leftP2.setText(KeyEvent.getKeyText(leftKeyP2));
					player2.add(leftP2);
					leftP2.setColumns(5);
				}
				{
					JButton lblMoveDown = new JButton("Move Down:");
					lblMoveDown.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							downKeyP2 = e.getKeyCode();
							downP2.setText(KeyEvent.getKeyText(downKeyP2));
							
						}
					});
					player2.add(lblMoveDown);
				}
				{
					downP2 = new JTextField();
					downP2.setEnabled(false);
					downP2.setText(KeyEvent.getKeyText(downKeyP2));
					player2.add(downP2);
					downP2.setColumns(5);
				}
				{
					JButton lblMoveRight = new JButton("Move Right:");
					lblMoveRight.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							rightKeyP2 = e.getKeyCode();
							rightP2.setText(KeyEvent.getKeyText(rightKeyP2));
							
						}
					});
					player2.add(lblMoveRight);
				}
				{
					rightP2 = new JTextField();
					rightP2.setEnabled(false);
					rightP2.setText(KeyEvent.getKeyText(rightKeyP2));
					player2.add(rightP2);
					rightP2.setColumns(5);
				}
				{
					JButton lblDropBomb = new JButton("Drop Bomb:");
					lblDropBomb.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							bombKeyP2= e.getKeyCode();
							dropBombP2.setText(KeyEvent.getKeyText(bombKeyP2));
							
						}
					});
					player2.add(lblDropBomb);
				}
				{
					dropBombP2 = new JTextField();
					dropBombP2.setEnabled(false);
					dropBombP2.setText(KeyEvent.getKeyText(bombKeyP2));
					player2.add(dropBombP2);
					dropBombP2.setColumns(5);
				}
				{
					JButton lblDetonateBomb = new JButton("Detonate Bomb:");
					lblDetonateBomb.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							keysPanel.repaint();
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							explodeBombKeyP2 = e.getKeyCode();
							detonateBombP2.setText(KeyEvent.getKeyText(explodeBombKeyP2));
							
						}
					});
					player2.add(lblDetonateBomb);
				}
				{
					detonateBombP2 = new JTextField();
					detonateBombP2.setEnabled(false);
					detonateBombP2.setText(KeyEvent.getKeyText(explodeBombKeyP2));				
					player2.add(detonateBombP2);
					detonateBombP2.setColumns(6);
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
				okButton.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {}
					
					@Override
					public void mousePressed(MouseEvent e) {}
					
					@Override
					public void mouseExited(MouseEvent e) {}
					
					@Override
					public void mouseEntered(MouseEvent e) {}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						setNewSettings();
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {}
					
					@Override
					public void mousePressed(MouseEvent e) {}
					
					@Override
					public void mouseExited(MouseEvent e) {}
					
					@Override
					public void mouseEntered(MouseEvent e) {}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						setNewSettings(false);
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		this.pack();
		this.setLocationRelativeTo(frame);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}




	/**
	 * Load game settings.
	 */
	private void loadGameSettings() {
	
		
	    upKeyP1 = gamePanel.getKeyUpP1();
	    downKeyP1 = gamePanel.getKeyDownP1();
	    leftKeyP1 = gamePanel.getKeyLeftP1();
	    rightKeyP1 = gamePanel.getKeyRightP1();
	    bombKeyP1 = gamePanel.getKeyDropBombP1();
	    explodeBombKeyP1 = gamePanel.getKeyExploBombP1();
    
		explodeBombKeyP2 = gamePanel.getKeyExploBombP2();
		bombKeyP2 = gamePanel.getKeyDropBombP2();
		rightKeyP2 = gamePanel.getKeyRightP2();
		downKeyP2 = gamePanel.getKeyDownP2();
		leftKeyP2 = gamePanel.getKeyLeftP2();
		upKeyP2 = gamePanel.getKeyUpP2();
		
	}


	/**
	 * Sets the new settings.
	 */
	private void setNewSettings() {
	    gamePanel.setKeyUpP1(upKeyP1);
	    gamePanel.setKeyDownP1(downKeyP1);
	    gamePanel.setKeyLeftP1(leftKeyP1);
	    gamePanel.setKeyRightP1(rightKeyP1);
	    gamePanel.setKeyDropBombP1(bombKeyP1);
	    gamePanel.setKeyExploBombP1(explodeBombKeyP1);
    
		gamePanel.setKeyExploBombP2(explodeBombKeyP2);
		gamePanel.setKeyDropBombP2(bombKeyP2);
		gamePanel.setKeyRightP2(rightKeyP2);
		gamePanel.setKeyDownP2(downKeyP2);
		gamePanel.setKeyLeftP2(leftKeyP2);
		gamePanel.setKeyUpP2(upKeyP2);
		
	}


	/**
	 * New settings.
	 *
	 * @return true, if successful
	 */
	public boolean newSettings() {
		return newSettings;
	}




	/**
	 * Sets the new settings.
	 *
	 * @param newSettings the new new settings
	 */
	public void setNewSettings(boolean newSettings) {
		this.newSettings = newSettings;
	}
	
}
