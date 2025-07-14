<%@ page import="mybatis.dao.MemoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  //요청시 한글처리
  request.setCharacterEncoding("utf-8");
  //파라미터 값들 받기
  String writer =request.getParameter("writer");
  String content =request.getParameter("content");
  String ip =request.getRemoteAddr();

  int cnt= MemoDAO.addMemo(writer, content,ip);
  //위 cnt는 저장된 레코드의 수를 저장한다.
  if (cnt>0){
    response.sendRedirect("memoList.jsp?error="+cnt);//momolist로 값을 넘김
    return;
  }

%>
</body>
</html>
