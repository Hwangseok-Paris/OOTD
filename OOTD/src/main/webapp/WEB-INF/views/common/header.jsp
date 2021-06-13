<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="../member/loginModal.jsp"%>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/header.css">


<script
	src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>

</head>
<body>
	<header class="header">
		<div class="header_nav">
			<!-- HEADER 로고 클릭 시 index화면으로 이동 -->
			<div class="header_logo">
				<img
					src="${pageContext.request.contextPath }/resources/images/headerlogo.png"
					id="logo" />
			</div>

			<!-- Header Brand, Second Hands (클릭 시 하단에 메뉴바) -->
			<div class="header_menu">
				<div>
					<a href="#"><h3 id="brand">BRAND</h3></a>
				</div>
				<div>
					<a href="#"><h3 id="second_Hand">SECOND HAND</h3></a>
				</div>
			</div>

			<!-- 검색창, 장바구니, 마이페이지, 다크모드 -->
			<div class="header_option">
				<ul class="nav_menu">
					<li class="search_li">
						<div>

							<form action="" method="GET" id="search_main">
								<input type="text" class="search_input"> <i
									class="fas fa-search fa-lg"></i>
							</form>
						</div>

					</li>

					<li><i class="fas fa-shopping-cart fa-lg"></i></li>

					<li><i class="fas fa-user fa-lg" id="loginBtn"
						data-target="#loginModal" data-toggle="modal"></i></li>
					<li>
						<span class="fa-stack fa-lg"> 
							<i class="far fa-sun fa-stack-1x fa-lg"></i> 
							<i class ="far fa-moon fa-stack-1xfa-lg"></i>
						</span>
					</li>

				</ul>


			</div>
		</div>
	</header>




	<script>
		$(function() {

			var icon = document.getElementById("logo");
			var icon_footer = document.getElementById("logo_footer")

			$('ul').children('li').find('.fa-search').click(function() {
				alert("css개빡치네");
			})

			//  $('ul').children('li').find('.fa-user').click(function() {
			//       alert("로그인 되있으면 마이페이지 안되있으면 로그인 페이지");
			//  })

			$('.fa-moon').on('click', function() {
								document.documentElement.classList.toggle("dark");

								$('.search_input').css('background-color','black');
								$('.search_input').css('color', 'white');

								icon.src = "${pageContext.request.contextPath }/resources/images/headerdarklogo.png";
								icon_footer.src = "${pageContext.request.contextPath }/resources/images/footerdarklogo.jpeg";
								
								$('.fa-moon').hide();
								$('.fa-sun').css('visibility', 'visible');

							})

			$('.fa-sun').on('click', function() {
								document.documentElement.classList.toggle("dark");

								$('.search_input').css('background-color','white');
								$('.search_input').css('color', '#bbb');

								icon.src = "${pageContext.request.contextPath }/resources/images/headerlogo.png";
								icon_footer.src = "${pageContext.request.contextPath }/resources/images/footerlogo.png";
								$('.fa-sun').css('visibility', 'hidden');
								$('.fa-moon').show();

							})

			$('.header_logo').on('click', function() {

			})

		})
	</script>
</body>
</html>