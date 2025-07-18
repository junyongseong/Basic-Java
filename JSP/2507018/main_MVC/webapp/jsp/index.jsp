<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">

  <style>
    .table{
      width: 600px;
      border-collapse: collapse;
    }
    .table th, .table td{
      border: 1px solid #000;
      padding: 5px;
    }
    .table caption{
      text-indent: -9999px;
      height: 0px;
    }
    .txt_R{text-align: right;}
    .noBorder{border: none !important;}
  </style>
</head>
<body>
  <div id="wrap">
    <header>
      <h1>사원목록</h1>
    </header>
    <article>
      <table class="table">
        <caption>사원 테이블</caption>
        <thead>
        <tr>
          <td colspan="6" class="txt_R noBorder">
<%--            <button type="button" id="total_btn" onclick="javascript:location.href='Controller?type=total'">전체보기</button>--%>
            <button type="button" id="all_btn">전체(비동기식)</button>
            <button type="button" id="total_btn" onclick="total()">전체</button>
            <button type="button" id="search_btn">검색</button>
            <button type="button" id="add_btn"
            onclick="javascript:location.href='Controller?type=add'">추가</button>
  <button type="button" id="dept_btn"
          onclick="javascript:location.href='Controller?type=dept'">부서목록</button>
          </td>
        </tr>
          <tr>
            <th>사번</th>
            <th>이름</th>
            <th>직종</th>
            <th>입사일</th>
            <th>급여</th>
            <th>부서</th>
          </tr>
        </thead>
        <tbody>

        </tbody>
      </table>
    </article>
  </div>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
<script>
  function total() {
    location.href='Controller?type=total';
  }
  $(function all() {
    $("#all_btn").click(function () {
    $.ajax({
      // 요청은 컨트롤러
      url:"Controller",
      // 전송방식
      type:"post",
      //파라미터는 all 즉 Allaction만들어야함 ->allaction에서 all.jsp로 감
      data:{type:"all"}
    }).done(function (res) {//res는 AllAcion이 수행된 후
      //응답되는 all.jsp에서 반복수행된 tr들
      console.log(res);
      // 테이블 태그에 테이블이란 클래스가 있는데 자식요소인 tbody에 res는
      //all.jsp에서 표현하는 tr들은 tbody안에 들어감
      $("table.table>tbody").html(res)
      });
    });
  });
</script>
</body>
</html>
