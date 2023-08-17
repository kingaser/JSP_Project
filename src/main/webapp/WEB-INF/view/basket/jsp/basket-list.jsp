<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>basket-list</title>
    <script src="includeHTML.js"></script>
    <link rel="stylesheet" type="text/css" href="css/basket-list.css" />
    <link rel="stylesheet" type="text/css" href="css/Style.css" />
  </head>
  <body>
    <header class="header" include-html="project-header.html"></header>
    <main class="main">
      <div class="basket-wrapper">
        <div class="basket-title">
          <h1>마이페이지</h1>
        </div>
        <div class="basket-subtitle"><h3>장바구니</h3></div>
        <div class="basket-buttons">
          <button class="basket-clear">장바구니 비우기</button>
          <button class="basket-purchase">목록 구매하기</button>
        </div>
        <div class="table-container">
          <table class="basket-table">
            <thead>
              <tr>
                <th width="50%">상품</th>
                <th class="align-center" width="10%">&nbsp;가격</th>
                <th class="align-center" width="5%">수량</th>
                <th class="align-center" width="10%">소계</th>
                <th class="align-center" width="5%">비고</th>
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
                <td class="align-center"><button>삭제</button></td>
              </tr>
              <tr>
                <td>자바</td>
                <td class="align-center">30000원</td>
                <td class="align-center">4개</td>
                <td class="align-center">가격 x 수량</td>
                <td class="align-center"><button>삭제</button></td>
              </tr>
              <tr>
                <td>파이썬</td>
                <td class="align-center">20000원</td>
                <td class="align-center">9개</td>
                <td class="align-center">가격 x 수량</td>
                <td class="align-center"><button>삭제</button></td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="basket-buttons2">
          <button class="continue-shopping">계속 쇼핑하기</button>
          <button class="go-to-purchase-list">구매목록 가기</button>
        </div>
      </div>
    </main>
    <footer class="footer" include-html="project-footer.html"></footer>
  </body>
</html>
<script>
  includeHTML();
</script>
