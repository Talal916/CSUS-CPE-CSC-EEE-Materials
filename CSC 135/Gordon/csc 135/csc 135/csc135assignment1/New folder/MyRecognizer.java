import java.io.IOException;
import java.util.Scanner;
//--------------------------------------------
// Recognizer for simple expression grammar
// Written by Amrit Singh.
// Some methods implemented by Scott Gordon (with permission).
// 
// to run on Athena (linux) -
//    save as:  MyRecognizer.java
//    compile:  javac MyRecognizer.java
//    execute:  java MyRecognizer
//
// EBNF Grammar is -
//	function ::=  B {statemt}
//	statemt  ::=  assnmt | ifstmt | loop | read | output | funcall
//	assnmt   ::=  ident ~ exprsn ;
//	ifstmt   ::=  I comprsn @ {statemt} [% {statemt}] &
//	loop     ::=  W comprsn L {statemt} T
//	read     ::=  R ident {, ident } ;
//	output   ::=  O ident {, ident } ;
//	funcall  ::=  C function E
//	comprsn  ::=  ( oprnd opratr oprnd )
//	exprsn   ::=  factor {+ factor}
//	factor   ::=  oprnd {* oprnd}
//	oprnd    ::=  integer | ident | ( exprsn )
//	opratr   ::=  < | = | > | !
//	ident    ::=  letter {char}
//	char     ::=  letter | digit
//	integer  ::=  digit {digit}
//	letter   ::=  X | Y | Z
//	digit    ::=  0 | 1 | 2 | 3 | 4 | 5 | 6 | 7
//--------------------------------------------

public class MyRecognizer 
{
//-----------------Implemented by Dr. Scott Gordon[token(), advancePtr(), match(), error()]------------------

	  static String inputString;
	  static int index = 0;
	  static int errorflag = 0;

	  private char token()
	  { return(inputString.charAt(index)); }

	  private void advancePtr()
	  { if (index < (inputString.length()-1)) index++; }

	  private void match(char T)
	  { if (T == token()) advancePtr(); else error(); }

	  private void error()
	  {
	    System.out.println("error at position: " + index);
	    errorflag = 1;
	    advancePtr();
	  }
	  
//-----------------------------------
	  
	  private void function() 
	  {
		  match('B');
		  while(token() == 'X' || token()== 'Y' || token()== 'Z' || token()== 'I'||  token()=='W' || token()== 'R' || token()== 'O' || token()== 'C')
			  statemt();
		   
		  	
	  }
	  private void statemt() 
	  {
		  
		    if(token() == 'X' || token()== 'Y' || token() == 'Z')
		    	assnmt();
		    else if(token()== 'I')
		    	ifstmt();
		    else if(token()=='W')
		    	loop();
		    else if(token()== 'R')
		    	read();
		    else if(token()== 'O')
		    	output();
		    else if(token()=='C')
		    	funcall();
		    else error();
		   
	  }
	  private void assnmt() 
	  {
		  ident();
		  match('~');
		  exprsn();
		  match(';');
	  }
	  private void ifstmt() 
	  {
		  match('I');
		  comprsn();
		  match('@');
		  while(token() == 'X' || token()== 'Y' || token()== 'Z' || token()== 'I'||  token()=='W' || token()== 'R' || token()== 'O' || token()== 'C')
		    	statemt();
		  if(token()== '%') 
		  {
			  match('%');
			  while(token() == 'X' || token()== 'Y' || token()== 'Z' || token()== 'I'||  token()=='W' || token()== 'R' || token()== 'O' || token()== 'C')
			  {
				  statemt();
			  }
			  match('&');
		  }else
			  match('&');
			  
	  }
	  private void loop() 
	  {
		  match('W');
		  comprsn();
		  match('L');
		  while(token() == 'X' || token()== 'Y' || token()== 'Z' || token()== 'I'||  token()=='W' || token()== 'R' || token()== 'O' || token()== 'C')
		    	statemt();
		  match('T');
	  }
	  private void read() 
	  {
		  match('R');
		  ident();
		  while(token()==',') 
		  {
			  match(',');
		  	  ident();	
		  }	  
		  match(';');
	  }
	  private void output() 
	  {
		  match('O');
		  ident();
		  while(token()==',') 
		  {
			  match(',');
		  	  ident();	
		  }
		  match(';');
		  
	  }
	  private void funcall() 
	  {
		  match('C');
		  function();
		  match('E');
	  }
	  private void comprsn()
	  {
		  match('(');
		  oprnd();
		  opratr();
		  oprnd();
		  match(')');
		  
	  }
	  private void exprsn() 
	  {
		  factor();
		  while(token()=='+')
		  {
			  match('+');
			  factor();
		  }
	  }
	  private void factor() 
	  {
		  oprnd();
		  while(token()=='*')
		  {
			  match('*');
			  oprnd();
			  
		  }

	  }
	  private void oprnd()
	  {
		  if(token()=='0'||token()== '1' ||token()== '2'||token()== '3'||token()== '4'||token()== '5'||token()== '6'||token()== '7')
			  integer();
		  if(token()== 'X'||token()== 'Y'||token()== 'Z')
		    ident();
		  else
		    match('(');
		    exprsn();
		    match(')');
		   
		  
	  }
	  private void opratr() {
		  if(token()== '<') match('<');
		  if(token()== '=') match('=');
		  if(token()== '>') match('>');
		  else  match('!');		  
	  }
	  private void ident() 
	  {
		  letter();
		  while((token() == '0') || (token() == '1')|| (token() == '2')|| (token() == '3')|| (token() == '4')|| (token() == '5')|| (token() == '6')|| (token() == '7') ||token()== 'X'||token()== 'Y'||token()== 'Z')
		  {
			  chr();
		  }
	  }
	  private void chr() {
		  if((token() == 'X') || (token() == 'Y') || (token() == 'Z'))
			  letter();
		  else
			  digit();
	  }
	  private void integer() 
	  {
		  while('0' <= token() && token() <= '7')
		  {
			  digit();
		  }
	  }
	  private void letter()
	  {
		  if ((token() == 'X') || (token() == 'Y') || (token() == 'Z'))  
			  match(token()); 
		  else error();
	  }
	  private void digit() 
	  {
		  //if ('0' <= token() && token() <= '7')
		  if ((token() == '0') || (token() == '1')|| (token() == '2')|| (token() == '3')|| (token() == '4')|| (token() == '5')|| (token() == '6')|| (token() == '7')) 
			  match(token()); 
		  else error(); 
		   
	  }
	 
//-----------------Implemented by Dr. Scott Gordon [start(),main()]------------------
	  private void start()
	  {
	    function();
	    match('$');

	    if (errorflag == 0)
	      System.out.println("legal." + "\n");
	    else
	      System.out.println("errors found." + "\n");
	  }
	  
	  public static void main (String[] args) throws IOException
	  {
	    MyRecognizer rec = new MyRecognizer();

	    Scanner input = new Scanner(System.in);

	    System.out.print("\n" + "enter an expression: ");
	    inputString = input.nextLine();

	    rec.start();
	  }
//-------------------------------------------

}
