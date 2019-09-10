CSC 135 Homework #3
Cameron Li
----------------------A----------------------
brother(X,Y) :- male(X), parent(Z,X), parent(Z,Y).

uncle(X,Y) :- brother(X,Z), parent(Z,Y).


----------------------B----------------------
cappedSum(C,[],0).
cappedSum(C,[H|T],S) :- cappedSum(C,T,Sum1),
(H>C -> S is Sum1 + C; S is Sum1 + H).


----------------------C----------------------
reverseShuffle(AList,BList,Sol):- reverse(BList, Rev_BList), 
				 shuffle(AList, Rev_BList, Sol).
shuffle([], [], []).
shuffle([X|Xs], [Y|Ys], [X,Y|Zs]):- shuffle(Xs,Ys,Zs).

#

----------------------D----------------------
value(1).
value(2).
value(3).
value(4).
value(5).
value(6).
value(7).
value(8).
value(9).
value(0).

pingpong(P,I,N,G,O) :- 	
	G is 1,
value(P),
P >= 1, 
value(I),
value(N),
value(O),
P\=I, P\=N, P\=G, P\=O,
I\=N, I\=G, I\=O,
N\=G, N\=O, 
G\=O,
P is (N+G) mod 10,
A1 is truncate((N+G)/10),
O is (A1+I+N) mod 10,
A2 is truncate((A1+I+N)/10),
N is (A2+P+I) mod 10.

