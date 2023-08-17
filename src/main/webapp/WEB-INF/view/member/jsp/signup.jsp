<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>7DAYS Signup</title>
    <link rel="stylesheet" type="text/css" href="css/signup.css">
    <link rel="icon" href="images/favicon.jpg">
</head>
<body>
<a href="/">
    <img class="logo" src="images/2nd_project_logo.jpg" alt="logo"/>
</a>
<form action="signup" method="post">
    <div class="container" id="container">
        <div class="form-container sign-in-container">
            <form action="#">
                <h1>Information</h1>
                <input type="text" placeholder="username"/>
                <input type="password" placeholder="password"/>
                <input type="text" placeholder="tel"/>
                <input type="text" placeholder="address"/>
                <button type="submit">Sign up</button>
            </form>
        </div>
        <form action="login" method="get">
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome!</h1>
                    <p>7DAYS에서<br/><br/>공부를 시작해요!</p>
                    <button type="submit">Log in</button>
                </div>
            </div>
        </div>
        </form>
    </div>
</form>
</body>
</html>