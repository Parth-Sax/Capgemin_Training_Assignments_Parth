CREATE DATABASE capgemini;
USE capgemini;
DROP TABLE IF EXISTS emp;

CREATE TABLE emp (
  empno decimal(4,0) NOT NULL,
  ename varchar(10) default NULL,
  job varchar(9) default NULL,
  mgr decimal(4,0) default NULL,
  hiredate date default NULL,
  sal decimal(7,2) default NULL,
  comm decimal(7,2) default NULL,
  deptno decimal(2,0) default NULL
);

DROP TABLE IF EXISTS dept;

CREATE TABLE dept (
  deptno decimal(2,0) default NULL,
  dname varchar(14) default NULL,
  loc varchar(13) default NULL
);

INSERT INTO emp VALUES ('7369','SMITH','CLERK','7902','1980-12-17','800.00',NULL,'20');
INSERT INTO emp VALUES ('7499','ALLEN','SALESMAN','7698','1981-02-20','1600.00','300.00','30');
INSERT INTO emp VALUES ('7521','WARD','SALESMAN','7698','1981-02-22','1250.00','500.00','30');
INSERT INTO emp VALUES ('7566','JONES','MANAGER','7839','1981-04-02','2975.00',NULL,'20');
INSERT INTO emp VALUES ('7654','MARTIN','SALESMAN','7698','1981-09-28','1250.00','1400.00','30');
INSERT INTO emp VALUES ('7698','BLAKE','MANAGER','7839','1981-05-01','2850.00',NULL,'30');
INSERT INTO emp VALUES ('7782','CLARK','MANAGER','7839','1981-06-09','2450.00',NULL,'10');
INSERT INTO emp VALUES ('7788','SCOTT','ANALYST','7566','1982-12-09','3000.00',NULL,'20');
INSERT INTO emp VALUES ('7839','KING','PRESIDENT',NULL,'1981-11-17','5000.00',NULL,'10');
INSERT INTO emp VALUES ('7844','TURNER','SALESMAN','7698','1981-09-08','1500.00','0.00','30');
INSERT INTO emp VALUES ('7876','ADAMS','CLERK','7788','1983-01-12','1100.00',NULL,'20');
INSERT INTO emp VALUES ('7900','JAMES','CLERK','7698','1981-12-03','950.00',NULL,'30');
INSERT INTO emp VALUES ('7902','FORD','ANALYST','7566','1981-12-03','3000.00',NULL,'20');
INSERT INTO emp VALUES ('7934','MILLER','CLERK','7782','1982-01-23','1300.00',NULL,'10');

INSERT INTO dept VALUES ('10','ACCOUNTING','NEW YORK');
INSERT INTO dept VALUES ('20','RESEARCH','DALLAS');
INSERT INTO dept VALUES ('30','SALES','CHICAGO');
INSERT INTO dept VALUES ('40','OPERATIONS','BOSTON');

SELECT ename
FROM emp;

SELECT ename, sal
FROM emp;

SELECT sal 
FROM emp;

-- display salary of employees without duplicates
SELECT DISTINCT sal
FROM emp;

--  display employee name , salary without duplicates ??
SELECT DISTINCT ename, sal
FROM emp;

-- display salary of employees with bonus of 1000 rupees
SELECT sal+1000
FROM emp;

-- display employee name , salary and annual salary of employees ??
SELECT ename, sal, sal*12
FROM emp;

-- dsipaly employee name, salary with hike of 10% ??
SELECT ename, sal*1.1
FROM emp;

-- display employee name , salary with deduction of 10% ??
SELECT ename, sal, sal-(sal*0.1)
FROM emp;

-- AS(alias)
SELECT sal AS salary , comm AS commission
FROM emp;

SELECT ename, sal+1000 AS Bonus
FROM emp;

SELECT ename, sal, sal+sal*0.1 AS Hike
FROM emp;

SELECT sal AS "Monthly salary", sal*12 Annual_Salary
FROM emp;

-- WAQTD name and salary with monthly hike of 50?
SELECT ename, sal+50 AS hike
FROM emp;

-- WAQTD name and salary with deduction of 10% ??
SELECT ename , (sal*12)*0.9 AS annual_deduction
FROM emp;

-- WAQTD total salary given to each employee(sal + comm)
SELECT sal+comm AS total_salary
FROM emp;

-- WAQTD details of all the employees along with annual salary??
SELECT *, sal*12 AS annual_salary
FROM emp;

