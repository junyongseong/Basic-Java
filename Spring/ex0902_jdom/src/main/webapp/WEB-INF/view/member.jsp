<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <meta charset="UTF-8">
  <style>
    #t1{
      border-collapse: collapse;
      width: 400px;
    }
    #t1 caption{
      text-indent: -9999px;
      height: 0;
    }
    #t1 th{
      padding: 6px;
      background-color: lightgray;
      /*border: 1px solid black;*/
      border: 1px black;
    }
    #t1 td{
      padding: 4px;
      border: 1px solid black;
    }
    #t1 .no-border{border: none;}

    #type, #value, #btn1{padding: 5px;}
    .w150{width: 150px}
  </style>
</head>
<body>
<h1>회원 목록</h1>
<hr/>
<table id="t1">
  <caption>회원목록 테이블</caption>
  <thead>
  <tr>
    <td colspan="3" class="no-border">
      <form action="search" method="post" id="searchForm">
        <select id="type" name="type">
          <option value="0">이름</option>
          <option value="1">이메일</option>
          <option value="2">연락처</option>
        </select>
        <input type="text" id="value" name="value" class="w150">
        <button type="button" id="btn1">검색</button>
      </form>
    </td>
  </tr>
  <tr>
    <th>회원명</th>
    <th>이메일</th>
    <th>연락처</th>
  </tr>
  </thead>
  <tbody>
    <c:forEach items="${ar}" var="vo">
      <tr>
        <td>${vo.name}</td>
        <td>${vo.email}</td>
        <td>${vo.phone}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
  $(function () {

    $("#btn1").click(function () {
      $.ajax({
        url: "t1Search",
        type : "get",
        data: {
          type: $("#type").val(),
          value: $("#value").val()
        },
        dataType: "json"
      }).done(function (res) {
        console.log(res);
        let code = "";
        // if (res.ar[i] !=null &&res.length>0){}
        for (let i = 0; i < res.length; i++) {
          let vo = res[i];  // 배열 원소 꺼내기
          code += "<tr>"
                  + "<td>" + vo.name + "</td>"
                  + "<td>" + vo.email + "</td>"
                  + "<td>" + vo.phone + "</td>"
                  + "</tr>";
        }
        $("#t1 tbody").html(code);
      });
    });

    // 엔터처리 (킹짱피티)
    $("#value").keydown(function(e) {
      if (e.key === "Enter" || e.keyCode === 13) {
        e.preventDefault();       // form submit 막기
        $("#btn1").click();       // 버튼 클릭 이벤트 실행
      }
    });

  })
</script>

</body>
</html>
