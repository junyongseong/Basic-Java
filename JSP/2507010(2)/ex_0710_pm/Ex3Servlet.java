package com.sist.ex_0710_pm;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/Ex3")
public class Ex3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //요청및 응답시 한글처리
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String searchType =request.getParameter("searchType");
        String searchValue =request.getParameter("searchValue");
//        //emp.search라는 sql문을 호출하기 위해 파라미터들을 Map구조에 담아야 한다.
//        Map<String,String> map = new HashMap<>();
//        map.put("searchType",searchType);
//        map.put("searchValue",searchValue);
//        dao가 해주는부분이라 지워도 okay

        EmpVO[] list = EmpDAO.search(searchType,searchValue);

        StringBuffer sb=new StringBuffer("<ol>");
        for (EmpVO vo :list){
            sb.append("<li>");
            sb.append(vo.getEmpno());//사번
            sb.append(",");
            sb.append(vo.getEname());//이름
            sb.append(",");
            sb.append(vo.getPosname());//부서이름
            sb.append(",");
            sb.append(vo.getDeptno());//부서코드
            sb.append("</li>");
        }//for의 끝
        sb.append("</ol>");

        //응답을 위한 스트림 생성
        PrintWriter out =response.getWriter();
        out.println("<h2>검색 결과</h2>");
        out.println("<hr/>");
        out.println(sb.toString());
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
