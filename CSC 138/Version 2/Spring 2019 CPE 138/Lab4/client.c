#include <stdio.h>
#include <stdlib.h> 
#include <string.h> 
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>


#define sa struct sockaddr 

#define SERVER_PORT 65450
#define MAX_LINE 256

int main(int argc, char * argv[])
{
	FILE *fp;
	struct hostent *hp;
	struct sockaddr_in sin;
	char *host;
	char  buf[MAX_LINE];
	int s;
	int len;
	host  =  argv[1];


	/* translate host name into peer’s IP address */
	hp = gethostbyname(host);

	/* build address data structure */
	bzero((char *)&sin, sizeof(sin));
	sin.sin_family= AF_INET;  /* Internet Address*/
	bcopy(hp->h_addr, (char *)&sin.sin_addr, hp->h_length);
	sin.sin_port= htons(SERVER_PORT);
	
	/* active open  PF_INET is protocol family*/
	//fillyourcodethecreatethesocket

	int sockfd = socket (PF_INET, SOCK_STREAM, 0);
	if(sockfd < 0){
		printf("socket creation failed...\n"); 
       		exit(0); 
	}
	else{
        	printf("Socket successfully created..\n"); 
    		
	}

	//fillyourcodetheconnectthesocketwithserver
	//int connect (int socket, struct sockaddr *address, int addr_len);
	
	if(connect(sockfd, (sa *)&sin, sizeof(sin)) < 0){
		printf("connection with the server failed...\n"); 
        	exit(0); 
    	} 
	else{
        	printf("connected to the server..\n"); 
	}
	

	/* main loop: get and send lines of text */
	printf("Enter something to send to server: ");
	while (fgets(buf, sizeof(buf), stdin)) {
		buf[MAX_LINE-1] = '\0';
		len= strlen(buf) + 1;
		send(sockfd, buf, len, 0);
	}

	
}