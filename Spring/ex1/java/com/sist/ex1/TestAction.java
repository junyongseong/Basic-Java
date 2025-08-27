package com.sist.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Controller
public class TestAction extends AbstractController {

    //이렇게도 가능함 어노테이션 안하고 추상화 상속받아서 이런식으로 컨트롤러도 가능
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
            ModelAndView mv = new ModelAndView("ex1");

            return mv;// /WEB-INF/jsp/ex1.jsp로 forward 함
    }
}

