# --------------------------------------------------------------
# Homework 7 - Histograms and Function Fitting
# --------------------------------------------------------------

import sys
import math
import numpy as np
import numpy.random as ran
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

print("\nProblem 2\tLinear fit\n")

# Create figure and subplot.
plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)

# Title and axis labels
plt.title('Linear Fit')
plt.xlabel(r'$x$')
plt.ylabel(r'$y$')

# Read in linear fit data.
x, y = np.loadtxt("HW07-linearFit.dat", np.float64, usecols={0, 1}, unpack=True)

# a0 + a1x + a2x^2 + ... + anx^n

# Plot the data.
dotSize = 20
plt.scatter(x, y, dotSize, color="black", zorder=2, label="Data")

def fit_poly(x, *coeffs):
    y = np.polyval(coeffs, x)
    return y

higher_order = 7
fit_results = []
for n in range(2, higher_order):
    # The initial guess of the parameters to be found by curve_fit.
    p0 = np.ones(n)

    (popt, pcov) = curve_fit(fit_poly, x, y, p0=p0, sigma=None, bounds=(-np.inf,np.inf))
    
    fit_results.append(popt)

xmin = -6.1
xmax = 5.22
plt.xlim(xmin, xmax)

for p in fit_results:
    y_fitted = fit_poly(x, *p)
    plt.plot(x, y_fitted, label='n = %d' % len(p))

plt.legend(loc="upper right", frameon=False, fontsize=10)

print("Minimum value of n = {} obtains a reasonable fit.".format(higher_order - 1))

# Export figure and show.
plt.savefig("hw7-problem2.pdf")
plt.tight_layout()
plt.show()

