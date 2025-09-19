package com.sist.ex0918_jwt_back.domain.member.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sist.ex0918_jwt_back.global.jpa.BaseEntity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
public class Member extends BaseEntity{ //여기안에 b_idx write같은거 존재

    private String mid,mname;

    //비밀번호는 외부로 가는것이 보안상 좋지 않기 때문에
    //JSON으로 변환을 하지 못하게 설정@@@!!
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String mpwd;
    private String accessToken;
    private String refreshToken;
}
