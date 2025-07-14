<%@ page import="mybatis.vo.MemoVO" %>
<%@ page import="java.util.List" %>
<%@ page import="mybatis.dao.MemoDAO" %>
<%@ page import="mybatis.vo.MemVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>

  <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
  <style>
    #content{
      resize: none;
    }
    #list_table{
      border-collapse: collapse;
      width: 400px;
    }
    #list_table th, #list_table td{
      border: 1px solid #27a;
      padding: 3px;
    }
    #list_table thead th{
      background: #5ad;
      color: #fff;
    }
    #list_table caption{
      font-size: 30px;
      font-weight: bold;
      padding-bottom: 20px;
    }

    .btn{
      width: 70px;
      height: 20px;
      text-align: center;
      padding:0px;
    }

    .btn a{
      display: block;
      width: 100%;
      padding: 4px;
      height: 20px;
      line-height: 20px;
      background: #27a;
      color: #fff;
      border-radius: 3px;
      text-decoration: none;
      font-size: 12px;
      font-weight: bold;
    }
    .btn a:hover{
      background: #fff;
      color: #27a;
      border: 1px solid #27a;
    }

    #list_table thead tr:first-child td{
      border: none;
    }

    #write_win{ display: none; }

    #writer{
      background-color: #dedede;
      border: 1px solid #ababab;
    }
    .txt_center{
      text-align: center;
      height: 50px;
    }
    #error_win{
      display: none;
    }
    .show{
      display: block;
    }
  </style>
</head>
<body>
<%//memoadd에서 값을 받아온고 그것을 비교함
  String error=request.getParameter("error");

  //로그인이 되었는지 알아내야함
  Object obj=session.getAttribute("mvo");
  if (obj ==null)
    response.sendRedirect("index.jsp");//강제 페이지 이동

  MemVO vo = (MemVO) obj;

  String msg = null;
  if (error != null && error.equals("1"))
    msg="저장완료!";
  else if (error != null && error.equals("0"))
    msg ="저장실패";
%>

<div id="wrap">
  <table id="list_table">
    <caption>메모 리스트</caption>
    <colgroup>
      <col width="50px">
      <col width="*">
      <col width="80px">
      <col width="90px">
    </colgroup>
    <thead>
    <tr>
      <td colspan="4" >
        <p class="btn">
          <a href="javascript:writeMemo()">
            글쓰기
          </a>
        </p>
      </td>
    </tr>
    <tr>
      <th>번호</th>
      <th>내용</th>
      <th>글쓴이</th>
      <th>등록일</th>
    </tr>
    </thead>
    <tbody>
    <%
      // DAO를 통해 원하는 자원을 받는다.
      List<MemoVO> list = MemoDAO.getAll();

      // list가 null이 아니고, size가 0보다 큰 경우 반복
      if (list != null && list.size() > 0) {
        for (MemoVO mvo : list) {
    %>
    <tr>
      <td><%= mvo.getIdx() %></td>
      <td><%= mvo.getContent() %></td>
      <td><%= mvo.getWriter() %></td>
      <td><%= mvo.getReg_date() %></td>
    </tr>
    <%
        }
      }
    %>
    </tbody>
  </table>
</div>

<div id="write_win" title="글쓰기">
  <form action="memoadd.jsp" method="post" name="frm">
    <table>
      <tbody>

      <tr>
        <td><label for="writer">작성자:</label></td>
        <td>
          <input type="text" id="writer"
                 name="writer"
                 value="<%=vo.getM_name()%>" readonly/>
<%-- disabled는 값이 안넘어감 해보면 null값 찍힘 --%>
        </td>
      </tr>
      <tr>
        <td><label for="content">내용:</label></td>
        <td>
          <textarea cols="40" rows="6"
            id="content" name="content"></textarea>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <p class="btn">
            <%--  a태그는 form의 하위 문서가 아니기때문에  this.form사용불가능--%>
            <a href="javascript:exe()">
              저장
            </a>
          </p>
        </td>
      </tr>
      </tbody>
    </table>
  </form>
</div>


<div id="error_win" title="Message">
  <%=msg%>
</div>


<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
  <script>
    $(function() {
      <% if (msg != null) { %>
      $("#error_win").dialog({
      });
      <% } %>
    });
    function writeMemo(){
      //숨져진 div를 보이게
      let option = {
        width:"450px",
        modal:true,
        autoOpen:false,
        title : '메모장',
        resizable : false,
        draggable: false
      };

      $("#write_win").dialog(option);
      $("#write_win").dialog("open");

    };


    //저장버튼을 눌렀을때 해야할 행동
    function exe() {
      let writer =$("#writer").val().trim();
      let content =$("#content").val().trim();

      if (writer.length==0){
        alert("이름을 입력하세요");
        $("#writer").val("");
        $("#writer").focus();
        return;
      }
      if (content.length==0){
        alert("내용을 입력하세요");
        $("#content").val("");
        $("#content").focus();
        return;
      }

      document.forms[0].submit();
    }
  </script>
</body>
</html>
