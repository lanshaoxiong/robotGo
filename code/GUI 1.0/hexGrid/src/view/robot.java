package view;

import java.awt.*;
import javax.swing.*;



import java.awt.Color;

public class robot {
	private String name;
	private String team;
	private Color color;
	private int direction;
	private int maxHp;
	private int currentHp;
	private int range;
	private int movePoints;
	private int moved;
	private boolean alive;
	private robotClass type;
	private boolean isAI;
	
	private int damageCaused;
	private int tilesMoved;
	private int kills;
	private int attackPower;
	private Point location;
	private String forthCode;
	
//	private boolean canMove;
	private boolean attacked;
	
	
	public enum robotClass{
		SCOUT, SNIPER, TANK
	}
	
	public robot(String newName, String newTeam, Color newColor, robotClass type, Point location){
		if(type == robotClass.SCOUT){
			range = 2;
			movePoints = 3;
			maxHp = 1;
			attackPower = 1;
		}
		if(type == robotClass.SNIPER){
			range = 3;
			movePoints = 2;
			maxHp = 2;
			attackPower = 2;

		}
		if(type == robotClass.TANK){
			range = 1;
			movePoints = 1;
			maxHp = 3;
			attackPower = 3;
		}
		
		// initialize the direction for different team.
		if(newColor.equals(Color.red)){
			direction = 0;
			isAI = DrawingPanel.isAI[1];
		}
		else if(newColor.equals(Color.orange)){
			direction = 1;
			isAI = DrawingPanel.isAI[2];
		}
		else if(newColor.equals(Color.yellow)){
			direction = 2;
			isAI = DrawingPanel.isAI[3];
		}
		else if(newColor.equals(Color.green)){
			direction = 3;
			isAI = DrawingPanel.isAI[4];
		}
		else if(newColor.equals(Color.blue)){
			direction = 4;
			isAI = DrawingPanel.isAI[5];
		}
		else if(newColor.equals(Color.MAGENTA)){
			direction = 5;
			isAI = DrawingPanel.isAI[6];
		}
		else;
		
		currentHp = maxHp;
		alive = true;
		attacked = false;
		moved = 0;
		tilesMoved=0;
		kills = 0;
		this.name = newName;
		this.team = newTeam;
		this.color = newColor;
		this.location = location;
		this.type = type;
		this.forthCode = "move! move!";
//				" variable moved ; ( have I moved? ) : moved? moved ? ;moved false ! : firstMove ( align along left edge )        moved? if                            
//					                     ( already moved )           
//					                   else                          
//					                     5 turn!                     
//					                   then ;                        
//					                                                 
//					     : edgeMove ( -- ) ( move along an edge )    
//					                0 check!                         
//					                .\ OUT OF BOUNDS\  =             
//					                if                               
//					                  1 turn!                        
//					                else                             
//					                  ( )                            
//					                then move! ;                     
//					                                                 
//					     : noMovesLeft? ( -- b ) ( no moves left? )  
//					                  movesLeft 0 <> ;               
//					                                                 
//					     variable shot ; ( have I shot this play? )  
//		                             : canShoot? ( -- b ) ( shot available? )    
//					                 shot? ;                         
//					                                                 
//					     : shoot!! ( id ir -- ) ( shoot if allowed ) 
//					               canShoot? if                      
//					                  pop pop      ( remove ir id )  
//					               else                              
//					                   shoot!      ( really shoot )  
//					                   shot true ! ( remember it )   
//					                 then                            
//					               then ;                            
//					                                                 
//					     : doNotShoot ( id ir -- ) ( pretend shot )  
//					                  pop pop ;                      
//					                                                 
//					     : enemy? ( s -- b ) ( decide if enemy )     
//					              team <> ;                          
//					                                                 
//					     : nonZeroRange? ( i -- b i )                
//					                  dup 0 <> ;                     
//					                                                 
//					     : tryShooting! ( ih id ir st -- )           
//					                  enemy?                         
//					                  swap nonZeroRange? rot         
//					                  and if                         
//		                                                shoot!!                  
//		                                              else                       
//		                                                doNotShoot               
//		                                              then pop ( remove ih ) ;   
//		                                                                         
//					     : shootEveryone ( try shot at all targets ) 
//					            scan!                                
//					            1 -                                  
//					            dup 0 < if                           
//					              ( no one to shoot at )             
//		                                    else 0 do                            
//					                     I identify! tryShooting!    
//					                   loop                          
//					            then ;                               
//		                                                                         
//					     : play ( -- )                               
//					            firstMove                            
//					            shot false ! ( prepare to shoot )    
//		                                    begin                                
//		                                      edgeMove                           
//					              shootEveryone                      
//					            noMovesLeft? until ;        "         
//					  
		} // end of constructor
				

	public String getInfo(){
		return "Team: " + team + ", "+  " Name: " + name + ", " + "Type: " + type;
	}
	
	
	public boolean getisAI(){
		return isAI;
	}
	
	public void setisAI(boolean status){
		isAI = status;
	}
	
	public String getName(){
		return name; 
	}
	
	public String getTeam(){
		return team;
	}
	
	public Color getColor(){
		return color;
	}
	
	public int getDirection(){
		return direction;
	}
	
	public int getMaxHp(){
		return maxHp;
	}
	
	public int getCurrentHp(){
		return currentHp;
	}
	
	public int getRange(){
		return range;
	}
	
	public int getMovePoints(){
		return movePoints;
	}
	
	public int getMoved(){
		return moved;
	}
	
	public boolean alive(){
		return alive;
	}
	public boolean attacked(){
		return attacked;
	}
	
	public int getDamageCaused(){
		return damageCaused;
	}
	
	public int getTilesMoved(){
		return tilesMoved;
	}
	
	public int getKills(){
		return kills;
	}
	
	public Point getLocation(){
		return location;
	}

	public int getAttackPower(){
		return attackPower;
	}
	
	public String getforthCode(){
		return forthCode;
	}
	
	public robotClass getType(){
		return type;
	}
	
	
	
	public void setName(String newName){
		name = newName; 
	}
	
	public void setTeam(String newTeam){
		team = newTeam;
	}
	
	public void setColor(Color newColor){
		color=newColor;
	}
	
	public void setDirection(int newDirection){
		direction = newDirection;
	}
	
	public void setMaxHp(int newMaxHp){
		maxHp = newMaxHp;
	}
	
	public void setCurrentHp(int newCurrentHp){
		currentHp = newCurrentHp;
	}
	
	public void setRange(int newRange){
		range = newRange;
	}
	
	public void setMovePoints(int newMovePoints){
		movePoints = newMovePoints;
	}
	
	public void setMoved(int newMoved){
		moved= newMoved;
	}
	
	public void setAlive(boolean newStatus){
		alive = newStatus;
	}
	public void setAttacked(boolean newStatus){
		attacked = newStatus;
	}
	
	public void setDamageCaused(int newDamageCaused){
		damageCaused = newDamageCaused;
	}
	
	public void setTilesMoved(int newTilesMoved){
		tilesMoved = newTilesMoved;
	}
	
	public void setKills(int newKills){
		 kills = newKills;
	}

	public void setCode(String newForthCode){
		forthCode = newForthCode;
	}

	public void setLocation (Point newLocation){
		this.location = newLocation;
	}

	
	
}