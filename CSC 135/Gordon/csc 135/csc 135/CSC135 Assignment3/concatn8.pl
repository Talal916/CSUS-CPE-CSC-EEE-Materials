concatn8([],M,M).
concatn8([H|X], M, [H|T) :- concatn8(X,M,T).