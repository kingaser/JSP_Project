<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>purchase-list</title>
    <script src="js/includeHTML.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/purchase-list.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Style.css"/>
    <link rel="icon" href="images/favicon.jpg">
</head>
<body>
<jsp:include page="/view/header/jsp/header.jsp" />
<main class="main">
    <div class="purchase-list-wrapper">
        <div class="purchase-list-title">
            <h1>마이페이지</h1>
        </div>
        <div class="purchase-list-subtitle"><h3>구매 목록 조회</h3></div>

        <div class="table-container">
            <table class="purchase-list-table">
                <thead>
                <tr>
                    <th width="50%">상품</th>
                    <th class="align-center" width="10%">가격</th>
                    <th class="align-center" width="10%">수량</th>
                    <th class="align-center" width="10%">소계</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="purchaseList" items="${list}">
                    <tr>
                        <td class="align-center"><img src="${purchaseList.image}"></td>
                        <td>${purchaseList.title}</td>
                        <td class="align-center">${purchaseList.quantity}</td>
                        <td class="align-center">${purchaseList.price}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="purchase-list-buttons2">
            <form action="/" method="get">
                <button class="continue-shopping">계속 쇼핑하기</button>
            </form>
            <form action="basket" method="get">
                <button class="go-to-basket-list" name="command" value="listBasket">장바구니 가기</button>
            </form>
        </div>
    </div>
</main>
<jsp:include page="/view/footer/jsp/footer.jsp"/>
</body>
</html>
