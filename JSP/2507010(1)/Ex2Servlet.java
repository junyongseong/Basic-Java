package com.sist.ex_0710;

import mybatis.vo.EmpVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

@WebServlet("/Ex2")
public class Ex2Servlet extends HttpServlet {
    SqlSessionFactory factory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        Reader r = null;
        try {
            r = Resources.getResourceAsReader("mybatis/config/conf.xml");
            factory =new SqlSessionFactoryBuilder().build(r);
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //한글처리
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String empno = request.getParameter("empno_tx");

        SqlSession ss = factory.openSession();
        EmpVO vo = ss.selectOne("emp.searchempno", empno);


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

        ss.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
