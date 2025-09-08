package com.sist.ex0908_bbs.Controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sist.ex0908_bbs.mapper.BbsMapper;
import com.sist.ex0908_bbs.service.BbsService;
import com.sist.ex0908_bbs.util.FileRenameUtil;
import com.sist.ex0908_bbs.util.Paging;
import com.sist.ex0908_bbs.vo.BbsVO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;


@RestController
public class BbsController {

    @Autowired
    private BbsService bbsService;
    @Autowired
    private ServletContext application;

    @Autowired
    private BbsMapper bbsMapper;


    @Autowired
    private HttpServletRequest request;

    @Value("${server.editor.path}")
    private String editor_img;

    int numPerPage = 10; // 한페이지에 보여줄 게시글 수
    private int pagePerBlock = 5; // 한 블럭당 보여줄 페이지 수

    @GetMapping("/list")
    public ModelAndView  getBbsList(@RequestParam String bname,String cPage){
        ModelAndView mv = new ModelAndView();

        int nowPage = 1;

        if(cPage != null && !cPage.equals("")){
            nowPage = Integer.parseInt(cPage);
        }
        if(bname == null || bname.equals("")){
            bname = "BBS";
        }

        mv.setViewName(bname+"/list");
        int totalCount = bbsService.getTotalCount(bname);//전체 게시물 수

        //페이징 객체 생성
        Paging page = new Paging(nowPage, totalCount, numPerPage, pagePerBlock,bname);

        BbsVO[] ar = bbsService.getList(bname, page.getBegin(), page.getEnd());


        mv.addObject("totalCount", totalCount);
        mv.addObject("bname", bname);
        mv.addObject("ar", ar);
        mv.addObject("page", page);
        mv.addObject("pageResult", page.getPagingHTML().toString());

        return mv;
    }


    @GetMapping("/write")
    public ModelAndView getWriteForm(@RequestParam String bname,String cPage) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(bname+"/write");

        mv.addObject("bname",bname);
        mv.addObject("cPage",cPage);

        return mv;
    }

    @PostMapping("/saveImg")
    public Map<String, Object> saveImg(MultipartFile upload) {
        //반환형 준비
        Map<String,Object> entity = new HashMap<>();

        //첨부파일이 전달되어 왔다면
        if(upload.getSize()>0){
            //파일을 저장할 위치(editor_img)를 절대경로화 시킨다.
            String realPath =application.getRealPath(editor_img);

            //파일명을 얻어낸다.
            String oname = upload.getOriginalFilename();

            //서버에 저장할 파일명을 만든다.

            //동일한 파일명이 있을 때만 파일 명을 변경하자
            String fname = FileRenameUtil.checkSameFileName(oname, realPath);
    
            try{
                upload.transferTo(new File(realPath,fname));
            }catch(Exception e){
                e.printStackTrace();
            }
            //업로드 된 파일의 전체경로 (파일명이 포함된 경로)를 
            //map에 담자
            String url_path = request.getContextPath();//sist.co.kr/

            //JSON형식으로 반환하기 위해서 map에 저장
            entity.put("img_url", url_path+editor_img+fname);
        }
        
        return entity;
    }

    @PostMapping("/write")
    public ModelAndView write(BbsVO vo,@RequestParam(required = false, defaultValue = "1")String cPage){
        System.out.println("bname: " + vo.getBname()); // bname 값 확인
        int result = bbsMapper.add(vo);

        ModelAndView mv = new ModelAndView();
        // mv.setViewName(bname+"/list");
        // mv.setViewName(vo.getBname()+"/list");

        if (result > 0) {
            // 성공 시 리다이렉트
            mv.setViewName("redirect:/list?cPage="+cPage+"&bname=" + vo.getBname());
        } else {
            // 실패 시 다시 글쓰기 폼으로
            mv.setViewName("redirect:/write?cPage="+cPage+"&bname=" + vo.getBname());
        }
        return mv;

    }
   
    
    
    
    
}
