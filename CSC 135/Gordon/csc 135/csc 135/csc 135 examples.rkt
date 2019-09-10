(define (factorial x)
 (if (= x 0) 1
 (* x (factorial (- x 1)))))

(define (isEven x)
 (= (modulo x 2) 0))

(define (lastElement L)
  (if (null? (cdr L)) (car L)
      (lastElement (cdr L))))

(define (maps f L)
  (if (null? L) '()
      (cons (f (car L)) (maps f (cdr L)))))
(define (cube x) (* x(* x x)))
(define (negate x) (- 0 x))

(define (composeDef f g)
  (define (h x) (f (g x)))
  h
)

(define (removeBuilder f)
  (define (h  L) (if (null? L) '()
                     (if (f (car L)) (h (cdr L))
                         (cons (car L) (h (cdr L))))))
 h
)