#!/usr/bin/python
# Solution to Problem 1 of HW02

# First method: for loop
listA = []
for i in range(10):
    listA.append(20+2*i+1)

print("Solution from method (a):")
print(listA)
print()

# Second method: list comprehension
listB = [(20+2*i+1) for i in range(10)]
print("Solution from method (b):")
print(listB)
