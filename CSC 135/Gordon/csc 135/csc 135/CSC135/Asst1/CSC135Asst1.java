package abc;

import java.io.IOException;
import java.util.Scanner;

public class Asst1 {
	static String inputString;
	static int index = 0;
	static int errorflag = 0;
	private char token(){ 
		return(inputString.charAt(index)); 
	}
	private void advancePtr(){ 
		if (index < (inputString.length()-1)) index++; 
	}
	private void match(char T){ 
		if (T == token()) advancePtr(); else error(); 
	}
	private void error(){
		System.out.println("error at position: " + index);
		errorflag = 1;
		advancePtr();
	}
	
	
	private void piece() {
		while ("UXYWIP".indexOf(token()) != -1) {
			stmnt();
			if (token() == ';')
				match(';');
		}
		if (token() == 'R' || token() == 'K') {
			lststmnt();
			if (token() == ';')
				match(';');
		}
	}
	private void block() {
		piece();
	}
	private void stmnt() {
		if (token() == 'W')
			whilst();
		else if (token() == 'I')
			ifst();
		else if (token() == 'P')
			forst();
		else
			assignst();
	}
	private void assignst() {
		varlist();
		match('=');
		explst();
	}
	private void whilst() {
		match('W');
		expr();
		match('D');
		block();
		match('E');
	}
	private void ifst() {
		match('I');
		expr();
		match('T');
		block();
		if (token() == 'S') {
			match('S');
			block();
		}
		match('E');
	}
	private void forst() {
		match('P');
		varname();
		match('=');
		expr();
		match(',');
		expr();
		if (token() == ',') {
			match(',');
			expr();
		}
		match('D');
		block();
		match('E');
	}
	private void lststmnt() {
		if (token() == 'R') {
			match('R');
			if ("NFV012345UXY(-&#".indexOf(token()) != -1)
				explst();
		}
		else
			match('K');
	}
	private void varlist() {
		varname();
		while (token() == ',')
			varname();
	}
	private void explst() {
		expr();
		while ("NFV012345UXY(-&#".indexOf(token()) != -1) {
			expr();
			match(',');
		}
	}
	private void expr() {
		if ("-&#".indexOf(token()) != -1) {
			unop();
			expr();
		}
		else {
			term();
			binop();
			expr();
		}
	}
	private void term() {
		if ("NFV".indexOf(token()) != -1) // N | F | V
			match(token());
		else if ("UXY".indexOf(token()) != -1) // letter
			letter();
		else if (token() == '(') { // (expr)
			match('(');
			expr();
			match(')');
		}
		else // num
			num();
	}
	private void binop() {
		if ("+-*/<>AO".indexOf(token()) != -1)
			match(token());
		else
			error();
	}
	private void unop() {
		if ("-&#".indexOf(token()) != -1)
			match(token());
		else
			error();
	}
	private void varname() {
		letter();
		while ("UXY012345".indexOf(token()) != -1) {
			if ("UXY".indexOf(token()) != -1)
				letter();
			else
				digit();
		}
	}
	private void num() {
		digit();
		while("012345".indexOf(token()) != -1)
			digit();
	}
	private void letter() {
		if ("UXY".indexOf(token()) != -1)
			match(token());
		else
			error();
	}
	private void digit() {
		if ("012345".indexOf(token()) != -1)
			match(token());
		else
			error();
	}
	//----------------------
	private void start() {
		term();
		match('$');
		if (errorflag == 0)
			System.out.println("legal." + "\n");
		else
			System.out.println("errors found." + "\n");
	}
	//----------------------
	public static void main (String[] args) throws IOException {
		Asst1 rec = new Asst1();
		Scanner input = new Scanner(System.in);
		System.out.print("\n" + "enter an expression: ");
		inputString = input.nextLine();
		rec.start();
	}
}

