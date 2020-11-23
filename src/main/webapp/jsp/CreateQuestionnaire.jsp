<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="utf-8">

<title>Qmaker问卷网</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">



</head>

<body>
    <div  style="text-align: center;">
        <nav>
           <a class="" href="#">预留导航栏</a>
        </nav>
    </div>
    <div style="display: flex;flex: 1;">
        <div style="width: 30%;height: 650px;text-align: center;">
            <p><button class="" id="add_single">单选题</button></p> 
            <p><button class="" id="add_multi">多选题</button></p>
           <p> <button class="" id="add_essay">简答题</button></p>   
        </div>
        <div style="width: 70%;height: 800px;display: flex;flex: 1;flex-direction: column;">
            <div style="height: 50%;overflow: auto;">
                <form action="CreateNewQuestionnaireAction.action" method="post">
                    <input type="text" name="questionNum" id="questionNum" value="0" hidden>
                    <button type="submit" class="" id="submit_btn">保存</button>
                     <h3>Title</h3>
                     <input type="text" name="title" id="" value="title">
                    <button class="">
                    <p>编辑</p>
                    </button>
                    <div>
                        <p>QuestionContent</p>
                    <p>单选题</p>
                    <p>option1</p>
                    <p>option2</p>
                        <div>
                            <button style="height: 60px;width: 60px;">上移</button>
                            <button style="height: 60px;width: 60px;">下移</button>
                            <button style="height: 60px;width: 60px;">编辑</button>
                            <button style="height: 60px;width: 60px;">删除</button>
                        </div>
                    </div>
                    
                </form>
            </div>
            <div style="height: 50%;border-top:dotted 1px #000000;">
            <p><input type="text"name=""value="QuestionContent"></p>
            <p><input type="text"name=""value="单选题"></p>
            <p><input type="text"name="" value="option1" style="width:80px;"><button>删除</button></p>
            <p><input type="text"name="" value="option2" style="width: 80px;"><button>删除</button></p>
            <p><button style="width: 50px;">添加选项</button></p>
            <p><button style="width: 500px;text-align: center;">保存编辑</button></p>
            </div>
        </div>
    </div>
</body>
</html>
