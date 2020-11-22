<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">
        <meta charset="utf-8">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">    
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page"> 
        <title>Qmaker</title>
    </head>
    <body>
        <div style="width:250px;height:230px;padding:0 50px 0 50px;margin: 250px auto;border:1px solid black;">
            <h1 style="text-align: center;">REGISTE</h1>
            <form action="UserRegisterAction.action" method="post">
                <div class="form-group" style="width:100%;margin-bottom:20px;float: right;">
                    用户名:<input type="text" class="form-control" name="userId" style="width:165px;float:right;">
                </div>
                <div class="form-group" style="width:100%;float:right;">
                    密码:<input type="password" class="form-control" name="password" style="width:165px;float:right;">
                </div>
                <div>
                    <button type="submit" class="btn btn-primary form-control" style="margin-top:30px;position:relative;left:42%;">注册</button>
                </div>
            </form>
        </div>
    </body>
</html>
