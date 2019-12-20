# --------------------------------------------------------------
# Homework 7 - Histograms and Function Fitting
# --------------------------------------------------------------

import sys
import math
import numpy as np
import numpy.random as ran
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

print("\nProblem 3\tNonlinear fit\n")

# Create figure and subplot.
plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)

# Title and axis labels
plt.title('Non-linear Fit')
plt.xlabel(r'$x$')
plt.ylabel(r'$y$')

# Read in non-linear fit data.
x_data, y_data = np.loadtxt("HW07-nonLinearFit.dat", np.float64, usecols={0,1}, unpack=True)

# Scatter plot the data.
dotSize = 20
plt.scatter(x_data, y_data, dotSize, label="Data: $f(t) = Asin(\omega_2t) + Bsin(\omega_2t)$", color="black", zorder=2)

xmin = -0.1
xmax = 10.1

plt.xlim(xmin, xmax) 

# Now fit a sample sine function to the data.
def single_sinA(t, A, w1):
    return (A * (np.sin(w1 * t))) 

def single_sinB(t, B, w2):
    return (B * (np.sin(w2 * t))) 

def double_sin(t, A, w1, B, w2):
    return (single_sinA(t, A, w1)) + (single_sinB(t, B, w2))

# A,     w1,       B,         w2
# amp    freq,     amp,       freq

# 1st step.
#    Amp, Freq
p01 = [2.5, 3]
(popt1, pcov1) = curve_fit(single_sinA, x_data, y_data, p0=p01, sigma=None, bounds=(-np.inf,np.inf))
print(popt1,"\n")
# Plot the resulting single sin curve on the data.
y_fitted1 = single_sinA(x_data, *popt1)
plt.plot(x_data, y_fitted1, color="red", linewidth=2.0, linestyle="-", label="Single Sin, $f(t) = {:.2f}sin({:.2f}t)$".format(popt1[0], popt1[1]))

# 2nd step.
'''
Add a second sine function B sin(ω2t) and ﬁt for its parameters B and ω2 while keeping
the parameters A and ω1 obtained in (i) for the ﬁrst sine function ﬁxed;
'''
p02 = [2.5, 3, 2.5, 3]
(popt2, pcov2) = curve_fit(double_sin, x_data, y_data, p0=p02, sigma=None, bounds=(-np.inf,np.inf))
print(popt2,"\n")
# Plot the resulting 2nd single curve on the data.
y_fitted2 = double_sin(x_data, *popt2)
plt.plot(x_data, y_fitted2, color="green", linewidth=2.0, linestyle="-", label="2nd Sin, $f(t) = {:.2f}sin({:.2f}t) + {:.2f}sin({:.2f}t)$".format(popt2[0], popt2[1], popt2[2], popt2[3]))

# 3rd step.
#    Amp1, Freq1, Amp2, Freq2
p03 = [0.6, 2.8, 1.9, 2.4]
(popt3, pcov3) = curve_fit(double_sin, x_data, y_data, p0=p03, sigma=None, bounds=(-np.inf,np.inf))
print(popt3,"\n")
# Plot the resulting double sin curve on the data.
y_fitted3 = double_sin(x_data, *popt3)
plt.plot(x_data, y_fitted3, color="blue", linewidth=2.0, linestyle="-", label="Double Sin, $f(t) = {:.2f}sin({:.2f}t) + {:.2f}sin({:.2f}t)$".format(popt3[0], popt3[1], popt3[2], popt3[3]))



plt.legend(loc="upper right", frameon=False, fontsize=10)

# Export figure and show.
plt.savefig("hw7-problem3.pdf")
plt.tight_layout()
plt.show()

