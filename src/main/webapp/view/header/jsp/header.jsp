<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<script>
  var isLogged = <%= session.getAttribute("login") != null %>;
</script>--%>

<style>
  #header-container {
    background-color: rgb(175, 196, 238);
    padding-left: 10%;
    padding-right: 10%;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

<div class="header-container">
  <a href="/"><h1>개발자를 위한 온라인 북스토어</h1></a>
  <nav class="header-menu">
    <a href="login">로그인</a>
    <a href="signup">회원가입</a>
    <a href="purchase">마이페이지</a>
  </nav>
/* 회원 로그인시 헤더*/
#header-container-with-login {
    background-color: rgb(175, 196, 238);
    padding-left: 10%;
    padding-right: 10%;
    display: none;
    justify-content: space-between;
    align-items: center;
}

/* 관리자 로그인시 헤더*/
#header-container-with-manager-login {
    background-color: rgb(175, 196, 238);
    padding-left: 10%;
    padding-right: 10%;
    display: none;
    justify-content: space-between;
    align-items: center;
}

.header a {
    text-decoration: none;
    color: black;
}

.header a:hover {
    font-weight: bold;
}

.header-menu a:hover,
.header-menu a:focus {
    font-weight: bold;
    outline: none;
}

.header-menu a {
    color: black;
    padding: 15px 25px;
    position: relative;
    display: inline-block;
    text-decoration: none;
}

.header-menu a:after {
    position: absolute;
    top: 100%;
    left: 0;
    width: 100%;
    height: 1px;
    background: #ddddff;
    content: "";
    opacity: 0;
    -webkit-transition: height 0.3s, opacity 0.3s, -webkit-transform 0.3s;
    -moz-transition: height 0.3s, opacity 0.3s, -moz-transform 0.3s;
    transition: height 0.3s, opacity 0.3s, transform 0.3s;
    -webkit-transform: translateY(-10px);
    -moz-transform: translateY(-10px);
    transform: translateY(-10px);
}

.header-menu a:hover:after,
.header-menu a:focus:after {
    height: 5px;
    opacity: 1;
    -webkit-transform: translateY(0px);
    -moz-transform: translateY(0px);
    transform: translateY(0px);
}
</style>

<div id="header-container">
    <a href="/"><h1>개발자를 위한 온라인 북스토어</h1></a>
    <nav class="header-menu">
        <a href="login">로그인</a>
        <a href="project-signup.html">회원가입</a>
    </nav>
</div>
<div id="header-container-with-login">
    <a href="/"><h1>개발자를 위한 온라인 북스토어</h1></a>
    <nav class="header-menu">
        <a href="/">로그아웃</a>
        <a href="purchase?command=listPurchase">마이페이지</a>
    </nav>
</div>
<div id="header-container-with-manager-login">
    <a href="/"><h1>개발자를 위한 온라인 북스토어</h1></a>
    <nav class="header-menu">
        <a href="/">로그아웃</a>
    </nav>

</div>
<script>
  var isLogged = <%= session.getAttribute("login") != null %>;

  if (isLogged) {
    document.getElementById("header-container-with-login").style.display = "flex";
    document.getElementById("header-container").style.display = "none";
    document.getElementById("header-container-with-manager-login").style.display = "none";
  } else {
    document.getElementById("header-container").style.display = "flex"
    document.getElementById("header-container-with-login").style.display = "none";
    document.getElementById("header-container-with-manager-login").style.display = "none";
  }

</script>