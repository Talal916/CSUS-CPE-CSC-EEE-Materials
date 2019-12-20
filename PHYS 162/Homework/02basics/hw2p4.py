import os
from os import makedirs

print("-------------------------------------------------------")
print("Problem 4\n")
# Write a Python script that will create the following directory
# structure in the local folder:
# A   B   C
#  1   1   1
#  2   2   2
#  3   3   3
#  4   4   4

# Check last module in lecture notes. 

dirMain = ['A', 'B', 'C'] # Main directories.
dirSub = ['1', '2', '3', '4'] # Sub directories.

for i in range (0, 3): # There are 3 main directories.
    path = dirMain[i]
    if not os.path.exists(path):
        os.mkdir(path)
        
    for j in range(0, 4): # There are 4 sub directories.
        path = dirMain[i] + "/" + dirSub[j]
        if not os.path.exists(path):
            os.mkdir(path)
            
            # Create "info.txt" in each sub directory.
            f = open(dirMain[i] + "/" + dirSub[j] + "/info.txt", "w+")

            # Write statement inside the contents of info.txt.
            f.write("This file is in folder " + dirMain[i] + "/" + dirSub[j] + ".")
            # f.write("This file is in folder {0}/{1}.".format(dirMain[i], dirSub[i]))

print("Usage: directories created, check current path where "'"problem4.py"'" is located.\n")