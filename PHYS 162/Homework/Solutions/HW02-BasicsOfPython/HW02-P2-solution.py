#!/usr/bin/python
# Solution to Problem 2 of HW02

import sys
import datetime

today = datetime.date.today()  # gets today's date
print ("Today is {:02d}/{:02d}/{:4d}.".format(today.month,today.day,today.year))

if(len(sys.argv)!=2):
    print("You must provide exactly one argument on the command line.")
    sys.exit("Exiting...")
else:
    word = sys.argv[1]

print("The word you entered is \"{:s}\".".format(word))
