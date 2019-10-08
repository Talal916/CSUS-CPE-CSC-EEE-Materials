# External module imports
import RPi.GPIO as GPIO
import time

GPIO.setwarnings(False)

# Pin Definitons:
ledPinA = 2
ledPinB = 3
ledPinC = 4
ledPinD = 17
ledPinE = 27
ledPinF = 22
ledPinG = 10

buttonPin0 = 25
buttonPin1 = 24
buttonPin2 = 23
buttonPin3 = 18

# Pin Setup:
GPIO.setmode(GPIO.BCM)
GPIO.setup(ledPinA, GPIO.OUT)
GPIO.setup(ledPinB, GPIO.OUT)
GPIO.setup(ledPinC, GPIO.OUT)
GPIO.setup(ledPinD, GPIO.OUT)
GPIO.setup(ledPinE, GPIO.OUT)
GPIO.setup(ledPinF, GPIO.OUT)
GPIO.setup(ledPinG, GPIO.OUT)

GPIO.setup(buttonPin0, GPIO.IN)
GPIO.setup(buttonPin1, GPIO.IN)
GPIO.setup(buttonPin2, GPIO.IN)
GPIO.setup(buttonPin3, GPIO.IN)

#initial states
GPIO.output(ledPinA, GPIO.LOW)
GPIO.output(ledPinB, GPIO.LOW)
GPIO.output(ledPinC, GPIO.LOW)
GPIO.output(ledPinD, GPIO.LOW)
GPIO.output(ledPinE, GPIO.LOW)
GPIO.output(ledPinF, GPIO.LOW)
GPIO.output(ledPinG, GPIO.LOW)

print("Number LED! Press CTRL+C to exit")

try:
    while(1):
        if GPIO.input(buttonPin0):
            GPIO.output(ledPinA, GPIO.HIGH)
            GPIO.output(ledPinB, GPIO.HIGH)
            GPIO.output(ledPinC, GPIO.HIGH)
            GPIO.output(ledPinD, GPIO.HIGH)
            GPIO.output(ledPinE, GPIO.HIGH)
            GPIO.output(ledPinF, GPIO.HIGH)
            print '0'
            time.sleep(1)
            GPIO.output(ledPinA, GPIO.LOW)
            GPIO.output(ledPinB, GPIO.LOW)
            GPIO.output(ledPinC, GPIO.LOW)
            GPIO.output(ledPinD, GPIO.LOW)
            GPIO.output(ledPinE, GPIO.LOW)
            GPIO.output(ledPinF, GPIO.LOW)
        if GPIO.input(buttonPin1):
            GPIO.output(ledPinB, GPIO.HIGH)
            GPIO.output(ledPinC, GPIO.HIGH)
            print '1'
            time.sleep(1)
            GPIO.output(ledPinB, GPIO.LOW)
            GPIO.output(ledPinC, GPIO.LOW)
        if GPIO.input(buttonPin2):
            GPIO.output(ledPinA, GPIO.HIGH)
            GPIO.output(ledPinB, GPIO.HIGH)
            GPIO.output(ledPinD, GPIO.HIGH)
            GPIO.output(ledPinE, GPIO.HIGH)
            GPIO.output(ledPinG, GPIO.HIGH)
            print '2'
            time.sleep(1)
            GPIO.output(ledPinA, GPIO.LOW)
            GPIO.output(ledPinB, GPIO.LOW)
            GPIO.output(ledPinD, GPIO.LOW)
            GPIO.output(ledPinE, GPIO.LOW)
            GPIO.output(ledPinG, GPIO.LOW)
        if GPIO.input(buttonPin3):
            GPIO.output(ledPinA, GPIO.HIGH)
            GPIO.output(ledPinB, GPIO.HIGH)
            GPIO.output(ledPinC, GPIO.HIGH)
            GPIO.output(ledPinD, GPIO.HIGH)
            GPIO.output(ledPinG, GPIO.HIGH)
            print '3'
            time.sleep(1)
            GPIO.output(ledPinA, GPIO.LOW)
            GPIO.output(ledPinB, GPIO.LOW)
            GPIO.output(ledPinC, GPIO.LOW)
            GPIO.output(ledPinD, GPIO.LOW)
            GPIO.output(ledPinG, GPIO.LOW)
            
except KeyboardInterrupt: # If CTRL+C is pressed, exit and clean
    GPIO.cleanup() # cleanup all GPIO