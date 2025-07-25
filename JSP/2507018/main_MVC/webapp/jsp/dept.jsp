<%@ page import="mybatis.vo.EmpVO" %>
<%@ page import="mybatis.vo.DeptVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
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
    <h1>부서목록</h1>
  </header>
  <article>
    <table class="table">
      <caption>부서 테이블</caption>
      <thead>
      <tr>
        <td colspan="6" class="txt_R noBorder">
          <button type="button" id="total_btn"
                  onclick="javascript:location.href='Controller?type=total'">사원전체보기</button>
          <button type="button" id="search_btn">검색</button>
          <button type="button" id="add_btn"
                  onclick="javascript:location.href='Controller?type=add'">사원추가</button>
        </td>
      </tr>
      <tr>
        <th>부서번호</th>
        <th>부서이름</th>
        <th>도시명</th>

      </tr>
      </thead>
      <tbody>
      <%
        Object obj = request.getAttribute("ar");
        if (obj!=null){
          DeptVO[] ar=(DeptVO[]) obj;
          for (DeptVO vo: ar){
      %>
      <tr>
        <td><%=vo.getDeptno()%></td>
        <td><%=vo.getDname()%></td>
        <td><%=vo.getCity()%></td>
      </tr>
      <%
        }//for의 끝
      }else {
      %>
      <tr>
        <td colspan="6" >
          현재 등록된 정보가 없습니다.
        </td>
      </tr>
      <%
        }
      %>
      </tbody>
    </table>
  </article>
</div>

</body>
</html>
