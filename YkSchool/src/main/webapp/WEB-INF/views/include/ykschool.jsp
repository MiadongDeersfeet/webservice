<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
        div,
        header,
        main,
        footer,
        nav {

            box-sizing: border-box;
        }

     
        #wrap {
            width: 1400px;
            height: 1500px;
            margin: auto;

            display: flex;
            flex-direction: column;
        }

        body {
            background-color: #f7eeee;
        }

        main,
        footer {
            background-color: rgb(250, 239, 241);
        }

        main {
            background-image: url(resources/img/student.jpg);
            border-radius: 20px;
        }

        header {
            flex: 2;
            display: flex;
        }

        footer {
            flex: 2;
            display: flex;
        }

        main {
            flex: 6;
            display: flex;
        }

        nav {
            flex: 0.5;
            padding-left: 10%;
        }

        #header_1 {
            flex: 2;
        }

        #header_2 {
            flex: 6.5;
        }

        #header_3 {
            flex: 1.5;
        }

        #content_1 {
            flex: 1.5;
        }

        #content_2 {
            flex: 7;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        #content_3 {
            flex: 1.5;
        }

        /*#login-area {
            width: 300px;
            height: 300px;
            border-radius: 20px;
            box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.24);
            display: flex;
            flex-direction: column;
            justify-content: space-evenly;
            align-items: center;
        }*/

        #div1 {
            flex: 2;

            display: flex;
        }

        #yk_school {
            margin-top: 0%;
            margin-left: 15%;
            font-weight: 500;
            font-size: 22px;
            font-family: "Jua";
            margin-bottom: 0;
            
        }

        #lab {
             font-family: "Jua";
             
        }

        #first {
            font-family: "Jua";

        }

        #div2 {
            flex: 8;

            display: flex;
            flex-direction: column;
        }

        #div3 {
            flex: 3;


        }

        #div4 {
            flex: 7;
        }

        #contact_wrap {
            width: 220px;
            margin-top: 15%;
            margin-left: 10%;
            margin-bottom: 15%;



        }

        #call_center {
            padding-top: 10%;
            margin-left: 18%;
            margin-bottom: 0%;
        }

        #phone {
            margin-top: 0%;
            margin-left: 18%;
            font-size: 22px;
            font-weight: 700;
            margin-bottom: 0%;
        }

        #runtime {
            margin-top: 2%;
            margin-left: 18%;
            font-size: 11px;
        }

        #div3>a {
            text-decoration: none;
            color: rgb(65, 65, 65);
            margin-right: 20px;

            &:hover {
                font-weight: 700;
            }
        }




        #div4>p {
            font-size: 17px;
            font-weight: 700;
        }

        

        #div4 > span {
            font-size: 12px;
        }

        #top_btn {
            position: fixed;
            bottom: 20px;
            right: 20px;
        }

        #lab {
            padding-top: 50;
            text-align: center;
            font-weight: 700;
            font-size: 50px;
            margin-bottom: 0;
        }

        #first {
            margin-top: 0;
            text-align: center;
        }

        nav, ul, li {
          /*  border: 1px solid red; */
            box-sizing: border-box;
        }

        nav {
            width: 1400px;
            height: 40px;
            background-color: #f7eeee;
            
        }

