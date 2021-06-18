
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

	<head>
	    <meta charset="UTF-8">
	    <title>브랜드 - 상품 순위</title>
	    <script src="${pageContext.request.contextPath }/resources/asset/js/jquery-3.6.0.min.js"></script>
	    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/myPage.css">
	    <c:import url="../common/styler.jsp"/>
	</head>

<body>

	<!-- HEADER IMPORT -->
	<c:import url="../common/header.jsp"/>

    <div class="container-myPage">
        <div class="body-title">MY PAGE</div>
       
        <!-- 좌측 aside 메뉴 (BRAND)-->
        <%@ include file="myPage_Brand_Menu.jsp" %>
     
        <section class="main">
            <div class="wrap-section">
                <div class="table-title">Product Rank</div>
                <table class="product-rank">
                    <thead>
                        <tr>
                            <th>순위</th>
                            <th>상품명</th>
                            <th>상품번호</th>
                            <th>가격</th>
                            <th>누적 판매수량</th>
                            <th>누적 판매금액</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <div class="rank">1</div>
                            </td>
                            <td>
                                <div class="product-info">
                                    <span class="product-name">Round String Jacket Brown </span>
                                </div>
                            </td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-price">30,000&nbsp;&#8361;</td>
                            <td>
                                <div class="sold">30</div>
                            </td>
                            <td>
                                <div class="sold-price">900,000&nbsp;&#8361;</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="rank">2</div>
                            </td>
                            <td>
                                <div class="product-info">
                                    <span class="product-name">Round String Jacket Brown </span>
                                </div>
                            </td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-price">30,000&nbsp;&#8361;</td>
                            <td>
                                <div class="sold">30</div>
                            </td>
                            <td>
                                <div class="sold-price">900,000&nbsp;&#8361;</div>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div class="rank">3</div>
                            </td>
                            <td>
                                <div class="product-info">
                                    <span class="product-name">Round String Jacket Brown </span>
                                </div>
                            </td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-price">30,000&nbsp;&#8361;</td>
                            <td>
                                <div class="sold">30</div>
                            </td>
                            <td>
                                <div class="sold-price">900,000&nbsp;&#8361;</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="rank">4</div>
                            </td>
                            <td>
                                <div class="product-info">
                                    <span class="product-name">Round String Jacket Brown </span>
                                </div>
                            </td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-price">30,000&nbsp;&#8361;</td>
                            <td>
                                <div class="sold">30</div>
                            </td>
                            <td>
                                <div class="sold-price">900,000&nbsp;&#8361;</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="rank">5</div>
                            </td>
                            <td>
                                <div class="product-info">
                                    <span class="product-name">Round String Jacket Brown </span>
                                </div>
                            </td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-price">30,000&nbsp;&#8361;</td>
                            <td>
                                <div class="sold">30</div>
                            </td>
                            <td>
                                <div class="sold-price">900,000&nbsp;&#8361;</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="rank">6</div>
                            </td>
                            <td>
                                <div class="product-info">
                                    <span class="product-name">Round String Jacket Brown </span>
                                </div>
                            </td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-price">30,000&nbsp;&#8361;</td>
                            <td>
                                <div class="sold">30</div>
                            </td>
                            <td>
                                <div class="sold-price">900,000&nbsp;&#8361;</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="rank">7</div>
                            </td>
                            <td>
                                <div class="product-info">
                                    <span class="product-name">Round String Jacket Brown </span>
                                </div>
                            </td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-price">30,000&nbsp;&#8361;</td>
                            <td>
                                <div class="sold">30</div>
                            </td>
                            <td>
                                <div class="sold-price">900,000&nbsp;&#8361;</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="rank">8</div>
                            </td>
                            <td>
                                <div class="product-info">
                                    <span class="product-name">Round String Jacket Brown </span>
                                </div>
                            </td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-price">30,000&nbsp;&#8361;</td>
                            <td>
                                <div class="sold">30</div>
                            </td>
                            <td>
                                <div class="sold-price">900,000&nbsp;&#8361;</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="rank">9</div>
                            </td>
                            <td>
                                <div class="product-info">
                                    <span class="product-name">Round String Jacket Brown </span>
                                </div>
                            </td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-price">30,000&nbsp;&#8361;</td>
                            <td>
                                <div class="sold">30</div>
                            </td>
                            <td>
                                <div class="sold-price">900,000&nbsp;&#8361;</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="rank">10</div>
                            </td>
                            <td>
                                <div class="product-info">
                                    <span class="product-name">Round String Jacket Brown </span>
                                </div>
                            </td>
                            <td>
                                <div class="product-no">0000001</div>
                            </td>
                            <td class="product-price">30,000&nbsp;&#8361;</td>
                            <td>
                                <div class="sold">30</div>
                            </td>
                            <td>
                                <div class="sold-price">900,000&nbsp;&#8361;</div>
                            </td>
                        </tr>

                    </tbody>
                </table>
            </div>
        </section>
    </div>
    
    <!-- FOOTER IMPORT -->
   	<%@ include file="../common/footer.jsp" %>
   	
</body>

</html>