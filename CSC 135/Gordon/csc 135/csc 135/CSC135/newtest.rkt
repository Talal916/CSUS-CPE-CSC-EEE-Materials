;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname newtest) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #f)))
(define (concatL L M)
  (if (null? L) '()
      (cons (string-append (car L) (car M)) (concatL (cdr L) (cdr M)))))

(concatL '("aa" "bb") '("11" "22"))

(define (buildList N E)
  (if (= N 0) '()
      (cons E (buildList (- N 1) E))))

(buildList 5 'a)



(define (selectN N)
  (lambda (L)
    (if (= N 0) L
        ((selectN (- N 1)) (cdr L)))))

((selectN 3) '(1 2 3 4 5))

(define (atom? X)
  (not (list? X)))

(define (compstructlist M L)
  (cond ((or (null? M) (null? L)) (and (null? M) (null? L)))
        ((or (atom? (car M)) (atom? (car L))) (and (and (atom? (car M)) (atom? (car L))) (compstructlist (cdr M) (cdr L))))
        (else (and (compstructlist (car M) (car L)) (compstructlist (cdr M) (cdr L))))))


(compstructlist '( (a b ) c ( ( d ) f ( g ) ) ) '( (x y ) z ( ( u )  r t ( w ) ) ))

(define (RR L)
  (if (null? L) '()
      (append (RR (cdr L)) (list(car L)))))

(RR '(1 (2 3) 4))

(define (DRR L)
  (cond ((null? L) '())
        ((list? (car L)) (append (DRR (cdr L)) (list (DRR (car L)))))
        (else (append (DRR (cdr L)) (list (car L))))))

(DRR '(1 (2 3) 4))

(define (depth L)
  (cond ((null? L) 0)
        ((atom? L) 0)
        (else (max (+ 1 (depth (car L))) (depth (cdr L))))))

(depth '( a (b) (c)))

(depth '( ( a ) ( b ( c ) ) ))

(depth '(()(((a)))))

(depth '( ( a ) b ( c ) d ))