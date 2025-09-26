<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내정보변경 페이지</title>

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
                <p>주기적인 정보변경은 보안에 참 중요하죠~!ㅇ.ㅇb</p>
            </div>
        </header>
        <nav>
        </nav>
        <main>
            <form>
            <fieldset>
            <legend>내정보수정 서비스</legend>    
        
            <div id="content_1">
            
            비밀번호 변경<br>
            <input type="password" id="inputPwd" placeholder="15자 이내"> <br>
             
            연락처 변경<br>
            <input type="text" id="inputPhone" placeholder="010-XXXX-XXXX"> <br>  
            희망언어<br>
            <select id="langSelect" name="lang">
                <option>영어</option>
                <option>히브리어</option>
                <option>아랍어</option>
            </select>
            <br />
            <button id="submitBtn" type="submit">변경하기</button>
            <button id="resetBtn" type="reset">초기화</button>
            
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