<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        html,
        body {
            width: 100%;
            height: 100%;
        }

        body {
            background: -webkit-gradient(linear, 0 0, left bottom, from(rgb(255, 0, 46)), to(rgb(12, 23, 45)));
        }

        li {
            list-style: none;

            text-align: right;
        }

        #io,
        input[type="text"],input[type="password"] {
            width: 200px;
        }

        #io {
            display: inline-block;
            /* width: 100px; */
            text-align: center;
        }

        .ll {
            position: relative;
        }

        .halfdown,
        .halftop {
            position: relative;
        }
        html,body
        {
        width:100%;
        height:100%;
        overflow:hidden;
        }

        .halftop {

            width: 0;
            border-bottom: 200px solid rgb(100, 56, 89);
            border-left: 200px solid transparent;
            border-right: 200px solid transparent;
            box-sizing: border-box;
        }

        .halfdown {
        opacity:0.6;
            width: 0;
            border-top: 200px solid rgb(100, 56, 89);
            border-left: 200px solid transparent;
            border-right: 200px solid transparent;
            box-sizing: border-box;
        }



        .outer {
            position: relative;
            width: 400px;
            margin: auto;
        }

        .lr {
            top: -25px;
            position: relative;
            width: 309px;
            height: 200px;
            float: left;
            z-index: 10;
        }
        .what
        {
      	border-radius:20%;
        opacity:0;
        background-image:url('pt/chess.gif');background-size:cover;
        }
    
    </style>
    <script src="js/move.js"></script>
</head>

<body>

    <div class="outer">
        <div class="halftop"></div>
       
        <form action="Check_login" class="lr">
            <ul>
                <li><span>用户名</span><input type="text" name="username" id=""></li>
                <li><span>密码</span><input type="password" name="password" id=""></li>
                <li><span id="io"><input type="button" name="" id="" value="登录" class="ll"></span></li>
            	<li><span><a href="Register.jsp" target="_self">注册账户</a></span></li>
            </ul>
        </form>
         <div class="lr what" style="display:none;"></div>
        <div class="clear"></div>
        <div class="halfdown"></div>
    </div>
    <script>
        var form = document.getElementsByClassName('outer')[0];
        console.log(form);
        var io = document.getElementById('io');
        var midtop = document.getElementsByClassName('halftop')[0];
        var middown = document.getElementsByClassName('halfdown')[0];
        var lr = document.getElementsByClassName('lr')[0];
        var rr = document.getElementsByClassName('lr')[1];
        delay=5;
        move({ 'top': 150 }, form, function () {
            io.onclick = function () {
                lr.style.display = 'none';
                setTimeout(() => {
                	lr.submit();
                }, 1000);
                delay=8;
                move({ 'top': -450 }, midtop);
                move({ 'top': 450 }, middown,function(){
                	middown.style['display']='none';
                });
               
            }
        });
    </script>
	
</body>

</html>