from socket import *
heloCommand = 'HELO Alice\r\n'

# Choose a mail server (e.g. Google mail server) and call it mailserver
mailserver = "localhost" 
serverport = 25

# Create socket called clientSocket and establish a TCP connection with mailserver
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((mailserver, serverport))
recv = clientSocket.recv(1024)
print recv
if recv[:3] != '220':
	print '220 reply not received from server.'

# Send HELO command and print server response.
print "Sending First HELO"
clientSocket.send(heloCommand)
recv1 = clientSocket.recv(1024)
print recv1
if recv1[:3] != '250':
	print '250 reply not received from server.'

# Send MAIL FROM command and print server response.
print "Sending MAIL FROM Command"
mailFromCommand = 'MAIL FROM: hoangvu518@gmail.com\r\n'
clientSocket.send(mailFromCommand)
recv1 = clientSocket.recv(1024)
print recv1
if recv1[:3] != '250':
	print '250 reply not received from server'

# Send RCPT TO command and print server response.
print "Sending RCPT TO Command"
rcptToCommand = 'RCPT TO: hoangvugame518@gmail.com\r\n'
clientSocket.send(rcptToCommand)
recv1 = clientSocket.recv(1024)
print recv1
if recv1[:3] != '250':
	print '250 reply not received from server' 

# Send DATA command and print server response.
print "Sending DATA Command"
dataCommand = 'DATA\r\n'
clientSocket.send(dataCommand)
recv1 = clientSocket.recv(1024)
print recv1
if recv1[:3] != '354':
	print '354 reply not received from server' 
	
# Send message data.
# Message ends with a single period.
print "Send message data"
msg="SUBJECT: SMTP Mail Client Test\nI love computer networks\n.\r\n"
clientSocket.send(msg)

recv1 = clientSocket.recv(1024)
print recv1
if recv1[:3] != '250':
	print '250 reply not received from server' 
# Fill in end

# Send QUIT command and get server response.
quitCommand = 'QUIT\r\n'
clientSocket.send("QUIT\r\n")
recv1 = clientSocket.recv(1024)
print recv1
if recv1[:3] != '221':
	print '221 reply not received from server'
