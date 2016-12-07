package view;


import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class DrawingPanel extends JPanel
{		
	
	//constants and global variables for board part
			final static Color COLOURBACK =  Color.WHITE;
			final static Color COLOURCELL =  Color.lightGray;	 
			final static Color COLOURGRID =  Color.BLACK;
			
			final static Color COLOURORANGE =  Color.ORANGE;
			final static Color COLOURRED =  Color.RED;
			final static Color COLOURYELLOW =  Color.YELLOW;
			final static Color COLOURGREEN =  Color.GREEN;
			final static Color COLOURBLUE =  Color.BLUE;
			final static Color COLOURPURPLE =  Color.MAGENTA;
			
			
			final static Color COLOURONE = new Color(255,255,255,200);
			final static Color COLOURONETXT = Color.BLUE;
			final static Color COLOURGRAY = Color.gray; 
			final static Color COLOURSHADOW = Color.white;
			final static Color COLOURSHOOT = Color.white;
			
			final static Color COLOURTWOTXT = new Color(255,100,255);
			final static int EMPTY = 0;
			final static int BSIZE = 10; //board size.
		    static int HEXSIZE = 80;	//hex size in pixels
			
			final static int BORDERS = 20;  
			final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS*3; //screen size (vertical dimension).

			static int[][] board = new int[BSIZE][BSIZE];
			
			static int PlayersNumber = 6;
			static int N = 0;
			static int Q = 0;
		    static boolean [] isAI = {false, false, false, false, false, false, false,
		    								 false, false, false, false, false, false,
		    								 false, false, false, false, false, false};
 			
//			static Point [] p_old = {new Point(0,0), new Point(1,4), new Point(3,0), new Point(7,0), new Point(9,4), new Point(7,8), new Point(3, 8),  
//													 new Point(1,3), new Point(4,0), new Point(6,0), new Point(8,5), new Point(6,8), new Point(2, 7),  
//													 new Point(1,5), new Point(2,1), new Point(7,1), new Point(8,3), new Point(7,7), new Point(4, 8)};
			
			static Point [] p_old = {new Point(0,0), new Point(1,4), new Point(3,0), new Point(7,0), new Point(9,4), new Point(7,8), new Point(3,8),  
													 new Point(1,4), new Point(3,0), new Point(7,0), new Point(9,4), new Point(7,8), new Point(3,8),  
													 new Point(1,4), new Point(3,0), new Point(7,0), new Point(9,4), new Point(7,8), new Point(3,8)};
			

//			static int [] status_old = {0,7,8,9,10,11,12,13,14,15,16,17,18,0,0,0,0,0,0};
			
			static int [] status_old = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
			

	public DrawingPanel()
	{	
		initialHex();
		setBackground(COLOURBACK);

		MyMouseListener ml = new MyMouseListener(this);            
		addMouseListener(ml);
	}
	
	public DrawingPanel(int size)
	{	
		HEXSIZE = size;
		initialHex();
		setBackground(COLOURBACK);

		MyMouseListener ml = new MyMouseListener(this);            
		addMouseListener(ml);
	}
	
	 private void initialHex(){

			hexmech_pointy.setXYasVertex(false); //RECOMMENDED: leave this as FALSE.

			hexmech_pointy.setHeight(HEXSIZE); //Either setHeight or setSize must be run to initialize the hex
			hexmech_pointy.setBorders(BORDERS);

			// deploy again!!!!!!!!!!!!!!
			for (int i=0;i<BSIZE;i++) {
				for (int j=0;j<BSIZE;j++) {
					
					// 2 players
					if (DrawingPanel.Q == 2){
						// red 
						if(i==1 && j==4)
							board[i][j]=1;
						else if (i == 1 && j == 5)
							board[i][j]=7;
						else if (i == 1 && j == 3)
							board[i][j]=13;

						//green
						else if(i==9 && j==4)
							board[i][j]=4;	
						else if(i==8 && j==5)
							board[i][j]=10;	
						else if(i==8 && j==3)
							board[i][j]=16;	
						
						else
							board[i][j]=EMPTY;			
					}
					
					// 3 players
					if (DrawingPanel.Q == 3){
						// red 
						if(i==1 && j==4)
							board[i][j]=1;
						else if (i == 1 && j == 5)
							board[i][j]=7;
						else if (i == 1 && j == 3)
							board[i][j]=13;
						
						// yellow
						else if(i==7 && j==0)
							board[i][j]=3;	
						else if(i==6 && j==0)
							board[i][j]=9;
						else if(i==7 && j==1)
							board[i][j]=15;
						
						// blue
						else if(i==7 && j==8)
							board[i][j]=5;
						else if(i==6 && j==8)
							board[i][j]=11;
						else if(i==7 && j==7)
							board[i][j]=17;
						
						else
							board[i][j]=EMPTY;	
					}
					
					// 6 players
					if (DrawingPanel.Q == 6){
						// red 
						if(i==1 && j==4)
							board[i][j]=1;
						else if (i==1 && j==5)
							board[i][j]=7;
						else if (i == 1 && j==3)
							board[i][j]=13;
						
						// orange
						else if(i==3 && j==0)
							board[i][j]=2;
						else if(i==4 && j==0)
							board[i][j]=8;
						else if(i==2 && j==1)
							board[i][j]=14;
						
						// yellow
						else if(i==7 && j==0)
							board[i][j]=3;	
						else if(i==6 && j==0)
							board[i][j]=9;
						else if(i==7 && j==1)
							board[i][j]=15;
						
						//green
						else if(i==9 && j==4)
							board[i][j]=4;	
						else if(i==8 && j==5)
							board[i][j]=10;	
						else if(i==8 && j==3)
							board[i][j]=16;		

						// blue
						else if(i==7 && j==8)
							board[i][j]=5;
						else if(i==6 && j==8)
							board[i][j]=11;
						else if(i==7 && j==7)
							board[i][j]=17;

						// purple
						else if(i==3 && j==8)
							board[i][j]=6;
						else if(i==2 && j==7)
							board[i][j]=12;
						else if(i==4 && j==8)
							board[i][j]=18;
						

						else
							board[i][j]=EMPTY;			
					}
					else;
			 }
		}
	}

	public void paintComponent(Graphics g)
	{	
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		super.paintComponent(g2);
		//draw grid
		for (int i=0;i<BSIZE;i++) {
			for (int j=0;j<BSIZE;j++) {
				if(i>=3 && i<=7 && (j==0 || j==8))
					hexmech_pointy.drawHex(i,j,g2);
				else if(i>=2 && i<=7 && (j==1 || j==7))
					hexmech_pointy.drawHex(i,j,g2);
				else if(i>=2 && i<=8 && (j==2 || j==6))
					hexmech_pointy.drawHex(i,j,g2);
				else if(i>=1 && i<=8 && (j==3 || j==5 || j==4))
					hexmech_pointy.drawHex(i,j,g2);
				else if(i>=1 && i<=9 && j==4)
					hexmech_pointy.drawHex(i,j,g2);
				else;
			}
		}
		//fill in hexes
		for (int i=0;i<BSIZE;i++) {
			for (int j=0;j<BSIZE;j++) {					
				if(i>=3 && i<=7 && (j==0 || j==8))
					hexmech_pointy.fillHex(i,j,board[i][j],g2);
				else if(i>=2 && i<=7 && (j==1 || j==7))
					hexmech_pointy.fillHex(i,j,board[i][j],g2);
				else if(i>=2 && i<=8 && (j==2 || j==6))
					hexmech_pointy.fillHex(i,j,board[i][j],g2);
				else if(i>=1 && i<=8 && (j==3 || j==5 || j==4))
					hexmech_pointy.fillHex(i,j,board[i][j],g2);
				else if(i>=1 && i<=9 && j==4)
					hexmech_pointy.fillHex(i,j,board[i][j],g2);
				else;
			}
		}

	}

	class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel 
		private Component component;

		MyMouseListener(Component component) {
	      this.component = component;
	    }
		public void mouseClicked(MouseEvent e) { 
				      
			JButton button_move = new JButton("Move");
		    PopupFactory factory_move = PopupFactory.getSharedInstance();
		    Popup popup_move = factory_move.getPopup(component, button_move, e.getX() + 180, e.getY() + 100);
		    popup_move.show();
		    
		    JButton button_attack = new JButton("Attack");
		    PopupFactory factory_attack = PopupFactory.getSharedInstance();
		    Popup popup_attack = factory_attack.getPopup(component, button_attack, e.getX() + 180, e.getY() + 130);
		    popup_attack.show();
		    
		    JButton button_cancel = new JButton("Cancel");
		    PopupFactory factory_cancel = PopupFactory.getSharedInstance();
		    Popup popup_cancel = factory_cancel.getPopup(component, button_cancel, e.getX() + 180, e.getY() + 160);
		    popup_cancel.show();
		    
		    ActionListener cancelActionListener = new ActionListener(){
		    	public void actionPerformed(ActionEvent a) {
			    	popup_move.hide();
			    	popup_attack.hide();
			    	popup_cancel.hide();
			     }
		    };
		    
//			public static Object[][] data = {
//				    {"scout", new Integer(1), new Integer(1), new Integer(3), new Integer(2)},
//				    {"sniper", new Integer(2), new Integer(2), new Integer(2), new Integer(3)},
//				    {"tank", new Integer(3), new Integer(3), new Integer(1), new Integer(1)}	     
//				};
		    
		    
		    ActionListener attackActionListener = new ActionListener() {
			     public void actionPerformed(ActionEvent a) {
			    	Point p = new Point( hexmech_pointy.pxtoHex(e.getX(),e.getY()) );
			    	

			    	
			    	if(GUI.rC.canShoot((GUI.robotList).elementAt(N))){
			    		
			    		// for scout 
			    		if(N >= 1 && N<=6){
			    			if(! hexmech_pointy.checkOutofScoutRange(p.x, p.y, N)){
			    				GUI.rC.attack((GUI.robotList).elementAt(N), p);
			    			}
			    		}
			    		
			    		// for sniper 
			    		else if (N >= 7 && N<=12){
			    			if(! hexmech_pointy.checkOutofSniperRange(p.x, p.y, N)){
			    				GUI.rC.attack((GUI.robotList).elementAt(N), p);
			    			}
			    		}
			    		
			    		// for tank
			    		else if (N >= 13 && N<=18){
			    			if(! hexmech_pointy.checkOutofTankRange(p.x, p.y, N)){
			    				GUI.rC.attack((GUI.robotList).elementAt(N), p);
			    			}
			    		}
			    		else;	
			    	}
			    	
			    	
			    	GUI.updateTable();
		        	popup_move.hide();
		        	popup_attack.hide();
		        	popup_cancel.hide();
		        	repaint();
		        	GUI.statusTable.repaint();
		        	GUI.sc.attackPlay();
			     }
			 };
			 
			ActionListener moveActionListener = new ActionListener() {
			        public void actionPerformed(ActionEvent a) {
						
						Point p = new Point( hexmech_pointy.pxtoHex(e.getX(),e.getY()) );
			        	if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return; 
			      
			        	
			        	updateMoveGUI(p);
			        	
			        	GUI.updateTable();
			        	popup_move.hide();
			        	popup_attack.hide();
			        	popup_cancel.hide();
			        	repaint();
			        	GUI.statusTable.repaint();
			        }
			      };
			button_move.addActionListener(moveActionListener);
			 
			button_cancel.addActionListener(cancelActionListener);
			
			button_attack.addActionListener(attackActionListener);

		}
	}//end of MyMouseListener class
	
		public static void updateMoveGUI(Point p){
			
        	if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return; 
      
        	
        	// walk one cell each click time 
        	if (robotController.canMove((GUI.robotList).elementAt(N))){
        	if(p_old[N].y % 2 == 0){
        		if(((p.x <= p_old[N].x) && (p.x >= p_old[N].x - 1 )  && (p.y >= p_old[N].y - 1 ) && (p.y <= p_old[N].y + 1 ) ) || ((p.x == p_old[N].x + 1) && (p.y == p_old[N].y)) ){
        			
        			for(int i=1; i <= 18 ; i++){
						if((p_old[N].x == p_old[i].x) && (p_old[N].y == p_old[i].y) && (i != N) ){
							status_old[N] = i;
							break;
						}
						else 
							status_old[N] = 0;
					}
					board[p_old[N].x][p_old[N].y] = status_old[N];
					
        			p_old[N] = p;
					status_old[N] = board[p.x][p.y];	
					board[p.x][p.y] = N;
					if( (((GUI.robotList).elementAt(N).getLocation().getX() != p.x) || ((GUI.robotList).elementAt(N).getLocation().getY() != p.y)) && !(GUI.robotList).elementAt(N).getisAI())
						robotController.move((GUI.robotList).elementAt(N), GUI.rC.PointToDirection((GUI.robotList).elementAt(N),p));
        		}
        	}
        	else{
        		if(((p.x <= p_old[N].x + 1) && (p.x >= p_old[N].x)  && (p.y >= p_old[N].y - 1 ) && (p.y <= p_old[N].y + 1 ) ) || ((p.x == p_old[N].x - 1) && (p.y == p_old[N].y)) ){
        			for(int i=1; i <= 18; i++){
						if((p_old[N].x == p_old[i].x) && (p_old[N].y == p_old[i].y) && (i != N)){
							status_old[N] = i;
							break;
						}
						else 
							status_old[N] = 0;
					}
					board[p_old[N].x][p_old[N].y] = status_old[N];
        			p_old[N] = p;
					status_old[N] = board[p.x][p.y];	
					board[p.x][p.y] = N;
					if(((GUI.robotList).elementAt(N).getLocation().getX() != p.x) || ((GUI.robotList).elementAt(N).getLocation().getY() != p.y) && !(GUI.robotList).elementAt(N).getisAI())
						robotController.move((GUI.robotList).elementAt(N), GUI.rC.PointToDirection((GUI.robotList).elementAt(N),p));
        		}
        	}
        	
        	}
        	
        	GUI.prosessLabel.setText("Moving " + GUI.robotList.getElementAt(N).getMoved() + " steps" );
        	GUI.updateTable();
//        	repaint();
        	GUI.statusTable.repaint();
		} // end of UpdateMoveGUI()
		
	
} // end of DrawingPanel class
