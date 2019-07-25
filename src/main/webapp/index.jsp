<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>qilin</title>
<base href="<%=basePath%>">
<%@ include file="/tools/head.jsp"%>
<script type="text/javascript">


</script>
</head>
<body>
	<%@ include file="/tools/header.jsp"%>
	<div class="am-g am-g-fixed">
		<div class="am-u-md-9 am-u-md-push-3">
			<div class="am-g">
				<div class="am-u-sm-11 am-u-sm-centered">
					<div class="am-cf am-article">
						<!-- start -->



					</div>
					<hr />

				</div>
			</div>
		</div>
		<%@ include file="/tools/menu.jsp"%>
	</div>
	<%@ include file="/tools/footer.jsp"%>
</body>
</html>