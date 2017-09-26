<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>CRM login page</title>
<link rel="Shortcut Icon" href="<%=request.getContextPath()%>/images/headM.png" /> 

<!-- Bootstrap -->
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet">
<script>
	/* alert('${msg}'+'${user}'); */
</script>
<script type="text/javascript" src="http://tool.keleyi.com/ip/visitoriphost/"></script>
<style>
.index {
	width: 50%;
	min-width: 390px;
}

.lbtn {
	width: 30%;
	min-width: 80px;
}

.hmax {
	width: 80%;
}

@media screen and (max-width:480px) {
	.index {
		width: 95%
	}
	.lbtn {
		width: 100%;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	.hbtn {
		width: 95%;
	}
	.hmax {
		width: 100%;
	}
}
</style>
</head>
<body>
	<!-- 登录界面 -->
	<div class="container control index"
		style="text-align: center; position: absolute; top: 45%; left: 50%; transform: translate(-50%, -50%);">
		<!-- 页头招呼语 -->
		<h1>Wellcome CRM!</h1>
		<p class="lead">Spring + SpringMVC + Mybatis + Shiro integrated CRM
			system, using bootstrap, easyUI and other front-end tools drawing
			interface.</p>
		<p>
			<a class="btn btn-lg btn-success hbtn" style="max-width: 380px"
				href="jsp/index.jsp" role="button">Log in and start to using</a>
		</p>
		<br>
		<!-- 登录框 -->
		<form action="<%=request.getContextPath()%>/user/login.do" id="form-data" method="post">
			<span  id="keleyivisitorip"></span>
			<div class="container hmax" style="text-align: center">
				<!-- 提示框 -->
					<div id="tis-msg" class="alert alert-danger alert-dismissible" style="display:none"
						role="alert">
					</div>
				<input id="loginIp" type="text" name="loginIp" title="获取ip地址信息">
				<input id="address" type="text" name="address" title="获取地理位置信息">
				<div class="input-group">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" onfocus="$('#username_input').focus()">Username:</button>
					</span> 
					<c:choose>
						<c:when test="${!empty username }"><input id="username_input"  type="text" name="username" class="form-control"
						placeholder="请输入用户名.." value="${username }" onblur="check(this)"></c:when>
						<c:otherwise><input id="username_input" type="text" name="username" class="form-control"
						placeholder="请输入用户名.." onblur="check(this)"></c:otherwise>
					</c:choose>
					
				</div>
				<br>
				<!-- /input-group -->

				<c:if test="${!empty msg1}">
					<div class="alert alert-danger alert-dismissible" style=""
						role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<!-- 密码错误提示 -->
						<strong>提示：</strong> ${msg1 }
					</div>
				</c:if>

				<div class="input-group">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" onfocus="$('#password_input').focus()">Password:</button>
					</span> <input id="password_input" type="text" name="password" class="form-control"
						placeholder="请输入密码..">
				</div>
				<!-- /input-group -->
				<br>
				<div class="container control"
					style="width: 80%; text-align: center">
					<input type="submit" class="btn btn-primary lbtn" onclick="return submits()" value="Login"
						role="button"></input> <input type="reset"
						class="btn btn-danger lbtn" value="Reset" role="button"></input>
				</div>
				<br>
				<div class="container control"
					style="width: 80%; min-width: 250px; text-align: center">
					<span>And you can <a>retrieve password</a><span> or </span>
						<a>register</a></span>
				</div>
			</div>
		</form>
	</div>



	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
	
	<script type="text/javascript">
	
		/*验证用户是否存在*/
		function check(t){
			if($(".form-control").eq(0).val()==""){
				return false;
			}else{
			
				$.ajax({
					url:"<%=request.getContextPath()%>/user/check.do",
					data:{username:$(t).val()},
					type:'post',
					success:function(msg){
						if(msg.length>0){
							$("#tis-msg").show(200).html("<button type='button' class='close' data-dismiss='alert'aria-label='Close'><span aria-hidden='true'>&times;</span></button><!-- 用户不存在提示 --><strong>提示：</strong> "+msg);
						}else{
							$("#tis-msg").hide(200);
						}
					}
				});
 			}
		}
		
		/* 表单提交验证 */
		function submits(){
			if($(".form-control").eq(0).val()==""||$(".form-control").eq(1).val()==""){
				$("#tis-msg").empty();
				$("#tis-msg").show(200).html("<button type='button' class='close' data-dismiss='alert'aria-label='Close'><span aria-hidden='true'>&times;</span></button><!-- 用户不存在提示 --><strong>提示：</strong> 用户名密码不能为空！");
				return false;
			}
			return true;
		};
		
		$(".form-control").focus(function(){
			$(".alert").hide(200);
		});
	</script>
	
	<script type="text/javascript">
	// 偷偷地获取位置信息
	$(function() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(
						getPositionSuccess);
			} 
			console.log($('#keleyivisitorip').html());
			$('#loginIp').val(11);
	});
	
	function getPositionSuccess(position) {
		var latlon = position.coords.latitude+','+position.coords.longitude;  
		alert(latlon)
	    var url = "http://api.map.baidu.com/geocoder/v2/?ak=C93b5178d7a8ebdb830b9b557abce78b&callback=renderReverse&location="+latlon+"&output=json&pois=0";   
	    $.ajax({    
	        type: "GET",    
	        dataType: "jsonp",    
	        url: url,   
	        success: function (json) {    
	            if(json.status==0){   
	                $('#address').val(json.result.formatted_address);
	            }   
	        },   
	        error: function (XMLHttpRequest, textStatus, errorThrown) {    
	            alert("地址位置获取失败");    
	        }   
	    });   
	}


</script>
</body>
</html>
