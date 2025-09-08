
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <meta charset="UTF-8">
  <style>
    #box{
      width: 300px;
      height: 300px;
      border: 1px solid #000;
    }
  </style>
</head>
<body>
<h1> 비동기식 통신으로 JSON결과 받기</h1>
<hr/>
<button type="button" id="bt1">연습1</button> &nbsp;
<button type="button" id="bt2">사원</button> &nbsp;
<div id="box">
  
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<%--Jquery넣기--%>
<script>
  $(function () {
    //이벤트 감지자 등록
    $("#bt1").click(function () {
      //연습1 버튼을 클릭할 떄마다 수행하는 곳
      $.ajax({
        url: "/callTest",
        type : "post",
        dataType : "json"
      }).done(function (res) {
        //비동기식 통신이 성공했을때 수행하는곳
        console.log(res);
        let code="<ul>";
        for (let i=0; i<res.length;i++){
            code += "<li>"
            code +=res.ar[i].ename;
            code +=", ";
            code +=res.ar[i].email;
            code += "</li>"
        }
          code +="</ul>"
          $("#box").html(code);
      })
    })

      $("#bt2").click(function () {
          $.ajax({
              url: "/callTest2",   // 사원 전용 매핑
              type : "post",
              dataType : "json"
          }).done(function (res) {
              console.log(res);
              let code="<ul>";
              for (let i=0; i<res.count; i++){
                  code += "<li>";
                  code += res.empList[i].empno + " , ";   // 사원번호
                  code += res.empList[i].ename + " , ";   // 사원이름
                  code += res.empList[i].job + " , ";     // 직무
                  code += res.empList[i].hiredate; //입사일
                  code += "</li>";
              }
              code += "</ul>";
              $("#box").html(code);
          });
      });
  })
</script>

</body>
</html>
