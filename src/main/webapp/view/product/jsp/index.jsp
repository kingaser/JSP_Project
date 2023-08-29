<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>index</title>
    <script src="js/includeHTML.js"></script>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/Style.css"/>
    <link rel="icon" href="images/favicon.jpg">
</head>
<body>
<jsp:include page="/view/header/jsp/header.jsp"/>
<main class="main">
    <div class="logo-search-wrapper">
        <div class="index-logo">
            <a href="">
                <img class="logo" src="images/2nd_project_logo.jpg" alt="logo"/>
            </a>
        </div>
        <div class="search">
            <form action="#" class="search-form">
                <input
                        name="search_input"
                        class="search-input"
                        type="text"
                        placeholder="검색할 내용을 입력하세요"
                />
                <button class="search-button" type="submit">검색</button>
            </form>
        </div>
    </div>
    <hr/>
    <div class="main-list-table-wrapper">
        <table class="main-list-table">
            <thead>
            <tr>
                <th width="15%">책 이미지</th>
                <th width="20%">제목</th>
                <th width="15%">저자</th>
                <th width="15%">가격</th>
                <th width="10%">리뷰</th>
                <th width="25%">비고</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${list}">
                <tr>
                    <td><img src="${p.image}"></td>
                    <td class="title indent text-align-left">${p.title}</td>
                    <td>${p.author}</td>
                    <td>${p.price}</td>
                    <td>${p.quantity}</td>
                    <td>
                        <form action="purchase/detail?id=" method="get">
                            <button class="to-add" name="id" value="${p.productId}">구매 페이지</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
            <tfoot>
            <td colspan="6" class="tablefoot"></td>
            </tfoot>
        </table>
    </div>
</main>
<footer class="footer" include-html="project-footer.html"></footer>
</body>
</html>
