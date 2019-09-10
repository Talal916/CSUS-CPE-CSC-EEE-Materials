DROP TABLE flore_student;
DROP TABLE flore_class;

CREATE TABLE flore_student
(
    ssn     VARCHAR2(20),
    lname   VARCHAR2(20),
    fname   VARCHAR2(20),
    age     NUMBER,
    salary  NUMBER,
    dob     NUMBER,
    CONSTRAINT flore_student_ssn_pk PRIMARY KEY (ssn)
); 

ALTER TABLE flore_student ADD UNIQUE (fname, lname);

ALTER TABLE flore_student MODIFY age CONSTRAINT flore_student_age_ck CHECK (age<10 AND age>50);

ALTER TABLE flore_student ADD address VARCHAR2(20);

ALTER TABLE flore_student MODIFY dob DATE NOT NULL;

CREATE INDEX flore_student_ssn_dob_idx ON flore_student (ssn, dob);

ALTER TABLE flore_student ADD transferable CHAR;
ALTER TABLE flore_student MODIFY transferable CHAR NOT NULL;

ALTER TABLE flore_student MODIFY transferable CONSTRAINT flore_student_transferable_ck CHECK
(transferable = 'y' or transferable = 'Y' or transferable = 'n' or transferable = 'N');  

ALTER TABLE flore_student DROP (age);

CREATE TABLE flore_class
(
  code        NUMBER,
  description VARCHAR2(100) NOT NULL,
  CONSTRAINT flore_class_description_uk UNIQUE (description)
);

ALTER TABLE flore_class ADD PRIMARY KEY (code);

/*CREATE INDEX flore_class_decription_idx ON flore_class (description);*/

CREATE TABLE flore_student_class
(
  ssn  NUMBER;
  code NUMBER;
);
