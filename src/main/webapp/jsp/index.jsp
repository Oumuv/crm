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

<style>
body{
	margin:0px;
	padding: 0px;
}
.page{
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
.icon-nav{
	display:none;
}
.text-nav{
		display:block;
	}
@media screen and (max-width:480px){
	.div-himg{
		width:100%;
		height: 50px;
		background: #4f9fcf;
		
	}
	.himg {
		height: 40px;
		width:40px;
		margin-left:10px;
		box-shadow: 1px 1px 2px #000;
		/* 垂直居中 */
		position: relative;
		top:50%;
		transform:translateY(-50%);
	} 
	.page{
		margin:0px; padding: 0px;
		width:100%;
	}
	.div-nav{
		position:fixed;
		bottom:0px;
		width:100%;
	}
	.icon-nav{
		display:block;
	}
	.text-nav{
		display:none;
	}
}
</style>

</head>
<body>
	<div class="container page" style="">
		<div class="div-himg">
			<div class="himg" style="float: left;">
				<img alt="头像" style="width: 100%;"
					src="<%=request.getContextPath()%>/images/headM.png">
			</div>
		</div>

		<div class="div-nav">
			<div style="float: left; margin-top: 50px; margin-left: 30px">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><span class="glyphicon glyphicon-search icon-nav"></span><a class="text-nav" href="#">Home</a></li>
					<li role="presentation"><span class="glyphicon glyphicon-search icon-nav"></span><a class="text-nav" href="#">Work</a></li>
					<li role="presentation"><span class="glyphicon glyphicon-search icon-nav"></span><a class="text-nav" href="#">Messages</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</html>