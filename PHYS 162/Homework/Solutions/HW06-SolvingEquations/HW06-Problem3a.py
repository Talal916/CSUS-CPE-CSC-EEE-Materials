#!/opt/local/bin/python
# Problem 3a (Case 3) on Solving Equations Numerically HW

import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import brentq

plt.figure(figsize=(8,6), dpi=80)
ax = plt.subplot(111)

# define trajectory function
h0 = 1.54 # in m
g = 9.8 # in m/s^2
d = 5 # in m
alpha = 30 # in degrees (slope of slanted ground)
H = 2.0 # in m
dPlateau = H / np.tan(alpha * np.pi / 180) + d # value of x where the plateau begins

# The particle trajectory function
def y( x, v0, th0 ):
	"This function will return the y-coordinate for a given x-coordinate and initial velocity."
	th0rad = th0 * np.pi/180
	return h0 + np.tan(th0rad) * x - g * x**2 / (2 * v0**2 * np.cos(th0rad)**2)

# The ground function
def ground( x ):
	"This function returns the height of the ground at a given value of x."
	if (x < d):
		retval = 0.0
	elif( x < dPlateau ):
		retval = np.tan(alpha * np.pi / 180) * (x-d)
	else:
		retval = H
	return retval

# We wish to know where y(x) = ground(x) so...
def diff( x, v0, th0 ):
	"The difference between y(x) and ground(x)"
	return y(x,v0,th0) - ground(x)

# set up domain variables
xmin = 0.0
xmax = 18.0
xrange = xmax - xmin

# set discretization step
dx = 0.1

# caclulate number of points needed (standard formula; take note of it)
numpoints = xrange/dx + 1

# Generate x values
xdata = np.linspace(xmin,xmax,numpoints,endpoint=True)

# Have to build the ground data one point at a time due to conditionals
ydata = []
for x in xdata:
	ydata.append(ground(x))

# Plot the ground
plt.plot(xdata,ydata,color='black', linewidth=3.0)

# Lists of values of v0 to be explored and corresponding colors
th0 = 25 # in degrees
v0s = [5,10,15] # in m/s
xmins = [3.3, 7.3, 16]
xmaxs = [4, 8.2, 17]
colors = ['red','blue','green']

# set title
plt.title(r'Trajectories for various $v_0$ with fixed $\theta_0=%.2f^\circ$' % (th0),fontsize=20,color='blue')

ymin = 0.0 # no point in plotting anything below the ground
ymax = -1 # we're going to find the largest y value among all the trajectories
# use a loop to make the plots
for v0,x0,x1,col in zip(v0s,xmins,xmaxs,colors):
	x = brentq( diff, x0, x1, args=(v0,th0) )
	
	# plug the xdata into the trajectory function
	xdata = np.linspace(0.0, x,numpoints)
	ydata = y(xdata,v0,th0)
	if( np.max(ydata) > ymax):
		ymax = np.max(ydata)
	
	# Plot the data
	plt.plot(xdata,ydata,color=col, linewidth=1.0, label=r'$v_0=%.1f$ m/s' % (v0))
	print("Range for v0 =  %d m/s: %.2f m" % (v0,x))

yrange = ymax - ymin
# Set the axis labels
plt.xlabel(r'$x$ (m)',fontsize=16)
plt.ylabel(r'$y$ (m)',fontsize=16)

# Set the axis limits with a bit of a margin
margin = 0.1
plt.xlim(xmin, xmax)
plt.ylim(ymin-0.025, ymax + yrange * margin)

# Turn on legend
plt.legend(loc='lower right',frameon=True)

# Save figure to file
plt.savefig("prob3a.pdf",dpi=72)

# Display figure
plt.show()