-- WAQTD name and designation along with 100 penalty in salary??
SELECT ename, job, sal-100 AS penalty
FROM emp;

-- WAQTD employee name , dept. number of employees working in dept. number 20??
SELECT ename, deptno
FROM emp
WHERE deptno = 20;

-- display name and salary of employees who are earning more than 2000??
SELECT ename, sal
FROM emp
WHERE sal > 2000;

 -- display the details of employess who are working as manager??
 SELECT *
 FROM emp
 WHERE job = 'Manager';
 
 --  display name and hiredate of employees who are hired after 1981??
 SELECT ename, hiredate
 FROM emp
 WHERE hiredate>'1981-12-31';
 
 -- WAQTD name and salary and annual salary of employees if annual salary is more than 12000?
 SELECT ename, sal, sal*12 AS annual_salary
 FROM emp
 WHERE sal*12 > 12000;

-- concat() function
SELECT concat('Mr ', Ename) AS employee_name
FROM emp;
 
SELECT concat(ename, ' is working as ', job, ' and earning salary of ', sal)
FROM emp
WHERE ename = 'Smith';

-- display the datils of employees working in deptno 20 and earning salary more than 2000
SELECT *
FROM emp
WHERE deptno = 20 AND sal>2000;

-- display name and deptno of employees who are working in deptno 10,20  ??
SELECT *
FROM emp
WHERE deptno = 10 OR deptno = 20; 

-- display the details of employees who are earning more than 2000 in deptno 10, 20 ??
SELECT *
FROM emp
WHERE sal>2000 AND (deptno = 10 OR deptno = 20); 

-- display details of employees who are not working as salesman and analyst??
SELECT *
FROM emp
WHERE job != 'SALESMAN' AND job != 'ANALYST';
-- WHERE NOT (job='SALESMAN OR job='ANALYST');
-- WHERE NOT job = 'SALESMAN' AND NOT job = 'ANALYST';

-- IN 
SELECT ename, deptno
FROM emp
WHERE deptno IN (10,20);

SELECT ename, deptno
FROM emp
WHERE deptno NOT IN (10, 20);

-- display name and salary of employees who are earning salary in the range of 1000 to 3000 ??
SELECT ename, sal
FROM emp
WHERE sal BETWEEN 1000 and 3000;

-- display the details of employees who are hired in the year of 1981???
SELECT *
FROM emp
WHERE hiredate BETWEEN '1981-01-01' AND '1981-12-31';

-- display the details of employees who are not earning salary in the range of 1000 to 3000??
SELECT *
FROM emp
WHERE sal NOT BETWEEN 1000 and 3000;

-- display details of employees who are not earning commission?
SELECT *
FROM emp
WHERE comm IS null;

--
SELECT *
FROM emp
WHERE comm IS NOT null;

-- display the details of emp who are earning salary but not commission??
SELECT *
FROM emp
WHERE sal IS NOT null AND comm IS null;

-- LIKE  display names of employees whose name starts with S ?
SELECT *
FROM emp
WHERE ename LIKE 'S&';

-- display names of employees whose names consist of char 'A' ?
SELECT *
FROM emp
WHERE ename LIKE '%A%';

-- display details of employees whose name consists of character 'A' two times?
SELECT *
FROM emp
WHERE ename LIKE '%A%A%';

-- display details of emp whose names consists of exactly 2 'A'?
SELECT *
FROM emp
WHERE ename LIKE '%A%A%' AND ename NOT LIKE '%A%A%A%';

-- display name and salary of employee who are earning 4 digits of salary?

-- display details of employees who are hired in the month of feb??
SELECT *
FROM emp
WHERE hiredate LIKE '____-02-__';

-- display emp names which does not start with 'S'?
SELECT ename
FROM emp
WHERE ename NOT LIKE 'S%';

-- display the names of employees whose names starts with 'A' or 'S' ?
SELECT ename 
FROM emp 
WHERE ename LIKE 'A%' OR ename LIKE 'S%';

-- names start with vowels 
SELECT ename 
FROM emp 
WHERE ename LIKE 'A%' OR ename LIKE 'E%' OR ename LIKE 'I%' OR ename LIKE 'O%' OR ename LIKE 'U%';

-- display the details whose names starts with consonents and ends with vowels??
SELECT ename 
FROM emp 
WHERE (ename NOT LIKE 'A%' AND
      ename NOT LIKE 'E%' AND 
      ename NOT LIKE 'I%' AND
      ename NOT LIKE 'O%' AND 
      ename LIKE 'U%') AND 
      (ename LIKE '%A' AND
      ename LIKE '%E' AND 
      ename LIKE '%I' AND
      ename LIKE '%O' AND 
      ename LIKE '%U');

SELECT * 
FROM emp;
      
-- 1)
SELECT ename
FROM emp
WHERE deptno = 10 AND mgr IS NOT null;

