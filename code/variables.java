package models;

import java.util.HashMap;
import java.util.Map;

public class variables {
	private Map<String,Object> wordDictionary;
	
	public variables(){
		wordDictionary = new HashMap<String,Object>();
	}
	
	public  Map<String,Object> getDictionary(){
		return wordDictionary;
	}
	
	
	public void defineWord( String name, Object value){
		
		if(wordDictionary.get(name)== null){
			wordDictionary.put(name,value);
		}else{
			System.out.println(name + " already defined");
		}
	}
	
	public void removeWord(String word){
		wordDictionary.remove(word);
	}
	
	public Object findWord(String key){
		return wordDictionary.get(key);
	}
	
	public String valueType(Object value){
		if(value instanceof Boolean){
			return "Boolean";
		}
		if(value instanceof String){
			return "String";
		}
		if(value instanceof Integer){
			return "Integer";
		}
		return "i dont know";
		
	}
	
	
	
	public static void main(String[] args){
		variables w = new variables();
		w.defineWord("aaa", 4);
		w.defineWord("bbb", "fun");
		w.defineWord("ccc", true);
		

		
		if((boolean)w.findWord("ccc")){
			System.out.println(7*(Integer)w.findWord("aaa"));
		}
		
		System.out.println();
		System.out.println((w.getDictionary().toString()));
		System.out.println(w.getDictionary().get("aab"));
	}
}
