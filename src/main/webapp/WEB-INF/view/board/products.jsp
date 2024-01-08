<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

ul {
    list-style:none;
    margin:0;
    padding:0;
}

li {
    margin: 0 0 0 0;
    padding: 0 0 0 0;
    border : 0;
    float: left;
}
</style>
</head>
<body>

<div class="container">
  <h2 class ="text-center">${boardName}[${boardCount}]</h2>
   <p  class="text-right"> <a class="btn btn-primary"  href="boardForm">게시판입력</a></p>               
  <!-- <table class="table table-bordered">
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
    <tbody> -->
    <c:forEach var="b" items="${li}">  
      <%-- <tr>
        <td>${b.num}</td>
        <td>${b.name}</td>
        <td><a href="boardInfo?num=${b.num}">${b.subject}</a></td>
        <td>${b.regdate}</td>
        <td>${b.readcnt}</td>
        <td>${b.file1}</td>
      </tr> --%>
      
      
      <ul class="products"  >
				
					<li class="first product"  >
					<a href="shop-single.html">
					<span class="onsale">Sale!</span>
					<img src="http://s3.amazonaws.com/caymandemo/wp-content/uploads/sites/10/2015/09/10175658/j4-520x520.jpg" alt="">
					<h3>${b.name }</h3>
					<span class="price"><span class="amount">$34.00</span></span>
					</a><a href="#" class="button">Add to cart</a>
					</li>
      </ul>
      
      </c:forEach>  
<!--     </tbody>
  </table> -->
  <ul class="pagination justify-content-center text-center">
  <li class="page-item <c:if test="${start<=bottomLine}"> disabled  </c:if> ">
    <a class="page-link" href="${pageContext.request.contextPath}/board/boardList?pageNum=${start-bottomLine}">Previous</a></li>
  
  <c:forEach var = "p" begin ="${start}" end="${end}">
 
  <li class="page-item <c:if test="${pageInt==p}"> active  </c:if>"><a class="page-link" 
       href="${pageContext.request.contextPath}/board/boardList?pageNum=${p}">${p}</a></li>
  </c:forEach>
 
  <li class="page-item <c:if test="${end>=maxPage}"> disabled  </c:if>"> <a class="page-link" href="${pageContext.request.contextPath}/board/boardList?pageNum=${start+bottomLine}">Next</a></li>
</ul>
</div>
</body>
</html>