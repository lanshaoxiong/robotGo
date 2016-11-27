import java.util.Stack;
import models.*;

public class Interpreter {


	public Stack<Object> DS;
	public Stack<Object> CS;
	public Stack<Object> ConS;
	public Stack<Integer> loopCount;
	public Stack<Object> LS;
	public words W;
	public variables V;
	Interpreter() {
		DS = new Stack<Object>();
		CS = new Stack<Object>();
		ConS = new Stack<Object>();
		loopCount = new Stack<Integer>();
		LS = new Stack<Object>();
		
		//String options[]= {"+","-","*","/mod","<",">","<=",">=","=","<>",".","random", "(", "drop", "dup", "swap", "rot", "and", "or", "invert", "if", "else", "then", "do", "loop", "health", "healthleft", "moves", "movesleft", "attack", "range", "team", "type", "turn!", "move!", "shoot!", "check!", "identify!", "send!", "mesg?", "recv!"};
		words W = new words();
		variables V = new variables();
	}

	public static void main(String[] args) throws Exception {

		Interpreter I = new Interpreter();
		
/*
		I.Arithmetic(1, 1, "+");
		int i = (int) I.DS.pop();
		System.out.println(i);

		I.Arithmetic(1, 1, "-");
		i = (int) I.DS.pop();
		System.out.println(i);

		I.Arithmetic(3, 3, "*");
		i = (int) I.DS.pop();
		System.out.println(i);

		I.Arithmetic(32, 11, "/mod");
		i = (int) I.DS.pop();
		System.out.println(i);
		System.out.println(I.DS.pop());

		I.DS.push("Hello");
		System.out.println(I.DS.pop());

		I.DS.push(23);
		I.DS.push(21);
		I.Compare((int) I.DS.pop(), (int) I.DS.pop(), "<");

		if ((Boolean) I.DS.pop()) {
			System.out.println("yo we did it");
		}
		I.Random(1, 20);
		System.out.println(I.DS.pop());
		*/
		//I.Read(": Sentence Hey how are you ; variable NUMBER");
		//System.out.println(words.findWord("Sentence"));
		
		//System.out.println(I.CS.pop());
		//I.Play("1 1 + . 4 3 - . 2 5 * . 47 5 /mod . . ");
		//I.Play("1 drop 2 dup . 3 swap . . ");
		I.Play(" true if 1 drop 2 dup . 3 swap . . else NO . then end . " );
		I.Play("1 2 = if equal else unequal then .");
		I.Play("1 1 <> if different else the_same then . ");
		I.Play("same same <> if different else same then .");
		
		
	}
	
	public void Play(String play) throws Exception{
		Tokenize1 (play);
		
		//"+","-","*","/mod","<",">","<=",">=","=","<>",".","random", 
		//"(", "drop", "dup", "swap", "rot", "and", "or", "invert", "if", 
		//"else", "then", "do", "loop", "health", "healthleft", "moves", 
		//"movesleft", "attack", "range", "team", "type", "turn!", "move!", 
		//"shoot!", "check!", "identify!", "send!", "mesg?", "recv!"
		while(!CS.isEmpty()){
		switch((String)CS.peek()){
		case "+":
			CS.pop();
			Arithmetic((Integer.parseInt((String) DS.pop())), (Integer.parseInt((String) DS.pop())), "+");
			break;
		case "-":
			CS.pop();
			Arithmetic((Integer.parseInt((String) DS.pop())), (Integer.parseInt((String) DS.pop())), "-");
			break;
		case "*":
			CS.pop();
			Arithmetic((Integer.parseInt((String) DS.pop())), (Integer.parseInt((String) DS.pop())), "*");
			break;
		case "/mod":
			CS.pop();
			Arithmetic((Integer.parseInt((String) DS.pop())), (Integer.parseInt((String) DS.pop())), "/mod");
			break;
		case ".":
			CS.pop();
			
			if (!DS.empty()){
			System.out.println(DS.pop());
			}
			else{
				throw new Exception("You can't print from an empty stack!");
			}
			break;
		case "<":
			CS.pop();
			Compare(DS.pop(), DS.pop(), "<");
			break;
		case ">":
			CS.pop();
			Compare(DS.pop(), DS.pop(), ">");
			break;
		case "<=":
			CS.pop();
			Compare(DS.pop(), DS.pop(), "<=");
			break;
		case ">=":
			CS.pop();
			Compare(DS.pop(), DS.pop(), ">=");
			break;
		case "=":
			CS.pop();
			Compare(DS.pop(), DS.pop(), "=");
			break;
		case "<>":
			CS.pop();
			Compare(DS.pop(), DS.pop(), "<>");
			break;
		case "drop":
			CS.pop();
			StackFunction("drop");
			break;
		case "dup":
			CS.pop();
			StackFunction("dup");
			break;
		case "swap":
			CS.pop();
			StackFunction("swap");
			break;
		case "rot":
			CS.pop();
			StackFunction("rot");
			break;
		case "if":
			CS.pop();
			Conditional();
			break;
		case "do":
			CS.pop();
			StartLoop();
			break;
		case "IncreaseIndex":
			int end = loopCount.pop();
			int index = loopCount.pop();
			index++;
			loopCount.push(index);
			loopCount.push(end);
			
			break;
		case "loop":
			loop();
			break;
		default :
			
			if(!CS.isEmpty()){
				DS.push(CS.pop());
			}
		break;
		}
		}
	}
	
