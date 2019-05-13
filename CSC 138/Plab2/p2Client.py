
from socket import *

msg = '\r\n I love computer networks!'
endmsg = '\r\n.\r\n'
# Choose a mail server (e.g. Google mail server) and call it mailserver
mailserver = "smtp.csus.edu"
mailPort = 23
# Create socket called clientSocket and establish a TCP connection with mailserver
#Fill in start  
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((mailserver, mailPort))
#Fill in end
recvhelo = clientSocket.recv(1024)
print recv
if recv[:3] != '220':
	print '220 reply not received from server.'

# Send HELO command and print server response.
heloCommand = 'HELO Alice\r\n'
clientSocket.send(heloCommand)
recv1 = clientSocket.recv(1024)
print recv1
if recv1[:3] != '250':
	print '250 reply not received from server.'
    
# Send MAIL FROM command and print server response.
clientSocket.send("MAIL FROM: <Chun@Alice.com\r\n")
recv2 = clientSocket.recv(1024)
if recv2[:3] != '250':
	print '250 reply not received from server.'
# Fill in end

# Send RCPT TO command and print server response. 
# Fill in start
clientSocket.send("RCPT TO: <chunyueleung@csus.edu>\r\n")
recv3 = clientSocket.recv(1024)
if recv3[:3] != '250':
	print '250 reply not received from server.'
# Fill in end

# Send DATA command and print server response. 
# Fill in start
clientSocket.send("DATA\r\n")
recv4 = clientSocket.recv(1024)
if recv4[:3] != '250':
	print '250 reply not received from server.'
# Fill in end

# Send message data.
# Fill in start
clientSocket.send(msg)
if recv4[:3] != '250':
	print '250 reply not received from server.'
# Fill in end
# Message ends with a single period.
# Fill in start
clientSocket.send(endmsg)
if recv4[:3] != '250':
	print '250 reply not received from server.'
# Fill in end

# Send QUIT command and get server response.
# Fill in start
clientSocket.send("QUIT\r\n")
if recv4[:3] != '250':
	print '250 reply not received from server.'
# Fill in end