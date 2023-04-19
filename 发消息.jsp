<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.*,table.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
color: antiquewhite;
}
 .gg {
            width: 80%;
            margin: auto auto;
        }

        select {
            width: 90%;
            height: 20px;
            background-color: wheat;
        }

        textarea {
            background-color: white;
            color: pink;
            width: 100%;
            height: 400px;
        }

</style>
</head>
<body>
<%
IdcardDao dao=IdcardDao.getInstance();
User_ user=(User_)session.getAttribute("User");
String owner=user.getUsername();
Idcard id=dao.getIdcardTi();
id.setOwner(owner);
id.setName("%");
boolean isM=(boolean)session.getAttribute("isM");
List<Idcard>ls=null;
if(!isM)
ls=IdcardDao.MakeSpecial(dao.QueryLike());
else ls=IdcardDao.MakeSpecial(dao.QueryAll());
%>
 <div class="loser" style="top:40%;">
                <form action="SendMessage">
                    <select name="receiver">
                    <%
                    Idcard ids=null;
                    for(int i=0;i<ls.size();i++)
                    {
                    	ids=ls.get(i);
                    	out.println("<option value=\""+ids.getAccount()+"\">"+"账号"+ids.getAccount()+":姓名"+ids.getName()+"</option>");
                    }
                    
                    %>
                    
                    </select><textarea name="mess" id="" cols="40" rows="20">

    </textarea>
        <input type="submit" value="发送信息">
                 
                </form>
            </div>
</body>
</html>