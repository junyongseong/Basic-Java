package com.sist.ex0918_jwt_back.domain.bbs.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sist.ex0918_jwt_back.domain.bbs.entity.Bbs;
import com.sist.ex0918_jwt_back.domain.bbs.entity.repository.BbsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor//초기화 되지 않은 상수(final) 필드나,
                        //@NonNull이 붙은 필드들에 대해 처리한다.
public class BbsService {
    private final BbsRepository bbsRepository;

    public List<Bbs> geList(){
        return bbsRepository.findAll();
    }

    public Bbs getBbs(Long b_idx){
        Bbs bbs = null;

        Optional<Bbs> opt =bbsRepository.findById(b_idx); //findbyid는 내가 만든게 아닌 jpa가 준거라
                                                        //optional로 받아줘야함 이건 Bbs가 아닌 optional
        if(!opt.isEmpty())//비어있지 않으면 즉 뭔가 들어옴
            bbs =opt.get(); //bbs에 opt 옵셔널이 가지고 있는 무언갈 넣어줌
        return bbs;
    }
    public Bbs create(String title, String writer, String content){
        // Bbs bbs = new Bbs(title,writer,content);
        //이렇게 하면 순서가 바뀌었을경우 안됨 그래서 빌더사용이 나음

        Bbs bbs= Bbs.builder().title(title)
        .writer(writer)
        .content(content)
        .build();
        return bbsRepository.save(bbs); //db에 저장
    }
}
