<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Object adminAttribute = session.getAttribute("admin");
    boolean isAdmin = adminAttribute != null && adminAttribute.equals("admin");
%>

<div id="header-container">
    <a class="go-home" href="/"><h1>개발자를 위한 온라인 북스토어</h1></a>
    <nav class="header-menu">
        <a href="/login">로그인</a>
        <a href="/signup">회원가입</a>
    </nav>
</div>
<div id="header-container-with-login">
    <a class="go-home" href="/"><h1>개발자를 위한 온라인 북스토어</h1></a>
    <nav class="header-menu">
        <a href="/" onclick="logout()">
            로그아웃
        </a>
        <a href="/purchase">마이페이지</a>
    </nav>
</div>
<div id="header-container-with-manager-login">
    <a class="go-home" href="/"><h1>개발자를 위한 온라인 북스토어</h1></a>
    <nav class="header-menu">
        <a href="/product/add">상품등록</a>
        <a href="/admin/member">회원관리</a>
        <a href="/" onclick="logout()">
            로그아웃
        </a>
    </nav>
</div>

<script>
    var isLogged = <%= session.getAttribute("login") != null %>;
    var adminLogged = <%= isAdmin %>;
    <%--var isLogged = <%= session.getAttribute("login") != null %>;--%>
    <%--var adminLogged = <%= session.getAttribute("admin").equals("admin") %>;--%>
    <%--console.log("변수저장댐");--%>


    var isLogged = <%= session.getAttribute("login") != null %>;

    function logout() {
        fetch('/logout', {
            method: 'POST',
            headers: {
                'Content-Type': 'text/html', // 요청 데이터 타입 설정
            },
            body: 'logout=true', // 요청 데이터 (파라미터 등)
        })
            .then(response => {
                if (response.ok) {
                    // 로그아웃 성공한 경우
                    window.location.href = "/"; // 로그아웃 후 리다이렉트할 URL
                } else {
                    // 로그아웃 실패한 경우 처리
                    console.error('Logout failed');
                }
            })
            .catch(error => {
                console.error('Error occurred:', error);
            });
    }

    if (isLogged && adminLogged) {
        document.getElementById("header-container-with-manager-login").style.display = "flex";
        document.getElementById("header-container-with-login").style.display = "none";
        document.getElementById("header-container").style.display = "none";
    } else if (isLogged) {
        document.getElementById("header-container-with-login").style.display = "flex";
        document.getElementById("header-container").style.display = "none";
        document.getElementById("header-container-with-manager-login").style.display = "none";
    } else {
        document.getElementById("header-container").style.display = "flex"
        document.getElementById("header-container-with-login").style.display = "none";
        document.getElementById("header-container-with-manager-login").style.display = "none";
    }
</script>

