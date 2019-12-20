# -----------------------------------------------------------
# Final 
# -----------------------------------------------------------

import numpy as np
import math
import matplotlib.pyplot as plt
from scipy.optimize import brentq
from scipy.optimize import fsolve
from math import sqrt
from math import exp

# Header.
print("Final - Problem 1 \n")
#

# Smooth curve. Plotting continuous function.
# Need lots and lots of points.

plt.figure(figsize=(8,6), dpi=80)
ax = plt.subplot(111)

# Set title
plt.title(r'Numerical Derivative of $x(t)$ vs. $v(t)$', fontsize=16)

# Read in data
data = np.loadtxt('derivativeData.dat')
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
plt.scatter(xdata,ydata,12,color='black', marker='o') # Black circles
plt.plot(xdata,ydata,color='red',label="Numerical derivative")

# Set the axis labels
plt.xlabel(r'$t$',fontsize=16)
plt.ylabel(r'$v(t)$',fontsize=16)

plt.legend(loc='lower right', frameon=False)

plt.savefig("Final - Problem 1.pdf",dpi=72)

# Display figure
plt.show()




