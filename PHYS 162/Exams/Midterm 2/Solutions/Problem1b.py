#!/Library/Frameworks/Python.framework/Versions/3.7/bin/python3

# Problem 1b on Midterm 2 (2019)

import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import fsolve

def z1( r ):
	( x, y ) = r
	return 0.59 * x**4 + y**2 / 2.4 - 1.5 * (x + 0.8)

def z2( r ):
	( x, y ) = r
	return np.exp(-0.3 * x * y) - np.sin(y**2)

def Z( r ):
	return ( z1(r), z2(r) )

# Create a new figure of size 8x6 points, using 80 dots per inch
plt.figure(figsize=(8,6), dpi=80)

# Create a new subplot from a grid of 1x1
plt.subplot(111)

xlist = np.linspace(-2.5,2.5,100,endpoint=True)
ylist = np.linspace(-2.5,2.5,100,endpoint=True)
X, Y = np.meshgrid(xlist,ylist)
Z1 = z1((X,Y))
Z2 = z2((X,Y))

plt.contour(X,Y,Z1,levels=[0],colors=['blue'])
plt.contour(X,Y,Z2,levels=[0],colors=['red'])

print("There are exactly four solutions...")
print(fsolve(Z, (1.38, 1.58)))
print(fsolve(Z, (1.53, 0.85)))
print(fsolve(Z, (-0.48, -1.05)))
print(fsolve(Z, (-0.23, -1.45)))

plt.savefig("prob1b.pdf")

plt.show()
