import sys
import time
import datetime
from datetime import date

print("-------------------------------------------------------")
print("Problem 2\n")
# Write a Python script that takes a single word as a command 
# line argument and then prints the current day’s date on a 
# ﬁrst line as MM/DD/YYYY, followed by 
# The word you entered is "<word>". on a second line, where 
# <word> is the provided word within quotation marks. Use the 
# sys module and use an if statement to have the script check 
# that the correct number of command line arguments (one) is 
# provided; if not, print a message to the user and exit cleanly.

sys.argv[1] = print("The arguments were:", sys.argv[1:])
now = datetime.date.today().strftime('%m/%d/%Y')

if (len(sys.argv) == 2):
    print("Today's date is {}.\n".format(now))
    sys.argv[1]
else:
    sys.exit("Error: enter 1 argument only.\n")
    
