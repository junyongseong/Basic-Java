package com.sist.ex0910_jpa2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.ex0910_jpa2.stroe.Emp;

public interface EmpRepository extends JpaRepository<Emp, Long> {
    
    //사번이 없는경우에는? 이런경우 처리 위해 Optional<Emp> 사용
    //검색된 데이터가 없을 때 null이 아닌 Optional.empty()를 반환
    //그러므로 값이 없을때 보다 안전하게 처리할 수 있다.
    Optional<Emp> findByEmpno(Long empno);//사번검색
    List<Emp> findByDeptno(String deptno); //부서번호 검색
    List<Emp> findByDeptnoAndJob(String deptno, String job); //부서번호,직종 검색

    //@Query 어노테이션은 Spring Data JPA에서 메서드에 직접 SQL문을 작성한다는 의미
    //nativeQuery = true 는 JPQL이 아닌  순수 SQL문을 사용하겠다는 의미
    //SQL문을 직접 작성할 수 있음 직종,부서번호 검색 쿼리문으로로
    @Query(value= "select * from emp where job like concat('%',?1,'%') and deptno = ?2", nativeQuery = true)
    List<Emp> findByJobLikeAndDeptno(String job, String deptno);
    
    
    List<Emp> findByJobContainingAndDeptno(String job, String deptno); // 직종,부서번호 검색 DEV이런식으로 검색가능능
    List<Emp> findByEnameStartingWith(String ename);//아무개 아저씨 이런것들 아~ 이렇게 검색가능

    //급여가 3000이하인 사원들의 정보를 입사일(hiredate)이 최근순으로 출력
    //하기 위한 메서드를 정의하자!
    // List<Emp> findBySalLessThanEqualOrderByHiredateDesc(String sal);
}
