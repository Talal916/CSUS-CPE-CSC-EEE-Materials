import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import brentq

print("Problem 1a\n")

def f(x):
    return 1.5 * x * np.cos(0.6 * x)

def g(x):
    return 2.2 + np.e**(x / 5)

def h(x):
    return f(x) - g(x)

# Create a new figure of size 8x6 points, using 80 dots per inch
plt.figure(figsize=(8,6), dpi=80)

# Create a new subplot from a grid of 1x1
plt.subplot(111)

# Generates data to be plotted
X = np.linspace(0.1, 20.0, 2560,endpoint=True) # only need positive values of x
Yf = f(X)
Yg = g(X)

plt.plot(X, Yf, color="blue", linewidth=1.0, linestyle="-")
plt.plot(X, Yg, color="red", linewidth=1.0, linestyle="-")

print("There are a finite number of solutions;\nfinding 2 positive solutions...")

Solutions = [brentq( h, 7.5, 10.0 ),
	brentq( h, 11.0, 12.5 )]

print(Solutions)

cnt = 0
for sol in Solutions:
	cnt += 1
	plt.annotate("%.2f"%(sol),
		xy=(sol, f(sol)),  xycoords='data',
        xytext=(30, 40*(-1)**cnt), textcoords='offset points', fontsize=16,
        arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.1"))
	print ("Solution %d: x = %.3f"%(cnt, sol))

    
# Export and show.
plt.savefig("p1a.pdf", dpi=72)
plt.show()


