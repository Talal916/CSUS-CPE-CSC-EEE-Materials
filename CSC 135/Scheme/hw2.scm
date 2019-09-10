(define (isEven x)
  (if (= (modulo x 2) 0) #t #f))

(define (allEven n)
  (if (= (modulo n 10) n) isEven(n))
  (if (= (modulo n 2) 0) allEven((/ n 10)))
  (if (= (not((modulo n 2) 0))) #f)
  #t
  )

(define (allOdd n)
  (if (= (modulo n 10) n) not(isEven(n)))
  (if (= not((modulo n 2) 0)) allOdd((/ n 10)))
  (if (= (modulo n 2) 0) #f)
  #t
  )

(define (ludicrous n)
  (if (= (modulo n 10) n) #t)
  (if (= (modulo n 2) 0) allEven(n))
  (if (= ((not(modulo n 2) 0))) allOdd(n))
  #f
  )

