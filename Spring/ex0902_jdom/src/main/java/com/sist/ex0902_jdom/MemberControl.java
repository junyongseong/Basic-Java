package com.sist.ex0902_jdom;

import data.vo.MemberVO;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberControl {
    /*
    * 오픈 API서비스의 URI 같은 경로가 멤버 변수로 선언되어야 하지만
    * 우리는 내부에 있는 XML문서를 접근하여 마치 오픈 API에서 결과를
    * 받는 것 처럼 가정하자
    * */
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private ServletContext application;
    @RequestMapping(value = "t1",method = RequestMethod.GET)
    public ModelAndView t1() throws IOException, JDOMException {
        ModelAndView mv = new ModelAndView();

        //준비된 문서의 절대경로를 지정하자!
        String realPath= application.getRealPath("/resources/pm/data/member.xml");

        //JDOM파서를 이용하여 로드(파싱) 하자!
        SAXBuilder builder = new SAXBuilder();

        //준비된 buiolder를 통해 결과인 xml자원을 문서화(document)시킨다.
        Document doc = builder.build(realPath);

        Element root = doc.getRootElement();
//        System.out.println("ROOT:" +root.getName());

        List<Element> list = root.getChildren("member");
//        System.out.println(list.size());

//        String type = request.getParameter("type");
//        String value = request.getParameter("value");

        //위에서 얻은 list를 배열로 만들어 보자!
        MemberVO[] ar = null;
        if(list != null && list.size()>0){
            ar= new MemberVO[list.size()];
            int i=0; //배열의 index값으로 사용할 변수
            for (Element e : list){
                String name =e.getChildText("name");//마루치
                String email =e.getChildText("email");//마루치
                String phone =e.getChildText("phone");//마루치

                MemberVO m =new MemberVO();

                m.setName(name);
                m.setEmail(email);
                m.setPhone(phone);

//                boolean chk = true;
//                if ("type" !=null && "value" !=null){
//                        if("0".equals(type) && !name.equals(value))
//                        chk = false;
//                        if("1".equals(type) && !name.contains(value))
//                        chk = false;
//                        if("2".equals(type) && !name.contains(value))
//                        chk = false;
//                }
//
//                if(!chk)
//                    mv.addObject(m);

                //채워진 MemberVO를 배열에 저장하자!
                ar[i] = m;
                i++;
            }
        }
        mv.addObject("ar",ar);
        mv.setViewName("member");
        return mv;
    }

    @RequestMapping(value="t1Search", method=RequestMethod.GET)
    @ResponseBody
    public List<MemberVO> t1Search() throws Exception {

        String type = request.getParameter("type");
        String value = request.getParameter("value");

        //준비된 문서의 절대경로를 지정하자!
        String realPath= application.getRealPath("/resources/pm/data/member.xml");

        //JDOM파서를 이용하여 로드(파싱) 하자!
        SAXBuilder builder = new SAXBuilder();

        //준비된 buiolder를 통해 결과인 xml자원을 문서화(document)시킨다.
        Document doc = builder.build(realPath);

        Element root = doc.getRootElement();
//        System.out.println("ROOT:" +root.getName());

        List<Element> list = root.getChildren("member");

        List<MemberVO> ar = new ArrayList<>();

        int i=0;
        for (Element e : list){
            String name = e.getChildText("name");
            String email = e.getChildText("email");
            String phone = e.getChildText("phone");

            boolean chk = true;
            if (type != null && value != null && !value.isEmpty()) {
                if ("0".equals(type) && !name.equals(value))
                    chk = false;
                if ("1".equals(type) && !email.contains(value))
                    chk = false;
                if ("2".equals(type) && !phone.contains(value))
                    chk = false;
            }

            if (chk) {
                MemberVO m = new MemberVO();
                m.setName(name);
                m.setEmail(email);
                m.setPhone(phone);
                ar.add(m);
            }
        }

        return ar; // JSON으로 반환됨
    }

}
