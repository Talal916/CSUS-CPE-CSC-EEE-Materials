from socket import *

msg = "\r\n I love computer networks!"
endmsg = "\r\n.\r\n"

# Choose a mail server (e.g. Google mail server) and call it mailserver
mailserver = "localhost" #Fill in start #Fill in end
serverPort = 25;
# Create socket called clientSocket and establish a TCP connection with mailserver
#Fill in start
clientSocket = socket(AF_INET, SOCK_STREAM);
clientSocket.connect((mailserver,serverPort));
#Fill in end


recv = clientSocket.recv(1024).decode()
print(recv)
if recv[:3] != '220':
print('220 reply not received from server.')

# Send HELO command and print server response.

heloCommand = 'HELO Alice\r\n'
clientSocket.send(heloCommand.encode())
recv1 = clientSocket.recv(1024).decode()
print(recv1)
if recv1[:3] != '250':
 print('250 reply not received from server.')

# Send MAIL FROM command and print server response.
# Fill in start
print ("Sending MAIL FROM Command")
mailfromCommand = 'MAIL FROM:talaljawaid916@gmail.com\r\n'
clientSocket.send(mailfromCommand.encode())
recv2 = client.socket.recv(1024).decode()
if recv2[:3] != '250':
	print("250 Reply not Received")

# Fill in end


# Send RCPT TO command and print server response.
# Fill in start
print("Sending RCPT TO Command");
rcpttoCommand = 'RCPT TO: talaljawaid916@gmail.com'
clientSocket.send((rcpttoCommand).encode());
recv3 = clientSocket.recv(1024).decode();
# Fill in end

# Send DATA command and print server response.
# Fill in start
print("Sending DATA Command");
dataCommand = 'DATA\r\n'
clientSocket.send((dataCommand).encode());
recv4 = clientSocket.recv(1024).decode();
print(recv4)
if recv4[:3] != '354':
	print(354 Reply Not Received)
# Fill in end
# Send message data.
# Fill in start
print("Sending message data");
clientSocket.send((msg).encode());

recv4 = clientSocket.recv(1024);
if recv4[:3] != '250':
	print(250 Reply Not Received)
# Fill in end

# Message ends with a single period.
# Fill in start
print("Sending endmsg");
clientSocket.send((endmsg).encode());
# Fill in end
# Send QUIT command and get server response.
# Fill in start
print("Sending QUIT Command");
quitCommand = 'QUIT\r\n'
clientSocket.send((quitCommand).encode());

if recv4[:3] != '250':
	print(250 Reply Not Received);
# Fill in end