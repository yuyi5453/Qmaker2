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
                    <form action="UpdatePaperAction.action" method="post">
                        <input type="text" name="questionNum" id="questionNum" value="0" hidden>
                      
                           
                                    <button type="submit" class="btn btn-success" id="submit_btn">保存</button>
                            
                                                <h3 style="text-align: center;"><s:property value="QuestionnaireTitle"/></h3>

                                                <input type="text" name="title" id="" value="<s:property value="QuestionnaireTitle"/>"
                                                >
              
                                            <button class="btn btn-outline-secondary edit-btn">
                                                <p class="" style="margin-bottom: 0em;">编辑</p>
                                            </button>
                             <hr>
                            <s:iterator value="QuestionnaireContent" id="id" status="st">
                               
                                    <div class="">
                                       
                                            <input type='text' name='optionNum[<s:property value="#id.questionNo"/>]' class='optionNum' value='<s:property value="#id.optionNum"/>' hidden>
                                           
                                                <div><h5><s:property value="#id.questionContent" /></h5></div>
                                           
                                            
                                                <input type="text" name="Question[<s:property value="#id.questionNo"/>]" id="" value="<s:property value="#id.questionContent" />" >
                                            
                                            <s:if test="#id.questionType=='single'">
                                           
                                                <p>单选题</p>
                                            
                                            
                                                <input type="text" name="questionType[<s:property value="#id.questionNo"/>]"  value="单选题" readonly>
                                            
                                            
                                                    <div class="">分值：</div>
                                                    <div class=""><p style="margin-bottom: 0px"><s:property value="#id.score"/></p></div>
                                            
                                           
                                                分值：<input type='text' name='score[<s:property value="#id.questionNo"/>]' class='form-control score' value='<s:property value="#id.score"/>'>
                                            
                                            <table class="" style="word-break: break-all;">
                                                <tbody>
                                                    <s:iterator value="#id.optionList" id="subId" status="subSt">
                                                    <tr class="">
                                                        <s:if test="#subId.isStandardAnswer == 'yes'">
                                                            <td><p class="iconfont icon-option" style="color: #178bc9"></p></td>
                                                        </s:if>
                                                        <s:else>
                                                            <td><p class="iconfont icon-option"></p></td>
                                                        </s:else>
                                                        <td><p><s:property value="#subId.optionContent" /></p></td>
                                                    </tr>
                                                    <tr class="" >
                                                        <td><p class=""></p></td>
                                                        <td><input type="text" name="option[<s:property value="#subId.questionNo"/>]" id=""  value="<s:property value="#subId.optionContent" />"></td>
                                                        <s:if test="#subId.isStandardAnswer == 'yes'">
                                                            <td><input type='radio' name='standardAnswer[<s:property value="#subId.questionNo"/>]' id='' class='' value='<s:property value="#subId.optionNo"/>' checked></td>
                                                        </s:if>
                                                        <s:else>
                                                            <td><input type='radio' name='standardAnswer[<s:property value="#subId.questionNo"/>]' id='' class='' value='<s:property value="#subId.optionNo"/>'></td>
                                                        </s:else>
                                                        
                                                    </tr>
                                                    </s:iterator>
                                                </tbody>
                                            </table>
                                            </s:if>
                                            <s:if test="#id.questionType=='multi'">
                                                <p>多选题</p>

                                                <input type="text" name="questionType[<s:property value="#id.questionNo"/>]" id=""  value="多选题" readonly>
                                           
                                        
                                               
                                                    <div class="">分值：</div>
                                                    <div class=""><p style="margin-bottom: 0px"><s:property value="#id.score"/></p></div>
                                               
                                            
                                           
                                                分值：<input type='text' name='score[<s:property value="#id.questionNo"/>]' class='form-control score' value='<s:property value="#id.score"/>'>
                                            
                                            <table class="" style="word-break: break-all;">
                                                <tbody>
                                                    <s:iterator value="#id.optionList" id="subId" status="subSt">
                                                    <tr>
                                                        <s:if test="#subId.isStandardAnswer == 'yes'">
                                                            <td><p class="iconfont icon-multi-option" style="color: #178bc9"></p></td>
                                                        </s:if>
                                                        <s:else>
                                                            <td><p class="iconfont icon-multi-option"></p></td>
                                                        </s:else>
                                                        <td><p><s:property value="#subId.optionContent" /></p></td>
                                                    </tr>
                                                    <tr>
                                                        <td><p class="iconfont icon-multi-option"></p></td>
                                                        <td><input type="text" name="option[<s:property value="#subId.questionNo"/>]" id="" value="<s:property value="#subId.optionContent" />"></td>
                                                        <s:if test="#subId.isStandardAnswer == 'yes'">
                                                            <td><input type='checkbox' name='standardAnswer[<s:property value="#subId.questionNo"/>]' id='' class='' value='<s:property value="#subId.optionNo"/>' checked></td>
                                                        </s:if>
                                                        <s:else>
                                                            <td><input type='checkbox' name='standardAnswer[<s:property value="#subId.questionNo"/>]' id='' class='' value='<s:property value="#subId.optionNo"/>'></td>
                                                        </s:else>
                                                    </tr>
                                                    </s:iterator>
                                                </tbody>
                                            </table>
                                            </s:if>
                                            <s:if test="#id.questionType=='essay'">
                                               
                                                    <p>简答题</p>

                                                    <input type="text" name="questionType[<s:property value="#id.questionNo"/>]" id=""value="简答题" readonly>      
                                            </s:if>
                                        
                                    </div>
                                  
                                       
                                            <button class="" ><p class="" style="margin-bottom: 0em;">上移</p></button>
                                 
                                       
                                            <button class="" ><p class="" style="margin-bottom: 0em;">下移</p></button>
                                       
                                       
                                            <button class=""><p class="" style="margin-bottom: 0em;">编辑</p></button>
                                        
                                       
                                            <button class=""><p class="" style="margin-bottom: 0em;">删除</p></button>
                                       
                                   
                             
                            </s:iterator>
                       
                    </form>
                </div>
                <div style="height: 50%;border-top:dotted 1px #000000;">
        
                </div>
        </div>

											
</body>
</html>

