<%@page import="dao.teacharDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<%
			String classname =(String)session.getAttribute("name");
			List list = new teacharDao().getbanjilist(classname);
%>
<h2 align="center">班级学生列表</h2>
<table border="1" class="table table-striped table-bordered table-hover">
			<tr>
			<td>编号<td>姓名</td><td>性别</td><td>年龄</td><td>地址</td><td>电话号码</td><td>民族</td><td>政治面貌</td><td>班级名</td>
			</tr>
		<%
				if(list==null||list.size()==0){
					out.print("<tr><td colspan='9'>没有任何数据显示</td></tr>");
				}else{
					for(int i=0;i<list.size();i++){
						String res[]=(String[])list.get(i);
		%>
			<tr>
			<td><%=res[0] %></td><td><%=res[1] %></td><td><%=res[2] %></td><td><%=res[3] %></td><td><%=res[4] %></td><td><%=res[5] %></td><td><%=res[6] %></td>
			<td><%=res[7] %></td><td><%=res[8] %></td>
			</tr>	
		<%
					}
				}
		%>
</table>
			