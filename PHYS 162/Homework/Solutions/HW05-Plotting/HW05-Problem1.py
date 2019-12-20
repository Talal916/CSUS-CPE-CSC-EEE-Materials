#!python3
# Problem 1 on Matplotlib-I HW

import numpy as np
import matplotlib.pyplot as plt

# set up domain variables
xmin = 0.1
xmax = 20.
xrange = xmax - xmin

# set discretization step
dx = 0.1

# calculate number of points needed (standard formula; take note of it)
numpoints = int(xrange/dx+0.0001) + 1 # adding a small number to make sure we're not slightly lower than integer when applying int

# Generate x values
xdata = np.linspace(xmin,xmax,numpoints)

# I don't really have a favorite function, ...
ydata1 = 2.5*np.exp(-0.5*((xdata-8.0)/5.0)**2)
ydata2 = np.log(xdata) # note that np.log is the natural logarithm

# Calculate y range for each function
ymin1 = np.min(ydata1)	# find minimum value
ymax1 = np.max(ydata1)	# find maximum value
yrange1 = ymax1 - ymin1

ymin2 = np.min(ydata2)	# find minimum value
ymax2 = np.max(ydata2)	# find maximum value
yrange2 = ymax2 - ymin2





# set figure size and resolution
plt.figure(figsize=(8,6), dpi=80)



# select top subplot
top=plt.subplot(2,1,1)

# set title
plt.title('A Couple of Cool Functions',fontsize=24,color='blue',position=(0.5,1.05))

# Plot the data 1
gausl, = top.plot(xdata, ydata1, color='red', linewidth=2.5, linestyle="-", label='Gaussian')
#gausl, = ... saves the line for later use in the legend.

# Set the axis labels for top subplot
plt.xlabel(r'$x$',fontsize=16,labelpad=-5)
plt.ylabel(r'Gaussian',fontsize=14,color='blue',y=0.5)

# Set tick mark locations and labels (addition of special labels is in notes 5)
plt.xticks(range(0,21,4))
plt.yticks(np.linspace(0,3,4))


# Set the axis limits with a bit of a margin
margin = 0.05
plt.xlim(xmin - xrange * margin, xmax + xrange * margin)
plt.ylim(ymin1 - yrange1 * margin, ymax1 + yrange1 * margin)

# sets up an inset plot
plt.axes([0.3,0.6,0.25,0.15])
plt.xticks([])
plt.yticks([])
cosl, = plt.plot(xdata, np.cos(xdata)**2, color='orange', lw=1.5, ls="dashed", label=r'$\cos^2(x)')
#plt.title(r'$\cos^2(x)$')
plt.xlabel('a.u.')
plt.ylabel('a.u.')

# Turn on legend for both top subplot and inset curves
top.legend([gausl,cosl],["Gaussian","Cosine squared"], loc='upper right',frameon=False)


# Select bottom subplot
ax = plt.subplot(2,1,2)
# Plot the data 2

plt.plot(xdata,ydata2,color='blue', lw=2.0, ls=":", label=r'$\ln(x)$')

# Set the axis labels
plt.xlabel(r'$x$',fontsize=16,labelpad=-5)
plt.ylabel(r'Natural logarithm',fontsize=14,color='red',y=0.5,x=-0.3)

# Set the axis limits with a bit of a margin
margin = 0.1
plt.xlim(xmin - xrange * margin, xmax + xrange * margin)
plt.ylim(ymin2 - yrange2 * margin, ymax2 + yrange2 * margin)
#ax.set_xlim(xmin - xrange * margin, xmax + xrange * margin)
#ax.set_ylim(ymin2 - yrange2 * margin, ymax2 + yrange2 * margin)

# Set tick mark locations and labels (addition of special labels is in notes 5)
plt.xticks([np.exp(i) for i in range(4)],
           [r'$e^{0}=1$',r'$e^1$',r'$e^2$',r'$e^3$'])
plt.yticks(np.linspace(-2,3,6,endpoint=True))

# Turn on legend
plt.legend(loc='lower right',frameon=True)


# The rest of this I did not expect you to do.  It comes from the intermediate and advanced material for matplotlib (Lecture Notes 05).
# Remove unneeded axes
ax.spines['top'].set_color('none')
ax.spines['right'].set_color('none')
ax.xaxis.set_ticks_position('bottom')
ax.yaxis.set_ticks_position('left')

# Makes other axes intersect at the origin
ax.spines['bottom'].set_position(('data',0))
ax.spines['left'].set_position(('data',0))

# Clarify one of the tick labels
label = ax.get_xticklabels()[0]
label.set_bbox(dict(facecolor='white', edgecolor='None', alpha=0.65 ))

# Annotate a special point
x = np.exp(1)
plt.scatter([x,],[np.log(x),],50,color='black',zorder=20)
plt.annotate(r'$\ln(e)=1$',
             xy=(x, np.log(x)),  xycoords='data',
             xytext=(50, -20), textcoords='offset points', fontsize=16,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))


# Save figure to file
plt.savefig("prob1.pdf",dpi=72)

# Display figure
plt.show()
