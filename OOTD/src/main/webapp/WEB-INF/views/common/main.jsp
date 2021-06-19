<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
	<script src="${pageContext.request.contextPath }/resources/asset/js/jquery-3.6.0.min.js"></script>
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
                <li><img class="img1" src="" alt="" /></li>
                <li><img class="img2" src="" alt="" /></li>
                <li><img class="img3" src="" alt="" /></li>
                <li><img class="img4" src="" alt="" /></li>
                <li><img class="img5" src="" alt="" /></li>
                <li><img class="img6" src="" alt="" /></li>
                <li><img class="img7" src="" alt="" /></li>
                <li><img class="img8" src="" alt="" /></li>
                <li><img class="img9" src="" alt="" /></li>
                <li><img class="img10" src="" alt="" /></li>
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
        
        $(function(){
        	$.ajax({
    			type: "POST",
    			url: "${pageContext.request.contextPath}/product/selectProductImages.do",
    			data: {}, 
				
    			success: function(data){
    				console.log(data);
    				console.log(data[0].att_name);
    				console.log("TOP 10 이미지 불러오기 성공!")
    				$('.bxslider>li>.img1').attr("src", "${pageContext.request.contextPath}/resources/images/productImgUpload/"+data[0].att_name);
    				$('.bxslider>li>.img2').attr("src", "${pageContext.request.contextPath}/resources/images/productImgUpload/"+data[1].att_name);
    				$('.bxslider>li>.img3').attr("src", "${pageContext.request.contextPath}/resources/images/productImgUpload/"+data[2].att_name);
    				$('.bxslider>li>.img4').attr("src", "${pageContext.request.contextPath}/resources/images/productImgUpload/"+data[3].att_name);
    				$('.bxslider>li>.img5').attr("src", "${pageContext.request.contextPath}/resources/images/productImgUpload/"+data[4].att_name);
    				$('.bxslider>li>.img6').attr("src", "${pageContext.request.contextPath}/resources/images/productImgUpload/"+data[5].att_name);
    				$('.bxslider>li>.img7').attr("src", "${pageContext.request.contextPath}/resources/images/productImgUpload/"+data[6].att_name);
    				$('.bxslider>li>.img8').attr("src", "${pageContext.request.contextPath}/resources/images/productImgUpload/"+data[7].att_name);
    				$('.bxslider>li>.img9').attr("src", "${pageContext.request.contextPath}/resources/images/productImgUpload/"+data[8].att_name);
    				$('.bxslider>li>.img10').attr("src", "${pageContext.request.contextPath}/resources/images/productImgUpload/"+data[9].att_name);
    			},
    			
    			error: function(){
    				alert('TOP 10 이미지 불러오기 실패!');
  					console.log("에러")
    			}
    			
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
    
