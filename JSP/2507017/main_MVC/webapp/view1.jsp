<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>페이지1</h1>
  <%-- request에 v1이라는 이름으로 저장한 값 출력  --%>
  <%
    //el하면 아래가 필요 없음  request, session, application, page 위 내의 데이터를 바로 꺼낼 수 있음
//    String v1= (String) request.getAttribute("v1");
  %>
  <h2>${v1}</h2>
</body>
</html>
