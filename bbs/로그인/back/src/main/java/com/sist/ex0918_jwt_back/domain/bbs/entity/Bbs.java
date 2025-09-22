package com.sist.ex0918_jwt_back.domain.bbs.entity;

import com.sist.ex0918_jwt_back.global.jpa.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder//현재클래스와 상위 클래스의 필드값을 저장하기 위한 메서드들 포함
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true) //부모가 가지는 함수 사용(필드 포함)
public class Bbs extends BaseEntity{

    @Column(columnDefinition ="bigint default 0")
    private Long hit;

    @Column
    private Long state = 0L; //위 default 0한거와 같음

    @NonNull
    private String title,content, writer;

    @PrePersist
    public void initStatus(){//save함수로 데이터가 저장(insert)되기 전에 수행함
        if(state == null){
            state = 0L;
            hit = 0L;
        }
    }
}
