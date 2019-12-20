# ----------------------------------------------------------------------------------
# Homework 6: Solving Equations in Python
# ----------------------------------------------------------------------------------

import numpy as np
import scipy
import math
from math import pi
from math import sin
from math import cos
from math import tan
from math import pow
from math import log
from math import log10 # log base 10.

from math import sqrt
from scipy.optimize import brentq
import matplotlib.pyplot as plt   
from scipy.optimize import fsolve
import matplotlib.lines as mlines

print("\nProblem 1c: Systems")
print("\tx^5 - y^3 + y^2 = sin(x)\n\ty^5 - x^3 = -1/4(cos^2(x) - 0.98)\n")

'''
Solve the following equations and systems of equations using the scipy module.

In all cases, ﬁnd all solutions, or at least 5 solutions (whichever is smaller). 
For parts (a) and (b), limit yourselves to positive (i.e., not including 0) 
values of x.

For each case, make a plot, adding dots at each solution you have solved for. 
Try annotating the solutions using the commands you learned in previous lecture notes!

Note: I recommend a separate script ﬁle for each part.

Do not try to solve any part of this system of equations analytically. The goal here is
to use purely numerical methods.

'''
def z1(r):
    (x, y) = r
    return x**5 - y**3 + y**2 - np.sin(x)

def z2(r):
    (x, y) = r
    return y**5 - x**3 + 1/4*(np.cos(x)**2 + 0.98)

fs = 10 # Font size.

# Create a new figure of size ''x'' points, using '' dots per inch
plt.figure(figsize=(10,8), dpi=80)

# Create a new subplot from a grid of 1x1
ax = plt.subplot(111)


# Generates data to be plotted.
xlist = np.linspace(-25, 30, 1000, endpoint=True)
ylist = np.linspace(-10, 3, 1000, endpoint=True)
X, Y = np.meshgrid(xlist, ylist)
Z1 = z1( (X, Y) )
Z2 = z2( (X, Y) )

plt.contour(X, Y, Z1, levels=[0], colors=['blue'])
plt.contour(X, Y, Z2, levels=[0], colors=['red'])

plt.xlabel("$x$", fontsize=fs)
plt.ylabel("$y$", fontsize=fs)

plt.xticks(fontsize=fs)
plt.yticks(fontsize=fs)

plt.xlim(-3, 2)
plt.ylim(-6, 3)

blue_line = mlines.Line2D([], [], color='blue', label=r"$x$^5 - $y$^3 + $y$^2 = $sin$($x$)")
red_line = mlines.Line2D([], [], color='red', label=r"$y$^5 - $x$^3 = -1/4($cos$^2($x$) - 0.98)")
						  
plt.legend(handles=[blue_line, red_line])

def Z( r ):
  return ( z1(r), z2(r) )

print("Getting solutions:\n")

print(fsolve(Z, (-1.5, -1.1)))
print(fsolve(Z, (0.61, -0.51)))
print(fsolve(Z, (0.79, 0.98)))



# Annotate the points.
x_position = [-1.33464007, 0.6976717, 0.93087786]
y_position = [-1.21392016, -0.55409576, 0.86075509]
plt.plot(x_position, y_position, 'ko')

# Position the annotations.
x_annotate = [-1.33464007, 0.6976717, 0.93087786]
y_annotate = [-1.21392016, -0.55409576, 0.86075509]
x_label = ["[-1.33, -1.21]", "[0.69, -0.55]", "[0.93, 0.86]"]

for i in range(0, 3):
    plt.annotate(x_label[i],
             xy=(x_annotate[i], y_annotate[i]),
             xycoords=('data'),
             xytext=(x_position[i], y_position[i]),
             textcoords='offset points',
             fontsize=10,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=1"))


plt.savefig("hw6-problem1c.pdf")
# Show plot on window.
plt.show()


