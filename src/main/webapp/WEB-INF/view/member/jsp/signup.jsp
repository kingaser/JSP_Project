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

    <script type="text/javascript">
        function checkFun() {
            var f = document.signupForm;

            var id = f.userId.value;
            // 4~20자리, 첫글자 숫자 X
            var regExpId = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/;

            var pw = f.password.value;
            //  비밀번호 (최소 8자리, 숫자,문자,특수문자 최소 1개)
            var regExpPw =
                /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;

            var phoneNum = f.tel.value;
            // 폰번 하이픈 넣든안넣든 가능
            var regExpTel = /^[0-9]{10,11}$/;

            if (!regExpId.test(id)) {
                alert("4~20자리,한글,특수문자는 안됩니다 첫글자 숫자도요");
                f.userId.focus();
                return false;
            }
            if (!regExpPw.test(pw)) {
                alert("비밀번호 오류 > 최소 8자리, 숫자,문자,특수문자 최소 1개씩");
                f.password.focus();
                return false;
            }
            if (!regExpTel.test(phoneNum)) {
                alert("10~11 자리 숫자만 입력해주세요");
                f.tel.focus();
                return false;
            } else return true;
        }
    </script>
</head>
<body>
<a href="/">
    <img class="logo" src="images/2nd_project_logo.jpg" alt="logo"/>
</a>
<div class="container" id="container">
    <div class="form-container sign-in-container">
        <form name="signupForm" action="signup" method="post">
            <h1>Information</h1>
            <input type="text" name="userId" placeholder="아이디를 입력하세요"/>
            <input type="password" name="password" placeholder="비밀번호를 입력하세요"/>
            <input type="text" name="tel" placeholder="전화번호를 입력하세요"/>
            <input type="text" name="address" placeholder="주소를 입력하세요"/>
            <button type="submit" onclick="return checkFun()">Sign up</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome!</h1>
                <p>7DAYS에서<br/><br/>공부를 시작해요!</p>
                <button onclick="location.href='login' ">Log in</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
