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

print("Problem 1b:\n")

def f(i, j):
    return math.e**((3*i-4*j)/20)

lst1 = list(range(9,12))

lst2 = list(range(3,6))

file = open('results.dat', 'w+')
for x in lst1:
    for y in lst2:
        file.write("{0} \t {1} \t {2} \n".format(x, y, f(x, y)))

file.close()

