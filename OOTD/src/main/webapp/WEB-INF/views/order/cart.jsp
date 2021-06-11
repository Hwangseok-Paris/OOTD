<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width,initial-scale=1">
   <title>장바구니</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   <script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/cart.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css"/>
     <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/footer.css"/>
</head>

<body>
<c:import url="../common/header.jsp"/>
   <div id="backbody">
      <div id="frame1">
         <form>
            <div id="frame2">
               <span style="font-size:15pt; font-weight: bold;">장바구니</span>
               <span class="home"><b>장바구니</b>&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;주문서 작성&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;주문 완료</span>
            </div>
            
            <div>
               <table class="calculation1" style="margin-top:20px;">
               <thead>
                  <tr>
                     <th colspan="10" style="text-align: left; padding-left: 10px; padding-top: 20px;">주문상품(1)</th>
                  </tr>
                  
                  <tr>
                     <th colspan="10" style="text-align: left; padding-left: 10px; color: gray; padding-top: 30px; border-bottom: solid 1px #e0e0eb;">상품정보</th>
                  </tr>
            
                  <tr>
                     <th style="width: 50px;"><input type="checkbox" name="checkbox" id="check" style="width: 50px;"/></th>
                     <th style="width: 100px;"><span>이미지</span></th>
                     <th style="width: 400px;">상품정보</th>
                     <th style="width: 130px;">판매가</th>
                     <th style="width: 130px;">수량</th>
                     <th style="width: 130px;">주문관리</th>
                  </tr>
               </thead>
      
               <tbody id="calculation1tbody">
                  <tr class="calculation1_tbody_tr1" style="height: 90px; background-color: #fff;">
                     <td style="text-align: left; text-align: center; border-right: none;">
                        <input type="checkbox" id="cbtr1" name="checkbox" />
                     </td>
                     <td style="border-left: none; border-right: none; width: 100px; text-align: center;"><img src="${pageContext.request.contextPath }/resources/images/sample.PNG" width="100px"></td>
                     <td style="text-align: left; padding-left: 10px; border-left: none; font-weight: bold;">
                     <span>[나이키]</span> <br /><span>엠버로이드 라운드 반팔티셔츠 707350-011</span> <br /><br />옵션 : <span>S</span>
                     </td>
                     <td>
                        <span class="price1" style="padding-left: 10px;">25900</span>원
                        <input type="hidden" class="realPrice" value="25900">
                     </td> 
                     <td style="width: 100px;">
                        <button class="button1 quanBtn" id="button" type ="button"  value='-' >-</button>
                       <div id="result" class="result">1</div>
                       <button class="button2 quanBtn" id="button" type="button"  value='+'>+</button>
                     </td>
                     
                     <td>
                        <button class="btn default btndelete">삭제</button>
                     </td>
                     
                  </tr>
                  <!-- 임시-상품 추가했을 때 확인 -->
                  <tr style="height: 90px; background-color: #fff;">
                     <td style="text-align: left; text-align: center; border-right: none;">
                        <input type="checkbox" id="cbtr2" name="checkbox" />
                     </td>
                     <td style="border-left: none; border-right: none; width: 100px; text-align: center;"><img src="${pageContext.request.contextPath }/resources/images/sample.PNG" width="100px"></td>
                     <td style="text-align: left; padding-left: 10px; border-left: none; font-weight: bold;">
                     <span>[나이키]</span> <br /><span>엠버로이드 라운드 반팔티셔츠 707350-011</span> <br /><br />옵션 : <span>S</span>
                     </td>
                     <td>
                        <span class="price1" style="padding-left: 10px;">25900</span>원
                        <input type="hidden" class="realPrice" value="25900">
                     </td>
                     <td style="width: 100px;">
                        <button class="button1 quanBtn" id="button" type ="button" value='-' >-</button>
                          <div id="result"  class="result">1</div>
                          <button class="button2 quanBtn" id="button" type="button" value='+'>+</button>
                     </td>
                     
                     <td>
                        <button class="btn default btndelete">삭제</button>
                     </td>
                     
                  </tr>
               </tbody>
               
               </table>
               
               <div style="margin: 10px 0;">
                  <button class="btn default btnfloat" style="background-color: #B7B8B9; color: #fff;">선택삭제</button>&nbsp;&nbsp;
                  <button class="btn default btnfloat" style="background-color: #B7B8B9; color: #fff;">전체삭제</button>
                  <span class="clearboth"></span>
               </div>
               <br /><br />
               
               <table class="calculation2">
               <tr style="background-color: #fafafa;">
                  <th style="width: 300px;">총 상품금액</th>
                  <th style="width: 300px;">총 배송비</th>
                  <th style="width: 300px; padding: 22px 0;"><span>총 결제금액</span></th>
               </tr>
               
               <tr style="background-color: #fff;">
                  <td style="padding: 22px 0;"><span class="totalPrice" id="price">25,900</span>원</td>
                  <td><span class="price" id="price">0</span>원</td>
                  <td><span class="totalPrice" id="price">25,900</span>원</td>
               </tr>
            </table>
            <br /><br /><br />
               
            </div>
            
            <div align="center">
               <button type="button" class="btn default orderbtn" id="allProduct">전체상품주문</button>
               <button type="button" class="btn default" id="productClear">선택상품주문</button>
               <button type="button" class="btn default footerbtn" id="footerbtn" type="button" onclick="location.href='${pageContext.request.contextPath}/order/order.do'" style="color: white;">쇼핑계속하기</button>
               <span class="clearboth"></span>
            </div>
            <br /><br /><br /><br />
   
            <div class="guideFrame">
               이용안내
            </div>
            <div class="guideDetail">
               <ul>
                  <li class="lifont">구매 가능 수량이 1개로 제한된 상품은 주문 취소 시, 24시간 내 가상계좌 재주문이 불가합니다.</li>
                  <li class="lifont">내일의 옷은 기본적으로 전 상품 무료 배송입니다.</li>
                  <li class="lifont">2개 이상 브랜드를 주문하신 경우, 각각 개별 배송됩니다.</li>
                  <li class="lifont">장바구니에 담은 시점과 현재의 판매 가격이 달라질 수 있습니다.</li>
                  <li class="lifont">수량 제한 상품의 경우, 가상계좌를 통한 주문은 최대 2건까지만 가능합니다.(미입금 주문 기준, 기존 주문 합산)</li>
               </ul>
            </div>
         </form>
      </div>
   </div>

