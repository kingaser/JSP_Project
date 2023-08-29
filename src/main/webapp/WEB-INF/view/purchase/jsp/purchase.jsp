<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>purchase</title>
    <script src="includeHTML.js"></script>
    <link rel="stylesheet" type="text/css" href="css/purchase.css" />
    <link rel="stylesheet" type="text/css" href="css/Style.css" />
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
                        <img src="images/book1.png" alt="bookimg" />
                    </td>
                    <td>토비의스프zzzzzzzzzzzzzzzzzzzzz링</td>
                    <td>300000</td>
                    <td>5개</td>
                    <td>
                        <span id="purchase-count">3</span><br /><br /><button
                            class="up-button"
                            type="button"
                            onclick="countUp()"
                    >
                        up</button
                    ><button
                            class="down-button"
                            type="button"
                            onclick="countDown()"
                    >
                        down
                    </button>
                    </td>

                    <td>
                        <button class="purchase-now">즉시구매</button>
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
    function initialize() {
        // "purchase-count" 요소에서 초기 값을 가져와서 purchaseCount 변수에 할당
        const purchaseCountElement = document.getElementById("purchase-count");
        if (purchaseCountElement) {
            purchaseCount = parseInt(purchaseCountElement.textContent);
        }
    }

    // 구매 수량 증가 함수
    function countUp() {
        purchaseCount++;
        updatePurchaseCount();
    }

    // 구매 수량 감소 함수
    function countDown() {
        if (purchaseCount > 0) {
            purchaseCount--;
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
</script>
</html>
<script>
    includeHTML();
</script>
