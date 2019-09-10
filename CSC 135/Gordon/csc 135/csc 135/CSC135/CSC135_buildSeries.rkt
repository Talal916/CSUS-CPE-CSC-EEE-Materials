;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname CSC135_buildSeries) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #f)))
(define (build a)
  (lambda(x)  ( cond ( (> a 0) (+ x a) )
                     ( (< a 0 )(* x (- 0 a) ) )
                     (else (* x x)))))

(define TEST
  (lambda (x) (( compose (build '5)(compose (build '3) (build '4))) x) ))

;verion 1
(define (MultiCompose L)
   (if (null? (cdr L)) (build (car L))
       (compose (MultiCompose (cdr L)) (build (car L)))))

(define (buildSeries L)
  (lambda (x) ((MultiCompose  L) x)))

(define mylist '(5 0 -4 -2 8))

(define S (buildSeries mylist))


;verion 2
(define (M_Compose f L)
  (if (null? (cdr L)) (f (car L))
      (compose (M_Compose f (cdr L)) (f (car L)))))

(define (buildSeries2 L)
  (lambda (x) ((M_Compose build L)x)))

(define SS (buildSeries2 mylist))


;verion 3
(define (M_Compose2 L)
   (if (null? (cdr L)) (car L)
      (compose (M_Compose2 (cdr L)) (car L))))

(define (buildSeries3 L)
  (lambda (x) ((M_Compose2 (map build L))x)))

(define SSS (buildSeries3 mylist))

  
          
  