/*Sam Lee
  10/11/17
  CSC 20
  Professor Wang
  Lab #6
*/

class Tokenizer {
   private char [] buf;
   private int cur;
   
   Tokenizer(String infixExpression) {
      buf = infixExpression.toCharArray();
      cur = 0;
   } 
   boolean moreTokens(){
      while(cur < buf.length && buf[cur] == ' ') {
         cur++;
      }   
      return cur < buf.length;
   }
   Token nextToken() {
      while(cur < buf.length && buf[cur] == ' ') {
         cur++;
      }  
      if (cur >= buf.length) {
         return null;
      }
      int result = 0;
      if (buf[cur] >= 49 && buf[cur] <= 58) {
         int start = cur;
         while(cur < buf.length && buf[cur] >= 49 && buf[cur] <= 58) {        

           cur++;
         } 
            String Digits = new String(buf, start, cur - start);
            int num = Integer.valueOf(Digits).intValue();
            return new Operand(num);
     } else {
         return new Operator(buf[cur++]);
     }
      
   }
}