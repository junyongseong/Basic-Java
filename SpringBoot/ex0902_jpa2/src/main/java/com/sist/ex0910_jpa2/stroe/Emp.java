package com.sist.ex0910_jpa2.stroe;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "emp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emp {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long empno;
    private String ename,job,sal;
    private LocalDate hiredate;

    @Column(name = "deptno", insertable = false, updatable = false)
    private String deptno;

    @ManyToOne(fetch = FetchType.LAZY) //Emp객체를 조회 할 때 Dept객체는 
                                    //필요할 때까지 로딩하지 않음
    @JoinColumn(name = "deptno",referencedColumnName= "deptno")
    private Dept dept;
}

