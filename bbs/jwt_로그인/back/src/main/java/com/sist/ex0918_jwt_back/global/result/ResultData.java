package com.sist.ex0918_jwt_back.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 제네릭 타입
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> {
    private int totalCount; // length
    private String msg;     // 메세지
    private T data;         // 내가 나중에 ResultData 생성할 때 리스트를 만들면 리스트 타입의 bbs가 생길거임

    // data 있는 경우 (리스트나 객체를 같이 내려줄 때)
    public static <T> ResultData<T> of(int totalCount, String msg, T data){
        return new ResultData<>(totalCount, msg, data);
    }

    // data 없는 경우 (단순히 개수와 메세지만 내려줄 때)
    public static <T> ResultData<T> of(int totalCount, String msg){
        return new ResultData<>(totalCount, msg, null);
    }
}
