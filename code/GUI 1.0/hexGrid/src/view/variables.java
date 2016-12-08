package view;


import java.util.HashMap;
import java.util.Map;

public class variables {
	private static Map<String,Object> variableDictionary;

	/**
     * @consturctor  
     **/
	public variables(){
		variableDictionary = new HashMap<String,Object>();
	}
	

	/**
     * @return variable dictionary  
     **/
	public  Map<String,Object> getDictionary(){
		return variableDictionary;
	}
	

	/**
	 * @pre the string name to be difined.
	 * @post output the string name 
     * @return nothing  
     **/	
	public static void defineVariable(String name){
		
		if(variableDictionary.get(name)== null){
			variableDictionary.put(name,0);
		}else{
			System.out.println(name + " already defined");
		}
	}


	/**
	 * @pre the string name, the object value
	 * @post set the variable value
     * @return nothing  
     **/		
	public static void setVariable(String name, Object value){
		variableDictionary.replace(name, value);
	}


	/**
	 * @pre the variable to be removed
	 * @post the variable is removed from the variable dictionary.
     * @return nothing  
     **/		
	public void removeVariable(String variable){
		variableDictionary.remove(variable);
	}

	
	/**
	 * @pre the variable key
	 * @post get the variable key from the dictionary
     * @return nothing  
     **/		
	public static Object findVariable(String key){
		return variableDictionary.get(key);
	}
	


	/**
	 * @pre the variable key
	 * @post get the variable key from the dictionary
     * @return a string, represents the value type. 
     **/		
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
		//w.defineVariable("aaa", 4);
		//w.defineVariable("bbb", "fun");
		//w.defineVariable("ccc", true);
			
		if((boolean)w.findVariable("ccc")){
			System.out.println(7*(Integer)w.findVariable("aaa"));
		}
		
		System.out.println();
		System.out.println((w.getDictionary().toString()));
		System.out.println(w.getDictionary().get("aab"));
	}
}