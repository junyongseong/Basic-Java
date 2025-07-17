package ex3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
//    추상 메서드
    String execute(HttpServletRequest request, HttpServletResponse response);
}
