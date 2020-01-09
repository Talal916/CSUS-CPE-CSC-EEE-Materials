#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int number = 7;

int main(void) {
	pid_t pid;
	printf("\nRunning the execl example\n");
	pid = fork();
	printf("PID is %d\n", pid);
	
	if (pid == 0) {
		printf("\tIn the execl child, PID is %d\n", pid);
		execl("./forkexample2", "forkexample2", NULL);
		return 0;
	} else if (pid > 0) {
		wait(NULL);
		printf("In the parent, done waiting\n");
	}

	return 0;
}
