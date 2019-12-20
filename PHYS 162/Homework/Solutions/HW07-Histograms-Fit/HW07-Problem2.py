#!/opt/local/bin/python

import numpy
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

data = numpy.loadtxt('HW07-linearFit.dat')
xdata = data.T[0]
ydata = data.T[1]

xmin = xdata.min()
xmax = xdata.max()
ymin = ydata.min()
ymax = ydata.max()

plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)
plt.scatter(xdata, ydata, 5, color="black", label="data")

def poly1( x, a, b ):
	return a + b * x

def poly2( x, a, b, c ):
	return a + b * x + c * x**2

def poly3( x, a, b, c, d ):
	return a + b * x + c * x**2 + d * x**3

def poly4( x, a, b, c, d, e ):
	return a + b * x + c * x**2 + d * x**3 + e * x**4

def poly5( x, a, b, c, d, e, f ):
	return a + b * x + c * x**2 + d * x**3 + e * x**4 + f * x**5

(popt1, pcov1) = curve_fit(poly1, xdata, ydata)
(popt2, pcov2) = curve_fit(poly2, xdata, ydata)
(popt3, pcov3) = curve_fit(poly3, xdata, ydata)
(popt4, pcov4) = curve_fit(poly4, xdata, ydata)
(popt5, pcov5) = curve_fit(poly5, xdata, ydata)

print(popt1)
print(popt2)
print(popt3)
print(popt4)
print(popt5)

xfitted = numpy.linspace(xmin,xmax,1001,endpoint=True)
yfitted1 = poly1(xfitted,popt1[0],popt1[1])
yfitted2 = poly2(xfitted,popt2[0],popt2[1],popt2[2])
yfitted3 = poly3(xfitted,popt3[0],popt3[1],popt3[2],popt3[3])
yfitted4 = poly4(xfitted,popt4[0],popt4[1],popt4[2],popt4[3],popt4[4])
yfitted5 = poly5(xfitted,popt5[0],popt5[1],popt5[2],popt5[3],popt5[4],popt5[5])
plt.plot(xfitted, yfitted1, color="gray", linewidth=1.0, linestyle="-", label="Degree 1")
plt.plot(xfitted, yfitted2, color="blue", linewidth=1.0, linestyle="-", label="Degree 2")
plt.plot(xfitted, yfitted3, color="red", linewidth=1.0, linestyle="-", label="Degree 3")
plt.plot(xfitted, yfitted4, color="orange", linewidth=1.0, linestyle="-", label="Degree 4")
plt.plot(xfitted, yfitted5, color="green", linewidth=1.0, linestyle="-", label="Degree 5")

plt.title("Polynomial Fits to Data")
plt.xlabel("x")
plt.ylabel("y")

plt.legend(loc='upper right', frameon=False)

print("It would seem that a 5th degree polynomial is necessary to obtain a good fit:\nf(x) = %.3f + %.3f*x + %.3f*x^2 + %.3f*x^3 + %.3f*x^4 + %.3f*x^5" % (popt5[0],popt5[1],popt5[2],popt5[3],popt5[4],popt5[5]))

plt.savefig("prob2.pdf",dpi=72)

plt.show()
