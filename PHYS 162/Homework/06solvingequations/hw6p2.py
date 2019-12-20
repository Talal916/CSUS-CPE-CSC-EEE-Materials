# ----------------------------------------------------------------------------------
# Homework 6: Solving Equations in Python
# ----------------------------------------------------------------------------------

import numpy as np
import scipy
import math
from math import pi
from math import sin
from math import cos
from math import tan
from math import pow
from math import log
from math import log10 # log base 10.

from math import sqrt
from scipy.optimize import brentq
import matplotlib.pyplot as plt   
from scipy.optimize import fsolve
import matplotlib.lines as mlines
from numpy.linalg import solve

print("\nProblem 2: Systems")
print("\t{ 11a + 1 = b + 3c")
print("\t{ 9c      = 8 + 4a")
print("\t{ 2a + 5b = 7 + 15c\n")

'''
Solve the following system of linear equations using the numpy module:
'''

'''
The system:
11a + 1  = b + 3c
9c       = 8 + 4a
2a  + 5b = 7 + 15c
'''

A = np.array([ [11, 1, 3], [-4, 0, 9], [2, 5, -15]])
b = np.array([-1, 8, 7])

sol = solve(A, b)
print("With numpy:")
print(sol)
print()

def equations(r, R):
    (a, b, c) = r
    eq1 = 11*a + 1 - b - 3*c
    eq2 = 9*c - 8 - 4*a
    eq3 = 2*a + 5*b - 7 - 15*c
    return (eq1, eq2, eq3)

r = fsolve(equations, (0.8, 1.4, 0.8), args=(2))

print("With fsolve:")
print(r, "\n")





