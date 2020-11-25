<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  
  <body>
   <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">

            </div>
            <div class="col-md-8" style="padding-left: 0px;padding-right: 0px;">
                <nav class="navbar navbar-expand-sm bg-light">
                    <a class="navbar-brand" href="#">Qmaker</a>

                    <ul class="navbar navbar-nav ml-auto">
                        <li class="nav-item">
                            <a href="#" class="nav-link"></a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">

        </div>
        <div class="col-md-8">
            <div class="row">
                <div class="col-md-12"
                    style=" height: 800px;background-image: url(/static/pic/newbanner3.png);background-repeat: no-repeat;">
                    <div class="row">
                        <div class="col-md-10">

                        </div>
                        
                            <div class="col-md-2" style="padding-top: 400px;">
                                <a href="/jsp/Login.jsp" style="text-decoration: none;"><button class="btn  btn-block" style="height: 50px;font: 600;background-color: #f491bf;color: #FFF;">用户登录</button></a>
                                <br>
                                <a href="${pageContext.request.contextPath}/jsp/Register.jsp" style="text-decoration: none;"><button class="btn  btn-block" style="height: 50px;font: 600;background-color: #a3cdfd;color: #FFF;">用户注册</button></a>
                            </div>
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-2">

        </div>
    </div>
  </body>
</html>
