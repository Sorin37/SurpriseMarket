<%--
  Created by IntelliJ IDEA.
  User: gliza
  Date: 11/8/2022
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Congratulations!</title>
    <script>
        function goHome() {
            document.location.href = "${pageContext.request.contextPath}/home";
        }
    </script>
</head>
<body>
<h1 style="font-size: 50px">Surprise!</h1>
<h1>You won ${gift}!!!</h1>
<button type="button" onclick="goHome()">Cool!</button>
</body>
</html>
