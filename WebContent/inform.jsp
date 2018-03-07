<%@page import="emtity.SMS"%>
<%@page import="dao.teacharDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<%
		List list = new teacharDao().getSMSlist();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="images/bg1.jpg" style="opacity:0.1;width:100%;height:490px;position:absolute">
<table style="margin:auto;"  class="table table-striped table-bordered table-hover">
		<%
				if(list==null&&list.size()==0){
					out.println("<tr><td colspan='2'>没有任何短消息</td></tr>");
				}else{
					//有数据
					for(int i=0;i<list.size();i++){
						SMS sms = (SMS)list.get(i);
		%>
		<tr>
		<td>内容</td><td><%=sms.getMname() %></td><td>发布时间</td><td><%=sms.getMtime() %></td>
		</tr>
		<% 
					}
				}
		%>

</table>


</body>
</html>