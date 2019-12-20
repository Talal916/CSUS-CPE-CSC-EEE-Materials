#!python 3
# Problem 3-b on Matplotlib-I HW

# Because of the "if" statements, the "ground" function does not work for arrays, and a loop is necessary to 
# apply to xdata before plotting. "numpy.piecewise" make it possible to go around this (see online documentation).

import numpy as np
import matplotlib.pyplot as plt

plt.figure(figsize=(8,6), dpi=80)
ax = plt.subplot(111)

# define trajectory function
h0 = 1.54 # in m
g = 9.8 # in m/s^2
d1 = 6 # in m
alpha = 30 # in degrees (slope of slanted ground)
d2 = 4 # in m
tanAlpha = np.tan(np.radians(alpha)) # calculate onces instead of every time a ground position is needed
H = d2*tanAlpha  # Height of the plateau in m

def y( x, v0, th0 ):
	"This function will return the y-coordinate for a given x-coordinate and initial velocity."
	th0rad = th0 * np.pi/180
	return h0 + np.tan(th0rad) * x - g * x**2 / (2 * v0**2 * np.cos(th0rad)**2)

# set up domain variables
xmin = 0.0
xmax = 12.0
xrange = xmax - xmin

# set discretization step
dx = 0.1

# calculate number of points needed (standard formula; take note of it)
numpoints = int(xrange/dx+0.001) + 1

# Generate x values
xdata = np.linspace(xmin,xmax,numpoints)

# The ground data, using conditional statements:
def ground( x ):
	"This function returns the height of the ground at a given value of x."
	retval = 0.0
	if( d1 < x <= d1+d2 ):
		retval = np.tan(np.radians(alpha)) * (x-d1)
	elif( x > d1+d2 ):
		retval = H
	
	return retval

# Since our function expects a single float, we have to use a loop to calculate the data:
ydata = []
for x in xdata:
	ydata.append(ground(x))

# Plot the ground
plt.plot(xdata,ydata,color='black', linewidth=3.0)

# Lists of values of v0 to be explored and corresponding colors
th0s = [0, 40, 50] # in degrees
v0s = [8.0,9.0,11.0] # in m/s
ranges = [xmax, xmax, xmax] # default values used before ranges are determined
ranges = [4.5, 8.3, 11.5]  # correct ranges, comments if unknown
colors = ['red','blue','green']

# set title
plt.title(r'Trajectories for various $v_0$ and $\theta_0$',fontsize=20,color='blue')

ymin = 0.0 # no point in plotting anything below the ground
ymax = -1 # we're going to find the largest y value among all the trajectories
# use a loop to make the plots
for v0,th0,col,xdist in zip(v0s,th0s,colors,ranges):
	# Generate x values for trajectories
	xdata = np.linspace(xmin,xdist,numpoints)  # generate data for each trajectory to end it when rock hits ground
	
	# plug the xdata into the trajectory function
	ydata = y(xdata,v0,th0)
	if( np.max(ydata) > ymax):
		ymax = np.max(ydata)
	
	# Plot the data
	plt.plot(xdata,ydata,color=col, linewidth=1.0, 
		label=r'$v_0=%.1f$ m/s, $\theta_0=%.0f^\circ$' % (v0,th0))
	plt.scatter([xdist,],[ground(xdist),],color="black")
	plt.annotate(r'r=%.1f m'%(xdist),
             xy=(xdist, ground(xdist)),  xycoords='data',
             xytext=(-120, 30), textcoords='offset points', fontsize=16,
             arrowprops=dict(arrowstyle="->", 
				connectionstyle="angle3,angleA=10,angleB=80"))
	print('For theta0 = %.0f degrees, v0=%.0f m/s, the range is %.1f m'%(v0,th0,xdist))

yrange = ymax - ymin
# Set the axis labels
plt.xlabel(r'$x$ (m)',fontsize=16)
plt.ylabel(r'$y$ (m)',fontsize=16)

# Set the axis limits with a bit of a margin
margin = 0.1
plt.xlim(xmin, xmax)
plt.ylim(ymin-0.025, ymax + yrange * margin)

#prepare tick labels for vertical axis:
yticks = []
ylabels = []
for x in ranges:
  y = ground(x)
  yticks.append(y)
  ylabels.append(f'{y:.1f}')
plt.yticks(yticks, ylabels, fontsize=16)

# Turn on legend
plt.legend(loc='upper right',frameon=True)

# Save figure to file
plt.savefig("prob3.pdf",dpi=72)


# Display figure
plt.show()
