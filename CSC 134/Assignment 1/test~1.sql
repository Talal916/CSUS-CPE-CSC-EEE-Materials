desc candidate;
desc party;

 ALTER table party ADD CONSTRAINT party_partyid_fk FOREIGN Key(CandidateID) references candidate;
 
 
ALTER table party DROP Constraint party_partyid_fk;
