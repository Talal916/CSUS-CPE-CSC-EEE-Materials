#Project 
#Sam Lee
#CSC 35
#Professor Cook

.data

Message:
	.ascii "Welcome to the Guessing Word Game!!!\n\0"
Message1:
	.ascii "Please enter a word, Player 1: \0"
Answer:
	.ascii "\nPlease type letter, Player 2: \0"
CorrectMessage:
	.ascii "\nYou are correct, please guess again.\n\0"
LosingMessage:
	.ascii "\nYou are very bad at this game, please guess again.\n\0"
WinMessage:
	.ascii  "\nCongrats, you won the game!!! \0"
Lose:
	.ascii "\nYou lose the game. You're a loser! \0"
TryBars:
	.ascii "\nThe amount of tries that you have or have left:\n\0"
LastMessage:
	.ascii "\nThe secret word was: \n\0"
HealthLine:
	.ascii "+++++\n\0"
Buffer:
	.space 100
Buffer1:
	.space 100
AnotherLine:
	.ascii " \n\0"
	
.text
.global _start

_start:

#Prints out the introduction of the game
	mov $Message, %rax
	call PrintCString

	mov $Message1, %rax
	call PrintCString

	mov $100, %rbx
	mov $Buffer, %rax
	call ScanCString

	call LengthCString
	mov %rax, %r8 #This is the length of the secret word

	mov $-1, %rdi #loop counter
	mov $0, %dh #character

#Moves Buffer to Buffer1
Loop:
	movb Buffer (%rdi), %dh
	movb %dh, Buffer1 (%rdi)
	add $1, %rdi
	cmp %r8, %rdi
	jl Loop
	
	call ClearScreen

#Converts the buffer or store word into dashes like this: -----
	mov $45, %dh
	mov $0, %rdi

Loop2:
	movb $45, Buffer(%rdi)
	add $1, %rdi
	cmp %r8, %rdi
	jl Loop2

	mov $0, %r9

GameLoop:
	mov $-1, %rdi
	#mov $45, %dh

#Loops until all characters are not ----- 
FinishGame:
	add $1, %rdi
	cmp %dh, Buffer(%rdi)
	je GameInput
	cmp %r8, %rdi
	jge End
	jmp FinishGame

	#Displays the health bar and etc.
GameInput:
	mov $TryBars, %rax
	call PrintCString
	mov $HealthLine, %rax 
	call PrintCString
	mov $Buffer, %rax
	call PrintCString
	mov $AnotherLine, %rax
	call PrintCString
	mov $Answer, %rax
	call PrintCString
	call ScanChar
	mov %al, %bl #bl is char that gets inputted and scanned

#Counts loss and tells whether the user has loss after 5 tries
	
	mov $-1, %rdi

LosePoint:
	add $1, %rdi
	mov $0, %cl
	call CapLower
	cmp %bl, Buffer1(%rdi)
	je Counter
	cmp %cl, Buffer1(%rdi)
	je Counter
	cmp %r8, %rdi
	jle LosePoint
	call Lose1Point
	cmp $5, %r9
	jge Losing
	jmp GameInput

#Finds the letter in the word and changes them
#Congratulates the user
Counter:
	call Green
	mov $CorrectMessage, %rax
	call PrintCString
	call Cyan
	mov $-1, %rdi

#Checks for case sensitivity and replaces the dashes
GameLoop1:
	add $1, %rdi
	mov $0, %cl
	call CapLower
	cmp %bl, Buffer1(%rdi)
	je Replace
	cmp %cl, Buffer1(%rdi)
	je Replace
	cmp %r8, %rdi
	jge GameLoop
	jmp GameLoop1

Replace:
	movb Buffer1(%rdi), %cl
	movb %cl, Buffer(%rdi)
	jmp GameLoop1

#Prints the ending message of the game	
End:
	mov $LastMessage, %rax
	call PrintCString
	call Green
	mov $Buffer, %rax
	call PrintCString
	mov $AnotherLine, %rax
	call PrintCString
	mov $WinMessage, %rax
	call PrintCString
	call Magenta
	mov $AnotherLine, %rax
	call PrintCString
	call EndProgram

Losing:
	call Red #changes color when you pick the wrong character
	mov $Lose, %rax
	call PrintCString
	mov $AnotherLine, %rax
	call PrintCString
	call Cyan	
	call EndProgram

#Point deduction and prints the losing message
Lose1Point:
	add $1, %r9
	mov %r9, %r10
	sub $1, %r10
	movb $88, HealthLine(%r10) #this changes + into X to indicate you lose a life
	call Red
	mov $LosingMessage, %rax
	call PrintCString
	call Magenta
	ret

#Color Changes
#Red Color
Red:
	push %rax
	mov $1, %rax #ascii code for red
	call SetForeColor
	pop %rax
	ret

#Green Color
Green:
	push %rax
	mov $2, %rax #ascii code for green
	call SetForeColor
	pop %rax
	ret

#Cyan Color
Cyan:
	push %rax
	mov $6, %rax #ascii code for cyan
	call SetForeColor
	pop %rax
	ret
	
#Magenta Color
Magenta: 
	push %rax
	mov $5, %rax #ascii code for magenta
	call SetForeColor
	pop %rax
	ret

#This part changes cl and stores the capital/lowercase into cl
CapLower:
	mov %bl, %cl
	cmp $122, %cl
	jg Else
	cmp $65, %cl
	jl Else
	cmp $97, %cl
	jge LowerCase
	jl CapitalLetter
	
#The method to check if the secret word has a capital letter
CapitalLetter:
	add $32, %cl
	ret
	
#The method to check if the secret word has a lowercase letter
LowerCase:
	sub $32, %cl
	ret

Else:
	ret

