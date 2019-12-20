print("-------------------------------------------------------")
print("Problem 1\n")
# Our goal is to generate a list of the ﬁrst 10 odd integers 
# larger than 20. Do this using each of the following methods:
#    (a) a for loop combined with the append function
#    (b) list comprehension and the range function
# For each case, print out the list when it’s complete.

list1A = []
for i in range(20, 40):
    if i % 2 == 1: # If modulus of i equals 1. Number is odd.    
        list1A.append(i)
print("(a) a for loop combined with the append function")
print("\t", list1A, "\n") # New list with odd numbers.

# Put function in brackets with a pattern to follow.
list1B = [i for i in range(20, 40)]
odd1B = [i for i in list1B if i % 2 == 1]

print("(b) list comprehension and the range function")
print("\t", odd1B, "\n") # Odd comprehension list.