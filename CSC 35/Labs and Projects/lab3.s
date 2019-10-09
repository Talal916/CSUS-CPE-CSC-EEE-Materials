#Lab 3
#Sam Lee
#CSC 35
#Professor Cook

.data
 Q1:
   .ascii "Do you like sports? (1=yes, 2=no) \n\0"
 Q2:
   .ascii "Are you lazy? (1=yes, 2=no)\n\0"
 S3:
   .ascii "Working Hard House\n\0"
 S4:
   .ascii "Lazy People House\n\0"
 Q5:
   .ascii "Do you play tennis? (1=yes, 0=no)\n\0"
 S6:
   .ascii "Other Sports Club\n\0"
 S7:
   .ascii "Tennis Club\n\0"

.text
.global _start

_start:
Main:
      mov  $Q1, %rax      
      call PrintCString
      call ScanInt      
      cmp $1, %rax
      je Right
Left:
      mov $Q2, %rax
      call PrintCString
      call ScanInt
      cmp $1, %rax
      je RightSecond
LeftSecond:
      mov $S3, %rax
      call PrintCString
      jmp End
RightSecond:
      mov $S4, %rax
      call PrintCString
      jmp End
Right: 
      mov $Q5, %rax
      call PrintCString 
      call ScanInt
      cmp $1, %rax
      je RightSecond2
LeftSecond1:
      mov $S6, %rax
      call PrintCString
      jmp End
RightSecond2:
      mov $S7, %rax
      call PrintCString
      jmp End
End: 
call EndProgram

