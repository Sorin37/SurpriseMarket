<%@ page import="com.example.emarket.model.User" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Surprise Market</title>
    <%--    <link href="../css/styles.css" rel="stylesheet" type="text/css">--%>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            if (${showToken}) {
                alert("Your token is ${token}");
            }
        });

        function discount() {
            if (document.form.fullPrice.value >= 500 && ${points} >= 100 && '${role}' == 'client') {
                const discount = ${points} < 400 ? Math.trunc(${points} / 100) * 5 : 20;
                    alert("You obtained a " + discount + " lei discount");
            }
            document.form.submit();
        }

        function logout() {
            document.location.href = "${pageContext.request.contextPath}/logout";
        }
    </script>
</head>
<body>
<div class="flex" style="display: flex; justify-content: space-between">
    <div>
        <% String username = (String) request.getAttribute("username");%>
        <span style="font-size: 50px;">Hello ${username}</span>
        <button type="button" onclick="logout()" style="font-size: 50px; height: 60px">Log out</button>
    </div>
    <div>
        <span style="font-size: 50px;">
    <%
        if (request.getAttribute("role").equals("client")) {
            out.print("Points: " + request.getAttribute("points"));
        }else{
            out.print("");
        }
    %></span>
    </div>
</div>
<form method="POST" style="font-size: 50px;" name="form">
    <div>
        <label for="priceInput">What is the amount that you owe?</label>
        <br>
        <input id="priceInput" type="number" value="00.00" step="0.01" name="fullPrice"
               style="height: 50px; font-size: 50px; inline-size: 250px"/>
    </div>
</form>
<button onclick="discount()" style="font-size: 50px; height: 60px">Buy</button>
<br/>
</body>
</html>