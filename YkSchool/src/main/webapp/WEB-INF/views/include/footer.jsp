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