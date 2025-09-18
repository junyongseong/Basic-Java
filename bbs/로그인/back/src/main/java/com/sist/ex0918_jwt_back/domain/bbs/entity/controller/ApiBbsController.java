package com.sist.ex0918_jwt_back.domain.bbs.entity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0918_jwt_back.domain.bbs.entity.service.BbsService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sist.ex0918_jwt_back.domain.bbs.entity.Bbs;
import com.sist.ex0918_jwt_back.global.result.ResultData;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bbs")
public class ApiBbsController {
    private final BbsService bbsService;

    @GetMapping("")
    public ResultData<List<Bbs>> getList() {
        // Map<String,Object> map = new HashMap<>();
        List<Bbs> list = this.bbsService.geList();
        // map.put("ar",list);
        // map.put("length", list.size());
        String msg ="fail";
        if(list != null && list.size()>0)
            msg="success";
        // return map;
        return ResultData.of(list.size(), msg,list);//totalcount
    }

    @GetMapping("/{b_idx}")
    public Map<String,Object> getBbs(@PathVariable("b_idx")Long b_idx) {
        Map<String,Object> map = new HashMap<>();
        Bbs bbs = this.bbsService.getBbs(b_idx);
        map.put("bbs",bbs);

        return map;
    }

}
