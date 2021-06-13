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
   <title>주문 페이지</title>
   <script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
   <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
   <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/order.css"/>
</head>
 
<body>
<c:import url="../common/header.jsp"/>
<div id="backbody order">
   <div id="frame1" style="align: center;">
      <form>
         <div id="frame2">
            <span style="font-size:15pt; font-weight: bold;">주문서 작성</span>
            <span class="home">장바구니&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;<b>주문서 작성&nbsp;&nbsp;&nbsp;</b>>&nbsp;&nbsp;&nbsp;주문 완료</span>
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
                 
                  <th style="width: 100px;"><span>이미지</span></th>
                  <th style="width: 400px;">상품정보</th>
                  <th style="width: 130px;">판매가</th>
                  <th style="width: 130px;">수량</th>
               </tr>
            </thead>
   
            <tbody>
               <tr style="height: 90px; background-color: #fff;">
                  
                  <td style="border-left: none; border-right: none; width: 100px; text-align: center;"><img src="${pageContext.request.contextPath }/resources/images/sample.PNG" width="100px"></td>
                  <td style="text-align: left; padding-left: 10px; border-left: none; font-weight: bold;">
                  <span>[나이키]</span> <br /><span>엠버로이드 라운드 반팔티셔츠 707350-011</span> <br /><br />옵션 : <span>S</span>
                  </td>
                  <td><span style="padding-left: 10px;">25,900</span>원</td>
                  <td style="width: 100px;">                        
                  	<div id="result" class="result">1</div> 
                  </td>
               </tr>
               <!-- 임시-상품 추가했을 때 확인 -->
               <tr style="height: 90px; background-color: #fff;">
                  
                  <td style="border-left: none; border-right: none; width: 100px; text-align: center;"><img src="${pageContext.request.contextPath }/resources/images/sample.PNG" width="100px"></td>
                  <td style="text-align: left; padding-left: 10px; border-left: none; font-weight: bold;">
                  <span>[나이키]</span> <br /><span>엠버로이드 라운드 반팔티셔츠 707350-011</span> <br /><br />옵션 : <span>S</span>
                  </td>
                  <td><span style="padding-left: 10px;">25,900</span>원</td>
                  <td style="width: 100px;">
                     <div id="result" class="result">1</div>
                  </td>                  
               </tr>
            </tbody>
   
            
            </table>
            <br />
            <table class="calculation2">
            <tr style="background-color: #fafafa;">
               <th style="width: 300px;">총 상품금액</th>
               <th style="width: 300px;">총 배송비</th>
               <th style="width: 300px; padding: 22px 0;"><span>총 결제금액</span></th>
            </tr>
            
            <tr style="background-color: #fff;">
               <td style="padding: 22px 0;"><span class="price">25,900</span>원</td>
               <td><span class="price">0</span>원</td>
               <td><span class="price">25,900</span>원</td>
            </tr>
         </table>
         <br /><br /><br />
            
         </div>
         
         <table class="delivery">
            <thead>
               <tr>
                  <th colspan="10">배송지 정보</th>
               </tr>
               
               <tr>
                  <td class="deliverytd">주문고객</td>
                  <td>
                     홍길동
                  </td>
               </tr>
               
               <tr>
                  <td class="deliverytd">수령인&nbsp;<span style="color: red">*</span></td>
                  <td><input class="underline" type="text" value="김길동" required="required" /></td>
               </tr>
               
               <tr>
                  <td class="deliverytd">주소&nbsp;<span style="color: red">*</span></td>
                  
                  <td>
                     <input class="underline" type="text" id="postnum1" size="10" maxlength="5" required="required" />
                     &nbsp;
                     <div class="btn default postSearch" id="postnum2" onclick="addrSearch();">우편번호 찾기</div>
                     <br />
                     <input class="underline" type="text" id="addr1" size="50" placeholder="주소" required="required" style="margin-bottom: 10px;" />
                     <br />
                     <input class="underline" type="text" id="addr2" size="50" placeholder="상세주소" required="required"/>
                  </td>
               </tr>
               
               <tr>
                  <td class="deliverytd">휴대전화&nbsp;<span style="color: red">*</span></td>
                  <td><input class="underline" type="text" placeholder="010-1234-5678"/></td>
               </tr>
               <tr>
                  <td class="deliverytd">이메일&nbsp;<span style="color: red">*</span></td>
                  <td><input class="underline" type="text" required="required"/> @ <input class="underline" id="domainName" type="text" required="required"/>&nbsp;
                     <select id="emailChoice" style="height: 30px; font-size: 13px;">
                        <option>이메일 선택</option>
                        <option>daum.net</option>
                        <option>naver.com</option>
                        <option>nate.com</option>
                        <option>gmail.com</option>
                     </select>
                  </td>
               </tr>
               
               <tr>
                  <td class="deliverytd" style="border-bottom: solid 1px #e0e0eb; padding-bottom:30px;">배송메모</td>
                  <td style="border-bottom: solid 1px #e0e0eb; padding-bottom:30px;">                  
                     <select id="memoChoice" style="height: 30px; font-size: 13px;">
                        <option value="test1">배송 시 요청사항을 선택해주세요</option>
                        <option value="test2">부재시 경비실에 맡겨주세요</option>
                        <option value="test3">배송 전 연락바랍니다</option>
                        <option value="test4">직접입력</option>
                     </select>
                     <br />
                     <textarea class="textarea" cols="80" rows="5"></textarea>
                  </td>
               </tr>
            </thead>
         </table>
         <br /><br />
            
         <div class="payArea">
            <div class="payment"><p style="margin-top: 30px; font-size: 10pt; font-weight: bold; color: gray;">결제수단선택</p>
               <div style="padding: 18px 10px; font-size: 10pt; color: black; font-weight: bold;">
                  <img src="${pageContext.request.contextPath }/resources/images/orderImg/card.PNG" alt="" style="width: 50px; margin-left: 10px;"/>
                  <img src="${pageContext.request.contextPath }/resources/images/orderImg/account.PNG" alt="" style="width: 50px; margin-left: 70px;"/>
                  <img src="${pageContext.request.contextPath }/resources/images/orderImg/phone.PNG" alt="" style="width: 50px; margin-left: 75px;"/>
                  <img src="${pageContext.request.contextPath }/resources/images/orderImg/passbook.PNG" alt="" style="width: 50px; margin-left: 60px;"/>
                  <br />
                  <input type="radio" name="cardradio" checked />신용카드
                  <input type="radio" name="cardradio" style="margin-left: 30px;"/>실시간 계좌이체
                  <input type="radio" name="cardradio" style="margin-left: 30px;"/>휴대폰 결제
                  <input type="radio" name="cardradio" style="margin-left: 30px;"/>무통장 입금
               </div>
            </div>
            <div class="total">
               <span style="display:inline-block; padding: 30px 10px; color: gray; font-weight: bold;">결제정보</span><br />
               <span style="display:inline-block; padding: 20px 10px;">주문상품금액</span>
               <span style="font-size: 20pt; font-weight: bold; float: right;">25,900원</span><br /><br />
               <button type="button" class="btn default payBtn" onclick="location.href='${pageContext.request.contextPath}/order/paymentSuccess.or'">결제하기</button>
            </div>
         </div>
         <br /><br />
         
         <div class="guideFrame">
            주문 전 확인하세요!
         </div>
         <div class="guideDetail">
            <ul>
               <li class="lifont">실제 결제 금액에 따라 적립포인트는 변경될 수 있습니다.</li>
               <li class="lifont">내일의 옷은 기본적으로 전 상품 무료 배송입니다.</li>
               <li class="lifont">2개 이상 브랜드를 주문하신 경우, 각각 개별 배송됩니다.</li>
               <li class="lifont">오프라인 매장과 동시 판매되고 있어 결제완료/입고확정 이후에도 품절이나 발송지연이 있을 수 있습니다.</li>
               <li class="lifont">품절 발생 시 문자로 결제취소 또는 재결제에 대해 추가 안내 드리고, 품절취소 고객보상 기준에 따라 보상해 드립니다.</li>
            </ul><br />
         </div>
      </form>
   </div>
