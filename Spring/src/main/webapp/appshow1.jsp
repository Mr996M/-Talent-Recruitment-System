<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>应聘记录</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />

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
<h1 align="center">应聘人员信息</h1>
	<table width="50%" border="1" cellpadding="0" cellspacing="0" align="center" class="table table-hover table-striped table-bordered">				 
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>电话号码</th>
			<th>学历</th>
			<th>应聘岗位</th>
			<th>状态</th>
			<th style="width: 200px">简历</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${slist }" var="s">
			<tr>
			
				<td>${s.aid }</td>
				<td>${s.aname }</td>
				<td>${s.tele }</td>
				<td>${s.education }</td>
				<td>${s.position }</td>
				<td>${s.status }</td>
				<td><a href="${pageContext.request.contextPath }/appC/downFile?fname=${s.cvurl}"><span class="glyphicon glyphicon-download" style="color: rgb(50, 106, 122);">${s.cvurl }</span></a></td>
				<td>
					<a class="btn btn-default" id="a" onclick="btn1()">
					<span class="glyphicon glyphicon-send" style="color: rgb(0, 84, 0);">&nbsp;发送面试邀约</span>
					</a>
					<a href="${pageContext.request.contextPath }/recrC/del/${s.aid}" class="btn btn-default" id="b" style="display: none; width: 40px;height: 40px;">
					<span class="glyphicon glyphicon-ok" style="color: rgb(255, 140, 60);" >通过</span>
					</a>
					<a href="${pageContext.request.contextPath }/recrC/del/${s.aid}" class="btn btn-default" id="c" style="display: none; width: 40px;height: 40px;">
					<span class="glyphicon glyphicon-remove" style="color: rgb(255, 140, 60);">不通过</span>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
			function btn1(){
			    document.getElementById("b").style.display='block'; 
				document.getElementById("c").style.display='block'; 
			}
	</script>

</body>
</html>