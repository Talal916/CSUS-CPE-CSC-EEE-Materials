ALTER tABLE cANDIDATE ADD CONSTRAINT SALARY_ck CHECK(salary>10000 AND salary <50000);

desc candidate;

SELECT *
  FROM user_cons_columns
 WHERE table_name = 'CANDIDATE';
 
 Alter table party modify partyDesc not null;
 
 desc party;
 
 ALTER Table Candidate DISABLE CONSTRAINT Salary_ck;
 
 ALTER table party ADD CONSTRAINT party_partyid_fk FOREIGN Key(partyID) references candidate;