# -------------------------------------------------------------------------
# Homework 12: Derivatives, integrals
# -------------------------------------------------------------------------

#
# Use Python to read in the ﬁle you created and matplotlib to make a plot 
# of the numerical derivative vs. step size Δx. Play around with your 
# choices of x and Δx so that you can see all three regimes:
#
#     (i) Δx is too large and so the derivative is poorly converged,
#     (ii) Δx is in the “sweet zone” giving you a good approximation of the 
#          actual derivative,
#     (iii) Δx is so small that precision errors are occurring and your 
#           program is spitting out garbage.
#
# I want to see all three of these regimes in your plot, which should be 
# similar  to Figure 1 in the notes (you don’t need to include the inset). 
# Note that to  see what’s going on at small Δx better, you might want to 
# use a logarithmic scale for the horizontal axis.
#

import numpy as np
import matplotlib.pyplot as plt

# Header.
print("Problem 1 \t Graphing the 'derivativeData.dat file in Python\n")
#

fig = plt.figure(figsize=(8, 6))
ax = fig.add_subplot(111) # The big subplot.
ax1 = fig.add_subplot(221)
ax2 = fig.add_subplot(222)
ax3 = fig.add_subplot(223)
ax4 = fig.add_subplot(224)

fig.suptitle('Numerical Derivative vs. Step Size of $f(x) = x^4−2x^3+5x−1$')
ax1.set_xscale('log')
ax2.set_xscale('log')
ax3.set_xscale('log')
ax4.set_xscale('log')

# Turn off axis lines and ticks of the big subplot
ax.spines['top'].set_color('none')
ax.spines['bottom'].set_color('none')
ax.spines['left'].set_color('none')
ax.spines['right'].set_color('none')
ax.tick_params(labelcolor='w', top='off', bottom='off', left='off', right='off')

# Read in 'derivativeData.dat'.
outputDataX, outputDataY = np.loadtxt("derivativeData.dat", np.float64, usecols={0, 1}, unpack=True)

# ---------------------------------------------------------------------------
#     (i) Δx is too large and so the derivative is poorly converged,
# Enter a value for x: 3
# Enter a starting value of Δx: 5

poorDataX, poorDataY = np.loadtxt("poorData.dat", np.float64, usecols={0, 1}, unpack=True)

# ---------------------------------------------------------------------------
#     (ii) Δx is in the “sweet zone” giving you a good approximation of the 
#          actual derivative,
# Enter a value for x: 3
# Enter a starting value of Δx: 0.25

sweetDataX, sweetDataY = np.loadtxt("sweetData.dat", np.float64, usecols={0, 1}, unpack=True)
 
# ---------------------------------------------------------------------------
#     (iii) Δx is so small that precision errors are occurring and your 
#           program is spitting out garbage.
# Enter a value for x: 3
# Enter a starting value of Δx: 0.00001

garbageDataX, garbageDataY = np.loadtxt("garbageData.dat", np.float64, usecols={0, 1}, unpack=True)

# plt.xlim(0, 10)
# plt.ylim(20, 100)

# Set common labels
ax.set_xlabel(r'$Δx$')
ax.set_ylabel(r'$(\frac{df}{dx})$forward')

l, = ax1.plot(outputDataX, outputDataY, label="User created", linewidth="0.9")
l2, = ax2.plot(poorDataX, poorDataY, color='orange', label="$Δx$ too large", linewidth="0.8")
l3, = ax3.plot(sweetDataX, sweetDataY, color='green', label="$Δx$ 'sweet zone'", linewidth="0.8")
l4, = ax4.plot(garbageDataX, garbageDataY,  color='red', label="$Δx$ too small", linewidth="0.8")

plt.legend(handles=[l, l2, l3, l4], loc="upper center", bbox_to_anchor=[-0.10, 2.40],
           ncol=4, shadow=True, fancybox=True)

# Show & export the graph.
plt.savefig("Problem 1 - Output.pdf", dpi = 72)
plt.show()