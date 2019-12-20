#!/opt/local/bin/python

### Step 1 ###

m = 0.200 	# in kg, mass of the stone
L = 0.06 	# in m, size (diameter) of the stone
h0 = 1.54 	# in m, height from which stone is thrown
g = 9.80 	# in m/s^2, acceleration of gravity


### step 2 ###

import math

def xdist( v0, theta0 ):
	"Function to calculate the range over flat ground of an ideal projectile launched from a height of h0 (m) subjected to gravity that causes an acceleration g (m/s^2).  The initial speed (m/s) and launch angle (degrees) are specicified as input parameters."
	theta0rad = theta0 * math.pi / 180	# converts degrees to radians
	range = (v0**2/g * math.cos(theta0rad)**2 ) * (math.tan(theta0rad) + math.sqrt(math.tan(theta0rad)**2+(2*g*h0/(v0**2 * math.cos(theta0rad)**2))))
	return range


### step 3 ###
print("### Step 3 ###################\n")

combosToCheck = [[8,20],[8,55],[10,35],[10,60],[12,15],[12,45]] # in m/s and degrees

for combo in combosToCheck:
	v0 = combo[0]
	theta0 = combo[1]
	print("  For v0 = %.2f m/s and theta0 = %.2f degrees, the range is %.3f m\n" % (v0,theta0,xdist(v0,theta0)))


### Step 4 ###
print("\n\n### Step 4 ###################\n")

def xdist2( V0 ):
	"Function to calculate the range over flat ground of an ideal projectile launched from a height of h0 (m) subjected to gravity that causes an acceleration g (m/s^2).  The initial speed (m/s) and launch angle (degrees) are specicified as input parameters.  This function also prints useful information to the screen when called."
	( v0, theta0 ) = V0	# note the lowercase and capital in the 2 variables V0 and v0
	range = xdist(v0,theta0)
	print("  For v0 = %.2f m/s and theta0 = %.2f degrees, the range is %.3f m\n" % (v0,theta0,range))
	return range

xdist2((8,20))
xdist2((12,45))

### Step 5 ###
print("\n\n### Step 5: Exploration ###################\n")
# Assuming a baseball pitching speed of about 90 mph, this works out to around 40 m/s.  25% of that is 10 m/s so I'll pick that as my first "reasonable speed."

print("\nSweep 1 for 10 m/s")
sweep1For10 = [[10,theta] for theta in range(5,90,5)]

for combo in sweep1For10:
	v0 = combo[0]
	theta0 = combo[1]
	xdist2((v0,theta0))

# We have learned that the max range occurs between 35 and 45 degrees so we "zoom in" on that span

print("\nSweep 2 for 10 m/s")
sweep2For10 = [[10,theta] for theta in range(35,45,1)]

for combo in sweep2For10:
	v0 = combo[0]
	theta0 = combo[1]
	xdist2((v0,theta0))

# We could continue zooming in, but this is good enough.

print("\nFor v0 = 10 m/s, the maximum range occurs around 41 degrees.")

# What happens if we change v0 to, say, 6 m/s?

print("\nSweep 1 for 6 m/s")
sweep1For6 = [[6,theta] for theta in range(5,85,5)]

for combo in sweep1For6:
	v0 = combo[0]
	theta0 = combo[1]
	xdist2((v0,theta0))

# We have learned that the max range occurs between 30 and 40 degrees so we "zoom in" on that span

print("\nSweep 2 for 6 m/s")
sweep2For6 = [[6,theta] for theta in range(30,40,1)]

for combo in sweep2For6:
	v0 = combo[0]
	theta0 = combo[1]
	xdist2((v0,theta0))

# We could continue zooming in, but this is good enough.

print("\nFor v0 = 6 m/s, the maximum range occurs around 36 degrees.\n")
print("So yes, the angle of maximum range DOES depend on the launch speed.")


### Step 6 ###
print("\n\n### Step 6: Assumption 1 ###################\n")
# If the stone is a sphere, the bottom of the ball will touch ground first. When that happens, the stone's center will still be one radius above ground.
# We can take this into account by measuring the position of bottom of the stone instead of this center. Doing that, the initial height should be replaced by h0-R, where R=L/2 is the stone's radius.

v0 = 10  # m/s
theta0 = 40 # degrees
print("  For a point-size stone,\n\t")
xpoint = xdist2((v0,theta0))

print ("For a stone of radius %.2f m,\n\t" % (L/2))
h0 -= L/2
xsphere = xdist2((v0,theta0))

diff = xpoint - xsphere
print("The difference is %.3f m, or %.2f %%" % (diff, diff*100/xpoint))
print("\nThus it is probably reasonable to ignore the stone's size.")
