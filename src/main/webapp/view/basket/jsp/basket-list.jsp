<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>basket-list</title>
    <script src="js/includeHTML.js"></script>
    <link rel="stylesheet" type="text/css" href="css/basket-list.css"/>
    <link rel="stylesheet" type="text/css" href="css/Style.css"/>
    <link rel="icon" href="images/favicon.jpg">
</head>
<body>
<jsp:include page="/view/header/jsp/header.jsp"/>
<main class="main">
    <div class="basket-wrapper">
        <div class="basket-title">
            <h1>마이페이지</h1>
        </div>
        <div class="basket-subtitle"><h3>장바구니</h3></div>
        <div class="basket-buttons">
            <button class="basket-clear">장바구니 비우기</button>
            <button class="basket-purchase">목록 구매하기</button>
        </div>
        <div class="table-container">
            <table class="basket-table">
                <thead>
                <tr>
                    <th width="20%">상품 이미지</th>
                    <th class="align-center" width="40%">상품명</th>
                    <th class="align-center" width="5%">가격</th>
                    <th class="align-center" width="5%">구매</th>
                    <th class="align-center" width="5%">삭제</th>
                </tr>
                </thead>
                <c:if test="${!empty list[0].title}">
                <tbody>
                <tr>
                    <c:forEach var="b" items="${list}">
                    <td><img src="${b.image}" width="100px" height="100px"/></td>
                    <td align="center">${b.title}</td>
                    <td>${b.price}</td>
                    <td class="align-center">
                        <button>구매</button>
                    </td>
                        <td class="align-center">
                        <button>삭제</button>
                        </c:forEach>
                    </td>
                </tr>
                </tbody>
                </c:if>
            </table>
        </div>
        <div class="basket-buttons2">
            <button class="continue-shopping">계속 쇼핑하기</button>
            <button class="go-to-purchase-list">구매목록 가기</button>
        </div>
    </div>
</main>
<footer class="footer" include-html="project-footer.html"></footer>
</body>
</html>
