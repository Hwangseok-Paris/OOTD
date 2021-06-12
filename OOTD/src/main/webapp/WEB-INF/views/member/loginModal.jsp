<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width" initial-scale=1.0>
    <title>LOGIN</title>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    
    <!-- css 링크 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/loginModal.css" />

</head>
<body>
    <div class="container">
       
        <!-- 로그인 Modal -->
        <div class="modal modal-center fade" id="loginModal" role="dialog" data-backdrop="static" data-keyboard="false">
          <div class="modal-dialog">
          
            <!-- Modal 컨텐츠 시작 -->
            <div class="modal-content">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 id="modal-title">LOGIN</h4>
                
                <!-- Modal 내 ID/PW 입력 및 로그인/ 가입 버튼 시작 -->
                <div class="modal-body" style="padding:40px 50px;">
                    <form role="form">
                        <div class="form-group">
                            <label for="usrname"> ID</label>
                            <input type="text" class="form-control" id="usrname" placeholder="Enter ID">
                        </div>
                        <div class="form-group">
                            <label for="psw"> Password</label>
                            <input type="text" class="form-control" id="psw" placeholder="Enter password">
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" value="" checked>Remember me</label>
                        </div>

                        <div class="join-btn-group">
                            <button type="button" id="join-btn" class="btn btn-link" onclick="goJoinPage()">JOIN</button>
                            |
                            <button type="button" id="login-btn" class="btn btn-link">LOGIN</button>
                        </div>
                    </form>
                </div>
                <!-- Modal 내 ID/PW 입력 및 로그인/ 가입 버튼 끝 -->
        

              <!-- 모달 내 메신저 ID 로그인 디자인 시작 -->
              <div id = "login-service">
                <div id="kakao-box">
                    <img id="icon-img" src="https://t1.daumcdn.net/cfile/tistory/992DA6415B743DB62B">
                    카카오톡으로 로그인
                </div>
                <div id="google-box">
                    <img id="icon-img" src="https://t1.daumcdn.net/cfile/tistory/99D8AF415B743DB636">
                    구글로 로그인
                </div>
                <div id="facebook-box">
                    <img id="icon-img" src="https://t1.daumcdn.net/cfile/tistory/9922CF415B743DB62D">
                    페이스북으로 로그인
                </div>
                <div id="line-box">
                    <img id="icon-img" src="https://t1.daumcdn.net/cfile/tistory/992972415B743DB708">
                    네이버로 로그인
                </div>
            </div>
            <!-- 메신저 ID 로그인 디자인 끝 -->

            <!-- modal의 footer 시작 -->
            <div class="modal-footer">
                <div class="modal-footer-child">
                    Forgot<button type="button" id="forgot-id" class="btn btn-link" data-toggle="modal" data-target="#findIdModal">ID?</button>
                    Forgot<button type="button" id="forgot-pw" class="btn btn-link" data-toggle="modal" data-target="#findPwModal">Password?</button>
                </div>
            </div>
            <!-- modal의 footer 끝 -->

            </div>
            <!-- Modal 컨텐츠 끝 -->

          </div>
        </div> 
      </div>

      <!-- 아이디 찾기 Modal -->
      <div class="modal modal-center fade" id="findIdModal" role="dialog">
        <div class="modal-dialog">
      
            <!-- Modal content-->
            <div class="modal-content">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3>아이디 찾기</h3>

                <div class="modal-body" style="padding:40px 50px;">
                    <form role="form">
                        <label for="username"></span>이름</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="usrname" placeholder="Enter name">
                        </div>

                        <label for="psw" style="margin-top:5%"></span>전화번호</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="psw" placeholder="Enter phone number">
                            <span class="input-group-append"><button type="button" class="btn btn-dark">본인 인증</button></span>
                        </div>
                        <button type="button" class="btn btn-secondary btn-lg btn-block" style="margin-top: 25%;">아이디 찾기</button>
                    </form>
                </div>
            </div>
        </div>
    </div> 

      <!-- 비밀번호 찾기 Modal -->
      <div class="modal modal-center fade" id="findPwModal" role="dialog">
        <div class="modal-dialog">
      
            <!-- Modal content-->
            <div class="modal-content">

                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3>비밀번호 찾기</h3>

                <div class="modal-body" style="padding:40px 50px;">
                    <form role="form">
                        <label for="username"></span>아이디</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="usrname" placeholder="Enter ID">
                        </div>

                        <label for="username" style="margin-top:5%"></span>이름</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="usrname" placeholder="Enter name">
                        </div>

                        <label for="psw" style="margin-top:5%"></span>전화번호</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="psw" placeholder="Enter phone number">
                            <span class="input-group-append"><button type="button" class="btn btn-dark">본인 인증</button></span>
                        </div>
                        <button type="button" class="btn btn-secondary btn-lg btn-block" style="margin-top: 10%;">비밀번호 찾기</button>
                    </form>
                </div>
            </div>
        </div>
    </div> 
    <script>
        /* 버튼 클릭 시, 모달 pop-up */
        $("#loginBtn").click(function(){
                $("#loginModal").modal();
          });
      

        /* 모달 밖의 영역 클릭 시, 모달이 닫히는 것을 방지 */
   		//   $('#loginModal').modal({backdrop: 'static', keyboard: false}) ;

        /* 모달 내 JOIN 버튼 클릭 시, 회원가입 페이지로 이동 */
        function goJoinPage() {
            location.href="memberJoin.html";
        }
    </script>
</body>
</html>