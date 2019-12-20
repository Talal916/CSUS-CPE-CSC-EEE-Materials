#!/usr/bin/python3

# Problem 1

print("\n### Problem 1 ###########################")
print("#########################################")
print("\nFor n=10:")
print(sum([-(-1)**n/n for n in range(1,11)]))
print("\nFor n=100:")
print(sum([-(-1)**n/n for n in range(1,101)]))
print("\nFor n=1000:")
print(sum([-(-1)**n/n for n in range(1,1001)]))

# Problem 2

print("\n\n\n### Problem 2 ###########################")
print(    "#########################################")
import math   # very important! none of the commands below wil work without this command.

print("\n(a) (sin(pi/4))^2 = ", math.sin(math.pi/4)**2)
print("The sine of pi/4 is 1/sqrt(2) so if you square this, you get 1/2=0.5")
print("\n(b) ln(e) = ", math.log(math.e))
print("The log base x of x is always 1=1.0")
print("\n(c) ln(10) = ", math.log(10))
print("The exponent needed on e to get 10 is about 2.30")
print("\n(d) log(10) = ", math.log10(10))
print("Again, the log base x of x is always 1=1.0")
print("\n(e) |-5.4| = ", math.fabs(-5.4), " (using math.fabs) or ", abs(-5.4), " (using abs).")
print("Obvious.")
print("\n(f) sqrt(40) = ", math.sqrt(40), " (using math.sqrt) or ", 40**(1/2), " (using exponentiation).")
print("It will sometimes be useful to use exponents to perform a root.")

# Problem 3

print("\n\n\n### Problem 3 ###########################")
print(    "#########################################")
print("List of denominators is ",[2*i+1 for i in range(6)])
piov4 = math.pi/4
print("\npi/4 = ", piov4,"\n")

print("\nFor 5 terms:")
Sum = sum([(-1)**n/(2*n+1) for n in range(5)])
print("\tsum is ",Sum,"; difference from pi/4 is ",Sum-piov4)

print("\nFor 10 terms:")
Sum = sum([(-1)**n/(2*n+1) for n in range(11)])
print("\tsum is ",Sum,"; difference from pi/4 is ",Sum-piov4)

print("\nFor 20 terms:")
Sum = sum([(-1)**n/(2*n+1) for n in range(21)])
print("\tsum is ",Sum,"; difference from pi/4 is ",Sum-piov4)

print("\nFor 50 terms:")
Sum = sum([(-1)**n/(2*n+1) for n in range(51)])
print("\tsum is ",Sum,"; difference from pi/4 is ",Sum-piov4)

print("\nFor 100 terms:")
Sum = sum([(-1)**n/(2*n+1) for n in range(101)])
print("\tsum is ",Sum,"; difference from pi/4 is ",Sum-piov4)

print("\nFor 1000 terms:")
Sum = sum([(-1)**n/(2*n+1) for n in range(1001)])
print("\tsum is ",Sum,"; difference from pi/4 is ",Sum-piov4)

print("\nFor 10000 terms:")
Sum = sum([(-1)**n/(2*n+1) for n in range(10001)])
print("\tsum is ",Sum,"; difference from pi/4 is ",Sum-piov4)

print("\nFor 100000 terms:")
Sum = sum([(-1)**n/(2*n+1) for n in range(100001)])
print("\tsum is ",Sum,"; difference from pi/4 is ",Sum-piov4)

# Problem 4

print("\n\n\n### Problem 4 ###########################")
print(    "#########################################")
print("\n(a): By order of operations, the multiplication and division \n\tgo first and then the addition so 6+2=8:")
print(2*3+4/2)

print("\n(b): By order of operations, the exponentiation goes first \n\tand then the addition so 5-6+49=48")
print(5-6+7**2)

print("\n(c): Parentheses first and then, by order of operations, \n\tthe exponentiation goes next, and then the subtraction so 1-2**(2)=1-4=-3")
print(1-2**(8/4))

print("\n(d): Without any grouping symbols, the expression is simply \n\tinterpreted from left to right so 2/2=1")
print(8/4/2)

print("\n(e): Now with grouping symbols, the parentheses go first and \n\tthen the other division so 8/2=4")
print(8/(4/2))

print("\n(f): Again the grouping symbols go first and then each of the exponentiations. \n\tThe latter two cancel out so it's just 2**3=8")
print((4/2)**3-7**8+7**8)

print("\n(g): By default, python will upgrade the level of precision as necessary so 14/10=1.4.  \n\tNote that C++ will NOT work this way!")
print(14/10)

print("\n(h): Exponentiation first, then division, and then addition so 8+16/2=8+8=16")
print(8+2**4/2)
