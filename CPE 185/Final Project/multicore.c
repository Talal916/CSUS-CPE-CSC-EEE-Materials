

#include "simpletools.h"                      // Include simple tools
#include "ping.h"                             // Include ping header
#include "adcDCpropab.h"                      // Include adcDCpropab

void senselight();
void senseobj();


int main()                                    // Main function
{
  cog_run(senselight, 128);   
  cog_run(senseobj, 128);   
}

void senselight(){
    while(1)                                    // Endless loop
    {
      high(11);                                  // Set P5 high
      pause(1);                                 // Wait for circuit to charge
      int t = rc_time(11, 1);                    // Measure decay time on P5
      //print("t = %d\n", t);                     // Display decay time
      //print("P1 : HIGH");
  
      if (t <100000)
      {      
        
        dac_ctr(8,0,255);                       // There is an obstacle, 3.3v to led, full brightness
        
        dac_ctr(1,1,255);                       // Gives 3.3v (High Signal) to RPi, motors stop
        
        print("P1 : HIGH\n");
  
      }
    
      if (t >=100000)
      {
        dac_ctr(8,0,155);                      // No obstacle, 2v to led, brake lights dimly lit
        
        dac_ctr(1,1,000);                      // Gives 0v (Low Signal) to RPi, motors run
        print("P1 : LOW\n");
  
      }                
      pause(200);                                
    }
}

void senseobj(){
  
  adc_init(21, 20, 19, 18);                   // CS=21, SCL=20, DO=19, DI=18
  
  while(1)                                    // Repeat indefinitely
  {
    int cmDist = ping_cm(14);                 // Get cm distance from Ping Sensor
      //print("cmDist = %d\n", cmDist);           // Display distance
      //print("A/D0 = %f\n", adc_volts(0));            // Display A/D0 volts (Debug Pins)
      print("A/D1 = %f\n", adc_volts(1));            // Display A/D1 volts (Debug Pins)
    
    if (cmDist <25)
    {
      dac_ctr(7,0,255);                       // There is an obstacle, 3.3v to led, full brightness
      
      dac_ctr(0,1,255);                       // Gives 3.3v (High Signal) to RPi, motors stop
    }
  
    if (cmDist >=25)
    {
      dac_ctr(7,0,155);                      // No obstacle, 2v to led, brake lights dimly lit
      
      dac_ctr(0,1,000);                      // Gives 0v (Low Signal) to RPi, motors run
    }                
    pause(200);                               // Wait 1/5 second
  }
  
}

