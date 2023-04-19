<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.*,table.*,java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="GBK">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户查询</title>
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
UserDao dao=UserDao.getInstance();
User_ id__=dao.getUserTi();
List<User_>ls=UserDao.MakeSpecial(dao.QueryAll());
%>
	
    <div class="inner">
    
        <table>
            <tr>
                <th>账户</th>
                <th>密码</th>
                <th>身份</th>
                <th>删除操作</th>
             
                
            </tr>
            <% 
            User_ id_=null;
            for(int i=0;i<ls.size();i++)
            {
            	id_=ls.get(i);
            	if(id_.getRole()==1)continue;
            	out.println("<tr>");
            	out.println("<th>"+id_.getUsername()+"</th>");
            	out.println("<th>"+id_.getPassword()+"</th>");
            	out.println("<th>"+id_.getRole()+"</th>");
            	out.println("<th>"+"<a href=\"Del_user?username="+id_.getUsername()+"\">删除</a>"+"</th>");
            	
            	out.println("<tr>");
            }
            
            %>
            
        </table>

    </div>
</body>

</html>