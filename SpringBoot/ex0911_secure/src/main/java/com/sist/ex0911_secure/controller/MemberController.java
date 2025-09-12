package com.sist.ex0911_secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sist.ex0911_secure.service.MemberService;
import com.sist.ex0911_secure.vo.MemVO;

import jakarta.servlet.http.HttpSession;




@RestController
public class MemberController {
    //DB활용을 위해 service 객체 준비
    @Autowired
    private MemberService mservice;
    
    //로그인 처리를 위한 세션 준비
    @Autowired
    private HttpSession session;

    @RequestMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");

        return mv;
    }

    @RequestMapping("/reg")
    public ModelAndView reg() {
        ModelAndView mv = new ModelAndView("reg");
        return mv;
    }

    @PostMapping("/reg")
    public ModelAndView reg(MemVO vo) {
        ModelAndView mv = new ModelAndView("index");

        //서비스를 이용하여 회원 등록
        int cnt = mservice.regMember(vo);

        //기본키를 저장 할 때 바로 얻어내는 방법은
        //매퍼에<insert...> 다음의 속성을 지정한다.
        //useGeneratedKeys="true" keyProperty="m_idx"
        System.out.println("멤버기본키:"+vo.getM_idx());
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    @PostMapping("/reqLogin")
    public ModelAndView login(MemVO vo) {
        ModelAndView mv = new ModelAndView("redirect:/");
        MemVO mvo = mservice.login(vo);

        //mvo가 null이면 아이디 또는 비밀번호가 틀린경우!
        if(mvo !=null){
            session.setAttribute("mvo", mvo);
        }else
            mv.addObject("status","1");

        //로그인이 잘 됐으면 status가 없음 잘 안됐으면 status가 들어감 (1)
        return mv;
    }
    
}
    


