# ------------------------------------------------------------
# Midterm 1
# ------------------------------------------------------------

import math
import os
import sys

print("Problem 3:\n")

# Create a function of x.
def f(x):
    if x < 0:
        print("Negative")
    elif x > 0:
        print("Positive")
    elif x == 0:
        print("Zero")

# Prompt user to test.
testNum = int(input("Enter a value of for x: "))
f(testNum)