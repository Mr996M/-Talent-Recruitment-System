<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>


</script>
</head>
<body>
<h2 style="margin-left:40%;">修改招聘信息</h2>
<form class="form-horizontal" role="form" style="margin-left:23%;" method="post" action="${pageContext.request.contextPath }/recrC/update"">
	<input type="hidden" name="id" value="${recruit.id}">
	<div class="form-group">
		
		<label for="firstname" class="col-sm-2 control-label">发布人</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="name" style="width: 300px" value="${recruit.name}">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">招聘岗位</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="position" style="width: 300px" value="${recruit.position}">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">招聘人数</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="number" style="width: 300px" value="${recruit.number}">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">招聘要求</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="7" name="request" style="width: 300px">${recruit.request}</textarea>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary" style="margin-left: 40px">修改</button>&nbsp;&nbsp;
			<button type="reset" class="btn btn-primary" style="margin-left: 40px">重置</button>
		</div>
	</div>
</form>

</body>
</html>