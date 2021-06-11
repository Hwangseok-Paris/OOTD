<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
    <title>brandDetail</title>
   
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous"> -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src='${pageContext.request.contextPath }/resources/asset/js/jquery.zoom.js'></script>
    <script src='${pageContext.request.contextPath }/resources/asset/js/jquery.Wheelzoom.js'></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/brandDetail.css" />
</head>
<body>
<h1>브랜드 상품 디테일  ( -- Header 영역 --)</h1><hr><br>
<section>
    <div class="product_detail">
        <div class="package" >
            <div id="insertArea" class="inputBox1" style="margin-left: 20%;">
                <div id="contentImgArea1" class="imgInput">
                    <img src="../resources/images/brand sample1.png" 
                        id="contentImg1" style="height: 150px; width: 120px;"/>
                </div>
                <div id="contentImgArea2" class="imgInput">
                    <img src="../resources/images/brand sample2.png" 
                        id="contentImg2" style="height: 150px; width: 120px;"/>
                </div>
                <div id="contentImgArea3" class="imgInput">
                    <img src="../resources/images/brand sample3.png" 
                        id="contentImg3" style="height: 150px; width: 120px;"/>
                </div>
                <div id="contentImgArea4" class="imgInput">
                    <img src="../resources/images/brand sample4.png" 
                        id="contentImg4" style="height: 150px; width: 120px;"/>
                </div>
            </div>

           
        
            <div id="imgDetail" class="inputBox2">
                <div class='inputBox2 zoom' id='ex1'>
                    <img src='../resources/images/brand sample1.png' id='jack' width='540' height='620' alt='Daisy on the Ohoopee'/>
                    
                </div>
            </div>
        
        
        
        

            
        </div>
        <div class="package">
            <div id="prTextInput" class="inputBox3">
                <span><b>COCO</b></span> <br>
                
                <h4 id="pName">Special Premium Jacket</h4>
                <span style="margin-left: 240px;" >￦</span><span id="ppPrice">398000</span> <br><hr>
                

                <dl>
                    <dt class="drop"><b>Product Detail</b> 
                        <span class="accIcon" style="margin-left: 167px;"> 
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
                                <path d="M8 0a1 1 0 0 1 1 1v6h6a1 1 0 1 1 0 2H9v6a1 1 0 1 1-2 0V9H1a1 1 0 0 1 0-2h6V1a1 1 0 0 1 1-1z"/>
                            </svg>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-lg" viewBox="0 0 16 16">
                                <path d="M0 8a1 1 0 0 1 1-1h14a1 1 0 1 1 0 2H1a1 1 0 0 1-1-1z"/>
                            </svg>
                        </span>
                    </dt> 
                    <dd class="ddd"><span class="pInfoText">
                        <br>- 겉감 코튼 100% / 안감 폴리에스터 100% <br>
                        - 루즈 핏 <br>
                        - 카멜 컬러 <br>
                        - 라운드 잠금 디테일 <br>
                        - 라운드 포켓 <br>
                        - 밑단 히든 스트링 <br>
                        - 밑단 밴딩 처리 <br>
                        - 뒤판 절개 디테일 <br>
                        - 로고 각인 소뿔 단추 <br>
                    </span> <br></dd>
                    <hr>
                    <dt class="drop"><b>Size, Color</b> 
                        <span class="accIcon" style="margin-left: 190px;">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
                                <path d="M8 0a1 1 0 0 1 1 1v6h6a1 1 0 1 1 0 2H9v6a1 1 0 1 1-2 0V9H1a1 1 0 0 1 0-2h6V1a1 1 0 0 1 1-1z"/>
                            </svg>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-lg" viewBox="0 0 16 16">
                                <path d="M0 8a1 1 0 0 1 1-1h14a1 1 0 1 1 0 2H1a1 1 0 0 1-1-1z"/>
                            </svg>
                        </span>
                    </dt>
                    <dd class="ddd"><span class="pInfoText">
                        <br>- S 어깨 52.5cm 가슴 62cm <br>
                        - Color : Black, Brown <br>    
                    </span> <br></dd>
                    <hr>
                    <dt>
                        <b>Select Size</b>
                        <select name="" id="selectSize" style="width: 130px;">
                            <option value="">선택안함</option>
                            <option value="S">S</option>
                            <option value="M">M</option>
                            <option value="L">L</option>
                        </select> <br>
                    </dt><hr>
                    <dt class="pOrigin">
                        <div id="origin">
                            <span>Special Premium Jacket <b class="selectedSize"></b> </span> 
                            <input type="number" id="pQuan" name="pQuan" value="1" min="1"> <!-- input value 값 ??  -->
                            <img src="../resources/images/xx.png" alt="" style="width: 15px; height: 15px; margin-right: 5px;" id="pDelete">
                            <span>￦</span><span class="pPrice">398000</span>
                        </div>
                    </dt>
                    <dt class="pResult">
                    </dt>

                    <dt>
                        <div>   
                            <b>Total :</b> <span id="won">0</span> <span class="totalPD"></span> <span id="totalQ"></span>
                        </div>
                    </dt>
                </dl>

            

                <button id="btn" onclick="goCart();">add to cart</button>
                <button id="btn" onclick="goBuy();">buy now</button>
            </div>
        </div>
    </div>

    <div class="review_list" style="clear:both;">
        <br><br><br><hr>

        <div style="margin-bottom: 15px;">
        <span class="underMenu" style="margin-bottom: 50px;">REVIEW</span><span class="underMenu" style="margin-bottom: 50px;">FAQ</span>
        </div>
        <table class="table table-hover">
            <tr>
                <th>
                    번호
                </th>
                <th>
                    제목
                </th>
                <th>
                    작성자
                </th>
                <th>
                    작성일
                </th>
                <th>
                    조회수
                </th>
            </tr>
            <tr>
                <td>
                    1
                </td>
                <td>
                    최고입니다~
                </td>
                <td>
                    슈퍼캡숑코코
                </td>
                <td>
                    2021/06/09
                </td>
                <td>
                    149
                </td>
            </tr>
            <tr>
                <td>
                    2
                </td>
                <td>
                    최악입니다~
                </td>
                <td>
                    슈퍼코코
                </td>
                <td>
                    2021/06/09
                </td>
                <td>
                    12
                </td>
            </tr>
            <tr>
                <td>
                    3
                </td>
                <td>
                    좋습니다~
                </td>
                <td>
                    코코
                </td>
                <td>
                    2021/06/09
                </td>
                <td>
                    3
                </td>
            </tr>
            


        </table>
        <hr>
        <!-- 우선 틀만 잡아놓음 -->
        <div class="text-center">
            <ul class="pagination">
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
            </ul>
        </div>



    </div>

