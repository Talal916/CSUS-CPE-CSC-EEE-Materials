#!/Library/Frameworks/Python.framework/Versions/3.7/bin/python3

# Problem 2 on Midterm 2 (2019)

import numpy
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)

data = numpy.loadtxt("snakeData.dat")

(rectHeights, edges, patches) = plt.hist(data, bins=30, range=None, density=True, color=None, label=None)

xmin = numpy.min(data)
xmax = numpy.max(data)
ymin = 0.0
ymax = rectHeights.max()*1.1

xdata = []
for i in range(len(edges)-1):
	x = (edges[i] + edges[i+1]) / 2
	xdata.append(x)

plt.xlim(xmin,xmax)
plt.ylim(ymin,ymax)

plt.scatter(xdata, rectHeights, 20, color="black", zorder=2)

def fitFunc(x, d0, mu, sigma):
	return d0 * numpy.exp(-(x-mu)**2/(2*sigma**2))

(popt, pcov) = curve_fit(fitFunc, xdata, rectHeights, p0=(1,22.311,1.777), sigma=None, bounds=(0,numpy.inf))

#print(popt)

xfitted = numpy.linspace(xmin,xmax,1001,endpoint=True)
yfitted = fitFunc(xfitted,popt[0],popt[1],popt[2])
plt.plot(xfitted,yfitted,color="gray", linewidth=1.0, linestyle="-", label="fitted")

print("The average snake length is {:.3f} cm.".format(numpy.mean(data)))
print("This compares well to the mean determined from the fit function: {:.3f} cm.".format(popt[1]))
print("The standard deviation of snake lengths is {:.3f} cm.".format(numpy.std(data,ddof=1)))
print("This compares well to the standard deviation determined from the fit function:\n {:.3f} cm.".format(popt[2]))
print("From the fit data, we can conclude that roughly 68%% of snakes have a length\n between {:.3f} cm and {:.3f} cm.".format(popt[1]-popt[2],popt[1]+popt[2]))

plt.show()
