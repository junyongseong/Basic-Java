<%-- 로그아웃은 로그인할 때 세션에 저장한 "mvo"를 삭제하는것이 로그아웃이다.--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.removeAttribute("mvo");
  response.sendRedirect("index.jsp");
%>
