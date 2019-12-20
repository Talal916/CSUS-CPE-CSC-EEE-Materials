#!/opt/local/bin/python

import numpy
import numpy.random as ran
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

def d( x, d0, xbar, sigma ):
	return d0 * numpy.exp(-(x - xbar)**2 / (2 * sigma**2))

plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)

normalData = ran.normal(5,1.25,100000)
(normalHist, edges, patches) = plt.hist(normalData, bins=50, range=None, rwidth=0.9, density=True, color=None, label="hist")

xmin = 0
xmax = 10.0
ymin = 0.0
ymax = normalHist.max()*1.1

plt.title("Histogram for Randomly Generated Gaussian Data")
plt.xlabel("data values")
plt.ylabel("normalized count")
plt.xlim(xmin,xmax)
plt.ylim(ymin,ymax)

xdata = []
for i in range(len(edges)-1):
	x = (edges[i] + edges[i+1]) / 2
	xdata.append(x)

plt.scatter(xdata, normalHist, 20, color="blue", zorder=2, label="midpoints")

(popt, pcov) = curve_fit(d, xdata, normalHist, bounds=(0,numpy.inf))

print(popt)

print("Integral of my fitted function: %.3f" % (popt[0]*numpy.sqrt(2*numpy.pi)*popt[2]))

xfitted = numpy.linspace(xmin,xmax,1001,endpoint=True)
yfitted = d(xfitted,popt[0],popt[1],popt[2])
plt.plot(xfitted, yfitted, color="red", linewidth=2.0, linestyle="--", label="fitted")

plt.legend(loc='upper left', frameon=False)

plt.savefig("prob1.pdf",dpi=72)

plt.show()
