<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学院信息管理系统</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.20.custom.min.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.20.custom.css" rel="stylesheet">
</head>
<body style="background-image:url('images/t1.jpeg');background-size:100%;">
		
		<div id="tabs">
		<ul>
			<li><a href="#tabs-1">学生登录</a></li>
			<li><a href="#tabs-2">老师登录</a></li>
		</ul>
		<div id="tabs-1">
			<form action="LoginServlet" method="post">
	<img src="images/main_48.gif" style="position:absolute;top:70px;"/><b style="margin-left:30px;">用户名:</b><input name="userName" placeholder="请输入用户名" onblur="test1()" data-toggle="tooltip" data-placement="right" title="用户名"/><br/>
	<img src="images/main_50.gif" style="position:absolute;top:100px;"/><b style="margin-left:33px;">密码:</b><input name="userPwd" type="password" style="margin-left:14px;" placeholder="请输入密码" onblur="test2()"  data-toggle="tooltip" data-placement="right" title="密码"/><br/>
					<input type="submit" value="登录" style="position:absolute;left:140px;margin-top:20px;"/>
					<input type="reset" value="重置" style="position:absolute;left:200px;margin-top:20px;"/>
			</form>
		</div>
		<div id="tabs-2">
			<form action="TeacharServlet" method="post">
					<img src="images/main_48.gif" style="position:absolute;top:70px;"/><b style="margin-left:30px;">用户名:</b><input name="aname" placeholder="请输入用户名" onblur="test3()"/><br/>
					<img src="images/main_50.gif" style="position:absolute;top:100px;"/><b style="margin-left:30px;">密码:</b><input name="apwd" type="password" style="margin-left:17px;" placeholder="请输入密码" onblur="test4()"/><br/>
					<input type="submit" value="登录" style="position:absolute;left:140px;margin-top:20px;"/>
					<input type="reset" value="重置" style="position:absolute;left:200px;margin-top:20px;"/>
			</form>
		</div>
	</div>
	
</body>
</html>
<script type="text/javascript">
		
	$("#tabs").tabs();
						 	
</script>