<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="mybatis.vo.BbsVO" %>
<%
  Object obj = request.getAttribute("vo");
  BbsVO vo = null;
  if(obj != null){
    vo = (BbsVO)obj;
  }
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>글 수정</title>
</head>
<body>
<h2>게시글 수정</h2>
<form action="/Controller" method="post" enctype="multipart/form-data" name="ff">
  <table border="1" cellpadding="5">
    <tr>
      <th>제목</th>
      <td><input type="text" name="title" value="<%= vo.getSubject() %>" required></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input type="text" name="writer" value="<%= vo.getWriter() %>" required></td>
    </tr>
    <tr>
      <th>내용</th>
      <%System.out.println(vo.getContent());%>
      <td><textarea name="content" rows="10" cols="60"><%=vo.getContent()%></textarea></td>
    </tr>
    <tr>
      <th>기존 파일</th>
      <td><%= vo.getFile_name() != null ? vo.getFile_name() : "없음" %></td>
    </tr>
    <tr>
      <th>파일첨부</th>
      <td><input type="file" name="file"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="button" value="수정완료"onclick="goEdit()">
        <input type="reset" value="다시작성">
      </td>
    </tr>
  </table>
  <input type="hidden" name="bname" value="BBS">
  <input type="hidden" name="type" value="edit">
  <input type="hidden" name="b_idx" value="<%= vo.getB_idx() %>">
  <input type="hidden" name="cPage" value="<%= request.getParameter("cPage") %>">
</form>

<script>
  function goEdit() {
    const form = document.ff;
    // Controller로 보낼 때 URL에 type 파라미터 직접 붙이기
    form.action = "Controller?type=edit";
    form.submit();
  }
</script>
</body>
</html>