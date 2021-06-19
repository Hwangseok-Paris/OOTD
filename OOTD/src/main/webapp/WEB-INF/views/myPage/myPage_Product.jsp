<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지 - 상품리스트</title>
    <script src="${pageContext.request.contextPath }/resources/asset/js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/myPage.css">

    <c:import url="../common/styler.jsp"/>


</head>

<body>

	<!-- HEADER IMPORT -->
	<c:import url="../common/header.jsp"/>


    <div class="container-myPage">
        <div class="body-title">MY PAGE</div>
        
        <!-- 마이페이지 메뉴 (일반) -->
        <%@ include file="myPage_Menu.jsp"%>        

         <section class="main">
            <div class="wrap-section">
                <div class="table-title">Product List</div>
                <table class="user-product-list">
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>상품번호</th>
                            <th>가격</th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach items="${list }" var="s">
	                    <tbody>
	                        <tr>
	                            <td class="product-name">
	                            	${s.product_name }
	                            </td>
	                            <td>
	                                <div class="product-no">${s.product_no }</div>
	                            </td>
	                            <td class="total-price"><fmt:formatNumber type="number" maxFractionDigits="3" value="${s.product_price}" /> &#8361;</td>
	                            <td>
<<<<<<< HEAD
	                                <button class="modify-product modify">수정</button>
	                                <button class="delete-product delete" id="${s.product_no }">삭제</button>
=======
	                                <button class="modify-product modify" id="updateProduct" onclick="moveToUpdate()">수정</button>
	                                <button class="delete-product delete" id="deleteProduct" onclick="deleteProduct()">삭제</button>
>>>>>>> refs/remotes/origin/feature_Jung
	                            </td>
	                        </tr>
	                    </tbody>
                    </c:forEach>
                </table>
            </div>
        </section>
    </div>
    
    <script>
<<<<<<< HEAD
    	$('.delete-product').on('click', function() {
    		var productNo = $(this).attr('id')
    		location.href="${pageContext.request.contextPath }/myPage/myPage_Product_Delete.do?productNo=" + productNo;
    	});
=======
    	function moveToUpdate() {
    		location.href="${pageContext.request.contextPath}/product/productUpdateView.do";
    	}
    
    	function deleteProduct() {
    		
    	}
>>>>>>> refs/remotes/origin/feature_Jung
    </script>
            
    <!-- FOOTER IMPORT -->
   	<%@ include file="../common/footer.jsp" %>
   	
</body>

</html>