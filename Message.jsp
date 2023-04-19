<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="table.*,java.util.*,java.text.SimpleDateFormat,dao.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="GBK">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>消息列表</title>
    <style>
        .fl {
            float: left;
        }

        .fr {
            float: right;

        }

        .messbox {
            margin-top: 20px;
            border: 1px dotted rgb(77, 74, 74);
            width: 60%;
            border-radius: 5px;
            font-family: "STSong";
            font-size: 20px;
            color: rgb(107, 148, 60);
        }

        .messbox p {
            font-family: "STSong";
            font-size: 15px;
            color: rgb(107, 148, 60);
        }

        .messbox div {
            font-family: "Arial", "Microsoft YaHei", "黑体", "宋体", sans-serif;
            font-size: 12px;
            line-height: 30px;
            color: rgb(12, 11, 14);
        }
    </style>
    <link type="text/css" rel="styleSheet" href="css/style.css" />
</head>
<body>
  <div class="outer">
      
        <div class="mid" style="background-color:transparent;">
           
            <%
           
          	User_ user=(User_)session.getAttribute("User");
            MessageDao dao=MessageDao.getInstance();
            Message mess=dao.getMessageTi();
            mess.setReceiver(user.getUsername());
            List<TableI>ls=dao.QuerySelSet();
            for(int i=0;i<ls.size();i++)
            {
            	mess=(Message)ls.get(i);
            	out.println("   <div class=\"messbox fl\"><p><span>发件人</span>&nbsp;&nbsp;&nbsp;<span>"+mess.getSender()+"</span>&nbsp;&nbsp;&nbsp;<span>时间</span>&nbsp;&nbsp;&nbsp;<span>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(mess.getTime())+"</span>"
              +"          </p>"
              +"          <hr>"
              +"         <div>"
              +"              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "
              +mess.getMessage()
              +"          </div>"
               +"     </div>");
            }
            %>
              
            <!-- <div class="messbox fr">
                <p><span>发件人</span>&nbsp;&nbsp;&nbsp;<span>测试</span>&nbsp;&nbsp;&nbsp;<span>时间</span>&nbsp;&nbsp;&nbsp;<span>今天</span>
                </p>
                <hr>
                <div>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    测试
                </div>

            </div> -->


        </div>



    </div>
</body>
</html>