<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="model.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="GBK">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>名片管理系统</title>
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
            background-image: url('../pt/chess.gif');
            background-size: cover;
        }

        div,
        a {
            display: block;
            opacity: 0.8;
            box-sizing: border-box;
            width: 300px;
            height: 40px;
            background-color: white;
            border: 1px solid black;
        }

        span {
            display: block;
        }

        .gun {
            overflow: hidden;
            width: 300px;
            opacity: 0.5;
            background-color: pink;
            display: none;
            position: relative;
        }

        h4 {
        position:relative;
            opacity: 0.8;
            background-color: rgb(240, 234, 206);
            height: 40px;
            font-size: 20px;
            line-height: 40px;
            
            color: darkkhaki;
        }

        iframe {
            opacity: 0.5;
            border: 1px solid black;
            width: 72%;
            height: 100%;
            position: absolute;
            top: 40px;
            right: 100px;
        }

        .outer {
        	position:relative;
            width: 320px;
            height: 100%;
            border-right: 1px solid black;
        }

        .ri {
            float: right;
            margin-right: 50%;
        }

        .lf {
            float: left;
        }
    </style>
    <script src="js/move.js"></script>
</head>

<body>
<%
boolean isM=false;
Object obj=session.getAttribute("user");
if(obj==null){
	request.getRequestDispatcher("Login.jsp").forward(request, response);
	return ;
}
else 
{
	isM=((User)obj).getRole()==1;
}
User user=(User)obj;

session.setAttribute("isM", isM);
%>
    <h4><%=isM?"管理员":"普通用户" %><span class="ri">名片管理系统</span></h4>
    <span class="outer">
    <%if(isM) {%>
        <div class="clk">用户管理</div>
        <span class="gun">
            <a href="用户查询.jsp" target="main">用户查询</a>
        </span>
        <%} %>
        <div class="clk">名片管理</div>
        <span class="gun">
            <a href="名片添加.jsp" target="main">名片添加</a>
            <a href="名片查询.jsp" target="main">名片查询</a>
        </span>
        <div class="clk">信息</div>
        <span class="gun">
            <a href="发消息.jsp" target="main">发送信息</a>
            <a href="Message.jsp" target="main">收件箱</a>
        </span>
        <% if(!isM){%>
        <div class="clk">个人信息</div>
        <span class="gun">
            <a href=<%="名片修改.jsp?owner="+user.getUsername()+"&id=0"%> target="main">信息更新</a>
        </span>
        <%} %>
        <div class="clk">回收站</div>
        <span class="gun">
            <a href="回收站查看.jsp" target="main">查看回收站</a>
        </span>
        <div class="clk">导入/导出</div>
        <span class="gun">
            <a href="导入.jsp" target="main">导入</a>
            <a href="导出.jsp" target="main">导出</a>
        </span>
       
    </span>
    <iframe src="" frameborder="0" name="main"></iframe>
    <!-- <iframe src="stu.jsp" frameborder="1" ></iframe> -->
    <script>
    window.onload=function(){
        function getStyle(obj, attr) {
            if (window.getComputedStyle)
                return getComputedStyle(obj, null)[attr];
            else return obj.currentStyle[attr];
        }
        function getSdouble(obj, attr) {
            return parseFloat(getStyle(obj, attr));
        }
        function move(json, obj, callback) {
            clearInterval(obj.timer);
            var speed = 10;
            var fns = false;
            obj.timer = setInterval(function () {
                fns = true;
                for (key in json) {
                    var it = getSdouble(obj, key);
                    var isf = (it >= parseFloat(json[key]));

                    if (!isf) {
                        obj.style[key] = (speed + it) + 'px';
                    }
                    fns &= isf;
                }
                if (fns) {
                    clearInterval(obj.timer);
                    if (callback) callback();
                }
            }, 60);
        }
        var gun = document.getElementsByClassName('gun');
        var clk = document.getElementsByClassName('clk');
        var isview;
        for (var i = 0; i < gun.length; i++) {
            clk[i].index = i;
            clk[i].onclick = function () {
                var obj = gun[this.index];
                obj.style.display = 'block';
                var height = getSdouble(obj, 'height');
                obj.style.height = 0;
                move({ 'height': height }, obj, function () { });
                this.onmouseover = function () {
                    obj.style.display = 'block';
                }
                obj.onmouseover = function () {
                    this.style.display = 'block';
                }
                obj.onmouseout = function () {
                    this.style.display = 'none';
                }
                this.onmouseout = function () {
                    obj.style.display = 'none';
                    this.onmouseover = function () { }
                }
            }

        }
        delay=100;
        var rt = document.getElementsByClassName('outer')[0];
        var he = document.body.offsetHeight;
        rt.style['top'] = -400 + 'px';
        ok=true;
        var h4 = document.getElementsByTagName('h4')[0];
        h4.style['top']=-40+'px';
        move({ 'top': 0}, h4);
        speed=120;
        move({ 'top': 0 }, rt);
    }
    </script>
</body>

</html>