#navbar {
            margin: 0;
            padding: 0;
            list-style: none;
            height: 100%;
            
        }

        #navbar > li {
            height: 100%;
            float: left;
            width: 16%;
            text-align: center;
        }

        #navbar a {
            text-decoration: none;
            color: #252424;
            font-weight: 800;
            width: 100%;
            height: 100%;
            display: block;
            line-height: 40px;
            position: relative; /*일단 내껀 얘네 안해도 문제없음
            transform: scale(1); */
            padding-left: 30%
        }
        
       
        
        /*평소에는 안보이다가 커서가 올라가면 펼쳐지게1*/
        #navbar > li > ul {
          list-style: none;
          padding: 0px;
          display: none;
          border: 1px solid salmon;
          border-radius: 15px;

        }

        /*평소에는 안보이다가 커서가 올라가면 펼쳐지게2*/
        #navbar > li > a:hover + ul {
            display:block;
        }

        /*평소에는 안보이다가 커서가 올라가면 펼쳐지게3*/
        #navbar > li > ul:hover {
            display:block;
        }

        #navbar a:hover {
            font-size: 17px;
        }

        #navbar > li > ul a {
            font-size: 11px;;
        }

        #navbar > li > ul a:hover {
            background: lemonchiffon;
            font-size: 14px;

        }

            div, form {
           /* border: 1px solid red; */
            box-sizing: border-box;
        }
        #header_2 {
            width: 650px;
            height: 160px;
            position: relative;
        }

        /*--------------요 밑에 있는 것만 나중에 들고 갈 예정---------------*/
        
        #header_2 {
            position: relative;
        }

        #search-form {
            width: 70%;
            height: 50%;
            position: absolute;
            top: 0px;
            bottom: 0px;
            left: 0px;
            right: 0px;
            margin: auto;
        }

        /* 검색창 form태그 내부 div 속성 */
        #search-form > div {
            height: 100%;
            float: left;
        }

        #search-text {
            width: 80%;
        }

        #search-btn {
            width: 20%;
        }
        
        /* input요소들 크기 늘리기 */
        #search-form input {
            width: 100%;
            height: 100%;
            box-sizing: border-box;
            border: 1px solid rgb(248, 171, 120);
            background-color: rgb(209, 153, 101);
            border-radius: 20px;
        }
        
        #search-form input:focus {
            outline: 4px dashed gold;
        }

        #search-form input[type="submit"] {
            color: rgb(230, 60, 88);
            padding-left: 25px;
            font-weight: 800;
            font-size: 15px;
            background-image: url(resources/img/camel.jpg);
            background-size: cover;
            &:hover {
                cursor: pointer;
            }
        }

        footer {
    width: 1400px;
    background-color: #f7eeee;

}

* {
    color: #252424;
}

    </style>
</head>
<body>
      <div id="wrap">
        <header>
            <div id="header_1"></div>
            <div id="header_2">
                <p id="lab">윤기스쿨LAB어학원</p>
                <p id="first">대한민국 최초 히브리어 어학원</p>

            </div>
            <div id="header_3"></div>
        </header>
        <nav>
            <ul id="navbar">
                <li><a href="#">히브리어LAB</a>
                    <ul>
                        <li><a href="#">설립이념</a></li>
                        <li><a href="#">학원장 인사말</a></li>
                        <li><a href="#">강사소개</a></li>
                        <li><a href="#">찾아오시는길</a></li>
                    </ul>
                </li>

                <li><a href="#">강의</a>
                    <ul>
                        <li><a href="#">온라인 수강신청</a></li>
                        <li><a href="#">무료 레벨테스트</a></li>
                    </ul>
                </li>

                <li><a href="#">커뮤니티</a>
                    <ul>
                        <li><a href="#">공지사항</a></li>
                        <li><a href="#">수강후기</a></li>
                        <li><a href="#">Q&A</a></li>
                        <li><a href="#">이벤트</a></li>
                    </ul>
                </li>
                
                <c:choose>
                <c:when test="${ empty sessionScope.userInfo }">
                <li class="nav-item">
			  <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#loginModal">로그인</a>
			</li>
			<li>
			<a href="<%= request.getContextPath() %>/signUp">회원가입</a>
			</li>
			</c:when>
			<c:otherwise>
                <li><a href="#">마이페이지</a>
                    <ul>
                        <li><a href="<%= request.getContextPath() %>/update">내정보수정</a></li>
                        <li><a href="#">나의강의실</a></li>
                        <li><a href="#">1:1문의사항</a></li>
                        <li><a href="#">결제내역</a></li>
                    </ul>
                </li>
					<li>
			<a href="#">로그아웃</a>
			</li>
			</c:otherwise>
                </c:choose>
			
		

            </ul>
        </nav>
        <br>
        <br>
        <br>
