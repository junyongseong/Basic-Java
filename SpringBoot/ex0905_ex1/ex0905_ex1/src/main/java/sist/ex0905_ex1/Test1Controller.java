package sist.ex0905_ex1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Test1Controller {

    // application.properties파일에 있는 변수값을 가져온다.
    @Value("${msg}")
    private String message;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/t1")
    public String test1(@RequestParam String param) { // 반드시 param이라는 파라미터가 있어야 함
        return "반갑습니다. 스프링입니다. param: " +  param;
    }

    @GetMapping("/t2/{var}")
    public String test2(@PathVariable String var){
        return "경로변수: " + var;
    }

    @GetMapping("/t3/{var}")
    public String test3(@PathVariable("var") String param){
        return "경로변수: " + param;
    }

    @GetMapping("/t4")
    public ModelAndView test4() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("str","쌍용교육센터 이전-선릉역으로 ㅎㅋㅎㅋ");
        mav.addObject("msg",message);
        mav.setViewName("t4");
        return mav;
    }
}
