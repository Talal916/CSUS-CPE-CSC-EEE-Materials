create table Candidate 

(
  Candidate_id NUMBER PRIMARY KEY,
  First_name VARCHAR(20),
  Last_name VARCHAR(20),
  CONSTRAINT candidate_fname_lname_uk UNIQUE(first_name,last_name),
  DOB date,
  Salary NUMBER,
  CHECK (salary>10000 AND salary<50000),
  party_id NUMBER,
  foreign key(party_id) references party on delete cascade,
  constraint candidate_party_id_fk FOREIGN key(party_id)
  REFERENCES party
);
  
create table Party
(

 party_id NUMBER primary key,
 partyDesc varchar(20) unique
 
);