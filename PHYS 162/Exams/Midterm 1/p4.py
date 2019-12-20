# ------------------------------------------------------------
# Midterm 1
# ------------------------------------------------------------

import numpy as np
import math
import os
import sys
from math import cos
from math import sin
from math import tan
from math import radians
from math import sqrt
import matplotlib.pyplot as plt
from matplotlib.pyplot import cm
from matplotlib import colors as mcolors

print("Problem 4:\n")

x_position,y_position = np.loadtxt("exp_data.dat",np.float64,usecols={0,1},unpack=True)

'''
# 1,001 rows found in 'exp_data.dat'.
for line in open ('exp_data.dat', 'r'):
    values = [float(s) for s in line.split()]
    x_position.append(values[0])
    y_position.append(values[1])
'''

def y2(x):
    line1 = (x + 20)**(1.1) / 500
    line2 = (9 * (np.cos(x / 200)**2) + 1)
    final = line1 * line2
    return final

'''
x = np.linspace(0.0, 500.0, 1001, endpoint=True)
y = np.linspace(0.0, 5.0, 50, endpoint=True)
'''

fig, ax = plt.subplots(nrows=1, ncols=1, figsize=(8, 8))
fig.suptitle("Problem 4")
line1, = ax.plot(x_position, y_position, 'r', label='y1(x)', linewidth='3.0')
line2, = ax.plot(x_position, y2(x_position), 'g', label='y2(x)', linewidth='3.0')

# line2, = ax.plot(x, y2, 'b', label='y2(x)', linewidth='2.0')
plt.xlabel('$x$')
plt.ylabel('$y$')


ax.legend(loc="upper right")

# Save figure to disk
plt.savefig("hw5_problem1.png", dpi=500)
# plt.savefig("1_basic_plotting.pdf",dpi=72)

# Show result on screen
plt.show()

