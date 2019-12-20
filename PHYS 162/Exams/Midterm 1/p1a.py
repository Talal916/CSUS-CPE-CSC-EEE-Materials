# ------------------------------------------------------------
# Midterm 1
# ------------------------------------------------------------

import math
from math import pi
from math import sin
from math import pow
from math import log
from math import log10 # log base 10.
from math import sqrt

print("Problem 1a:\n")

list1A = []
for i in range(37, 149):
    # If i % 2 equals 0. Number is even.
    if i % 2 == 0: # If modulus of i equals 1. Number is odd.    
        list1A.append(i)

print("Print list of even numbers between 37 and 149:")
print("\t", list1A, "\n") # New list with even numbers.

print("Print the sum the new list:", sum(list1A))
