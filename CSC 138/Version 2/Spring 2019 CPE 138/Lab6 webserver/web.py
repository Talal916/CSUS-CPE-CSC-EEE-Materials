#import socket module

from socket import *

serverSocket= socket(AF_INET, SOCK_STREAM)#creates socket

#Prepare a sever socket

#Fill in start

serverPort = 7000 #sets port

serverSocket.bind(('', serverPort)) #associates socket with this port

serverSocket.listen(1) #tells socket to listen for requests

#Fill in end

while True:

#Establish the connection

    print ('Ready to serve…')

    connectionSocket, addr = serverSocket.accept() #creates a socket specifically for this client

    try:

        message =connectionSocket.recv(1024) #receives message from client

        print (message)

        filename = message.split()[1]

        f = open(filename[1:]) #opens file and reads the contents

        outputdata =f.read()

        #Send one HTTP header line into socket

        #Fill in start

        connectionSocket.send(b'\nHTTP/1.x 200 OK\n')

        #Fill in end

        #Send the content of the requested file to the client

        for i in range(0, len(outputdata)):

            connectionSocket.send(outputdata[i].encode()) #outputs all of the data in the file

        connectionSocket.close() #closes the socket for this client

        print ('File Recieved')

    except IOError:

        #Sendresponse message for file not found

        #Fill in start

        connectionSocket.send(b'\n404 File Not Found\n') #sends an error message to be printed on the page

        #Fill in end

        #Close client socket

        #Fill in start

        connectionSocket.close() #closes the socket for the client

#Fill in end

serverSocket.close() #closes the server socket
