<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
      <head>
            <title></title>
     
           <style>
              *{margin:0px;padding:0px;}
              body{background:url("img/bg.jpg") repeat;}
               #accordion{
                    width:1180px;
                    height:405px;
                    background-color:pink;
                }
               #accordion ul{
                    border:solid 1px blue;
                    position:relative;
                }
              #accordion ul li{
                    list-style-type:none;
                    border:solid 1px black;
                    height:405px;
                    width:106px;
                    overflow:hidden;
                    float:left;
                    background-color:#000;
                    position:relative;
                }
               #accordion ul li img{
                    width:538px;
                    height:405px;
                    opacity:0.5;
                }
               #accordion ul li .tm{
                     opacity:1;
                }
               #accordion ul .first{
                    width:538px;
                    height:
                }
               #accordion ul .last{
                     position:absolute;
                     top:0px;
                     right:0px;
                }
               #accordion ul .txt{
                      width:538px;
                      height:50px;
                      background-color:rgba(0,0,0,0.5);
                      position:absolute;
                      bottom:0px;
                      color:white;
                      text-align:center;
                }
           </style>
      </head>
      <body>
        <div id="accordion">
            <ul>
               <li class="first"><img src=images/11.jpg class="tm">
                     <div class="txt">
                     <h3>IT教育</h3>
                     <p>南方IT学院--给你不一样的人生</p>
                     </div>
               </li>
               <li><img src=images/12.jpg>
                     <div class="txt">
                     <h3>IT教育</h3>
                     <p>南方IT学院--给你不一样的人生</p>
                     </div>
               </li>
                <li><img src=images/13.jpg>
                    <div class="txt">
                     <h3>IT教育</h3>
                     <p>南方IT学院--给你不一样的人生</p>
                     </div>
                </li>
                <li><img src=images/14.jpg>
                   <div class="txt">
                     <h3>IT教育</h3>
                     <p>南方IT学院--给你不一样的人生</p>
                     </div>
                </li>
                <li><img src=images/15.jpg>
                     <div class="txt">
                     <h3>IT教育</h3>
                     <p>南方IT学院--给你不一样的人生</p>
                     </div>
                </li>
                <li><img src=images/16.jpg>
                    <div class="txt">
                     <h3>IT教育</h3>
                     <p>南方IT学院--给你不一样的人生</p>
                     </div>
                 </li>
                 <li class="last"><img src=images/17.jpg>
                     <div class="txt">
                     <h3>IT教育</h3>
                     <p>南方IT学院--给你不一样的人生</p>
                     </div>
                 </li>
            </ul>
        </div>
       
	<br/><span style="font-family:微软雅黑;line-height:2.2em">南方it教育学院（全称为 广东南方软件培训学院、广东南方职业培训学院 和 广东南方软件学院）创办于1997年，位于中国南端最具魅力的城市——珠海。</span>
	<span style="font-family:微软雅黑;line-height:2.2em">是珠三角乃至全国最具规模的高层次IT专业学院，目前拥有专业师资团队近200名，学院始终坚持以“打造核心竞争力，培育现代职业人”办学宗旨及“以市场为需求，以就业为导向”办学方向，专业专注于高端、精品IT人才培养、校企合作等。目前开设覆盖IT行业主流移动开发、移动电商、动漫游戏、4G物联网、云计算大数据、Android、IOS等专业及课程。学制两年，学生毕业将获得国家人力资源与社会保障部颁发的职业资格高级技能证书及学历文凭。</span>
      </body>
      <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
      <script type="text/javascript">
              $("#accordion ul li").hover(function(){
                     //当我们的鼠标经过li的时候添加一个css
 $(this).find("img").addClass("tm").parent().siblings().find("img").removeClass("tm");
                    //添加一个动画，当前图片显示538px其他的显示为106px
 $(this).stop().animate({width:538},300).siblings().stop().animate({width:106},300);
            })
      </script>