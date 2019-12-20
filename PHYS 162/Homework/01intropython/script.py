import sys

platform = sys.platform
print("your computer runs on a",platform, "computer\n")
print("The script name is",sys.argv[0],"\n")
print("The arguments were: ",sys.argv[1:],"\n")

if(len(sys.argv)>=2):
	check = int(sys.argv[1])
else:
	check = 0

if(check==4):
	sys.exit('Check was equal to 4.  Exiting...\n')