package view;


import java.util.*;
public class words {

	private static Map<String,String> wordDictionary;
	
	public words(){
		wordDictionary = new HashMap<String,String>();
	}
	
	public static Map<String,String> getDictionary(){
		return wordDictionary;
	}
	
	
	public static void defineWord( String name, String script){
		
		if(wordDictionary.get(name)== null){
			wordDictionary.put(name,script);
		}else{
			System.out.println(name + " already defined");
		}
	}
	
	public static void removeWord(String word){
		wordDictionary.remove(word);
	}
	
	public static String findWord(String key){
		return wordDictionary.get(key);
	}
	
	
	public static void main(String[] args){
		new words();
		words.defineWord("aaa", "bbbbb");
		words.defineWord("aaa", "bffbb");
		//words.removeWord("aaa");
		System.out.println((getDictionary().toString()));
		System.out.println(getDictionary().get("aaa"));
	}
	
}
