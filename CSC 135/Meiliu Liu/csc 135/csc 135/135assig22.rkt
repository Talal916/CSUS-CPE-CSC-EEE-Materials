(define (last L)
 (if (null? (cdr L)) (car L)
			(last (cdr L))))

(define (removeLastElement L)
  (if (null? (cdr L)) null
      (cons (car L) (removeLastElement (cdr L))))) 

(define (reverseShuffle L M)
  (if (null? M) L
      (if (null? L) M
          (if (>= (length L) (length M)) (cons (car L) (reverseShuffle (cdr L) M))
              (if(<(length L) (length M)) (cons (last M) (reverseShuffle L (removeLastElement M))))))))

(define (reverseShuffle2 L M)
  (if (null? M) L
      (if (null? L) M
          (cons (car L) (reverseShuffle2 (cdr L) M)))))

(define (reverseShuffle3 L M)
  (if (null? M) L
      (if (null? L) M
          (cons (last M) (reverseShuffle3 ((car L) (removeLastElement M)))))))

(define (getLength List)
 (if (null? List) 0
  (+ 1 (getLength (cdr List))))
)

(define(cappedSum I L) ; takes in an integer I and a list L
        (if (null? L) 0 ; if the list is null (empty)return 0
            (if( < I (car L)) (+ (car L)(cappedSum I (cdr L))); if integer < all elements in the list it will add the elements
               (+ I (cappedSum I (cdr L)))))); if there are numbers greater than I, I willl be added in place of those integers.

(define (countListElements L) ; this function counts the number of items in a list
  (if(null? L) 0              ; if the list is null the amount of elements = to 0
      (+ 1 (countListElements(cdr L) )))) ; else +1 for each element

(define (biggestListSize L)
  (if( empty? L) 0)
  (if (empty? (cdr L)) (countListElements(car L))
      (if (< (countListElements(car L)) (countListElements(car (cdr L)))) (biggestListSize (cdr L))
          (biggestListSize (cons (car L) (cdr(cdr L)))))))

