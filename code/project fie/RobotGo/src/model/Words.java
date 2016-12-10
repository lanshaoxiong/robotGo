package model;


import java.util.*;
public class Words {

	private static Map<String,String> wordDictionary;
	

	/**
     * @constructor  
     **/	
	public Words(){
		wordDictionary = new HashMap<String,String>();
	}
	


	/**
	 * @pre nothing
	 * @post nothing
     * @return the word dictionary
     **/	
	public static Map<String,String> getDictionary(){
		return wordDictionary;
	}
	
	

	/**
	 * @pre the word name to be difined, the script 
	 * @post define the input word if the word is not defined before
     * @return nothing  
     **/	
	public static void defineWord( String name, String script){
		
		if(wordDictionary.get(name)== null){
			wordDictionary.put(name,script);
		}else{
			System.out.println(name + " already defined");
		}
	}
	

	/**
	 * @pre the word name to be removed 
	 * @post the input word is removed
     * @return nothing  
     **/	
	public static void removeWord(String word){
		wordDictionary.remove(word);
	}
	



	/**
	 * @pre the word key
	 * @post nothing
     * @return return the word matches the given key
     **/
	public static String findWord(String key){
		return wordDictionary.get(key);
	}
	
	
	public static void main(String[] args){
		new Words();
		Words.defineWord("aaa", "bbbbb");
		Words.defineWord("aaa", "bffbb");
		//words.removeWord("aaa");
		System.out.println((getDictionary().toString()));
		System.out.println(getDictionary().get("aaa"));
	}
	
}