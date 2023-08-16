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

<input type="hidden" name="command" value="login"/>
<img src="/images/logo.jpg" alt="">
<div class="container" id="container">
    <div class="form-container sign-in-container">
        <form action="/" method="post">
            <h1>Log in</h1>
            <input type="text" name="username"/>
            <input type="password" name="passwd"/>
            <button type="submit">Log in</button>
        </form>
    </div>
    <form action="/member?command=signup" method="get">
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-right">
                    <h1>Welcome!</h1>
                    <p>7DAYS에서<br/><br/>공부를 시작해요!</p>
                    <input type="hidden" name="command" value="signup" />
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
