<%--
  Created by IntelliJ IDEA.
  User: gliza
  Date: 11/7/2022
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function redirectToRegister(){
            document.location.href="${pageContext.request.contextPath}/register";
        }
    </script>
</head>
<body>
<div style="display: flex; justify-content: center; align-items: center; height: 100%">
    <form method="post">
        <h1 style="font-size: 50px">Welcome to Surprise Market!</h1>
        <label for="tokenInput" style="font-size: 30px">Authenticate via token:</label>
        <br>
        <br>
        <input id="tokenInput" type="text" name="loginToken" style="width: 100%">
        <br>
        <br>
        <div style="display: flex; justify-content: space-evenly">
            <button type="submit">Log in</button>
            <button type="button" onclick='document.location.href="/register"'>Register</button>
        </div>
    </form>
</div>
</body>
</html>
