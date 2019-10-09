#include <stdio.h>
#include <stdlib.h> 
#include <string.h> 
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>

#define SA struct sockaddr

#define SERVER_PORT 65450
#define MAX_PENDING 5
#define MAX_LINE 256


int main(){
	struct sockaddr_in sin;
	char buf[MAX_LINE];
	int len, le;
	int s, new_s;
	
	

	/* build address data structure */
	bzero((char *)&sin, sizeof(sin));sin.sin_family= AF_INET;
	sin.sin_addr.s_addr= INADDR_ANY;
	sin.sin_port= htons(SERVER_PORT);
	/* setup passive open */
	
	// Socket making
	int sockfd = socket (PF_INET, SOCK_STREAM, 0);
	if(sockfd < 0){
		printf("Creating socket failed...\n"); 
        	exit(0); 
	}
	else{
		printf("Socket successfully created..\n");
	}
	
	//int bind (int socket, struct sockaddr *address, int addr_len)
	if ((bind(sockfd, (SA*)&sin, sizeof(sin))) != 0) { 
        	printf("Binding socket failed...\n"); 
        	exit(0); 
    	} 
    	else{
        	printf("Socket bind success..\n"); 
	}

	//int listen (int socket, int backlog)
	if ((listen(sockfd, MAX_PENDING)) != 0) { 
        	printf("Listen failed...\n"); 
        	exit(0); 
    	} 
    	else{
        	printf("Server listening..\n"); 
	}
	


/* wait for connection, then receive and print text */
	while(1) {
	
		//int accept (int socket, struct sockaddr *address, int *addr_len) 

		le = sizeof(sin); 
      		new_s = accept(sockfd, (SA*)&sin, &le); 
    		if (new_s < 0) { 
        		printf("server acccept failed...\n"); 
        		exit(0); 
    		} 
   		else{
        		printf("server acccept the client...\n"); 
		}

		//int recv (int socket, char *buff, int buff_len, int flags)
		len = sizeof(buf);
		recv(new_s, buf, len, 0);
		printf("Client message: %s ", buf);

		
	}
}