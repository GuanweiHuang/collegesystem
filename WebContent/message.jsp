<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息列表</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h2 align="center">个人信息列表</h2>
	<table style="margin:auto;"  class="table table-striped table-bordered table-hover">
		<tr>
		<td>姓名</td><td>年龄</td><td>性别</td><td>地址</td>
		<td>电话号码</td><td>出生年月</td><td>民族</td><td>政治面貌</td>
		</tr>
		<c:forEach var="u" items="${authorList }" varStatus="ids">
		<tr>
		<td>${u.sauthor}</td><td>${u.sage}</td><td>${u.ssex }</td><td>${u.saddresss }</td>
		<td>${u.sphone }</td><td>${u.sbirth }</td><td>${u.sNation }</td><td>${u.spolitic }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
<script type="text/javascript">
	function loadData(){
		//$("body").css("background-color","gray");
		$("#tab").css("text-aligh","left");
		$("tr").css("height","35px");
		$("tr td").css("width","100px");
		
		
		$.post()	
		
		
		
		
		
		
	}
	window.onload=loadData;
	
</script>