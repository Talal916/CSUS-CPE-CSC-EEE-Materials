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
from math import radians
from math import log10 # log base 10.

from math import sqrt
from scipy.optimize import brentq
import matplotlib.pyplot as plt   
from scipy.optimize import fsolve
import matplotlib.lines as mlines

print("\nProblem 3a: Projectile problem\n")

'''
Going back to the projectile problem (see previous notes), use the scipy module to solve
numerically for the x-coordinate of the landing point for the two diﬀerent ground functions
deﬁned below.

Note that you will have use the args parameter when employing the numerical solver as
shown in the notes (remember the Gaussian example...)

Note: I recommend a separate script ﬁle for each part.
'''

plt.figure(figsize=(8,6), dpi=80)
ax = plt.subplot(111)

# Define trajectory function.

# Constants.
g = 9.81
d = 5         # m
H = 2         # m
alpha = 30    # degrees (slope of slanted ground)

h0 = 1.54     # m
th0 = 25   # degrees

def y(x, v0, th0):
	"This function will return the y-coordinate for a given x-coordinate and initial velocity."
	th0rad = th0 * np.pi/180
	return h0 + np.tan(th0rad) * x - g * x**2 / (2 * v0**2 * np.cos(th0rad)**2)

# Trajectory function.
def f(x, v0):
    return (h0 + (x * np.tan(np.radians(th0))) - ((g * (x**2) / (2 * (v0**2) * np.cos(np.radians(th0)**2) ))))

# The new ground data for hw6. 
def h1(x):
    condList = [x < d, 
                np.logical_and(x >= d, (x - d) * np.tan(np.radians(alpha) < H)), 
                (x - d) * np.tan(np.radians(alpha)) >= H]

    funcList = [0, (x - d) * np.tan(np.radians(alpha)), H]
    
    return np.piecewise(x, condList, funcList)
    
# Set discretization step.
dx = 0.1

# Set up domain variables.
xmin = 0.0
xmax = 17.0
xrange = xmax - xmin

# Calculate number of points needed (standard formula; take note of it).
numpoints = int(xrange/dx+0.001) + 1

# Generate x values.
xdata = np.linspace(xmin, xmax, numpoints)

# Since our function expects a single float, we have to use a loop to calculate the data:
ydata = []
for x in xdata:
	ydata.append(h1(x))

# Plot the ground.
plt.plot(xdata, ydata, color='black', linewidth=3.0)

th0s = [25, 25, 25] # in degrees
v0s = [5, 10, 15] # m/s
ranges = [xmax, xmax, xmax] # default values used before ranges are determined
ranges = [3.6, 7.74, 16.52] # Cuts off trajectories too.
colors = ['red','green','blue']

# Set title.
plt.title(r'Trajectories for various $v_0$',fontsize=20,color='black')

ymin = 0.0 # Ground is 0. Don't plot below that.
ymax = -1 # Finding largest y value among all trajectories.

# Looping to make plots.
for v0,th0,col,xdist in zip(v0s,th0s,colors,ranges):
	# Generate x values for trajectories.
	xdata = np.linspace(xmin,xdist,numpoints) # Generate data for each trajectory to end it when rock hits ground.

    # Plug xdata into trajectory function.
	ydata = y(xdata,v0,th0)
	if( np.max(ydata) > ymax):
		ymax = np.max(ydata)

	# Plot the data.
	plt.plot(xdata,ydata,color=col, linewidth=1.0, 
		label=r'$v_0=%.1f$ m/s, $\theta_0=%.0f^\circ$' % (v0,th0))
	plt.scatter([xdist,],[h1(xdist),],color="black")
	plt.annotate(r'r=%.1f m'%(xdist),
             xy=(xdist, h1(xdist)),  xycoords='data',
             xytext=(-120, 30), textcoords='offset points', fontsize=12,
             arrowprops=dict(arrowstyle="->", 
				connectionstyle="angle3,angleA=10,angleB=80"))
	print('For theta0 = %.0f degrees, v0=%.0f m/s, the range is %.1f m'%(th0,v0,xdist))

yrange = ymax - ymin
# Set the axis labels.
plt.xlabel(r'$x$ (m)',fontsize=16)
plt.ylabel(r'$y$ (m)',fontsize=16)

# Set the axis limits with a bit of a margin.
margin = 0.1
plt.xlim(xmin, xmax)
plt.ylim(ymin-0.025, ymax + yrange * margin)

# Turn on legend.
plt.legend(loc='lower right',frameon=True)

print("\nGetting 3 solutions for x-coordinates:\n")

# Use brentq.
def traj1(x):
    return(h1(x) - f(x, 5))
sol1 = brentq(traj1, 0, 5)
print(sol1)

def traj2(x):
    return(h1(x) - f(x, 10))
sol2 = brentq(traj2, 5, 9)
print(sol2)

def traj3(x):
    return(h1(x) - f(x, 15))
sol3 = brentq(traj3, 9, 20)
print(sol3)

# The solutions from brentq for some reason aren't matching the actual
# ranges shown in the graph. However, the brentq solutions are in the
# ballpark of the actual range. Is brentq inaccurate or is my trajectory
# function is incorrect?

# Export figure and show.
plt.savefig("hw6-problem3a.pdf")
plt.show()











