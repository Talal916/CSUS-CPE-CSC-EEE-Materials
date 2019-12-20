#!python 3

import numpy as np
import matplotlib.pyplot as plt

xmin, xmax = 0.0, 10.0

X,Y = np.loadtxt("fct.dat", usecols={0,1}, unpack=True)

plt.subplot(2,1,1)
plt.plot(X,Y,color="red",label=r'$x^2\sin(2x-\pi/2)$')
plt.xlabel("x")
plt.ylabel("f(x)")
plt.xlim(xmin,xmax)

plt.legend()

X,Y = np.loadtxt("slope.dat", usecols={0,1}, unpack=True)

def slope(x):
	return 2*x*np.sin(2*x-np.pi/2)+2*x**2*np.cos(2*x-np.pi/2)

dY = slope(X)

plt.subplot(2,1,2)

plt.plot(X,Y,color="red",label=r'slope of $x^2-\sin(2x-\pi/2)$')
plt.plot(X,dY,color="blue",ls="dashed", label=r'derivative of  $x^2-\sin(2x-\pi/2)$')

plt.xlabel("x")
plt.ylabel("f'(x)")
plt.xlim(xmin,xmax)

plt.legend()
plt.show()