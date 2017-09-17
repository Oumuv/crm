<%@ page language="java" import="java.util.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>CRM index</title>

<!-- Bootstrap -->
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet">

<style>
.test {
	border: 1px red solid;
}

html {
	top: 0px;
	bottom: 0px;
	height: 100%;
}

body {
	top: 0px;
	bottom: 0px;
	margin: 0px;
	padding: 0px;
	height: 100%;
}

.page {
	top: 0px;
	bottom: 0px;
	width: 80%;
	height: 100%;
}

.conten_div {
	
}

@media screen and (max-width:910px) and (min-width:480px) {
}

@media screen and (max-width:480px) {
	.page {
		position: fixed;
		top: 0px;
		margin: 0px;
		padding: 0px;
		width: 100%;
	}
	.div-nav-s ul li {
		width: 33%;
	}
	.btn-uitl .btn {
		width: 48%;
		margin: 2px 0px 3px 0px;
		padding: 0px;
	}
	.btn-uitl .text-nav {
		display: block;
	}
	.conten_div {
		width: 100%;
		margin-top: 50px;
	}
}
</style>

</head>
<body>
	<div class="container page test">
		<!-- 头像框 -->
		<div class="div-himg" onclick="showbtn()">
			<div class="himg" style="float: left;">
				<img alt="头像" style="width: 100%;"
					src="<%=request.getContextPath()%>${user.himg}">
			</div>
			<span id="title-nav" style="">Home</span>
		</div>
		
		<!-- 工具按钮 -->
		<div class="btn-uitl " style="float:right;">
		 	<a class="btn  glyphicon glyphicon-cog" aria-hidden="true"><span class="text-nav">设置</span></a>
		 	<a class="btn  glyphicon glyphicon-log-out" aria-hidden="true" href="<%=request.getContextPath()%>/user/logout.do"><span class="text-nav">注销登录</span></a>
		</div>
		
		<!-- 主导航 -->
		<div class="div-nav ">
			<div class="div-nav-s" style="">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active navlist btn_nav" link-window="user/home.jsp"><a
						class="btn-lg glyphicon glyphicon-home text-nav"><span
							class="text-nav" > Home</span></a></li>
					<li role="presentation" class="navlist btn_nav" link-window="msg/msg.jsp"><a
						class="btn-lg glyphicon glyphicon-folder-open text-nav"><span
							class="text-nav" > Work</span></a></li>
					<li role="presentation" class="navlist btn_nav" link-window="word/word.jsp"><a
						class="btn-lg glyphicon glyphicon-comment text-nav"><span
							class="text-nav" > Messages</span></a></li>
				</ul>
			</div>
		</div>
		
		<!-- 内容 -->
		<div class="test conten_div  " style="">
<!-- 		<iframe id="iframe_window" width="100%" height="100%" src="" frameborder="0" scrolling="auto"> -->
<!-- 		</iframe> -->
<%-- 		<%@ include file=""%> --%>
<%-- 			<jsp:include page='/jsp/user/home.jsp' flush='true'/> --%>
		<%@ include file="/jsp/user/home1.jsp" %>
		</div>
		<div class="footer"style="background:red;position:absolute;bottom: 0px;width:100%;height:50px;">
			
		</div>
	</div>
</body>

<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

<script type="text/javascript">
	/*点击主导航栏切换页面 */
	$(".navlist").click(function() {
		$(".navlist").removeClass("active");
		$(this).addClass("active");
		$("#title-nav").html($(this).find("span").html());
		var html="/mycrm/jsp/"+$(this).attr('link-window');
// 		$('.conten_div').load("/mycrm/jsp/"+$(this).attr('link-window'));
$.ajax(
		
		);
		
<%-- 		$('#iframe_window').attr("src","<%=request.getContextPath()%>/jsp/"+$(this).attr("link-window")); --%>
	});
	/*显示/隐藏工具栏*/
	function showbtn(){
		if(screen.width <= 480){
			  $(".btn-uitl").toggle(200);
		}
	}
	
</script>
</html>