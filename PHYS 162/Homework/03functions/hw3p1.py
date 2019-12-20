# --------------------------------------------------------------
# HW03 - Functions
# --------------------------------------------------------------

import os
import sys
import math
from math import pi
from math import sin
from math import cos
from math import pow

print("-------------------------------------------------------")
print("Problem 1\n")

def f(x):
    # A function that returns: f(x) = sin (x + 2).
    return sin(x + 2)

def g(x):
    # A function that returns: g(x) = (10 - x^3) / (10 + 2x^3).
    return (10 - x**3) / (10 + 2 * x**3)

def h(x, y, z):
    # Function that returns: h(x, y, z) = cos(x + yz).
    return cos(x + y*z)

# Interval between 0 and 1001.
lst = list(range(0, 1002))

file = open('data.dat', 'w+')
for x in lst:
    lst[lst.index(x)] = x * (2*(pi)) / lst[1]
    y = f(x)
    z = g(x)
    t = h(x, y, z)
    # h = (x, y, z)
    file.write("{0:4d}\t{1:.16f}\t{2:.16f}\t{3:.16f}\n".format(x,y,z,t))

file.close()

print("Generated '"'data.dat'"' file. Check file where '"'problem1.py'"' is located.\n")