package com.sist.ex0917_bbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0917_bbs.service.BbsService;
import com.sist.ex0917_bbs.service.CommService;
import com.sist.ex0917_bbs.util.Paging;
import com.sist.ex0917_bbs.vo.BbsVO;

@RestController
@RequestMapping("/board")
public class BbsController {

    @Autowired
    private BbsService bService;

    @Autowired
    private CommService cService;

    private int numPerPage = 7;
    private int pagePerPage = 5;

    @RequestMapping("/list")
    public Map<String, Object> list(@RequestParam("bname") String bname,
            String searchType, String searchValue, String cPage) {
        int nowPage = 1;

        if (cPage != null) {
            nowPage = Integer.parseInt(cPage);
        }

        //bname이 무조건 인자로 받기로 되어있지만 공백일떄는
        //기본값으로 BBS로 정하자
        if (bname.trim().length() == 0) {
            bname = "BBS";
        }

        //페이징 기법을 위해 총 게시물 수를 알아내야한다.
        int totalCount = bService.getTotalCount(bname, searchType, searchValue);

        //페이징 객체 생성
        Paging page = new Paging(numPerPage, pagePerPage);
        page.setTotalCount(totalCount);//총 게시물 수를 지정
        page.setNowPage(nowPage);//현재 페이지 값 지정

        //이제 페이징 객체로부터 begin end값을 얻어낸다.
        int begin = page.getBegin();
        int end = page.getEnd();

        //화면에 표현할 게시물 목록 받기
        List<BbsVO> list = bService.getList(bname, searchType, searchValue, begin, end);

        //반환할 Map구조를 생성하자
        Map<String, Object> map = new HashMap<>();
        map.put("ar", list);
        map.put("bname", bname);
        map.put("nowPage", nowPage);
        map.put("totalCount", totalCount);
        map.put("totalPage", page.getTotalPage());
        map.put("length", list.size());
        return map;
    }

    @RequestMapping("/getBbs")
    public Map<String, Object> getBbs(@RequestParam("b_idx") String b_idx) {
        Map<String, Object> map = new HashMap<>();
        BbsVO vo = bService.getBbs(b_idx);
        map.put("vo", vo);

        return map;
    }

    // 저장
    @RequestMapping("/add")
    public Map<String, Object> addBbs(@RequestBody BbsVO vo) {
        Map<String, Object> map = new HashMap<>();

        //첨부파일 처리... 여기선 생략 스프링 예제 참조
        int cnt = bService.addBbs(vo);
        map.put("cnt", cnt); //cnt가 0보다 크다면 정상적으로 저장 완료

        return map;
    }

}
