/*Sam Lee
  10/5/17
  CSC 20
  Professor Wang
  Lab #5
*/ 

import java.io.*;
import MyStackQueue.*;

class infix {
   static Queue infixToPostfix(String s) {
      Stack theStack = new Stack();
      Queue theQueue = new Queue();
      Tokenizer T = new Tokenizer(s);
      theStack.push(new Operator('#'));
      while (T.moreTokens()) {
         Token Tkn = T.nextToken(); 
         if (Tkn instanceof Operand) {theQueue.enqueue(Tkn);}
         else {
            Operator Opr = (Operator)Tkn;
            if (Opr.operator=='(') {
               theStack.push(Opr); 
            }
            else if (Opr.operator==')') {
               while (((Operator)theStack.top()).operator != '(') {
                  theQueue.enqueue(theStack.pop());   
               } 
               theStack.pop();
            }
            else {
               while (((Operator)theStack.top()).precedence()>=Opr.precedence()) {
                  theQueue.enqueue(theStack.pop());   
               } 
               theStack.push(Opr);
            }
                     
         }
      }
      while (((Operator)theStack.top()).operator != '#') {
         theQueue.enqueue(theStack.pop());   
      } 
      return theQueue;
   }

   static int evaluePostfix(Queue Post) {
      Stack theStack = new Stack(); 
      int result = 0;
      while (!Post.isEmpty()) {
         Token Tkn = (Token)Post.dequeue();
         if (Tkn instanceof Operand) {
            theStack.push(Tkn);
         }
         else {
            Operator Opr = (Operator)Tkn;
         
            int operand2 = ((Operand)theStack.pop()).operand;
            int operand1 = ((Operand)theStack.pop()).operand;
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
      return result;
   }
   

   public static void main(String[] args) throws IOException {
      Queue Post;
      while(true) {
         System.out.print("Enter infix: ");
         System.out.flush();
         InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader br = new BufferedReader(isr);
         String s = br.readLine();
         if ( s.equals("") ) 
            break;
         Post = infixToPostfix(s);
         System.out.println("Postfix is " + Post.toString() + '\n');
         int result = evaluePostfix(Post);
         System.out.println("Result is " + result + '\n');
      }
   }
}
