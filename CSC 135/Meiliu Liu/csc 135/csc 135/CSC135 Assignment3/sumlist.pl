


sumlist([],0).
sumlist([X|L],N) :- sumlist(L,M), N is M+X.

