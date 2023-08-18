<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>product-regist</title>
    <script src="js/includeHTML.js"></script>
    <link rel="stylesheet" type="text/css" href="../../../../css/product-regist.css"/>
    <link rel="stylesheet" type="text/css" href="../../../../css/Style.css"/>
    <link rel="icon" href="images/favicon.jpg">
</head>

<body>
<jsp:include page="/view/header/jsp/header.jsp"/>
<main class="main">
    <div class="regist-body">
        <img src="/images/logo.jpg" alt=""/>
        <div class="container" id="container">
            <div class="form-container regist-product-container">
                <form action="/product/add" method="post">
                    <h1>상품 등록</h1>
                    <input type="text" name="제목"/>
                    <input type="text" name="저자"/>
                    <input type="number" name="가격"/>
                    <input type="number" name="수량"/>
                    <input type="file" id="file"/>
                    <button type="submit">regist</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>관리자님!</h1>
                        <p>상품을<br/><br/>등록하세요 !</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<footer class="footer" include-html="project-footer.html"></footer>
</body>
</html>
