-- 주석
SELECT *FROM emp; -- 전체 테이블생성
SELECT empno, ename,deptno,sal FROM emp;

SELECT empno, ename, hiredate,deptno 
	FROM emp 
	WHERE deptno = 10;
    
SELECT empno, ename, deptno, job 
	FROM emp 
	WHERE job = 'SALESMAN' ;
    
SELECT empno, ename, sal, hiredate
	FROM emp 
	WHERE empno >= 1500 ; 
    
SELECT empno, ename, hiredate, deptno
	FROM emp
    WHERE DATE_FORMAT(hiredate, '%Y') = '1981';
    
    -- 원하는 날짜
SELECT empno, ename, hiredate, deptno
	FROM emp
  	WHERE hiredate >='1981-01-01'
	AND hiredate<='1981-12-31';
    
SELECT empno, ename, hiredate, deptno
	FROM emp
	WHERE deptno=10
  	AND  hiredate >='1981-01-01'
	AND hiredate<='1981-12-31';
    
    -- 내림차순 정렬
SELECT empno, ename, hiredate, deptno
	FROM emp
  	WHERE hiredate>='1981-01-01'
	AND hiredate<='1981-12-31'
    ORDER BY hiredate aSC; -- acs ,desc 생략하면 자동 오름차순
    
-- -----------------------------------------------------------
    SELECT empno, ename, job, hiredate
	FROM emp
	WHERE hiredate BETWEEN '1981-01-01' AND '1981-12-31';

    SELECT empno, ename, job, deptno
	FROM emp
	WHERE empno BETWEEN 1100 AND 1500; 

SELECT empno,ename, job
	FROM emp
	WHERE empno =1000
	OR empno =1200
	OR empno =1120
	OR empno =1166;

SELECT empno, ename, job
	FROM emp
	WHERE empno IN(1000, 1102, 1200, 1120, 1166);
    
SELECT empno, ename, job, deptno FROM emp
    WHERE job IN('SALESMAN', 'DEVLOP');
    
SELECT empno, ename, job, sal, deptno FROM emp
	WHERE job IN('SALESMAN', 'DEVLOP') 
    AND sal>=1500;

SELECT empno, ename, job, deptno FROM emp
	WHERE ename LIKE '_도';
    
SELECT empno, ename, hiredate, deptno FROM emp
	WHERE hiredate LIKE '1981%';
-- -----------------------------------------------------------
SELECT empno, ename, job FROM emp
	WHERE LOWER(job)= 'salesman';
    
SELECT empno, ename, job, SUBSTR(job, 3, 1) AS sub1, SUBSTRING(job, 3, 1),LENGTH(job) 
	FROM emp;
        
SELECT empno, ename, job, INSTR(job,'S') 
	FROM emp;

SELECT CEIL(3.14), ceil(5.01), ceil(5.00),ceil(3.00001);
SELECT FLOOR(3.1111); -- 3

SELECT ROUND(1200.34,0),ROUND(1234.34,-2),ROUND(1254.34,-2),ROUND(1200.34,1);
-- 1200 1200 1300 1200.3

SELECT ROUND(1200.34,0),ROUND(1234.34,-2),
	MOD(10,3),MOD(20,3),FLOOR(3.95), GREATEST(10,23,8,45,34) as '최대값';
    
SELECT NOW(),dayofweek(now()); -- 일 1 월 2 화 3 이런식임

SELECT dayofweek('2025-11-22');-- 7 토요일

SELECT NOW(),dayofmonth(now()), dayofyear(NOW());

SELECT NOW(),month(now()), dayname(NOW()),quarter(now());

SELECT now(), period_add(202511,2);

SELECT now(), period_diff(202506,202411);

SELECT now(), SUBSTR(NOW(),1,4),substr(now(),6,2);

SELECT empno,ename,now(), period_diff(CONCAT(SUBSTR(now(),1,4),SUBSTR(now(),6,2)),
concat(substr(hiredate,1,4),substr(hiredate,6,2)))
FROM emp;

SELECT empno,ename, now(),date_format(now(),'%Y%m') As c_date FROM emp;

SELECT  empno,ename, period_diff(date_format(now(),'%Y%m'),date_format(hiredate,'%Y%m'))
FROM emp;