<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>CRM login page</title>

<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<style>
	.index{
		width:50%;
		min-width:390px;
		}
	.lbtn{
		width:30%; min-width:80px;
	}
	.hmax{
		width:80%;
	}
	
	@media screen and (max-width:480px){
		.index{
			width:95%
		}
		.lbtn{
			width:100%;
			margin-top:10px;
			margin-bottom: 10px;
		}
		.hbtn{
			width:95%;
		}
		.hmax{
			width:100%;
		}
	}
</style>
</head>
<body>
	<!-- 登录界面 -->
	<div class="container control index" style="text-align: center; position: absolute;top: 45%;left: 50%;transform: translate(-50%, -50%);">
		<!-- 页头招呼语 -->
		<h1>Wellcome CRM!</h1>
		<p class="lead">Spring + SpringMVC + Mybatis integrated CRM
			system, using bootstrap, easyUI and other front-end tools drawing
			interface.</p>
		<p>
			<a class="btn btn-lg btn-success hbtn" style="max-width:380px" href="jsp/index.jsp" role="button">Log in and start to using</a>
		</p>
		<br>
		<!-- 登录框 -->
		<form action="user/login" method="post">
			<div class="container hmax" style="text-align: center">
			
				<div class="alert alert-danger alert-dismissible" style="display:none;" role="alert">
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  <strong>提示：</strong> 用户名不存在！
				</div>
			
				<div class="input-group">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">Username:</button>
					</span> <input type="text" name="username" class="form-control" placeholder="请输入用户名..">
				</div>
				<br>
				<!-- /input-group -->
				
				<div class="alert alert-danger alert-dismissible" style="display:none;" role="alert">
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  <strong>提示：</strong> 密码输入有误！
				</div>
				
				<div class="input-group">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">Password:</button>
					</span> <input type="text" name="password" class="form-control" placeholder="请输入密码..">
				</div>
				<!-- /input-group -->
				<br>
				<div class="container control" style="width: 80%; text-align: center">
					<input type="submit" class="btn btn-primary lbtn" value="Login" role="button"></input>
					<input type="reset" class="btn btn-danger lbtn" value="Reset" role="button"></input>
				</div>
				<br>
				<div class="container control" style="width: 80%;min-width:250px;text-align: center">
					<span>And you can <a>password retrieva</a><span> or </span>
					<a>register</a></span>
				</div>
			</div>
		</form>
	</div>
	
	
	
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>
