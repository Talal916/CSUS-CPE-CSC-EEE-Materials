;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname test) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #f)))
(define (removeAtom a L)
  (cond ((null? L)
         '())
        ((list? (car L))
         (append(list(removeAtom a (car L))) (removeAtom a (cdr L))))
        ((= a (car L))
         (removeAtom a (cdr L)))
        (else
         (append(list(car L))(removeAtom a (cdr L))))))

(removeAtom '1 '(1 (1(2)2)))

(define (countDown n)
  (if (= 0 n ) '()
      (cons n (countDown (- n 1)))))

(countDown 9)

(define (countDownT n L)
  (if (= n 0) L
      (countDownT (- n 1) (append L (list n)))))

(countDownT 9 '())

(define (RcountDown n)
  (if (= n 0) '()
      (append (RcountDown (- n 1)) (list n))))

(define (squareList L)
  (if (null? L) '()
      (cons (*(car L)(car L)) (squareList (cdr L)))))

(RcountDown 9)

(squareList '(1 2 3 4 5))

(define (squareListT L b)
  (if (null? L) b
      (squareListT (cdr L) (append b (list (* (car L) (car L)))))))

(squareListT '(1 2 3 4 5) '())

( define ( square-list L )
   (map (lambda (x) (* x x)) L))

(square-list '(1 3 4 6 8))

(define (removeif F L)
  (cond ((null? L)
         '())
        ((F (car L))
         (removeif F (cdr L)))
        (else
         (cons (car L) (removeif F(cdr L))))))

(define (removeifeven L)
  (removeif (lambda (x) (= (modulo x 2) 0)) L))

(removeifeven '(1 3 5 7 8 9 0))

(define (concatL A B)
  (if (null? A) '()
      (cons (string-append (car A) (car B)) (concatL (cdr A) (cdr B)))))

(define (buildList n E)
  (if (= 0 n) '()
      (cons E (buildList (- n 1) E))))

( buildList 5 '() ) ; expects '( () () () () () )
( buildList 3 'A )  ; expects '( A A A)

(define (listpicket A L)
  (if (null? L) (list A)
      (append(cons A (list(car L))) (listpicket A (cdr L)))))

(define (listpicketall A L)
  (cond ((null? L)
         (list A))
        ((list? (car L))
         (cons (cons A (listpicketall A (car L))) (listpicketall A (cdr L))))
        (else
         (append (cons A (list (car L))) (listpicketall A (cdr L))))))

(define (countElement L)     ; count the number of elements of a list  
  (if (null? L) 0
      (+ 1 (countElement (cdr L)))))

(define (removeFirstN n L)   ; remove first N elements of a list
  (if (= n 0) L
      (helper (- n 1) (cdr L))))
 
(define (selectN n)          ; return a function which left the last n elements of a list
  (lambda (L) (helper (- n(countElement L)) L)))

(define Last (selectN 3))  ; return last 3 elements of a list
(Last '(4 8 2 9 -1 13))    ; expects '(9 -1 13)
(Last '(-2 3 -4 8 9 1 7))  ; expects '(9 1 7)

( buildList 2 '(a b c ) ) ; expects '( (a b c) (a b c) )
( concatL '( "ab" "c" "de" ) '( "fff" "des" "vvvv" )) ; expects '( "abfff" "cdes" "devvvv" )

( listpicket 'A '( d ( e f g ) h ( g ) )) ; expects '( A d A ( e f g ) A h A ( g ) A )

( listpicketall 'A '( a ( ( ( b c ) ) e ) ) ) ; expects '( A a A ( A ( A ( A b A c A) A) A e A) A)