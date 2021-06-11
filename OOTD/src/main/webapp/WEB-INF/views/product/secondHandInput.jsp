<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>second-hand</title>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/secondHandInput.css" />
</head>
<body>
   <h1 style="text-align: center;">( -- Header 영역 -- )</h1>
<hr>
    <h1 style="text-align: center;">상품 등록( Second-hand )</h1>
<hr>
    <div class="package">
        <div id="insertArea" class="inputBox1" style="margin-left: 25%;">
            <div id="contentImgArea1" class="imgInput">
                <img src="../resources/images/imgInput.png" 
                    id="contentImg1" style="height: 150px; width: 120px;"/>
            </div>
            <div id="contentImgArea2" class="imgInput">
                <img src="../resources/images/imgInput.png" 
                    id="contentImg2" style="height: 150px; width: 120px;"/>
            </div>
            <div id="contentImgArea3" class="imgInput">
                <img src="../resources/images/imgInput.png" 
                    id="contentImg3" style="height: 150px; width: 120px;"/>
            </div>
            <div id="contentImgArea4" class="imgInput">
                <img src="../resources/images/imgInput.png" 
                    id="contentImg4" style="height: 150px; width: 120px;"/>
            </div>
        </div>

        <div id="imgDetail" class="inputBox2">
            <div id="imageDetail" class="imgInput">
                <img src="" alt="" style="height: 640px; width: 390px;">
            </div>
        </div>
    </div>
    <div class="package">
        <div class="fileArea" id="fileArea">
            <!--  첨부 사진 추가 영역 -->
            <!-- (input:file#thumbImg$[name=thumbImg$ onchange=loadImg(this,$)])*4  -->
            <input type="file" accept="image/*" name="thumbImg1" id="thumbImg1" onchange="loadImg(this, 1);" />
            <input type="file" accept="image/*" name="thumbImg2" id="thumbImg2" onchange="loadImg(this, 2);" />
            <input type="file" accept="image/*" name="thumbImg3" id="thumbImg3" onchange="loadImg(this, 3);" />
            <input type="file" accept="image/*" name="thumbImg4" id="thumbImg4" onchange="loadImg(this, 4);" />
        </div>

        <div id="prTextInput" class="inputBox3">
            <input type="text" id="productName" class="ininput" placeholder="상품명">
            <br>
            <input type="number" id="productPrice" class="ininput" placeholder="가격(숫자만 입력)">
            <br><hr>
            <h5>Product Detail</h5>
            <textarea id="productDetail" cols="32" rows="10" class="ininput">
브랜드 :
구매가 :
구매장소 : 
구입시기 : 
착용 횟수 :
상태 : 
특이사항 : 
상품 링크 : 
            </textarea>
            <br><hr>
            <h5>Size, Color</h5>
            <textarea id="productInfo" cols="32" rows="8" class="ininput" placeholder="실측사이즈, 색상정보"></textarea>
            <br><hr>
            <h5>Option & Stock</h5>
            <input type="text" id="size1" class="ininput" placeholder="사이즈 입력">
            <br><br>
            <button id="btn">등록하기</button>
            <br><br>
        </div>
    </div>






    <script>
        $('#contentImgArea1').on('click', function() { 
			$('#thumbImg1').click();
		});
		
		$('#contentImgArea2').on('click', function() {
			$('#thumbImg2').click();
		});
		
		$('#contentImgArea3').on('click', function() {
			$('#thumbImg3').click();
		});
		
		$('#contentImgArea4').on('click', function() {
			$('#thumbImg4').click();
		});
		
		$('#fileArea').hide();

        function loadImg(img, num) {
			if (img.files && img.files[0]) {

				var reader = new FileReader();

				reader.onload = function(e) {

					switch (num) {
					case 1: 
						$('#contentImg1').attr('src', e.target.result); 
						break;
					case 2:
						$('#contentImg2').attr('src', e.target.result);
						break;
					case 3:
						$('#contentImg3').attr('src', e.target.result);
						break;
					case 4:
						$('#contentImg4').attr('src', e.target.result);
						break;
					}
				}

				reader.readAsDataURL(img.files[0]);
			}
			

		}
    </script>
</body>
</html>