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

<title>My JSP 'PersonalIndex.jsp' starting page</title>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8" style="width:100%;margin-top:100px;border:1px solid black;padding-top:50px;">
				<div class="row">
					<div class="col-md-4">
								<form>
									<div class="row" style="width:100px;position:relative;left:47%;">
										<button class="btn btn-basic form-control" type="submit" 
											formaction="PersonalIndexAction.action" >我发布的问卷</button>
									</div>
									<div class="row" style="width:100px;position:relative;left:47%;margin-top: 10px;">
										<button class="btn btn-basic form-control" type="submit" 
											formaction="PersonalIndexUnpublishedAction.action">未发布的问卷</button>
									</div>
									<div class="row" style="width:100px;position:relative;left:47%;margin-top: 10px;">
										<button class="btn btn-basic form-control" type="submit" 
											formaction="PersonalIndexFilledAction.action">我填写的问卷</button>
									</div>
									<div class="row" style="width:100px;position:relative;left:47%;margin-top: 10px;">
										<button class="btn btn-basic form-control" type="submit"
											formaction="PersonalIndexOthersAction.action">问卷广场</button>
									</div>
								</form>
					</div>
					<div class="col-md-8">
						<div class="card">
							<div class="card-body">
									<div class="row">
										<div class="col-md-6" style="width:100px;position:relative;left:47%;">
											<a href="jsp/CreateQuestionnaire.jsp">
												<h3>新建问卷</h3>
											</a>
										</div>
									</div>
									<hr>
								<s:iterator value="QuestionnaireList" id="id" status="st">
									<div class="row">
										<div class="col-md-10">
											<div class="row">
												<div class="col-md-12">
													<h4>
														<s:property value="#id.title" />
													</h4>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<p>
														<s:property value="#id.lastChangedTime" />
													</p>
												</div>
											</div>
										</div>
									</div>
									<form action="#" method="post">
										<div class="row" style="width:200px;position: relative;left:47%;">
											<input type="text" name="QuestionnaireId"
												value=<s:property value="#id.questionnaireId"/> hidden>
											<s:if
												test="#session.QuestionnaireStatus == 'PUBLISHED'">
												<div class="col-md-4">
												</div>
												<div class="col-md-2">
													<button class="btn btn-outline-danger" type="submit"
														formaction="DeleteQuestionnaireAction.action">删除</button>
												</div>

												<div class="col-md-2">
													<button class="btn btn-outline-secondary" type="submit"
														formaction="QuestionnaireDetailAction.action">查看</button>
												</div>
												<div class="col-md-2">
													<button class="btn btn-outline-secondary" type="submit"
														formaction="StatisticAction.action">统计</button>
												</div>
												<div class="col-md-2">
													<button class="btn btn-outline-secondary" type="submit"
														formaction="FillOutQuestionnaireAction.action">填写</button>
												</div>
											</s:if>

											<s:elseif
												test="#session.QuestionnaireStatus == 'UNPUBLISHED'">
												<div class="col-md-4"></div>
												<div class="col-md-2">
													<button class="btn btn-outline-danger" type="submit"
														formaction="DeleteQuestionnaireAction.action">删除</button>
												</div>

												<div class="col-md-2">
													<button class="btn btn-outline-secondary" type="submit"
														formaction="QuestionnaireDetailAction.action">查看</button>
												</div>
												<div class="col-md-2">
													<button class="btn btn-outline-secondary" type="submit"
														formaction="EditQuestionnaireAction.action">编辑</button>
												</div>
												<div class="col-md-2">
													<button class="btn btn-outline-secondary" type="submit"
														formaction="PublishAction.action">发布</button>
												</div>
											</s:elseif>
										</div>
									</form>
								</s:iterator>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
