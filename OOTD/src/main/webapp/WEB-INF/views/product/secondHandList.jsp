<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고리스트</title>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/productList.css">
</head>

<body>

	<c:import url="../common/header.jsp"/>
	
	
    <div class="container">
        <!-- 스토어 이름영역 -->
        <header class="list-title">
            <h2 align="center">SECOND HAND STORE</h2>
        </header>

        <!-- 카테고리 사이드바 -->
        <nav class="side-bar">
            <!-- 카테고리 -->
            <div id="category">
                <ul class="category">
                    <!-- 상품별 -->
                    <li id="prod-li">
                        <div class="showArea">
                            <b class="accordionTitle">PRODUCT</b>
                            &nbsp;&nbsp;
                            <!-- 아이콘 -->
                            <span class="accIcon">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
                                    <path d="M8 0a1 1 0 0 1 1 1v6h6a1 1 0 1 1 0 2H9v6a1 1 0 1 1-2 0V9H1a1 1 0 0 1 0-2h6V1a1 1 0 0 1 1-1z"/>
                                </svg>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-lg" viewBox="0 0 16 16">
                                    <path d="M0 8a1 1 0 0 1 1-1h14a1 1 0 1 1 0 2H1a1 1 0 0 1-1-1z"/>
                                </svg>
                            </span>
                        </div>
                        
                        
                        <!-- 보여줄 영역 -->
                        <div class="dropArea">
                            <ul class="hiddenArea">
                                <li class="prod cate">Top</li>
                                <li class="prod cate">bottom</li>
                                <li class="prod cate">Shoes</li>
                                <li class="prod cate">Hat</li>
                                <li class="prod cate">Bag</li>
                            </ul>
                        </div> 
                    </li>
                </ul>
            </div>
        </nav>


        

        <section class="main-wrapper">
            <!-- 필터 정렬 영역 -->
            <div class="filter-div">
                <span class="filter-text">최신순</span>
                <span class="filter-text">낮은 가격순</span>
                <span class="filter-text">높은 가격순</span>
                <span class="filter-text" id="prod-regis">상품등록</span>
            </div>
            <div class="content-wrapper">
                <!-- 상품 list -->
                <div class="product-list">
                <ul>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <!-- thumbnail image -->
                            <img src="https://heights-store.com/web/product/big/202105/4d853a41a69f4fb834d22631fbcadaa0.jpg" alt="">
                            <!-- hover 시 상품 정보 -->
                            <span class="thumbnail-info">
                                <b>Know Wave</b> 
                                <p>
                                    Multi Check Half N Half Jacket - Navy/Brown Big Check <br><br>
                                    256,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <img src="https://heights-store.com/web/product/big/202105/aaf50b824edbf9671555d2c68654c0ab.jpg" alt="">
                            <span class="thumbnail-info">
                                <b>Know Wave</b>
                                <p>
                                    Leopard Hood Jacket - Brown <br><br>
                                    215,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <img src="https://heights-store.com/web/product/big/202105/4d853a41a69f4fb834d22631fbcadaa0.jpg" alt="">
                            <span class="thumbnail-info">
                                <b>Know Wave</b>
                                <p>
                                    Multi Check Half N Half Jacket - Navy/Brown Big Check <br><br>
                                    256,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <img src="https://heights-store.com/web/product/big/202105/aaf50b824edbf9671555d2c68654c0ab.jpg" alt="">
                            <span class="thumbnail-info">
                                <b>Know Wave</b>
                                <p>
                                    Leopard Hood Jacket - Brown <br><br>
                                    215,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                </ul>
                <ul>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <img src="https://heights-store.com/web/product/big/202105/aaf50b824edbf9671555d2c68654c0ab.jpg" alt="">
                            <span class="thumbnail-info">
                                <b>Know Wave</b>
                                <p>
                                    Multi Check Half N Half Jacket - Navy/Brown Big Check<br><br>
                                    256,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <img src="https://heights-store.com/web/product/big/202105/4d853a41a69f4fb834d22631fbcadaa0.jpg" alt="">
                            <span class="thumbnail-info">
                                <b>Know Wave</b>
                                <p>
                                    Leopard Hood Jacket - Brown<br><br>
                                    215,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <img src="https://heights-store.com/web/product/big/202105/aaf50b824edbf9671555d2c68654c0ab.jpg" alt="">
                            <span class="thumbnail-info">
                                <b>Know Wave</b>
                                <p>
                                    Multi Check Half N Half Jacket - Navy/Brown Big Check<br><br>
                                    256,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <img src="https://heights-store.com/web/product/big/202105/4d853a41a69f4fb834d22631fbcadaa0.jpg" alt="">
                            <span class="thumbnail-info">
                                <b>Know Wave</b>
                                <p>
                                    Leopard Hood Jacket - Brown<br><br>
                                    215,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                </ul>
                <ul>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <img src="https://heights-store.com/web/product/big/202105/4d853a41a69f4fb834d22631fbcadaa0.jpg" alt="">
                            <span class="thumbnail-info">
                                <b>Know Wave</b>
                                <p>
                                    Multi Check Half N Half Jacket - Navy/Brown Big Check<br><br>
                                    256,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <img src="https://heights-store.com/web/product/big/202105/aaf50b824edbf9671555d2c68654c0ab.jpg" alt="">
                            <span class="thumbnail-info">
                                <b>Know Wave</b>
                                <p>
                                    Leopard Hood Jacket - Brown<br><br>
                                    215,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <img src="https://heights-store.com/web/product/big/202105/4d853a41a69f4fb834d22631fbcadaa0.jpg" alt="">
                            <span class="thumbnail-info">
                                <b>Know Wave</b>
                                <p>
                                    Multi Check Half N Half Jacket - Navy/Brown Big Check<br><br>
                                    256,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                    <li class="thumbnail-list">
                        <div class="thumbnail-area">
                            <img src="https://heights-store.com/web/product/big/202105/aaf50b824edbf9671555d2c68654c0ab.jpg" alt="">
                            <span class="thumbnail-info">
                                <b>Know Wave</b>
                                <p>
                                    Leopard Hood Jacket - Brown<br><br>
                                    215,000 원
                                </p>
                            </span>
                        </div>
                    </li>
                </ul>
            </div>

            <!-- 페이지네이션 (임시) -->
            <div class="pagination">
                <a href="#">&laquo;</a>
                <a href="#">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
                <a href="#">6</a>
                <a href="#">&raquo;</a>
              </div>
            </div>
            
        </section>
        
                <!-- top 버튼 -->
	        <aside>
	            <div id="topBtn" href="#">TOP</div>
	        </aside>
    </div>
	
    <!-- FOOTER IMPORT -->
   	<%@ include file="../common/footer.jsp" %>
   	
	
    <script>
        // Dropdown 
        $('.showArea').on('click', function() {
            // 숨긴 영역 slide down
            $(this).next('.dropArea').slideToggle(300);

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
        });

        // hover 시 상품정보 보여주기
        $('.thumbnail-area').on({
                'mouseenter' : function() {
                    $(this).children('span').css('display', 'block');
                }, 
                'mouseleave' : function() {
                    $(this).children('span').css('display', 'none');
                }
        });

        // filter 클릭 시 밑줄 표기하기
        $('.filter-text').on('click', function() {
            $(this).css('border-bottom', 'solid 2px gray');
            $(this).siblings().css('border-bottom', '');
        });

        // top 버튼
        $(function() {
        $("#topBtn").click(function() {
            $('html, body').animate({
                scrollTop : 0
            }, 400);
            return false;
        });
    });
        
    $('#toggleTheme').on('click', function() {
        $('html').toggleClass("dark");
    });

    $(function() {
        console.log(localStorage.getItem('darkMode'));
        $('html').attr('class', localStorage.getItem('darkMode'));
    });
        

    </script>
</body>
</html>