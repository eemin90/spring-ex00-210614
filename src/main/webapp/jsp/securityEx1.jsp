<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<div class="container">
	<!-- Spring security test -->
	<div>
		<sec:authorize access="isAuthenticated()">
			<!-- 로그인 되어있을 때 principal은 CustomUser -->
			<sec:authentication property="principal" var="pinfo"/> <br>
			${pinfo.member.userid} <br>
			${pinfo.member.userpw} <br>
			${pinfo.member.userName} <br>
		</sec:authorize>
		
		<sec:authorize access="!isAuthenticated()">
			<!-- 로그인 안되어있을 때 principal은 String -->
			<sec:authentication property="principal" var="pinfo"/> <br>
			${pinfo} <br>
		</sec:authorize>
	</div>
</div>
</body>
</html>