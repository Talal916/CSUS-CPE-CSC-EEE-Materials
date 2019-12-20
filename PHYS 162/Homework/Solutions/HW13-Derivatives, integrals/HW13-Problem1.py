#!/usr/bin/python
# Problem 1 on Derivatives HW

import numpy as np
import matplotlib.pyplot as plt

plt.figure(figsize=(8,6), dpi=80)
ax = plt.subplot(111)

# set title
plt.title(r'Numerical Derivative of $x^4-2x^3+5x-1$ vs. $\Delta x$ at $x=3$',fontsize=16)

# Read in data
data = np.loadtxt('f_x=3_dx0=0.5.dat')
xdata = np.log10(data.T[0])
ydata = data.T[1]

# set up domain variables
dfexact = 59.
xmin = np.min(xdata)
xmax = np.max(xdata)
xrange = xmax - xmin

ymin = dfexact-1. #np.min(ydata)
ymax = dfexact+1.5 #np.max(ydata)
yrange = ymax - ymin

# Set tick mark locations and labels
plt.xticks([3*i-15 for i in range(6)],
           [r'$10^{%d}$' % (3*i-15) for i in range(6)])

# Plot the data
plt.scatter(xdata,ydata,12,color='red', marker='o')
plt.plot(xdata,ydata,color='red')

# Set the axis labels
plt.xlabel(r'$\Delta x$',fontsize=16)
plt.ylabel(r'$\left(\frac{\mathrm{d}f}{\mathrm{d}x}\right)_\mathrm{forward}$',fontsize=16)

# Set the axis limits with a bit of a margin
margin = 0.05
plt.xlim(xmin - xrange * margin, xmax + xrange * margin)
plt.ylim(ymin,ymax) # - yrange * margin, ymax + yrange * margin)

# Remove unneeded axes
ax.spines['top'].set_color('none')
ax.spines['right'].set_color('none')
ax.xaxis.set_ticks_position('bottom')
ax.yaxis.set_ticks_position('left')

# Makes other axes intersect at the origin
ax.spines['bottom'].set_position(('data',dfexact-0.5))
ax.spines['left'].set_position(('data',xmin - xrange * margin))

plt.plot([xmin- xrange * margin,xmax], [dfexact, dfexact], ls=":", color="black")

## Everything below this (except the show command) is not required for the homework, but add the inset zoomin in on the "flat" part of the curve.

# set up domain variables
xmin = -9
xmax = -6
xrange = xmax - xmin
# Set the axis limits with a bit of a margin
margin = 0.05
ymin=dfexact-0.1
ymax=dfexact+0.1
plt.plot([xmin,xmax,xmax,xmin,xmin],[ymin,ymin,ymax,ymax,ymin],color="black",lw=0.5)
plt.plot([xmin,xmin-1],[ymax,ymax+0.2],color="black",ls=":",lw=0.5,zorder=10)
plt.plot([xmax,xmax+2],[ymax,ymax+0.2],color="black",ls=":",lw=0.5,zorder=10)

ymin = -0.000004 #np.min(ydata)
ymax = .00003 #np.max(ydata)
yrange = ymax - ymin

plt.axes((0.4,0.55,0.35,0.28))
plt.scatter(xdata,ydata-dfexact,12,color='red', marker='o')
# Set the axis labels
plt.xlabel(r'$\Delta x$',fontsize=12)
plt.ylabel(r'Error on $\frac{\mathrm{d}f}{\mathrm{d}x}$',fontsize=12)

plt.xlim(xmin, xmax)
plt.ylim(ymin,ymax) # - yrange * margin, ymax + yrange * margin)
plt.plot([xmin,xmax], [0., 0.], ls=":", color="black")

# Set tick mark locations and labels
plt.xticks([i+xmin for i in range(1+round(xrange))],
           [r'$10^{%d}$' % (i+xmin) for i in range(1+round(xrange))])
plt.yticks([0,1.e-5,2.e-5],[0,"$10^{-5}$",r"$2\times10^{-5}$"])
# Save figure to file
plt.title("Zoom-in on \"flat\" part",fontsize=12)

plt.savefig("prob1.pdf",dpi=72)

# Display figure
plt.show()
