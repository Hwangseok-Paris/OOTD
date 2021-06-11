<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>브랜드 - 상품리스트</title>
	    <script src="${pageContext.request.contextPath }/resources/asset/js/jquery-3.6.0.min.js"></script>
	    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/myPage.css">
	</head>
<body>

	<!-- HEADER IMPORT -->
	<%@ include file="../common/header.jsp" %>

    <div class="container">
        <div class="body-title">MY PAGE</div>
       
        <!-- 좌측 aside 메뉴 (BRAND)-->
        <%@ include file="myPage_Brand_Menu.jsp" %>
     
        <section class="main">
            <div class="wrap-section">
                <div class="table-title">Product List</div>
                <table class="product-list">
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>상품번호</th>
                            <th>사이즈 - 재고</th>
                            <th>가격</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="product-name">Round String Jacket Brown</td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-stock">
                                <div class="stock-area">
                                    <span class="product-size">small</span>&nbsp;-
                                    <span class="product-stock">100</span><br>
                                    <span class="product-size">medium</span>&nbsp;-
                                    <span class="product-stock">80</span><br>
                                    <span class="product-size">large</span>&nbsp;-
                                    <span class="product-stock">50</span>
                                </div>
                            </td>
                            <td class="total-price">80,000 &#8361;</td>
                            <td>
                                <button class="modify-product modify">수정</button>
                                <button class="delete-product delete">삭제</button>
                            </td>
                        <tr>
                            <td class="product-name">Round String Jacket Brown</td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-stock">
                                <div class="stock-area">
                                    <span class="product-size">small</span>&nbsp;-
                                    <span class="product-stock">100</span><br>
                                    <span class="product-size">medium</span>&nbsp;-
                                    <span class="product-stock">80</span><br>
                                    <span class="product-size">large</span>&nbsp;-
                                    <span class="product-stock">50</span>
                                </div>
                            </td>
                            <td class="total-price">80,000 &#8361;</td>
                            <td>
                                <button class="modify-product modify">수정</button>
                                <button class="delete-product delete">삭제</button>
                            </td>
                        <tr>
                            <td class="product-name">Round String Jacket Brown</td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-stock">
                                <div class="stock-area">
                                    <span class="product-size">small</span>&nbsp;-
                                    <span class="product-stock">100</span><br>
                                    <span class="product-size">medium</span>&nbsp;-
                                    <span class="product-stock">80</span><br>
                                    <span class="product-size">large</span>&nbsp;-
                                    <span class="product-stock">50</span>
                                </div>
                            </td>
                            <td class="total-price">80,000 &#8361;</td>
                            <td>
                                <button class="modify-product modify">수정</button>
                                <button class="delete-product delete">삭제</button>
                            </td>
                        <tr>
                            <td class="product-name">Round String Jacket Brown</td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-stock">
                                <div class="stock-area">
                                    <span class="product-size">small</span>&nbsp;-
                                    <span class="product-stock">100</span><br>
                                    <span class="product-size">medium</span>&nbsp;-
                                    <span class="product-stock">80</span><br>
                                    <span class="product-size">large</span>&nbsp;-
                                    <span class="product-stock">50</span>
                                </div>
                            </td>
                            <td class="total-price">80,000 &#8361;</td>
                            <td>
                                <button class="modify-product modify">수정</button>
                                <button class="delete-product delete">삭제</button>
                            </td>
                        <tr>
                            <td class="product-name">Round String Jacket Brown</td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-stock">
                                <div class="stock-area">
                                    <span class="product-size">small</span>&nbsp;-
                                    <span class="product-stock">100</span><br>
                                    <span class="product-size">medium</span>&nbsp;-
                                    <span class="product-stock">80</span><br>
                                    <span class="product-size">large</span>&nbsp;-
                                    <span class="product-stock">50</span>
                                </div>
                            </td>
                            <td class="total-price">80,000 &#8361;</td>
                            <td>
                                <button class="modify-product modify">수정</button>
                                <button class="delete-product delete">삭제</button>
                            </td>
                    </tbody>
                </table>
            </div>
        </section>
    </div>
        
    <!-- FOOTER IMPORT -->
   	<%@ include file="../common/footer.jsp" %>
   	
</body>

</html>