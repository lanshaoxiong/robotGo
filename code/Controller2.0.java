package theController;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.DefaultListModel;

import models.robot;
import models.robot.coord;
import models.robot.robotClass;

public class controller {
  
    public static final String FILE_NAME_robotList = "robotList.txt";

    DefaultListModel<robot> robotList;
    //DefaultListModel<gameboard> gameboardList;
    
    Lock lock = new ReentrantLock();
    
   controller(DefaultListModel<robot> newRobotList){
    	robotList = newRobotList;
    	//gameboardList = newGameboardList;
    
    }


    /**
     *
     * @return
     */
    public void createRobot(String newName, String newTeam, Color newColor, robotClass newType){
        try{
            lock.lock();
            robot newRobot = new robot(newName,newTeam,newColor,newType);
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
    public void UpdateRobots(int newDirection, int newCurrentHp, int newMoved, boolean newLifeStatus, boolean newAttackStatus, int index, coord newLocation){
        try{
            lock.lock();
            robot temp = robotList.get(index);
            temp.setDirection(newDirection);
            temp.setCurrentHp(newCurrentHp);
            temp.setMoved(newMoved);
            temp.setAlive(newLifeStatus);
            temp.setAttacked(newAttackStatus);
            temp.setLocation(newLocation);
            //temp.setDamageCaused(newDamageCaused);
            //temp.setTilesMoved(newTilesMoved);
            //temp.setKills(newKills);
            robotList.setElementAt(temp, index);
        }
        finally{
            lock.unlock();
        }
    }
      
    
    /**
     *
     * @return
     */
    public void delete(int index, int list_number){
        try{
            lock.lock();
            if(list_number == 1)
                robotList.removeElementAt(index);
            //else if(list_flag == 2)
                //gameboardList.removeElementAt(index);
        }        
        finally{
            lock.unlock();
        }
    }  
    
    
    public void move (robot currentRobot){
    	// update the coordinates and movePoints info in robotList after each move
    	int moved = currentRobot.getMoved();
    	if ( moved <= currentRobot.getMovePoints()){
    	    int robotIndex = robotList.indexOf(currentRobot); // answers the question above  
    	    int currentDirection = currentRobot.getDirection();
    	    coord currentLocation =  currentRobot.getLocation();
    	    currentRobot.setDirection(currentDirection);
    	    currentRobot.setLocation(currentLocation);
    	    moved ++;
    	    UpdateRobots(currentDirection, currentRobot.getCurrentHp(), currentRobot.getMoved(), 
    			currentRobot.alive(), currentRobot.attacked(),robotIndex,currentLocation);
    	}

    }
    
   public boolean isInRange (robot currentRobot, coord target) {
	   // for human it could be always true based on design
	   // for AI it's another case, will implement this later tonight
	   return true;
   }
    
   @SuppressWarnings("null")
   public DefaultListModel<robot> getRobotOnTile (coord target) {
	   DefaultListModel<robot> robotsOnTile = null;
	   for (int i = 0; i < robotList.getSize(); i++) {
		   // find the target by searching the robotList
		   if (robotList.getElementAt(i).getLocation() == target) { 
			   // add the robots on this specific tile to a temporary robot list
			   robotsOnTile.addElement(robotList.getElementAt(i));
		   }
	   }
	   return robotsOnTile;	   
   }
    
    
    public void attack(robot currentRobot, coord target){
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
    	}
    	currentRobot.setAttacked(true);
        
    	// update the robotLists, first update the current robot 
	    UpdateRobots(currentRobot.getDirection(), currentRobot.getCurrentHp(), currentRobot.getMoved(), currentRobot.alive(), 
	    		     currentRobot.attacked(),robotList.indexOf(currentRobot),currentRobot.getLocation());
	    
	    // then update the robot(s) which were attacked
	    for(int i = 0; i < robotList.getSize();i++) {
	    	for(int j = 0; j < getRobotOnTile(target).getSize(); j++) {
	    		// loop through two lists to find the matching robots
	    		if (robotList.getElementAt(i).getLocation() == getRobotOnTile(target).getElementAt(j).getLocation()){
	    			// update robot list with the robot stat in robotOnTile list
	    			robot matchingRobot = getRobotOnTile(target).getElementAt(j);
	    			UpdateRobots(matchingRobot.getDirection(), matchingRobot.getCurrentHp(), matchingRobot.getMoved(), 
	    					     matchingRobot.alive(), matchingRobot.attacked(), i, matchingRobot.getLocation());
	    		}
	    	}
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


