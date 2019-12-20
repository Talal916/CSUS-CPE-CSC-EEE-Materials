#!python 3

import math

def f(x):
  return math.sin(x+2)
  
def g(x):
  return (10-x**3)/(10+2*x**3)
  
def h(x,y,z):
  return math.cos(x+y*z)

file = open ("data.dat", "w")
dx = 2.*math.pi/1000
for i in range(1001):
  x = dx*float(i)
  y, z = f(x), g(x)
  file.write("{:8.3f}  {:8.3f}  {:8.3f}  {:8.3f}\n".format(x, y, z, h(x,y,z)))
file.close()
  