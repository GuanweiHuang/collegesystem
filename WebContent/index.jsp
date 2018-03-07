<%@page import="emtity.student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="Head1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理系统</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>

<script type="text/javascript" src="js/outlook2.js"></script>

<link rel="stylesheet" type="text/css" href="js/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css" />
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no" onload="startTime()">

<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div></noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        
        <% %>
       
        
        <span style="float:right; padding-right:20px;" class="head"> <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a></span>
        <span style="padding-left:10px; font-size: 16px; "><img src="images/blocks.gif" width="20" height="20" align="absmiddle" /> 南方IT学院</span>
    </div>
    <!-- <div region="south" split="true" style="height: 30px; background: #D2E0F2; "> -->
    <div region="south" split="true" style="height: 30px; background: green; ">
        <div class="footer">图书管理系统</div>
    </div>
    <div region="west" split="true" title="导航菜单" style="width:180px;" id="west">
		<div class="easyui-accordion" fit="true" border="false">
		<!--  导航内容 -->
				
		</div>

    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="padding:20px;overflow:hidden;background-image:url('images/index.jpeg');background-size:100%;" id="home">
					
					<c:forEach var="u" items="${userList }" varStatus="ids">
					<span style="font-family:微软雅黑;font-size: 38px;color:White">${u.sauthor }</span><span style="font-family:微软雅黑;font-size: 38px;color:White">学员欢迎您的登录</span>
					</c:forEach>
					<p id="time" style="font-family:微软雅黑;font-size: 38px;color:White">当前时间：<font color="white"><span id="nowDateTimeSpan" style="font-size:28px;"></span></font></p>
					
			</div>
		</div>
    </div>
    
    
    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;" >
                <table cellpadding=3>
                	<tr>
                        <td>原密码：</td>
                        <td><input id="txtPass"  type="password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="txtRePass" type="password" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="serverLogin()">
                    确定</a> <a class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)"
                        onclick="closeWindow()">取消</a>
            </div>
        </div>
    </div>

	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
	</div>


</body>
</html>


<script type="text/javascript">

	 var _menus = {"menus":[
						{"menuid":"1","icon":"icon-sys","menuname":"个人中心",
							"menus":[{"menuname":"我的信息","icon":"icon-nav","url":"AuthorServlet"},
									{"menuname":"班级信息","icon":"icon-add","url":"Class.jsp"},
									{"menuname":"公告栏","icon":"icon-users","url":"inform.jsp"},
									{"menuname":"学院通知","icon":"icon-role","url":"publicinform.jsp"},
									{"menuname":"短信息","icon":"icon-set","url":"suggest.jsp"}
								]
						},{"menuid":"8","icon":"icon-sys","menuname":"教务中心",
							"menus":[{"menuname":"课程学分","icon":"icon-nav","url":"xuefen.jsp"},
									{"menuname":"我的课程","icon":"icon-nav","url":"stucourse.jsp"}
									
								]
						},{"menuid":"56","icon":"icon-sys","menuname":"学习中心",
							"menus":[{"menuname":"资料下载","icon":"icon-nav","url":"http://www.baidu.com"},
									{"menuname":"学习历程","icon":"icon-nav","url":"sthrogh.jsp"}
								]
						},{"menuid":"28","icon":"icon-sys","menuname":"财政中心",
							"menus":[{"menuname":"我的财务","icon":"icon-nav","url":"money.jsp"}
								]
						},{"menuid":"39","icon":"icon-sys","menuname":"教学系统",
							"menus":[{"menuname":"学院介绍","icon":"icon-nav","url":"brief.jsp"}
								]
						}
				]};
        //设置修改密码窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 200,
                resizable:false
            });
        }
        //关闭修改密码窗口
        function closeWindow() {
        	$('#w').window('close');
        	
        }

       
        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass').val();
            var $rePass = $('#txtRePass').val();
            var $Pass=$('#txtPass').val();
            
            if ($Pass == '') {
                msgShow('系统提示', '请输入原密码！', 'warning');
                return false;
            }
            var Pwd=<%=session.getAttribute("userPwd")%>;
            if ($Pass != Pwd) {
                msgShow('系统提示', '密码不正确！请重新输入', 'warning');
                return false;
            }
            if ($newpass == '') {
                msgShow('系统提示', '请输入新密码！', 'warning');
                return false;
            }
            if ($newpass.length<6) {
                msgShow('系统提示', '密码长度不能小于6！', 'warning');
                return false;
            }
            if ($rePass == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }
            if ($newpass != $rePass) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }
            $.post("doUpdatePasswordServlet?opt=UpdateStu" ,"newpass="+$newpass, function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass;
                $rePass;
                close();
                setTimeout("location.href ='login.jsp'",2000);
                
            })
            
        }
		function mytime(){
			
		}
        $(function() {

            openPwd();
            //
            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEphttp://www.easygaokao.com/dataSearch.html?nav_1=sjcx&nav_2=zydq').click(function() {
                serverLogin();
            })
            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
                    if (r) {
                        location.href = 'login.jsp';
                    	//window.close();    
                    }
                });
            })	
        });
		
		//当前时间
		 
            function startTime()     
            {     
                var today=new Date();//定义日期对象     
                var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年      
                var MM = today.getMonth()+1;//通过日期对象的getMonth()方法返回年      
                var dd = today.getDate();//通过日期对象的getDate()方法返回年       
                var hh=today.getHours();//通过日期对象的getHours方法返回小时     
                var mm=today.getMinutes();//通过日期对象的getMinutes方法返回分钟     
                var ss=today.getSeconds();//通过日期对象的getSeconds方法返回秒     
                // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09     
                MM=checkTime(MM);  
                dd=checkTime(dd);  
                mm=checkTime(mm);     
                ss=checkTime(ss);      
                var day; //用于保存星期（getDay()方法得到星期编号）  
                if(today.getDay()==0)   day   =   "星期日 "   
                if(today.getDay()==1)   day   =   "星期一 "   
                if(today.getDay()==2)   day   =   "星期二 "   
                if(today.getDay()==3)   day   =   "星期三 "   
                if(today.getDay()==4)   day   =   "星期四 "   
                if(today.getDay()==5)   day   =   "星期五 "   
                if(today.getDay()==6)   day   =   "星期六 "   
                document.getElementById('nowDateTimeSpan').innerHTML=yyyy+"年-"+MM +"月-"+ dd +"日 " + hh+":"+mm+":"+ss+"   " + day;     
                setTimeout('startTime()',1000);//每一秒中重新加载startTime()方法   
            }     
              
            function checkTime(i)     
            {     
                if (i<10){  
                    i="0" + i;  
                }     
                  return i;  
            }    
       
 </script>