-- 2)
SELECT  ename
FROM emp
WHERE comm IS null AND job = 'CLERK';

-- 3)
SELECT ename
FROM emp
WHERE (mgr IS null AND deptno = 10) OR (mgr IS null AND deptno = 30);

-- 4)
SELECT * 
FROM emp
WHERE ename LIKE 'J%S';

-- 5)
SELECT *
FROM emp
WHERE sal LIKE '____.%';

-- 6)
SELECT *
FROM emp
WHERE ename LIKE '_____';

-- 7) 
SELECT ename, hiredate
FROM emp
WHERE hiredate LIKE '1982-__-01';

-- 8)
SELECT ename
FROM emp
WHERE ename LIKE 'A____A';

-- 9)
SELECT ename, job 
FROM emp
WHERE job LIKE 'MAN%';

-- 10)
SELECT ename 
FROM emp 
WHERE ename LIKE '%S';

-- 11)
SELECT *
FROM emp
WHERE job = 'ANALYST' AND sal LIKE '____.%';

-- 12)
SELECT ename 
FROM emp
WHERE hiredate LIKE '%-01-%';

-- 13)
SELECT *
FROM emp
WHERE ename LIKE '%L%L%' AND job ='manager';

-- 14)
SELECT ename
FROM emp
WHERE ename LIKE 'A%' OR ename LIKE 'J%' OR ename LIKE 'S%';

-- 15)
SELECT ename
FROM emp
WHERE ename NOT LIKE '__A%';

SELECT * FROM emp;

-- FUNCTIONS

SELECT LENGTH(ename)
FROM emp;

SELECT 'hello world';

SELECT ename, length(ename) AS length
FROM emp;

-- display the names of  emp whose name is of exactly 4 characters without LIKE operator
SELECT ename
FROM emp
WHERE length(ename) = 4;

-- display the details of emp whose name is more than 4 characters but less than 7 chars?
SELECT *
FROM emp
WHERE length(ename) > 4 AND length(ename) < 7;

SELECT Lower('SMITH')
FROM emp;

-- substr()
SELECT substr('QSPIDERS', 2, 3)
SELECT substr('QSPIDERS', -7, 1);
SELECT substr('QSPIDERS', -8);
SELECT substr('QSPIDERS', -3, 1);
SELECT substr(ename, 4, 1)
FROM emp;

-- position()
SELECT locate('a', 'malayalam', 3);

SELECT substr('malayalam hindi', position(' ' in 'malayalam hindi')+1);

-- extract '@gmail.com' from the gmail id
SELECT substr('parthsaxena182512@gmail.com', position('@' in 'parthsaxena182512@gmail.com'));

-- extract string before '@gmail.com' from the gmail id
SELECT substr('parthsaxena182512@gmail.com', 1, position('@' in 'parthsaxena182512@gmail.com')-1);

-- date functions()
SELECT current_date();
SELECT year(now()); -- Mysql
SELECT minute(now()); -- Mysql

SELECT extract(year from now()); -- postgre
SELECT extract(month from now()); -- postgre
SELECT extract(day from now()); -- postgre
SELECT extract(hour from now()); -- postgre
SELECT extract(minute from now()); -- postgre
SELECT extract(second from now()); -- postgre

-- retrieve all the emp who are hired on friday -- only for postgre
SELECT *, to_char(hiredate, 'day') AS day
FROM emp
WHERE to_char(hiredate, 'd') = 'fri';

-- retrive all the emp who are hired in december ??
SELECT *, to_char(hiredate, 'mon') AS month
FROM emp
WHERE to_char(hiredate, 'mon') = 'dec';

where hiredate :: text like '____-12-__';

-- retrieve all the emp who are hired in 1981 ??
SELECT *, to_char(hiredate, 'yyyy')
FROM emp
WHERE 

-- display the details of emp who are hired in the month of march , april, may ??
SELECT *, to_char(hiredate, 'mon') AS month
FROM emp
WHERE to_char(hiredate, 'mon') = 'mar' OR to_char(hiredate, 'mon') = 'apr' OR to_char(hiredate, 'mon') = 'may';

