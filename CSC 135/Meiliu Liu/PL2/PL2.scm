(define (sphere-volume radius)
  (/ (* 4 (* 3.14 (cube radius))) 3))

(define (shell-volume inner-radius outer-radius)
  ( - (sphere-volume outer-radius)(sphere-volume inner-radius)))
