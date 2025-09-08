package com.sist.ex0908_bbs.mapper;

import java.util.List;

import com.sist.ex0908_bbs.vo.BbsVO;

public interface BbsMapper {

    int totalCount(String bname);

    List<BbsVO> list(String bname, int begin, int end);

    int add(BbsVO vo);

    BbsVO getBbs(String b_idx);

    int updateBbs(BbsVO vo); // 게시글 수정

    int deleteBbs(String b_idx); // 게시글 삭제
}
