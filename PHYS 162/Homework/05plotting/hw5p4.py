# -------------------------------------------------------------------------------
# HW05 - Plotting
# -------------------------------------------------------------------------------

# Imports
import numpy as np
import matplotlib
import math
import random
from math import cos
from math import sin
from math import tan
from math import radians
from math import sqrt
# import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.pyplot import cm
from matplotlib import colors as mcolors

print("Problem 4 \t Reproduce the graph")

'''
3 columns in 'ground.dat'
x position, color code, ground height (y)
'''

x_position = []
color_code = []
ground_height = []
# 261 rows found in 'ground.dat'.
for line in open ('ground.dat', 'r'):
    values = [float(s) for s in line.split()]
    x_position.append(values[0])
    color_code.append(values[1])
    ground_height.append(values[2])

# Test print each column.
# print(x_position)
# print(color_code)
# print(ground_height)


# Create data
X1 = np.linspace(0, 100, 1001, endpoint=True)
Y1 = np.linspace(1, 6, 50, endpoint=True)

X = np.linspace(-np.pi, np.pi, 256, endpoint=True)
Y = np.cos(X)

fig, (ax1, ax2, ax3) = plt.subplots(nrows=1, ncols=3, sharex=True, figsize=(10, 7))
# plt.figure(figsize=(8, 8))

# -------------------------------------------------------------------------------

# Top wide graph.
ax1 = plt.subplot(2,1,1)
ax1.spines['right'].set_color('none')
ax1.spines['top'].set_color('none')
ax1.spines['bottom'].set_position(('data', 0))
ax1.spines['left'].set_position(('data', 0))
ax1.set_ylabel('$y$ (m)')
ax1.set_xlabel('$x$ (m)')
yticks1 = ax1.yaxis.get_major_ticks()
yticks1[1].label1.set_visible(False)

t = color_code

ax1.scatter(x_position, ground_height, marker='+', c=t)
ax1.title.set_text('Some plots to reproduce')



# -------------------------------------------------------------------------------

# Bottom left graph.
def f1(x):
    return np.cos(x**2)
# Bottom left x data.
# bl_xdata = np.linspace(-np.pi, np.pi, 256, endpoint=True)
bl_xdata = np.linspace(0, 4, 100, endpoint=True)

y1 = f1(bl_xdata)
ax2.set_xlim([-np.pi, np.pi])


ax2 = plt.subplot(2,2,3)

xT = np.array([0,1,2,3,4,])
yT = np.array([0,1,2,3,4,5,6,7,8,])
my_xticks = ['0', '', '$\u03C0$/2', '', '$\u03C0$']
# ax2.set_xticks(xTT, my_xticks)
plt.xticks(xT, my_xticks)

ax2.plot(bl_xdata, y1, color="#297db7", linewidth=1.2)
ax2.title.set_text('cos($x$\u00b2)')

# -------------------------------------------------------------------------------

# Bottom right graph.
def f2(x):
    return 1 - x**2

def f3(x):
    return x**2 - 1    

# Bottom right x data.
br_xdata = np.linspace(-1.5, 1.5, 100, endpoint=True)

y2 = f2(br_xdata)
y3 = f3(br_xdata)

xT2 = np.array([0,1,2,3,4,5,6,])
my_xticks2 = ['-1.5', '-1.0', '-0.5', '0.0', '0.5', '1.0', '1.5']
# ax2.set_xticks(xTT, my_xticks)
ax3.set_xticks(xT2, my_xticks2)

ax3.set_ylim([-1.0, 1.0])
ax3.set_xlim([-1.5, 1.5])

ax3 = plt.subplot(2,2,4)
ax3.plot(br_xdata, y2, color="#1f77b4", linewidth=2.0, label="1 - $x$\u00b2")
ax3.plot(br_xdata, y3, color="#ff7f0e", linewidth=2.0, label="$x$\u00b2 - 1")
ax3.title.set_text(' ')

handles, labels = ax3.get_legend_handles_labels()
ax1.legend(handles, labels, loc='center right')

# -------------------------------------------------------------------------------

# Save figure to disk
plt.savefig("hw5_problem4.png", dpi=200)
# plt.savefig("hw5_problem4.pdf", dpi=200)
# plt.savefig("1_basic_plotting.pdf",dpi=72)

# Show result on screen
plt.show()