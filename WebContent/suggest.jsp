<%@page import="emtity.teachar"%>
<%@page import="dao.teacharDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<%
		List tealist = new teacharDao().gettealist();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: 微软雅黑">

<form action="dissentServlet" method="post">
<table border="1" class="table table-striped table-bordered table-hover" id="mytab">
<tr>
			<td>信息类型:</td><td><input name="dlei" type="text"></td>
</tr>
<tr>
			<td>发布时间:</td><td><input name="dstime"></td>
</tr>
<tr>			
			<td>收件人:</td>
			<td><select name="entno">
							<option value="">请选择老师</option>
							<%
								for(int i=0;i<tealist.size();i++){
									teachar tea = (teachar)tealist.get(i);
								
							%>
							<option value="<%=tea.getTno() %>"><%=tea.getTname() %></option>
							<%
								}
							%>
					    </select></td>
</tr>
<tr>
				<td>内容:</td>
				<td><textarea name="dsname" cols="40" rows="10">
			
				</textarea></td>
</tr>
<tr>
				<td>发件人:</td><td><input name="stuno"></td>
</tr>			
<tr>
				<td colspan="2" style="text-align:center"><input type="submit" value="发送">&nbsp;&nbsp;<input type="reset" value="重置"></td> 
</tr>
			
</table>
</form>
</body>
</html>