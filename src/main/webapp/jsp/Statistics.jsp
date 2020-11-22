<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
       
    </div>
    <div style="width: 70%;height: 800px;display: flex;flex: 1;flex-direction: column;">
        <div style="height: 50%;overflow: auto;">
        
            <s:iterator value="QuestionnaireContent" id="id" status="st">
               
                    
                        <h4>
                            <s:property value="#id.questionContent" />
                        </h4>
                        <p hidden>
                            <s:property value="#id.questionNo" />
                        </p>
                        <s:if test="#id.questionType=='single'">
                            <div class="single">

                                <table>
                                    <tbody>
                                        <s:iterator value="#id.optionList" id="subId"
                                            status="subSt">
                                            <tr>
                                                <td><p class='iconfont icon-option'></p></td>
                                                <td><p>
                                                        <s:property value="#subId.optionContent" />
                                                    </p></td>
                                                <td><p hidden>
                                                        <s:property value="#subId.statistic" />
                                                    </p></td>
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                            </div>
                        </s:if>
                        <s:elseif test="#id.questionType=='multi'">
                            <div class="multi">

                                <table>
                                    <tbody>
                                        <s:iterator value="#id.optionList" id="subId"
                                            status="subSt">
                                            <tr>
                                                <td><p class='iconfont icon-multi-option'></p></td>
                                                <td><p>
                                                        <s:property value="#subId.optionContent" />
                                                    </p></td>
                                                <td><p hidden>
                                                        <s:property value="#subId.statistic" />
                                                    </p></td>
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                            </div>
                        </s:elseif>
                        <s:else>
                            <div class="essay">
                                
                            </div>
                        </s:else>
                    
               
            </s:iterator>


        
        </div>
        <div style="height: 50%;border-top:dotted 1px #000000;">
        
        </div>
    </div>
	
	
</div>
			</div>
		</div>
	</div>
</body>
</html>
