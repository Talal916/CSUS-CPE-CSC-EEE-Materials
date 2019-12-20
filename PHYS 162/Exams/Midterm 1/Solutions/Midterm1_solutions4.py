#!/opt/local/bin/python
# Solution for Problem 4 on Midterm 1 - Fall 2016

import numpy as np
import matplotlib.pyplot as plt

filename = "exp_data.dat"

plt.figure(figsize=(8,5), dpi=80)
ax = plt.subplot(111)

plt.title(r'$y_1,y_2$ vs. $x$')
plt.xlabel(r'$x$',size=14)
plt.ylabel(r'$y_1,y_2$',size=14)

X, Y1 = np.loadtxt(filename,unpack=True)
Y2 = ((X+20)**1.1/500)*(9*np.cos(X/200)**2+1)

#ax.spines['right'].set_color('none')
#ax.spines['top'].set_color('none')
#ax.xaxis.set_ticks_position('bottom')
#ax.spines['bottom'].set_position(('data',0))
#ax.yaxis.set_ticks_position('left')
#ax.spines['left'].set_position(('data',0))

plt.plot(X, Y1, color="blue", linewidth=1.0, linestyle="-",
         label=r'experimental data ($y_1(x)$)')

plt.plot(X, Y2, color="red", linewidth=1.0, linestyle="-",
         label=r'$y_2(x)=\frac{(x+20)^{1.1}}{500}\left[9\,\cos^2\left(\frac{x}{200}\right)+1\right]$')

xmin = X.min()
xmax = X.max()
xrange = xmax - xmin
ymin = Y1.min()
ymax = Y1.max()
yrange = ymax - ymin
margin = 0.1

plt.xlim(xmin - margin * xrange, xmax + margin * xrange)

plt.ylim(ymin - margin * yrange, ymax + margin * yrange)

# Adds legend
plt.legend(bbox_to_anchor=(0.55,0.1),loc='lower left', frameon=True, prop={'size': 10})

x1 = 196.0
y1 = 2.80
x2 = 402
y2 = 4.03
plt.scatter([x1,x2],[y1,y2],30,color ='black',zorder=100)

plt.annotate('(%d, %.2f)'%(x1,y1),
             xy=(x1, y1),  xycoords='data',
             xytext=(+20, -20), textcoords='offset points', fontsize=12,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))

plt.annotate('(%d, %.2f)'%(x2,y2),
             xy=(x2, y2),  xycoords='data',
             xytext=(+20, -20), textcoords='offset points', fontsize=12,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))

plt.savefig("prob4.pdf",dpi=72)

plt.show()
