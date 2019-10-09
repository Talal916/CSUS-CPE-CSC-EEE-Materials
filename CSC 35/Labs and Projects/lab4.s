#Lab 4
#Sam Lee
#CSC 35
#Professor Cook

.data

Guess:
    .ascii "Your Guess: \0"
High: 
    .ascii "You are too high, choose lower!!!\n\0"
Low:
    .ascii "You are too low, choose higher!!!\n\0"
Result:
    .ascii "Congratulations, you are correct. It took you a total of \0"
EndResult:
    .ascii " guesses!!!\n\0"

.text
.global _start

_start:   
     mov $101, %rax
     call Random
     
     mov %rax, %rbx
     
Game:
     add $1, %rcx 
     mov $Guess, %rax
     call PrintCString
     call ScanInt
     cmp %rbx, %rax
     JE ThirdSentence
     cmp %rbx, %rax
     JG FirstSentence
     cmp %rbx, %rax
     JL SecondSentence
   
FirstSentence:
     mov $High, %rax
     call PrintCString
     JMP Game    
SecondSentence:
     mov $Low, %rax
     call PrintCString
     JMP Game
ThirdSentence:     
     mov $Result, %rax
     call PrintCString
     JMP LastSentence     
LastSentence:
      mov %rcx, %rax
      call PrintInt    
      mov $EndResult, %rax
      call PrintCString
call EndProgram
