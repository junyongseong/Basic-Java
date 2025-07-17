package ex3;

import ex2.DateAction;
import ex2.GreetAction;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Controller3")
public class Controller3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //type이라는 파라미터를 받기
        String type =request.getParameter("type");
        String viewPath =null;//jsp경로를 저장할 변수

//        if (type ==null ||type.equalsIgnoreCase("emp")){
//            EmpAction action = new EmpAction();
//            viewPath = action.execute(request, response);
//        } else if (type.equalsIgnoreCase("dept")) {
//            DeptAction action = new DeptAction();
//            viewPath= action.execute(request, response);
//        }
        //인터페이스 만들고 오버라이드
        Action action=null;
//        if (type ==null ||type.equalsIgnoreCase("emp")){
//            action = new EmpAction();
//            //viewPath = action.execute(request, response);
//        } else if (type.equalsIgnoreCase("dept")) {
//            action = new DeptAction();
//        }else if (type.equalsIgnoreCase("memo")) {
//            action = new MemoAction();
//        }
        if(type !=null){
            switch (type){
                case "emp":
                    action = new EmpAction();
                    break;
                case "dept":
                    action = new DeptAction();
                    break;
                case "memo":
                    action = new MemoAction();
                    break;
                default:
                    action = new EmpAction();

            }

        }
        viewPath= action.execute(request, response);

        //forward를 하기 위해 필요한 객체
        RequestDispatcher disp = request.getRequestDispatcher(viewPath);
        disp.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
