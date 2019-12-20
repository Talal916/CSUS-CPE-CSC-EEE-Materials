#!/Library/Frameworks/Python.framework/Versions/3.7/bin/python3

# Problem 2 on Final Exam (2019)

import numpy.random as ran

mean = float(input("Mean value for data: "))
stdev = float(input("Standard deviation value for data: "))

numpoints = ran.randint(1, 10001)

data = ran.normal(mean, stdev, numpoints)

dataFile = open("dataFile.dat", 'w')
for d in data:
    dataFile.write(f"{d}\n")
dataFile.close()
