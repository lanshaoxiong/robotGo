package models;
import java.util.*;


public class Tiles {
	List<Integer> robotsOnTile;

	public Tiles(){
		robotsOnTile = new ArrayList<Integer>();
	}
	
	public void addRobotToTile(int newRobotIndex){
		robotsOnTile.add(newRobotIndex);
	}
	
	public void removeRobotFromTile(int RobotIndex){
		robotsOnTile.remove( (Object)RobotIndex);
	}
	
	public ArrayList<Integer> getRobots(){
		return (ArrayList<Integer>)robotsOnTile;
	}

	public static void main(String[] args){
		Tiles tile1 = new Tiles();
		
		tile1.addRobotToTile(1);
		tile1.addRobotToTile(2);
		tile1.addRobotToTile(5);
		tile1.removeRobotFromTile(5);
	
		System.out.print(tile1.getRobots().toString());
	}
	
}
