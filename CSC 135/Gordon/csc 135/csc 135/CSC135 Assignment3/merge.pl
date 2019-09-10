   merge(L,[],L).
   merge([],K,K).
   merge([X|L],[Y|K],[X|M]) :- X < Y, merge(L,[Y|K],M).
   merge([X|L],[Y|K],[Y|M]) :- X >= Y, merge([X|L],K,M).