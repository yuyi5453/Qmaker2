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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="EditQuestionnaire.js" charset="utf-8"></script>
<link rel="stylesheet" href="icon.css">
</head>

<body>
	<div class="container-fluid"
		style="width: 100%; height: 100%;background-color: #c3e1f598">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8" style="padding-left: 0px;padding-right: 0px;">
				<nav class="navbar navbar-expand-sm bg-light" role="navigation">
				<a class="navbar-brand" href="#">Brand</a>
				<ul class="navbar-nav">
					<li class="nav-item"><a href="#" class="nav-link">nav-1</a></li>
					<li class="nav-item"><a href="#" class="nav-link">nav-2</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="#" class="nav-link">new
							account</a></li>
					<li class="nav-item"><a href="#" class="nav-link">sign in</a>
					</li>
				</ul>
				</nav>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style=" height: 100%;min-height: 900px ;background-image: url(pic/RegisterBackground.jpg);background-repeat: no-repeat;background-size: cover;">
				<div class="row">
					<div class="col-md-4">
						<div class="card"
							style="margin-left: 30%;margin-top: 20px;height: 90%;box-shadow: 0px 0px 10px 5px #c3e1f5b7;min-height: 900px">
							<div class="card-body">
								<div class="row">
									<button class="btn btn-basic form-control" id="add_single">单选题</button>

								</div>
								<div class="row">
									<button class="btn btn-basic form-control" id="add_multi">多选题</button>

								</div>
								<div class="row">
									<button class="btn btn-basic form-control" id="add_essay">简答题</button>

								</div>
							</div>
						</div>
					</div>
					<div class="col-md-8">
						<div class="row">
							<div class="col-md-12">
								<div class="card"
									style="margin-right: 15%;margin-top: 20px;height: 90%;box-shadow: 0px 0px 10px 5px #c3e1f5b7;height: 580px;overflow: auto;">
									<form action="UpdateQuestionnaireAction.action" method="post">
										<input type="text" name="questionNum" id="questionNum" value="0" hidden>
										<div class="card-body" id="preview_bar">
											<div class="row">
												<div class="col-md-10"></div>
												<div class="col-md-2">
													<button type="submit" class="btn btn-success" id="submit_btn">保存</button>
												</div>
											</div>
											<div class="row question-bar">
												<div class="col-md-12">
													<div class="row question-content-bar form-group">
														<div class="col-md-12">
															<div class="for-preview">
																<div>
																	<h3 style="text-align: center;"><s:property value="QuestionnaireTitle" /></h3>
																</div>
															</div>
															<div class="for-edit">
																<input type="text" name="title" id="" value="<s:property value="QuestionnaireTitle" />"
																	class="form-control">
															</div>
														</div>
													</div>
													<div class="row control-bar">
														<div class="col-md-10"></div>
														<div class="col-md-2">
															<button class="btn btn-outline-secondary edit-btn">
																<p class="iconfont icon-ic_edit"
																	style="margin-bottom: 0em;">编辑</p>
															</button>
														</div>
													</div>
												</div>
											</div>
											<hr>
											<s:iterator value="QuestionnaireContent" id="id" status="st">
												<div class="row question-bar">
                                                <div class="col-md-12">
                                                    <div class="row question-content-bar form-group">
                                                        <div class="col-md-12">
                                                        	<input type='text' name='optionNum[<s:property value="#id.questionNo"/>]' class='optionNum' value='2' hidden>
                                                            <div class="for-preview">
                                                                <div><h5><s:property value="#id.questionContent" />(QuestionContent)</h5></div>
                                                            </div>
                                                            <div class="for-edit">
                                                                <input type="text" name="questionContent[<s:property value="#id.questionNo"/>]" id="" value="<s:property value="#id.questionContent" />" class="form-control" >
                                                            </div>
                                                            <s:if test="#id.questionType=='single'">
                                                            <div class="for-preview">
                                                                <p>单选题</p>
                                                            </div>
                                                            <div class="for-edit">
                                                                <input type="text" name="questionType[<s:property value="#id.questionNo"/>]" id="" class="form-control" value="单选题" readonly>
                                                            </div>
                                                            <table class="option-table" style="word-break: break-all;">
                                                                <tbody>
                                                                	<s:iterator value="#id.optionList" id="subId" status="subSt">
                                                                    <tr class="for-preview">
                                                                        <td><p class="iconfont icon-option"></p></td>
                                                                        <td><p><s:property value="#subId.optionContent" />(option)</p></td>
                                                                    </tr>
                                                                    <tr class="for-edit" >
                                                                        <td><p class="iconfont icon-option"></p></td>
                                                                        <td><input type="text" name="optionContent[<s:property value="#subId.questionNo"/>]" id="" class="form-control" value="<s:property value="#subId.optionContent" />"></td>
                                                                    </tr>
                                                                    </s:iterator>
                                                                </tbody>
                                                            </table>
                                                            </s:if>
                                                            <s:if test="#id.questionType=='multi'">
                                                            <div class="for-preview">
                                                                <p>多选题</p>
                                                            </div>
                                                            <div class="for-edit">
                                                                <input type="text" name="questionType[<s:property value="#id.questionNo"/>]" id="" class="form-control" value="多选题" readonly>
                                                            </div>
                                                            <table class="option-table" style="word-break: break-all;">
                                                                <tbody>
                                                                	<s:iterator value="#id.optionList" id="subId" status="subSt">
                                                                    <tr class="for-preview">
                                                                        <td><p class="iconfont icon-multi-option"></p></td>
                                                                        <td><p><s:property value="#subId.optionContent" />(option)</p></td>
                                                                    </tr>
                                                                    <tr class="for-edit" >
                                                                        <td><p class="iconfont icon-multi-option"></p></td>
                                                                        <td><input type="text" name="optionContent[<s:property value="#subId.questionNo"/>]" id="" class="form-control" value="<s:property value="#subId.optionContent" />"></td>
                                                                    </tr>
                                                                    </s:iterator>
                                                                </tbody>
                                                            </table>
                                                            </s:if>
                                                            <s:if test="#id.questionType=='essay'">
                                                            	<div class="for-preview">
                                                                	<p>简答题</p>
                                                            	</div>
                                                            	<div class="for-edit">
                                                                	<input type="text" name="questionType[<s:property value="#id.questionNo"/>]" id="" class="form-control" value="简答题" readonly>
                                                            	</div>
                                                            </s:if>
                                                        </div>
                                                    </div>
                                                    <div class="row control-bar" >
                                                        <div class="col-md-4"></div>
                                                        <div class="col-md-2">
                                                            <button class="btn btn-outline-secondary up-btn" ><p class="iconfont icon-ic_up_line" style="margin-bottom: 0em;">上移</p></button>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <button class="btn btn-outline-secondary down-btn" ><p class="iconfont icon-ic_down_line" style="margin-bottom: 0em;">下移</p></button>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <button class="btn btn-outline-secondary edit-btn"><p class="iconfont icon-ic_edit" style="margin-bottom: 0em;">编辑</p></button>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <button class="btn btn-outline-danger delete-btn"><p class="iconfont icon-delete" style="margin-bottom: 0em;">删除</p></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
											</s:iterator>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="card"
									style="margin-right: 15%;margin-top: 20px;height: 90%;box-shadow: 0px 0px 10px 5px #c3e1f5b7;height: 300px;overflow: auto;">
									<div class="card-body" id="oprate_bar"></div>
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

