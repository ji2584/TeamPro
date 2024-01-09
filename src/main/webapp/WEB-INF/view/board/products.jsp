<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

li {
	margin: 0 0 0 0;
	padding: 0 0 0 0;
	border: 0;
	float: left;
}
</style>
</head>
<body>

	<div class="container">
		<h5 class="text-center">[${boardCount}]개의 상품이 있습니다</h5>
		<p class="text-right">
			<a class="btn btn-primary" href="boardForm">게시판입력</a>
		</p>

		<c:forEach var="b" items="${li}">

			<ul class="products">

				<li class="first product"><a href="shop-single.html"> <span
						class="onsale">${b.pname }</span> <img
						src="http://s3.amazonaws.com/caymandemo/wp-content/uploads/sites/10/2015/09/10175658/j4-520x520.jpg"
						alt="">

						<li>${b.file1}<img
							src="${pageContext.request.contextPath}/image/board/${b.file1}"
							width="100px" height="120px"></li>

						<h5>판매상품:${b.subject }</h5> 
						<span class="price"><span
							class="amount">${b.price }</span></span>
				</a><a href="#" class="button">장바구니담기</a>
					<p>
						<a href="boardInfo?num=${b.pnum}">상세보기</a></li>
			</ul>
		</c:forEach>
		<ul class="pagination justify-content-center text-center">
			<li
				class="page-item <c:if test="${start<=bottomLine}"> disabled  </c:if> ">
				<a class="page-link"
				href="${pageContext.request.contextPath}/board/boardList?pageNum=${start-bottomLine}">Previous</a>
			</li>

			<c:forEach var="p" begin="${start}" end="${end}">

				<li class="page-item <c:if test="${pageInt==p}"> active  </c:if>"><a
					class="page-link"
					href="${pageContext.request.contextPath}/board/boardList?pageNum=${p}">${p}</a></li>
			</c:forEach>

			<li class="page-item <c:if test="${end>=maxPage}"> disabled  </c:if>">
				<a class="page-link"
				href="${pageContext.request.contextPath}/board/boardList?pageNum=${start+bottomLine}">Next</a>
			</li>
			<li class="page-item <c:if test="${end>=maxPage}"> disabled  </c:if>">
				<a class="page-link"
				href="${pageContext.request.contextPath}/board/boardForm">판매글등록</a>
			</li>
		</ul>
	</div>
	-----------------------------가기존 게시글 폼-----------------------


	<h5 class="text-center">[${boardCount}]개의 상품이 있습니다</h5>
	<p class="text-right">
		<a class="btn btn-primary" href="boardForm">게시판입력</a>
	</p>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
				<th>파일</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="boardNum" value="${boardNum}" />
			<c:forEach var="b" items="${li}">
				<tr>
					<td>${boardNum}</td>
					<c:set var="boardNum" value="${boardNum-1}" />
					<td>${b.pname}</td>
					<td><a href="boardInfo?num=${b.pnum}">${b.subject}</a></td>
					<td>${b.regdate}</td>
					<td>${b.readcnt}</td>
					<td>${b.file1}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pagination  " style="justify-content: center">
		<li
			class="page-item    <c:if test="${start<=bottomLine}">        disabled    </c:if>                ">
			<a class="page-link"
			href="${pageContext.request.contextPath}/board/boardList?pageNum=${start-bottomLine}">Previous</a>
		</li>

		<c:forEach var="p" begin="${start }" end="${end }">
			<li
				class="page-item <c:if test="${pageInt==p}">        active    </c:if>  "><a
				class="page-link"
				href="${pageContext.request.contextPath}/board/boardList?pageNum=${p}">${p}</a></li>

		</c:forEach>


		<li
			class="page-item    <c:if test="${end>=maxPage}">        disabled    </c:if>">
			<a class="page-link"
			href="${pageContext.request.contextPath}/board/boardList?pageNum=${start+bottomLine}">Next</a>
		</li>
	</ul>

</body>
</html>