<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <aside class="category-list">
		<div class="menu-title">MY PAGE</div>
		<ul class="category">
		    <li>
		        <a href="${pageContext.request.contextPath}/myPage/myPage_Brand_Info.mp">회원 정보</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/myPage/myPage_Brand_Product.mp">등록 상품</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/myPage/myPage_Brand_Order.mp">주문 내역</a>
		    </li>
		    <li>
		        <a href="${pageContext.request.contextPath}/myPage/myPage_Brand_Rank.mp">상품 순위</a>
		    </li>
		</ul>
	</aside>