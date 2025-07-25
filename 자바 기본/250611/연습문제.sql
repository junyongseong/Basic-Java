-- 1. emp테이블에서 연봉을 계산하는 SELECT문장을 기술하시오(급여*보너스)
SELECT *, sal * IFNULL(comm, 1) FROM emp;

-- 2. emp테이블에서 사번이 7521번인 사원의 직종과 같고,7844번 사원의 급여보다 많이 받는 
-- 사원들의 정보를 사번,이름,직종,급여,입사일 순으로 출력하시오. 단,서브쿼리를 활용하자
SELECT empno, ename, job, sal, hiredate FROM emp
   WHERE sal >= (SELECT sal FROM emp WHERE empno = 7844)
   AND job = (SELECT job FROM emp WHERE empno = 7521);

-- 3. emp테이블에서 직종이 ‘CLERK’ 또는 ‘SALESMAN’인 사원들 중 최대 급여를 구하는 
-- SELECT문장을 기술하시오
SELECT MAX(sal) FROM emp WHERE job IN( 'CLERK' , 'SALESMAN' );

-- 4. 서브쿼리를 활용하여 emp테이블에서 사원 이름이 'SMITH'이고, 직종이 'CLERK'인사원의 
-- 급여보다 더 많이 받는 사원들의 정보를 사번,이름,직종,급여 순으로 출력해보자!.
SELECT empno, ename, job, sal FROM emp
WHERE sal > (SELECT sal FROM emp
            WHERE ename = 'SMITH' AND job = 'CLERK');

-- 5. emp테이블에서 각 부서별 인원수를 구하는 SELECT 문장을 기술하시오.
--  (부서가 NULL인 사람도 출력하시오)
SELECT deptno, COUNT(*) FROM emp GROUP BY deptno;

-- 6. emp테이블에서 각 부서별 인원이 5명 이상인 부서의 부서코드, 인원수, 급여의 합을 구
-- 하는 SELECT 문장을 기술하시오
SELECT deptno, COUNT(*), SUM(sal) FROM emp
    GROUP BY deptno
    HAVING COUNT(*) >= 5;

-- 7. 각 부서별 보너스의 합을 구하여 부서코드, 인원수, 보너스의 합 순으로 정보를 출력하는
--  SELECT 문장을 기술하시오! (단 NULL이 출력되어서는 안된다.)
SELECT deptno, COUNT(*), SUM(IFNULL(comm, 0)) FROM emp GROUP BY deptno;

-- 8. deptno가 20인 부서의 도시명을 알아내는 SELECT 문장을 기술하시오.
SELECT d.deptno, l.city FROM (SELECT * FROM dept WHERE deptno=20) d, locations l
   WHERE d.loc_code = l.loc_code;

-- 9.각 사원들의 관리자(MGR)가 누구인지를 알아내어 사번, 이름, 관리자사번(MGR),관리자 명 
-- 순으로 출력 하시오!
SELECT e.empno,e.ename,e.mgr,e2.ename FROM emp e INNER JOIN emp e2
   ON e.mgr = e2.empno;

-- 10. emp테이블에서 직종이 ‘ANALYST’인 사원들의 정보를사번, 이름, 직종, 급여, 부서명, 
-- 도시명 순으로 출력하시오!
SELECT e.empno,e.ename,e.job,e.sal,d.dname,l.city FROM (SELECT * FROM emp WHERE job = 'ANALYST') e 
        INNER JOIN dept d INNER JOIN locations l
    ON e.deptno = d.deptno AND d.loc_code = l.loc_code;
