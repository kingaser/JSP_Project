<%@ page import="entity.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>purchase</title>
    <script src="/js/includeHTML.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/purchase.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Style.css"/>
</head>
<body>
<header class="header" include-html="project-header.html"></header>

<main class="main">
    <div class="purchase-wrapper">
        <div class="purchase-table-wrapper">
            <table class="purchase-table">
                <thead>
                <tr>
                    <th width="15%">책 이미지</th>
                    <th width="20%">제목</th>
                    <th width="15%">가격</th>
                    <th width="15%">재고</th>
                    <th width="20%">구매 개수</th>
                    <th width="15%">구매</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <img src="${p.image}" alt="bookimg"/>
                    </td>
                    <td>${p.title}</td>
                    <td>${p.price}</td>
                    <td>${p.quantity}</td>
                    <td>
                        <input id="quantity" name="quantity" value="1">
                        <span id="purchase-count">1</span><br/><br/>

                        <button class="up-button" type="button" onclick="countUp()">
                            up
                        </button>
                        <button class="down-button" type="button" onclick="countDown()">
                            down
                        </button>
                    </td>

                    <td>
                        <button class="purchase-now" id="submitBuy">즉시구매</button>
                    </td>
                </tr>
                </tbody>
                <tfoot>
                <td colspan="6" class="tablefoot"></td>
                </tfoot>
            </table>
        </div>
    </div>
</main>
<footer class="footer" include-html="project-footer.html"></footer>
</body>

<script>
    <%
    Member member = (Member) session.getAttribute("login");
    %>
    let quan = document.getElementById("quantity")
    let username = '<%= member.getUsername() %>;'
    let pid = ${p.productId};

    function initialize() {
        const purchaseCountElement = document.getElementById("purchase-count");

        // "purchase-count" 요소에서 초기 값을 가져와서 purchaseCount 변수에 할당
        if (purchaseCountElement) {
            purchaseCount = parseInt(purchaseCountElement.textContent);
        }
    }

    // 구매 수량 증가 함수
    function countUp() {
        purchaseCount++;
        quan.value++;
        updatePurchaseCount();

    }

    // 구매 수량 감소 함수
    function countDown() {
        if (purchaseCount > 0) {
            purchaseCount--;
            quan.value--;
            updatePurchaseCount();
        }

    }

    // 구매 수량 화면 업데이트 함수
    function updatePurchaseCount() {

        const purchaseCountElement = document.getElementById("purchase-count");
        if (purchaseCountElement) {
            purchaseCountElement.textContent = purchaseCount;
        }

    }

    // 페이지 로드 시 초기화 함수 호출
    initialize();

    $(document).ready(function() {
        $("#submitBuy").click(function() {
            $.ajax({
                type: "POST",
                url: "/purchase/check",
                data: {
                    productId: pid,
                    quantity: quan.value
                },
                success: function(response) {
                    window.location.href = "/purchase";
                },
                error: function() {
                    console.error('구매 실패');
                }
            });
        });
    });
</script>
</html>
