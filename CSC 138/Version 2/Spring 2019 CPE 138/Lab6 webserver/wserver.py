#import socket module
from socket import *

serverSocket = socket(AF_INET, SOCK_STREAM)
serverPort = 5858

# Prepare a sever socket

serverSocket.bind(('', serverPort))
serverSocket.listen(1)

while True:

    # Establish the connection

    print('Ready to serve...')
    connectionSocket, addr = serverSocket.accept()

    try:
        message = connectionSocket.recv(1024)
        print(message)
        filename = message.split()[1]
        f = open(filename[1:])
        outputdata = f.read()

        # Send one HTTP header line into socket

        # TypeError: a bytes-like object is required, not 'str'
        # Solution: use .encode('utf-8') or but letter b infront of text
        okmsg = b'\nHTTP/1.0 200 OK\n'
        connectionSocket.send(b'\nHTTP/1.1 200 OK\n')


        # Send the content of the requested file to the client

        for i in range(0, len(outputdata)):
            connectionSocket.send(outputdata[i].encode('utf-8'))
            #print(outputdata[i].encode('utf-8'))

        print('File Sent')

        connectionSocket.close()

    except IOError:

        # Send response message for file not found
        errmsg = b'\nHTTP/1.1 404 File Not Foundr\\n'
        connectionSocket.send(b'\n\nHTTP/1.1 404 File Not Found\n\n')
        # Close client socket
        connectionSocket.close()

serverSocket.close()

