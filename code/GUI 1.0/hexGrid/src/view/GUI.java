package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GUI {

	private JFrame frmGameBoard;
	private JTable statusTable;
	private JButton btnEnd;
	private JButton btnSwitch;
	private JScrollPane statusScrollPane;
	private JPanel btnpanel;
	private DrawingPanel gameBoardPanel;
	
	
		
		/**
		 * Create the application.
		 */
		public GUI() {		
			initialize();
		}

	/**
	 * Launch the application.
	 */
	public static void StartButtonClicked() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmGameBoard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameBoard = new JFrame();
		frmGameBoard.setTitle("game board");
		frmGameBoard.setBounds(100, 100, 897, 756);
		frmGameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameBoard.getContentPane().setLayout(null);
		
		String[] columnNames = {"Robot Name",
                "Health",
                "Attack Value",
                "Movement Point",
                "Range"};
		
		Object[][] data = {
			    {"scout", new Integer(1), new Integer(1),new Integer(3), new Integer(2)},
			    {"sniper", new Integer(2), new Integer(2),new Integer(2), new Integer(3)},
			    {"tank", new Integer(3), new Integer(3),new Integer(1), new Integer(1)}	     
			};
		
		statusScrollPane = new JScrollPane();
		statusScrollPane.setBounds(102, 648, 372, 76);
		frmGameBoard.getContentPane().add(statusScrollPane);
		
		statusTable = new JTable(data, columnNames);
		statusTable.setFillsViewportHeight(true);
		statusScrollPane.setViewportView(statusTable);
		
		btnpanel = new JPanel();
		btnpanel.setBounds(510, 673, 381, 39);
		frmGameBoard.getContentPane().add(btnpanel);
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				(DrawingPanel.N) = 1; 
				gameBoardPanel.repaint();
			}
		});
		btnpanel.add(btnStart);
		
		btnEnd = new JButton("End");
		btnpanel.add(btnEnd);
		
		btnSwitch = new JButton("Switch");
		btnSwitch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DrawingPanel.N++;
				if((DrawingPanel.N) > 6)
					(DrawingPanel.N) = 1;
				
				
			
					
			}
		});
		btnpanel.add(btnSwitch);
		
		
		gameBoardPanel = new DrawingPanel(80);
		gameBoardPanel.setBounds(99, 0, 765, 636);
		frmGameBoard.getContentPane().add(gameBoardPanel);
		
		
	}
}