</section>


    

        
<script>

        $(document).ready(function(){
            $('#ex1').zoom();
            $('#ex2').zoom({ on:'grab' });
            $('#ex3').zoom({ on:'click' });
            $('#ex4').zoom({ on:'toggle' });
            $('#ex5').wheelzoom();
            $('#ex5').wheelzoom({zoom:0.05});
            $('#ex5').trigger('wheelzoom.reset')
        });
    



    



    
        // function goCart() {

        // }

        // function goBuy() {

        // }
        
        // $(function() {
        //     if($('.totalPD').text()== "") {
        //         console.log("totalPD::" + $('.totalPD').text())
        //         $('#won').text('0')
        //     }
        // });
        
        $('#pDelete').on('click', function() {
            $(this).parent().remove()
        });
            

        $('#pQuan').on('change', function() {
            var uuu = $(this).val()
            
            // var ggg = $('#ppPrice').text().str.substring(indexStart[2, indexEnd])
            // var ggg = $('#ppPrice').text()
            // console.log(uuu);
            // console.log(ggg);
            // console.log(uuu*hhh);
            $(this).siblings('.pPrice').text(thousandComma(uuu*hhh));
            totalCalc();
        });

        var hhh;

        $(function() {
            hhh = $('#ppPrice').text();
            // console.log(hhh);

            $('#ppPrice').text(thousandComma($('#ppPrice').text()));

            if($("#pQuan").val() < 1) alert("최소 주문수량은 1개 입니다.");
        });



        $('.pOrigin').hide();
        // $('.pResult').hide();
        
        $('#selectSize').on('change', function() {

            $('.pResult').show();

            if($('.frmSize.'+$('#selectSize').val()).length == 0){
                var result = $('#origin').clone(true);

                result.removeClass('#origin');
                result.addClass($('#selectSize').val());
                result.addClass('frmSize');
                result.find('.selectedSize').text("[" + $('#selectSize').val() + "]");
                
                $('.pResult').append(result);

                $('.pPrice').each(function(){
                    $(this).text(thousandComma($(this).text()));
                });
            } else {
                var quan = $('.frmSize.'+$('#selectSize').val()).find('[name=pQuan]');
                quan.val(parseInt(quan.val()) + 1);
                var priceTag = quan.siblings('.pPrice');
                priceTag.text(thousandComma(parseInt((priceTag.text()).replace(',','')) * quan.val()));


            }
            totalCalc();

            $('#won').text('￦')

            // $('.pResult').$('#selectedSize').text($('#selectSize').val())

        })

        
        
       function totalCalc(){
            var totalPrice = 0;
            // console.log("totalPrice before :: " + totalPrice);
            
            $('.pResult .pPrice').each(function(){
                // console.log("parse : "+$(this).text());
                // console.log("count = " + Number(($(this).text()).replace(/,/gm,'')))
                totalPrice += Number(($(this).text()).replace(/,/gm,''));
            })
            
            // var totalQuan = 0;
            // $('.pResult #pQuan').each(function() {
            //     totalQuan += Number($('#pQuan').val())
            //     $('#totalQ').text("(" + totalQuan + "개)")
            // })



            $('.totalPD').text(thousandComma(totalPrice));
            // console.log("totalPrice after :: " + totalPrice);
       }
        

        function thousandComma(x){
            return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        }



        $('.drop').on('click', function () {

            // 숨긴 영역 slide down
            $(this).next('.ddd').slideToggle(300);

            // +, - 아이콘 바꾸기
            var plus = $(this).children('span').children('.bi-plus-lg');
            var dash = $(this).children('span').children('.bi-dash-lg');

            if ( dash.css('display') == 'none' ) {
                dash.css('display', 'inline-block');
                plus.css('display', 'none');
            } else {
                plus.css('display', 'inline-block');
                dash.css('display', 'none');
            }

            // if ($(this).hasClass('on')) {
            //     slideUp();
            // } else {
            //     slideUp();
            //     $(this).addClass('on').next().slideDown();
            // }
            // function slideUp() {
            //     $('.drop').removeClass('on').next().slideUp();
            // };
        })


        $('#contentImgArea1').on('click', function() { 
			$('#imgDetail').children().children().attr('src', $('#contentImg1').attr('src'));
		});
		
		$('#contentImgArea2').on('click', function() {
			$('#imgDetail').children().children().attr('src', $('#contentImg2').attr('src'));
		});
		
		$('#contentImgArea3').on('click', function() {
			$('#imgDetail').children().children().attr('src', $('#contentImg3').attr('src'));
		});
		
		$('#contentImgArea4').on('click', function() {
			$('#imgDetail').children().children().attr('src', $('#contentImg4').attr('src'));
		});







    </script>
    <br><br><br><br><br><br><br><br><br><br>
</body>
</html>