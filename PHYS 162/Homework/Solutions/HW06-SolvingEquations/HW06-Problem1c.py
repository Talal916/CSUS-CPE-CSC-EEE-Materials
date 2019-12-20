#!/opt/local/bin/python

# Solving nonlinear systems of equations using scipy.optimize.fsolve

import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import fsolve

def z1( r ):
	( x, y ) = r
	return x**5 - y**3 + y**2 - np.sin(x)

def z2( r ):
	( x, y ) = r
	return y**5 - x**3 + (np.cos(x)**2 - 0.98) / 4

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

Solutions = [fsolve(Z, (-1.3, -1.1)),
	fsolve(Z, (0.1, -0.3)),
	fsolve(Z, (1, 1))]
solX, solY = np.array(Solutions).T
plt.scatter(solX,solY,20,marker="o",color="black")

print("There are exactly three solutions...")
cnt = 0
for sol in Solutions:
	cnt += 1
	plt.annotate("(%.2f, %.2f)"%(sol[0],sol[1]),
		xy=(sol[0], sol[1]),  xycoords='data',
        xytext=(30, -50), textcoords='offset points', fontsize=16,
        arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.1"))
	print ("\tSolution %d: (x,y) = (%.3f,%.3f)"%(cnt, sol[0],sol[1]))
	
plt.savefig("prob1c.pdf",dpi=72)

plt.show()
