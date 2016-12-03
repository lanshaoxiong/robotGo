package view;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.DefaultListModel;

import view.robot.robotClass;


public class robotController {
  
    public static final String FILE_NAME_robotList = "robotList.txt";

    DefaultListModel<robot> robotList;
    
    Lock lock = new ReentrantLock();
    
   robotController(DefaultListModel<robot> newRobotList){
    	robotList = newRobotList;    
    }
   
   public static DefaultListModel<Point> scanTileList = new DefaultListModel<>();


    /**
     *
     * @return
     */
    public void createRobot(String newName, String newTeam, Color newColor, robotClass newType, Point location){
        try{
            lock.lock();
            robot newRobot = new robot(newName, newTeam, newColor, newType, location);
            robotList.addElement(newRobot);
        }
        finally{
            lock.unlock();
        }
    }

      
    
    /**
     *
     * @return
     */
    public void delete(int index){
//        try{
//            lock.lock();
            robotList.removeElementAt(index);
//        }        
//        finally{
//            lock.unlock();
//        }
    }  
    
    
    // reset all robot after press "end" button
    public void resetRobotList(){
    	for(int i = 0; i<= 18; i++){
    		robotList.getElementAt(i).setCurrentHp(robotList.getElementAt(i).getMaxHp());
    		robotList.getElementAt(i).setAlive(true);
    		robotList.getElementAt(i).setAttacked(false);
    		robotList.getElementAt(i).setMoved(0);

    		if(robotList.getElementAt(i).getColor().equals(Color.red)){
    			robotList.getElementAt(i).setDirection(0);
    			robotList.getElementAt(i).setLocation(new Point(1,4));
    		}
    		else if(robotList.getElementAt(i).getColor().equals(Color.orange)){
    			robotList.getElementAt(i).setDirection(1);
    			robotList.getElementAt(i).setLocation(new Point(3,0));
    		}
    		else if(robotList.getElementAt(i).getColor().equals(Color.yellow)){
    			robotList.getElementAt(i).setDirection(2);
    			robotList.getElementAt(i).setLocation(new Point(7,0));
    		}
    		else if(robotList.getElementAt(i).getColor().equals(Color.green)){
    			robotList.getElementAt(i).setDirection(3);
    			robotList.getElementAt(i).setLocation(new Point(9,4));
    		}
    		else if(robotList.getElementAt(i).getColor().equals(Color.blue)){
    			robotList.getElementAt(i).setDirection(4);
    			robotList.getElementAt(i).setLocation(new Point(7,8));
    		}
    		else if(robotList.getElementAt(i).getColor().equals(Color.MAGENTA)){
    			robotList.getElementAt(i).setDirection(5);
    			robotList.getElementAt(i).setLocation(new Point(3,8));
    		}
    		else;
    	}
    }
    
    

    public void move (robot currentRobot, int direction){
    	// update the coordinates and movePoints info in robotList after each move
    	if (canMove(currentRobot)){ 
    		int moved = currentRobot.getMoved();
    		Point mLocation = this.DirectionToPoint(currentRobot, direction);
    		if((mLocation.x != currentRobot.getLocation().getX()) || (mLocation.y != currentRobot.getLocation().getY())){
    			moved++;
        		currentRobot.setMoved(moved);
        	    currentRobot.setDirection(direction);
        	    currentRobot.setLocation (mLocation);
    		}
    	}
    }
    
    public boolean canMove(robot currentRobot){
    	return (currentRobot.getMoved() < currentRobot.getMovePoints());
    }
    
