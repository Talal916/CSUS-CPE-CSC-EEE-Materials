# --------------------------------------------------------------
# Homework 7 - Histograms and Function Fitting
# --------------------------------------------------------------

import sys
import math
import numpy as np
import numpy.random as ran
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

print("\nProblem 4\tData import & Histogram\n")

# Create figure and subplot.
plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)

# Title and axis labels
plt.title('Double Guassian Histogram')
plt.xlabel(r'$x$')
plt.ylabel(r'$y$')

# Read in double guassian data as 'G'.
G = np.loadtxt("HW07-doubleGaussian.dat", np.float64, usecols={0}, unpack=True)

# Separate initial data into two sub-arrays.
G_sub1 = G[:1100] # First peak.
G_sub2 = G[1100:] # Second peak.

# Calculate mean and standard deviation for sub-arrays.
G_sub1_mu = np.mean(G_sub1)
G_sub1_sigma = np.std(G_sub1)
G_sub2_mu = np.mean(G_sub2)
G_sub2_sigma = np.std(G_sub2)

# Set the limits.
xmin = 0.0
xmax = 1.0
xmin, xmax = plt.xlim()
ymin = 0.0
ymax = G.max()*1.1

# Plot the histogram.
(G, edges, patches) = plt.hist(G, bins=50, range=None, alpha=.9, histtype="bar", rwidth=0.9, density=True, color="brown", label=None)

# Plot the 1st sub-array.
(G_sub1, edges1, patches1) = plt.hist(G_sub1, bins=50, range=None, alpha=.3, histtype="bar", rwidth=0.9, density=True, color="black", label=None)

# Plot the 2nd sub-array.
(G_sub2, edges2, patches2) = plt.hist(G_sub2, bins=50, range=None, alpha=.3, histtype="bar", rwidth=0.9, density=True, color="black", label=None)

# Get midpoints of edges.
x_data = []
for i in range(len(edges)-1):
	x = (edges[i] + edges[i+1]) / 2
	x_data.append(x)

x_data1 = []
for j in range(len(edges1)-1):
	x1 = (edges1[j] + edges1[j+1]) / 2
	x_data1.append(x1)
    

# Scatter plot the data. G is the y_data.
dotSize = 20
plt.scatter(x_data, G, dotSize, label=r"Double Guassian: $d(x)=d0e^{\frac{ (x - \mu^2) }{ 2\sigma^2}} + d0e^{\frac{ (x - \mu^2) }{ 2\sigma^2}}$", color="blue", zorder=2)

# Guassian function variables.
mu = np.mean(G) # Mean of G.
sigma = np.std(1.25)    # Standard deviation.

# Curve fit function.
def guassian(x, mu, sigma, d0):
    return (d0 * np.exp(-((x - mu)**2 / 2 * sigma**2))) + (d0 * np.exp(-((x - mu)**2 / 2 * sigma**2)))

def bimodal(x, mu1, sigma1, d1, mu2, sigma2, d2):
    return (guassian(x, mu1, sigma1, d1)) + (guassian(x, mu2, sigma2, d2))

# Midpoints of the edges and call to curve_fit.
p0 = [.9, 1.7, 0.2, 2.5, 3.4, 0.2]
bounds = (-np.inf,np.inf)
(popt, pcov) = curve_fit(bimodal, x_data, G, p0=p0, sigma=None, bounds=bounds)

print(popt,"\n")
print("Guessed data:")
print("1st peak mean: {:.5f}; standard deviation: {:.5f}".format(popt[0], popt[1]))
print("2nd peak mean: {:.5f}; standard deviation: {:.5f}".format(popt[3], popt[4]))
print("")
print("Calculated data:")
print("1st peak mean: {:.5f}; standard deviation: {:.5f}".format(G_sub1_mu, G_sub1_sigma))
print("2nd peak mean: {:.5f}; standard deviation: {:.5f}".format(G_sub2_mu, G_sub2_sigma))

y_fitted = bimodal(x_data, *popt)
# Plot curve fit.
plt.plot(x_data, y_fitted, color="red", linewidth=2.0, linestyle="-", label=r"Fit: $d(x)=%.2fe^{\frac{ (x - %.2f^2) }{ 2%.2f^2}} + %.2fe^{\frac{ (x - %.2f^2) }{ 2%.2f^2}}$" %(popt[0],popt[1],popt[2],popt[3],popt[4],popt[5]))

plt.legend(loc="upper left", frameon=False, fontsize=14)

# Export figure and show.
plt.savefig("hw7-problem4.pdf")
plt.tight_layout()
plt.show()