package view;


import java.util.*;
public class words {

	private static Map<String,String> wordDictionary;
	

	/**
     * @consturctor  
     **/	
	public words(){
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
		new words();
		words.defineWord("aaa", "bbbbb");
		words.defineWord("aaa", "bffbb");
		//words.removeWord("aaa");
		System.out.println((getDictionary().toString()));
		System.out.println(getDictionary().get("aaa"));
	}
	
}