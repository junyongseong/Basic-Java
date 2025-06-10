SELECT  * FROM my_db.dept;

SELECT * FROM dept;
SELECT * FROM emp;
SELECT * FROM locations;

SELECT distinct deptno FROM emp
	WHERE sal >=3000;

SELECT e.empno, e.ename, e.job, e.hiredate, d.deptno, d.dname
	FROM emp e INNER JOIN dept d
    ON e.deptno =d.deptno;
    
-- 각 부서별 도시명을 출력하자!
--	부서코드. 부서명, 도시코드, 도시명 순으로 출력하자   
SELECT d.deptno, d.dname, l.loc_code, l.city
	FROM dept d INNER JOIN locations l
	ON d.loc_code = l.loc_code;
-- 문제) 각 테이블 간 연결하여 각 사원들이 누가 어떤 도시에 있는 부서에서
	-- 근무하는지 출력하자!
	-- 사번, 이름, 직종, 입사일, 부서코드, 부서명, 도시명 순으로 출력하시오!   
SELECT e.empno, e.ename, e.job,e.hiredate, d.deptno, d.dname, l.city
	FROM emp e INNER JOIN dept d INNER JOIN locations l
	ON e.deptno =d.deptno AND d.loc_code = l.loc_code; 
    
-- LEFT OUTER JOIN 
SELECT e.empno, e.ename, e.job,e.hiredate, d.deptno, d.dname
	FROM emp e LEFT OUTER JOIN dept d
	ON e.deptno =d.deptno;
    
-- RIGHT OUTER JOIN 왼쪽이 비어있음
SELECT e.empno, e.ename, e.job,e.hiredate, d.deptno, d.dname
	FROM emp e RIGHT OUTER JOIN dept d
	ON e.deptno =d.deptno;
    
-- 현재 사원들과 부서간의 연결에서 부서는 존재하지만 근무하는
-- 구성원이 없는 부서가 무엇인지? 알아내자!
SELECT e.*,d.deptno,d.dname
	FROM emp e RIGHT OUTER JOIN dept d
	ON e.deptno = d.deptno;
    
-- 문제2) emp테이블에서 직종이 'ANALYST'인 사원들의 정보를
-- 사번, 이름, 직종, 급여, 부서명, 도시코드 순으로 출력하시오!
SELECT e.empno, e.ename, e.job,e.sal, d.dname, d.loc_code
	FROM emp e LEFT OUTER JOIN dept d
	ON e.deptno = d.deptno
	WHERE e.job ='ANALYST';
    
-- 위의 내용을 서브쿼리로 한다면...
SELECT e.empno, e.ename, e.job,e.sal, d.dname, d.loc_code
	FROM (SELECT  * FROM emp WHERE job ='ANALYST') e LEFT OUTER JOIN dept d
	ON e.deptno = d.deptno;
    
-- 위의 내용에서 도시명을 하나 추가해서 출력하려 한다면...
SELECT e.empno, e.ename, e.job,e.sal, d.dname, d.loc_code, l.city
	FROM (SELECT  * FROM emp WHERE job ='ANALYST') e LEFT OUTER JOIN dept d
	ON e.deptno = d.deptno
    LEFT OUTER JOIN locations l 
    ON d.loc_code =l.loc_code;
    
-- 문제3) 'DALLAS'에서 근무하는 사원들의 정보를
-- 	사번, 이름, 직종, 입사일, 부서코드, 도시명 순으로 출력하시오! 
-- 이건 실패 아래가 성공 LEFT OUTER JOIN을 INNER JOIN으로 바꾸거나 RIGHT로 바꿈 됨
    SELECT e.empno, e.ename, e.job, e.hiredate, d.dname, l.city
	FROM emp e RIGHT OUTER JOIN dept d 
	ON e.deptno = d.deptno
	RIGHT OUTER JOIN (SELECT * FROM locations WHERE city ='DALLAS') l
	ON d.loc_code =l.loc_code;
    
SELECT e.empno, e.ename, e.job,e.sal, d.dname, d.loc_code, l.city
	FROM emp e INNER JOIN DEPT d
    INNER JOIN(SELECT * FROM locations WHERE city ='DALLAS') l
    ON e.deptno = d.deptno
    AND d.loc_code = l.loc_code;
    
-- 문제4) 각 사원들의 관리자(MGR)가 누구인지를 알아내어
--	사번, 이름, 관리자 사번,관리자명 순으로 출력하시오
    SELECT e.empno, e.ename, e.mgr as ManagerNumber, m.ename as Manager
	FROM emp e INNER JOIN emp m
	ON e.mgr = m.empno;