package com.sist.ex0910_jpa2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.ex0910_jpa2.repository.EmpRepository;
import com.sist.ex0910_jpa2.stroe.Emp;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;

    public List<Emp> findAll() {
        return empRepository.findAll();
    }
    public Optional<Emp> findByEmpno(Long empno){
        return empRepository.findByEmpno(empno);
    }

    //사번검색
    public List<Emp> findByDeptno(String deptno){
        return empRepository.findByDeptno(deptno);
    }
    //직종과 부서 검색
    public List<Emp> findByDeptnoandjob(String deptno,String job){
        return empRepository.findByDeptnoAndJob(deptno,job);
    }

    //직접 쿼리문으로
    public List<Emp> findByJobLikeAndDeptno(String job,String deptno){
        return empRepository.findByJobLikeAndDeptno(job, deptno);
    }
    public List<Emp> findByJobContainingAndDeptno(String job,String deptno){
        return empRepository.findByJobContainingAndDeptno(job, deptno);
    }
    public List<Emp> findByEnameStartingWith(String ename){
        return empRepository.findByEnameStartingWith(ename);
    }

    // public List<Emp> findBySalLessThanEqualOrderByHiredateDesc(int hiredate){
    //     return empRepository.findBySalLessThanEqualOrderByHiredateDesc(BigDecimal sal);
    // }
    
}
