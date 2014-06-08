package gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PausePanelDialog extends JDialog{
	
	private MainWindow mainWindow;

	public PausePanelDialog(MainWindow mainWindow, boolean modal){
		super(mainWindow.getFrame(),true);
//		TODO remove comments
//		setUndecorated(true);
		this.mainWindow = mainWindow;

		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(150,50));
		panel.setBorder(null);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		
		JLabel lblPausee = new JLabel("Pause");
		lblPausee.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPausee);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(150,150));
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Resume");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnSaveGame = new JButton("Save Game");
		panel_1.add(btnSaveGame);
		
		JButton btnLoadGame = new JButton("Load Game");
		panel_1.add(btnLoadGame);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		getContentPane().add(verticalStrut);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(150,50));
		getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));

		
		JButton btnMainMenu = new JButton("Main Menu");
		panel_4.add(btnMainMenu);
		this.setVisible(true);
		
		
		this.pack();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	}

}
