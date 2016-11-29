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

				for (int i=0;i<DrawingPanel.BSIZE;i++) {
					for (int j=0;j<DrawingPanel.BSIZE;j++) {
						
						// 2 players
						if (DrawingPanel.Q == 2){
							// red 
							if(i==1 && j==4)
								DrawingPanel.board[i][j]=1;
							
							//green
							else if(i==9 && j==4)
								DrawingPanel.board[i][j]=4;		
							
							else
								DrawingPanel.board[i][j]=DrawingPanel.EMPTY;			
						}
						
						// 3 players
						if (DrawingPanel.Q == 3){
							// red 
							if(i==1 && j==4)
								DrawingPanel.board[i][j]=1;
							// yellow
							else if(i==7 && j==0)
								DrawingPanel.board[i][j]=3;
							// blue
							else if(i==7 && j==8)
								DrawingPanel.board[i][j]=5;
							else
								DrawingPanel.board[i][j]=DrawingPanel.EMPTY;	
						}
						
						// 6 players
						if (DrawingPanel.Q == 6){
							// red 
							if(i==1 && j==4)
								DrawingPanel.board[i][j]=1;
							// orange
							else if(i==3 && j==0)
								DrawingPanel.board[i][j]=2;
							// yellow
							else if(i==7 && j==0)
								DrawingPanel.board[i][j]=3;
							//green
							else if(i==9 && j==4)
								DrawingPanel.board[i][j]=4;		

							// blue
							else if(i==7 && j==8)
								DrawingPanel.board[i][j]=5;

							// purple
							else if(i==3 && j==8)
								DrawingPanel.board[i][j]=6;

							else
								DrawingPanel.board[i][j]=DrawingPanel.EMPTY;			
						}
						else;
				 }
			}

				(DrawingPanel.N) = 1; 
				gameBoardPanel.board[DrawingPanel.p_old[DrawingPanel.N].x][DrawingPanel.p_old[DrawingPanel.N].y] = DrawingPanel.N;
//				System.out.println(DrawingPanel.N);
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
				else if (DrawingPanel.Q == 3){
					DrawingPanel.N = DrawingPanel.N + 2;
					if((DrawingPanel.N) > 18)
						(DrawingPanel.N) = 1;
				}
				else if (DrawingPanel.Q == 6){
					DrawingPanel.N = DrawingPanel.N + 1;
					if((DrawingPanel.N) > 18)
						(DrawingPanel.N) = 1;
				}
				else;
				
				// when overlapping, show the specific robot on the overlapping cell
				DrawingPanel.board[DrawingPanel.p_old[DrawingPanel.N].x][DrawingPanel.p_old[DrawingPanel.N].y] = DrawingPanel.N;
				gameBoardPanel.repaint();
				
				
			}
		});
		btnpanel.add(btnSwitch);
		
		
		gameBoardPanel = new DrawingPanel(80);
		gameBoardPanel.setBounds(99, 0, 765, 636);
		frmGameBoard.getContentPane().add(gameBoardPanel);
		
	}
	

	
}
