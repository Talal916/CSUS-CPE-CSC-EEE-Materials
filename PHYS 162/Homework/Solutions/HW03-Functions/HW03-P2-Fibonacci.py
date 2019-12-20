#!python 3

def nextElem(x, y):
#   "Returns the sum of the 2 arguments"
   return x+y
   
def Add2List(list, N):
#  "Adds N elements to the provided list using Fibonacci rule
#   (List must have at least 2 to start the series)"
   if (len(list) < 2):
      print ("Error: provided list must have at least 2 elements!")
      return
   for i in range(N):
     list.append(nextElem(list[-2], list[-1]))
   return

list = []
list.append(int(input("Enter an integer number: ")))
list.append(int(input("Enter a second integer number: ")))

N = int(input("How many elements do you want to add to the list? "))
Add2List(list, N)

print("\nYour Fibonacci list is:", list)

