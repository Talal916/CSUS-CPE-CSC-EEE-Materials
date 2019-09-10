#lang racket

;======================;
;; Dr. Gordon
;; Csc 135 Assignment 2
;;Fall 2018
;======================;

;; Problem A "ludicrous"
;;===============================================
(define (ludicrous F L)
	(if (null? L) #t
				  (if (>= (counter F L) 0) #t
									#f))
)

;;helper function counter.
(define (counter F list)
  (if (null? list)
      0
      (+ (if (F (car list)) 1 (- 0 1))
         (counter F (cdr list))))
)

;------Tester Function-----
(define (isEven a)
  (if (even? a) #t #f)
)

(define (isOdd E)
  (if (= 0 (modulo E 2)) #f
      ;If E % 2 = 0, not odd
      ;.......... 1, is  odd
                         #t))

;;Try to test by (ludicrous isEven '(8 6 0))

;;===============================================
;; Problem B "cappedSum"

;;===============================================
;;===============================================
;; Problem C "reverseShuffle"
(define (reverseShuffle L1 L2)
	(if (null? L2) '();;return nothing
		   (cons(iteminList L1(car L2))
			(reverseShuffle L1(cdr L2))))	
)

;;helper function to get the item of a list.
(define (iteminList List i)
	(if (null? List) '()
		(if (equal? 1 i) (car List)
			(iteminList (cdr List)(- i 1))))

)
;;===============================================
;;===============================================
;; Problem D "biggestListSize"

;;===============================================
;;===============================================
;; Problem E "functionPairs"

;;===============================================
;;===============================================
;; Problem F "nestedCappedSum"
(define (neshtlist L1)
	(if (< (getLength L1) 2) L1
		(cons (car L1) (cons(neshtlist(cdr (remLast L1))) 
						(cons (getLast L1) '()))))
)

;;helper function to get the last item in the list.
(define (getLast L1)
	(if (null? (cdr L1)) (car L1)
		(getLast (cdr L1)))
)
;;Try to test by getLast'(numbers)

;;helper funtion to remove the last item in the list.
(define (remLast L1)
	(if (null? (cdr L1)) '()
		(cons(car L1) (remLast(cdr L1))))
)
;;Try to test by remLast'(numbers)

;;helper funtion to get the length of the list.
(define (getLength List)
	(if (null? List) 0
		(+ 1 (getLength (cdr List))))
)

;;===============================================
;;===============================================
;; Problem G "makeExploder"
(define (makeExploder L)
	(define (F P)
		(mapperExploder L P) );--Helper Function does the work
		F
)

;;helper function that mangle a single number.
(define (exploder L n)
	(+ (* (expt n (car L)) (car (cdr L))) (car (cdr (cdr L))))
)

;;helper function that map for exploder.	
(define (mapperExploder L1 L2)
	(if (null? L2) '();Returns empty list when done with recursion
		(cons (exploder L1 (car L2)) (mapperExploder L1 (cdr L2))))
)
;;===============================================
;;examples of how to run it (define P (makeExploder '(2 5 3)))
;;(P '(4))
;;output 27000