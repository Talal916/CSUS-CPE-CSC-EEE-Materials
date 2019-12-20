#!python 3
# Problem 4 on Matplotlib HW

import numpy as np
import matplotlib.pyplot as plt

# Create figure and subplot
plt.figure(figsize=(8,6), dpi=80)
ax = plt.subplot(211)

# Title and axis labels
plt.title('Some plots to reproduce')
plt.xlabel(r'$x$ (m)')
plt.ylabel(r'$y$ (m)')
plt.yticks([1,2,3,4,5,6])

# Read in ground data; there are obviously many ways to do this in Python
groundDataX,groundCol,groundDataY = np.loadtxt("ground.dat",np.float64,usecols={0,1,2},unpack=True)

# Plot ground data
plt.scatter(groundDataX,groundDataY,c=groundCol, marker="+")
# Adjust axes
ax.spines['top'].set_color('none') # turn off top axis
ax.spines['right'].set_color('none') # turn off right axis
ax.spines['bottom'].set_position(('data',0)) # make x-axis pass through y=0
ax.spines['left'].set_position(('data',0)) # make y-axis pass through x=0


ax=plt.subplot(2,3,4)
xdata = np.linspace(0.0,np.pi,200)
ydata = np.cos(xdata**2)
plt.plot(xdata,ydata)
plt.title(r'$\cos(x^2)$')
plt.xticks([0,0.5*np.pi,np.pi],[0,r'$\pi/2$',r'$\pi$'])
plt.yticks([-1,0,1])

plt.axes([0.45,0.11,0.45,0.35])
xdata = np.linspace(-1.5,1.5,200)
ydata = 1.0-xdata**2
plt.plot(xdata,ydata,lw=2.0,label=r'$1-x^2$')
plt.plot(xdata,-ydata,lw=2.0,label=r'$x^2-1$')
plt.legend(loc=(0.7,1.7))

plt.savefig("prob4.pdf",dpi=72)

plt.show()
