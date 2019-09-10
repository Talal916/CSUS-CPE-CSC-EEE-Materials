%Amrit Singh
%Dr. Scott Gordon
%CSC-135
%Assignment3 

%----------------A---------------------------------
parent(john, fred).
parent(john, terry).
parent(terry, madge).
parent(fred, luther).
male(john).
male(fred).
male(luther).

%determine whether questioned person is a sibling of the parent of the niece/nephew
uncle(X,Y):-parentsBrother(X,Z), parent(Z,Y), X \=Z.
%determine whe
parentsBrother(X,Y):-male(X),parent(Z,X),parent(Z,Y).


%---------------------------------------------------------------
%----------------B---------------------------------

%base case.
cappedSum(X,[],0):-!.
%else if the "car" of the list is less than or equal to the "cap" then add the contents of the list normally, else swith the greater number with the cap number before adding
cappedSum(X,[Y|Z],A):-cappedSum(X,Z,W),(Y=<X -> A is W + Y ; A is W + X).

%--------------------------------------------------------------
%----------------C---------------------------------
reverseShuffle(L1,L2,R):-reverse(L2,L2r),revershfle(L1,L2r,R).%reverse function takes in list and reverses it. 
revershfle([],[],[]). % base case when lists are empty
%Take the car of each of the respected lists and "shuffle" them
revershfle([H|S1],[I|S2],[H,I|J]):-revershfle(S1,S2,J).

%----------------------------------------------------------------
%----------------D---------------------------------

num(0).
num(1).
num(2). % stating possible values as facts
num(3).
num(4).
num(5).
num(6).
num(7).
num(8).
num(9).

pingpong(P,I,N,G,O) :-  G is 1, num(P), P >= 1, num(I), num(N), num(O), 
			P\=I, P\=N, P\=G, P\=O, I\=N, I\=G, I\=O, N\=G, N\=O, G\=O, 
			P is (N+G) mod 10, 
			A is truncate((N+G)/10), 
			O is (A+I+N) mod 10, 
			B is truncate((A+I+N)/10), 
			N is (B+P+I) mod 10.

%------------------------------------------------------------------
