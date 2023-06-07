<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>招聘信息</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
	body{
				background-color: #92B8B1;
			}
			
	#left{
		float: left;
	}	
	
	#right{
		float: right;
		margin-top: 70px;
	}		
</style>
</head>
<body>
<h1 align="center">招聘信息</h1>
<a href="${pageContext.request.contextPath }/recrC/showRec">
<span class="glyphicon glyphicon-home" style="color: rgb(0, 0, 78);">返回管理</span>
</a><br/><br/>
<c:forEach items="${slist }" var="s">
<div style="width: 1200px;height: 220px">
<div id="left">招聘职位:<span>${s.position}</span><br/><br/>
发布人:<span>${s.name}</span><br/><br/>
招聘人数:<span>${s.number}</span><br/><br/>
<div style="width: 400px" >
招聘要求:<span>${s.request}</span>
</div>
</div>
<div id="right">
 <a href="${pageContext.request.contextPath }/apply.jsp?position=${s.position}" class="btn btn-info  btn-primary btn-lg">       
<span class="glyphicon glyphicon-arrow-right" style="color: rgb(178, 83, 53);">应聘该职位</span>
</a>
</div>
</div>
<hr/>
</c:forEach>


</body>
</html>