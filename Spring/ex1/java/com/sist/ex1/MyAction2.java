package com.sist.ex1;

import ex1.vo.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyAction2 {


    private TestVO vo1;

    public TestVO getTvo() {
        return vo1;
    }

    public void setTvo(TestVO vo1) {
        this.vo1 = vo1;
    }

    @RequestMapping("/ttt")
    public ModelAndView test( ) {
        ModelAndView mv = new ModelAndView("ex5");

        //te의 이름을 jsp에서 표현하기 위해 mv에 저장해야한다.
        mv.addObject("vo",vo1);

        return mv;
    }
}
