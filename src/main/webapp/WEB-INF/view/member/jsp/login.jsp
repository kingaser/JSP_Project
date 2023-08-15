<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<form action="/signup" method="post">
    <input type="hidden" name="command" value="login"/>
    <img src="/images/logo.jpg" alt="">
    <div class="container" id="container">
        <div class="form-container sign-in-container">
            <form action="#">
                <h1>Log in</h1>
                <input type="text" placeholder="Id"/>
                <input type="password" placeholder="Password"/>
                <button>Log in</button>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-right">
                    <h1>Welcome!</h1>
                    <p>7DAYS에서<br/><br/>공부를 시작해요!</p>
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
