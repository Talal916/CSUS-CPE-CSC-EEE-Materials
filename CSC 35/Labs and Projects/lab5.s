#Lab 5
#Sam Lee
#CSC 35
#Professor Cook

.data
FirstPhrase: 
	.ascii "I'M MR. MEEKSEEKS. LOOK AT ME!\n\0"
EndPhrase:
	.ascii "? CAN DO!\n\0"
Task: 
	.space 30

.text
.global _start

_start:
	mov $FirstPhrase, %rax
	call PrintCString
	
	mov $30, %rbx
        mov $Task, %rax
	call ScanCString	
	
	mov %rax, %rcx
	call LengthCString
	mov %rax, %rbx
	mov $0, %rdi

Loop:
	cmp %rbx, %rdi
	jg End
	cmpb $122, (%rcx, %rdi)
	jg Next
	cmpb $96, (%rcx, %rdi)
	jg Subtract
	add $1, %rdi
	jmp Loop
Subtract:
	subb $32, (%rcx, %rdi)
	add $1, %rdi
	jmp Loop
Next:
	add $1, %rdi
	jmp Loop

End:
	mov %rcx, %rax
	call PrintCString
	mov $EndPhrase, %rax
	call PrintCString
	call EndProgram
