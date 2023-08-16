<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>7DAYS Signup</title>
    <link rel="stylesheet" type="text/css" href="/css/signup.css">
    <link rel="icon" href="http://localhost:8888/images/favicon.jpg">
</head>
<body>
<img src="/images/logo.jpg" alt="">
<form action="member?command=signup" method="post">
    <div class="container" id="container">
        <div class="form-container sign-in-container">
            <form action="#">
                <h1>Information</h1>
                <input type="text" name="username"/>
                <input type="password" name="passwd"/>
                <input type="text" name="tel"/>
                <input type="text" name="address"/>
                <button type="submit">Sign up</button>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome!</h1>
                    <p>7DAYS에서<br/><br/>공부를 시작해요!</p>
                    <button class="ghost" id="signUp">Log in</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>