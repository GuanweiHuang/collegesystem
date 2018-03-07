<%@page import="dao.StuDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<%
		String stucourse =(String)session.getAttribute("userName");
		List list = new StuDao().getcournamelist(stucourse);
%>
<h2 align="center">课程信息列表</h2>
<table border="1" width="800" class="table table-striped table-bordered table-hover">
		<tr>
		<td>学生</td><td>教员姓名</td><td>课程名</td>
		</tr>
<%
		if(list==null||list.size()==0){
			out.print("<tr><td colspan='3'>没有任何数据显示</td></tr>");
		}else{
			for(int i=0;i<list.size();i++){
				String[] res = (String[])list.get(i);
%>
		<tr>
		<td><%=res[0] %></td><td><%=res[3] %></td><td><%=res[1] %></td>
		</tr>
<% 
			}
		}
%>