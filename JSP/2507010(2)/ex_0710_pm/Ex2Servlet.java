package com.sist.ex_0710_pm;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Ex2")
public class Ex2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //파라미터 값 받기
        String empno = request.getParameter("empno_tx");
        EmpVO vo = EmpDAO.getEmp(empno);

        StringBuffer sb = new StringBuffer();
        if (vo == null) {
            sb.append("<h3>사원이 존재하지 않습니다.</h3>");
        }else{
            sb.append("<h2>사번 검색 결과</h2>");
            sb.append("<ul>");
            sb.append("<li>사번: " + vo.getEmpno() + "</li>");
            sb.append("<li>이름: " + vo.getEname() + "</li>");
            sb.append("<li>직급: " + vo.getPosname() + "</li>");
            sb.append("<li>부서번호: " + vo.getDeptno() + "</li>");
            sb.append("</ul>");

        }
        PrintWriter out=response.getWriter();
        out.println(sb.toString());

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
