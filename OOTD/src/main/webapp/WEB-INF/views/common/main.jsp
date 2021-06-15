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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.15/jquery.bxslider.min.css" rel="stylesheet" /> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.15/jquery.bxslider.min.js"></script>

    <style>
        .bx-wrapper {
            -moz-box-shadow: none;
            -webkit-box-shadow: none;
            box-shadow: none;
            border: 0;
        }
    </style>
    
</head>
<body>
	<article>
		<div id="main_video">
	        <video  src="${pageContext.request.contextPath }/resources/images/main_video.mp4" muted="muted" autoplay="autoplay" loop=""></video>
	    </div>
        <div class="video_content">
            <div class="video_Brand">
                <p>Go to Brand Shop</p>
            </div>
    
            <div class="video_SHand">
                <p>Go to Second Hand</p>
            </div>
        </div>
    </article>

    <div class="product_slide">
        <div class="slide_wrapper">
            
            <ul class="bxslider">
                <li>slide 01</li>
                <li>slide 02</li>
                <li>slide 03</li>
                <li>slide 04</li>
                <li>slide 05</li>
                <li>slide 06</li>
                <li>slide 07</li>
                <li>slide 08</li>
                <li>slide 09</li>
                <li>slide 10</li>
            </ul>
            
        </div>
    </div>

   <script>
        $(function() {

            $('.bxslider').bxSlider({
                minSlides: 1,
                maxSlides: 5,
                moveSlides: 5,
                slideWidth: 300,
                slideMargin: 20,
                mode: 'horizontal',
                speed: 1500,
                pause: 5000,
                infiniteLoop: true,
                auto: true
            });
        });
        
        //브랜드 리스트로 화면이동
        $('.video_Brand').on('click', function() {
            var pType = 1;
			location.href="${pageContext.request.contextPath}/product/productList.do?pType="+pType;
        })

        //중고 리스트 화면이동
        $('.video_SHand').on('click', function() {
            var pType = 2;
			location.href="${pageContext.request.contextPath}/product/productList.do?pType="+pType;
        })
    </script>
    
</body>
</html>