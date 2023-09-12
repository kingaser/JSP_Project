<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>product-regist</title>
    <script src="js/includeHTML.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/regist.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Style.css"/>
    <link rel="icon" href="images/favicon.jpg">
</head>

<body>

    <div class="regist-body">
        <form action="/product/add" method="post" enctype="multipart/form-data">
            <a href="/">
                <img class="logo" src="../../images/2nd_project_logo.jpg" alt="logo"/>
            </a>
            <div class="container" id="container">
                <div class="form-container regist-product-container">
                    <h1>상품 등록</h1>
                    <input type="text" placeholder="제목" name="title"/>
                    <input type="text" placeholder="저자" name="author"/>
                    <input type="number" placeholder="가격" name="price"/>
                    <input type="number" placeholder="수량" name="quantity"/>
                    <input type="file" name="image"/>
                    <button type="submit">regist</button>
                </div>
                <div class="overlay-container">
                    <div class="content-box">
                        <h2 class="book-info">책 소개</h2>
                        <textarea class="custom-textarea" datatype="text" name="content"></textarea>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
