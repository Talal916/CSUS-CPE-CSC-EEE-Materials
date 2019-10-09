public class Card {
   private int value;
   private boolean faceUp;
      //constructor
   public Card(int v) {
      value = v;
      faceUp = false;
   }
   //returns the value of the instance variable
   public int getValue() {
      return value;
   }
   public boolean isFaceUp() {
      //if faceup = true return true else return false
      return faceUp;
   }
   public void flipCard() {
      if(faceUp){
         faceUp = false;
      } 
      else {
         faceUp = true;  
      } 
   }
   //faceup is true
   public void setFaceUp() {
      faceUp = true;
   }
   //faceup is false
   public void setFaceDown() {
      faceUp = false;
   }
   public boolean equals(Card otherCard) {
      if (value == otherCard.value)
      {
         return true;
      } 
      else {   
         return false;
      }
   }
   public String toString() {
   //if card face up is true return value else return *
      if (faceUp){
         return Integer.toString(value);
      } 
      else {
         return "*";
      }   
   }
}//end of code
