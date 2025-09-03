<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <meta charset="UTF-8">
</head>
<body>
<header>
  <h1>카카오 지도 검색</h1>
</header>
<form onsubmit="return false;">
  주소를 입력하시오: <input type="text" id="inputsearch" name="inputsearch">
  <button type="button"onclick="searchAddress()">검색</button>
</form>
<div id="map" style="width: 600px; height:400px"></div><br/>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2b57b7f6652d736e301f963cbb72dcc7"></script>

<script>
  var container = document.getElementById('map');
  var options = {
    center: new kakao.maps.LatLng(37.499334, 127.033162),
    level: 3
  };
  // 지도를 생성합니다
  var map = new kakao.maps.Map(container, options);
  // 주소-좌표 변환 객체를 생성합니다
  var geocoder = new kakao.maps.services.Geocoder();

  // 마커가 표시될 위치입니다
  var markerPosition  = new kakao.maps();//이거 재활용

  // // 마커를 생성합니다
  // var marker = new kakao.maps.Marker({
  //   position: markerPosition
  // });
  function searchAddress() {
    var input =document.getElementById("inputsearch").value;

    if (!input){
      alert("주소를 입력해주세요");
      return;
    }

  }
  // // 마커가 지도 위에 표시되도록 설정합니다
  // marker.setMap(map);

  // 주소로 좌표를 검색합니다
  geocoder.addressSearch(input, function(result, status) {

    // 정상적으로 검색이 완료됐으면
    if (status === kakao.maps.services.Status.OK) {

      var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

      // 결과값으로 받은 위치를 마커로 표시합니다
      var marker = new kakao.maps.Marker({
        map: map,
        position: coords
      });

      // 인포윈도우로 장소에 대한 설명을 표시합니다
      var infowindow = new kakao.maps.InfoWindow({
        content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
      });
      infowindow.open(map, marker);

      // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
      map.setCenter(coords);
    }else{
      alert("검색 실패");
      return;
    }
  });
</script>
</body>
</html>
