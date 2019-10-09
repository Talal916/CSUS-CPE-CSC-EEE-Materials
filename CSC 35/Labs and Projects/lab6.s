#Lab 3
#Sam Lee
#CSC 35
#Professor Cook

.data
	Message:
		.ascii "Hello World!\n"
	Message1:
		.ascii "My name is Sam Lee.\n"
	Message2:
		.ascii "My plans for winter break is to sleep.\n"

.text
.global _start

_start:
	mov $1, %rax
	mov $1, %rdi
	mov $Message, %rsi
	mov $13, %rdx
	syscall

	mov $1, %rax
	mov $1, %rdi
	mov $Message1, %rsi
	mov $20, %rdx
	syscall

	mov $1, %rax
	mov $1, %rdi
	mov $Message2, %rsi
	mov $39, %rdx
	syscall 

	mov $60, %rax
	mov $0, %rdi
	syscall

	
