<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 페이지</title>

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Jua&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">

    <style>
        
        body {
            background-color: #f7eeee;
        }
        
        div,
        header,
        nav,
        main,
        footer {

        }
        
        header {
            flex: 1;
            display: flex;            
            justify-content: center; 
            align-items: center;
            font-weight: 500;
            font-size: 22px;
            font-family: "Jua";
        
        }

        p {
            text-align: center;
        }

  
        nav {
            flex: 0.5;
        }

        main {
            flex: 6;
        }
        
        legend {
          text-align: center;
          font-size: 30px;
          font-weight: 500;
          font-family: "Jua";
        }

        #content_1 {
            padding-top: 3%;
            height: 500px;
            text-align: center;
            font-size: 20px;
            
        }

        footer {
            flex: 1;
        }

        #wrap {
            width: 1000px;
            height: 800px;
            margin: auto;
            display: flex;
            flex-direction: column;
        }

        input {
            width: 200px;
            height: 30px;
        }

        :placeholder-shown {
            text-align: center;
        }

        #submitBtn {
            width: 70px;
            height: 30px;
        }

        #resetBtn {
            width: 70px;
            height: 30px;
        }

        #langSelect {
            margin-bottom: 0.5%;
        }
        
        #footer_1 {
            text-align: center;
        }
        
    </style>
</head>
<body>
    <div id="wrap">
        <header>
            <div id="header_1">
                <h1>윤기스쿨LAB어학원</h1>
                <p>어서와 처음이지~? ㅇ,.ㅇ</p>
            </div>
        </header>
        <nav>
        </nav>
        <main>
            <form action="login" method="post">
            <fieldset>
            <legend>회원가입 서비스</legend>    
        
            <div id="content_1">
             아이디<br>
            <input type="text" name="studentId" id="inputId" placeholder="영문과 숫자 조합 / 최대 10자"> <br>
            비밀번호<br>
            <input type="password" name="studentPwd" id="inputPwd" placeholder="영문+숫자+특수문자 / 최소 6자"> <br>
            이름<br>
            <input type="text" name="studentName" id="inputName" placeholder="필수기재"> <br>   
            연락처<br>
            <input type="text" name="phone" id="inputPhone" placeholder="010-XXXX-XXXX"> <br>  
            희망언어<br>
            <select name="lang" id="langSelect">
                <option>영어</option>
                <option>히브리어</option>
                <option>아랍어</option>
            </select>
            <br />
            <input id="submitBtn" type="submit" value="회원가입"></button>
            <input id="resetBtn" type="reset" value="초기화"></button>
            
            </fieldset>   
            </form>
        </main>

        <footer>
            <div id="footer_1">
            <span>Copyright © 2025 AhabatYeshua Co.,Ltd. ALL RIGHTS RESERVED.</span>
            </div>
        </footer>

    </div>
    
</body>
</html>