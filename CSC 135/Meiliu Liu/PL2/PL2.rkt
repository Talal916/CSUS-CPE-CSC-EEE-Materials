(define (cube n)
  (* n(* n n)))

(define (sphere-volume radius)
  (/ (* 4 (* 3.14 (cube radius))) 3))

(define (shell-volume outer-radius inner-radius)
  ( - (sphere-volume outer-radius)(sphere-volume inner-radius)))





(define (close? number-1 number-2 limit)
  (< (abs (- number-1 number-2)) limit))


(define (how-many a b c)
  (cond
    [(> (disc a b c) 0) 2]
    [(= (disc a b c) 0) 1]
    [(< (disc a b c) 0) 0]))
(define (disc a b c)
  (- (* b b)(* 4 a c)))


(define (filter-out-symbol list symbol)
  (cond ((null? list) '())
        ((eq? symbol (car list))
         (filter-out-symbol (cdr list) symbol))
        (else (cons (car list)
                    (filter-out-symbol (cdr list) symbol)))))



(define (listMin L)
  (cond ((null? (cdr L)) (car L))
        ((<(car L)(listMin (cdr L)))(car L))
        (else (listMin (cdr L)))))
(define (listMax L)
  (cond ((null? (cdr L))(car L))
        ((> (car L)(listMax (cdr L))) (car L))
        (else(listMax( cdr L)))))
(define (pMinMax L)
  (list(listMin L)(listMax L)))


(define (inc_n n)
  (lambda (x)(+ n x)))











