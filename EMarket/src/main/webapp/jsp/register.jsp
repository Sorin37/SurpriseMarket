<%--
  Created by IntelliJ IDEA.
  User: gliza
  Date: 11/7/2022
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div style="display: flex; justify-content: center; align-items: center; height: 100%">
    <form method="post">
        <h1 style="font-size: 50px">Become a member now!</h1>
        <label for="usernameInput" style="font-size: 30px">Username:</label>
        <br>
        <br>
        <input id="usernameInput" type="text" name="username" style="width: 100%">
        <br>
        <br>
        <div style="display: flex; justify-content: center">
            <button type="submit">Register</button>
        </div>
    </form>
</div>
</body>
</html>
