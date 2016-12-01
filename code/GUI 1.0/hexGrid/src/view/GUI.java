package view;

import java.awt.*;
import javax.swing.*;

import view.robot.robotClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class GUI {

	private JFrame frmGameBoard;
	static JTable statusTable;
	private JButton btnEnd;
	private JButton btnSwitch;
	private JScrollPane statusScrollPane;
	private JPanel btnpanel;
	private DrawingPanel gameBoardPanel;
	
	public String[] columnNames = {
			"Robot Name",
            "Health",
            "Attack Value",
            "Range",
            "Move Point",
            "Attack Point",
            "Status"};
		
	public static DefaultListModel<robot> robotList = new DefaultListModel<robot>();
	public static robotController rC = new robotController(robotList);
	
	
	public static Object[][] data = {
			{"scout", new Integer(1), new Integer(1), new Integer(2), new Integer(3), new Integer(1), "alive"},
			{"sniper", new Integer(2), new Integer(2),new Integer(3), new Integer(2), new Integer(1), "alive"},
			{"tank", new Integer(3), new Integer(3), new Integer(1), new Integer(1), new Integer(1), "alive"}	     
	};

//	public static Object[][] data = {
//			{"scout", 1, 1, 2, 3, 1, "alive"},
//			{"sniper", 2, 2, 3, 2, 1, "alive"},
//			{"tank", 3, 3, 1, 1, 1, "alive"}	     
//	};
//		
		
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
		
		// initialize the robot in 1 - 18 order
		rC.createRobot("scout_red","red",Color.RED, robotClass.SCOUT, new Point(1,4)); // empty, no use
		
		
		rC.createRobot("scout_red","red",Color.RED, robotClass.SCOUT, new Point(1,4));
		rC.createRobot("scout_orange","orange",Color.ORANGE, robotClass.SCOUT, new Point(3,0));
		rC.createRobot("scout_yellow","yellow",Color.YELLOW, robotClass.SCOUT, new Point(7,0));
		rC.createRobot("scout_green","green",Color.GREEN, robotClass.SCOUT, new Point(9,4));
		rC.createRobot("scout_blue","blue",Color.BLUE, robotClass.SCOUT, new Point(7,8));
		rC.createRobot("scout_purple","purple",Color.MAGENTA, robotClass.SCOUT, new Point(3,8));
		
		
		rC.createRobot("sniper_red","red",Color.RED, robotClass.SNIPER, new Point(1,4));
		rC.createRobot("sniper_orange","orange",Color.ORANGE, robotClass.SNIPER, new Point(3,0));
		rC.createRobot("sniper_yellow","yellow",Color.YELLOW, robotClass.SNIPER, new Point(7,0));
		rC.createRobot("sniper_green","green",Color.GREEN, robotClass.SNIPER, new Point(9,4));
		rC.createRobot("sniper_blue","blue",Color.BLUE, robotClass.SNIPER, new Point(7,8));
		rC.createRobot("sniper_purple","purple",Color.MAGENTA, robotClass.SNIPER, new Point(3,8));
		
		
		rC.createRobot("tank_red","red",Color.RED, robotClass.TANK, new Point(1,4));
		rC.createRobot("tank_orange","orange",Color.ORANGE, robotClass.TANK, new Point(3,0));
		rC.createRobot("tank_yellow","yellow",Color.YELLOW, robotClass.TANK, new Point(7,0));
		rC.createRobot("tank_green","green",Color.GREEN, robotClass.TANK, new Point(9,4));
		rC.createRobot("tank_blue","blue",Color.BLUE, robotClass.TANK, new Point(7,8));
		rC.createRobot("tank_purple","purple",Color.MAGENTA, robotClass.TANK, new Point(3,8));
		
		
		frmGameBoard = new JFrame();
		frmGameBoard.setTitle("game board");
		frmGameBoard.setBounds(100, 100, 897, 756);
		frmGameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameBoard.getContentPane().setLayout(null);
		
		statusScrollPane = new JScrollPane();
		statusScrollPane.setBounds(102, 648, 480, 76);
		frmGameBoard.getContentPane().add(statusScrollPane);
		
		statusTable = new JTable(data, columnNames);
		statusTable.setFillsViewportHeight(true);
		statusScrollPane.setViewportView(statusTable);
		
		btnpanel = new JPanel();
		btnpanel.setBounds(594, 668, 297, 39);
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
				updateTable();
				statusTable.repaint();
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
					
				data[0][0] = "scout";
				data[0][1] = 1;
				data[0][2] = 1;
				data[0][3] = 2;
				data[0][4] = 3;
				data[0][5] = 1;
				data[0][6] = "alive";
				
				data[1][0] = "sniper";
				data[1][1] = 2;
				data[1][2] = 2;
				data[1][3] = 3;
				data[1][4] = 2;
				data[1][5] = 1;
				data[1][6] = "alive";
				
				data[2][0] = "tank";
				data[2][1] = 3;
				data[2][2] = 3;
				data[2][3] = 1;
				data[2][4] = 1;
				data[2][5] = 1;
				data[2][6] = "alive";
				
				for (int i = 0; i<=18; i++){
					rC.delete(i);
				}
				
				rC.createRobot("scout_red","red",Color.RED, robotClass.SCOUT, new Point(1,4)); // empty, no use
				
				
				rC.createRobot("scout_red","red",Color.RED, robotClass.SCOUT, new Point(1,4));
				rC.createRobot("scout_orange","orange",Color.ORANGE, robotClass.SCOUT, new Point(3,0));
				rC.createRobot("scout_yellow","yellow",Color.YELLOW, robotClass.SCOUT, new Point(7,0));
				rC.createRobot("scout_green","green",Color.GREEN, robotClass.SCOUT, new Point(9,4));
				rC.createRobot("scout_blue","blue",Color.BLUE, robotClass.SCOUT, new Point(7,8));
				rC.createRobot("scout_purple","purple",Color.MAGENTA, robotClass.SCOUT, new Point(3,8));
				
				
				rC.createRobot("sniper_red","red",Color.RED, robotClass.SNIPER, new Point(1,4));
				rC.createRobot("sniper_orange","orange",Color.ORANGE, robotClass.SNIPER, new Point(3,0));
				rC.createRobot("sniper_yellow","yellow",Color.YELLOW, robotClass.SNIPER, new Point(7,0));
				rC.createRobot("sniper_green","green",Color.GREEN, robotClass.SNIPER, new Point(9,4));
				rC.createRobot("sniper_blue","blue",Color.BLUE, robotClass.SNIPER, new Point(7,8));
				rC.createRobot("sniper_purple","purple",Color.MAGENTA, robotClass.SNIPER, new Point(3,8));
				
				
				rC.createRobot("tank_red","red",Color.RED, robotClass.TANK, new Point(1,4));
				rC.createRobot("tank_orange","orange",Color.ORANGE, robotClass.TANK, new Point(3,0));
				rC.createRobot("tank_yellow","yellow",Color.YELLOW, robotClass.TANK, new Point(7,0));
				rC.createRobot("tank_green","green",Color.GREEN, robotClass.TANK, new Point(9,4));
				rC.createRobot("tank_blue","blue",Color.BLUE, robotClass.TANK, new Point(7,8));
				rC.createRobot("tank_purple","purple",Color.MAGENTA, robotClass.TANK, new Point(3,8));
				
				
			    gameBoardPanel.setVisible(false);
				frmGameBoard.dispose();				
			}			
		});
		
		
		
		
		btnSwitch = new JButton("Switch");
		btnSwitch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				robotList.getElementAt(DrawingPanel.N).setMoved(0);
				
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
				updateTable();
				statusTable.repaint();
				gameBoardPanel.repaint();
				
				
			}
		});
		btnpanel.add(btnSwitch);
		
		
		gameBoardPanel = new DrawingPanel(80);
		gameBoardPanel.setBounds(99, 0, 765, 636);
		frmGameBoard.getContentPane().add(gameBoardPanel);
		
	} // end of initialize()
	
	public static void updateTable(){
		// for scout turn 
        if(DrawingPanel.N >= 1 && DrawingPanel.N  <= 6){
        	// refresh scout row
        	data[0][1] = robotList.elementAt(DrawingPanel.N).getCurrentHp();
        	data[0][2] = robotList.elementAt(DrawingPanel.N).getAttackPower();
        	data[0][3] = robotList.elementAt(DrawingPanel.N).getRange();
        	data[0][4] = robotList.elementAt(DrawingPanel.N).getMovePoints() - robotList.elementAt(DrawingPanel.N).getMoved();
        	
        	
        	if (robotList.elementAt(DrawingPanel.N).attacked())
        		data[0][5] = 0;
        	else 
        		data[0][5] = 1;
        	
        	if (robotList.elementAt(DrawingPanel.N).alive())
        		data[0][6] = "alive";
        	else 
        		data[0][6] = "dead";
        	
        	// refresh sniper row
        	data[1][1] = robotList.elementAt(DrawingPanel.N + 6).getCurrentHp();
        	data[1][2] = robotList.elementAt(DrawingPanel.N + 6).getAttackPower();
        	data[1][3] = robotList.elementAt(DrawingPanel.N + 6).getRange();
        	data[1][4] = robotList.elementAt(DrawingPanel.N + 6).getMovePoints() - robotList.elementAt(DrawingPanel.N + 6).getMoved();
        	
        	if (robotList.elementAt(DrawingPanel.N + 6).attacked())
        		data[1][5] = 0;
        	else 
        		data[1][5] = 1;
        	
        	if (robotList.elementAt(DrawingPanel.N + 6).alive())
        		data[1][6] = "alive";
        	else 
        		data[1][6] = "dead";
        	
        	// refresh tank row
        	data[2][1] = robotList.elementAt(DrawingPanel.N + 12).getCurrentHp();
        	data[2][2] = robotList.elementAt(DrawingPanel.N + 12).getAttackPower();
        	data[2][3] = robotList.elementAt(DrawingPanel.N + 12).getRange();
        	data[2][4] = robotList.elementAt(DrawingPanel.N + 12).getMovePoints() - robotList.elementAt(DrawingPanel.N + 12).getMoved();
        	
        	if (robotList.elementAt(DrawingPanel.N + 12).attacked())
        		data[2][5] = 0;
        	else 
        		data[2][5] = 1;
        	
        	if (robotList.elementAt(DrawingPanel.N + 12).alive())
        		data[2][6] = "alive";
        	else 
        		data[2][6] = "dead";
        			
        }
        
        // for sniper turn 
        else if(DrawingPanel.N  >= 7 && DrawingPanel.N  <= 12){
        	// refresh scout row
        	data[0][1] = robotList.elementAt(DrawingPanel.N - 6).getCurrentHp();
        	data[0][2] = robotList.elementAt(DrawingPanel.N - 6).getAttackPower();
        	data[0][3] = robotList.elementAt(DrawingPanel.N - 6).getRange();
        	data[0][4] = robotList.elementAt(DrawingPanel.N - 6).getMovePoints() - robotList.elementAt(DrawingPanel.N - 6).getMoved();
        	

        	if (robotList.elementAt(DrawingPanel.N - 6).attacked())
        		data[0][5] = 0;
        	else 
        		data[0][5] = 1;
        	
        	if (robotList.elementAt(DrawingPanel.N - 6).alive())
        		data[0][6] = "alive";
        	else 
        		data[0][6] = "dead";
        	
        	// refresh sniper row
        	data[1][1] = robotList.elementAt(DrawingPanel.N ).getCurrentHp();
        	data[1][2] = robotList.elementAt(DrawingPanel.N).getAttackPower();
        	data[1][3] = robotList.elementAt(DrawingPanel.N).getRange();
        	data[1][4] = robotList.elementAt(DrawingPanel.N).getMovePoints() - robotList.elementAt(DrawingPanel.N).getMoved();
        	
        	if (robotList.elementAt(DrawingPanel.N).attacked())
        		data[1][5] = 0;
        	else 
        		data[1][5] = 1;
        	
        	if (robotList.elementAt(DrawingPanel.N).alive())
        		data[1][6] = "alive";
        	else 
        		data[1][6] = "dead";
        	
        	// refresh tank row
        	data[2][1] = robotList.elementAt(DrawingPanel.N + 6).getCurrentHp();
        	data[2][2] = robotList.elementAt(DrawingPanel.N + 6).getAttackPower();
        	data[2][3] = robotList.elementAt(DrawingPanel.N + 6).getRange();
        	data[2][4] = robotList.elementAt(DrawingPanel.N + 6).getMovePoints() - robotList.elementAt(DrawingPanel.N + 6).getMoved();
        	
        	if (robotList.elementAt(DrawingPanel.N + 6).attacked())
        		data[2][5] = 0;
        	else 
        		data[2][5] = 1;
        	
        	if (robotList.elementAt(DrawingPanel.N + 6).alive())
        		data[2][6] = "alive";
        	else 
        		data[2][6] = "dead";
        		
        }
        
     // for tank turn 
        else if(DrawingPanel.N  >= 13 && DrawingPanel.N  <= 18){
        	// refresh scout row
        	data[0][1] = robotList.elementAt(DrawingPanel.N - 12).getCurrentHp();
        	data[0][2] = robotList.elementAt(DrawingPanel.N - 12).getAttackPower();
        	data[0][3] = robotList.elementAt(DrawingPanel.N - 12).getRange();
        	data[0][4] = robotList.elementAt(DrawingPanel.N - 12).getMovePoints() - robotList.elementAt(DrawingPanel.N - 12).getMoved();
        	

        	if (robotList.elementAt(DrawingPanel.N - 12).attacked())
        		data[0][5] = 0;
        	else 
        		data[0][5] = 1;
        	
        	if (robotList.elementAt(DrawingPanel.N - 12).alive())
        		data[0][6] = "alive";
        	else 
        		data[0][6] = "dead";
        	
        	// refresh sniper row
        	data[1][1] = robotList.elementAt(DrawingPanel.N - 6).getCurrentHp();
        	data[1][2] = robotList.elementAt(DrawingPanel.N - 6).getAttackPower();
        	data[1][3] = robotList.elementAt(DrawingPanel.N - 6).getRange();
        	data[1][4] = robotList.elementAt(DrawingPanel.N - 6).getMovePoints() - robotList.elementAt(DrawingPanel.N - 6).getMoved();
        	
        	if (robotList.elementAt(DrawingPanel.N - 6).attacked())
        		data[1][5] = 0;
        	else 
        		data[1][5] = 1;
        	
        	if (robotList.elementAt(DrawingPanel.N - 6).alive())
        		data[1][6] = "alive";
        	else 
        		data[1][6] = "dead";
        	
        	// refresh tank row
        	data[2][1] = robotList.elementAt(DrawingPanel.N).getCurrentHp();
        	data[2][2] = robotList.elementAt(DrawingPanel.N).getAttackPower();
        	data[2][3] = robotList.elementAt(DrawingPanel.N).getRange();
        	data[2][4] = robotList.elementAt(DrawingPanel.N).getMovePoints() - robotList.elementAt(DrawingPanel.N).getMoved();
        	
        	if (robotList.elementAt(DrawingPanel.N).attacked())
        		data[2][5] = 0;
        	else 
        		data[2][5] = 1;
        	
        	if (robotList.elementAt(DrawingPanel.N).alive())
        		data[2][6] = "alive";
        	else 
        		data[2][6] = "dead";
        }
        else;
	} 
	
	
	

	
} // end of GUI class
