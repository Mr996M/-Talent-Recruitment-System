<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>招聘管理</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

<style type="text/css">
.btn-info {
    color: #000;
    background-color: #92B8B1;
    border-color:  #666666;
    margin-bottom: 10px;
}

</style>
</head>
<body>
<h1 align="center">招聘管理</h1>
	<table width="50%" border="1" cellpadding="0" cellspacing="0" align="center" class="table table-hover table-striped table-bordered">
		
		 <a href="${pageContext.request.contextPath }/insert.jsp" class="btn btn-info  btn-sm">
          <span class="glyphicon glyphicon-plus" style="margin-bottom: 10px"></span> 发布招聘
        </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <a href="${pageContext.request.contextPath }/recrC/info" class="btn btn-info  btn-sm">
         <span class="glyphicon glyphicon-th-list" style="margin-bottom: 10px"></span>&nbsp;招聘首页
        </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <a href="${pageContext.request.contextPath }/appC/findApply" class="btn btn-info  btn-sm">
         <span class="glyphicon glyphicon-eye-open" style="margin-bottom: 10px"></span>&nbsp;应聘记录
        </a>     
		<tr>
			<th>编号</th>
			<th>发布人</th>
			<th>岗位</th>
			<th>招聘数量</th>
			<th width="500px">招聘要求</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${slist }" var="s">
			<tr>
			
				<td>${s.id }</td>
				<td>${s.name }</td>
				<td>${s.position }</td>
				<td>${s.number }</td>
				<td>${s.request }</td>
				<td>
					<a href="${pageContext.request.contextPath }/recrC/upShow/${s.id}">
					<span class="glyphicon glyphicon-pencil" style="color: rgb(255, 140, 60);">&nbsp;编辑</span>
					</a>&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath }/recrC/del/${s.id}">
					<span class="glyphicon glyphicon-trash" style="color: rgb(178, 83, 53);">&nbsp;删除</span>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>