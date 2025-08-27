package com.sist.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test2Action {
    @RequestMapping("/ex2")
    public ModelAndView execute(){
        ModelAndView mv =new ModelAndView();

        //아래는 request.setAttribute와 똑같음
        //mv가 requset에 담겨서 포워드될때 같이 감
        mv.addObject("msg","SIST 반갑고~");

        //ModelAndView에 안넣고 여기서 하는이유
        // 바꿀 수 있기때문에
        mv.setViewName("ex2");// /WEB-INF/jsp/ex2.jsp
        return mv;
    }

    @RequestMapping("/ex3")
    public ModelAndView execute2(){
        ModelAndView mv =new ModelAndView();

        //아래는 request.setAttribute와 똑같음
        //mv가 requset에 담겨서 포워드될때 같이 감
        mv.addObject("str","Hello Spring");

        //ModelAndView에 안넣고 여기서 하는이유
        // 바꿀 수 있기때문에
        mv.setViewName("ex3");// /WEB-INF/jsp/ex3.jsp
        return mv;
    }
}
