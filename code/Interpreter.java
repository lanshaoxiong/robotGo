package cmpt370project;

import java.util.Stack;
import models.*;

public class Interpreter {

	public Stack<Object> DS;
	public Stack<Object> CS;

	Interpreter() {
		DS = new Stack<Object>();
		CS = new Stack<Object>();
	}

	public static void main(String[] args) throws Exception {

		Interpreter I = new Interpreter();

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
		
		I.Read("Hey how are you");
		System.out.println(I.CS.toString());
		
		System.out.println(I.CS.pop());
	}

	public void Arithmetic(int t1, int t2, String op) throws Exception {
		int F = 0;

		if (op.equals("+")) {
			F = t1 + t2;
			this.DS.push(F);
		} else if (op.equals("-")) {
			F = t1 - t2;
			DS.push(F);
		} else if (op.equals("*")) {
			F = t1 * t2;
			DS.push(F);
		} else if (op.equals("/mod")) {
			if (t1 == 0) {
				throw new Exception("You can't divide by zero ya nutjob");
			}
			F = t1 % t2;
			DS.push(F);
			F = t1 / t2;
			DS.push(F);

		} else {
			throw new Exception("Operator not recognised:" + op);
		}

	}

	public void Compare(int value2, int value1, String op) throws Exception {
		if (op.equals("<")) {
			if (value1 < value2) {
				DS.push(true);
			} else {
				DS.push(false);
			}
		} else if (op.equals(">")) {
			if (value1 > value2) {
				DS.push(true);
			} else {
				DS.push(false);
			}
		} else if (op.equals("<=")) {
			if (value1 <= value2) {
				DS.push(true);
			} else {
				DS.push(false);
			}
		} else if (op.equals(">=")) {
			if (value1 >= value2) {
				DS.push(true);
			} else {
				DS.push(false);
			}
		} else if (op.equals("=")) {
			if (value1 == value2) {
				DS.push(true);
			} else {
				DS.push(false);
			}
		} else if (op.equals("<>")) {
			if (value1 != value2) {
				DS.push(true);
			} else {
				DS.push(false);
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

	public void Read(String code) {
		String[] tokens = code.split(" ");
		
		for(String t : tokens){
			DS.push(t);
			
		}
		
		String[] tokens2 = new String[tokens.length];
		for(int i =0; i<tokens.length;i++){
			tokens2[i]= (String) DS.pop();
		}
		
		for(String t : tokens2){
			CS.push(t);
			
		}
	}

	public void DefineWord(String Word, String Code) {
		words.defineWord(Word, Code);
	}
}