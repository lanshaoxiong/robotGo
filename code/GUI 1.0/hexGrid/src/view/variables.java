package view;


import java.util.HashMap;
import java.util.Map;

public class variables {
	private static Map<String,Object> variableDictionary;
	
	public variables(){
		variableDictionary = new HashMap<String,Object>();
	}
	
	public  Map<String,Object> getDictionary(){
		return variableDictionary;
	}
	
	
	public static void defineVariable(String name){
		
		if(variableDictionary.get(name)== null){
			variableDictionary.put(name,0);
		}else{
			System.out.println(name + " already defined");
		}
	}
	
	public static void setVariable(String name, Object value){
		variableDictionary.replace(name, value);
	}
	
	public void removeVariable(String variable){
		variableDictionary.remove(variable);
	}
	
	public static Object findVariable(String key){
		return variableDictionary.get(key);
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
