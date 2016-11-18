

package models;
import java.util.*;


public class mailbox {
	List<String> messages;

	public mailbox(){
		messages = new ArrayList<String>();
	}
	
	public void addMessage(String newMessage){
		if(messages.size()<7){
			messages.add(newMessage);
		}
		if(messages.size()==7){
			messages.remove(0);
		}
	}
	
	public void removeMessage(String message){
		messages.remove(message);
	}
	
	public ArrayList<String> getMessages(){
		return (ArrayList<String>)messages;
	}

	public static void main(String[] args){
		mailbox m1 = new mailbox();
		

		m1.addMessage("1");
		m1.addMessage("2");
		m1.addMessage("3");
		m1.addMessage("4");
		m1.addMessage("5");
		m1.addMessage("6");
		m1.addMessage("7");
		m1.addMessage("8");
		//System.out.println(m1.getMessages().get(3));
		//System.out.println(m1.getMessages().size());
		System.out.print(m1.getMessages().toString());
	}
	
	
}

