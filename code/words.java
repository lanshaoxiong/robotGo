package models;
import java.util.*;
public class words {

	private Map<String,String> wordDictionary;
	
	public words(){
		wordDictionary = new HashMap<String,String>();
	}
	
	public  Map<String,String> getDictionary(){
		return wordDictionary;
	}
	
	
	public void defineWord( String name, String script){
		
		if(wordDictionary.get(name)== null){
			wordDictionary.put(name,script);
		}else{
			System.out.println(name + " already defined");
		}
	}
	
	public void removeWord(String word){
		wordDictionary.remove(word);
	}
	
	public String findWord(String key){
		return wordDictionary.get(key);
	}
	
	
	public static void main(String[] args){
		words w = new words();
		w.defineWord("aaa", "bbbbb");
		w.defineWord("aaa", "bffbb");
		w.removeWord("aaa");
		System.out.println((w.getDictionary().toString()));
		System.out.println(w.getDictionary().get("aab"));
	}
	
}
