package com.sist.ex0910_jpa2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0910_jpa2.service.EmpService;

import lombok.RequiredArgsConstructor;




@RestController
@RequiredArgsConstructor
@RequestMapping("/emp")
public class EmpController {
    
    private final EmpService empService;

    @RequestMapping("/all")
    public Object findAll(){
        return empService.findAll();
    }

    @RequestMapping("/getemp")
    public Object getEmp(@RequestParam("empno") Long empno){
        return empService.findByEmpno(empno);
    }
    //직종과 부서 검색을 and조건으로 검색하고자 한다.
    //RequestMapping("/jobanddept")
    @RequestMapping("/jobanddept")
    public Object getjobanddept(@RequestParam("deptno") String deptno,
                                @RequestParam("job") String job){
                    return empService.findByDeptnoandjob(deptno, job);
    }
    @GetMapping("/job_dept")
    public Object jobDept(@RequestParam("job") String job, @RequestParam("deptno") String deptno) {
        return empService.findByJobLikeAndDeptno(job,deptno);
    }
   
    @GetMapping("/job_dept2")
    public Object jobDept2(@RequestParam("job") String job, @RequestParam("deptno") String deptno) {
        return empService.findByJobContainingAndDeptno(job,deptno);
    }
    
    @GetMapping("/startwithename")
    public Object startwithename(@RequestParam("ename") String ename) {
        return empService.findByEnameStartingWith(ename);
    }
    
    
}