<!-- 로그인 Modal (BS5) -->
<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <h5 class="modal-title" id="loginModalLabel">
          <span style="color:#f7eeee;">YK</span> 로그인
        </h5>
        <!-- BS5는 btn-close + data-bs-dismiss -->
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>

      <div class="modal-body">
        <form action="login" name="sign-in" method="post" id="signInForm" style="margin-bottom:0;">
          <table style="margin:0 auto; width:100%;">
            <tbody>
              <tr>
                <td style="text-align:left">
                  <p><strong>아이디를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="idCheck"></span></p>
                </td>
              </tr>
              <tr>
                <td>
                  <input type="text" name="studentId" id="signInId" class="form-control" maxlength="15" patter="^[a-z][a-z0-9]{1,15}$" title="아이디는 소문자 영문으로 시작, 소문자+숫자 조합 가능, 15자 이내" required
                         style="margin-bottom:25px; width:100%; height:40px; border:1px solid #d9d9de"
                         placeholder="최대 15자">
                </td>
              </tr>
              <tr>
                <td style="text-align:left">
                  <p><strong>비밀번호를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwCheck"></span></p>
                </td>
              </tr>
              <tr>
                <td>
                  <input type="password" maxlength="20" id="signInPw" name="studentPwd" class="form-control" patter="^(?:[a-z]{1,8}|\d{1,8}|[a-z\d]{1,8})$" title="비밀번호는 영문(소)만 8자 이내 또는 숫자만 8자 이내 또는 영문(소)+숫자 8자 이내입니다." required
                         style="margin-bottom:25px; height:40px; border:1px solid #d9d9de" placeholder="최소 8자">
                </td>
              </tr>
              <tr>
                <td style="padding-top:10px; text-align:center">
                  <p><strong>로그인 후 다양한 서비스를 이용할 수 있습니다.</strong></p>
                </td>
              </tr>
              <tr>
                <td style="width:100%; text-align:center;">
                  <input type="submit" value="로그인" class="btn form-control"
                         style="background-color:#f7eeee; margin-top:0; height:40px; color:#black; border:0; opacity:.8">
                </td>
              </tr>
            </tbody>
          </table>
        </form>
      </div>

    </div>
  </div>
</div>

<!-- 로그인 실패 모달 -->
<div class="modal fade" id="loginFailModal" tabindex="-1" aria-labelledby="loginFailLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <h5 class="modal-title" id="loginFailLabel">로그인 실패</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="닫기"></button>
      </div>

      <div class="modal-body">
        아이디 또는 비밀번호가 올바르지 않습니다.
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>

    </div>
  </div>
</div>
        
        <main>
            <div id="content_1"></div>
            <div id="content_2">

            </div>
            <div id="content_3"></div>
        </main>
        <footer>
            <div id="div1">

                <div id="contact_wrap">
                    <p id="yk_school">윤기스쿨LAB어학원</p>
                    <p id="call_center">고객센터</p>
                    <p id="phone">02-2514-1104</p>
                    <p id="runtime">평일 : 07시 ~ 21시<br>
                        토요일 : 09시 ~ 16시<br>
                        (일요일/공휴일 휴무)</p>
                </div>
            </div>
            <div id="div2">
                <div id="div3">
                    <a href="#">회사소개</a>
                    <a href="#">단체수강</a>
                    <a href="#">제휴안내</a>
                    <a href="#">채용정보</a>
                    <a href="#">강사채용</a>
                    <a href="#">기업특강</a>
                    <a href="#">이용약관</a>
                    <a href="#">개인정보처리방침</a>


                </div>
                <div id="div4">
                    <p>㈜윤기스쿨</p>

                    <b>기업체 교육 컨설팅 및 출강 </b>
                    <span>02-2514-0924</span>
                    <b>FAX</b>
                    <span>02-316-2514</span>
                    <span>고객센터 : deersfeet@yunkischool.com</span>
                    <span> 마케팅/제휴문의 : marketer@yunkischool.com</span>
                    <span>제안 및 고객(사업)최고책임자 : ceo@yunkischool.com</span>
                    <span>사업자등록번호 : 316-39-27066</span>
                    <span>통신판매업신고번호 : 제2021-서울을지로-0400호 [정보조회]</span>
                    <span>학원등록번호: 제02202500045호</span>
                    <span>호스팅 제공자 : ㈜SKT</span>
                    <span>주소 : 서울 중구 남대문로 120 그레이츠청계 2층</span><br>
                    <span>대표 : 김윤기</span>
                    <span>개인정보보호책임자 : 김윤기</span>
                    <span>Copyright © 2025 AhabatYeshua Co.,Ltd. ALL RIGHTS RESERVED.</span>
                </div>


        </footer>
    </div>
    <a href="#header_1" id="top_btn">
        <img src="resources/낙타.jpg" alt="맨 위로" style="width:80px; height:40px;">
    </a>
    <!-- Bootstrap 5 JS (bundle) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
<% if(request.getAttribute("loginFail") != null) { %>
    document.addEventListener("DOMContentLoaded", function() {
        var failModal = new bootstrap.Modal(document.getElementById("loginFailModal"));
        failModal.show();
    });
<% } %>
</script>
</body>
</html>