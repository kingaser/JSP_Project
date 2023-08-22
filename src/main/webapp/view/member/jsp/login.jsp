<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% if (request.getParameter("loginFailed") != null) { %>
<script>alert('로그인 실패!');</script>
<% } %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="icon" href="images/favicon.jpg">

    <script>

    </script>
</head>
<body>

<a href="/">
    <img class="logo" src="images/2nd_project_logo.jpg" alt="logo"/>
</a>
<div class="container" id="container">
    <div class="form-container sign-in-container">
        <form action="login" method="post">
            <h1>Log in</h1>
            <input type="hidden" name="command" value="login">
            <input type="text" name="username" placeholder="아이디를 입력하세요"/>
            <input type="password" name="password" placeholder="비밀번호를 입력하세요"/>
            <button type="submit">Log in</button>
        </form>
    </div>
    <form action="signup" method="get">
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-right">
                    <h1>Welcome!</h1>
                    <p>7DAYS에서<br/><br/>공부를 시작해요!</p>
<%--                    <input type="hidden" name="command" value="signup" />--%>
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
