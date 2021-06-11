<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

    
    <div class="modal">
        <div class="order-detail">
            <div class="close-icon">
                <img src="${pageContext.request.contextPath }/resources/icon/close_icon.png" alt="close icon">
            </div>
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

</script>