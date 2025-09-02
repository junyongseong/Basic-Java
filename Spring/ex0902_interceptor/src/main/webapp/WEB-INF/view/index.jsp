<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--참조할 페이지를 선언 --%>
<c:import url="nav.jsp" var="nav"/>
<c:import url="foot.jsp" var="foot"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" type="text/css" href="resources/css/common.css">
  <link rel="stylesheet" type="text/css" href="resources/css/main.css">

</head>
<body>
<article id="wrap">

<%--  상단영역--%>
<%--  jstl사용--%>
  ${nav}
<%--  아래는 include 이게 속도가 더 느림 --%>
<%--  <jsp:include page="nav.jsp"/>--%>

<%--  ==================== 콘텐츠 영역 ====================--%>
  <div id="contents">
    <ul class="benel">
      <li> <a href=""> <img src="resources/img/@img00.png"></a> </li>
    </ul>


    <div class="main_news">
      <div class="news_type01 fl">
        <p class="title">기브유 후원참여</p>
        <a href="" class="news_src">
          <span class="thum_img">
            <img src="resources/img/@img01.png" alt="기사사진1"/>
          </span>
          <span class="subject ellip">
            난청이지만 피아니스트가 되고픈 한별이의 이야기입니다.
          </span>
        </a>

        <div>
          <span class="writer">by togeter</span>
          <span class="more_view">자세히보기</span>
        </div>
      </div>

      <div class="news_type01 fc">
        <p class="title">기브유 후원금 쓰임현황</p>
        <a href="" class="news_src">
          <span class="thum_img">
            <img src="resources/img/@img02.png" alt="기사사진2"/>
          </span>
          <span class="subject ellip">
            레티하씨 가정에 희망의 집 선물로 행복한 꿈이 시작됩니다.
          </span>
        </a>
        <div>
          <span class="writer">by 한국좋은모임</span>
          <span class="more_view">자세히보기</span>
        </div>
      </div>

      <div class="news_type01 fr">
        <p class="title">기브유 나눔영상</p>
        <p href="" class="news_src">
          <span class="thum_img">
            <img src="resources/img/@img03.png" alt="기사사진3"/>
            <span id="btn_play" title="동영상 재생">
              <a href="https://www.youtube.com/watch?v=y3BV5WjptBA"></a>
            </span>
          </span>
          <span class="subject ellip">
            생수 1리터의 생명을 선물해주세요
          </span>
        </p>
        <div>
          <span class="writer">by togeter</span>
          <span class="more_view">자세히보기</span>
        </div>
      </div>
    </div>
    <div class="main_board">
      <!--공지사항-->
      <div class="board_type01 fl">
        <p class="title">공지사항</p>
        <span class="more_view">
            <a href="">더보기</a>
          </span>
        <ul class="notice">
          <li>
            <a href="" class="ellip">T-togeter 리뉴얼 오픈되었습니다.</a>
            <span class="date">2025.07.01</span>

          </li>

          <li>
            <a href="" class="ellip">GiveU이벤트 당첨자 공지입니다.</a>
            <span class="date">2025.06.30</span>
          </li>

          <li>
            <a href="" class="ellip">앞으로 코딩의 활용분야 범위는 우리 생활 모두가 될것입니다.</a>
            <span class="date">2025.06.29</span>
          </li>
        </ul>
      </div>

      <!--트위터-->
      <div class="board_type01 fc">
        <p class="title">T-together트위터</p>
        <span class="more_view">
            <a href="">더보기</a>
          </span>

        <article class="art">
                <span class="thum_img">
                  <img src="resources/img/@img04.png" alt="기사 이미지"/>
                </span>

          <span class="src">
                  [캠패인] 뜨거웠던 여름이 빨리지나가고 시원한 바람과 오색의 단풍들이 사색의 시산을 만들어주는 계절에
                </span>

        </article>
      </div>

      <!--배너-->
      <div class="board_type01 fr">
            <span class="banner b01">
              <a href="">배너1</a>
            </span>
        <span class="banner b02">
              <a href="">배너2</a>
            </span>
      </div>
    </div>
  </div>
<%--하단 영역--%>

${foot}

</article>
</body>
</html>
