#!/opt/local/bin/python

import numpy
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

xdata,ydata = numpy.loadtxt('HW07-nonLinearFit.dat',unpack=True)

xmin = xdata.min()
xmax = xdata.max()
ymin = ydata.min()
ymax = ydata.max()

plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)
plt.scatter(xdata, ydata, 5, color="black", label="data")

xfitted = numpy.linspace(xmin,xmax,1001,endpoint=True)

def fit1( x, a, k ):
	return a * numpy.sin(k * x)

# First fit with just a single sine function
(popt1, pcov1) = curve_fit(fit1, xdata, ydata, p0=(3,2.5))

print(popt1)

yfitted1 = fit1(xfitted,popt1[0],popt1[1])
plt.plot(xfitted, yfitted1, color="gray", linewidth=1.0, linestyle="-", label="fit1")

def fit3( x, a1, k1, a2, k2 ):
	return fit1(x, a1, k1) + fit1(x, a2, k2)

def fit2( x, a, k ):
	return fit3(x, popt1[0], popt1[1], a, k)

# Now use those fit parameters for one of the two sinusoids and fit the other sinusoid
(popt2, pcov2) = curve_fit(fit2, xdata, ydata, p0=(1.1*popt1[0],1.1*popt1[1]), sigma=None, bounds=(-numpy.inf,numpy.inf))

print(popt2)

yfitted2 = fit2(xfitted,popt2[0],popt2[1])
plt.plot(xfitted, yfitted2, color="red", linewidth=1.0, linestyle="-", label="fit2")

# Finally, we can use our results from the previous two phases to try and fit all the parameters simultaneously
(popt3, pcov3) = curve_fit(fit3, xdata, ydata, p0=(popt1[0],popt1[1],popt2[0],popt2[1]), sigma=None, bounds=(-numpy.inf,numpy.inf))

print(popt3)

yfitted3 = fit3(xfitted,popt3[0],popt3[1],popt3[2],popt3[3])
plt.plot(xfitted, yfitted3, color="blue", linewidth=1.0, linestyle="-", label="fit3")

plt.title("Sinusoidal Fits to Data")
plt.xlabel("x")
plt.ylabel("y")

plt.legend(loc='upper right', frameon=False)

#print("Uncomment plt.plot() calls for the first two phases if you wish to see them!")

plt.savefig("prob3.pdf",dpi=72)

plt.show()
