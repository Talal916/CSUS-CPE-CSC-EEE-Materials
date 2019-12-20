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

print("\nProblem 1b: x = 1/2 * tan(x)")

'''
Solve the following equations and systems of equations using the scipy module.

In all cases, ﬁnd all solutions, or at least 5 solutions (whichever is smaller). 
For parts (a) and (b), limit yourselves to positive (i.e., not including 0) 
values of x.

For each case, make a plot, adding dots at each solution you have solved for. 
Try annotating the solutions using the commands you learned in previous lecture notes!

Note: I recommend a separate script ﬁle for each part.

(Note: when plotting, the vertical lines are asymptotes; they are not part of the tangent
function so don’t search for solutions at their intersection with the LHS.
Also, zero is not positive so it doesn’t count as one of your ﬁve solutions!)

'''

# ln(x)
def g(x):
    return x

# pi*sin(x)
def h(x):
    return 1/2 * np.tan(x)

def f(x):
    return g(x) - h(x)

fs = 10 # Font size.

# Create a new figure of size ''x'' points, using '' dots per inch
plt.figure(figsize=(10,8), dpi=80)

# Create a new subplot from a grid of 1x1.
ax = plt.subplot(111)

# Generates data to be plotted.
X = np.linspace(1, 15, 2560,endpoint=True)

Y = g(X) # x
plt.plot(X, Y, color="red", linewidth=1.0, linestyle="-",label="$x$")

Y = h(X) # 1/2 * tan(x)
plt.plot(X, Y, color="blue", linewidth=1.0, linestyle="-",label="1/2 $tan$($x$)")

plt.xticks(fontsize = fs)
plt.yticks(fontsize = fs)
plt.legend(fontsize = fs)

# Axis labels.
plt.title('$x$ = 1/2 $tan$($x$)')
plt.xlabel('$X$')
plt.ylabel('$y$ = $f(x)$')

# Don't get 0.
plt.xlim(1, 15)
plt.ylim(-5, 15)

print("\nGetting 5 solutions:\n")

(x1, x2) = (1.0, 1.47)
print(f"Solution for f(x) = 0, between {x1:.1f} and {x2:.1f} is "
        f"{brentq(f, x1, x2):.3f}")


(x1, x2) = (4.44, 4.65)
print(f"Solution for f(x) = 0, between {x1:.1f} and {x2:.1f} is "
        f"{brentq(f, x1, x2):.3f}")


(x1, x2) = (7.5, 7.8)
print(f"Solution for f(x) = 0, between {x1:.1f} and {x2:.1f} is "
        f"{brentq(f, x1, x2):.3f}")


(x1, x2) = (10.88, 10.97)
print(f"Solution for f(x) = 0, between {x1:.1f} and {x2:.1f} is "
        f"{brentq(f, x1, x2):.3f}")


(x1, x2) = (14.05, 14.11)
print(f"Solution for f(x) = 0, between {x1:.1f} and {x2:.1f} is "
        f"{brentq(f, x1, x2):.3f}")


# Annotate the points.
x_position = [1.166, 4.604, 7.790, 10.950, 14.102]
y_position = [1.11, 4.56, 7.72, 10.89, 14.05]
plt.plot(x_position, y_position, 'ko')

# Position the annotations.
x_annotate = [1.166, 4.604, 7.790, 10.950, 14.102]
y_annotate = [1.11, 4.56, 7.72, 10.89, 14.00]
x_label = ["1.166", "4.604", "7.790", "10.950", "14.102"]

for i in range(0, 5):
    plt.annotate(x_label[i],
             xy=(x_annotate[i], y_annotate[i]),
             xycoords=('data'),
             xytext=(x_position[i], y_position[i]),
             textcoords='offset points',
             fontsize=10,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=2"))

plt.savefig("hw6-problem1b.pdf")
# Show plot on window.
plt.show()


