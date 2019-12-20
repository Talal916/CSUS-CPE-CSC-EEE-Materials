#!/opt/local/bin/python

# Solving linear systems of equations using numpy.linalg.solve

import numpy as np
from numpy.linalg import solve

a = np.array([ [11,-1,-3] , [-4,0,9] , [2,5,-15] ])
b = np.array([-1,8,7])
sol = solve(a,b)
print("a = %.3f\nb = %.3f\nc = %.3f"%(sol[0],sol[1],sol[2]))
