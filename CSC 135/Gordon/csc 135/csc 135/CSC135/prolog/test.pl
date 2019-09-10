fac(0,1).
fac(N,R) :- N1 is N-1, fac(N1,R1), R is N*R1.

listMin([],[],[]).
listMin([H1|T1], [H2|T2], [H1|T3]) :- H1<H2, listMin(T1,T2,T3).
listMin([H1|T1], [H2|T2], [H2|T3]) :- H1>=H2, listMin(T1,T2,T3).

one(9,0).
one(X,R) :- X<9, R is X+1.

digitinc(X,R) :- X<10, one(X,R).
digitinc(N,R) :- Z is mod(N,10), one(Z,Z1), N1 is div(N,10), digitinc(N1,R1), R is R1*10+Z1.  