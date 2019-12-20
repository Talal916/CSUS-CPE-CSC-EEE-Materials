# ----------------------------------------------------------------------------------
# Homework 6: Solving Equations in Python
# ----------------------------------------------------------------------------------

import numpy as np
import scipy
import math
from math import pi
from math import sin
from math import cos
from math import pow
from math import log
from math import log10 # log base 10.

from math import sqrt
from scipy.optimize import brentq
import matplotlib.pyplot as plt   
from scipy.optimize import fsolve

print("\nProblem 1a: ln(x) = pi*sin(x)\n")

'''
Solve the following equations and systems of equations using the scipy module.

In all cases, ﬁnd all solutions, or at least 5 solutions (whichever is smaller). 
For parts (a) and (b), limit yourselves to positive (i.e., not including 0) 
values of x.

For each case, make a plot, adding dots at each solution you have solved for. 
Try annotating the solutions using the commands you learned in previous lecture notes!

Note: I recommend a separate script ﬁle for each part.
'''

# ln(x)
def g(x):
    return np.log(x)

# pi*sin(x)
def h(x):
    return np.pi * np.sin(x)

def f(x):
    return g(x) - h(x)

fs = 10 # Font size.

# Create a new figure of size ''x'' points, using '' dots per inch
plt.figure(figsize=(8,6), dpi=80)

# Create a new subplot from a grid of 1x1.
ax = plt.subplot(111)

# Generates data to be plotted.
X = np.linspace(1, 20, 2560,endpoint=True)

Y = g(X) # ln(x).
plt.plot(X, Y, color="red", linewidth=1.0, linestyle="-",label="$ln$($x$)")

Y = h(X) # pi*sin(x)
plt.plot(X, Y, color="blue", linewidth=1.0, linestyle="-",label="$\u03C0$ $sin$($x$)")

plt.xticks(fontsize = fs)
plt.yticks(fontsize = fs)
plt.legend(fontsize = fs)

plt.title("$ln$($x$) = $\u03C0$ $sin$($x$)")
plt.xlabel('$X$')
plt.ylabel('$y$ = $f(x)$')

# Don't get 0.
plt.xlim(1, 17.0)

print("Getting 5 solutions:\n")

(x1, x2) = (2.0, 4.0)
print(f"Solution for f(x) = 0, between {x1:.1f} and {x2:.1f} is "
        f"{brentq(f, x1, x2):.3f}")

(x1, x2) = (6.0, 8.0)
print(f"Solution for f(x) = 0, between {x1:.1f} and {x2:.1f} is "
        f"{brentq(f, x1, x2):.3f}")

(x1, x2) = (8.0, 10.0)
print(f"Solution for f(x) = 0, between {x1:.1f} and {x2:.1f} is "
        f"{brentq(f, x1, x2):.3f}")

(x1, x2) = (12.0, 14.0)
print(f"Solution for f(x) = 0, between {x1:.1f} and {x2:.1f} is "
        f"{brentq(f, x1, x2):.3f}")

(x1, x2) = (14.0, 16.0)
print(f"Solution for f(x) = 0, between {x1:.1f} and {x2:.1f} is "
        f"{brentq(f, x1, x2):.3f}")


# Annotate the points.
x_position = [2.807, 6.948, 8.667, 13.545, 14.682]
y_position = [1.035, 1.933, 2.157, 2.606, 2.681]
plt.plot(x_position, y_position, 'ko')

# Position the annotations.
x_annotate = [2.807, 6.948, 8.667, 13.545, 14.682]
y_annotate = [1.4, 2.1, 2.3, 2.7, 2.9]
x_label = ["2.807", "6.948", "8.667", "13.545", "14.682"]

for i in range(0, 5):
    plt.annotate(x_label[i],
             xy=(x_annotate[i], y_annotate[i]),
             xycoords=('data'),
             xytext=(x_position[i], y_position[i]),
             textcoords='offset points',
             fontsize=10,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=2"))

plt.savefig("hw6-problem1a.pdf")
# Show plot on window.
plt.show()


