# ------------------------------------------------------------
# Homework 1: Introduction to Python
# --
# For the following exercises, write your code in one or more
# text ﬁle(s) ending with extension .py. Be sure to use a
# plain text editor (i.e., NOT Word). For parts that require
# written explanation, use the print() function to print your
# answers to the screen when the script is run.
#
# Note that unlike with using the Python interpreter, commands
# will not print out to the screen automatically when run
# through a scripting ﬁle. Wrap each command you’d like to
# print to the screen in the function print() or save the
# command’s output to a variable and then print the variable.
# ------------------------------------------------------------

import math
from math import pi
from math import sin
from math import pow
from math import log
from math import log10 # log base 10.
from math import sqrt

print("-------------------------------------------------------")
print("Problem 1\n")
# Use the sum command described in the lecture notes to ﬁnd the
# result for the sum of 1 − 1/2 + 1/3 − 1/4 + 1/5 − 1/6 + . . .
# for several numbers of terms (say 10, 100, 1000).
# (Hint: read up on the range function online and see how to
# make it start at 1 instead of 0.)

# Ans: sum = 0.61666666666 for 6 terms.
list1 = [1 / i for i in range(1, 11)]  # 10 terms.
print("List:", list1)

print("Sum of the list:", sum(list1[::2]) - sum(list1[1::2]), "\n")
# List splitting.
# 1st part adds ahead 2 places each time.
# 2nd part subtracts 1st index and 2nd index.

print("-------------------------------------------------------")
print("Problem 2\n")
# Find the online documentation on the Python math module to
# familiarize yourself with the functions used in the problem.
# Evaluate each of the following using commands from the math y
# module and explain their output:

solution2A = pow(sin(pi / 4), 2)
print("(a) the square of the sine of pi/4 =", solution2A)
print("The output is in radians and the actual solution is 0.5.\n"
      "Python returned a float number.\n")

solution2B = log(math.e)
print("(b) the natural logarithm of e, the base for natural logarithms =", int(solution2B))
print("I used 'math.e' to get 'e'. The natural log(e) solution is 1.\n")

solution2C = log(10)
print("(c) the natural logarithm of 10 =", solution2C)
print("I used 'math.e' to get 'e'. The natural log(e) solution is 1.\n")

solution2D = log10(10)
proof = log10(11)
print("(d) the base 10 logarithm of 10 =", solution2D)
print("The output is correct because the base 10 logarithm of 11 is", proof, "\n")

solution2E = abs(-5.4)
print("(e) the absolute value of -5.4 =", solution2E)
print("The absolute value of a negative number is always positive.\n")

solution2F = sqrt(40)
print("(f) the square root of 40 =", solution2F)
print("Prime factorization of 40 = 2^3 * 5. By applying the exponent rule and radical rule,\n"
      "we get 2sqrt(10). The sqrt(10) is 3.162277... 2 * 3.1622... = 6.32\n")

print("-------------------------------------------------------")
print("Problem 3\n")
# Verify that the following inﬁnite series equals π/4:
#   1 - 1/3 + 1/5 - 1/7 + ...
# First, ﬁgure out how to represent the pattern using an index n. 
# Then we can generate the list of terms as in the notes. 
# Obviously, we can’t really take n to inﬁnity with this series 
# so try letting it go for some large values of n.
# Note that to complete the problem, you need to compare the 
# answer for increasing numbers of terms in the sum to π/4 and 
# show that the diﬀerence gets smaller.

proof = 0.0
problem = (pi/4)

print("pi/4 =", problem)
for n in range(1, 100000):
    proof += pow(-1,(n-1)) * (1/float(2*n-1))
print("The series =", proof)
print("As you can see, as we increase 'n' the series approaches closer to pi/4.\n")

print("-------------------------------------------------------")
print("Problem 4\n")
# For this problem, try to ﬁgure out the answer before executing 
# the command. You must explain your reasoning (using a print 
# command) for full credit!
# Use the precedence and arithmetic rules of Python to predict 
# the values of each of the following expressions:

solution4A = (2*3 + 4/2)
print("(a) 2*3 + 4/2 =", solution4A)
print("2*3 = 6 and 4/2 = 2. Then 6 + 2 is 8.\n")

solution4B = (5 - 6 + 7**2)
print("(b) 5 - 6 + 7**2 =", solution4B)
print("7^2 is 49. Add and subtract (left to right) = 48.\n")

solution4C = (1 - 2 ** (8/4))
print("(c) 1 - 2 ** (8/4) =", solution4C)
print("Do powers first. 2 ** (8/4) is 2^2. 2^2 = 4. 1 - 4 = -3.\n")

solution4D = (8 / 4 / 2)
print("(d) 8 / 4 / 2 =", solution4D)
print("Divide left to right. 8/4 = 2. 2/2 = 1.\n")

solution4E = (8 / (4/2))
print("(e) 8 / (4/2) =", solution4E)
print("Parentheses first. 4/2 = 2. 8/2 is 4.\n")

solution4F = ((4/2)**3 - 7**8 + 7**8)
print("(f) (4/2)**3 - 7**8 + 7**8 =", solution4F)
print("(4/2)**3 = 8. 7^8 = 5764801. Add and subtract (left to right)\n"
      "8 - 5764801 + 5764801 = 8.\n")

solution4G = (14/10)
print("(g) 14/10 =", solution4G)
print("Divide 14 by 10. 14/10 is 1(4/10) in mixed number. 4/10 = .40. Add 1 = 1.40\n")

solution4H = (8 + 2 ** 4 / 2)
print("(h) 8 + 2 ** 4 / 2 =", solution4H)
print("Exponent in the middle. '8 + (2^4) / 2'. 2^4 = 16. 16/2 = 8. 8 + 8 = 16.\n")
print("-------------------------------------------------------")