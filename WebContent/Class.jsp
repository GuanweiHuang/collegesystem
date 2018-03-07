<%@page import="dao.StuDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
			String author = (String)session.getAttribute("userName");
			List list = new StuDao().gettealist(author);
			
%>
<h2 align="center">班级信息列表</h2>
<table border="1" width="800" class="table table-striped table-bordered table-hover">
		<tr>
		<td>班级名</td><td>教员姓名</td><td>电话号码</td>
		</tr>
<%
		if(list==null||list.size()==0){
			out.print("<tr><td colspan='3'>没有任何数据显示</td></tr>");
		}else{
			for(int i=0;i<list.size();i++){
				String[] res = (String[])list.get(i);
%>
		<tr>
		<td><%=res[1] %></td><td><%=res[2] %></td><td><%=res[3] %></td>
		</tr>
<% 
			}
		}
%>