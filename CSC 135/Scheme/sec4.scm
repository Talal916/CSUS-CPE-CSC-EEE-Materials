(define (isEven x)
 (if (= (modulo x 2) 0) #t #f))

(define (sumOfSquares x y)
 (+ (* x x) (* y y)))

(define (factorial x)
 (if (= x 0) 1
	     (* x (factorial (- x 1)))))

(define (last L)
 (if (null? (cdr L)) (car L)
			(last (cdr L))))

(define (appendToList newItem L)z
 (if (null? L) (cons newItem '())
		       (cons (car L) (appendToList newItem(cdr L)))))	
			   
(define (memberofL a)
 (if (null? L) #f
				(if (equal? a (car L)) #t
						 (memberOf	(cdr L) a))))
(define (concatn8 L M)
  (if (null? L) M
      (cons (car L) (concatn8 (cdr L) M))))

(define (mapList f L)
  (if (null? L) '()
      (cons (f (car L)) (mapList f (cdr L)))))

(define (cube x) (* x(* x x)))

(define (negate x) (- 0 x))

(define (composeDef f g)
  (define (h x) (f (g x)))
  h
)

(define (removeBuilder f)
  (define (h L) (if (null? L) L
                   (if (f (car L))(h (cdr L))
                       (cons (car L) (h (cdr L))))))
  h
)

(define (removeBuilder2 f)
  (lambda (L) (removeFromList f L)))

(define (removeFromList f L)
  (if (null? L) L
                (if (f (car L)) (removeFromList f (cdr L))
                    (cons (car L) (removeFromList f (cdr L))))))