</div>
<script>
   
   function addrSearch() {
       new daum.Postcode({
           oncomplete: function(data) {
               // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
   
               // 각 주소의 노출 규칙에 따라 주소를 조합한다.
               // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
               var fullAddr = ''; // 최종 주소 변수
               var extraAddr = ''; // 조합형 주소 변수
   
               // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
               if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                   fullAddr = data.roadAddress;
   
               } else { // 사용자가 지번 주소를 선택했을 경우(J)
                   fullAddr = data.jibunAddress;
               }
   
               // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
               if(data.userSelectedType === 'R'){
                   //법정동명이 있을 경우 추가한다.
                   if(data.bname !== ''){
                       extraAddr += data.bname;
                   }
                   // 건물명이 있을 경우 추가한다.
                   if(data.buildingName !== ''){
                       extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                   }
                   // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                   fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
               }
   
               // 우편번호와 주소 정보를 해당 필드에 넣는다.
               $('#postnum1').val(data.zonecode); //5자리 새우편번호 사용
               
               $('#addr1').val(fullAddr);
   
               // 커서를 상세주소 필드로 이동한다.
               $('#addr2').focus();
           }
       }).open();
   };
   
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
   });
   
	// 배송메모 - 직접 입력 선택시에만 textarea 보여주기 
	  $('#memoChoice').on('change', function(){
	     var a = $('#memoChoice option:selected').val();
	     console.log(a);
	     if( a == 'test4') {
	        $('textarea').show();
	     } else {
	        $('textarea').hide();
	        console.log("test4 아님");
	     }
	  
	  
	  });
</script>
<c:import url="../common/footer.jsp"/>
</body>
</html>