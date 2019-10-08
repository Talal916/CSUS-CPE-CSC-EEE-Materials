/*
  Sense Light.side

  Display light sensor levels.
  
  http://learn.parallax.com/propeller-c-simple-circuits/sense-light
*/

#include "simpletools.h"                      // Include simpletools

int main()                                    // main function
{
  while(1)                                    // Endless loop
  {
    high(11);                                  // Set P5 high
    pause(1);                                 // Wait for circuit to charge
    int t = rc_time(11, 1);                    // Measure decay time on P5

    //print("t = %d\n", t);                     // Display decay time
    //print("P1 : HIGH");

    if (t <100000)
    {      
      
      dac_ctr(8,0,000);                       // There is an obstacle, 3.3v to led, full brightness
      
      dac_ctr(1,1,255);                       // Gives 3.3v (High Signal) to RPi, motors stop
      
      print("P1 : HIGH\n");

    }
  
    if (t >=100000)
    {
      dac_ctr(8,0,255);                      // No obstacle, 2v to led, brake lights dimly lit
      
      dac_ctr(1,1,000);                      // Gives 0v (Low Signal) to RPi, motors run
      print("P1 : LOW\n");

    }                
    pause(200);                                
  }
}

