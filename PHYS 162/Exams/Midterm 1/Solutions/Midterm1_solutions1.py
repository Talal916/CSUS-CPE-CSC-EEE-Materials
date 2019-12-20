#!/opt/local/bin/python
# Solution for Problem 1 on Midterm 1 - Fall 2019
import math

print("####### Part (a) #######")
nums = [i for i in range(38,149,2)]

print(sum(nums))

file = open("results.dat","w")
for i in range(8,13):
	for j in range(2,7):
		file.write("{:4d} {:4d} {:8.4f}\n".format(i,j,math.e**((3*i-4*j)/20)))
file.close()
