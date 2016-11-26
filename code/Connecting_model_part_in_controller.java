public class controller {
  
    public static final String FILE_NAME_robotList = "robotList.txt";
    //public static final String FILE_NAME_gameboardList = "gameboardList.txt";

    DefaultListModel<robot> robotList;
    //DefaultListModel<gameboard> gameboardList;
    
    Lock lock = new ReentrantLock();
    
    controller(DefaultListModel<robot> newRobotList){
    	robotList = newRobotList;
    	//gameboardList = newGameboardList;
    
    }

    public enum robotClass{
		SCOUT, SNIPER, TANK
	}
    /**
     *
     * @return
     */
    void createRobot(String newName, String newTeam, Color newColor, robotClass newType){
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
    void UpdateRobots(int newDirection, int newCurrentHp, int newMoved, int newLifeStatus, int newAttackStatus, int index){
        try{
            lock.lock();
            robot temp = listModel_normal.get(index);
            temp.setDirection(newDirection);
            temp.setCurrentHp(newCurrentHp);
            temp.setMoved(newMoved);
            temp.setAlive(newLifeStatus);
            temp.setAttacked(newAttackStatus);
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
    void delete(int index, int list_number){
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
    
    /**
     *
     * @return
     */
    void readFromFile() throws IOException, ClassNotFoundException{
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
    void writeToFile() throws IOException{
        ObjectOutputStream os_robot = new ObjectOutputStream(new FileOutputStream(FILE_NAME_robotList));
        os_robot.writeObject(robotList);
        os_robot.close();
        
        //ObjectOutputStream os_gameboard = new ObjectOutputStream(new FileOutputStream(FILE_NAME_gameboardList));
        //os_gameboard.writeObject(gameboardList);
        //os_gameboard.close();

    }
    

    
}









	




































}