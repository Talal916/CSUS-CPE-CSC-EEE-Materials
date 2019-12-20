# -----------------------------------------------------------
# Final 
# -----------------------------------------------------------

import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit
from math import exp

# Header.
print("Final - Problem 3 \t EnergyData.dat Histogram\n")
#

plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)

data = np.loadtxt("EnergyData.dat")

(rectHeights, edges, patches) = plt.hist(data, bins=30, range=None, density=True, color=None, label=None)

xmin = np.min(data)
xmax = np.max(data)
ymin = 0.0
ymax = rectHeights.max()*1.1

xdata = []
for i in range(len(edges)-1):
	x = (edges[i] + edges[i+1]) / 2
	xdata.append(x)

plt.xlim(xmin,xmax)
plt.ylim(ymin,ymax)

plt.scatter(xdata, rectHeights, 20, color="black", zorder=2)

k = 8.617 * 10**-5
# T = 5000 # Celsuis

# Fit function P(E).
def fitFunc(E, Z, T):
    # return (1/Z * exp(-E/(k*T))
	return (1/Z * np.exp(-E/(8.617 * 10**-5 * T)))

(popt, pcov) = curve_fit(fitFunc, xdata, rectHeights, p0=(.1, 4000), sigma=None, bounds=(0,np.inf))

xfitted = np.linspace(xmin,xmax,1001,endpoint=True)
yfitted = fitFunc(xfitted,popt[0], popt[1])
plt.plot(xfitted,yfitted,color="red", linewidth=1.0, linestyle="-", label="fitted")

plt.title("Histogram of EnergyData.dat")
plt.xlabel("x")
plt.ylabel("y")

print("Estimated temperature of the gas: {} celsuis".format(popt[1]))
print("Mean of energy data: {}".format(np.mean(data)))

# Export and show
plt.savefig("Final - Problem 2.pdf",dpi=72)
plt.show()
