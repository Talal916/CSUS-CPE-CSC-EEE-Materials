;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname ChunYueLEUNG_Assignmenrt2) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #f)))
; Chun Yue LEUNG
; CSC135 Assignmnet 2

; Q1 ----------------------------------------------------------------------------
;    Takes two integers, and returns a 5-digit integer constructed of the rightmost 3 digits
;of the first input, and the leftmost 2 digits of the second input.

(define (countDigit a)    ; return the number of digit of an positive integer
  (if (< (/ a 10) 1) 1
      (+ 1 (countDigit (/ a 10)))))

(define (power a b)       ; return integer: integer a to the power of integer b
  (if (= 0 b) 1
      (* a (power a (- b 1)))))
       
(define (left2most b)     ; return the leftmost two digit of an integer
  (let ( (d (power 10 (- (countDigit b) 2))))
  (/(- b (modulo b d)) d)))

(define (make5 a b)       ; final function for Q1
  (let ( (a (abs a))
         (b (abs b)) )
  (if (or (< a 100) (< b 10)) '-2
      (+ (*(modulo a 1000)100) (left2most b)))))

;Testing
(newline)
(display "*****Testing for Q1*****" )(newline)
(make5 '561432 '254) ; expects '43225
(make5 '561432 '-254) ; expects '43225
(make5 '32 '-254) ; expects '-2
(make5 '561432 '-2) ; expects '-2
(make5 000 '456456) ; expects '-2

; Q2 ----------------------------------------------------------------------------
;    Takes two lists of strings of the same length and returns a list of that length containing strings
;which are the concatenation of the strings at the same position in the two list.
(define (concatL A B)
  (if (null? A) '()
      (cons (string-append (car A) (car B)) (concatL (cdr A) (cdr B)))))

;Testing
(newline)
(display "*****Testing for Q2*****" )(newline)

( concatL '( "ab" "c" "de" ) '( "fff" "des" "vvvv" )) ; expects '( "abfff" "cdes" "devvvv" )


; Q3 ----------------------------------------------------------------------------
;    Takes an integer N and a Scheme expression E (i.e. an atome or a list ) and
;returns a new list of length N where each element is the Expression E.
(define (buildList n E)
  (if (= 0 n) '()
      (cons E (buildList (- n 1) E))))

;Testing
(newline)
(display "*****Testing for Q3*****" )(newline)

( buildList 5 '() ) ; expects '( () () () () () )
( buildList 3 'A )  ; expects '( A A A)
( buildList 2 '(a b c ) ) ; expects '( (a b c) (a b c) )


; Q4 ----------------------------------------------------------------------------
;     Takes a list and a “picket” and returns a “picketed list.”
; The picketed list is the original list where all the elements are now surrounded by pickets
(define (listpicket A L)
  (if (null? L) (list A)
      (append(cons A (list(car L))) (listpicket A (cdr L)))))

;Testing
(newline)
(display "*****Testing for Q4*****" )(newline)

( listpicket 'A '( d ( e f g ) h ( g ) )) ; expects '( A d A ( e f g ) A h A ( g ) A )


; Q5 ----------------------------------------------------------------------------
;    Similr to Q3, except it also applies to sub-list
(define (listpicketall A L)
  (cond ( (null? L)
          (list A) )
        ( (list? (car L))
          (append (cons A (list(listpicketall A (car L)))) (listpicketall A (cdr L))))
        ( else
          (append (cons A (list (car L))) (listpicketall A (cdr L))))))

;Testing
(newline)
(display "*****Testing for Q5*****" )(newline)

( listpicketall 'A '( a ( ( ( b c ) ) e ) ) ) ; expects '( A a A ( A ( A ( A b A c A) A) A e A) A)

; Q6 ----------------------------------------------------------------------------
;    Takes as input an integer N. It then builds and returns a "select" function based on N.
(define (helper n L)   ; remove first N elements of a list
  (if (= n 0) L
      (helper (- n 1) (cdr L))))
 
(define (selectN n)          ; return a function which left the last n elements of a list
  (lambda (L) (helper n L)))

;Testing
(newline)
(display "*****Testing for Q6*****" )(newline)

(define Last (selectN 3))  ; Remove first 3 elements of a list
(Last '(4 8 2 9 -1 13))    ; expects '(9 -1 13)
(Last '(-2 3 -4 8 9 1 7))  ; expects '(8 9 1 7)

