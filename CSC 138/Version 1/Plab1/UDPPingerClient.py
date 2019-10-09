from socket import *
from time import *

serverName = 'localhost'
serverPort = 12005
serverAddress = '127.0.0.1'

clientSocket = socket(AF_INET, SOCK_DGRAM)
clientSocket.settimeout(1)



numTries = 11

print('Attempting to ping '+serverName)

for i in range(1,numTries):
	currentTime = time()
	message = 'Ping '+ str(i) + str(time()-currentTime) + ' seconds have passed.';
	try:
		clientSend = clientSocket.sendto(message.encode(),(serverName,serverPort))
		recvdMessage,serverAddress = clientSocket.recvfrom(2048)
		print('Response: Ping '+ i)
		print("\n Round Trip Time (RTT): "+ time()-currentTime + ' seconds')
	except socket.timeout:
		print('Request Timed Out')
clientSocket.close()


