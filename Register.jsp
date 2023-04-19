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
            font-size: 12px;
            text-align: right;
        }

        #io,
        input[type="text"],input[type="password"]{
            margin-top: 2px;
            width: 150px;
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

        .halftop {

            width: 0;
            border-bottom: 200px solid rgb(100, 56, 89);
            border-left: 200px solid transparent;
            border-right: 200px solid transparent;
            box-sizing: border-box;
        }

        .halfdown {
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
            top: -35px;
            position: relative;
            width: 279px;
            height: 200px;

            float: left;
            z-index: 10;
        }
    </style>
    <script src="js/move.js"></script>
</head>

<body>

    <div class="outer">
        <div class="halftop"></div>
        <form action="Add_user" class="lr">
            <ul>
                <li><span>用户名</span><input type="text" name="username" id="" value=<%=request.getParameter("username") %>></li>
                <li><span>密码</span><input type="password" name="password" id="" value=<%=request.getParameter("password") %>></li>
                <li><span>真实姓名</span><input type="text" name="realname" id="" value=<%=request.getParameter("realname") %>></li>
                <li><span id="io"><input type="button" name="" value="注册" class="ll"></span></li>

            </ul>
        </form>
        <div class="halfdown"></div>
    </div>
    <script>
        var form = document.getElementsByClassName('outer')[0];
        console.log(form);
        var io = document.getElementById('io');
        var midtop = document.getElementsByClassName('halftop')[0];
        var middown = document.getElementsByClassName('halfdown')[0];
        var lr = document.getElementsByClassName('lr')[0];
        delay=5;
        move({ 'top': 150 }, form, function () {
            io.onclick = function () {
                lr.style.display = 'none';
                setTimeout(() => {
                    lr.submit();
                }, 500);
                move({ 'top': -form.offsetTop }, midtop);
                move({ 'top': form.offsetTop }, middown);
            }
        });


    </script>

</body>

</html>