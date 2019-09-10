% ----- A -----

uncle(U,N) :- male(U), parent(G,U), parent(G,P), parent(P,N), P\=U.

% ----- B -----

cappedSum(C,[X],X) :- C >= X.
cappedSum(C,[X],C) :- C < X.
cappedSum(C,[X|[Y|Z]],S) :- C >= X, cappedSum(C,[Y|Z],T), S is X+T.
cappedSum(C,[X|[Y|Z]],S) :- C < X, cappedSum(C,[Y|Z],T), S is C+T.

% ----- C -----

reverseList([],[]).
reverseList([X|Y],R) :- reverseList(Y,Q), appendList(X,Q,R).

appendList(E,[],[E]).
appendList(E,[X|Y],[X|Z]) :- appendList(E,Y,Z).

forwardShuffle([],[],[]).
forwardShuffle([X|L],[Y|M],[X|[Y|F]]) :- forwardShuffle(L,M,F).

reverseShuffle(L,M,S) :- reverseList(M,R), forwardShuffle(L,R,S).

% ----- D -----

digit(0). digit(1). digit(2). digit(3). digit(4).
digit(5). digit(6). digit(7). digit(8). digit(9).

pingpong(P,I,N,G,O) :-
  digit(P), digit(I), digit(N), digit(G), digit(O),
  P\=I, P\=N, P\=G, P\=O, I\=N, I\=G, I\=O, N\=G, N\=O, G\=O,
  PIN is P*100 + I*10 + N,
  ING is I*100 + N*10 + G,
  SUM is PIN + ING,
  GNOP is G*1000 + N*100 + O*10 + P,
  SUM = GNOP.

