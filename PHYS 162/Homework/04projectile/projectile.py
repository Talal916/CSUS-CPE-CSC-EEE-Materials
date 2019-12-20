# ----------------------------------------------------------------
# HW04 - Projectile problem
# ----------------------------------------------------------------

import math
from math import pi
from math import radians
from math import degrees
from math import sin
from math import cos
from math import tan
from math import pow
from math import log
from math import log10 # log base 10.
from math import sqrt

# ----------------------------------------------------------------
# Step 1

# Constants.
g = 9.81 # m/s^2
m = 200 # 200g mass of stone.
L = 6     # cm is thrown from initial speed v0 at an 
h0 = 1.54 # initial height h0 m at an initial speed v0
          # at an angle theta0 above the horizontal.
          # Calculate its landing point.

# angle = degrees(pi / 2)
# print(angle)

# ----------------------------------------------------------------
# Step 2

print("\n-----------------------------------------------------------")
def xdist(v0, theta0):
    # Code Eq. 7 in the notes.
    # x = (v0^2*cos^2*theta0/g) * 
    # (tan*theta0) + sqrt(tan^2*theta0 + 2gh0/v0^2*cos^2*theta0))
    if v0 == 0:
        return 0
    
    theta0 = radians(theta0)
    part1 = ((v0**2 * cos(theta0)**2)/ (g))
    part2 = ( (tan(theta0)) + sqrt( (tan(theta0)**2) + (2*g*h0)/(v0**2 * cos(theta0)**2)   ))
    range = part1 * part2
    return range # Horizontal distance to the landing point.

# ----------------------------------------------------------------
# Step 3

v0 = [8.00, 9.00, 20.9, 30.9, 42.94, 46.94] # Speeds.
theta0 = [20.9, 30, 40, 42, 43, 45] # Angles.

maxSpeed = [46.94] # Max speed of a baseball to m/s^2.
minSpeed = [20.9]
angleRange = [i for i in range(1,90)]
# print(angleRange)

# Iterate through v0 and theta0 combinations.
print("Evaluate "'"xdist"'" for at least 6 different combinations of values of v0 and theta0:\n")
i = 0
while i < len(v0):
    print("For v0 = {:.2f} m/s and theta0 = {:.1f} degrees, the range is {:.2f} m."
          .format(v0[i], theta0[i], xdist(v0[i], theta0[i]) ))
    i += 1
    
'''
for i in range(0, 6):
    print("For v0 = {:.2f} m/s and theta0 = {:.1f} degrees, the range is: {:.2f}".format(v0[i], theta0[i], xdist(v0[i], theta0[j]) ))
'''

# ----------------------------------------------------------------
# Step 4

print("\n-----------------------------------------------------------")
print(""'"xdist2"'" output:\n")

# "range0" is the range of v0 and theta0.
# "range1" is the range of v1 and theta0.
 
print("v0 (m/s) \t v1 (m/s) \t theta0 \t range0 (m) \t range1 (m)")
def xdist2(tuple):
    # print("For v0 = {:.2f} m/s and theta0 = {:.1f} degrees, the range is {:.2f} m.".format(tup[0], tup[2], xdist(tup[0], tup[2])))
    # print("For v0 = {:.2f} m/s and theta0 = {:.1f} degrees, the range is {:.2f} m.".format(tup[1], tup[2], xdist(tup[1], tup[2])))

    print("{:.2f} \t\t {:.2f} \t\t {:.1f} \t\t {:.2f} \t\t {:.2f}"
          .format(tuple[0], tuple[1], tuple[2], xdist(tuple[0], tuple[2]), xdist(tuple[1], tuple[2])))
    return tuple

j = 0
tuples = []
while j < len(angleRange):
    tuples.append((minSpeed[0], maxSpeed[0], angleRange[j]))
    j += 1

for tuple in tuples:
    xdist2(tuple)

# ----------------------------------------------------------------
# Step 5: Exploration

print("\n-----------------------------------------------------------")
print("Exploration: Choose a reasonable value for the initial\n"
      "speed v0 of the stone. What is reasonable?")

print("\nThe fastest speeds for a baseball throw is 95 - 105 mph.\n" 
      "I will pick the min (95) and max (105). 95 mph is 42.47 m/s\n"
      "and 105 mph is 46.94 m/s.\n")

print("When the speed was 46.94 m/s, the range was the farthest\n"
      "when, it was 45 degrees. For this initial speed, 45\n"
      "degrees was the angle to maximize that range.\n")

print("However, when the initial speed was 20.9 m/s the farthest range\n"
      "was reached when it was 44 degrees. Therefore, 45 degrees doesn't\n"
      "necessarily mean it will always travel the farthest.\n")

# ----------------------------------------------------------------
# Step 6: Assumption 1

print("-----------------------------------------------------------")
print("Assumption 1")
print("How does the answer change if we take this finite size in account?\n")

print("A sphere of diameter L = {}.\n"
      "The radius of L = {}.\n".format(L, (L/2)))

print("Initial speed: 46.94 m/s\n"
      "Angle: 45 degrees\n")

# Get time flight for the projectile:
# t = 2*vi*sin(theta)/g
# t = 2*46.94 m/s * sin(45 degrees) / 9.81 = 6.76688936s
# Vx = Vi * cos(45 degees) = 46.94 * cos(45 degrees) = 33.19ms^-1
# x-range = Vx * t = 33.19 * 6.76688936 = 224.5930m

print("If we take this finite size into account, maybe we can state that\n"
      "the range may vary. The center of the sphere may land directly\n"
      "on the mark, or may go over the range. Therefore, should the initial\n"
      "height be the center, the new initial height would be 1.51m. This is\n"
      "result from subtracting the radius of the sphere with the initial\n"
      "height "'"L"'".\n")

