import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import brentq
from scipy.optimize import fsolve

print("Problem 1b\n")

def z1(r):
    (x, y) = r
    return 0.59*x**4 + y**2 / 2.4 - (1.5*(x + 0.8))

def z2(r):
    (x, y) = r
    return np.e**(-0.3*x*y) - np.sin(y**2)

def Z(r):
    return (z1(r), z2(r))

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

Solutions = [fsolve(Z, (-0.49, -1.0)),
	fsolve(Z, (-0.25, -1.42)),
	fsolve(Z, (1.3, 1.6)),
    fsolve(Z, (1.5, 0.8))]
solX, solY = np.array(Solutions).T
plt.scatter(solX,solY,20,marker="o",color="black")

print("There are exactly 4 solutions...")

cnt = 0
for sol in Solutions:
	cnt += 1
	plt.annotate("(%.2f, %.2f)"%(sol[0],sol[1]),
		xy=(sol[0], sol[1]),  xycoords='data',
        xytext=(30, -50), textcoords='offset points', fontsize=16,
        arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.3"))
	print ("\tSolution %d: (x,y) = (%.3f,%.3f)"%(cnt, sol[0],sol[1]))


# Export and show.
plt.savefig("p1b.pdf", dpi=72)
plt.show()