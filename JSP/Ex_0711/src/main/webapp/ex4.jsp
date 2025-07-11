<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String num =request.getParameter("s_num");
    //NUM은 문자열이므로 연산을 수행할 수 없다. 그래서
    //정수로 변환한다.
//    if (num !=null) {
        int dan = Integer.parseInt(num);
//    }
%>

<%--  계산식을 만들기 위한 스크립트 릿--%>
<%="입력값 : "+num%><br/>
  <%
      StringBuffer sb= new StringBuffer();
    for(int i=1; i<10;i++){
        sb.append(num);
        sb.append("*");
        sb.append(i);
        sb.append("=");
        sb.append(dan*i);
        sb.append("<br/>");
    }%>
<%=sb.toString()%>

<%--출력문--%>
</body>
</html>
