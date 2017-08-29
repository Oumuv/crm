<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>CRM index</title>

<!-- Bootstrap -->
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link href="../css/style1.css">

<style>

.test{border: 1px red solid;}

body {
	margin: 0px;
	padding: 0px;
}

.page {
	width: 80%;
}

.himg {
	width: 100px;
	height: 100px;
	background-color: red;
	border-radius: 50%;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	overflow: hidden;
	box-shadow: 5px 5px 5px #C0C0C0;
}

.icon-nav {
	display: none;
}

.div-nav-s {
	float: left;
	margin-top: 50px;
	margin-left: 30px
}

.navlist {
	text-align: center;
}

.text-nav {
	cursor:pointer;
}

#title-nav {
	display: none;
}

.conten_div{
	width:100%;
	margin-top:110px;
}

@media screen and (max-width:910px) and (min-width:480px) {
	.page {
		width: 80%;
		min-width: 725px;
	}
}
@media screen and (max-width:480px) {
	.div-himg {
		position:fixed;
		width: 100%;
		height: 50px;
		background: #4f9fcf;
	}
	.himg {
		height: 40px;
		width: 40px;
		margin-left: 10px;
		box-shadow: 1px 1px 2px #000;
		/* 垂直居中 */
		position: relative;
		top: 50%;
		transform: translateY(-50%);
	}
	.page {
		position: fixed;
		top: 0px;
		margin: 0px;
		padding: 0px;
		width: 100%;
	/* 	display: flex;
		justify-content: center;
		align-items: center; */
	}
	.div-nav {
		position: fixed;
		bottom: 0px;
		width: 100%;
	}
	.icon-nav {
		width: 40px;
		height: 40px;
		display: block;
	}
	.div-nav-s {
		margin: 0px;
		padding: 0px;
		width: 100%;
	}
	.div-nav-s ul li {
		width: 33%;
	}
	.text-nav {
		display: none;
	}
	#title-nav {
		color: #fff;
		font-size: 18px;
		display: block;
		position: absolute;
		top: 25px;
		left: 50%;
		transform: translate(-50%, -50%);
	}
	.btn-uitl{
		position:fixed;
		display:none;
		width:40%;
		 border-radius: 5px;
		-moz-border-radius: 5px; 
		-webkit-border-radius: 5px;
		top:55px;
		left:1px;
		background:#E3E3E3;
		float:left;
	}
	.btn-uitl .btn{
		width:48%;
		margin:2px 0px 3px 0px;
		padding: 0px;
	}
	.btn-uitl .text-nav{
		display:block;	
	}
	.conten_div{
		width:97%;
		margin-top:50px;
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
					src="<%=request.getContextPath()%>/images/headM.png">
			</div>
			<span id="title-nav" style="">Home</span>
		</div>
		
		<!-- 工具按钮 -->
		<div class="btn-uitl " style="float:right;">
		 	<a class="btn  glyphicon glyphicon-cog" aria-hidden="true"><span class="text-nav">设置</span></a>
		 	<a class="btn  glyphicon glyphicon-log-out" aria-hidden="true" href="<%=request.getContextPath()%>/user/logout.do"><span class="text-nav">注销登录</span></a>
		</div>
		
		<!-- 主导航 -->
		<div class="div-nav test">
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
		<div class="conten_div  ss" style="">
			<iframe id="iframe_window" width="100%" src="<%=request.getContextPath()%>/jsp/user/home.jsp" frameborder="0" scrolling="auto">
				
			</iframe>
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
		$('#iframe_window').attr("src",$(this).attr("link-window"));
	});
	/*显示/隐藏工具栏*/
	function showbtn(){
		if(screen.width <= 480){
			  $(".btn-uitl").toggle(200);
		}
	}
	
</script>
</html>