<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>

<head>
    <meta charset="UTF-8">
    <title>마이페이지 - 구입항목</title>
    <script src="${pageContext.request.contextPath }/resources/asset/js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/myPage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/order_Detail.css">
</head>

<body>

	<!-- HEADER IMPORT -->
	<%@ include file="../common/header.jsp" %>


    <div class="container">
        <div class="body-title">MY PAGE</div>
        
        <!-- 마이페이지 메뉴 (일반) -->
        <%@ include file="myPage_Menu.jsp" %> 
       
        <section class="main">
            <div class="wrap-section">
                <div class="table-title">구매 내역</div>
                <table class="product-table">
                    <thead>
                        <tr>
                            <th>상품정보</th>
                            <th>주문번호</th>
                            <th>주문일자</th>
                            <th>주문금액</th>
                            <th>주문상태</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <div class="product-info">
                                    <div class="brand-name">OOTD</div>
                                    <span class="product-name">Round String Jacket Brown </span>
                                    <span class="product-option">(small)</span>
                                </div>
                            </td>
                            <td>
                                <div class="order-no">0000001</div>
                            </td>
                            <td class="order-date">2021.06.06</td>
                            <td class="total-price">300,000&#8361;</td>
                            <td>
                                <span class="purchase-status">1</span> <!-- 값(숫자)에 따라 주문상태, 버튼 변경-->
                            </td>
                            <td>
                                <button class="confirm-purchase" style="display: none;">구매 확정</button>
                                <button class="write-review" style="display: none;">리뷰 작성</button>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="product-info">
                                    <div class="brand-name">OOTD</div>
                                    <span class="product-name">Round String Jacket Brown </span>
                                    <span class="product-option">(small)</span>
                                </div>
                            </td>
                            <td>
                                <div class="order-no">0000001</div>
                            </td>
                            <td class="order-date">2021.06.06</td>
                            <td class="total-price">300,000&#8361;</td>
                            <td>
                                <span class="purchase-status">2</span> <!-- 값(숫자)에 따라 주문상태, 버튼 변경-->
                            </td>
                            <td>
                                <button class="confirm-purchase" style="display: none;">구매 확정</button>
                                <button class="write-review" style="display: none;">리뷰 작성</button>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="product-info">
                                    <div class="brand-name">OOTD</div>
                                    <span class="product-name">Round String Jacket Brown </span>
                                    <span class="product-option">(small)</span>
                                </div>
                            </td>
                            <td>
                                <div class="order-no">0000001</div>
                            </td>
                            <td class="order-date">2021.06.06</td>
                            <td class="total-price">300,000&#8361;</td>
                            <td>
                                <span class="purchase-status">3</span> <!-- 값(숫자)에 따라 주문상태, 버튼 변경-->
                            </td>
                            <td>
                                <button class="confirm-purchase" style="display: none;">구매 확정</button>
                                <button class="write-review" style="display: none;">리뷰 작성</button>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="product-info">
                                    <div class="brand-name">OOTD</div>
                                    <span class="product-name">Round String Jacket Brown </span>
                                    <span class="product-option">(small)</span>
                                </div>
                            </td>
                            <td>
                                <div class="order-no">0000001</div>
                            </td>
                            <td class="order-date">2021.06.06</td>
                            <td class="total-price">300,000&#8361;</td>
                            <td>
                                <span class="purchase-status">4</span> <!-- 값(숫자)에 따라 주문상태, 버튼 변경-->
                            </td>
                            <td>
                                <button class="confirm-purchase" style="display: none;">구매 확정</button>
                                <button class="write-review" style="display: none;">리뷰 작성</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </section>
    </div>

    <!-- 모달 영역 (jsp에서 임포트로 변경)-->
    <div class="modal">
        <div class="order-detail">
            <div class="close-icon">
                <img src="${pageContext.request.contextPath }/resources/icon/close_icon.png" alt="close icon">
            </div>
            <!-- <div class="for-modal-close"></div> -->
            <div class="detail-area">

                <div class="detail-title">ORDER DETAIL</div>
                <div class="order-no-area">
                    <span>No.</span>
                    <span class="order-no">0000001</span>
                </div>
                <div class="customer-info-title detail-subtitle">Customer Info</div>
                <table class="customer-info">
                    <thead>
                        <tr>
                            <th>주문자명</th>
                            <th>배송주소</th>
                            <th>연락처</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <div class="customer-name">옷삼이</div>
                            </td>
                            <td>
                                <div class="customer-address">서울시 강남구 옷삼로333, 21 2층</div>
                            </td>
                            <td>
                                <div class="customer-phone">010-1234-1234</div>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="product-info-title detail-subtitle">Ordered Item</div>
                <table class="order-list">
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>주문일자</th>
                            <th>수량</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <span class="product-name">Round String Jacket Brown </span>
                                <span class="product-option">(small)</span>
                            </td>
                            <td>
                                <div class="order-date">2021.06.06</div>
                            </td>
                            <td>
                                <div class="order-quantity">3</div>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="price-area">
                    <span>주문금액 : </span>
                    <span price-amount>200,000&nbsp;&#8361;</span>
                </div>
            </div>
        </div>
    </div>
    
            
    <!-- FOOTER IMPORT -->
   	<%@ include file="../common/footer.jsp" %>
   	
</body>

<script>
    // 모달창 스크립트
    $('.order-no').click(function () {
        $('.modal').fadeIn();
    })

    $('.modal').on('click', function (event) {
        if ($(event.target).hasClass('modal')) {
            $('.modal').fadeOut()
        }
    });

    $('.close-icon').click(function () {
        $('.modal').fadeOut();
    })


    // .purchase_status의 값(value)에 따라 배송 상태 텍스트 변경
    $(function () {
        $('.purchase-status').each(function () {
            ps = $(this).text();

            cfmBtn = $(this).parent().next().children('.confirm-purchase');
            wrvBtn = $(this).parent().next().children('.write-review');

            switch (ps) {
                case "1":
                    $(this).text('배송준비');
                    break;
                case "2":
                    $(this).text('배송중');
                    cfmBtn.show();
                    break;
                case "3":
                    $(this).text('구매완료');
                    wrvBtn.show();
                    break;
                case "4":
                    $(this).html('<span>구매완료</span><br><span>후기작성완료</span>');
                    break;
            }
        })
    })


    $('.write-review').click(function () {
        $(location).attr('href', '${pageContext.request.contextPath}/myPage/myPage_Review.mp')
    })
</script>

</html>