package com.sist.ex0908_bbs.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BbsVO {
    private String b_idx, subject, writer, content, file_name, ori_name, pwd, write_date, ip, hit, bname, status;

    private List<CommVO> c_list; // 댓글 여러개를 저장하는 공간
    private  MultipartFile file; // 첨부파일 한개를 저장하는 공간
}
