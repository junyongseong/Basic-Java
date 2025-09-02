<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="nav.jsp" var="nav"/>
<c:import url="foot.jsp" var="foot"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/common.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/sub_tab.css">

</head>
<body>
<article id="wrap">
    ${nav}
    <!-- =============== 상단영역 끝 ===============-->
    <!-- =============== 콘텐츠 영역 ===============-->
    <div id="contents">
        <p>
            <img src="/resources/img/@img05.png" alt="이미지5"/>
        </p>
        <div class="tab_type01">
            <ul>
                <li id="t1"><a href="javascript:ex1()">위드유</a></li>
                <li id="t2" class="selected"><a href="javascript:ex2()">위드유 영상</a></li>
                <li id="t3"><a href="javascript:ex3()">위드유 대화</a></li>
            </ul>
        </div>
        <!-- 각 탭에 표현할 내용들 -->
        <div id="tab1" class="tab_cont">
            위드유 내용입니다.!
        </div>
        <div id="tab2" class="tab_cont show">
            T1은 4일 오전 (이하 한국시간)  캐나다 밴쿠버 퍼시픽 콜리세움에서 열린
            ‘2025 미드 시즌 인비테이셔널(이하 MSI)’ 브래킷 스테이지 1라운드 CTBC 플라잉 오이스터(CFO)와 경기에서
            1세트 승리 이후 2, 3세트를 패하며 매치포인트를 허용했지만, 4, 5세트를 잡아내면서 힘겨운 3-2 역전승을 거뒀다.
            이로써 T1은 승자조 2라운드에 진출해 모비스타 코이(MKOI) 꺾은 빌리빌리 게이밍(BLG)와 3라운드 진출을 다투게 됐다.
        </div>
        <div id="tab3" class="tab_cont">
            위드유 Tab 내용입니다.!
        </div>
    </div>
    <!-- =============== 콘텐츠 영역 끝 ===============-->

    <!-- =============== 하단 영역 =============== -->
    ${foot}
    <!-- =============== 하단 영역 끝=============== -->
    <article>
        <script>
            function ex1(){
                //첫번째 Tab을 클릭했을 때 수행하는 곳

                //현재 문서에서 아이디가 t1인 요소를 검색한다.
                var t1 = document.getElementById("t1");
                var t2 = document.getElementById("t2");
                var t3 = document.getElementById("t3");

                t1.className = "selected";//<li class="selected".......
                t2.className = "";//기존에 있는 지정된 class를 삭제한다.
                t3.className = "";
                //-------------탭 처리 ------------------------
                // 해당 탭에 표현한 내용처리를 지금부터 하자!
                //먼저 tab1,tab2,tab3이라는 아이디를 가진 요소들 모두 검색하자
                var tab1 =document.getElementById("tab1");
                var tab2 =document.getElementById("tab2");
                var tab3 =document.getElementById("tab3");
                tab1.className = "tab_cont show";
                tab2.className = "tab_cont";
                tab3.className = "tab_cont";

            }

            function ex2(){
                //첫번째 Tab을 클릭했을 때 수행하는 곳

                //현재 문서에서 아이디가 t1인 요소를 검색한다.
                var t1 = document.getElementById("t1");
                var t2 = document.getElementById("t2");
                var t3 = document.getElementById("t3");

                t2.className = "selected";//<li class="selected".......
                t1.className = "";//기존에 있는 지정된 class를 삭제한다.
                t3.className = "";
                //-------------탭 처리 ------------------------
                // 해당 탭에 표현한 내용처리를 지금부터 하자!
                //먼저 tab1,tab2,tab3이라는 아이디를 가진 요소들 모두 검색하자
                var tab1 =document.getElementById("tab1");
                var tab2 =document.getElementById("tab2");
                var tab3 =document.getElementById("tab3");
                tab2.className = "tab_cont show";
                tab1.className = "tab_cont";
                tab3.className = "tab_cont";

            }

            function ex3(){
                //첫번째 Tab을 클릭했을 때 수행하는 곳

                //현재 문서에서 아이디가 t1인 요소를 검색한다.
                var t1 = document.getElementById("t1");
                var t2 = document.getElementById("t2");
                var t3 = document.getElementById("t3");

                t3.className = "selected";//<li class="selected".......
                t2.className = "";//기존에 있는 지정된 class를 삭제한다.
                t1.className = "";
                //-------------탭 처리 ------------------------
                // 해당 탭에 표현한 내용처리를 지금부터 하자!
                //먼저 tab1,tab2,tab3이라는 아이디를 가진 요소들 모두 검색하자
                var tab1 =document.getElementById("tab1");
                var tab2 =document.getElementById("tab2");
                var tab3 =document.getElementById("tab3");
                tab3.className = "tab_cont show";
                tab2.className = "tab_cont";
                tab1.className = "tab_cont";
            }
        </script>
    </article>


</article>
</body>
</html>
