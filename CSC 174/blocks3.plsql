-- First illustration of PL/SQL DBMS_OUTPUT package & Oracle table access
-- Revision history
--	Apr 2010 . Added doc. for SELECT into statement
--	Mar 06	. Redocument Usage and add compile directive (/)
--		. Debugging note: to_char(v_lname) was illegal to_char call
--	Oct 03, v1
-- 	Usage:	For results display, set serveroutput on and 
--		Execute via: @blocks3.plsql

set serveroutput ON

DECLARE
v_lname		mitchell.employee.lname%TYPE;

BEGIN

-- Limitation of code: ONE result row interacting with PL/SQL variables
--  Multiple result rows cannot be assigned to one PL/SQL scalar variable
SELECT lname
INTO v_lname
FROM mitchell.employee
WHERE ssn > '333445555';
DBMS_OUTPUT.PUT_LINE ('LAST NAME of SSN 333445555 is: ' || v_lname);

END;
/
show errors
