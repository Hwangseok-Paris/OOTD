<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>OOTD - 마이페이지(개인)</title>
    <script src="${pageContext.request.contextPath }/resources/asset/js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/myPage_Info.css">
</head>

<body>

	<!-- HEADER IMPORT -->
	<c:import url="../common/header.jsp"/>


    <div class="container-myPage">
        <div class="body-title">MY PAGE</div>
        
        <!-- 마이페이지 메뉴 (일반) -->
        <%@ include file="myPage_Menu.jsp" %> 
       
        <section class="main">
            <div class="wrap-section">
                <div class="table-title">회원 정보</div>
                <table class="member-info">
                    <tbody>
                        <tr class="id">
                            <td>아이디</td>
                            <td name="userID">${member.member_name }</td>
                            <td></td>
                            <td></td>
                        </tr>
                        
                        <tr class="password" style>
                            <td>비밀번호</td>
                            <td colspan="2">*********</td>
                            <td>
                                <button class="modify-btn" id="update-password">비밀번호 변경</button>
                            </td>
                        </tr>
                        
                        <tr class="update-password" style="display: none">
                            <td colspan="4">
                                <form action="${pageContext.request.contextPath}/myPage/update_Pwd.do" method="post">
                                    <div class='passowrd-update-area'>
                                        <div class="input">
                                            <label for="password">현재 비밀번호</label>
                                            <input type="password" name="password" id="password">
                                        </div>
                                        <div class="input">
                                            <label for="new-password">새 비밀번호</label>
                                            <input type="password" name="new_password" id="new-password">
                                        </div>
                                        <div class="input">
                                            <label for="new-password-confirm">새 비밀번호 확인</label>
                                            <input type="password" name="confirm_password" id="new-password-confirm">
                                        </div>
                                        <div class="btn-group">
                                            <input type="submit" value="확인">
                                            <input type="reset" id="reset-password" value="취소">
                                        </div>
                                    </div>
                                </form>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>이름</td>
                            <td colspan="3">오오티디</td>
                        </tr>
                        
                        <tr class='email'>
                            <td>이메일</td>
                            <td colspan="2">paris@gmail.com</td>
                            <td>
                                <button type="submit" id="update-email" href="${pageContext.request.contextPath} }/myPage/update_Email.do">이메일 변경</button>
                            </td>
                        </tr>
                        
                        <tr class="update-email" style="display: none">

                            <td colspan="4">
                                <form action="">
                                    <div class='email-update-area'>
                                        <div class="input">
                                            <label for="email">변경 이메일 주소</label>
                                            <input type="email" name="email" id="email"
                                                placeholder="변경 이메일 주소 입력(example@ootd.com)">
                                        </div>

                                        <div class="btn-group">
                                            <input type="submit" value="확인">
                                            <input type="reset" id="reset-email" value="취소">
                                        </div>
                                    </div>
                                </form>
                            </td>
                        </tr>
                        
                        <tr class="phone">
                            <td>휴대전화</td>
                            <td colspan="2">010-8888-8888</td>
                            <td>
                                <button id="update-phone">휴대전화 변경</button>
                            </td>
                        </tr>
                        
                        <tr class="update-phone" style="display: none">
                            <td colspan="4">
                                <form action="">
                                    <div class='phone-update-area'>
                                        <div class="input">
                                            <label for="phone">휴대전화 번호</label>
                                            <input type="text" name="phone" id="phone"
                                                placeholder="휴대전화 번호 입력( ' - ' 포함)">
                                        </div>
                                        <div class="btn-group">
                                            <input type="submit" value="확인">
                                            <input type="reset" id="reset-phone" value="취소">
                                        </div>
                                    </div>
                                </form>
                            </td>
                        </tr>
                        
                        <tr class="account">
                            <td>계좌번호</td>
                            <td>신한은행</td>
                            <td>110-236-417886</td>
                            <td>
                                <button id="update-account">계좌번호 변경</button>
                            </td>
                        </tr>
                        
                        <tr class="update-account" style="display: none">

                            <td colspan="4">
                                <form action="" method="POST">
                                    <div class='account-update-area'>
                                        <div class="input">
                                            <label for="account">변경 계좌번호</label>

                                            <select class="select-bank">
                                                <option value="">국민은행</option>
                                                <option value="">신한은행</option>
                                                <option value="">농협</option>
                                                <option value="">우리은행</option>
                                            </select>


                                            <input type="text" name="account" id="account"
                                                placeholder="계좌번호 입력( ' - ' 포함)">

                                            <div class="btn-group">
                                                <input type="submit" value="확인">
                                                <input type="reset" id="reset-account" value="취소">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>

            </div>

        </section>
    </div>
    
    <!-- FOOTER IMPORT -->
   	<%@ include file="../common/footer.jsp" %>
   	


</body>
<script>
    $('#update-password').on('click', function () {
        $('.update-password').show()
        $('.password').hide()
    })

    $('#reset-password').on('click', function () {
        $('.update-password').hide()
        $('.password').show()
    })

    $('#update-email').on('click', function () {
        $('.update-email').show()
        $('.email').hide()
    })

    $('#reset-email').on('click', function () {
        $('.update-email').hide()
        $('.email').show()
    })

    $('#update-phone').on('click', function () {
        $('.update-phone').show()
        $('.phone').hide()
    })

    $('#reset-phone').on('click', function () {
        $('.update-phone').hide()
        $('.phone').show()
    })

    $('#update-account').on('click', function () {
        $('.update-account').show()
        $('.account').hide()
    })

    $('#reset-account').on('click', function () {
        $('.update-account').hide()
        $('.account').show()
    })


</script>

</html>