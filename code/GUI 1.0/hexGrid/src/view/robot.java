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
		if(newColor.equals(Color.red))
			direction = 0;
		else if(newColor.equals(Color.orange))
			direction = 1;
		else if(newColor.equals(Color.yellow))
			direction = 2;
		else if(newColor.equals(Color.green))
			direction = 3;
		else if(newColor.equals(Color.blue))
			direction = 4;
		else if(newColor.equals(Color.MAGENTA))
			direction = 5;
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