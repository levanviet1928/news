<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<!-- Bootstrap core CSS -->
<link
	href="<c:url value= '/template/web/bootstrap/css/bootstrap.min.css' /> "
	rel="stylesheet">
<link href="<c:url value = '/template/web/css/shop-homepage.css' />"
	rel="stylesheet">

</head>
<body>
	<!-- header -->
	<%@include file="/common/web/header.jsp"%>
	<!-- header -->

	<dec:body />


	<!-- footer -->
	<%@include file="/common/web/footer.jsp"%>
	<!-- footer -->
	<script type="text/javascript"
		src=" <c:url value=' vendor/jquery/jquery.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value = 'vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

</body>
</html>