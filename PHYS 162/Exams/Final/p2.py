# -----------------------------------------------------------
# Final 
# -----------------------------------------------------------

import numpy as np
import random
import scipy
import math
from math import e
from math import pi
from math import sin
from math import cos
from math import tan
from math import pow
from math import log
from math import radians
from math import log10 # log base 10.

from math import sqrt
from scipy.optimize import brentq
import matplotlib.pyplot as plt   
from scipy.optimize import fsolve
import matplotlib.lines as mlines
import numpy.random as ran

# Header.
print("Final - Problem 2 \n")
#

'''
def normalDist(x, mean, std_dev):
	return ((x - mean) / std_dev)
'''

mean = input("Enter a value for mean: ") 
# print(mean) 
std_dev = input("Enter a value for standard deviation: ") 

# Generate random data
file = open("File.txt","w") 
ran_num_data_points = random.randint(1,10000)
normalData = ran.normal(1,ran_num_data_points,10000)
for x in range(ran_num_data_points):
    file.write("{}\n".format(normalData))
file.close() 

'''
print("Random number picked for data points:", ran_num_data_points)
normalData = ran.normal(x,ran_num_data_points,10000)

print(normalDist(ran_num_data_points, mean, std_dev))
'''






