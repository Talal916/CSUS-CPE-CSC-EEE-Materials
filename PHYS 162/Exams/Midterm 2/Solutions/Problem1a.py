#!/Library/Frameworks/Python.framework/Versions/3.7/bin/python3

# Problem 1a on Midterm 2 (2019)

import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import brentq

def f( x ):
	return 1.5 * x * np.cos(0.6 * x)

def g( x ):
	return np.exp(x/5) + 2.2

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

#plt.ylim(0.0,50.0)

print("There are two solutions...")
print(brentq( h, 8.5, 9.5 ))
print(brentq( h, 11.5, 12.5 ))

plt.savefig("prob1a.pdf")

plt.show()
