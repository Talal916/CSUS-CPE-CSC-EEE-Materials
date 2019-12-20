#!/opt/local/bin/python
# Solution for Problem 3 on Midterm 1 - Fall 2019

def xTest( x ):
    "Prints a word to indicate the sign or zero-ness of the inputted number"
	if (x<0):
		print("Negative")
	elif (x>0):
		print("Positive")
	else:
		print("Zero")

xTest(34)
xTest(-22.1)
xTest(0)