<!-- <script>
   $(document).ready(function(){
      
      // 체크박스 전체 선택, 개별 선택, 선택 해제
      $(".calculation1 thead input:checkbox[id=check]").click(function(){
         var bool = $(this).prop("checked");
         $(".calculation1 tbody input:checkbox[name=checkbox]").prop("checked", bool);
      });
      
      $(".calculation1 tbody input:checkbox[name=checkbox]").click(function(){
         var flag = false;
         $(".calculation1 tbody input:checkbox[name=checkbox]").each(function(){
            var bool = $(this).prop("checked");
         
            if(!bool){
               $(".calculation1 thead input:checbox'id=check]").prop("checked", false);
               flag = true;
               return false;
            }
         });
         
         if(!flag){
            $(".calculation1 thead input:checkbox[id=check]").prop("checked", true);
         }
      });
      
      // 이메일 선택시, 자동으로 값 들어오게 하기
      $("#emailChoice").bind("change", function(){
         $("#domainName").val($(this).val());
      });
      
      calcPrice();
   });
   
   // 총합 계산
   function calcPrice(){
      var sum = 0;
      $('.price1').each(function(){
         sum += Number($(this).text());
      });
      
      $('.totalPrice').text(thousandComma(sum));
   }
   
   // 천단위 쉼표 함수
   function thousandComma(x){
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
   
   // 수량 -
   $('.button1').click(function(){
	   var a = parseInt($(this).siblings('.result').text());
	      console.log("a2", a);
	      a = a-1;
	      if(a<1){
	         alert("잘못된 수량입니다.") 
	         return false;
	         }
	      $(this).siblings('.result').text(a);
	      
	      //var b = parseInt($(this).parent().siblings().children('.price1').text());
	      var price = $('.realPrice').val();
	      console.log(price);
	      $(this).parent().siblings().children('.price1').text(a*price);
	      
	      calcPrice();
   });
   
   // 수량 +
   $('.button2').click(function(){
      var a = parseInt($(this).siblings('.result').text());
      console.log("a1", a);
      a= a+1;
      $(this).siblings('.result').text(a);
   
      // var b = parseInt($(this).parent().siblings().children('.price1').text());
      var price = $('.realPrice').val(); // span의 id값을 가져와서 a*price
      console.log(price);
      $(this).parent().siblings().children('.price1').text(a*price);
      
      calcPrice();
      
   });
      
   // 선택 삭제
   $(".btndelete").click(function(){
      $(this).parent().parent().remove();
      
      var tr = $('#calculation1tbody tr').val();
      if(tr == null){
         console.log("장바구니가 비어있습니다.")
      }
   });
</script> -->
<c:import url="../common/footer.jsp"/>
</body>
</html>