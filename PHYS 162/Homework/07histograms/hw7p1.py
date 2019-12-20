# --------------------------------------------------------------
# Homework 7 - Histograms and Function Fitting
# --------------------------------------------------------------

import sys
import math
import numpy as np
import numpy.random as ran
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

print("\nProblem 1\tNormally distributed random numbers\n")

# Constants.
num_points = 50000                    # Points pull from guassian.
mu = 5                                # Mean.
sigma = 1.25                          # Standard deviation.
x = ran.normal(mu, sigma, num_points) # fakeData.
# d0 = 1
num_bins = 20

# Print the main and standard deviation of the random.
print("Mean:", np.mean(x)) # should be close to mu
print("Standard Deviation:", np.std(x, ddof=1)) # should be close to sigma

# Create figure and subplot.
plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)

# Title and axis labels
plt.title('Normally Distributed Histogram')
plt.xlabel(r'$x$')
plt.ylabel(r'$y$')

# Plot the histogram.
(hist, edges, patches) = plt.hist(x, num_bins, range=None, 
    histtype="bar", rwidth=0.9, density=True, color="grey", label=None)

xmin = 0.0
xmax = 1.0
xmin, xmax = plt.xlim()
ymin = 0.0
ymax = hist.max()*1.1

plt.xlim(xmin,xmax)
plt.ylim(ymin,ymax)

def close(d0, sigma):
    return math.sqrt(2 * math.pi) * d0 * sigma

# Midpoints of each bar.
xdataMidPoints = 0.5*(edges[:-1]+edges[1:])

plt.scatter(xdataMidPoints, hist, 20, color="blue", zorder=2)

# Curve fit function.
def guassian(x, mu, d0, sigma):
    return d0 * np.exp(-((x - mu)**2 / 2 * sigma**2))

xexact = np.linspace(xmin, xmax, 1001, endpoint=True)

# Plot exact fit.
plt.plot(xdataMidPoints, hist, color="green", linewidth=2.0, linestyle="-", 
	label="Exact Fit")

# Midpoints of the edges and call to curve_fit.
(popt, pcov) = curve_fit(guassian, xdataMidPoints, hist, p0=[1., 0., 1.], sigma=None, bounds=(-np.inf,np.inf))

print(popt,"\n")

x_interval_for_fit = xexact
yfitted = guassian(x_interval_for_fit, *popt)
# yfitted = guassian(x_interval_for_fit, popt[0], popt[1], popt[2])
# Plot curve fit.
plt.plot(x_interval_for_fit, yfitted, color="red", linewidth=2.0, linestyle="--", label="Fit")

# Plug your fitted values for d0 and sigma and see how close it is to 1.
print(np.sqrt(2 * np.pi) * popt * sigma)

plt.legend(loc="upper right", frameon=False, fontsize=10)

# Export figure and show.
plt.savefig("hw7-problem1.pdf")
plt.tight_layout()
plt.show()

