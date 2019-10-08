/*
  Obstacle Detection_HYDRA.c
 
  Measure and display Ping))) Ultrasonic Distance Sensor distance measurements.
  Turns on Brakes & Brake LEDs when obstacle is detected within 25 centimeters. 
*/

#include "simpletools.h"                      // Include simpletools header
#include "ping.h"                             // Include ping header
#include "adcDCpropab.h"                      // Include adcDCpropab

int main()                                    // Main function
{
  adc_init(21, 20, 19, 18);                   // CS=21, SCL=20, DO=19, DI=18
  
  while(1)                                    // Repeat indefinitely
  {
    int cmDist = ping_cm(14);                 // Get cm distance from Ping Sensor
    //print("cmDist = %d\n", cmDist);           // Display distance
      print("A/D0 = %f\n", adc_volts(0));            // Display A/D0 volts (Debug Pins)
      //print("A/D1 = %f\n", adc_volts(1));            // Display A/D1 volts (Debug Pins)
    
    if (cmDist <30)
    {
      dac_ctr(7,0,255);                       // There is an obstacle, 3.3v to led, full brightness
      
      dac_ctr(0,1,255);                       // Gives 3.3v (High Signal) to RPi, motors stop
    }
  
    if (cmDist >=30)
    {
      dac_ctr(7,0,000);                      // No obstacle, 2v to led, brake lights dimly lit
      
      dac_ctr(0,1,000);                      // Gives 0v (Low Signal) to RPi, motors run
    }                
    pause(400);                               // Wait 1/5 second
  }
}