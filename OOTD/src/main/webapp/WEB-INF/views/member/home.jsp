<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
	<title>카카오 로그인</title>
	
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script>
        // SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('070e574cef4ec45be518f989611aff42');
        // SDK 초기화 여부를 판단합니다.
        console.log(Kakao.isInitialized());
    </script>
	
</head>
<body>
<h1>
	Hello world!
</h1>



<a id="custom-login-btn" href="javascript:loginWithKakao()">
  <img
    src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
    width="222"
  />
</a>

<br>
<br>
<br>


<%
	String code = null;
	
	session = request.getSession();
    
	if(session.getAttribute("code") != null){
    	
		code = (String)session.getAttribute("code");
    	
    	out.print("<h5>code: " + code + "</h5>" + "<br>");
%>
    	
    	<input type="hidden" id="code" value=<%=code%> />
    	
    	<input type="hidden" id="tocken" value="" />
    	
    	<a id="mytoken" href="javascript:selectMyAccessTockenWithKakao()">나의 토큰 정보 얻기</a>
    	
    	<a id="myinfo" href="javascript:selectMyInfoWithKakao()">나의 정보 얻기</a>
    	
<% 
    }else{
    	out.print("*로그인 후 code를 받으세요." +"<br>");
    }
    
%>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

var code = null;
 
 if(document.getElementById("code") != null){
	 
	 
	 //코드 체크
	 var code = document.getElementById("code").value;
	  
	  
	 if(code != null){
	 	//코드 존재
	 	console.log("code  존재");
	 	console.log(code);
	 	
	     Kakao.Auth.setAccessToken(code);
	     
	     
	     
	 }else{
	 	console.log("code 없음");
	 }
 }
 

 
 
 //카카오 로그인
function loginWithKakao() {
    Kakao.Auth.authorize({
        redirectUri: 'http://localhost:8080/oauth'
      });		
  }
	
 
 
//나의 토큰 가져오기	
function selectMyAccessTockenWithKakao() {
	
 	var param = {"code" : code}
	
	 	$.ajax({
			url  : '/selectMyAccessTockenWithKakao',
	        type : 'get',
	        data : param,
	        dataType : "JSON", 
	        contentType: "application/x-www-form-urlencoded;charset=utf-8", 
	        success : function(data){
	            
	        	
	        	console.log(data);
	        	
	        	console.log(data['access_token']);    //토큰얻기
	        	
	        	document.getElementById("tocken").value = data['access_token']; //토큰 할당
	        	
	        },
	        error: function(xhr, type){ 
		        console.log(xhr); 
		        console.log(type); 
			}
	    })
	
  }
	
	
	
//나의 정보 가져오기	
function selectMyInfoWithKakao() {
	
	var myTocken = document.getElementById("tocken").value
	
 	var param = {"tocken" : myTocken}
	
	 	$.ajax({
			url  : '/selectMyInfoWithKakao',
	        type : 'get',
	        data : param,
	        dataType : "JSON", 
	        contentType: "application/x-www-form-urlencoded;charset=utf-8", 
	        success : function(data){
	            
	        	console.log(data);
	        },
	        error: function(xhr, type){ 
		        console.log(xhr); 
		        console.log(type); 
			}
	    })
	
  }
	
</script>
    
</body>
</html>
