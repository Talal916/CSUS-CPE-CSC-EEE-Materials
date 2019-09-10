;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname HandoutsSolQ6) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #f)))
(define (atom? a)
  (not (list? a)))

(define (remove_atom x L) ; orignale code
  (cond ( (null? L ) '( ) )
        ( (atom? (car L) ) (if (eq? (car L) x) (cons (remove_atom x (cdr L) ) null )
                               (cons (car L) (remove_atom x (cdr L) ) ) ) )
        ( else (append (remove_atom x (car L) ) (remove_atom x (cdr L) ) ) ) ) )

( remove_atom 'a '( a ( b c ( a ) a ) ( a b ) ) )


(define (remove_atom2 x L) ; fixed code
  (cond ( (null? L ) '( ) )
        ( (atom? (car L) ) (if (eq? (car L) x) (remove_atom2 x (cdr L) ) ; remove the (cons .... null)
                               (cons (car L) (remove_atom2 x (cdr L) ) ) ) )
        ( else (cons (remove_atom2 x (car L) ) (remove_atom2 x (cdr L) ) ) ) ) ) ; use append instead of cons

( remove_atom2 'a '( a ( b c ( a ) a ) ( a b ) ) )

(define (remove_atom3 x L) ; fixed code
  (cond ( (null? L ) '( ) )
        ( ( and (atom? (car L) ) (eq? (car L) x) ) (remove_atom3 x (cdr L) ) )
        ( ( atom? (car L) ) (cons (car L) (remove_atom3 x (cdr L) ) ) ) 
        ( else (cons (remove_atom3 x (car L) ) (remove_atom2 x (cdr L) ) ) ) ) )

( remove_atom3 'a '( a ( b c ( a ) a ) ( a b ) ) )

(define (isEven? x)
  (= 0 (modulo x 2))) 

(isEven? '2)

(define (sumOfSquares x y)
  (+ (* x x) (* y y)))

(sumOfSquares 4 3)

(define (factorial x)
  (if (= x 0) 1
      (* x (factorial (- x 1)))))

(factorial 6)

(define (lastElement L)
  (if (null? (cdr L)) (car L)
      (lastElement (cdr L))))

(lastElement '(1 2 3 4))

(define (isInList L a)
  (if (null? L) #f
      (or (eq? (car L) a) (isInList (cdr L) a))))

(isInList '(1 2 3) 5)

(define (concatn8 L M)
  {if (null? L) M
      (cons (car L) (concatn8 (cdr L) M))})

(concatn8 '(1 2 3) '(4 5 6))

(define (sqList L)
  (map (lambda (x) (* x x)) L))

(sqList '(1 2 3 4))

(define (sqList2 L)
  (if (null? (cdr L)) (list (* (car L) (car L)))
      (cons (* (car L) (car L)) (sqList2 (cdr L)))))

(sqList2 '(1 2 3 4))


(define (removeAtom a L)
  (cond ((null? L) '())
        ((list? (car L)) (cons (removeAtom a (car L)) (removeAtom a (cdr L))))
        ((eq? (car L) a) (removeAtom a (cdr L)))
        (else (cons (car L) (removeAtom a (cdr L))))))

( removeAtom 'a '( a ( b c ( a ) a ) ( a b ) ) )

(define (deepR L)
  (cond ((null? L) '())
        ((list? (car L)) (append (deepR (cdr L)) (list (deepR (car L)))))
        (else (append (deepR (cdr L)) (list (car L))))))

(deepR '(1 2 (3(6 7) 4) 5))

( define ( deep-reverse L )
( cond ( ( null? L ) '( ) )
( ( list? ( car L ) ) ( append ( deep-reverse ( cdr L ) )
( list ( deep-reverse ( car L ) ) ) ) )
( else ( append ( deep-reverse ( cdr L ) ) ( list ( car L ) ) ) ) ) )

(deep-reverse '(1 2 (3(6 7) 4) 5))
    
(map (lambda (x) (* x x)) '(5 6 7))

(define (fib a b n)
  (if (= 2 n) b
      (fib b (+ a b) (- n 1))))

(fib 1 1 9)

(define (removeif F L)
  (cond ((null? L) '())
        ((F (car L)) (removeif F (cdr L)))
        (else (cons (car L) (removeif F (cdr L))))))

(removeif (lambda (x) (< x 0)) '(1 2 3 -4 5 -6 7))

(define (removeifT F L T)
  (cond ((null? L) T)
        ((F (car L)) (removeifT F (cdr L) T))
        (else (removeifT F (cdr L) (cons (car L) T)))))

(removeifT (lambda (x) (> x 0)) '(1 -2 3 4 -5) '())

(define (addN a)
  (lambda (x) (+ a x)))

((addN 5) 6)

(define (buildS F)
  (lambda (L) (cond ((null? (cdr L)) (list (F (car L)) ))
                    (else (cons (F (car L)) ((buildS F) (cdr L)))))))

((buildS (lambda (x) (* x x))) '(1 2 3 4 5))

(define (remB F)
  (lambda (L) (cond ((null? L) '())
                    ((F (car L)) ((remB F) (cdr L)))
                    (else (cons (car L) ((remB F) (cdr L)))))))

((remB (lambda (x) (< x 0))) '(1 -2 3 4 -5))