<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 상세페이지 -->

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>details</title>
    <script src="/js/includeHTML.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
                        <form action="/purchase/check?id=" method="get">
                            <button class="to-add" type="submit" name="id" value="${p.productId}">구매 하기</button>
                        </form>
                    </td>
                    <td>
                        <form action="/basket/register" method="post">
                            <button class="to-basket" name="productId" value="${p.productId}">추가</button>
                        </form>
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
                    <c:forEach var="reply" items="${replyList}">
                        <li>
                            <span>${reply.username}</span>
                            <p>${reply.content}</p>
                        </li>
                    </c:forEach>
                </ul>
            </fieldset>
            <div class="write-review">
                <form action="#">
                    <fieldset class="write-review-fieldset">
                        <legend><h1>리뷰 등록</h1></legend>
                        <textarea name="review" id="review"></textarea>
                        <button type="button" id="submitReviewButton">리뷰 등록</button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</main>
<footer class="footer" include-html="project-footer.html"></footer>
</body>
</html>
<script>
    $(document).ready(function() {
        $("#submitReviewButton").click(function() {
            var reviewContent = $("#review").val();
            var productId = ${p.productId}; // 제품 ID 설정

            $.ajax({
                type: "POST",
                url: "/reply",
                data: {
                    replyContent: reviewContent,
                    productId: productId
                },
                success: function(response) {
                    window.location.href = "/purchase/detail?id=" + productId;
                    window.location.reload();
                },
                error: function() {
                    console.error('리뷰 등록 실패');
                }
            });
        });
    });
</script>