# External module imports
import RPi.GPIO as GPIO
import time

# Pin Definitons:
ledPin = 17 # Broadcom pin 17 (PI pin 11)
buttonPin = 27 # Broadcom pin 27 (PI pin 13)

# Pin Setup:
GPIO.setmode(GPIO.BCM)
GPIO.setup(ledPin, GPIO.OUT)
GPIO.setup(buttonPin, GPIO.IN)

# Initial state for LED:
GPIO.output(ledPin, GPIO.LOW)
print("Simple Python GPIO Start! Press CTRL+C to exit")
try:
    while 1:
        if GPIO.input(buttonPin):
            GPIO.output(ledPin, GPIO.HIGH)
            print("1")
            time.sleep(0.2)
        else:
            GPIO.output(ledPin, GPIO.LOW)
            
except KeyboardInterrupt: # If CTRL+C is pressed, exit and clean
    GPIO.cleanup() # cleanup all GPIO