    public boolean canShoot(robot currentRobot){
    	return !(currentRobot.attacked());
    }
    
    
    public boolean inRange(robot currentRobot, Point target){
    	
    	if(currentRobot.getType() ==  robotClass.SCOUT)
    		return ! (hexmech_pointy.checkOutofScoutRange(target.x, target.y, robotList.indexOf(currentRobot)));
    	else if(currentRobot.getType() ==  robotClass.SNIPER)
    		return ! (hexmech_pointy.checkOutofSniperRange(target.x, target.y, robotList.indexOf(currentRobot)));
    	else if(currentRobot.getType() ==  robotClass.TANK)
    		return ! (hexmech_pointy.checkOutofTankRange(target.x, target.y, robotList.indexOf(currentRobot)));
    	else
    		return false;
    	
    }
    
    
    // helper function for move
    public int PointToDirection(robot currentRobot, Point np){
    	int mx = currentRobot.getLocation().x;
    	int my = currentRobot.getLocation().y;
    	
    	if(my % 2 == 0){
    		if((np.x == mx + 1) && (np.y == my))
    			return 0;
    		else if((np.x == mx) && (np.y == my + 1))
    			return 1; 
    		else if((np.x == mx - 1 ) && (np.y == my + 1))
    			return 2;
    		else if((np.x == mx - 1 ) && (np.y == my))
    			return 3;
    		else if((np.x == mx - 1 ) && (np.y == my - 1))
    			return 4;
    		else if((np.x == mx) && (np.y == my - 1))
    			return 5;
    		else 
    			return currentRobot.getDirection();		
    	}
    	else {
    		if((np.x == mx + 1) && (np.y == my))
    			return 0;
    		else if((np.x == mx + 1) && (np.y == my + 1))
    			return 1; 
    		else if((np.x == mx) && (np.y == my + 1))
    			return 2;
    		else if((np.x == mx - 1 ) && (np.y == my))
    			return 3;
    		else if((np.x == mx) && (np.y == my - 1))
    			return 4;
    		else if((np.x == mx + 1) && (np.y == my - 1))
    			return 5;
    		else 
    			return currentRobot.getDirection();		
    	}
    }
    
    // helper function for move
    // transfer direction info to the corresponding location info 
    public Point DirectionToPoint(robot currentRobot, int nDirection){
    	int mx = currentRobot.getLocation().x;
    	int my = currentRobot.getLocation().y;
    	
    	if(my % 2 == 0){
    		if(nDirection == 0)
    			return new Point(mx+1, my);
    		else if (nDirection == 1)
    			return new Point(mx, my+1);
    		else if (nDirection == 2)
    			return new Point(mx-1, my+1);
    		else if (nDirection == 3)
    			return new Point(mx-1, my);
    		else if (nDirection == 4)
    			return new Point(mx-1, my-1);
    		else if (nDirection == 5)
    			return new Point(mx, my-1);
    		else 
    			return currentRobot.getLocation();
    	}
    	
    	else{
    		if(nDirection == 0)
    			return new Point(mx+1, my);
    		else if (nDirection == 1)
    			return new Point(mx+1, my+1);
    		else if (nDirection == 2)
    			return new Point(mx, my+1);
    		else if (nDirection == 3)
    			return new Point(mx-1, my);
    		else if (nDirection == 4)
    			return new Point(mx, my-1);
    		else if (nDirection == 5)
    			return new Point(mx+1, my-1);
    		else 
    			return currentRobot.getLocation();
    	}
    	
    }
    
    // helper function for move
    public void turn(robot currentRobot){
    	int currentDirection = currentRobot.getDirection();
    	currentDirection++;
    	if (currentDirection > 5)
    		currentDirection = 0;
    	currentRobot.setDirection(currentDirection);
    }
    
