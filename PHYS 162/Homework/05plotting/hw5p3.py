# -------------------------------------------------------------------------------
# HW05 - Plotting
# -------------------------------------------------------------------------------

# Imports
import numpy as np
import matplotlib
import math
from math import cos
from math import sin
from math import tan
from math import radians
from math import sqrt
import matplotlib.pyplot as plt
from matplotlib.pyplot import cm

print("Problem 3 \t Modification of the ground")
'''
We want to illustrate the projectile problem with ﬂat ground described in Lecture Notes 4.
This should be a fairly straightforward application of the functions discussed above.
Prepare the following graphs, in both cases including the ground as a thick black line.

   (a) several curves with diﬀerent values of v0 for a ﬁxed value of θ0;
   (b) several curves with diﬀerent values of θ0 for a ﬁxed value of v0.

Make sure to include the values of the parameters v0 and θ0 in your graph.

Note: Remember that here we are plotting trajectories, y(x) for ﬁxed values of v0 and θ0,
not the range, so you can’t reuse the function you deﬁned in the corresponding homework
(it was only calculating the range).

You should be able to hover your mouse over the plots created in the Python viewer and
read oﬀ the coordinates of any point. Use this approach to ﬁnd the range of the projectile
in a few cases that you plotted above, and add the range into the curve label in the legend.
'''
colors = "bgrcmyk"


def y(x, v0, th0):
    '''
   "This function will return the y−coordinate for a given /
   x−coordinate and initial velocity."
   '''

    th0rad = th0 * np.pi / 180.0  # in radians
    return h0 + np.tan(th0rad) * x - (g * x**2) / (2 * v0**2 *
                                                   np.cos(th0rad)**2)

h0 = 1.54  # initial height h0 m at an initial speed v0
# at an angle theta0 above the horizontal.
# Calculate its landing point.
g = 9.81
# v01 = 10 # in meters per second
# th01 = 40 # in degrees

xdata = np.linspace(0.0, 100.0, 1001, endpoint=True)
fig, (ax1, ax2) = plt.subplots(nrows=1, ncols=2, figsize=(8, 4))
# axs[0].plot(x, y)
# axs[1].plot(x, -y)
colors = ['blue', 'green', 'red']

# -------------------------------------------------------------------------------
# (a) several curves with diﬀerent values of v0 for a ﬁxed value of θ0;

'''
Landing points.
(2.6, 0)
(8.09, 1.2)
(12.4, 2.2)
'''

i = 0
v01 = [4, 9, 11.2]  # Speeds.
th01 = 35  # Angles.
ax1.title.set_text('Trajectories with fixed angle of {}$^o$'.format(th01))
ax1.set_ylim([0, 10])
ax1.set_xlim([0, 15])
ax1.set_ylabel('Height ($m$)')
ax1.set_xlabel('Trajectory Range ($m$)')

# Redefine array of x-positions to make trajectories stop.
x1f1 = np.linspace(0.0, 2.8, 100)
x2f1 = np.linspace(0.0, 8.09, 100)
x3f1 = np.linspace(0.0, 10.6, 100)
xFinal1 = [x1f1, x2f1, x3f1]

while i < len(v01):
    # xFinal = np.linspace(0.0, 0, 1000)

    ydata1 = y(xFinal1[i], v01[i], th01)
    # Extend the window to see all the interactive options.
    ax1.plot(xFinal1[i],
             ydata1,
             linewidth=2.0,
             color=colors[i],
             label="{}$m/s$ $v0$".format(v01[i]))
    i += 1

# Ramp distance and angle.
d1 = 6  # m
d2 = 4  # m
slopeAngle = 30 * np.pi / 180.0 # In radians.

# Correct ground function.
def ground(x):
    if x < d1:
        # x = 0
        return 0
    # Return 1 thing. elif.
    elif d1 < x < d1 + d2:
        return (x - d1) * tan(slopeAngle)
    elif x > d1 + d2:
        return d2 * tan(slopeAngle)

ydataG = []
for x in xdata:
    ydataG.append(ground(x))

ax1.plot(xdata, ydataG, linewidth=4.0, color="black", label="Ground")

# Annotate the points.
x_position1 = [2.66, 8.14, 10.6]
y_position1 = [0.03, 1.3, 2.3]
ax1.plot(x_position1, y_position1, 'ko')

# Position the annotations.
x_annotate1 = [3.3, 9, 10.5]
y_annotate1 = [0.5, 1.5, 2.5]
x_label1 = ["R = 2.6", "R = 8.14", "R = 12.50"]

for z in range(0, 3):
    ax1.annotate(x_label1[z],
             xy=(x_annotate1[z], y_annotate1[z]),
             xycoords=('data'),
             xytext=(x_position1[z], y_position1[z]),
             textcoords='offset points',
             fontsize=10,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))

ax1.legend(loc="upper right")

# -------------------------------------------------------------------------------
# (b) several curves with diﬀerent values of θ0 for a ﬁxed value of v0.

'''
Landing points.
5.6, 0
7.3, 0.8
10.2, 2.3
'''

# Redefine array of x-positions to make trajectories stop.
x1f2 = np.linspace(0.0, 5.8, 100)
x2f2 = np.linspace(0.0, 7.5, 100)
x3f2 = np.linspace(0.0, 10.4, 100)
xFinal2 = [x1f2, x2f2, x3f2]

j = 0
v02 = 10.5  # Speeds.
th02 = [0, 15, 45]  # Angles.
ax2.title.set_text('Trajectories with fixed velocity of {}$m/s$'.format(v02))
ax2.set_ylim([0, 10])
ax2.set_xlim([0, 15])
ax2.set_ylabel('Height ($m$)')
ax2.set_xlabel('Trajectory Range ($m$)')
while j < len(th02):
    ydata2 = y(xFinal2[j], v02, th02[j])
    # Extend the window to see all the interactive options.
    ax2.plot(xFinal2[j],
             ydata2,
             linewidth=2.0,
             color=colors[j],
             label="{}$^o$".format(th02[j]))
    j += 1

# Ground.
ax2.plot(xdata, ydataG, linewidth=4.0, color="black", label="Ground")

# Annotate the points.
x_position2 = [5.7, 7.5, 10.3]
y_position2 = [0.03, 0.91, 2.32]
ax2.plot(x_position2, y_position2, 'ko')

# Position the annotations.
x_annotate2 = [7, 8.6, 10.3]
y_annotate2 = [0.1, 1.16, 2.5]
x_label2 = ["R = 5.6", "R = 7.3", "R = 10.1"]

for z in range(0, 3):
    ax2.annotate(x_label2[z],
             xy=(x_annotate2[z], y_annotate2[z]),
             xycoords=('data'),
             xytext=(x_position2[z], y_position2[z]),
             textcoords='offset points',
             fontsize=10,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))

ax2.legend(loc="upper right")

# -------------------------------------------------------------------------------

# Save figure to disk
plt.savefig("hw5_problem3.png", dpi=200)
plt.savefig("hw5_problem3.pdf", dpi=200)
# plt.savefig("1_basic_plotting.pdf",dpi=72)

# Show result on screen
plt.show()