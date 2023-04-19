<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="table.*,dao.*" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>名片添加</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        li {

            list-style: none;
        }

        tr {
            height: 50px;
        }

        th {
            width: 200px;
            margin-left: 20px;
        }

        .header {
            height: 20%;
            background-color: #fff;

        }



        .midtop,
        .mid,
        .footer {
            margin: auto;
            width: 80%;

        }

        .mid {
            height: 120%;
            background-color: rgb(92, 93, 158);
        }

        .footer {
            background-color: white;
            height: 10%;
        }

        html,
        body,
        .outer {
            height: 100%;
            width: 100%;
        }

        html {
            background-color: rgb(230, 220, 220);
        }

        .foot,
        .foot2 {
            font-family: "宋体";
        }

        .foot {
            position: relative;
            letter-spacing: 10px;
            font-size: 20px;
            top: 70px;
            left: 200px;
            color: blue;
        }

        .foot2 {
            position: relative;
            letter-spacing: 10px;
            font-size: 20px;
            top: 70px;
            font-weight: 400;
            left: 225px;
            color: blue;
        }

        .form {
        width:30%;
            position: relative;
            top: 100px;
            width: 300px;
            margin: auto;
        }

        select,input {
            background-color: rgb(92, 93, 158);
            height: 20px;
            border-bottom: 1px solid rgb(148, 138, 138);
           
            width: 100%;
            border-top: none;
            border-left: none;
           
            border-right: none;
        }
  


        input[type="submit"] {
           height: 20px;
    margin-left: 35%;
    width: 20%;
        }
        form 
        {
            position: relative;
    width: 30%;
    margin: auto auto;
    height: 50%;
    top: 100px;
        }
        .hidden
        {
        display:none;
        }
    </style>


</head>

<body>
<%
boolean isM=false;
Object obj=session.getAttribute("User");
if(obj==null){
	request.getRequestDispatcher("Login.jsp").forward(request, response);
}
User_ user=(User_)session.getAttribute("User");
isM=(boolean)session.getAttribute("isM");
String display=isM?"":"hidden";
%>
    <form action="Add_idcard">

<table>
        <tr>
            <td><span>编号</span></td>
            <td><input type="text" name="id" value=<%="" %>> </td>
        </tr>
        <tr>
            <td><span>姓名</span></td>
            <td><input type="text" name="name" value=<%="" %>> </td>
        </tr>
        <tr>
            <td><span>账户</span></td>
            <td><input type="text" name="account" value=<%="" %>> </td>
        </tr>
        <tr>
            <td><span>密码</span></td>
            <td><input type="text" name="pswd" value=<%="" %>> </td>
        </tr>
        <tr>
            <td><span>邮箱</span></td>
            <td><input type="text" name="email" value=<%="" %>></td>
        </tr>
        
        <tr class=<%=display%> >
            <td><span>拥有者</span></td>
            <td><input type="text" name="owner" value=<%=user.getUsername()%> ></td>
        </tr>
        <tr><td><span>性别</span></td>
        <td>
            <select name="sex">
                <option value="男" <%=(("".equals("男"))?"selected":"")%> >男♂
                </option>
                <option value="女" <%=("".equals("女"))?"selected":"" %> >女♀</option>
            </select></td>

        </tr>
        <tr><th><input type="submit" value="添加" style="background-color: yellowgreen;border-radius: 5px 5px 5px 5px;top:2px;"></th><tr>
    </table>
    </form>


</body>
<div id="night-mask"
    style="position: fixed;top: 0;left: 0;width: 100%;height: 100%;z-index: 2147483647;pointer-events: none;mix-blend-mode: multiply;transition: opacity 0.1s ease 0s;opacity:0.3;display:none;background: #000000;">
</div>

</html>