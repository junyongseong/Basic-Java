<%@ page import="mybatis.vo.MemVO" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public int useSize(File f){
        //인자로 전달된 FIle객체가 폴더여야 한다.
        //이 폴더의 하위요소들의 File용량을 더해야 한다.
        //우선 하위요소들을 모두 얻어낸다.
        File[] list = f.listFiles(); // 하위 요소들이 다 나온다.
        int size = 0;
        //파일일 경우엔 용량을 size에 누적시키고, 폴더의 일경우엔 현재 함수를 다시 호출한다.(재귀호출)
        for (File sf : list){
            if (sf.isFile()){
                size+=sf.length(); //용량 누적
            }else {
                size+=useSize(sf);
            }
        }//for의 끝
        return size;
    }
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
    <STYLE>

        table{
            width: 600px;
            border-collapse: collapse;
        }
        table th, table td{
            border: 1px solid #27a;
            padding: 5px;
        }

        table th{
            background-color: #bcbcbc;
        }

        .title{
            width: 25%;
            background-color: #bcbcbc;
        }
        .btn{
            width: 70px;
            height: 20px;
            text-align: center;
            padding:0px;
            display: inline-block;
            margin-right: 20px;
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

        #s_id, #s_pw{
            width: 80px;
            border: 1px solid #27a;
            border-radius: 3px;
            padding: 4px;
        }
        div#log_fail, div#log_suc{
            width: 170px;
            border: 1px solid #27a;
            border-radius: 3px;
        }
        .hide{ display: none; }
        .show{ display: block; }

        div#box{
            display: inline-block;
            width: 65px;
            height: 20px;
            padding: 0;
            margin: 0;
            margin-left: 3px;
        }
        .success{
            color: #2277aa;
            font-weight: bold;
            font-size: 11px;
        }
        .fail{
            color: #f00;
            font-weight: bold;
            font-size: 11px;
        }

        div#my_alert, #upload_win, #folder_win{
            display: none;
        }
        .w50{
            width: 50px;
        }
        .w80{
            width: 80px;
        }
        .before, .after{
            display: inline-block;
            margin-left: 30px;
        }

    </STYLE>
</head>
<body>
<%
    int totalSize = 1024*1024*1000; //1기가
    int useSize = 0;

    //로그인을 수행한 상태들만 허용하는 페이지이므로 로그인 검증하자!
    Object obj = session.getAttribute("mvo");

    if (obj != null){
        MemVO mvo = (MemVO) obj;
        //현재페이지로 올떄 파라미터 하나 받는다. 그것은 바로 cPath다.
        //만약 없으면 null을 받는다는 것을 기억하자!!
        String dir = request.getParameter("cPath");
        String fname = request.getParameter("f_name"); //폴더명

        //만약 dir이 null이면, 접속한 사용자의 id를 넣어 준다.
        if(dir == null){
            dir = mvo.getM_id();
        }else {
            //이미 myDisk에 들어  왔다가 다른 작업(폴더)를 클릭하여, 요청한 경우
            if (fname != null && fname.trim().length() > 0){
                dir = dir+"/"+fname; // mmm/folder1
            }
        }

        //dir이 구해진 후 나중에 파일 올리기를 할때 upload.jsp에서 필요하므로
        //세션에 미리 저장해 두자!
        session.setAttribute("dir",dir);
        String r_path= application.getRealPath("/members/"+mvo.getM_id());
        useSize = useSize(new File(r_path));
%>
<H1>My Disk Service</H1>
<Hr/>
<%=mvo.getM_name()%>(<span class="m_id"><%=mvo.getM_id()%></span>)님의 디스크
&nbsp;[<a href="javascript:home()">Home</a>]
<hr/>
<table>
    <caption>디스크사용량 테이블</caption>
    <tbody>
    <tr>
        <th class="title">전체용량</th>
        <td><%=totalSize/1024%>KB</td>
    </tr>
    <tr>
        <th class="title">사용량</th>
        <td><%=useSize/1024%>KB</td>
    </tr>
    <tr>
        <th class="title">남은용량</th>
        <td><%=(totalSize-useSize)/1024%>KB</td>
    </tr>
    </tbody>
</table>
<hr/>
<div id="btn_area">
    <p class="btn">
        <a href="javascript:selectFile()">파일올리기</a>
    </p>
    <p class="btn">
        <a href="javascript:dialogFolder()">폴더생성</a>
    </p>
    <p class="btn">
        <a href="javascript:exe()">파일생성</a>
    </p>
</div>

<hr/>
<label for="dir">현재위치:</label>
<span id="dir"><%=dir%></span>
<p/>
<p class="before">
    <a href="javascript:before()">상위로</a>
</p>

<table>
    <caption>위치 폴더 안에 내용을 표현하는 테이블</caption>
    <thead>
    <tr>
        <th class="w50">구분</th>
        <th>폴더 및 파일명</th>
        <th class="w80">삭제여부</th>
    </tr>
    </thead>
    <tbody>
    <%

        //[상위로] 기능을 구현
        if(!dir.equalsIgnoreCase(mvo.getM_id())){
            //예를 들어 현재 위치가 "mmm/abc/1234라면 상이로 기능은 "mmm/abc"를 의미한다.
            int idx =dir.lastIndexOf("/");
            String upPath=dir.substring(0,idx);//idx전까지
    %>
    <tr>
        <td colspan="2">
            <a href ="javascript:goUp('<%=upPath%>')">../</a>
        </td>
    </tr>
    <%
        }

        //현재 위치 값(dir)을 가지고 File객체를 만들기 위해 절대경로
        String realPath = application.getRealPath("/members/"+dir);

        //절대경로를 만든 이유는 File객체를 생성하여 하위에 있는 파일 또는 폴더들을 얻기 위함이다.
        File s_file = new File(realPath); //c:/.../members/[접속한 유저]
        //위에서 만든 File객체 안에 있는 하위요소(파일 및 폴더들 얻기)
        File[] sub_list = s_file.listFiles();

        for (File f : sub_list){
    %>
    <tr>
        <td>
            <%if(f.isFile()){out.print("파일");}%>
        </td>
        <td>
            <% if (f.isDirectory()){%>
            <a href="javascript:gogo('<%=f.getName()%>')">
                <%=f.getName()%>
            </a>
            <%
            }else{ %>
            <a href="javascript:down('<%=f.getName()%>')">
            <%=f.getName()%>
            </a>
            <% } %>
        </td>
        <td></td>
    </tr>
    <%
        }//for의 끝
    %>
    </tbody>
</table>

<form name="ff" method="post">
    <input type="hidden" name="f_name"/>
    <input type="hidden" name="cPath" value="<%=dir%>"/>
</form>
<%--파일 첨부가 되는 폼은 반드시 enctype이 multipart/form-data로 지정되어야 함!
    폼에 파일을 첨부하게 되면 무조건 enctype이 위와 같아야한다.--%>
<div id="upload_win" title="파일 올리기">
    <form action="upload.jsp" method="post" name="frm2"
          enctype="multipart/form-data">
        <%--    아래의 cPath는 필요없다--%>
        <input type="hidden" name="cPath" value="<%=dir%>"/>
        <label for="selectFile">첨부파일:</label>
        <%--  파일선택기 --%>
        <input type="file" id="selectFile" name="upload"/><br/>
        <p class="btn">
            <a href="javascript:upload()">보내기</a>
        </p>
        <p class="btn">
            <a href="javascript:closeUpload()">닫 기</a>
        </p>
    </form>
</div>

<div id="folder_win" title="폴더 만들기">
    <form action="makeFolder.jsp" method="post" name="frm3">

        <input type="hidden" name="cPath" value="<%=dir%>"/>
        <label for="f_name">폴더명:</label>

        <input type="text" id="f_name" name="f_name"/><br/>
        <p class="btn">
            <a href="javascript:makeFolder()">만들기</a>
        </p>
        <p class="btn">
            <a href="javascript:closeFolder()">닫 기</a>
        </p>
    </form>

</div>

<%
    }else {
        response.sendRedirect("../index.jsp");
    }
