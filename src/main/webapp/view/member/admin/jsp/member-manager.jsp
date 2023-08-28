<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>purchase-list</title>
    <script src="js/includeHTML.js"></script>
    <link rel="stylesheet" type="text/css" href="css/member-manager.css"/>
    <link rel="stylesheet" type="text/css" href="css/Style.css"/>
    <link rel="icon" href="images/favicon.jpg">
</head>
<body>
<jsp:include page="/view/header/jsp/header.jsp"/>
<main class="main">
    <div class="purchase-list-wrapper">
        <div class="purchase-list-title">
            <h1>회원 목록</h1>
        </div>
        <div class="table-container">
            <table class="purchase-list-table">
                <thead>
                <tr>
                    <th width="50%">회원 번호</th>
                    <th class="align-center" width="10%">ID</th>
                    <th class="align-center" width="10%">주소</th>
                    <th class="align-center" width="10%">권한</th>
                    <th class="align-center" width="10%">삭제</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="member" items="${memberList}">
                    <tr>
                        <th width="50%">${member.memberId}</th>
                        <th class="align-center" width="10%">${member.username}</th>
                        <th class="align-center" width="10%">${member.address}</th>
                        <th class="align-center" width="10%">${member.role}</th>
                        <th class="align-center" width="10%">
                            <button type="submit" onclick="deleteMember(${member.memberId})">
                                회원 삭제
                            </button>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
<footer class="footer" include-html="project-footer.html"></footer>
</body>
</html>
<script>
    function deleteMember(memberId) {
        fetch('/admin/member', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded', // 요청 데이터 타입 설정
            },
            body: 'memberId=' + memberId, // 요청 데이터 (파라미터 등)
        }).then(response => {
            if (response.ok) {
                // 회원 삭제 성공 시 화면 새로고침
                location.reload();
                alert("회원 삭제 완료!!")
            }
        });
    }
</script>