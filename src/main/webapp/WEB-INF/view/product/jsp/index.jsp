<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>index</title>
    <script src="includeHTML.js"></script>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/Style.css">
</head>
<body>
<header class="header" include-html="project-header.html"></header>
<main class="main">
    <div class="logo-search-wrapper">
        <div class="index-logo">
            <a href="/">
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
            <tr>
                <td><img src="images/book1.png" alt="bookimg"/></td>
                <td>토비의스프zzzzzzzzzzzzzzzzzzzzz링</td>
                <td>토비</td>
                <td>120000원</td>
                <td>3개</td>
                <td>
                    <button class="to-add">즉시구매</button>
                    <button class="to-basket">장바구니</button>
                </td>
            </tr>
            <tr>
                <td><img src="images/book1.png" alt="bookimg"/></td>
                <td>토비의스프zzzzzzzzzzzzzzzzzzzzz링</td>
                <td>토비</td>
                <td>120000원</td>
                <td>3개</td>
                <td>
                    <button class="to-add">즉시구매</button>
                    <button class="to-basket">장바구니</button>
                </td>
            </tr>
            </tbody>
            <tfoot>
            <td colspan="6" class="tablefoot"></td>
            </tfoot>
        </table>
    </div>
</main>
<footer class="footer" include-html="project-footer.html"></footer>
<script>
    includeHTML();
</script>
</body>
</html>
