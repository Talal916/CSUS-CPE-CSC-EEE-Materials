#!/usr/bin/python
# Solution to Problem 4 of HW02





import os

dirList1 = ['A','B','C']
dirList2 = ['1','2','3','4']
filename = "info.txt"

for dir1 in dirList1:
    os.system("mkdir {:s}".format(dir1))
    for dir2 in dirList2:
        os.system("mkdir {:s}{:s}{:s}".format(dir1,os.sep,dir2))
        file = open("{1:s}{0:s}{2:s}{0:s}{3:s}".format(os.sep,dir1,dir2,filename),'w')
        file.write("This file is in folder {:s}/{:s}.".format(dir1,dir2))
        file.close()
