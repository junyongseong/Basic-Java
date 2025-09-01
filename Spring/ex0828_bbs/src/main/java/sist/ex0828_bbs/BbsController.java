package sist.ex0828_bbs;

import Spring.input.ImgVO;
import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import mybatis.vo.DataVO;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BbsController {

    // 절대 경로를 얻기위한 request 생성
    @Autowired
    private HttpServletRequest request;

    // ServletContext -> 지금 나의 프로젝트
    @Autowired
    private ServletContext application;

    @Autowired
    private BbsDAO bbsDAO;

    @Autowired
    private HttpSession session;

    // 파일들을 저장할 경로 파일 객체 생성을 위해
    private String editor_img = "/resources/editor_img/";

    int numPerPage = 7; // 한 페이지에 보여질 게시물 수
    int pagePerBlock = 5; // 한 블럭당 보여질 페이지수

    // 목록을 얻어내는 메서드
    @RequestMapping("/bbs/list")
    public ModelAndView list(String bname, String cPage) {
//        페이징 처리
        if(bname == null || bname.equals(""))
            bname = "BBS";

        Paging page = new Paging(numPerPage, pagePerBlock);

        // 총 페이지 수를 구하기 위해 총 게시물 수를 알아내야 한다.
        int totalCount = bbsDAO.getTotalCount(bname);

        // 총 페이지 수를 구하자
        page.setTotalCount(totalCount);

        // 현재 페이지가 null인 경우
        if(cPage == null)
            cPage = "1";
        page.setNowPage(Integer.parseInt(cPage));
        // ----- 페이징 기법 ----------//

        ModelAndView mv = new ModelAndView();

        // View페이지에 표현할 목록을 받아야 한다.(배열)
        BbsVO[] ar = bbsDAO.getList(bname, page.getBegin(), page.getEnd());

        mv.addObject("ar", ar);
        mv.addObject("page", page);
        mv.addObject("nowPage", page.getNowPage());

        mv.setViewName("/bbs/list");

        return mv;
    }

    @RequestMapping("/bbs/view")
    public ModelAndView view(String bname, String b_idx, String cPage) {

        ModelAndView mv = new ModelAndView("list");

        /// ============================ 조회수 증가 ================================
        List<BbsVO> list = null;
        // 세션으로부터 이름이 r_list라는 이름으로 저장된 객체를 얻어낸다.
        Object obj = session.getAttribute("r_list");

        if(obj != null)
            list = (List<BbsVO>) obj;
        else{
            // 처음으로 게시판 들어온 경우
            list = new ArrayList<BbsVO>();
            session.setAttribute("r_list", list);
        }

        // 이제 list에서 인자로 받은 b_idx값과 같은 값을 가진 BbsVO를
        // list에서 검색한다.
        boolean check = false; // 이 false가 유지된다면 찾지 못한 경우 -> 조회수가 증가되어야 함
        for(BbsVO vo : list) {
            if(vo.getB_idx().equals(b_idx)){
                check = true;
                break;
            }
        }// for의 끝

        // check변수의 값이 false이면 조회수 증가
        if(!check){
            bbsDAO.hit(b_idx);
        }
        /// =============================================================================


        if(bname == null || bname.equals("")) {
            bname = "BBS";
        }

        BbsVO vo = bbsDAO.getBbs(b_idx);
        if(vo != null) {
            if(!check)
                list.add(vo); // 다음에 같은 게시물을 클릭하면 조회수 증가를 하지 않는다.
                                //검색된 vo를 뷰페이지에서 봐야 함으로 mv에 저장
                mv.addObject("vo", vo);
        }

        // 검색된 VO를 View페이지에서 봐야 함으로 mv에 저장
        mv.addObject("vo", vo);
        mv.addObject("page", cPage);
        mv.addObject("bname", bname);

        mv.setViewName("/bbs/view");
        return mv;
    }

    @RequestMapping("bbs/write")
    public String write() {
        return "bbs/write";
    }

    @RequestMapping(value = "/bbs/saveImg", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> saveImg(ImgVO vo) {

        // JSON 처리를 위한 Map 구조
        Map<String, String> map = new HashMap<>();

        // 전달 되어 오는 이미지 파일은 vo라는 인자에 저장되어 있음
        MultipartFile file = vo.getUpload(); // 파라미터를 가져옴
        if(file.getSize() > 0){
            // 넘어온 파일이 있는 경우 경로를 지정해주기 위해 검사한다.

            // 파일을 저장할 위치 (editor_img)를 절대경로화 시킴
            // 위에 멤버로 선언함, 내가 원하는 경로로 선언
            String realPath = application.getRealPath(editor_img);

            // 저장할 위치를 준비했고 파일을 저장한다.
            try{
                // 스프링 프로젝트에서 파일을 저장하는 기능이  기본적으로 내장되어 있다.
                // 위에 선언한 저장할 파일경로와, 파일의 이름
                file.transferTo(new File(realPath, file.getOriginalFilename()));

                // 이제 만든 파일을 JSON 으로 전달하기 위해 map에 담아서 던져준다.
                map.put("fname", file.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }

            String c_path = request.getContextPath(); // localhost:8080
            map.put("url", c_path + editor_img);

        }

        // 이제 준비가 끝났으니 JSON응답으로 보내주면 된다.
        // 반드시 라이브러리가 필요하다. 노션확인
        return map;
    }

    // 저장
    @RequestMapping(value = "/bbs/write", method = RequestMethod.POST)
    public ModelAndView save(DataVO vo ) {
        // 전달되는 파라미터들이 모두 DataVO에 저장된 상태
        ModelAndView mv = new ModelAndView();

        // 폼에 enctype이 multipart로 시작하는지?
        String c_type = request.getContentType();
        if(c_type.startsWith("multipart")){
            // 파일 첨부가 된 폼객체로부터 요청이 된 경우라면?
            MultipartFile f = vo.getFile(); // 파일
            String fname = null;
            if(f.getSize() > 0){
                // 첨부된 파일을 원하는 위치에 저장(절대 경로)
                String realPath = application.getRealPath("resources/upload");
                fname = f.getOriginalFilename(); // 파일명
                try{
                    // 첨부된 파일을 원하는 위치에 저장한다.
                    f.transferTo(new File(realPath, fname)); // 파일 업로드됨
                    // DB에 저장할 수 있도록 파일명을 vo에 저장한다.
                    vo.setFile_name(fname);
                    vo.setOri_name(fname);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            vo.setIp(request.getRemoteAddr()); // IP 지정

            //DB에 저장
            bbsDAO.save(vo);
        }
        mv.setViewName("redirect:/bbs/list");
        return mv;
    }

    //삭제
    @RequestMapping(value = "/bbs/del", method = RequestMethod.POST)
    public ModelAndView del(String b_idx, String cPage) {
        ModelAndView mv = new ModelAndView();

        bbsDAO.delBbs(b_idx);
        mv.setViewName("redirect:/bbs/list");
        return mv;
    }

    //수정
    @RequestMapping("/bbs/edit")
    public ModelAndView edit(String b_idx, String title, String content, String fname, String oname, String ip) {
        ModelAndView mv = new ModelAndView();
        int result = bbsDAO.edit(b_idx, title, content, fname, oname, ip);
        mv.addObject("result", result);
        mv.setViewName("redirect:/bbs/write");
        return mv;
    }
}
