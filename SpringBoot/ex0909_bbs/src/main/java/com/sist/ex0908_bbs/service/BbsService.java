package com.sist.ex0908_bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.ex0908_bbs.mapper.BbsMapper;
import com.sist.ex0908_bbs.vo.BbsVO;

@Service
public class BbsService {
    @Autowired
    private BbsMapper bbsMapper;
    public int getTotalCount(String bname) {
        return bbsMapper.totalCount(bname);
    }

    public BbsVO[] getList(String bname, int begin, int end) {
        BbsVO[] ar = null;
        List<BbsVO> list = bbsMapper.list(bname, begin, end);

        if(list != null && !list.isEmpty()) {
            ar = new BbsVO[list.size()];
            list.toArray(ar);
        }

        return ar;
    }
    public int getAdd(BbsVO vo){
        return bbsMapper.add(vo);
    }

}
