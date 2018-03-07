<%@page import="emtity.teachar"%>
<%@page import="dao.teacharDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<%
		String tname = (String)session.getAttribute("name");
		String tpwd  = (String)session.getAttribute("pwd");
		List list = new teacharDao().checklogtea(tname,tpwd);
%>
<h2 align="center">个人信息列表</h2>
<table border="1" class="table table-striped table-bordered table-hover">
		<tr>
		<td>姓名</td><td>年龄</td><td>性别</td><td>地址</td><td>电话号码</td>
		</tr>
<%
		if(list==null||list.size()==0){
			out.print("<tr><td colspan='5'>没有任何数据显示</td></tr>");
		}else{
			for(int i=0;i<list.size();i++){
				teachar tea = (teachar)list.get(i);
%>
		<tr>
		<td><%=tea.getTname() %></td><td><%=tea.getTage() %></td><td><%=tea.getTsex() %></td>
		<td><%=tea.getTaddress() %></td><td><%=tea.getTphone() %></td>
		</tr>
<% 
			}
		}
%>