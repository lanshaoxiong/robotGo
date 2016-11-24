package view;


import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
			
			static int counter = 0;
			static int PlayersNumber = 6;	
			
			static Point p_old = new Point(0,0);
			
			
			


	public DrawingPanel()
	{	
		initialHex();
		setBackground(COLOURBACK);

		MyMouseListener ml = new MyMouseListener();            
		addMouseListener(ml);
	}
	
	public DrawingPanel(int size)
	{	
		HEXSIZE = size;
		initialHex();
		setBackground(COLOURBACK);

		MyMouseListener ml = new MyMouseListener();            
		addMouseListener(ml);
	}
	
	 private void initialHex(){

			hexmech_pointy.setXYasVertex(false); //RECOMMENDED: leave this as FALSE.

			hexmech_pointy.setHeight(HEXSIZE); //Either setHeight or setSize must be run to initialize the hex
			hexmech_pointy.setBorders(BORDERS);

			for (int i=0;i<BSIZE;i++) {
				for (int j=0;j<BSIZE;j++) {
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
		public void mouseClicked(MouseEvent e) { 
			board[p_old.x][p_old.y] = 0;
			Point p = new Point( hexmech_pointy.pxtoHex(e.getX(),e.getY()) );
			p_old = p;
			
			if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return;

			//What do you want to do when a hexagon is clicked?
			board[p.x][p.y] = (int)'X';
			//counter++;
			repaint();
		}		 
	} //end of MyMouseListener class 
} // end of DrawingPanel class