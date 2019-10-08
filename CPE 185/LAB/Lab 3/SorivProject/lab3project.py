from gpiozero import LED
import time


print ("Option 1")
print ("Option 2")
print ("Option 3")

select = input("select an option: ")
print(select)


if select == "1":
    for i in range(0, 3):  
        led = LED(18)
        led.on()
        time.sleep(1)
        led.off()
        
        led = LED(23)
        led.on()
        time.sleep(1)
        led.off()
        
        led = LED(24)
        led.on()
        time.sleep(1)
        led.off()
        
        led = LED(25)
        led.on()
        time.sleep(1)
        led.off()
    
    
if select == "2":
    for i in range(0, 3):
        
        led = LED(24)
        led.on()
        time.sleep(1)
        led.off()
        
        led = LED(23)
        led.on()
        time.sleep(1)
        led.off()
        
        led = LED(18)
        led.on()
        time.sleep(1)
        
        led = LED(25)
        led.on()
        time.sleep(1)
        led.off()
        
        led = LED(24)
        led.on()
        time.sleep(1)
        led.off()
                
        led = LED(18)
        led.on()
        time.sleep(1)
        led.off()

if select == "3":
    for i in range(0, 3):  
        led = LED(25)
        led.on()
        time.sleep(1)
        led.off()
        
        led = LED(24)
        led.on()
        time.sleep(1)
        led.off()
        
        led = LED(23)
        led.on()
        time.sleep(1)
        led.off()
        
        led = LED(18)
        led.on()
        time.sleep(1)
        led.off()
 
