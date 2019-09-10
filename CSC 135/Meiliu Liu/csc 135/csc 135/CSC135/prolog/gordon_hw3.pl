%1. DOGENTHUSIAST --------------------------------------------------

dogEnthusiast(X) :- owner(X,A), breed(A,dog), owner(X,B), breed(B,dog), A\=B,!.

owner(fred,fido).
owner(fred,docky).
breed(fido,dog).
breed(docky,dog).

lastElement([X],X):-!.
lastElement([_|L],X) :- not(L=[]), lastElement(L,X).

noOfElement([X|_],1,X):-!.
noOfElement([_|T],N,X) :- N>1, N1 is N-1, noOfElement(T,N1,X).

listPicker(_,[],[]):-!.
listPicker(L,[S|T],[H|X]) :- noOfElement(L,S,H), listPicker(L,T,X).

num(1).
num(2).
num(3).
num(4).
num(5).
num(6).
num(7).
num(8).
num(9).
num(0).

crypto(G,R,I,P,T,O,C,K) :- num(G), num(R), num(I), num(P), num(T), num(O), num(C), num(K),
                         not(T=O), not(T=C), not(T=K), not(O=C), not(O=K), not(C=K),
                         L1 is T*1000+O*100+C*10+K, LHS is L1*L1,
                         RHS is G*10000000+R*1000000+I*100000+P*10000+L1,
                         LHS=RHS.

interleave([],[],[]):-!.
interleave([],S,[999|S]):-!.
interleave(S,[],[999|S]):-!.
interleave([A|B],[C|D],[A,C|X]) :- interleave(B,D,X).

oneInc(9,0).
oneInc(X,Y) :- X<9, Y is X+1.

digitinc(9,0).
digitinc(X,Y) :- X<9, Y is X+1.
digitinc(X,Y) :- X>=10, R is mod(X,10), D is div(X,10), oneInc(R,R1), digitinc(D,D1), U is D1*10, Y is R1+U.  

listMin([],[],[]).
listMin([A1|A2],[B1|B2],[A1|R2]) :- A1>=B1, listMin(A2,B2,R2).
listMin([A1|A2],[B1|B2],[B1|R2]) :- A1<B1, listMin(A2,B2,R2). 

enjoys(john,jav).
enjoys(john,pornhub).
enjoys(john,thisav).
objectkind(jav, site).
objectkind(pornhub, site).
objectkind(thisav, site).
enjoys(peter,jav).
enjoys(peter,pornhub).
enjoys(peter,jerkoff).
objectkind(jerkoff, sports).



realman(X) :- enjoys(X,A), enjoys(X,B), enjoys(X,C), A\=B, A\=C, C\=B, objectkind(A, site), objectkind(B, site), objectkind(C, site).

  