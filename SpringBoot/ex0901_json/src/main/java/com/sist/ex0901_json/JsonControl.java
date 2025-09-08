package com.sist.ex0901_json;

import jsonEx.output.DataVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class JsonControl {


    @RequestMapping("/bbs/test")
    public String test(){

        return "ex1";
    }
//    ajax 여기 위에 /bbs/이렇게 맞춰야함 혹은 ajax에서 /callTest해야함 /는 현재 위치를 의미함
    @RequestMapping(value = "callTest",method = RequestMethod.POST)
    @ResponseBody
//    value가 뭐가 넘어올지 모르니 Object
    public Map<String, Object> json(){
        Map<String,Object> map = new HashMap<>();
//        map.put("ename","마동석");
//        map.put("email","ma@korea.com");

//        DataVO dvo= new DataVO("마동석","ma@korea.com");
//        map.put("vo",dvo);
        DataVO[] ar = new DataVO[3];
        ar[0] = new DataVO("일동석","1@korea.com");
        ar[1] = new DataVO("이동석","2@korea.com");
        ar[2] = new DataVO("삼동석","3@korea.com");

        map.put("ar",ar);
        map.put("length",ar.length);

        return map;
    }
}
