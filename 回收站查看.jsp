<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.*,table.*,java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
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
String id=request.getParameter("like");
if(id==null)id="";
System.out.println(id);
TrashDao dao=TrashDao.getInstance();
Trash id__=dao.getTrashTi();
id__.setName(id+"%");
User_ user=(User_)session.getAttribute("User");
boolean isM=(boolean)session.getAttribute("isM");
List<Trash>ls=null;
if(isM)
	ls=TrashDao.MakeSpecial(dao.QueryAll());
else {
id__.setOwner(user.getUsername());
ls=TrashDao.MakeSpecial(dao.QueryLike());
}
%>
	
    <div class="inner">
    <form action="回收站查看.jsp">
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
                <th>还原操作</th>
            </tr>
            <%
            Trash id_=null;
            for(int i=0;i<ls.size();i++)
            {
            	id_=ls.get(i);
            	out.println("<tr>");
            	out.println("<th>"+id_.getId()+"</th>");
            	out.println("<th>"+id_.getName()+"</th>");
            	out.println("<th>"+id_.getSex()+"</th>");
            	out.println("<th>"+id_.getAccount()+"</th>");
            	out.println("<th>"+id_.getPswd()+"</th>");
            	out.println("<th>"+id_.getEmail()+"</th>");
            	out.println("<th>"+"<a href=\"Del_trash?id="+id_.getId()+"&owner="+id_.getOwner()+"\">删除</a>"+"</th>");
            	out.println("<th>"+"<a href=\"Undo_trash?id="+id_.getId()+"&owner="+id_.getOwner()+"\">还原</a>"+"</th>");
            	out.println("<tr>");
            }
            
            %>
            
        </table>
        

    </div>
</body>

</html>