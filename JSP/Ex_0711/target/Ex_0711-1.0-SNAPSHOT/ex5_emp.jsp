<%@ page import="java.util.List" %>
<%@ page import="mybatis.vo.EmpVO" %>
<%@ page import="mybatis.dao.EmpDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>전체 사원</h1>
  <hr/>
  <%
    //DAO를 통해 원하는 자원을 받는다.
    List<EmpVO> list= EmpDAO.getAll();
  %>
  <ul>
    <%
      for (EmpVO vo:list){%>
<%--      for문 안이지만 html영역--%>
  <li><%=vo.getEmpno()%>,<%=vo.getEname()%></li>
    <% }%>
  </ul>
</body>
</html>
