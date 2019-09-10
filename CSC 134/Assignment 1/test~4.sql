desc Candidate;

alter table candidate ADD PartyID  NUMBER;

Alter table candidate add constraint candidate_partyID_fk foreign key(partyID) references Party;

desc candidate;

alter table candidate disable constraint candidate_partyID_fk;

alter table candidate DROP constraint candidate_partyID_fk;

drop table candidate;
drop table party;