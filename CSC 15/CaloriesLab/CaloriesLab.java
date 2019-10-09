public class CaloriesLab{

   public static void main(String[] args) {
  
      double weight = 150/2.2;
      int time = 30;
      int sleep = 6*60;
      //Runs 6 MPH for 30 minutes
      double running = 0.0175*10*weight*time;
      System.out.println("Number of Calories Burned for Running 6 MPH for 30 Minutes: ");
      System.out.println(running);
      //Plays basketball for 30 minutes
      double basketball = 0.0175*8*weight*time;
      System.out.println("Number of Calories Burned for Playing Basketball for 30 Minutes: ");
      System.out.println(basketball);
      //Sleeps for 6 hours
      double sleeps = 0.0175*1*weight*sleep;
      System.out.println("Number of Calories Burned for Sleeping for 30 Minutes: ");
      System.out.println(sleeps);
   }
}
      
      
      
