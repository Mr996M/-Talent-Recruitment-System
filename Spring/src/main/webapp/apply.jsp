<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写应聘信息</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<% String position=request.getParameter("position");
  %>
<h2 style="margin-left:40%;">应聘信息</h2>
<form class="form-horizontal" role="form" style="margin-left:23%;" method="post" action="${pageContext.request.contextPath }/appC/addApply" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${recruit.id}">
	<input type="hidden" name="status" value="未邀约">
	
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">应聘岗位:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="position" value="<%=position%> " style="width: 300px" readonly="readonly">
		</div>
	</div>
	
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">姓名:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="aname" style="width: 300px">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">联系方式:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="tele" style="width: 300px">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">学历</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="education" style="width: 300px">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">上传简历</label>
		<div class="col-sm-10">
		<input type="file" name="file1"/>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary" style="margin-left: 40px">上传</button>&nbsp;&nbsp;
			<button type="reset" class="btn btn-primary" style="margin-left: 40px">重置</button>
			<a href="${pageContext.request.contextPath }/recrC/info" class="btn">
			返回
			</a>
		</div>
	</div>
</form>
</body>
</html>