    // ==============================================================
    
    
    
    
    public void attack(robot currentRobot, Point target){
    	// check if the robot have attacked or not during this term
    	if (!(currentRobot.attacked()) && inRange(currentRobot, target)) {
    		for (int i = 0; i < getRobotOnTile(target).getSize(); i++) {
    			// calculate HP changes
    			int oldHP = getRobotOnTile(target).getElementAt(i).getCurrentHp();
    			int newHP = oldHP - currentRobot.getAttackPower();
    			// update the HP changes
    			getRobotOnTile(target).getElementAt(i).setCurrentHp(newHP);
    			if (getRobotOnTile(target).getElementAt(i).getCurrentHp() <=0) {
    				getRobotOnTile(target).getElementAt(i).setCurrentHp(0);
    				getRobotOnTile(target).getElementAt(i).setAlive(false);
    			}
    		}
    		currentRobot.setAttacked(true);
    	}	
    }

    
    public DefaultListModel<robot> getRobotOnTile(Point target) {
  	   DefaultListModel<robot> robotsOnTile = new DefaultListModel<robot>();
  	   for (int i = 0; i < robotList.getSize(); i++) {
  		   // find the target by searching the robotList
  		   if (robotList.getElementAt(i).getLocation().x == target.x && robotList.getElementAt(i).getLocation().y == target.y) { 
  			   // add the robots on this specific tile to a temporary robot list
  			   robotsOnTile.addElement(robotList.getElementAt(i));
  		   }
  	   }
  	   return robotsOnTile;	   
     }
    
    
    public DefaultListModel<robot> identify(int index) {
 	   DefaultListModel<robot> robotsOnTile = new DefaultListModel<robot>();
 	   for (int i = 0; i < robotList.getSize(); i++) {
 		   // find the target by searching the robotList
 		   if (robotList.getElementAt(i).getLocation().x == scanTileList.getElementAt(index).x && robotList.getElementAt(i).getLocation().y == scanTileList.getElementAt(index).y) { 
 			   // add the robots on this specific tile to a temporary robot list
 			   robotsOnTile.addElement(robotList.getElementAt(i));
 		   }
 	   }
 	   return robotsOnTile;	   
    }
    
    
    
//    // for AI shooting 
    public int scan(robot currentRobot){
    	
    	if(currentRobot.getType() == robotClass.SCOUT){
    		for(int i = currentRobot.getLocation().x - 2; i<= currentRobot.getLocation().x + 2; i++){
    			for (int j = currentRobot.getLocation().y - 2; i<= currentRobot.getLocation().y + 2; j++){
    				if(inRange(currentRobot, new Point(i,j)) && (DrawingPanel.board[i][j] > 0)){
    					scanTileList.addElement(new Point(i,j));
    				}
    			}
    		}
    	}
    	else if (currentRobot.getType() == robotClass.SNIPER){
    		for(int i = currentRobot.getLocation().x - 3; i<= currentRobot.getLocation().x + 3; i++){
    			for (int j = currentRobot.getLocation().y - 3; i<= currentRobot.getLocation().y + 3; j++){
    				if(inRange(currentRobot, new Point(i,j)) && (DrawingPanel.board[i][j] > 0)){
    					scanTileList.addElement(new Point(i,j));
    				}
    			}
    		}
    	}
    	else if(currentRobot.getType() == robotClass.TANK){
    		for(int i = currentRobot.getLocation().x - 1; i<= currentRobot.getLocation().x + 1; i++){
    			for (int j = currentRobot.getLocation().y - 1; i<= currentRobot.getLocation().y + 1; j++){
    				if(inRange(currentRobot, new Point(i,j)) && (DrawingPanel.board[i][j] > 0)){
    					scanTileList.addElement(new Point(i,j));
    				}
    			}
    		}
    	}
    	else;
    	
    	return scanTileList.getSize();
    	
    }

    
    public void goNext(){
    	robotList.getElementAt(DrawingPanel.N).setMoved(0);
		robotList.getElementAt(DrawingPanel.N).setAttacked(false);
		
		if (DrawingPanel.Q == 2){
			DrawingPanel.N = DrawingPanel.N + 3;
			if((DrawingPanel.N) > 18)
				(DrawingPanel.N) = 1;
			while(!robotList.getElementAt(DrawingPanel.N).alive()){
				DrawingPanel.N = DrawingPanel.N + 3;
				if((DrawingPanel.N) > 18)
					(DrawingPanel.N) = 1;
			}
		}
		
		
//		if (DrawingPanel.Q == 2){
//			DrawingPanel.N = temp;
//			DrawingPanel.N = DrawingPanel.N + 3;
//			if((DrawingPanel.N) > 18)
//				(DrawingPanel.N) = 1;
//			temp = DrawingPanel.N;
//			while(!robotList.getElementAt(DrawingPanel.N).alive()){
//				DrawingPanel.N = DrawingPanel.N + 6;
//				if((DrawingPanel.N) > 18)
//					DrawingPanel.N = 1;
//			}
//			
//		}
		else if (DrawingPanel.Q == 3){
			DrawingPanel.N = DrawingPanel.N + 2;
			if((DrawingPanel.N) > 18)
				(DrawingPanel.N) = 1;
			while(!robotList.getElementAt(DrawingPanel.N).alive()){
				DrawingPanel.N = DrawingPanel.N + 2;
				if((DrawingPanel.N) > 18)
					(DrawingPanel.N) = 1;
			}
		}
		else if (DrawingPanel.Q == 6){
			DrawingPanel.N = DrawingPanel.N + 1;
			if((DrawingPanel.N) > 18)
				(DrawingPanel.N) = 1;
			while(!robotList.getElementAt(DrawingPanel.N).alive()){
				DrawingPanel.N = DrawingPanel.N + 1;
				if((DrawingPanel.N) > 18)
					(DrawingPanel.N) = 1;
			}
		}
		else;
		
		scanTileList.removeAllElements(); 
		
		// when overlapping, show the specific robot on the overlapping cell
		DrawingPanel.board[DrawingPanel.p_old[DrawingPanel.N].x][DrawingPanel.p_old[DrawingPanel.N].y] = DrawingPanel.N;
		GUI.updateTable();
		GUI.statusTable.repaint();
		GUI.gameBoardPanel.repaint();
		
		scanTileList.removeAllElements();
    }
    
