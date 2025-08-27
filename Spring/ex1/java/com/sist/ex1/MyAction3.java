package com.sist.ex1;

import ex1.vo.DataVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyAction3 {

    @RequestMapping("/ex6")
    public ModelAndView ex(){
        ModelAndView mv =new ModelAndView("ex6");

        DataVO[] ar = new DataVO[3];
        ar[0]= new DataVO();
        ar[0].setName("일지매");
        ar[0].setPhone("010-1234-1234");

        ar[1]= new DataVO();
        ar[1].setName("이지매");
        ar[1].setPhone("010-2345-2345");

        ar[2]= new DataVO();
        ar[2].setName("삼지매");
        ar[2].setPhone("010-3456-3456");

        //배열을 뷰페이지에서 표현하기 위해 mv에 저장!
        mv.addObject("ar",ar);

        return mv;
    }
}
