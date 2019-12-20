#!/opt/local/bin/python

# Solving single equations using scipy.optimize.brentq

import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import brentq

def f( x ):
	return np.log(x)

def g( x ):
	return np.pi * np.sin(x)

def h( x ):
	return f(x) - g(x)

# Create a new figure of size 8x6 points, using 80 dots per inch
plt.figure(figsize=(8,6), dpi=80)

# Create a new subplot from a grid of 1x1
plt.subplot(111)

# Generates data to be plotted
X = np.linspace(0.1, 20, 2560,endpoint=True) # only need positive values of x
Yf = f(X)
Yg = g(X)

plt.plot(X, Yf, color="blue", linewidth=1.0, linestyle="-")
plt.plot(X, Yg, color="red", linewidth=1.0, linestyle="-")


print("There are a finite number of solutions, but more than five;\nfinding first five positive solutions...")

#plt.ylim(-2.0,2.0)
Solutions = [brentq( h, 2.5, 3.5 ),
	brentq( h, 6, 7.5 ),
	brentq( h, 7.5, 10 ),
	brentq( h, 13, 14 ),
	brentq( h, 14, 15 )]

plt.scatter(Solutions,f(Solutions),20,marker="o",color="orange")
cnt=0
for sol in Solutions:
	cnt += 1
	plt.annotate("%.2f"%(sol),
		xy=(sol, f(sol)),  xycoords='data',
        xytext=(30, 40*(-1)**cnt), textcoords='offset points', fontsize=16,
        arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.1"))
	print ("Solution %d: x = %.3f"%(cnt, sol))
plt.savefig("prob1a.pdf",dpi=72)

plt.show()
