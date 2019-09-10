/*uncle(U,N) :- male(U), parent */

/* first statement makes sure U is male
	next statement calls brotherOf to make sure U is brother of father of N (S)
		-implies that male sibling of S is uncle of N
*/


uncle(U, N) :- male(U), brotherOf(U,S), parent(S,N).

/*
brotherOf
both statements ensure that U and S are from same parent
 last statement ensures that U and S aren't the same person
*/
brotherOf(U,S) :- parent(G,U), parent(G,S), U \= S.


%-----------------------------------------------------------------------


%base case 
cappedSum(S,[],0).
/* cappedSum implementation translated from scheme assignment */
cappedSum(S,[A|B],Z):-
	cappedSum(S,B,C),
	(A=< S -> Z is C + A; Z is C + S).


%--------------------------------------------

%base case
rHelp([],[],[]). 
/* reverseshuffle implementation translated from scheme assignment */
reverseShuffle(A,B,R):-
reverse(B,REVERSED),
rHelp(A,REVERSED,R).

rHelp([W|X],[Z|Y],[W,Z|J]):-
rHelp(X,Y,J).


%-----------------------------------------------------------------------


/* Created with guidance from Scott Gordon's notes and hints on assignment page */
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

pingpong(P,I,N,G,O) :- 	

	G is 1,

num(P),

P >= 1, 

num(I),

num(N),

num(O),
 


 /*
Ensuring that none of the variables are the same


 */
P\=I,
P\=N,
P\=G,
P\=O,
I\=N,
I\=G,
I\=O,
N\=G,
N\=O,
G\=O,

P is (N+G) mod 10,

A1 is truncate((N+G)/10),

O is (A1+I+N) mod 10,

A2 is truncate((A1+I+N)/10),

N is (A2+P+I) mod 10.

%------------------------------------------------

