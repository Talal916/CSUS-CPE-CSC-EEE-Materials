#!/Library/Frameworks/Python.framework/Versions/3.7/bin/python3

# Problem 3 on Final Exam (2019)

import numpy
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

data = numpy.loadtxt('EnergyData.dat')

k = 8.617e-5

def P( E, T, Z ):
	return ( 1.0 / Z ) * numpy.exp( -E / ( k * T ) )

fig = plt.figure(figsize=(8,6))
plt.subplot(111)

(histData, edges, patches) = plt.hist(data, bins=30, rwidth=0.9, density=True, color="blue", label="data counts")

xmin = edges[0]
xmax = edges[-1]
xrange = xmax - xmin
ymin = 0.0
ymax = histData.max()
yrange = ymax - ymin

plt.xlim(xmin - 0.1 * xrange, xmax + 0.1 * xrange)
plt.ylim(ymin, ymax + 0.1 * yrange)

xdata = []
for i in range(len(edges)-1):
	x = (edges[i] + edges[i+1]) / 2
	xdata.append(x)

plt.scatter(xdata, histData, 20, color="black", zorder=2, label="midpoints")

(popt, pcov) = curve_fit(P, xdata, histData, p0=(3000,1))#/2500))

print(f"The best estimate for the temperature is {popt[0]:.0f} K.")
print(f"The average energy of the gas particles is {numpy.mean(data):.4f} eV.")

xfitted = numpy.linspace(xmin,xmax,1001,endpoint=True)
yfitted = P(xfitted,popt[0],popt[1])
plt.plot(xfitted, yfitted, color="black", linewidth=2.0, linestyle="-", label="fitted")

plt.title("Histogram of Imported Data")
plt.xlabel("energy values")
plt.ylabel("normalized count")

plt.legend(loc='upper right', frameon=False)

plt.savefig("problem3.pdf")

plt.show()
