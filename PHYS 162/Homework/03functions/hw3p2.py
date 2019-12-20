# --------------------------------------------------------------
# HW03 - Functions
# --------------------------------------------------------------

import os
import sys
import array as arr

print("-------------------------------------------------------")
print("Problem 2\tFibonacci sequence\n")

# Inputs. Take 1st and 2nd value of the list.
n1 = int(input("Enter value of the 1st element of the list: "))
n2 = int(input("Enter value of the 2nd element of the list: "))
# Ask for how many elements to be added to the list.
N = int(input("Enter how many elements to be added to the list: "))

def NextElement(x, y):
    sum = x + y
    return sum

# Contains the 1st and 2nd element of the list.
list = [n1, n2]

def Add2List(list, N):
    if N >= 2:
        for i in range(N):
            s = len(list)
            list.append(NextElement(list[s-1], list[s-2]))
    else:
        print("Error: try again, list contains less than 2 elements.")

Add2List(list, N)
print("Fibonacci sequence: ", list)