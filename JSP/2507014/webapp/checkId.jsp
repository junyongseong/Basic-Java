<%@ page import="mybatis.dao.MemberDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String u_id = request.getParameter("u_id");

  //1이면 이미 존재 즉 중복 0이면 사용가능
  int cnt= MemberDAO.getid(u_id);
  if (cnt>0){//이미 있는 경우
      response.sendRedirect("reg.jsp?error="+cnt);//reg.jsp로 값을 넘김
      return;
  }
%>