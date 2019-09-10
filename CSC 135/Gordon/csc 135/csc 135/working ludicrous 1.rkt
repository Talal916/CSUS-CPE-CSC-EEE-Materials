(define (isEven x)
  (if (= (modulo x 2) 0) #t #f))

(define (allEven n )
  (cond
    [(= (modulo n 10) n) (isEven n)]
    [(= (modulo n 2) 0) (allEven(/ n 10))]
    [(not(= (modulo n 2) 0)) #f]
    [else #t]))

(define (allOdd n)
  (cond
    [(= (modulo n 10) n) (not(isEven n))]
    [(not(= (modulo n 2) 0)) (allOdd (/ n 10))]
    [(= (modulo n 2) 0) #f]
    [else #f]))

(define (ludicrous n)
  (cond
    [(= (modulo n 10) n) #t]
    [(= (modulo n 2) 0) (allEven n)]
    [(not(= (modulo n 2) 0)) (allOdd n)]
    [else #f]))
