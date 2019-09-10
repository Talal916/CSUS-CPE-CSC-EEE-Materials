drop sequence salary;
drop table candidate;
drop table party;


Create sequence salary start with 20000 increment by 10000;

create table party
  (
    partyid number primary key,
    partydesc varchar2(20)
  );

insert into party
values(1,'Democrat');

insert into party
values(2,'Republican');

insert into party
values(3,'Independent');

insert into party
values(4,'');


create table candidate
  (
  lname varchar(40)  not null,
  fname varchar(20)  not null,
  address	varchar(20),
  salary number,
  dob	date,
  partyid number references party
);


insert into candidate
values('jennet', 'abraham', 'Berkeley, CA.', salary.nextval, '01 feb 1960',1);

insert into candidate
values ( 'Green', 'abraham', 'Oakland, CA.',salary.nextval, '01 feb 1964',1 );

insert into candidate
values('gren', 'cheryl','Berkeley, CA.',null,'01 feb 1968',2 );

insert into candidate
values('greeenr', 'albert', 'Salt Lake City, UT', salary.nextval, '01 feb 1970',2);

insert into candidate
values('gran', 'anne', 'Salt Lake City, UT', salary.nextval, '01 feb 1961',3 );


insert into candidate
values('mama', 'mia', 'pepper City, UT', salary.nextval, '01 feb 1968',null );
commit;

