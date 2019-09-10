;Talal Jawaid
;CSC 135 Homework #2
;Professor Scott Gordon
;11/5/2018
;Incomplete due to lack of proper understanding of Scheme language syntax 


(define (isEven x)
  (if (= (modulo x 2) 0) #t #f))

(define (allEven n)
  (if (= (modulo n 10) n) isEven(n))
  (if (= (modulo n 2) 0) allEven((/ n 10)))
  (if (not(= ((modulo n 2) 0))) #f)
  #t
  )

(define (allOdd n)
  (if (= (modulo n 10) n) not(isEven(n)))
  (if (not(= (modulo n 2) 0)) allOdd((/ n 10)))
  (if (= (modulo n 2) 0) #f)
  #t
  )

(define (ludicrous n)
  (if (= (modulo n 10) n) #t)
  (if (= (modulo n 2) 0) allEven(n))
  (if (not(= ((modulo n 2) 0))) allOdd(n))
  #f
  )


;________________________________________________________

(define (cappedSum n L) ;cappedSum takes integer and list as its parameters 
  (if(null? L) 0 ;if list is null, return 0
  (if( <  n (car L)) ; else if n < the car of L
     (+ (cappedSum n (cdr L)) n) 
     (+ (cappedSum n (cdr L))
        (car L))))
  )

;___________________________________________________

;(define (reverseShuffle L M) )



;__________________________________



(define (lengthList L)
  (if (empty? L)
      0
      (+ 1 (lengthList (cdr L)))))



;(define (biggestListSize M))


;___________________________________

;(define (functionPairs F L))

;______________________________________

;(define (nestedCappedSum n cappedSum))

;_____________________________________-

;(define (makeExploder L) exploder)

;



;______________________________;_________________
;Scott Gordon Helper Functions beyond this point


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

