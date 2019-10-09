#Lab 2
#Sam Lee
#CSC 35
#Professor Cook

.data
First:
      .ascii "Eating an apple: 40 points\n\0"

Second:
      .ascii "Skipping class: 50 points\n\0"

Third: 
      .ascii "Being on time to class: 60 points\n\0"

FirstQuestion: 
      .ascii "How many people ate an apple?\n\0"

SecondQuestion:
      .ascii "How many people skipped class?\n\0"

ThirdQuestion:
      .ascii "How many people were on time to class?\n\0"

FourthStatement:
      .ascii "You earned \0"

FifthStatement:
      .ascii " points.\n\0"

.text
.global _start

_start:
      mov $First, %rax
      call PrintCString

      mov $Second, %rax
      call PrintCString

      mov $Third, %rax
      call PrintCString

      mov $FirstQuestion, %rax
      call PrintCString
      call ScanInt
      imul $40, %rax
      mov %rax, %rbx
 
      mov $SecondQuestion, %rax
      call PrintCString
      call ScanInt
      imul $50, %rax
      add %rax, %rcx
      
      mov $ThirdQuestion, %rax
      call PrintCString 
      call ScanInt
      imul $60, %rax
      add %rax, %rdx

      mov $FourthStatement, %rax
      call PrintCString
      mov %rdx, %rax
      call PrintInt 
     

     mov $FifthStatement, %rax
     call PrintCString

call EndProgram
