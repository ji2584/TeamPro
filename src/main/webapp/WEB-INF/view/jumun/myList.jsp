<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<main>
    <div class="container">
    <h2 class="my-4">판매등록 상품</h2>
    
    <form action="${pageContext.request.contextPath}/jumun/myList" method="post">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">물품번호</th>
                    <th scope="col">이미지</th>
                    <th scope="col">물품명</th>
                    <th scope="col">파일</th>
                    <th scope="col">제목</th>
                    <th scope="col">현재가</th>
                    <th scope="col">입찰횟수</th>
                    <th scope="col">마감일</th>
                    <th scope="col">선택</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="j" items="${li}">
                    <tr>
                        <td>${j.pnum}</td>
                        <td><img src="${j.picture}" alt="이미지" style="max-width: 50px; max-height: 50px;"></td>
                        <td>${j.pname}</td>
                        <td>${j.file1}</td>
                        <td>${j.subject}</td>
                        <td>${j.price}</td>
                        <td>${j.readcnt}</td>
                        <td>${j.regdate}</td>
                        <td><input type="checkbox" name="selectedItems" value="${j.pnum}"></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
             
    </form>
</div>
</main>
</body>
</html>