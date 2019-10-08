#include <stdio.h>
#include <wiringPi.h>

//pin number declarations
const int ledPin = 17;
const int buttonPin = 27;

int main(void)
{
    //setup stuff:
    wiringPiSetupGpio(); //initialize wiring pi
    
    pinMode(ledPin, OUTPUT);
    pinMode(buttonPin, INPUT);
    
    printf("C GPIO program running! Press control C to quit.\n");
    
    while(1)
    {
        if(digitalRead(buttonPin))
            digitalWrite(ledPin, HIGH);
        else
            digitalWrite(ledPin, LOW);
    }
    
    return 0;

}