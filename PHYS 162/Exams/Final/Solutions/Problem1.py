#!/Library/Frameworks/Python.framework/Versions/3.7/bin/python3

# Problem 1 on Final Exam (2019)

import numpy as np
import matplotlib
import matplotlib.pyplot as plt
from scipy.optimize import brentq

# Change to serif font
matplotlib.rcParams['font.family'] = "serif"
plt.rcParams["mathtext.fontset"] = "dejavuserif"

# Setup for exact plot
def v( t ):
	return 4 * t**2 * np.exp( -0.5 * t ) - np.sqrt( 13 * t ) + 1.2

tmin = 0.0
tmax = 10.0
trange = tmax - tmin

numpoints = 2001

# Setup for plot of numerical data
(tvals, vvals) = np.loadtxt("v_of_t.dat",unpack=True)

# Create a new figure of size 8x6 points
plt.figure(figsize=(8,6))

# Create a new subplot from a grid of 1x1
plt.subplot(111)

# Generates data to be plotted
T = np.linspace(tmin, tmax, numpoints,endpoint=True) # only need positive values of x
VT = v(T)
Z = np.zeros(numpoints)

plt.plot(T, VT, color="blue", linewidth=2.0, linestyle="--", zorder=10, label=r"Exact $v(t)$")
plt.plot(tvals, vvals, color="red", linewidth=2.0, linestyle="-", label=r"Numerical $v(t)$")
plt.plot(T, Z, color="black", linewidth=1.0, linestyle="-")

# Find solutions
t1 = brentq( v, 0.0, 0.5 )
t2 = brentq( v, 0.5, 2.0 )
t3 = brentq( v, 5.0, 7.0 )
sols = [ [t1, (+10, +30)], [t2, (+10, -30)], [t3, (+10, +30)] ]

# Mark and annotate solutions
plt.scatter([t1, t2, t3], [0.0, 0.0, 0.0], 20, color="black", zorder=20)
for sol in sols:
    t = sol[0]
    v = 0.0
    loc = sol[1]
    plt.annotate(f'{t:.2f}',
             xy=(t, v),  xycoords='data',
             xytext=loc, textcoords='offset points', fontsize=16,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))

# Labels and such
plt.title("Velocity vs. time")
plt.xlabel("Time (s)")
plt.ylabel("Velocity (m/s)")
plt.legend(loc="lower left")

print("There are a three solutions")
print(f"t1 = {t1:.5f} s")
print(f"t2 = {t2:.5f} s")
print(f"t3 = {t3:.5f} s")

plt.savefig("problem1.pdf")

plt.show()
