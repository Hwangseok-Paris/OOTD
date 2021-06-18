<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

    <%-- <script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script> --%>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
    <!-- css 링크 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/loginModal.css" />

    <div class="container">
       
       <c:if test="${ !empty member }">
       
       <!-- 내 정보 Modal -->
       <div class="modal modal-center fade" id="loginModal" role="dialog" data-backdrop="static" data-keyboard="false">
          <div class="modal-dialog"> 
          
            <!-- Modal 컨텐츠 시작 -->
            <div class="modal-content">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                
                <c:if test="${ member.login_type == 1 }">
                <h4 id="modal-title">${ member.brand_name }</h4> 
                </c:if>
                
                <c:if test="${ member.login_type == 2 }">
                <h4 id="modal-title">${ member.member_name }</h4> 
                </c:if>
                
                <!-- Modal 내 ID/PW 입력 및 로그인/ 가입 버튼 시작 -->
                <div class="modal-body" style="padding:40px 50px;">
                    <div class="join-btn-group">
                        <button type="button" id="join-btn" class="btn btn-link" onclick="goMyPage()">MYPAGE</button>
                            | 
                    	<button type="button" id="login-btn" class="btn btn-link" onclick="logout()">LOGOUT</button>
                    	
                    </div>
                </div> 
                <!-- 내 정보 모달 끝 -->

            </div> 
            <!-- Modal 컨텐츠 끝 -->

         </div>
        </div> 
       
       </c:if>
       
      <c:if test="${ empty member }">
        <!-- 로그인 Modal -->
        <div class="modal modal-center fade" id="loginModal" role="dialog" data-backdrop="static" data-keyboard="false">
          <div class="modal-dialog">
          
            <!-- Modal 컨텐츠 시작 -->
            <div class="modal-content">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 id="modal-title">LOGIN</h4>
                
                <!-- Modal 내 ID/PW 입력 및 로그인/ 가입 버튼 시작 -->
                <div class="modal-body" style="padding:40px 50px;">
                    <form role="form" action="member/memberLogin.do" method="post">
                        <div class="form-group">
                            <label for="usrname"> ID</label>
                            <input type="text" class="form-control" id="member_id" name="member_id" placeholder="Enter ID">
                        </div>
                        <div class="form-group">
                            <label for="psw"> Password</label>
                            <input type="password" class="form-control" id="member_pw" name="member_pw"placeholder="Enter password">
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" value="" checked>Remember me</label>
                        </div>

                        <div class="join-btn-group">
                            <button type="button" id="join-btn" class="btn btn-link" onclick="goJoinPage()">JOIN</button>
                            |
                            <button type="submit" id="login-btn" class="btn btn-link">LOGIN</button>
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
        
        </c:if>
        
      </div>

      <!-- 아이디 찾기 Modal -->
      <div class="modal modal-center fade" id="findIdModal" role="dialog">
        <div class="modal-dialog">
      
            <!-- Modal content-->
            <div class="modal-content">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3>아이디 찾기</h3>

                <div class="modal-body" style="padding:40px 50px;">
                    <form role="form" action="member/sendIdMail.do" method="post">
                    	
                    	<label for="brand" style="margin-top:5%">
                    		<input type="checkbox" name="login_type" value="1" checked="true">업체 &nbsp;
                    	</label>
            			<input type="checkbox" name="login_type" value="2">개인
                    	<br /><br />
                        <label for="username">이름 / 브랜드 이름</label>
                        <div class="input-group">
                            <input type="text" name="member_name" class="form-control" id="usrname" placeholder="Enter name">
                        </div>

                        <label for="psw" style="margin-top:5%">이메일</label>
                        <div class="input-group">
                            <input type="text" name="email" class="form-control" id="psw" placeholder="Enter phone number">
                        </div>
                        <button type="submit" class="btn btn-secondary btn-lg btn-block" style="margin-top: 25%;">아이디 찾기</button>
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
                    <form role="form" action="member/sendPwMail.do" method="post">
                    	
                    	
                    	<label for="brand" style="margin-top:5%">
                    		<input type="checkbox" name="login_type" value="1" checked="true">업체 &nbsp;
                    	</label>
            			<input type="checkbox" name="login_type" value="2">개인
                    	<br /><br />
                        
                        <label for="username">아이디</label>
                        <div class="input-group">
                            <input type="text" name="member_id" class="form-control" id="usrname" placeholder="Enter ID">
                        </div>

                        <label for="username" style="margin-top:5%">이름 / 브랜드 이름</label>
                        <div class="input-group">
                            <input type="text" name="member_name" class="form-control" id="usrname" placeholder="Enter name">
                        </div>

                        <label for="psw" style="margin-top:5%">이메일</label>
                        <div class="input-group">
                            <input type="text" name="email" class="form-control" id="psw" placeholder="Enter phone number">
                        </div>
                        <button type="submit" class="btn btn-secondary btn-lg btn-block" style="margin-top: 10%;">비밀번호 찾기</button>
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
        	location.href='${pageContext.request.contextPath}/member/joinAccept.do';
        }
        
        function goMyPage() {
        	location.href="${pageContext.request.contextPath}/member/goMyPage.do"
        }
        
        function logout() {
        	location.href="${pageContext.request.contextPath}/member/logout.do"
        }

        
        /* componentDidMount() {
        	Kakao.init('1da952139d172c0ac2c48f4a3ba9ca34');
        } */
        
        $(function() {
        	Kakao.init('1da952139d172c0ac2c48f4a3ba9ca34');
        });
        
        $('#kakao-box').on('click', function() {
        	try {
        		return new Promise(function(resolve, reject) {
        			if (!Kakao) {
        				reject('Kakao 인스턴스가 존재하지 않습니다.')
        			}
        			
        			Kakao.Auth.login({
        				success: function(auth) {
        					console.log('정상적으로 로그인', auth)
        					this.setState({
        						isLogin: true
        					});
        					
        				}, fail: function(error) {
        					console.log(error)
        				}
        			})
        		})
        	} catch (err) {
        		console.log(err)
        	}
        });
        
        
    </script>
