# ------------------------------------------------------------
# Midterm 1
# ------------------------------------------------------------

import math
import os
import sys
from math import pi
from math import sin
from math import pow
from math import log
from math import log10 # log base 10.
from math import sqrt

print("Problem 2:\n")

# User runs the script with:
#   python3 p2.py word
# word creates a directory called "word".

if(len(sys.argv)!=2):
    print("Error: you must provide exactly one argument on the command line to create the directory.")
    sys.exit("Exiting...")
else:
    word = sys.argv[1]
    dirName = word

os.system("mkdir {:s}".format(dirName))

