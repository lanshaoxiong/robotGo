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
    	//gameboardList = newGameboardList;
    
    }


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
    
//    
//    /**
//     *
//     * @return
//     */
//    public void UpdateRobots(int newDirection, int newCurrentHp, int newMoved, boolean newLifeStatus, boolean newAttackStatus, int index, Point newLocation){
//        try{
//            lock.lock();
//            robot temp = robotList.get(index);
//            temp.setDirection(newDirection);
//            temp.setCurrentHp(newCurrentHp);
//            temp.setMoved(newMoved);
//            temp.setAlive(newLifeStatus);
//            temp.setAttacked(newAttackStatus);
//            temp.setLocation(newLocation);
//            //temp.setDamageCaused(newDamageCaused);
//            //temp.setTilesMoved(newTilesMoved);
//            //temp.setKills(newKills);
//            robotList.setElementAt(temp, index);
//        }
//        finally{
//            lock.unlock();
//        }
//    }
      
    
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
    
    
//    public void resetRobotList(){
//    	for(int i = 0; i<= 18; i++){
//    		if(robotlist.getElementAt(i).type == robotClass.SCOUT){
//    			range = 2;
//    			movePoints = 3;
//    			maxHp = 1;
//    			attackPower = 1;
//    		}
//    		if(type == robotClass.SNIPER){
//    			range = 3;
//    			movePoints = 2;
//    			maxHp = 2;
//    			attackPower = 2;
//
//    		}
//    		if(type == robotClass.TANK){
//    			range = 1;
//    			movePoints = 1;
//    			maxHp = 3;
//    			attackPower = 3;
//    		}
//    		currentHp = maxHp;
//    		alive = true;
//    		attacked = false;
//    		moved = 0;
//    		tilesMoved=0;
//    		kills = 0;
//    		direction = 0;
//    		
//    		this.name = newName;
//    		this.team = newTeam;
//    		this.color = newColor;
//    		this.location = location;
//    	}
//    }
    
    
    
    
    
    
    
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
    
//    public boolean isInAttackRange(robot currentRobot, Point target){
//    	
//    }
    
    // helper function
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
    
    public void turn(robot currentRobot){
    	int currentDirection = currentRobot.getDirection();
    	currentDirection++;
    	if (currentDirection > 5)
    		currentDirection = 0;
    	currentRobot.setDirection(currentDirection);
    }
    
    

   public DefaultListModel<robot> getRobotOnTile (Point target) {
//	   DefaultListModel<robot> robotsOnTile = null;
	   DefaultListModel<robot> robotsOnTile = new DefaultListModel<robot>();
	   for (int i = 0; i < robotList.getSize(); i++) {
		   // find the target by searching the robotList
		   if (robotList.getElementAt(i).getLocation() == target) { 
			   // add the robots on this specific tile to a temporary robot list
			   robotsOnTile.addElement(robotList.getElementAt(i));
		   }
	   }
	   return robotsOnTile;	   
   }
    
    
    public void attack(robot currentRobot, Point target){
    	// check if the robot have attacked or not during this term
    	if (currentRobot.attacked() == false) {
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


