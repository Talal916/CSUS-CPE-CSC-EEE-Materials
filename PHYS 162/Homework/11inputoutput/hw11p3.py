# -------------------------------------------------------------------------------
# Homework 11: Input, output
# --
# Write a C++ program that will create a data ﬁle containing pairs of values
# x f(x) in 2 columns for a function f(x) of your choice and for a ﬁnite range of
# values of x. Use a step for the x values that gives you a smooth curve.
# (Note that we don’t have the convenience of something line numpy.linspace here
# so you will have to write your own algorithm for creating the discretized
# values of x; try to do this without using a ﬂoating point index in your loop.)
#
# Import the data created into a Python script and use matplotlib to plot the
# function from it.
#
# Submit your source code and your Python script. Create the data ﬁle in the
# current working directory so it will run easily for me.
# -------------------------------------------------------------------------------

import numpy as np
import matplotlib.pyplot as plt

print("Problem 3 \t Graphing the 'outputData.dat file in Python\n")

# Create figure and subplot
plt.figure(figsize = (8, 6), dpi = 80)
# ax = plt.subplot(211) # Top sub graph.
ax = plt.subplot(111) # Full grid square graph.

# Title and axis labels
plt.title('Graph of "outputData.dat": $y = sqrt(x)$')
plt.xlabel(r'$x$')
plt.ylabel(r'$y$')

# Read in 'outputData.dat'.
outputDataX, outputDataY = np.loadtxt("outputData.dat", np.float64, usecols={0, 1}, unpack=True)

# plt.xlim(0, 10)
# plt.ylim(0, 100)

plt.plot(outputDataX, outputDataY)


# Show & export the graph.
plt.savefig("Problem 3 - Output.pdf", dpi = 72)
plt.show()


