import math
from math import pi
from math import sin
from math import pow
from math import log
from math import log10 # log base 10.
from math import sqrt
from math import e

print("-------------------------------------------------------")
print("Problem 3\n")
# Use the format string method to write the following:

print("(a) The value of pi with 4 digits after the decimal point:")
print("\t{:.4f}\n".format(pi))

# -------------------------------------------------------------

print("(b) The value of 100pi^2 with 10 digits after the decimal point:")
print("\t{:.10f}\n".format(100*pi**2))

# -------------------------------------------------------------

# Pulling elements out individually.
print("(c) Using a single print command, the value of π with 6 digits\n", 
      "after the decimal point on one line, then the same value\n",
      "with 20 digits on a second line; make sure you only\n",
      "provide the value of π once!")
print("\t{:.6f}\n\t{:.20f}\n".format(pi, pi))

# -------------------------------------------------------------

print("(d) Set the variables x = e^3 and y = sin(π/3), then print the\n", 
      "values of x and y each with 3 digits after the decimal\n", 
      "point, followed by x · y in scientiﬁc notation with 4\n", 
      "signiﬁcant ﬁgures.")
x = e**3
y = sin(pi/3)
print("\t{:.3f}\n\t{:.3f}\n".format(x, y))
print("\t{:.4f}\n".format(x*y))

# -------------------------------------------------------------

print("(e) Define the list [1, 5, 10], then print it in reverse order\n",
      "with each number printed with 3 digits, preceded by zeros (0)\n",
      "as needed. Try to provide the list variable to format\n",
      "(as opposed to each element separately).")
# Note: do not use reverse() function call.
lst = [1, 5, 10]
# Using python's slice notation to reverse the list.
rev_list = lst[::-1]
print("\t", rev_list)

print("\t [{0:03}, {1:03}, {2:03}]".format(rev_list[0], rev_list[1], rev_list[2]))