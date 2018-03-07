<%@page import="emtity.dissent"%>
<%@page import="dao.StuDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<%
			String disname =(String)session.getAttribute("name");
			List list = new StuDao().getdissentlist(disname);
%>
<h2 align="center">信息列表</h2>
<table border="1" class="table table-striped table-bordered table-hover">
			<tr>
			<td>信息内容<td>信息类型</td><td>发送时间</td><td>发件人</td>
			</tr>
			<%
					if(list==null||list.size()==0){
						out.print("<tr><td colspan='4'>没有任何信息显示</td></tr>");
					}else{
						//有信息
						for(int i=0;i<list.size();i++){
							String res[]=(String[])list.get(i);
			%>
			<tr>
			<td><%=res[0] %><td><%=res[1] %></td><td><%=res[2] %></td><td><%=res[3] %></td>
			</tr>		
			<% 
						}
					}
			%>
</table>