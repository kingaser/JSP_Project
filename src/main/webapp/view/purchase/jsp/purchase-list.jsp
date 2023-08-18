<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>purchase-list</title>
    <script src="js/includeHTML.js"></script>
    <link rel="stylesheet" type="text/css" href="css/purchase-list.css"/>
    <link rel="stylesheet" type="text/css" href="css/Style.css"/>
    <link rel="icon" href="images/favicon.jpg">
</head>
<body>
<jsp:include page="/view/header/jsp/header.jsp"></jsp:include>
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
                <tr>
                    <td>
                        스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링스프링
                    </td>
                    <td class="align-center">20000원</td>
                    <td class="align-center">3개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>자바</td>
                    <td class="align-center">30000원</td>
                    <td class="align-center">4개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>파이썬</td>
                    <td class="align-center">20000원</td>
                    <td class="align-center">9개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>자바</td>
                    <td class="align-center">30000원</td>
                    <td class="align-center">4개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>파이썬</td>
                    <td class="align-center">20000원</td>
                    <td class="align-center">9개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>자바</td>
                    <td class="align-center">30000원</td>
                    <td class="align-center">4개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>파이썬</td>
                    <td class="align-center">20000원</td>
                    <td class="align-center">9개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>자바</td>
                    <td class="align-center">30000원</td>
                    <td class="align-center">4개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>파이썬</td>
                    <td class="align-center">20000원</td>
                    <td class="align-center">9개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>자바</td>
                    <td class="align-center">30000원</td>
                    <td class="align-center">4개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>파이썬</td>
                    <td class="align-center">20000원</td>
                    <td class="align-center">9개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>자바</td>
                    <td class="align-center">30000원</td>
                    <td class="align-center">4개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>파이썬</td>
                    <td class="align-center">20000원</td>
                    <td class="align-center">9개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>자바</td>
                    <td class="align-center">30000원</td>
                    <td class="align-center">4개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
                <tr>
                    <td>파이썬</td>
                    <td class="align-center">20000원</td>
                    <td class="align-center">9개</td>
                    <td class="align-center">가격 x 수량</td>
                </tr>
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
<footer class="footer" include-html="project-footer.html"></footer>
</body>
</html>
