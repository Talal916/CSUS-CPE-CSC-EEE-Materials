#Lab 1
#Sam Lee
#CSC 35
#Professor Cook

.data                            
Message:  		          
    .ascii "Hello World!\n\0"    

Name:   
 .ascii "My name is\n"
 .ascii "Sam Lee.\n\0"

Quote:
    .ascii "Always be yourself and have faith in yourself.\n\0"

Graduate:
    .ascii "I will graduate in \0"

EndGraduate:
    .ascii " from Sacramento State\n\0"

.text				  
.global _start		         
			
_start:				  
    mov $Message, %rax		  
    call PrintCString		  
    
mov $Name, %rax
    call PrintCString
   
 mov $Quote, %rax
    call PrintCString
   
 mov $Graduate, %rax
    call PrintCString
   
 mov $2021, %rax
    call PrintInt
   
 mov $EndGraduate, %rax
    call PrintCString		
   
 call EndProgram 	 	  
