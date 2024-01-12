<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    // Ajax 호출하여 남은 시간 업데이트
    function updateRemainingTime(pnum, regdate) {
        var currentTime = new Date().getTime();
        var expirationTime = new Date(regdate).getTime() + (7 * 24 * 60 * 60 * 1000); // 7일을 밀리초로 변환

        var remainingTime = expirationTime - currentTime;

        var days = Math.floor(remainingTime / (1000 * 60 * 60 * 24));
        var hours = Math.floor((remainingTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var minutes = Math.floor((remainingTime % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((remainingTime % (1000 * 60)) / 1000);

        $("#remainingTime-" + pnum).text(days + "일 " + hours + "시간 " + minutes + "분 " + seconds + "초");
    }

    // 페이지 로드 후 초기 업데이트
    $(document).ready(function() {
        <c:forEach var="b" items="${li}">
            updateRemainingTime(${b.pnum}, "${b.regdate}");
        </c:forEach>
    });

    // 일정 간격으로 업데이트
    setInterval(function() {
        <c:forEach var="b" items="${li}">
            updateRemainingTime(${b.pnum}, "${b.regdate}");
        </c:forEach>
    }, 1000); // 1초마다 업데이트
</script>
<style>
ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

li {
	margin: 0 0px; /* 상하 0, 좌우 10px 간격 지정 */
	padding: 0 20px;
	border-radius: 5px;
	float: left;
	position: relative;
	text-align: center; /* 내용 중앙 정렬 */
}

.custom-border {
	width: 200px; /* 상자의 너비 설정 */
	height: 330px; /* 상자의 높이 설정 */
	border: 5px solid #ddd; /* 테두리 스타일 정의 */
	border-radius: 10px; /* 테두리 둥글게 처리 */
	margin-right: 20px;
	margin-bottom: 20px; /* 아래쪽 간격을 20px로 설정 */
	text-align: center; /* 텍스트를 중앙 정렬 */
	/* 추가적인 스타일 정의 가능 */
	font-weight: bold; /* 굵기 설정 */
	font-size: 12px; /* 크기 설정 */
	color: black; /* 글자 색상 설정 */
	position: relative;
	overflow: hidden;
	transition: border 0.3s ease-in-out;
}

.custom-border:hover {
	border: 1px solid white; /* 마우스 오버시 테두리 색상 변경 */
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* 마우스 오버시 그림자 효과 추가 */
}

.remaining-time {
	background-color: #2A2A2A;
	padding: 15px;
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	/* 텍스트 굵기 및 크기 설정 */
	font-weight: bold; /* 굵기 설정 */
	font-size: 12px; /* 크기 설정 */
	color: white; /* 글자 색상 설정 */
}


.product-content {
	display: flex;
	flex-direction: column;
	align-items: center;
	text-align: center;
}

   .category-list {
        position: fixed;
        top: 10px; /* 상단 여백 조절 */
        left: 230px; /* 좌측 여백 조절 */
        background-color: #fff;
        padding: 20px; /* 내부 여백 조절 */
        border: 5px solid #ddd; /* 테두리 스타일 정의 */
        border-radius: 10px; /* 테두리 둥글게 처리 */
        transition: top 0.3s ease-in-out;
    }



@media screen and (max-width: 1668px) {
	.category-list {
		display: none; 
	}
	
}
</style>
</head>
<body>

	<div class="container">
		<h5 class="text-center">카테고리:&nbsp;${boardPname}<br>[${boardCount}]개의 상품이 있습니다</h5>

		<c:forEach var="b" items="${li}">
			<div class="product-item">
				<ul class="products">
					<li class="first product custom-border">
						<h6>&nbsp;</h6>
						<div class="product-content">
							<h4>${b.pname }</h4>
							<a href="boardInfo?num=${b.pnum}"> <img
								src="${pageContext.request.contextPath}/image/board/${b.file1}"
								style="width: 120px; height: 140px;" alt=""></a>

							<div class="remaining-time" id="remainingTime-${b.pnum}"></div>
							<span class="price">${b.price }&nbsp;원</span> <a
								href="${pageContext.request.contextPath}/jumun/jumunAdd?pnum=${b.pnum}">찜하기</a>
							<p></p>
							<h6>&nbsp;</h6>
						</div>
					</li>
				</ul>
			</div>
		</c:forEach>
		<ul class="pagination justify-content-center text-center">
			<li
				class="page-item <c:if test="${start<=bottomLine}"> disabled  </c:if> ">
				<a class="page-link"
				href="${pageContext.request.contextPath}/board/products?pageNum=${start-bottomLine}">Previous</a>
			</li>

			<c:forEach var="p" begin="${start}" end="${end}">

				<li class="page-item <c:if test="${pageInt==p}"> active  </c:if>"><a
					class="page-link"
					href="${pageContext.request.contextPath}/board/products?pageNum=${p}">${p}</a></li>
			</c:forEach>

			<li class="page-item <c:if test="${end>=maxPage}"> disabled  </c:if>">
				<a class="page-link"
				href="${pageContext.request.contextPath}/board/products?pageNum=${start+bottomLine}">Next</a>
			</li>
			<li><a class="page-link" href="boardForm">게시판입력</a></li>
		</ul>

	</div>
	<div class="category-list">
		<h5>Category</h5>
		<ul>
			<!-- 카테고리 목록 아이템들을 동적으로 생성할 수 있습니다. -->
			<li><a
				href="${pageContext.request.contextPath}/board/products?boardid=1">가전</a></li><p>
			<li><a
				href="${pageContext.request.contextPath}/board/products?boardid=2">의류</a></li><p>
			<li><a
				href="${pageContext.request.contextPath}/board/products?boardid=3">도서</a></li><p>
			<li><a
				href="${pageContext.request.contextPath}/board/products?boardid=4">기타</a></li>
		</ul>
	</div>
	<script>
    var categoryList = document.querySelector('.category-list');
    var headerHeight = document.querySelector('.site-header').offsetHeight; // 헤더의 높이
    var initialTop = 300; // 초기 top 값

    function updateCategoryListPosition() {
        var scrollTop = window.scrollY;

        // 스크롤이 헤더 아래로 내려갔을 때 고정
        if (scrollTop > headerHeight) {
            categoryList.style.top = '70px'; // 원하는 값으로 조절
        } else {
            // 스크롤이 맨 위로 올라갈 때 초기 위치로 고정
            categoryList.style.top = initialTop + 'px';
        }
    }

    // 페이지 로드 후 초기 업데이트
    document.addEventListener('DOMContentLoaded', function() {
        updateCategoryListPosition();
    });

    // 스크롤 이벤트에 따라 카테고리 목록의 위치를 조절
    document.addEventListener('scroll', updateCategoryListPosition);
</script>


</body>
</html>
