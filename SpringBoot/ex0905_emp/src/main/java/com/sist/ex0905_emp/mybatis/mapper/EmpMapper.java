package com.sist.ex0905_emp.mybatis.mapper;

import com.sist.ex0905_emp.mybatis.vo.EmpVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    //SQL문을 가진 mapper 파일(emp.xml)과 연동된다.
    //그래서 여기에 정의하는 함수들은 emp.xml에 존재하는
    //id명과 동일해야한다.(ex.all, add, search)


    //all은 List를 반환하고 제네릭 타입은 EmpVO임 그래서 이렇게 만듬
    List<EmpVO> all();

}
