package com.sist.ex0902_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MemberControl {

    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(String m_id,String m_pw){
        ModelAndView mv = new ModelAndView();
        //DAO 활용한 DB인증
        //했다고 가정함

        boolean autologin = "1111".equals(m_id)&&"1111".equals(m_pw);

        if (autologin) {
            session.setAttribute("mvo", m_id);
            mv.setViewName("redirect:/");
        }else {
            mv.setViewName("login");
        }
        return mv;
    }
}
