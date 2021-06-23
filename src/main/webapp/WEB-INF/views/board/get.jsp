<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags/board" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<my:navbar />
<div class="container">
	<h1>글 보기</h1>
	<hr>
	<div class="row">
		<div class="col-12">
			<form>
				<div class="form-group">
					<label for="input1">제목</label>
					<input id="input1" class="form-control" name="title" value="${board.title}" readonly>
				</div>
				<div class="form-group">
					<label for="textarea1">내용</label>
					<textarea id="textarea1" class="form-control" name="content" rows="5" readonly><c:out value="${board.content}" /></textarea>
				</div>
				<div class="form-group">
					<label for="input2">작성자</label>
					<input id="input2" class="form-control" name="writer" value="${board.writer}" readonly>
				</div>
				<hr>
				<a class="btn btn-secondary" href="${appRoot}/board/modify?bno=${board.bno}">수정/삭제</a>
			</form>
		</div>
	</div>
</div>
</body>
</html>