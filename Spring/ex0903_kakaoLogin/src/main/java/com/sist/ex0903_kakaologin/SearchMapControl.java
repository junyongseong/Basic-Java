package com.sist.ex0903_kakaologin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchMapControl {
    @RequestMapping("searchmap")
    public String searchmap(){
        return "searchmap";
    }
}
