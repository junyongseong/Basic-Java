package com.sist.ex0901_bbs;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BbsControl {

    @Autowired
    private BbsDAO bbsDAO;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ServletContext application;
    @Autowired
    private HttpSession session;
    int numPerPage =7;
    int pageNumBlock =5;

    private String upload_path = "/resources/bbs_upload/";
    //에디터에 주입될 이미지 파일들이 저장될 곳은
    private String editor_path="/resources/editor_img/";

    @RequestMapping("/list")
    public ModelAndView list(String bname,String cPage){
        ModelAndView mv = new ModelAndView();

        //========================페이징 기법========================
        if (bname == null ||bname.equals(""))
            bname="BBS";

        Paging page = new Paging(numPerPage,pageNumBlock);
        //                      게시물의 수, 블럭당 보여질 페이지 수
        int totlaRecord = bbsDAO.getTotalCount(bname);
        page.setTotalCount(totlaRecord);
        if (cPage ==null)
            cPage ="1";
        page.setNowPage(Integer.parseInt(cPage));//begin,end,startPage,endPage 구해짐
        //=========================================================

        //뷰페이지에서 표현할 게시물 목록 가져오기
        BbsVO[] ar = bbsDAO.getList(bname,page.getBegin(),page.getEnd());

        //뷰페이지에서 표현할 정보들을 mv에 저장
        mv.addObject("ar",ar);
        mv.addObject("page",page);
        mv.addObject("bname",bname);

        //뷰 페이지 설정
        mv.setViewName("list");//뷰페이지 설정

        return mv;
    }

    @RequestMapping("/write")
    public String write(){
        return "write";
    }

    @RequestMapping(value = "saveImg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveImg(MultipartFile upload ){
        Map<String,Object> map = new HashMap<>();

        //파라미터로 들어온 이미지 파일이 있는지? 확인
        if (upload.getSize()>0){
            //넘어온 이미지 파일이 있는 경우이므로 원하는 곳에 저장하기 위해
            //절대경로가 필요하다.
            String real_path = application.getRealPath("editor_path");
            String fname = upload.getOriginalFilename();
            //파일 저장!
            try {
                upload.transferTo(new File(real_path,fname));
                //현재 프로젝트의 경로
                String c_path =request.getContextPath()+"/resources/editor_img/"+fname;
                String url = request.getContextPath()+"/resources/editor_img/";
                map.put("url", url);   // 디렉토리까지만
                map.put("fname", fname); // 파일명만
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return map;
    }

}
