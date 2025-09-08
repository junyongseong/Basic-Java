package com.sist.ex0901_json;

import jsonEx.output.MemberVO;
import mybatis.dao.EmpDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Controller
public class EmpControl {

    @Autowired
    private EmpDAO empDAO;


    @RequestMapping("/bbs/empTest")
    public String test() {
        return "ex1";   //view/ex1.jsp
    }

    @RequestMapping(value = "callTest2",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> json(){
        Map<String,Object> map = new HashMap<>();

        //DAO 호출
        List<MemberVO> list = empDAO.selectAll();

        //map에 저장
        map.put("empList",list);
        map.put("count",list.size());

        return map;
    }

}
