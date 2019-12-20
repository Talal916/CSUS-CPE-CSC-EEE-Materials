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

print("Problem 2 \t Projectile motion with flat ground")
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


def xdist(v0, th0):
    # Code Eq. 7 in the notes.
    # x = (v0^2*cos^2*theta0/g) *
    # (tan*theta0) + sqrt(tan^2*theta0 + 2gh0/v0^2*cos^2*theta0))
    if v0 == 0:
        return 0

    th0 = radians(th0)
    part1 = ((v0**2 * cos(th0)**2) / (g))
    part2 = ((tan(th0)) + sqrt((tan(th0)**2) + (2 * g * h0) /
                               (v0**2 * cos(th0)**2)))
    range = part1 * part2
    return range  # Horizontal distance to the landing point.


h0 = 1.54  # initial height h0 m at an initial speed v0
# at an angle theta0 above the horizontal.
# Calculate its landing point.
g = 9.81
# v01 = 10 # in meters per second
# th01 = 40 # in degrees

xdata = np.linspace(0.0, 100.0, 1001, endpoint=True)
fig, (ax1, ax2) = plt.subplots(nrows=1, ncols=2, figsize=(10, 6))
# axs[0].plot(x, y)
# axs[1].plot(x, -y)
colors = ['blue', 'green', 'purple']

# -------------------------------------------------------------------------------
# (a) several curves with diﬀerent values of v0 for a ﬁxed value of θ0;

i = 0
v01 = [10, 20, 30]  # Speeds.
th01 = 35  # Angles.
ax1.title.set_text('Trajectories of a fixed angle of {}$^o$'.format(th01))
ax1.set_ylim([0, 20])
ax1.set_xlim([0, 100])
ax1.set_ylabel('Height ($m$)')
ax1.set_xlabel('Trajectory Range ($m$)')
while i < len(v01):
    ydata1 = y(xdata, v01[i], th01)
    # Extend the window to see all the interactive options.
    ax1.plot(xdata,
             ydata1,
             linewidth=2.0,
             color=colors[i],
             label="{:.2f}$m$ range | {}$m/s$ v0".format(
                 xdist(v01[i], th01), v01[i]))
    i += 1

ax1.axhline(y=0.0, color='black', linestyle='-', linewidth=4.0, label='Ground')

ax1.legend(loc="upper right")

# -------------------------------------------------------------------------------
# (b) several curves with diﬀerent values of θ0 for a ﬁxed value of v0.

j = 0
v02 = 20  # Speeds.
th02 = [20, 30, 40]  # Angles.
ax2.title.set_text('Trajectories of a fixed velocity of {}$m/s$'.format(v02))
ax2.set_ylim([0, 13])
ax2.set_xlim([0, 50])
ax2.set_ylabel('Height ($m$)')
ax2.set_xlabel('Trajectory Range ($m$)')
while j < len(th02):
    ydata2 = y(xdata, v02, th02[j])
    # Extend the window to see all the interactive options.
    ax2.plot(xdata,
             ydata2,
             linewidth=2.0,
             color=colors[j],
             label="{:.2f}$m$ range | {}$^o$".format(xdist(v02, th02[j]),
                                                     th02[j]))
    j += 1

ax2.axhline(y=0.0, color='black', linestyle='-', linewidth=4.0, label='Ground')

ax2.legend(loc="upper right")

# Save figure to disk
plt.savefig("hw5_problem2.png", dpi=500)
# plt.savefig("1_basic_plotting.pdf",dpi=72)

# Show result on screen
plt.show()