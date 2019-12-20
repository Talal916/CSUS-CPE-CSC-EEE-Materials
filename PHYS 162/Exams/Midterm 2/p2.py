import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import brentq
from scipy.optimize import fsolve
from scipy.optimize import curve_fit

print("Problem 2\n")

fs = 10  # used as fontsize

def d( x, d0, xbar, sigma ):
	return d0 * np.exp(-(x - xbar)**2 / (2 * sigma**2))

data = np.loadtxt('snakeData.dat')

# Part (a).
peak1data = data[:1000]

xbar = np.mean(peak1data)
sigma = np.std(peak1data,ddof=1)

print(f"Mean and standard deviation of the data:\n\n"
	f"  Mean for histogram: {xbar:.3f}"
	f"  Standard deviation for histogram: {sigma:.3f}")

# Part (b)
plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)
(hist, edges, patches) = plt.hist(data, bins=50, range=None, rwidth=0.9, density=True, color=None, label="hist")

xmin = edges[0]
xmax = edges[-1]
ymin = 0.0
ymax = hist.max()*1.1

# Part (c)
xdata = []
for i in range(len(edges)-1):
	x = (edges[i] + edges[i+1]) / 2
	xdata.append(x)
plt.scatter(xdata, hist, 20, color="black", zorder=2, label="midpoints")

# Part (d)
def d( x, d0, xbar, sigma ):
	return d0 * np.exp(-(x - xbar)**2 / (2 * sigma**2))

(popt, pcov) = curve_fit(d, xdata, hist, bounds=(0,np.inf))

print(popt)

print("Integral of my fitted function: %.3f" % (popt[0]*np.sqrt(2*np.pi)*popt[2]))

xfitted = np.linspace(xmin,xmax,1001,endpoint=True)
yfitted = d(xfitted,popt[0],popt[1],popt[2])
plt.plot(xfitted, yfitted, color="red", linewidth=2.0, linestyle="--", label="fitted")

plt.legend(loc='upper left', frameon=False)

# Export and show.
plt.savefig("p2.pdf", dpi=72)
plt.show()