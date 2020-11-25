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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://cdn.highcharts.com.cn/highcharts/highcharts.js"></script>
<script src="/static/js/Statistics.js" charset="utf-8"></script>
<link rel="stylesheet" href="/static/icon/icon.css">

</head>

<body>
	<div class="container-fluid"
		style="width: 100%; height: 100%;background-color: #c3e1f598">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8" style="padding-left: 0px;padding-right: 0px;">
				<nav class="navbar navbar-expand-sm bg-light" role="navigation">
				<a class="navbar-brand" href="#">Qmaker</a>
				<ul class="navbar-nav">
					<li class="nav-item"><a href="#" class="nav-link"></a></li>
					<li class="nav-item"><a href="#" class="nav-link"></a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="#" class="nav-link"></a></li>
					<li class="nav-item"><a href="#" class="nav-link"></a></li>
				</ul>
				</nav>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style=" height: 100%;min-height: 900px ;background-image: url(/static/pic/RegisterBackground.jpg);background-repeat: no-repeat;background-size: cover;">
				<div class="row">
					<div class="col-md-6">
						<div class="card"
							style="margin-left: 15%;margin-top: 20px;height: 90%;box-shadow: 0px 0px 10px 5px #c3e1f5b7;min-height: 900px">
							<div class="card-body content">
								<s:iterator value="QuestionnaireContent" id="id" status="st">
									<div class="row question-bar">
										<div class="col-md-12">
											<h4>
												<s:property value="#id.questionContent" />
											</h4>
											<p class="questionNo" hidden>
												<s:property value="#id.questionNo" />
											</p>
											<s:if test="#id.questionType=='单选题'">
												<div class="单选题">

													<table class="option-table">
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
											<s:elseif test="#id.questionType=='多选题'">
												<div class="multi">

													<table class="option-table">
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
										</div>
									</div>
								</s:iterator>


							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-12">
								<div class="card"
									style="margin-right: 15%;margin-top: 20px;height: 90%;box-shadow: 0px 0px 10px 5px #c3e1f5b7;height: 500px;overflow: auto;">
									<div class="card-body" id="pie-chart"></div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<div class="card"
									style="margin-right: 15%;margin-top: 20px;height: 90%;box-shadow: 0px 0px 10px 5px #c3e1f5b7;height: 300px;overflow: auto;">
									<div class="card-body" id="bar-chart"></div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<div class="card"
									style="margin-right: 15%;margin-top: 20px;height: 90%;box-shadow: 0px 0px 10px 5px #c3e1f5b7;height: 50px;overflow: auto;">
									<div class="card-body">
										<div id="statistic"></div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
