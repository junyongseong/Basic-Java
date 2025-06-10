SELECT *FROM emp WHERE comm IS NOT NULL;

-- Ex) emp테이블에서 각 부서별 인원수를 출력하자!
SELECT deptno, COUNT(*) FROM emp 
	GROUP BY deptno
    ORDER BY deptno;
   
-- Ex) emp테이블에서 각 부서별 인원수, 그리고 급여의 평균과 총액을 구하자!
SELECT deptno, COUNT(*),AVG(sal),SUM(sal),MAX(sal),MIN(sal)
	FROM emp
	GROUP BY deptno;
    
-- 문제1) emp테이블에서 직종별(job) 급여의 합과 평균을 구하시오!
SELECT job, SUM(sal), FLOOR(AVG(sal)),COUNT(*)
	FROM emp
	GROUP BY job;
    
-- 문제2) emp테이블에서 각 부서별 보너스 (comm)의 합, 평균을 구하시오!
SELECT deptno,COUNT(*), SUM(IFNULL(comm,0)), FLOOR(AVG(IFNULL(comm,0)))
	FROM emp
	GROUP BY deptno;
    
SELECT job,AVG(sal)
	FROM emp
	WHERE job ='ANALYST';
-- -----------------위 아래 똑같-------------------------
SELECT job,AVG(sal)
	FROM emp
	WHERE job ='ANALYST'
	GROUP BY job;
    
-- 문제3)  emp테이블에서 직종이 'CLERK' 또는 'SALESMAN'인 사원들중
-- 최대 급여를 구하는 SELECT문은?
SELECT MAX(sal) FROM emp
	WHERE job IN('CLERK' , 'SALESMAN');
    
-- 그룹화 
SELECT job, MAX(sal) FROM emp
	WHERE job IN('CLERK' , 'SALESMAN')
	GROUP BY  job;
    
-- Ex) emp테이블에서 각 부서별 인원수, 급여의 합을 구하는 SELECT문을 구하자? 
SELECT deptno, COUNT(*), SUM(sal) FROM emp
	GROUP BY deptno;

-- 위의 결과에서 인원수가 7명 이상인 부서만 확인하고 싶다면
SELECT deptno, COUNT(*), SUM(sal) FROM emp
	GROUP BY deptno
	HAVING COUNT(*) >= 7;
    
-- 1) 먼저 이름이  'SMITH'이고 직종이 'CLERK'인 사원의 급여를 알아내야 한다.
SELECT sal FROM emp
	WHERE ename = 'SMITH' AND job = 'CLERK';

-- 2) 1에서 알아낸 결과 800이라는 급여보다 더많이 받는 사원들의 정보를 출력!
SELECT empno,ename,job,sal
	FROM emp
	WHERE sal > 800;
    
-- 위는 2번에 걸쳐 실행하는 상황이다. 이것을 서브쿼리로 바꿔보자!
    SELECT empno,ename,job,sal
	FROM emp
	WHERE sal > (SELECT sal FROM emp
			WHERE ename = 'SMITH' AND job ='CLERK');
    
    -- 문제4) emp테이블에서 사번이 7521번인 사원의 직종과 같고 7844번 사원의 
	-- 급여보다 많이 받는 사원들의 정보를 사번, 이름, 직종, 급여, 입사일 순으로 출력하시오!
   -- 1)사번이 7521인 사원의 직종 알아내기 :SALESMAN
	SELECT job FROM emp
	WHERE empno = 7521;

	-- 2)사번이 7844인 사원의 급여 알아내기:1500
	SELECT sal FROM emp
	WHERE empno=7844;
    
    -- 3) 위의 1)과 2)의 결과를 가지고 원하는 정보를 얻기 위해 문장 만들기
	SELECT empno,ename,job,sal,hiredate
	FROM emp
	WHERE sal>=1500 AND
	job ='SALESMAN';

	-- 4)위 의 SQL문장들을 조합하면...
 	SELECT empno,ename,job,sal,hiredate
	FROM emp
	WHERE sal>=(SELECT sal FROM emp
	WHERE empno=7844) AND
	job =(SELECT job FROM emp
	WHERE empno = 7521);
    
    
-- 문제5) emp테이블에서 급여가 3000이상인 사원들 중
-- 입사일이 1982년 이전에 입사한 사원들의 정보를
-- 사번, 이름,급여, 입사일 순으로 출력하자! 

SELECT empno, ename, sal, hiredate
	FROM emp
	WHERE hiredate <'1982-01-01'
	AND sal >= 3000;

-- 위는 emp테이블 전체를 대상으로 검색을 수행한다.
-- 하지만 다음은 내용이 그렇지 않다.
	SELECT a.empno, a.ename, a.sal, a.hiredate
	FROM (SELECT * FROM emp WHERE sal>= 3000) a
	WHERE a.hiredate <'1982-01-01';
    
-- Ex)급여가 3000이상인 사원들의 부서코드와 부서명을 출력하자!
	
-- 1) 먼저 급여가 3000 이상이 사원들의 부서코드를 알아내야한다.
	SELECT deptno FROM emp
	WHERE sal >=3000;
    
-- 2) 위를 수행하면 결과가 20번 부서는 2개가 나온다. 그래서 중복된 값을 제거해야함
	SELECT distinct deptno FROM emp
	WHERE sal >=3000;
    
-- 3) 앞서 구한 10,20번을 가지고 있는 dept테이블에서 조건을 사용하여 
-- 부서코드와 부서명을 출력하면 된다.
	SELECT deptno,dname FROM dept
	WHERE deptno IN(10,20);

-- 4) 위의 문장들을 하나로 합쳐서 결과를 확인하자!
	SELECT deptno,dname FROM dept
	WHERE deptno IN(SELECT distinct deptno FROM emp
	WHERE sal >=3000);
    
    