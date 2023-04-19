<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="table.*,dao.*" errorPage=""%>

    <head>
        <meta charset="GBK">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>名片修改</title>
        <link type="text/css" rel="styleSheet" href="style.css" />
        <style>
            .asin,input[type="text"] {
                margin-bottom: 5px;
                top: 0;
            }
            table:nth-child(1)
        {
            text-align: right;
        }
            

            .text {
                position: relative;
                top: 20px;
            }
			.hidden
			{
			display:none;
			}
            .box {
                filter: opacity(0.5);

                position: relative;
                top: 80px;
                width: 50%;
                height: 300px;
                /* height: 500px; */
            }



            .header,
            .footer,
            .mid {
                background-color: transparent;
            }
			.text{
			background-color:white;
				text-align:center;
			}
            .text span {
            	
                line-height: 40px;
                font-family: "黑体";
                color: rgb(13, 56, 19);
                letter-spacing: 1px;
            }

            .gg {
                position: relative;
                left: -106px;
            }
            form 
            {
           
            text-align: -webkit-center;
            }
            table 
            {
             margin:auto;
            }
            select
            {
            float:left;
            }
        </style>
    </head>

    <body>
        <%! public String fstr(String s) { return s==null?"":s; } %>
          
                <div class="outer">
                    <div class="header"></div>
                    <!-- <div class="midtop"></div> -->
                    <div class="mid">
                        <center>
                            <div class="box">
                                <div class="text">

                                    <center>
                                        <h3>名片信息</h3>
                                    </center>
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
<%
String id=request.getParameter("id");
String owner=request.getParameter("owner");
IdcardDao dao=IdcardDao.getInstance();
Idcard id_=dao.getIdcardTi();
id_.setOwner(owner);
id_.setId(id);
id_=(Idcard)dao.QuerySel();//注意
%>
<form action="Upt_idcard">
<table>
        <tr><td><span>编号</span></td><td><input type="text" name="id" value=<%=id_.getId() %>>  </td>  </tr>
        <tr><td><span>姓名</span></td><td><input type="text" name="name" value=<%=id_.getName() %>>  </td>  </tr>
        <tr><td><span>账户</span></td><td><input type="text" name="account" value=<%=id_.getAccount() %>> </td>  </tr>
        <tr><td><span>密码</span></td><td><input type="text" name="pswd" value=<%=id_.getPswd() %>>  </td>  </tr>
        <tr><td><span>邮箱</span></td><td><input type="text" name="email" value=<%=id_.getEmail() %>></td>   </tr>
        <tr class=<%=display %>><td><span>所有者</span></td><td><input type="text" name="owner" value=<%=id_.getOwner() %>></td>   </tr>
        <tr><td><span>性别</span></td><td>
            <select name="sex" >
                <option value="男" <%=((id_.getSex().equals("男"))?"selected":"")%> >男♂
                </option>
                <option value="女" <%=(id_.getSex().equals("女"))?"selected":"" %> >女♀</option>
            </select>
        </td>
            </tr>
            <tr><th>&nbsp;&nbsp;&nbsp;</th><th>
            <input type="submit" value="修改"
                style="background-color: yellowgreen;margin-right: 40%;border-radius: 5px 5px 5px 5px;top:2px;">
    </th></tr></table>
    </form>
                                </div>
                            </div>
                        </center>
                    </div>
                    <div class="body"></div>
                    <div class="footer"></div>
                </div>
    </body>