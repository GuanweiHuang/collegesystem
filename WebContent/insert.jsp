<%@page import="emtity.teachar"%>
<%@page import="emtity.stucourse"%>
<%@page import="dao.teacharDao"%>
<%@page import="emtity.TbClass"%>
<%@page import="service.StuService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.20.custom.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.20.custom.min.js"></script>
<script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>
<%
				//要先添加学生必须先找出所有人数未满的班级
				//然后才能为添加学生选择班级
				//先查询出未满人数的班级【人数<30】
				List clslist = new StuService().getNoFullClass();
				if(clslist==null||clslist.size()==0){
					out.print("<script>alert('班级已满,请重新选择!');location.href='index2.jsp';</script>");
				}

				//查询学生所读课程
				List courselist = new teacharDao().getstucourselist();
				
				//查询学生所读班级老师
				List tealist = new teacharDao().gettealist();
%>
<body onload="btn()">
<div id="myFrm" title="添加学生" style="display:none;font-size:14px;">
<form action="doAddStuServlet" method="post" align="left:300px;" onsubmit="return check()">
				学生学号:<input name="userNo"><br/>
				学生密码:<input name="userpwd"><br/>
				学生姓名:<input name="userName"><br/>
				学生年龄:<input name="userAge"><br/>
				学生性别:<input name="userSex" type="radio" value="男">男
					   <input name="userSex" type="radio" value="女">女<br/>
				学生地址:<input name="userAdd"><br/>
				学生电话:<input name="userPhone"><br/>
				出生年月:<input type="text" id="datepicker" name="userbirth"><br/>
				学生民族:<input name="usernation"><br/>
				政治面貌:<input name="userpolt"/><br/>
				所属课程:<select name="usercourse">
							<option value="">请选择课程</option>
							<%
								for(int i=0;i<courselist.size();i++){
									stucourse coursecls = (stucourse)courselist.get(i);
								
							%>
							<option value="<%=coursecls.getKno() %>"><%=coursecls.getCourname() %></option>
							<%
								}
							%>
					    </select><br/>
				所读班级:<select name="userClass">
							<option value="">请选择班级</option>
							<%
								for(int i=0;i<clslist.size();i++){
									TbClass cls = (TbClass)clslist.get(i);
								
							%>
							<option value="<%=cls.getCno() %>"><%=cls.getCname() %></option>
							<%
								}
							%>
					    </select><br/>
					 所属老师:<select name="userTea">
							<option value="">请选择老师</option>
							<%
								for(int i=0;i<tealist.size();i++){
									teachar tea = (teachar)tealist.get(i);
								
							%>
							<option value="<%=tea.getTno() %>"><%=tea.getTname() %></option>
							<%
								}
							%>
					    </select><br/>
				<input type="submit" value="添加学生" style="margin-top:5px;">
</form>
</div>
</body>
<script type="text/javascript">
$(function() {
	$( "#datepicker" ).datepicker({
		numberOfMonths: 1, //可以控制月份
		dateFormat:"yy-mm-dd",
		showOn: "button",
		buttonImage: "images/calendar.gif",
		buttonImageOnly: true
	});
});


function btn(){
		$("#myFrm").dialog("open");
}

$("#myFrm").dialog({
	autoOpen: false,
	show: "explode", //显示时增加百叶窗的效果
	hide: "blind",	//关闭时增加爆炸的效果
	modal: true,
	buttons:{
		"确定":function(){
			//关闭对话框
			$("#myFrm").dialog("close");
		},
		"取消":function(){
			$("#myFrm").dialog("close");
		}
	}
});

function check(){
	//获取表单元素的值
	var userno = $(":input[name=userNo]").val();
	var userpwd = $(":input[name=userpwd]").val();
	var userName = $(":input[name=userName]").val();
	var userAge = $(":input[name=userAge]").val();
	var userAdd = $(":input[name=userAdd]").val();
	var userbirth = $(":input[name=userbirth]").val();
	//对获取到的表单值做出判断
	if(userno==null||userno==''){
		alert("学号不能为空");
		return false;
	}
	if(userpwd==null||userpwd==''){
		alert("密码不能为空");
		return false;
	}
	if(userName==null||userName==''){
		alert("姓名不能为空");
		return false;
	}
	if(userAge<7){
		alert("您输入的年龄不符合");
		return false;
	}
	if(userAdd==null||userAdd==''){
		alert("请输入您的家庭地址");
		return false;
	}
	if(userbirth==null|userbirth==''){
		alert("请输入您的出生年月");
		return false;
	}
		return true;
}

</script>