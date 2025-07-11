  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
      <title>Title</title>
  </head>
  <body>
    <%
      String id =request.getParameter("s_id");
      String pw =request.getParameter("s_pw");
    %>
      <h2>아이디 : <%=id%></h2>
      <h2>비밀번호 : <%=pw%></h2>
  <%--스크립트 릿은 지역변수인데 사용할 수 있는 이유는 선언문을 제외학
  출력문과 스크립트 릿은 서비스 함수에 들어가기때문에 사용할 수 있음--%>
  </body>
  </html>
