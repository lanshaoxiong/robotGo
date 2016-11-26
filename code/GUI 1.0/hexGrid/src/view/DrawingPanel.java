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
			final static Color COLOURCELL =  Color.WHITE;	 
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
			final static Color COLOURTWOTXT = new Color(255,100,255);
			final static int EMPTY = 0;
			final static int BSIZE = 10; //board size.
		    static int HEXSIZE = 80;	//hex size in pixels
			
			final static int BORDERS = 20;  
			final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS*3; //screen size (vertical dimension).

			int[][] board = new int[BSIZE][BSIZE];
			
			static int PlayersNumber = 6;
			static int N = 1;
			
			static Point [] p_old = {new Point(0,0), new Point(1,4), new Point(3,0), new Point(7,0), new Point(9,4), new Point(7,8), new Point(3, 8)};
			static int [] status_old = {0,0,0,0,0,0,0};

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

			for (int i=0;i<BSIZE;i++) {
				for (int j=0;j<BSIZE;j++) {
					if(i==1 && j==4)
						board[i][j]=1;
					else if(i==3 && j==0)
						board[i][j]=2;
					else if(i==7 && j==0)
						board[i][j]=3;
					else if(i==9 && j==4)
						board[i][j]=4;
					else if(i==7 && j==8)
						board[i][j]=5;
					else if(i==3 && j==8)
						board[i][j]=6;
					else
						board[i][j]=EMPTY;			
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
		    
		    ActionListener cancelActionListener = new ActionListener() {
			     public void actionPerformed(ActionEvent a) {
			    	popup_move.hide();
			    	popup_attack.hide();
			    	popup_cancel.hide();
			     }
			 };
			 
			ActionListener moveActionListener = new ActionListener() {
			        public void actionPerformed(ActionEvent a) {
			        	
						for(int i=1; i<=PlayersNumber; i++){
							if((p_old[N].x == p_old[i].x) && (p_old[N].y == p_old[i].y) && (i != N)){
								status_old[N] = i;
								break;
							}
							else 
								status_old[N] = 0;
						}
						board[p_old[N].x][p_old[N].y] = status_old[N];
						
						Point p = new Point( hexmech_pointy.pxtoHex(e.getX(),e.getY()) );
			        	if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return; 
						
			        	p_old[N] = p;
						status_old[N] = board[p.x][p.y];	
						board[p.x][p.y] = N;
						
			        	popup_move.hide();
			        	popup_attack.hide();
			        	popup_cancel.hide();
			        	repaint();
			        }
			      };
			button_move.addActionListener(moveActionListener);
			 
			button_cancel.addActionListener(cancelActionListener);
			

		}

	}//end of MyMouseListener class 
} // end of DrawingPanel class
