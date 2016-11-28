package view;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	public static robotController rC;
	
	
		
		/**
		 * Create the application.
		 */
		public GUI() {		
			initialize();
		}

	/**
	 * Launch the application.
	 */
		public static void StartButtonClicked(){
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
		
		// just click once, then set disable.
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			@Override
			 public void actionPerformed(ActionEvent ae) {
//				for (int i = 1; i<=18; i++){
//					gameBoardPanel.board[DrawingPanel.p_old[i].x][DrawingPanel.p_old[i].y] = 2;
//
//					gameBoardPanel.repaint();			
//				}
				(DrawingPanel.N) = 1; 
				gameBoardPanel.board[DrawingPanel.p_old[DrawingPanel.N].x][DrawingPanel.p_old[DrawingPanel.N].y] = DrawingPanel.N;
				gameBoardPanel.repaint();
				btnStart.setEnabled(false);
			}
		});
		
		
		btnpanel.add(btnStart);
		
		btnEnd = new JButton("End");
		btnpanel.add(btnEnd);
		btnEnd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.N = 0;
				DrawingPanel.PlayersNumber = 0;
				DrawingPanel.Q = 0;
				
				DrawingPanel.p_old[0] = new Point(0,0);
				DrawingPanel.p_old[1] = new Point(1,4);
				DrawingPanel.p_old[2] = new Point(3,0);
				DrawingPanel.p_old[3] = new Point(7,0);
				DrawingPanel.p_old[4] = new Point(9,4);
				DrawingPanel.p_old[5] = new Point(7,8);
				DrawingPanel.p_old[6] = new Point(3,8);
				
				DrawingPanel.p_old[7] = new Point(1,4);
				DrawingPanel.p_old[8] = new Point(3,0);
				DrawingPanel.p_old[9] = new Point(7,0);
				DrawingPanel.p_old[10] = new Point(9,4);
				DrawingPanel.p_old[11] = new Point(7,8);
				DrawingPanel.p_old[12] = new Point(3,8);

				DrawingPanel.p_old[13] = new Point(1,4);
				DrawingPanel.p_old[14] = new Point(3,0);
				DrawingPanel.p_old[15] = new Point(7,0);
				DrawingPanel.p_old[16] = new Point(9,4);
				DrawingPanel.p_old[17] = new Point(7,8);
				DrawingPanel.p_old[18] = new Point(3,8);
				
//				DrawingPanel.p_old[7] = new Point(1,3);
//				DrawingPanel.p_old[8] = new Point(4,0);
//				DrawingPanel.p_old[9] = new Point(6,0);
//				DrawingPanel.p_old[10] = new Point(8,5);
//				DrawingPanel.p_old[11] = new Point(6,8);
//				DrawingPanel.p_old[12] = new Point(2,7);
//				
//				DrawingPanel.p_old[13] = new Point(1,5);
//				DrawingPanel.p_old[14] = new Point(2,1);
//				DrawingPanel.p_old[15] = new Point(7,1);
//				DrawingPanel.p_old[16] = new Point(8,3);
//				DrawingPanel.p_old[17] = new Point(7,7);
//				DrawingPanel.p_old[18] = new Point(4,8);
				
				DrawingPanel.status_old[0] = 0;
				DrawingPanel.status_old[1] = 0;
				DrawingPanel.status_old[2] = 0;
				DrawingPanel.status_old[3] = 0;
				DrawingPanel.status_old[4] = 0;
				DrawingPanel.status_old[5] = 0;
				DrawingPanel.status_old[6] = 0;
				DrawingPanel.status_old[7] = 0;
				DrawingPanel.status_old[8] = 0;
				DrawingPanel.status_old[9] = 0;
				DrawingPanel.status_old[10] = 0;
				DrawingPanel.status_old[11] = 0;
				DrawingPanel.status_old[12] = 0;
				DrawingPanel.status_old[13] = 0;
				DrawingPanel.status_old[14] = 0;
				DrawingPanel.status_old[15] = 0;
				DrawingPanel.status_old[16] = 0;
				DrawingPanel.status_old[17] = 0;
				DrawingPanel.status_old[18] = 0;
				
//				DrawingPanel.status_old[0] = 7;
//				DrawingPanel.status_old[1] = 8;
//				DrawingPanel.status_old[2] = 9;
//				DrawingPanel.status_old[3] = 10;
//				DrawingPanel.status_old[4] = 11;
//				DrawingPanel.status_old[5] = 12;
//				DrawingPanel.status_old[6] = 13;
//				DrawingPanel.status_old[7] = 14;
//				DrawingPanel.status_old[8] = 15;
//				DrawingPanel.status_old[9] = 16;
//				DrawingPanel.status_old[10] = 17;
//				DrawingPanel.status_old[11] = 18;
//				DrawingPanel.status_old[12] = 0;
//				DrawingPanel.status_old[13] = 0;
//				DrawingPanel.status_old[14] = 0;
//				DrawingPanel.status_old[15] = 0;
//				DrawingPanel.status_old[16] = 0;
//				DrawingPanel.status_old[17] = 0;
//				DrawingPanel.status_old[18] = 0;
				
			    gameBoardPanel.setVisible(false);
				frmGameBoard.dispose();				
			}			
		});
		
		
		
		
		btnSwitch = new JButton("Switch");
		btnSwitch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (DrawingPanel.Q == 2){
					DrawingPanel.N = DrawingPanel.N + 3;
					if((DrawingPanel.N) > 18)
						(DrawingPanel.N) = 1;
					}
				if (DrawingPanel.Q == 3){
					DrawingPanel.N = DrawingPanel.N + 2;
					if((DrawingPanel.N) > 18)
						(DrawingPanel.N) = 1;
					}
				if (DrawingPanel.Q == 6){
					DrawingPanel.N = DrawingPanel.N + 1;
					if((DrawingPanel.N) > 18)
						(DrawingPanel.N) = 1;
					}
				else;
					// when overlapping, show the specific robot on the overlapping cell
				gameBoardPanel.board[DrawingPanel.p_old[DrawingPanel.N].x][DrawingPanel.p_old[DrawingPanel.N].y] = DrawingPanel.N;

				gameBoardPanel.repaint();
				
			}
		});
		btnpanel.add(btnSwitch);
		
		
		gameBoardPanel = new DrawingPanel(80);
		gameBoardPanel.setBounds(99, 0, 765, 636);
		frmGameBoard.getContentPane().add(gameBoardPanel);
		
		
	}
}
