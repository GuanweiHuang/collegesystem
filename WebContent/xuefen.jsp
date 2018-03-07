<%@page import="dao.StuDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		String stucourse =(String)session.getAttribute("userName");
		List list = new StuDao().getcournamelist(stucourse);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程学分</title>
<link rel="stylesheet" type="text/css" href="css/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/locale/jquery.easyui.min.js"></script>
</head>
<body>
<table>
		<tr>
		<td>课程学分</td><td>课程名</td>
		</tr>
<%
		if(list==null||list.size()==0){
			out.print("<tr><td colspan='2'>没有任何数据显示</td></tr>");
		}else{
			for(int i=0;i<list.size();i++){
				String[] res = (String[])list.get(i);
%>
		<tr>
		<td style="width:700px"><div class="easyui-progressbar" data-options="value:<%=res[2] %>" style="width:100%;"></div></td><td><%=res[1] %></td>
		</tr>
<% 
			}
		}
%>
	
</body>
</html>