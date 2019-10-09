#Project 
#Sam Lee
#CSC 35
#Professor Cook

.data

	Intro: .ascii "Welcome to The Word Game!\n\0"
	Player1: .ascii "Player #1, Please Enter Your Word: \n\0"
	Answer: .space 40
	Copy: .space 40
	Player2: .ascii"Player 2, The word is \0"
	Prompt1: .ascii "\nYour turn to guess the word: \n\0"
	Answer2: .space 40
	Prompt2: .ascii "Wrong answer buddy guess again!\n\0"
	Prompt3: .ascii " is the clue.\n\0"
	UnderTwo: .ascii "Wow, Under two tries? You're awesome at this game.\n\0"
	UnderFour: .ascii "Under four tries, you're meh.\n\0"
	OverFour: .ascii "More than four tries, you might as well not play this game\n\0"
.text

.global _start

_start:
	mov $0, %rdx		#Intro and user prompting
	mov $Intro, %rax
	call PrintCString

	mov $Player1, %rax
	call PrintCString

	mov $Answer, %rax
	mov $40, %rbx
	call ScanCString
	mov $0, %rdi

While:				#Copying the user input
	cmp $40, %rdi   #Keeps track of index and does not stop until all indices are done
	je NextStep		#When all indices are done it jumps to the next block of code

	mov Answer(%rdi), %al	
	mov %al, Copy(%rdi)

	add $1, %rdi
	jmp While

NextStep:
	mov $1, %rdi		#Initializing index at 1 to take out ever two letter

RemoveLetters:			
	cmp $40, %rdi
	jg Next

	movb $45, Answer(%rdi)	#45 is '-' in ascii, here it replaces every second letter with '-'
 	add $2, %rdi
	jmp RemoveLetters

Next:
	call ClearScreen	#Got it from your library, clears screen, or I could have also just new line 99x
	mov $Player2, %rax	#Here just prompts player two what to do
	call PrintCString
	mov $Answer, %rax
	call PrintCString
	mov $Prompt1, %rax
	call PrintCString
	mov $0, %rdi
	
Compare:			#This block of code takes in the user input and jumps it into a loop
	
	mov $Answer2, %rax
	mov $40, %rbx
	call ScanCString
	jmp Loop
Loop: 				#The look will take every single byte and compare them, and if they match it
	cmp $40, %rdi		#will continue until it's done, if not it will take you to the wrong loop and then back to the guess
	je WinningText
	mov Answer2(%rdi), %al
	cmp %al, Copy(%rdi)
	je Plus
	jne Wrong
Plus:				#Keeps track of the index
	add $1, %rdi
	jmp Loop
Wrong:				#Wrong block, prompts you that you are wrong, and prompts the word with
	add $1, %rdx		#the missing letters again so you can guess again
	mov $Prompt2, %rax
	call PrintCString
	mov $Answer, %rax
	call PrintCString
	mov $Prompt3, %rax
	call PrintCString
	jmp Compare

WinningText:			#List of winning texts, they may vary depending on how good you are at the game

	cmp $2, %rdx
	jle Two
	cmp $4, %rdx
	jle Four
	cmp $4, %rdx
	jg More
Two:
	mov $UnderTwo, %rax
	call PrintCString
	jmp Done
Four:
	mov $UnderFour, %rax
	call PrintCString
	jmp Done
More:
	mov $OverFour, %rax
	call PrintCString
	jmp Done
Done:

	call EndProgram
