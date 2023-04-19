<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.*,table.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="GBK">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>名片查询</title>
    <style>
    body{
color: antiquewhite;
}
    *
    {
    padding:0;
    margin:0;
    }
        .inner {
            margin: auto auto;
        }

        th {
            border: 1px dotted rgb(58, 54, 54);
            width: 11.111%;
            height: 20px;
            box-sizing: border-box;
        }

        a {
        	display:inline-block;
        	text-decoration:none;
            text-align: center;
            width: 50%;
            background-color: chartreuse;
            border-radius: 50%;
        }
         input[type="text"] {
            width: 50%;
                box-sizing: border-box;
            height: 20px;
            border-radius: 5px 0 0 5px;
            position: relative;
        }

        input[type="submit"] {
            vertical-align: bottom;
            position: relative;
            height: 20px;
            /* margin-left: 50px; */
            background-color: wheat;
            width: 100px;
            border: none;
            border-radius: 0 5px 5px 0;
            
        }
    </style>
</head>

<body>
<%
boolean isM=false;
Object obj=session.getAttribute("User");
if(obj==null){
	request.getRequestDispatcher("Login.jsp").forward(request, response);
	return ;
}
User_ user=(User_)session.getAttribute("User");
isM=(boolean)session.getAttribute("isM");
%>
<%

String id=request.getParameter("like");
if(id==null)id="";
System.out.println(id);
IdcardDao dao=IdcardDao.getInstance();
Idcard id__=dao.getIdcardTi();
id__.setName(id+"%");
if(!isM)
	id__.setOwner(user.getUsername());
List<Idcard>ls=null;
if(isM)
ls=IdcardDao.MakeSpecial(dao.QueryAll());
else ls=IdcardDao.MakeSpecial(dao.QueryLike());
%>
	
    <div class="inner">
    <form action="名片查询.jsp">
    <input type="text" name="like"><input type="submit" value="模糊查询">
        </form>
        <table>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>账户</th>
                <th>密码</th>
                <th>邮箱</th>
                <th>删除操作</th>
                <th>修改操作</th>
                
            </tr>
            <% 
            Idcard id_=null;
            for(int i=0;i<ls.size();i++)
            {
            	
            	id_=ls.get(i);
            	if(id_.getId().equals("0"))continue;	
            	out.println("<tr>");
            	out.println("<th>"+id_.getId()+"</th>");
            	out.println("<th>"+id_.getName()+"</th>");
            	out.println("<th>"+id_.getSex()+"</th>");
            	out.println("<th>"+id_.getAccount()+"</th>");
            	out.println("<th>"+id_.getPswd()+"</th>");
            	out.println("<th>"+id_.getEmail()+"</th>");
            	out.println("<th>"+"<a href=\"Del_idcard?id="+id_.getId()+"&owner="+id_.getOwner()+"\">删除</a>"+"</th>");
            	out.println("<th>"+"<a href=\"名片修改.jsp?id="+id_.getId()+"&owner="+id_.getOwner()+"\" target=\"main\">修改</a>"+"</th>");
            	
            	out.println("<tr>");
            }
            
            %>
            
        </table>


    </div>
</body>

</html>