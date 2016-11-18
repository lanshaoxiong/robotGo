package models;
import java.util.*;

public class gamboard {
	boolean[] players;
	int turn;
	int numberofPlayers;
	Tiles[] tilesonBoard;
	ArrayList<robot> robotsinPlay;
	
	int getRobotIndex(robot r){
		return robotsinPlay.indexOf(r);
	}
	int getTurn(){
		return turn;
	}
	void setTurn(int t){
		turn= t;
	}
	int getNumberofPlayers(){
		return numberofPlayers;
	}
	void setNumofPlayers(int number){
		numberofPlayers=number;
	}
	boolean getPlayers(int index){
		return	players[index];
	}
	void setPlayer(boolean human, int index){
		players[index]=human;
	}
	robot getRobot(int index){
		return robotsinPlay.get(index);
	}
	Tiles getTile(int index){
		return tilesonBoard[index];
	}
}