	public void loop(){
		
	}
	
	public void StartLoop(){
		loopCount.push((Integer) DS.pop());
		loopCount.push((Integer) DS.pop());

		while(((String) CS.peek()).compareTo("loop")!=0){
			LS.push(CS.pop());
		}
		
		/*
		while(!LS.isEmpty()){
			CS.push(LS.pop());	
		}
		*/	
		CS.push("IncreaseIndex");
		
		
	}
	
	public void Conditional(){
		if (((String) DS.pop()).compareTo("true")==0){
			while(((String) CS.peek()).compareTo("else")!=0){
				ConS.push(CS.pop());
			}
			
			CS.pop();
			
			while(((String) CS.peek()).compareTo("then")!=0){
				CS.pop();
			}
			
			CS.pop();
			
			while(!ConS.isEmpty())
				CS.push(ConS.pop());
				
		}
		else {
			while(((String) CS.peek()).compareTo("else")!=0){
				CS.pop();
			}
			CS.pop();
			while(((String) CS.peek()).compareTo("then")!=0){
				ConS.push(CS.pop());
			}
			CS.pop();
			while(!ConS.isEmpty())
				CS.push(ConS.pop());
			}
		}

	
	public void Read(String code) {
		Tokenize1(code);
		
		String temp = "";
		while(!CS.empty()){
			
		if (CS.peek().equals(":")){
			CS.pop();
			String name= (String)CS.pop();
			while(!CS.peek().equals(";")){
			temp=temp.concat((String)CS.pop()+ " ");
			}
			words.defineWord(name, temp);
			CS.pop();
		}
		else if (CS.peek().equals("variable")){
			CS.pop();
			variables.defineVariable((String)CS.pop());
		}
	
		}
		
	}
	public void Tokenize1(String code){
		Object[] tokens = code.split(" ");
		
		for(Object t : tokens){
			DS.push(t);
			
		}
		
		Object[] tokens2 = new Object[tokens.length];
		for(int i =0; i<tokens.length;i++){
			tokens2[i]= (Object) DS.pop();
		}
		
		for(Object t : tokens2){
			CS.push(t);
			
		}
	}
	public void Arithmetic(int t1, int t2, String op) throws Exception {
		int F = 0;

		if (op.equals("+")) {
			F = t1 + t2;
			DS.push(F);
		} else if (op.equals("-")) {
			F = t2 - t1;
			DS.push(F);
		} else if (op.equals("*")) {
			F = t1 * t2;
			DS.push(F);
		} else if (op.equals("/mod")) {
			if (t2 == 0) {
				throw new Exception("You can't divide by zero ya nutjob");
			}
			F = t2 % t1;
			DS.push(F);
			F = t2 / t1;
			DS.push(F);

		} else {
			throw new Exception("Operator not recognised:" + op);
		}

	}

	public void Compare(Object object, Object object2, String op) throws Exception {
		if (op.equals("<")) {
			if ((int)object2 < (int)object) {
				DS.push("true");
			} else {
				DS.push("false");
			}
		} else if (op.equals(">")) {
			if ((int)object2 > (int)object) {
				DS.push("true");
			} else {
				DS.push("false");
			}
		} else if (op.equals("<=")) {
			if ((int)object2 <= (int)object) {
				DS.push("true");
			} else {
				DS.push("false");
			}
		} else if (op.equals(">=")) {
			if ((int)object2 >= (int)object) {
				DS.push("true");
			} else {
				DS.push("false");
			}
		} else if (op.equals("=")) {
			if (object2.toString().compareTo(object.toString())==0) {
				DS.push("true");
			} else {
				DS.push("false");
			}
		} else if (op.equals("<>")) {
			if (object2.toString().compareTo(object.toString())!=0) {
				DS.push("true");
			} else {
				DS.push("false");
			}
		} else {
			throw new Exception("Operator not recognised: " + op);
		}
	}

	
	
	public void StackFunction(String op) throws Exception {
		if (op.equals("drop")) {
			DS.pop();
		} else if (op.equals("dup")) {
			Object I = DS.pop();
			DS.push(I);
			DS.push(I);
		} else if (op.equals("swap")) {
			Object I = DS.pop();
			Object J = DS.pop();
			DS.push(I);
			DS.push(J);
		} else if (op.equals("rot")) {
			Object I = DS.pop();
			Object J = DS.pop();
			Object K = DS.pop();
			DS.push(J);
			DS.push(I);
			DS.push(K);
		} else {
			throw new Exception("Operator not recognised: " + op);
		}
	}
	public void Random(int min, int max) {
		DS.push(min + (int) (Math.random() * ((max - min) + 1)));
	}

	public void DefineWord(String Word, String Code) {
		words.defineWord(Word, Code);
	}
}