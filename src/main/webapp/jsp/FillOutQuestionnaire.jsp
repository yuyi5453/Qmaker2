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

<title>My JSP 'QuestionnaireDetail.jsp' starting page</title>

<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<div class="container-fluid"
		style="width: 100%; height: 100%;">
		<div>
			<div style=" height: 100%;">
				<div style="margin-left: 20%;margin-right: 20%;margin-top: 3%;height: 90%;">
					<div style="padding-left: 10%;padding-right: 10%;">
						<div>
							<div>
								<h2 style="text-align: center;"><s:property value="QuestionnaireTitle"/></h2>
							</div>
						</div>
						<div>
							<div>
								<p>discription...discription...discription...discription...discription...discription...discription...discription...discription...discription...discription...discription...</p>
							</div>
						</div>
						<hr>
						<form method="post">
						<s:iterator value="QuestionnaireContent" id="id" status="st">
							<div>
								<div>
									<h4>
										<s:property value="#id.questionContent" />
									</h4>
									<s:if test="#id.questionType=='single'">
										<div>
											<table>
												<tbody>
													<s:iterator value="#id.optionList" id="subId"
														status="subSt">
														<tr>
															<td><input type="radio"
																name="Option4Question[<s:property value="#subId.questionNo"/>]"
																value="<s:property value="#subId.optionNo"/>"></td>
															<td><s:property value="#subId.optionContent" />(option)</td>
														</tr>
													</s:iterator>
												</tbody>
											</table>
										</div>
									</s:if>
									<s:elseif test="#id.questionType=='multi'">
										<div>
											<table>
												<tbody>
													<s:iterator value="#id.optionList" id="subId"
														status="subSt">
														<tr>
															<td><input type="checkbox"
																name="Option4Question[<s:property value="#subId.questionNo"/>]"
																value="<s:property value="#subId.optionNo"/>"></td>
															<td><s:property value="#subId.optionContent" />(option)</td>
														</tr>
													</s:iterator>
												</tbody>
											</table>
										</div>
									</s:elseif>
									<s:else>
										<div>
											<textarea name="Option4Question[<s:property value="#id.questionNo"/>]" id="" cols="60" rows="6"></textarea>
										</div>
									</s:else>
								</div>
							</div>
						</s:iterator>
						<hr>
						<button type="submit" class="btn btn-outline-success form-control" formaction="SubmitAnswerSheetAction.action">提交</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
