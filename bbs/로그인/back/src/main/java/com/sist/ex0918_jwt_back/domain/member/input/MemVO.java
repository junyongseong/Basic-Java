package com.sist.ex0918_jwt_back.domain.member.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemVO {

    private String mid, mname;
    private String mpwd;
}
