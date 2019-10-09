/*Sam Lee
  10/24/17
  CSC 20
  Professor Wang
  Lab #10
*/ 

import java.io.*;
import java.util.*;

enum errorType { ExcessLeftParenthesis, ExcessRightParenthesis, ExcessOperator, ExcessOperand};
class infixException extends Exception {
   private errorType etype;
   public infixException(errorType et) { 
      etype = et;
   }
   public String toString() {
      return etype.name();
   }
}

class infix {
   static LinkedList<Token> infixToPostfix(String s) throws Exception {
      
      Stack <Operator> theStack = new Stack <Operator> ();
   
      LinkedList<Token> theQueue = new LinkedList<Token>();
   
      Tokenizer T = new Tokenizer(s);
      theStack.push(new Operator('#'));
      while (T.moreTokens()) {
         Token Tkn = T.nextToken(); 
         if (Tkn instanceof Operand) {theQueue.addLast(Tkn);}
         else {
            Operator Opr = (Operator)Tkn;
            if (Opr.operator=='(') {
               theStack.push(Opr); 
            }
            else if (Opr.operator==')') {
               try {
                  while ((theStack.peek()).operator != '(') {
                     theQueue.addLast(theStack.pop());   
                  } 
                  theStack.pop();
               } 
               catch (Exception e) {
                  throw new infixException(errorType.ExcessRightParenthesis);
               }
            
            }
            
            else {
               while ((theStack.peek()).precedence()>=Opr.precedence()) {
                  theQueue.addLast(theStack.pop());   
               } 
               theStack.push(Opr);
            }
         }
                     
      }
      
      while ((theStack.peek()).operator != '#') {
         if ((theStack.peek()).operator == '(') {
            
            throw new infixException(errorType. ExcessLeftParenthesis);
         }
         theQueue.addLast(theStack.pop());   
      } 
      return theQueue;
   }

   static int evaluePostfix(LinkedList<Token> Post) throws Exception {
      Stack <Operand> theStack = new Stack<Operand>(); 
      
      int result = 0;
      int operand1, operand2;
      while (!Post.isEmpty()) {
         Token Tkn =Post.removeFirst();
         if (Tkn instanceof Operand) {
            theStack.push((Operand)Tkn);
         }
         else {
            Operator Opr = (Operator)Tkn;
            try {
               Operand oprnd2 = theStack.pop();
               Operand oprnd1 = theStack.pop();
               operand1 = oprnd1.operand;
               operand2 = oprnd2.operand;
            }
            catch(Exception e) {
               throw new infixException(errorType. ExcessOperator);
               
            }
            switch(Opr.operator) {
               case '+': result = operand1 + operand2; 
                  break;
               case '-': result = operand1 - operand2; 
                  break;
               case '*': result = operand1 * operand2;
                  break;
               case '/': result = operand1 / operand2;
                  break;
            }
            theStack.push(new Operand(result));
         
         
         }
      }
      theStack.pop();
      if (!theStack.isEmpty()) {
         throw new infixException(errorType. ExcessOperand);
      
      }
   
      return result;
   }
   
   public static void main(String[] args) throws IOException {
      LinkedList<Token> Post;
      while(true) {
         try { 
            System.out.print("Enter infix: ");
            System.out.flush();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            if ( s.equals("") ) 
               break;
            Post = infixToPostfix(s);
            System.out.print("Postfix is ");
            for (Token Tkn: Post){ 
               System.out.print( Tkn + " "); 
               
            }
            System.out.println();
            
            int result = evaluePostfix(Post);
            System.out.println("Result is " + result + '\n');
         }
         catch (Exception e) {
            System.out.println("\n**** " + e.toString() + " *****\n");
         }      
      } 
   }
}