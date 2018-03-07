<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<center>
		<h2>学生课程详情</h2>
		<table border="1" width="750" style="text-align:center;">
		<tr>
			<td colspan="6">
					<form action="getstutjServlet" method="post">
							学生姓名:<input name="uname" size="5" value="${param.uname }"/>
							班级:<input name="banji" size="5" value="${param.banji }"/>
							<input type="submit" value="查询"/>
					</form>
			</td>
		</tr>
		<tr>
		<td>编号</td><td>学生姓名</td><td>课程</td><td>学分</td><td>班级</td><td>教员</td>
		</tr>
		<c:forEach var="res" items="${stutjlist }" varStatus="ids">
		<tr>
		<td>${ids.count }</td><td>${res[1] }</td><td>${res[2] }</td><td>${res[3]}</td><td>${res[4]}</td><td>${res[5]}</td>
		</tr>
		</c:forEach>
		</table>
		</center>
</body>
</html>