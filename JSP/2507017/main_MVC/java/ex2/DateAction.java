package ex2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class DateAction {
    public String execute(HttpServletRequest request,//String으로 반환하는 이유는 jsp경로를 반환하기 위해
                          HttpServletResponse response){
        LocalDate date = LocalDate.now();

        request.setAttribute("date",date.toString());//현재 날짜를
        //forward될 request에 "date"라는 이름으로 저장!

        //보여질 jsp경로를 반환하자!
        return "/ex2/page1.jsp";
    }
}
