#import socket module
from socket import *
import sys # In order to terminate the program
serverPort = 12015
serverSocket = socket(AF_INET, SOCK_STREAM)
#Prepare a sever socket
serverSocket.bind(('',serverPort))
serverSocket.listen(1)

print('The server is ready to listen')

#Fill in start
#Fill in end
while True:
     #Establish the connection
     print('Ready to serve...')
     connectionSocket, addr = serverSocket.accept()#Fill in start #Fill in end
     try:
         message = connectionSocket.recv(1024) #Fill in start #Fill in end
         filename = message.split()[1]
         f = open(filename[1:])
         outputdata = f.read() #Fill in start #Fill in end
         #Send one HTTP header line into socket
         httpHeader= '\nHTTP/1.1 200 OK\r\n'
         connectionSocket.send(httpHeader.encode())
         #Fill in start
         #Fill in end
         #Send the content of the requested file to the client
         for i in range(0, len(outputdata)):
             connectionSocket.send(outputdata[i].encode())

         connectionSocket.send("\r\n".encode())

         connectionSocket.close()
     except IOError:
        fileNotFoundHeader = '\nHTTP/1.1 404 Not Found\n' 
        connectionSocket.send(fileNotFoundHeader.encode())
        #Send response message for file not found
         #Fill in start
         #Fill in end
         #Close client socket
        connectionSocket.close()
         #Fill in start
         #Fill in end
serverSocket.close()
sys.exit() #Terminate the program after sending the corresponding data 