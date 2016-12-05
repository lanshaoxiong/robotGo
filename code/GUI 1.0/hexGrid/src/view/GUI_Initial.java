package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class GUI_Initial {

	private JFrame frmInitialization;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	
	JPanel Player1Panel;
	JPanel Player2Panel;
	JPanel Player3Panel;
	JPanel Player4Panel;
	JPanel Player5Panel;
	JPanel Player6Panel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Initial window = new GUI_Initial();
					window.frmInitialization.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Initial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInitialization = new JFrame();
		frmInitialization.setTitle("Initialization");
		frmInitialization.setBounds(100, 100, 729, 589);
		frmInitialization.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInitialization.getContentPane().setLayout(null);
		
		JPanel numberPanel = new JPanel();
		numberPanel.setBounds(30, 36, 503, 38);
		frmInitialization.getContentPane().add(numberPanel);
		
		JLabel numberLabel = new JLabel("Number of players:");
		numberLabel.setHorizontalAlignment(SwingConstants.LEFT);
		numberPanel.add(numberLabel);
		
		JRadioButton rdbtnTwoPlayers = new JRadioButton("Two Players");
		rdbtnTwoPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		numberPanel.add(rdbtnTwoPlayers);
		buttonGroup.add(rdbtnTwoPlayers);
		
		rdbtnTwoPlayers.addActionListener(new ActionListener(){
			@Override
				public void actionPerformed(ActionEvent e) {
					DrawingPanel.Q = 2;
					DrawingPanel.PlayersNumber = 2;
					setPanelEnabled(Player1Panel, true);
					setPanelEnabled(Player2Panel, false);
					setPanelEnabled(Player3Panel, false);
					setPanelEnabled(Player4Panel, true);
					setPanelEnabled(Player5Panel, false);
					setPanelEnabled(Player6Panel, false);
					
				}
			});
		

		JRadioButton rdbtnThreePlayers = new JRadioButton("Three Players ");
		numberPanel.add(rdbtnThreePlayers);
		buttonGroup.add(rdbtnThreePlayers);
		rdbtnThreePlayers.addActionListener(new ActionListener(){
			@Override
				public void actionPerformed(ActionEvent e) {
					DrawingPanel.Q = 3;
					DrawingPanel.PlayersNumber = 3;
					setPanelEnabled(Player1Panel, true);
					setPanelEnabled(Player2Panel, false);
					setPanelEnabled(Player3Panel, true);
					setPanelEnabled(Player4Panel, false);
					setPanelEnabled(Player5Panel, true);
					setPanelEnabled(Player6Panel, false);
				}
			});
		
		JRadioButton rdbtnSixPlayers = new JRadioButton("Six Players");
		numberPanel.add(rdbtnSixPlayers);
		buttonGroup.add(rdbtnSixPlayers);
		rdbtnSixPlayers.addActionListener(new ActionListener(){

			@Override
				public void actionPerformed(ActionEvent e) {
					DrawingPanel.Q = 6;
					DrawingPanel.PlayersNumber = 6;
					setPanelEnabled(Player1Panel, true);
					setPanelEnabled(Player2Panel, true);
					setPanelEnabled(Player3Panel, true);
					setPanelEnabled(Player4Panel, true);
					setPanelEnabled(Player5Panel, true);
					setPanelEnabled(Player6Panel, true);
				}
			});
		
		Player1Panel = new JPanel();
		Player1Panel.setBounds(30, 94, 220, 38);
		frmInitialization.getContentPane().add(Player1Panel);
		
		JLabel Player1Label = new JLabel("Player1:");
		Player1Panel.add(Player1Label);
		
		JRadioButton Player1HumanButton = new JRadioButton("Human");
		Player1HumanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[1] = false;
				DrawingPanel.isAI[7] = false;
				DrawingPanel.isAI[13] = false;
			}
		});
		buttonGroup_1.add(Player1HumanButton);
		Player1HumanButton.setVerticalAlignment(SwingConstants.BOTTOM);
		Player1Panel.add(Player1HumanButton);
		
		JRadioButton Player1AIButton = new JRadioButton("AI");
		Player1AIButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[1] = true;
				DrawingPanel.isAI[7] = true;
				DrawingPanel.isAI[13] = true;
			}
		});
		
		buttonGroup_1.add(Player1AIButton);
		Player1AIButton.setVerticalAlignment(SwingConstants.BOTTOM);
		Player1Panel.add(Player1AIButton);
		
		Player2Panel = new JPanel();
		Player2Panel.setBounds(30, 136, 220, 38);
		frmInitialization.getContentPane().add(Player2Panel);
		
		JLabel lblPlayer = new JLabel("Player2:");
		Player2Panel.add(lblPlayer);
		
		JRadioButton Player2HumanButton = new JRadioButton("Human");
		Player2HumanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[2] = false;
				DrawingPanel.isAI[8] = false;
				DrawingPanel.isAI[14] = false;
			}
		});
		buttonGroup_2.add(Player2HumanButton);
		Player2HumanButton.setVerticalAlignment(SwingConstants.BOTTOM);
		Player2Panel.add(Player2HumanButton);
		
		JRadioButton radioButton_1 = new JRadioButton("AI");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[2] = true;
				DrawingPanel.isAI[8] = true;
				DrawingPanel.isAI[14] = true;
			}
		});
		buttonGroup_2.add(radioButton_1);
		radioButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		Player2Panel.add(radioButton_1);
		
		Player3Panel = new JPanel();
		Player3Panel.setBounds(30, 177, 220, 38);
		frmInitialization.getContentPane().add(Player3Panel);
		
		JLabel lblPlayer_1 = new JLabel("Player3:");
		Player3Panel.add(lblPlayer_1);
		
		JRadioButton Player3HumanButton = new JRadioButton("Human");
		Player3HumanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[3] = false;
				DrawingPanel.isAI[9] = false;
				DrawingPanel.isAI[15] = false;
			}
		});
		buttonGroup_3.add(Player3HumanButton);
		Player3HumanButton.setVerticalAlignment(SwingConstants.BOTTOM);
		Player3Panel.add(Player3HumanButton);
		
		JRadioButton radioButton_3 = new JRadioButton("AI");
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[3] = true;
				DrawingPanel.isAI[9] = true;
				DrawingPanel.isAI[15] = true;
			}
		});
		buttonGroup_3.add(radioButton_3);
		radioButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
		Player3Panel.add(radioButton_3);
		
		Player4Panel = new JPanel();
		Player4Panel.setBounds(30, 217, 220, 38);
		frmInitialization.getContentPane().add(Player4Panel);
		
		JLabel lblPlayer_2 = new JLabel("Player4:");
		Player4Panel.add(lblPlayer_2);
		
		JRadioButton Player4HumanButton = new JRadioButton("Human");
		Player4HumanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[4] = false;
				DrawingPanel.isAI[10] = false;
				DrawingPanel.isAI[16] = false;
			}
		});
		buttonGroup_4.add(Player4HumanButton);
		Player4HumanButton.setVerticalAlignment(SwingConstants.BOTTOM);
		Player4Panel.add(Player4HumanButton);
		
		JRadioButton radioButton_5 = new JRadioButton("AI");
		radioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[4] = true;
				DrawingPanel.isAI[10] = true;
				DrawingPanel.isAI[16] = true;
			}
		});
		buttonGroup_4.add(radioButton_5);
		radioButton_5.setVerticalAlignment(SwingConstants.BOTTOM);
		Player4Panel.add(radioButton_5);
		
		Player5Panel = new JPanel();
		Player5Panel.setBounds(30, 259, 220, 38);
		frmInitialization.getContentPane().add(Player5Panel);
		
		JLabel lblPlayer_3 = new JLabel("Player5:");
		Player5Panel.add(lblPlayer_3);
		
		JRadioButton Player5HumanButton = new JRadioButton("Human");
		Player5HumanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[5] = false;
				DrawingPanel.isAI[11] = false;
				DrawingPanel.isAI[17] = false;
			}
		});
		buttonGroup_5.add(Player5HumanButton);
		Player5HumanButton.setVerticalAlignment(SwingConstants.BOTTOM);
		Player5Panel.add(Player5HumanButton);
		
		JRadioButton radioButton_7 = new JRadioButton("AI");
		radioButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[5] = true;
				DrawingPanel.isAI[11] = true;
				DrawingPanel.isAI[17] = true;
			}
		});
		buttonGroup_5.add(radioButton_7);
		radioButton_7.setVerticalAlignment(SwingConstants.BOTTOM);
		Player5Panel.add(radioButton_7);
		
		Player6Panel = new JPanel();
		Player6Panel.setBounds(30, 299, 220, 38);
		frmInitialization.getContentPane().add(Player6Panel);
		
		JLabel lblPlayer_4 = new JLabel("Player6:");
		Player6Panel.add(lblPlayer_4);
		
		JRadioButton Player6HumanButton = new JRadioButton("Human");
		Player6HumanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[6] = false;
				DrawingPanel.isAI[12] = false;
				DrawingPanel.isAI[18] = false;
			}
		});
		buttonGroup_6.add(Player6HumanButton);
		Player6HumanButton.setVerticalAlignment(SwingConstants.BOTTOM);
		Player6Panel.add(Player6HumanButton);
		
		JRadioButton radioButton_9 = new JRadioButton("AI");
		radioButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.isAI[6] = true;
				DrawingPanel.isAI[12] = true;
				DrawingPanel.isAI[18] = true;
			}
		});
		buttonGroup_6.add(radioButton_9);
		radioButton_9.setVerticalAlignment(SwingConstants.BOTTOM);
		Player6Panel.add(radioButton_9);
		
		JButton playButton = new JButton("Play");

	 	
		playButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				buttonGroup_2.clearSelection();
				buttonGroup_3.clearSelection();
				buttonGroup_4.clearSelection();
				buttonGroup_5.clearSelection();
				buttonGroup_6.clearSelection();
				GUI.StartButtonClicked();
			}
		});
		playButton.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		playButton.setBounds(30, 399, 220, 67);
		frmInitialization.getContentPane().add(playButton);
//		
		DrawingPanel thumbnailPanel = new DrawingPanel(50);
		thumbnailPanel.setBounds(262, 86, 445, 380);
		frmInitialization.getContentPane().add(thumbnailPanel);

	}
	
	// helper function to enable panel
	void setPanelEnabled(JPanel panel, Boolean isEnabled) {
	    panel.setEnabled(isEnabled);
	    Component[] components = panel.getComponents();

	    for(int i = 0; i < components.length; i++) {
	        if(components[i].getClass().getName() == "javax.swing.JPanel") {
	            setPanelEnabled((JPanel) components[i], isEnabled);
	        }
	        components[i].setEnabled(isEnabled);    
	    }
//	    if(panel == personPortion){
//	        streetAdsField.setEnabled(isEnabled);
//	    }
//	    if(panel == graduatePortion){
//	        titleField.setEnabled(isEnabled);
//	        areaField.setEnabled(isEnabled);
//	        streetAdsField_prof.setEnabled(isEnabled);
//	    }
	    
	}
}
