# -------------------------------------------------------------------------------
# HW05 - Plotting
# -------------------------------------------------------------------------------

# Imports
import numpy as np
import matplotlib
import math
import matplotlib.pyplot as plt

print("Problem 1 \t Plotting Functions")

# Graph x^2, ln(x), and sin(x).
'''
Pick three of your favorite (non-trivial) functions on a given domain and use 
matplotlib to plot them. Be sure to mess with at least the following plot 
attributes:
   • Title
   • Subplots
   • Axis labels
   • Curve color and thickness
   • Tick markers
   • Legend
   • Saving the ﬁgure to a ﬁle on the disk
   • Show the ﬁgure in the Python viewer
'''


def f1(x):
    return math.e**x


def f2(x):
    return x**2


def f3(x):
    return np.sin(x)


x = np.linspace(-1, 2, 100, endpoint=True)
y1 = f1(x)  # e^x function.
y2 = f2(x)  # x^2 function.
y3 = f3(x)

fig, ax = plt.subplots(nrows=1, ncols=1, figsize=(10, 4))
fig.suptitle('3 Functions')
line1, = ax.plot(x, y1, 'r', label='e^2', linewidth='3.0')
line2, = ax.plot(x, y2, 'g', label='x^2', linewidth='2.0')
line3, = ax.plot(x, y3 * np.pi, 'b', label='sin(x)', linewidth='1.0')
plt.xlabel('$x$')
plt.ylabel('$f$')

leg = plt.legend()
'''
fig, axs = plt.subplots(3, sharex=True, sharey=True, figsize=(8,13))

fig.suptitle('Sharing both axes')
axs[0].plot(x, y ** 2)
axs[1].plot(x, 0.3 * y, 'o')
axs[2].plot(x, y, '+')
'''

# Save figure to disk
plt.savefig("hw5_problem1.png", dpi=500)
# plt.savefig("1_basic_plotting.pdf",dpi=72)

# Show result on screen
plt.show()
