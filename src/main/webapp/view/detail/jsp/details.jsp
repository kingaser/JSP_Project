<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 상세페이지 -->

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>details</title>
    <script src="/js/includeHTML.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/details.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Style.css"/>
    <link rel="icon" href="/images/favicon.jpg">
</head>
<body>
<jsp:include page="/view/header/jsp/header.jsp"/>

<main class="main">
    <div class="detail-wrapper">
        <div class="detail-table-wrapper">
            <table class="detail-table">
                <thead>
                <tr>
                    <th width="15%">책 이미지</th>
                    <th width="30%">제목</th>
                    <th width="5%">저자</th>
                    <th width="10%">가격</th>
                    <th width="10%">구매</th>
                    <th width="10%">장바구니</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><img src="${p.image}"></td>
                    <td class="title indent text-align-left">${p.title}</td>
                    <td>${p.author}</td>
                    <td>${p.price}</td>
                    <td>
                        <form action="purchase/detail?id=${p.productId}" method="get">
                            <button class="to-add">즉시 구매</button>
                        </form>
                    </td>
                    <td>
                        <form action="/basket/register" method="post">
                            <button class="to-basket" name="productId" value="${p.productId}">추가</button>
                        </form>
                        <%--                        <form action="basket" method="get">--%>
                        <%--                            <button class="to-basket" name="command" value="listBasket">장바구니</button>--%>
                        <%--                        </form>--%>
                    </td>
                </tr>
                </tbody>
                <tfoot>
                <td colspan="6" class="tablefoot"></td>
                </tfoot>
            </table>
        </div>
        <div class="detail-review-container">
            <fieldset class="review-fieldset">
                <legend style="text-align: center"><h1>리뷰</h1></legend>
                <ul class="detail-review">
                    <p class="if-empty-review">등록된 리뷰가 없습니다</p>
                    <li>
                        <span>아이디 님</span>
                        <p>
                            내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                        </p>
                    </li>
                    <li>
                        <span>아이디 님</span>
                        <p>
                            내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                        </p>
                    </li>
                    <li>
                        <span>아이디 님</span>
                        <p>
                            내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                        </p>
                    </li>
                </ul>
            </fieldset>
            <div class="write-review">
                <form action="#">
                    <fieldset class="write-review-fieldset">
                        <legend><h1>리뷰 등록</h1></legend>

                        <textarea name="review" id="review"></textarea>
                        <button type="submit" class="review-button">리뷰 등록</button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</main>
<footer class="footer" include-html="project-footer.html"></footer>
</body>
</html>