-- display the details of emp who are hired on 1981 in the month of feb, dec, apr on wednesday and friday ?? -- ONLY IN Postgre
SELECT *
FROM emp
WHERE EXTRACT(YEAR FROM hiredate) = 1981
AND EXTRACT(MONTH FROM hiredate) IN (2, 4, 12)
AND TO_CHAR(hiredate, 'Day') IN ('Wednesday', 'Friday');
-- OR 
SELECT *
FROM emp
WHERE to_char(hiredate, 'yyyy') AS year

-- INTERVAL()
SELECT * 
FROM emp
WHERE hiredate > current_date - INTERVAL 2 year;

-- timestampdiff() / age()
SELECT EXTRACT(year FROM timestampdiff(current_date, '2025-01-01'));

-- retrieve the employees who are having 10 years of experience??
SELECT *
FROM emp
WHERE extract(year FROM age(current_date, hiredate)) >= 10;

-- COALESCE()
SELECT ename, sal, comm, sal + COALESCE(comm, 0) AS total_sal
FROM emp;

SELECT max(sal)
FROM emp;

SELECT ename
FROM emp
WHERE sal = (SELECT max(sal) FROM emp);

SELECT count(comm)
FROM emp;

SELECT count(*)
FROM emp;

-- display no. of employees whose name connsist of character 'a'
SELECT count(ename) AS no_of_times
FROM emp
WHERE ename LIKE '%A%';

-- display max salary, min sal and avg sal of all the employeesworking in deptno 20?
SELECT max(sal) AS maximum, min(sal) AS minimum, avg(sal) AS average
FROM emp
WHERE deptno = 20;

-- display no of emp and total sal of all the emp who is earning more than 1700 ?
SELECT count(*) AS number, sum(sal) AS total
FROM emp
WHERE sal > 1700;

-- GROUP BY
SELECT count(*) AS no_of_employees, deptno
FROM emp
GROUP BY deptno;

-- display nof employees ineach dept but their sal is more than 2000?
SELECT count(ename) AS no_of_emp, deptno
FROM emp
WHERE sal > 2000
GROUP BY deptno;

-- display max sal given to an emp in each designation??
SELECT max(sal) AS maximum, min(sal) AS minimum, job
FROM emp
GROUP BY job;

-- display no of times salaries are repeated in emp table??
SELECT count(sal) AS count, sal
FROM emp
GROUP BY sal;

-- display avg sal given to the emp in each job
SELECT avg(sal) AS average, job
FROM emp
GROUP BY job;

-- display no of emp earning comm in each dept
SELECT count(comm) AS no_of_emp, deptno
FROM emp
GROUP BY deptno;

-- display no  of emp in each dept only if there are at least 4 emp?
SELECT count(), deptno

-- display no of emp in each dept having at least 2 emp in it, and there name consist of char 'A' or 'S'?
SELECT count(*), deptno
FROM emp
WHERE ename LIKE '%A%' OR ename LIKE '%S%'
GROUP BY deptno
HAVING count(*) >= 4; 

-- display the sal which are repeated in emp table?
SELECT count(sal), sal
FROM emp
GROUP BY sal
HAVING count(*)>=2;

-- display job and total sal of each job , if the total sal of each job is more than 9500?
SELECT sum(sal), job
FROM emp
GROUP BY job
HAVING sum(sal)>9500;

-- calculate the avg sal of all emp and display it only if the avg exceeds 55000
SELECT avg(sal)
FROM emp
HAVING avg(sal)>55000;

-- 1)
SELECT count(*), job
FROM emp
WHERE sal>1200
GROUP BY job
HAVING sum(sal) > 3800;

-- 2)
SELECT max(sal), job 
FROM emp
GROUP BY job
HAVING max(sal) > 2600;

-- 3)
SELECT count(hiredate), hiredate
FROM emp
GROUP BY hiredate
HAVING count(hiredate)>=2;

-- 4) 
SELECT min(sal), max(sal), job
FROM emp
GROUP BY job
HAVING min(sal)>100 AND max(sal)<5000;

-- 5)
SELECT count(*), deptno
FROM emp
WHERE job = 'Manager'
GROUP BY deptno
HAVING count(*) = 2;

-- diplay no of times sal are repeated and arrange the count in desc order??
SELECT count(sal) AS no_of_times, sal
FROM emp
GROUP BY sal
ORDER BY no_of_times DESC;

-- display the details of emp who is earning sal more than allen
SElECT * 
FROM emp 
WHERE sal>(SELECT sal FROM emp WHERE ename = 'Allan');

