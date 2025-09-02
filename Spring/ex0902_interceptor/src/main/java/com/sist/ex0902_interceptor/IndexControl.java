package com.sist.ex0902_interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexControl {

    @RequestMapping("/")
    public String index(){
        return "index";//view/index.jsp로 forward됨
    }


    @GetMapping("/sub/bravo")
    public ModelAndView sub(){

        ModelAndView mv = new ModelAndView("sub_tab");
        return mv;
    }

}
