<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Moschino | Minimalist Free HTML Portfolio by WowThemes.net</title>
<link rel='stylesheet' href='../team/css/woocommerce-layout.css' type='text/css' media='all'/>
<link rel='stylesheet' href='../team/css/woocommerce-smallscreen.css' type='text/css' media='only screen and (max-width: 768px)'/>
<link rel='stylesheet' href='../team/css/woocommerce.css' type='text/css' media='all'/>
<link rel='stylesheet' href='../team/css/font-awesome.min.css' type='text/css' media='all'/>
<link rel='stylesheet' href='../team/style.css' type='text/css' media='all'/>
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Oswald:400,500,700%7CRoboto:400,500,700%7CHerr+Von+Muellerhoff:400,500,700%7CQuattrocento+Sans:400,500,700' type='text/css' media='all'/>
<link rel='stylesheet' href='../team/css/easy-responsive-shortcodes.css' type='text/css' media='all'/>
</head>
<body class="home page page-template page-template-template-portfolio page-template-template-portfolio-php">
<div id="page">
	<div class="container">
		<header id="masthead" class="site-header">
		<div class="site-branding">
			<h1 class="site-title"><a href="index.html" rel="home">Moschino</a></h1>
			<h2 class="site-description">Minimalist Portfolio HTML Template</h2>
		</div>
		<nav id="site-navigation" class="main-navigation">
		<button class="menu-toggle">Menu</button>
		<a class="skip-link screen-reader-text" href="#content">Skip to content</a>
		<div class="menu-menu-1-container">
			<ul id="menu-menu-1" class="menu">
			
				<li><a href="../member/index">메인</a></li>
				
				  <li class="menu-item-has-children">
                                <a href="#">카테고리</a>
                                <ul class="sub-menu">
                                    
                                    <li><a href="${pageContext.request.contextPath}/board/products?boardid=1">가전</a></li>
                                    <li><a href="${pageContext.request.contextPath}/board/products?boardid=2">의류</a></li>
                                    <li><a href="${pageContext.request.contextPath}/board/products?boardid=3">기타</a></li>
                                </ul>
                            </li>
				
				<c:if test = "${sessionScope.id==null}">
				<li><a href="../member/loginForm">로그인</li>
				<li><a href="../member/memberinput">회원가입</a></li>
				</c:if>
				
				<c:if test = "${sessionScope.id!=null}">
				    
				<li> <a href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
				
				
				
				
				  <li class="menu-item-has-children">
                                <a href="#">마이페이지</a>
                                <ul class="sub-menu">
                                    
                                    <li><a href="../member/memberinfo">회원정보</li>
                                    <li><a href="${pageContext.request.contextPath}/board/myproducts?boardid=4">찜한상품</a></li>
                                    <li><a href="${pageContext.request.contextPath}/board/myproducts?boardid=5">판매등록상품</a></li>
                                     <li><a href="${pageContext.request.contextPath}/board/myproducts?boardid=6">판매완료상품</a></li>
                                </ul>
                            </li>
                     <c:if test="${sessionScope.admin != null}">
    						<li><a href="/admin/main">관리자 페이지</a></li>
					</c:if>
				 </c:if>
				    
				 
				<!-- <ul class="sub-menu">
					<li><a href="portfolio-item.html">Portfolio Item</a></li>
					<li><a href="blog-single.html">Blog Article</a></li>
					<li><a href="shop-single.html">Shop Item</a></li>
					<li><a href="portfolio-category.html">Portfolio Category</a></li>
				</ul>
				</li>
				<li><a href="contact.html">Contact</a></li> -->
			</ul>
		</div>
		</nav>
		</header>
		<!-- #masthead -->
		
		<!-- #content -->
	</div>
	<!-- .container -->
	
	
</div>
<!-- #page -->

</body>
</html>