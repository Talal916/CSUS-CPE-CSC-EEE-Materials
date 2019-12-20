#!/opt/local/bin/python

# Solving single equations using scipy.optimize.brentq

import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import brentq

def f( x ):
	return x

def g( x ):
	return np.tan(x) / 2

def h( x ):
	return f(x) - g(x)

# Create a new figure of size 8x6 points, using 80 dots per inch
plt.figure(figsize=(8,6), dpi=80)

# Create a new subplot from a grid of 1x1
plt.subplot(111)

# Generates data to be plotted
X = np.linspace(0, 15, 2560,endpoint=True) # only need positive values of x
Yf = f(X)
Yg = g(X)

plt.plot(X, Yf, color="blue", linewidth=1.0, linestyle="-")
plt.plot(X, Yg, color="red", linewidth=1.0, linestyle="-")

#prepare x tick labels
xticks=["$0$","$\pi/2$","$\pi$"]
for i in range(2,6):
	xticks.append("$%d\pi/2$"%(2*i-1))
	xticks.append("$%d\pi$"%(i))

plt.xticks(np.linspace(0,10,11)*np.pi/2,xticks)
plt.ylim(0.0,15.0)

Solutions = [brentq( h, 1, np.pi / 2 ),
	brentq( h, 4.4, 3 * np.pi / 2 ),
	brentq( h, 7.5, 5 * np.pi / 2 ),
	brentq( h, 10.5, 7 * np.pi / 2 ),
	brentq( h, 13.8, 9 * np.pi / 2 )]

plt.scatter(Solutions,f(Solutions),20,marker="o",color="orange")
cnt=0
for sol in Solutions:
	cnt += 1
	plt.annotate("%.2f"%(sol),
		xy=(sol, f(sol)),  xycoords='data',
        xytext=(30, -20), textcoords='offset points', fontsize=16,
        arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.1"))
	print ("Solution %d: x = %.3f"%(cnt, sol))

plt.savefig("prob1b.pdf",dpi=72)

plt.show()
