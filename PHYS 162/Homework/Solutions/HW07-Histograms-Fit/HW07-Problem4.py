#!/opt/local/bin/python

import numpy
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

fs=10  # used as fontsize

data = numpy.loadtxt('HW07-doubleGaussian.dat')

def d( x, d0, xbar, sigma ):
	return d0 * numpy.exp(-(x - xbar)**2 / (2 * sigma**2))

def d2( x, d01, xbar1, sigma1, d02, xbar2, sigma2 ):
	return d(x, d01, xbar1, sigma1) + d(x, d02, xbar2, sigma2)

fig = plt.figure(figsize=(6,6), dpi=80)

### Part (a)
plt.subplot(311)
plt.plot(data,linestyle="",marker="+", color='blue')
plt.xlabel('Measurement #', fontsize=fs)
plt.ylabel('$G$ [$2e^2/h$]', fontsize=fs)

### Parts (b) - (c) ###
plt.subplot(312)

(histData, edges, patches) = plt.hist(data, bins=50, color="blue", label="data counts")

xmin = edges[0]
xmax = edges[-1]
xrange = xmax - xmin
ymin = 0.0
ymax = histData.max()
yrange = ymax - ymin

plt.xlim(xmin - 0.1 * xrange, xmax + 0.4 * xrange)
plt.ylim(ymin, ymax + 0.25 * yrange)

xdata = []
for i in range(len(edges)-1):
	x = (edges[i] + edges[i+1]) / 2
	xdata.append(x)

plt.scatter(xdata, histData, 20, color="black", zorder=2#, label="midpoints"
)

(popt, pcov) = curve_fit(d2, xdata, histData, bounds=(0,numpy.inf))

xfitted = numpy.linspace(xmin,xmax,1001,endpoint=True)
yfitted = d2(xfitted,popt[0],popt[1],popt[2],popt[3],popt[4],popt[5])
plt.plot(xfitted, yfitted, color="black", linewidth=2.0, linestyle="-", label="Double Gaussian fit")

plt.title("Histogram of Imported $G$ Data", fontsize=fs)
plt.xlabel("$G$ $[2e^2/h]$", fontsize=fs)
plt.ylabel("Count", fontsize=fs)

plt.legend(loc='upper right', 
		   #bbox_to_anchor=(1.0, 0.9),
		   fontsize=fs)


### Parts (d) -(e) ###
peak1data = data[:1100]
peak2data = data[1100:]

mean1 = numpy.mean(peak1data)
mean2 = numpy.mean(peak2data)

stdev1 = numpy.std(peak1data,ddof=1)
stdev2 = numpy.std(peak2data,ddof=1)

if (mean1 < mean2):
    meanSmall = mean1
    stdevSmall = stdev1
    meanLarge = mean2
    stdevLarge = stdev2
else:
    meanSmall = mean2
    stdevSmall = stdev2
    meanLarge = mean1
    stdevLarge = stdev1

if (popt[1] < popt[4]):
    poptMeanSmall = popt[1]
    poptStdevSmall = popt[2]
    poptMeanLarge = popt[4]
    poptStdevLarge = popt[5]
else:
    poptMeanSmall = popt[4]
    poptStdevSmall = popt[5]
    poptMeanLarge = popt[1]
    poptStdevLarge = popt[2]

print(f"Comparison of mean and standard deviation of individual peaks to fit data:\n\n"
	f"  Mean for peak 1: {meanSmall:.3f}"
	f"\txbar1 from fit: {poptMeanSmall:.3f}\n"
	f"  Mean for peak 2: {meanLarge:.3f}"
	f"\txbar2 from fit: {poptMeanLarge:.3f}\n\n"
	f"  Standard deviation for peak 1: {stdevSmall:.3f}"
	f"\tsigma1 from fit: {poptStdevSmall:.3f}\n"
	f"  Standard deviation for peak 2: {stdevLarge:.3f}"
	f"\tsigma2 from fit: {poptStdevLarge:.3f}")

plt.subplot(313)

(histData1, edges1, patches1) = plt.hist(peak1data, 
	bins=35, color="blue", 
	label=f"Peak 1, $\mu={mean1:.2f} \\times 2e^2/h$", 
	alpha=0.5)
(histData2, edges2, patches2) = plt.hist(peak2data, bins=35, color="red", 
	label=f"Peak 2, $\mu={mean2:.2f} \\times 2e^2/h$", 
	alpha=0.5)

plt.title("Double Histogram of Imported $G$ Data", fontsize=fs)
plt.xlabel("$G$ $[2e^2/h]$", fontsize=fs)
plt.ylabel("Count", fontsize=fs)

xmin = edges1[0]
xmax = edges2[-1]
xrange = xmax - xmin
ymin = 0.0
ymax = numpy.max([histData1.max(),histData2.max()])
yrange = ymax - ymin
plt.xlim(xmin - 0.1 * xrange, xmax + 0.4 * xrange)
plt.ylim(0, ymax + 0.25 * yrange)

plt.legend(loc='upper right', frameon=False)

fig.set_tight_layout(True)

plt.savefig("prob4.pdf",dpi=72)

plt.show()
