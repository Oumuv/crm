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
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet">


</head>
<body>
	<div class="container page" style="">
		<div class="div-himg">
			<div class="himg" style="float: left;">
				<img alt="头像" style="width: 100%;" 
					src="<%=request.getContextPath()%>/images/headM.png">
			</div>
			<span id="title-nav" alt="标题"></span>
		</div>

		<div class="div-nav">
			<div class="div-nav-s" style="">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active navlist"><a
						class="btn-lg glyphicon glyphicon-home text-nav"><span
							class="text-nav"> Home</span></a></li>
					<li role="presentation" class="navlist"><a
						class="btn-lg glyphicon glyphicon-folder-open text-nav"><span
							class="text-nav"> Work</span></a></li>
					<li role="presentation" class="navlist"><a
						class="btn-lg glyphicon glyphicon-comment text-nav"><span
							class="text-nav"> Messages</span></a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

<script type="text/javascript">
	$(".navlist").click(function() {
		$(".navlist").removeClass("active");
		$(this).addClass("active");
		$("#title-nav").html($(this).find("span").html());
	});
</script>
</html>