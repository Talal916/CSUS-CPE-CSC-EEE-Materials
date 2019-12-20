#!/opt/local/bin/python
# Solution for Problem 2 on Midterm 1 - Fall 2019

import os
import sys

if(len(sys.argv)!=2):
	sys.exit('You must enter a directory name as a single command-line argument.')
else:
	dirname = sys.argv[1]

os.mkdir(dirname)
