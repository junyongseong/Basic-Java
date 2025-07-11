<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <article>
        <header>
            <h2>ex4_form.jsp</h2>
        </header>
        <div>
            <form action="ex4.jsp"method="post"name="ff">
                <label for="s_num">숫자입력 : </label>
                <input type="text" id="s_num" name="s_num">
                <br/>
                <button type="button" onclick="exe()">보내기</button>
            </form>
        </div>
    </article>
    <script>
        function exe() {
            let num =document.getElementById("s_num");
            if (num.value.trim().length==0){
                alert("숫자를 입력하세요");
                s_num.value ="";
                s_num.focus();
                return;
            }
            //숫자인지 아닌지 판단해야함
            document.ff.submit();
        }
    </script>
</body>
</html>