    // for AI move 
    public String check(robot currentRobot, int direction){
    	Point target = DirectionToPoint(currentRobot, direction);
    	if (checkInBoundary(target.x, target.y)){
    		if(DrawingPanel.board[target.x][target.y] > 0)
    			return "OCCUPIED";
    		else 
    			return "EMPTY";
    	}
    	else
    		return "OUT OF BOUNDS";
    }  

    
    
    
    // check for boundary
    public boolean checkInBoundary(int i, int j){
    	if(i>=3 && i<=7 && (j==0 || j==8))
			return true;
		else if(i>=2 && i<=7 && (j==1 || j==7))
			return true;
		else if(i>=2 && i<=8 && (j==2 || j==6))
			return true;
		else if(i>=1 && i<=8 && (j==3 || j==5 || j==4))
			return true;
		else if(i>=1 && i<=9 && j==4)
			return true;
		else
			return false;
    }
    

    
//    ================================================================================================
    

    /**
     *
     * @return
     */
    public void readFromFile() throws IOException, ClassNotFoundException{
        ObjectInputStream is_robot = new ObjectInputStream(new FileInputStream(FILE_NAME_robotList));
        DefaultListModel<robot> inObject_robot =  (DefaultListModel<robot>) is_robot.readObject();
        is_robot.close();
        robotList.removeAllElements();
        while(!inObject_robot.isEmpty()){
            robotList.addElement(inObject_robot.remove(0));
        }
        
        //ObjectInputStream is_gameboard = new ObjectInputStream(new FileInputStream(FILE_NAME_gameboardList));
        //DefaultListModel<gameboard> inObject_underGrad =  (DefaultListModel<gameboard>) is_gameboard.readObject();
        //is_gameboard.close();
        //gameboardList.removeAllElements();
        //while(!inObject_gameboard.isEmpty()){
            //gameboardList.addElement(inObject_gameboard.remove(0));
        //}
        
    }
    
    /**
     *
     * @return
     */
    public void writeToFile() throws IOException{
        ObjectOutputStream os_robot = new ObjectOutputStream(new FileOutputStream(FILE_NAME_robotList));
        os_robot.writeObject(robotList);
        os_robot.close();
        
        //ObjectOutputStream os_gameboard = new ObjectOutputStream(new FileOutputStream(FILE_NAME_gameboardList));
        //os_gameboard.writeObject(gameboardList);
        //os_gameboard.close();

    }
    

    
}


