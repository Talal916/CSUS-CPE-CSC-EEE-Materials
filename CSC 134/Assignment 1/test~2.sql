ALTER table candidate add CONSTRAINT candidate_partyID_fk FOREIGN KEY (candidateID)  REFERENCES candidate(candidateID);

desc party;

 ALTER Table Party DISABLE CONSTRAINT party_candidateID_fk;

desc party;