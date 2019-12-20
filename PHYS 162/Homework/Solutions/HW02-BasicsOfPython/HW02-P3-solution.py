#!/usr/bin/python
# Solution to Problem 3 of HW02

import math

print ("(a) pi = {:.4f}".format(math.pi))

print ("(b) 100pi^2 = {:.10f}".format(100*math.pi**2))

print ("(c) With  6 digits, pi = {0:.6f};\n    With 20 digits, pi = {0:.20f}.".format(math.pi))

x = math.e**3
y = math.sin(math.pi/3)

print ("(d) x = {0:6.3f}, y = {1:6.3f}, x*y = {2:.3E}".format(x, y, x*y))

myList = [1,5,10]
print ("(e) {2:03d}, {1:03d}, {0:03d}".format(*myList))













