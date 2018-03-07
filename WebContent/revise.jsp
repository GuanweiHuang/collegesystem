<%@page import="dao.teacharDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<%
			String classname =(String)session.getAttribute("name");
			List list = new teacharDao().getbanjilist(classname);
%>
<h2 align="center">班级学生列表</h2>
<table border="1" class="table table-striped table-bordered table-hover" id="mytab">
			<tr>
			<td>编号</td><td>姓名</td><td>性别</td><td>年龄</td><td>地址</td>
			<td>电话号码</td><td>民族</td><td>政治面貌</td><td colspan='2' style="text-align:center">操作</td>
			</tr>
		<%
				if(list==null||list.size()==0){
					out.print("<tr><td colspan='9'>没有任何数据显示</td></tr>");
				}else{
					for(int i=0;i<list.size();i++){
						String res[]=(String[])list.get(i);
		%>
			<tr>
			<td><%=res[0] %></td><td><%=res[1] %></td><td><%=res[2] %></td>
			<td><%=res[3] %></td><td><%=res[4] %></td>
			<td><%=res[5] %></td><td><%=res[6] %></td><td><%=res[7] %></td>
			<td><a href="javascript:updateStu('<%=res[0]%>')">修改</a></td>
			<td><a href="javascript:deleteStu('<%=res[0]%>')">删除</a></td>
			</tr>	
		<%
					}
				}
		%>
</table>

<div id="frmDiv" style="position: absolute;top:10%;left:35%;background-color:rgb(224,236,225);width:300px;height:300px;display:none">
	 	<h2>修改学生信息列表</h2>
	 	<form action="" id="addFrm">
	 		<table>
	 			<tr>
	 				<td colspan="2"><input type="hidden" name="sno"></td>
	 			</tr>
	 			<tr>
	 				<td>姓名:</td><td><input name="sauthor"></td>
	 			</tr>
	 			<tr>
	 				<td>性别:</td><td><input name="ssex"></td>
	 			</tr>
	 			<tr>
	 				<td>年龄:</td><td><input name="sage"></td>
	 			</tr>
	 			<tr>
	 				<td>地址:</td><td><input name="saddresss"></td>
	 			</tr>
	 			<tr>
	 				<td>电话号码:</td><td><input name="sphone"></td>
	 			</tr>
	 			<tr>
	 				<td>民族:</td><td><input name="sNation"></td>
	 			</tr>
	 			<tr>
	 				<td>政治面貌:</td><td><input name="spolitic"></td>
	 			</tr>
	 			</table>
	 			<br/>
	 				<input type="button" value="修改学生" onclick="doUpdateStu()" style="width:120px;" >
	 				<input type="button" value="放弃操作" onclick="doExit()" style="width:120px;">
	 	</form>
	 </div>
<script type="text/javascript">
	function updateStu(id){
		//点击修改，打开修改学生的层,
		$("#frmDiv").slideDown(800);
		//异步查询出要修改的学生详细信息并绑定到表单中
		$.get("UpdateStuServlet?opt=stuBySauthor","sno="+id,function(data){
			$("input[name=sno]").val(data.sno);
			$("input[name=sauthor]").val(data.sauthor);
			$("input[name=ssex]").val(data.ssex);
			$("input[name=sage]").val(data.sage);
			$("input[name=saddresss]").val(data.saddresss);
			$("input[name=sphone]").val(data.sphone);
			$("input[name=sNation]").val(data.sNation);
			$("input[name=spolitic]").val(data.spolitic);
		},"JSON");
	}
	//执行修改
	function doUpdateStu(){
		//表单序列化
		var param=$("#addFrm").serialize();
		$.post("UpdateStuServlet?opt=updateStu",param,function(data){
			if(data==1){
				$("#frmDiv").prepend("<span>修改学生成功!</span>");
				doExit();//关闭
			}else{
				$("#frmDiv").prepend("<span>修改学生失败!</span>");
			}
		});
	}
	//关闭添加学生的层
	function doExit(){
		$("#frmDiv").slideUp(800);
	}
	
	function deleteStu(sno){
		$.get("UpdateStuServlet?opt=deleteStu","&sno="+sno,function(data){
			if(confirm('你确定要删除吗')){
			if(data==1){
				alert("删除成功");
				//删除成功后刷新页面
				location.reload();
			}else{
				alert("删除失败");
			}	
			}
		});
		}
</script>
			