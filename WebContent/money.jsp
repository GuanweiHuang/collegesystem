<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.StuDao"%>
<%@page import="java.util.List"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<%
		String stucourse =(String)session.getAttribute("userName");
		List list = new StuDao().getcournamelist(stucourse);
%>
<img src="images/bg1.jpg" style="opacity:0.3;width:100%;height:490px;position:absolute">
<h2 align="center">费用列表</h2>
<table border="1" width="800" class="table table-striped table-bordered table-hover">
		<tr>
		<td>学生</td><td>学费</td><td>考试费</td><td>网络费</td><td>教材费</td><td>总计</td>
		</tr>
<%
		if(list==null||list.size()==0){
			out.print("<tr><td colspan='5'>没有任何数据显示</td></tr>");
		}else{
			for(int i=0;i<list.size();i++){
				String[] res = (String[])list.get(i);
%>
		<tr>
		<td><%=res[0] %></td><td>20000元</td><td>600元</td><td>200元</td><td>600元</td><td>21400</td>
		</tr>
<% 
			}
		}
%>