%>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
<script>
    function home() {
        location.href="myDisk.jsp";
    }

    function gogo(folder_name) {
        //폴더를 클릭했을 때 해당 폴더명을 인자로 전달하여, 수행하는 함수
        // alert(folder_name);

        //현재문서(document)에서 이름이 ff인 폼 객체를 찾아 그 안에 이름이
        //f_name인 요소의 값(value)으로 인자로 받은 folder_name을 지정한다.
        document.ff.f_name.value = folder_name;
        document.ff.action = "myDisk.jsp";
        document.ff.submit();
    }
    function before() {
        //상위로를 클릭했을때 상위 폴더로 갈 수 있는 기능

        //먼저 now라는 이름으로 문서에서 ff인 폼객체 안에 현재 경로를 찾음
        let now = document.ff.cPath.value;

        if (now.indexOf("/")>0){
            let up = now.substring(0, now.lastIndexOf("/"));
            document.ff.cPath.value = up;
        }
        else{
            //여기에 뭘 넣지
        }
        // console.log(111);
        document.ff.action = "myDisk.jsp";
        document.ff.submit();
    }
    function goUp(path){
        document.ff.cPath.value=path;
        document.ff.action = "myDisk.jsp";
        document.ff.submit();
    }
    function selectFile() {
        $("#upload_win").dialog({
            width:320
        });
    }
    function closeUpload() {
        $("#upload_win").dialog("close")
    }
    function upload() {
        document.frm2.submit();
    }
    function dialogFolder() {
        $("#folder_win").dialog();
    }
    function makeFolder() {
        document.frm3.submit();
    }
    function closeFolder() {
        $("#folder_win").dialog("close");
    }
    function down(fname) {
        //인자로 받은 파일명을 현재문서 안에 있는 ff라는 이름으의 폼 객체
        //이름이 f_name 이라는 input type="hidden" 요소의 값(value)로
        //지정한다.
        document.ff.f_name.value =fname;

        //ff라는 폼의 action을 변경하자!
        document.ff.action="download.jsp"
        document.ff.submit();//서버로 전달

        //다운로드가 진행되면서 현재 페이지가 유지될 때
        // 파일명이 지정되어 있으면 오류가 발생 할 수 있으므로 파일명을 삭제한다.
        document.ff.f_name.value="";
    }
</script>
</body>
</html>
