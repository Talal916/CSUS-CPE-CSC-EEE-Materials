#!/opt/local/bin/python
# Problem 2-1a on Matplotlib-I HW

import numpy as np
import matplotlib.pyplot as plt

plt.figure(figsize=(8,6), dpi=80)
ax = plt.subplot(111)

# define trajectory function
h0 = 1.54 # in m
g = 9.8 # in m/s^2

def y( x, v0, th0 ):
	"This function will return the y-coordinate for a given \
	 x-coordinate and initial velocity."
	th0rad = th0 * np.pi/180.0  # in radians
	return h0 + np.tan(th0rad) * x - g * x**2 / (2 * 
		v0**2 * np.cos(th0rad)**2)

# set up domain variables
xmin = 0.0
xmax = 17.5
xrange = xmax - xmin

# set discretization step
dx = 0.1

# caclulate number of points needed (standard formula; take note of it)
numpoints = int(xrange/dx+0.001) + 1

# Generate x values
xdata = np.linspace(xmin,xmax,numpoints,endpoint=True)

# The ground data (a bunch of zeroes)
ydata = np.zeros(numpoints)

# Plot the ground
plt.plot(xdata,ydata,color='black', linewidth=3.0)

# Lists of values of v0 to be explored and corresponding colors
v0s = [6,8,10,12] # in m/s
colors = ['red','blue','green','gray']
ranges = [4.9, 7.9, 11.6, 16.1] # read from plot
th0 = 40 # in degrees

# set title
plt.title(r'Trajectories for various $v_0$ with fixed $\theta_0=%.0f^\circ$' % (th0),fontsize=20,color='blue')

ymin = 0.0 # no point in plotting anything below the ground
ymax = -1 # we're going to find the largest y value among all the trajectories
# use a loop to make the plots
for v0,col, xdist in zip(v0s,colors,ranges):
	
	# plug the xdata into the trajectory function
	ydata = y(xdata,v0,th0)
	if( np.max(ydata) > ymax):
		ymax = np.max(ydata)

	# Plot the data
	plt.plot(xdata,ydata,color=col, linewidth=1.0, 
		label=r'$v_0=%.1f$ m/s, range is %.1f m' % (v0,xdist))
	# print the ranges for the trajectories
	print('For v0 = %.0f m/s and theta0 = %.0f degrees, I find a range of about %.1f m.'%(v0,th0,xdist))

yrange = ymax - ymin
# Set the axis labels
plt.xlabel(r'$x$ (m)',fontsize=16)
plt.ylabel(r'$y$ (m)',fontsize=16)

# Set the axis limits with a bit of a margin
margin = 0.15
plt.xlim(xmin, xmax)
plt.ylim(ymin-0.025, ymax + yrange * margin)

# Turn on legend
plt.legend(loc='upper right',frameon=True)

# Save figure to file
plt.savefig("prob2-a.pdf",dpi=72)


# Display figure
plt.show()
