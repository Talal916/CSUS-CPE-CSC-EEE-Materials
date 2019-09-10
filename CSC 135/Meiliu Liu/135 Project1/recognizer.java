import java.io.*;
import java.util.Scanner;
//--------------------------------------------
// Recognizer for simple expression grammar
// Written by Talal Jawaid with code used from Scott Gordon's Recognizer
// Talal code consists of methods for handling each non-terminal 
// 9/30/2018
//
// Recognizes legal expressions for the grammar below
// 
// to run on Athena (linux) -
//    save as:  Recognizer.java
//    compile:  javac Recognizer.java
//    execute:  java Recognizer
//
/*  	
 * 
 * 		Input requirements: End all expressions with $
 * 							No White Spaces
 * 							Only enter legal tokens as shown below
 *
 	   function ::=  B {statemt}
       statemt  ::=  assnmt | ifstmt | loop | read | output | funcall
       assnmt   ::=  ident ~ exprsn ;
       ifstmt   ::=  I comprsn @ {statemt} [% {statemt}] &
       loop     ::=  W comprsn L {statemt} T
       read     ::=  R ident {, ident } ;
       output   ::=  O ident {, ident } ;
       funcall  ::=  C function E
       comprsn  ::=  ( oprnd opratr oprnd )
       exprsn   ::=  factor {+ factor}
       factor   ::=  oprnd {* oprnd}
       oprnd    ::=  integer | ident | ( exprsn )
       opratr   ::=  < | = | > | !
       ident    ::=  letter {char}
       char     ::=  letter | digit
       integer  ::=  digit {digit}
       letter   ::=  X | Y | Z
       digit    ::=  0 | 1 | 2 | 3 | 4 | 5 | 6 | 7

	 The tokens are: B I W L T R O C E X Y Z 0 1 2 3 4 5 6 7 ; ~ @ % & , ( ) + * < = > !
   Nonterminals are shown as lowercase words.
   The following characters are NOT tokens (they are EBNF metasymbols):   | { } [ ]
   Note that parentheses are TOKENS, not EBNF metasymbols in this particular grammar.
   
*/

//---------Scott Gordon Code with minor modifications by Talal Jawaid-----------------------------------

public class Recognizer
{
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
    System.out.print("Error at position: " + index);
    System.out.println("\tToken: "+token() + " caused the error." );
    errorflag = 1;
    advancePtr();
  }
//-----End of Scott Gordon Code-----------------
//Talal Code begins here

private void function()
{
	match('B');
	while(token() == 'X' || token() == 'Y' || token() == 'Z' || token() == 'C' || token() == 'O' || token() == 'R' || token() == 'W' || token() == 'I' )
	{
	        statemt();
	}
}

private void statemt()
{
	if(token() == 'C')
		funcall();
	else if(token() == 'I')
		ifstmt();
	else if(token() == 'W')
		loop();
	else if(token() == 'R')
		read();
	else if(token() == 'O')
		output();
	else if(token() == 'X')
		assnmt();
	else if(token() == 'Y')
		assnmt();
	else if(token() == 'Z')
		assnmt();

	
	
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
	
	while(token() == 'X' || token() == 'Y' || token() == 'Z' || token() == 'C' || token() == 'O' || token() == 'R' || token() == 'W' || token() == 'I' )
	{
	        statemt();
	}
	
	if(token() == '%') 
	{
        match('%');
        
		while(token() == 'X' || token() == 'Y' || token() == 'Z' || token() == 'C' || token() == 'O' || token() == 'R' || token() == 'W' || token() == 'I' )
		{
		        statemt();
        }
        
		match('&');
	}
	else
		match('&');
		
}



private void loop()
{
	match('W');
	
	comprsn();
	
    match('L');
    
    while(token() == 'X' || token() == 'Y' || token() == 'Z' || token() == 'C' || token() == 'O' || token() == 'R' || token() == 'W' || token() == 'I' )
    {
            statemt();
    }
    match('T');
	
}

private void read()
{
    match('R');
    
    ident();

    while(token() == ',')
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

    while(token() == ',')
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
    if(token() == '(')
    {
        match('(');
        exprsn();
        match(')');
    } 
    else if(token() == '0' || token() == '1' || token() == '2' || token() == '3' || token() == '4' || token()== '5' || token() == '6' || token() == '7')
    {
        integer();
    }
    else if(token() == 'X' || token() == 'Y' || token() == 'Z')
    {
        ident();
    }

    
}

private void opratr()
{
    if(token() == '<')
        match('<');
    else if(token() == '=')
        match('=');
    else if(token() == '>')
        match('>');
    else if(token() == '!')
        match('!');
    
    
}

private void ident()
{
    letter();
    
    while( token() == '0' || token() == '1' || token() == '2' || token() == '3' || token() == '4' || token()== '5' || token() == '6' || token() == '7'|| token() == 'X' || token() == 'Y' || token() == 'Z')
    {
        charr();
    }

}

private void charr()
{
    if(token() == '0' || token() == '1' || token() == '2' || token() == '3' || token() == '4' || token()== '5' || token() == '6' || token() == '7')
    {
        digit();
    }
    else if(token() == 'X' || token() == 'Y' || token() == 'Z')
    {
        letter();
    }
}

private void integer()
{
    while( token() == '0' || token() == '1' || token() == '2' || token() == '3' || token() == '4' || token()== '5' || token() == '6' || token() == '7')
    {
        digit();
    }
}

private void letter()
{
    while(token() == 'X' || token() == 'Y' || token() == 'Z')
    {
        match(token());
    }
}

private void digit()
{
    while( token() == '0' || token() == '1' || token() == '2' || token() == '3' || token() == '4' || token()== '5' || token() == '6' || token() == '7')
    {
        match(token());
    }
}

//Talal Code ends here
//Only minor modifications to Scott Gordon's Recognizer code beyond this point
//----------------------
  private void start()
  {
    function();
    match('$');

    if (errorflag == 0)
      System.out.println("legal." + "\n");
    else
      System.out.println("errors found." + "\n");
  }
//----------------------
  public static void main (String[] args) throws IOException
  {
    Recognizer rec = new Recognizer();

    Scanner input = new Scanner(System.in);
    System.out.print("\n" + "enter an expression: ");
    inputString = input.nextLine();
    input.close();
    rec.start();
  }
}