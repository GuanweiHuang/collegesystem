<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>


<img src="images/bg1.jpg" style="opacity:0.3;width:100%;height:490px;position:absolute">
<h2 align="center">我的职称</h2>
<table border="1"  class="table table-striped table-bordered table-hover">
		<tr>
		<td>教师名称</td><td>教师等级</td><td>荣誉证书</td>
 		</tr>
 		
     <c:forEach var="t" items="${tearole}" >
		<tr>
		<td>${t.troname}</td><td>${t.trole}</td><td><img src="${t.troimages}"></td>
		</tr>
 		</c:forEach>
</table>
 		
 		

    