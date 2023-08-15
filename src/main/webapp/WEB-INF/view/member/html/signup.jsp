<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>7DAYS Signup</title>
    <link rel="stylesheet" type="text/css" href="/WEB-INF/view/member/css/signup.css">
    <link rel="icon" href="http://localhost:8888/images/favicon.jpg">
</head>
<body>
<img src="/images/logo.jpg" alt="">
<div class="container" id="container">
    <div class="form-container sign-in-container">
        <form action="member/html/signup.jsp" method="post">
            <h1>Information</h1>
            <input type="text" placeholder="Id"/>
            <input type="password" placeholder="Password"/>
            <input type="number" placeholder="PhoneNumber"/>
            <input type="text" placeholder="Address"/>
            <button>Sign up</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome!</h1>
                <p>7DAYS����<br/><br/>���θ� �����ؿ�!</p>
                <button class="ghost" id="signUp">Log in</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>