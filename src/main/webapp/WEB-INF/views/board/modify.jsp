<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags/board" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>

<script>
	$(document).ready(function() {
		$('#board-remove-btn1').click(function(){
			var remove = '${appRoot}/board/remove';
			if (confirm("삭제 하시겠습니까?")) {
				$('#modify-form1').attr('action', remove);
				$('#modify-form1').submit();
			}
		});
		
		$("#file-remove-btn1").click(function() {
			var remove = "${appRoot}/board/fremove";
			if (confirm("파일을 삭제하시겠습니까?")) {
				$("#modify-form1").attr("action", remove);
				$("#modify-form1").submit();
			}
		});
	});
</script>

</head>
<body>
<my:navbar />
<div class="container">
	<h1>글 수정/삭제</h1>
	<hr>
	<div class="row">
		<div class="col-12">
			<form id="modify-form1" action="${appRoot}/board/modify" method="post" enctype="multipart/form-data">
				<input name="bno" value="${board.bno}" hidden />
				<div class="form-group">
					<label for="input1">제목</label>
					<input id="input1" class="form-control" name="title" value="${board.title}" />
				</div>
				<div class="form-group">
					<label for="textarea1">내용</label>
					<textarea id="textarea1" class="form-control" name="content" rows="5"><c:out value="${board.content}"/></textarea>
				</div>
				<c:if test="${not empty board.fileName}">
					<div class="form-group">
						<img class="img-fluid" src="${imgRoot}${board.bno}/${board.fileName}" />
					</div>
					<div class="form-group">
						<input id="file-remove-btn1" class="btn btn-outline-danger" type="button" value="파일 삭제" />
					</div>
				</c:if>
				<div class="form-group">
					<label for="input3">파일</label>
					<input type="file" id="input3" class="form-control" name="file" accept="image/*" />
				</div>
				<div class="form-group">
					<label for="input2">작성자</label>
					<input id="input2" class="form-control" name="writer" value="${board.writer}" hidden readonly />
					<input class="form-control" value="${board.writerName}" readonly />
				</div>
				
				<!-- controller의 modify로 post 방식으로 이동할 때 값을 전달 -->
				<input name="pageNum" value="${cri.pageNum}" hidden />
				<input name="amount" value="${cri.amount}" hidden />
				<input name="type" value="${cri.type}" hidden />
				<input name="keyword" value="${cri.keyword}" hidden />
				
				<hr>
				<input class="btn btn-secondary" type="submit" value="수정" />
				<input id="board-remove-btn1" class="btn btn-danger" type="button" value="삭제" />
			</form>
		</div>
	</div>
</div>
</body>
</html>