<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags/board"%>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp"%>

<title>Insert title here</title>

<script>
	$(document).ready(function() {
		if (history.state == null) {
			$('#modal1').modal('show');
			history.replaceState({}, null);
		}
	});
</script>

</head>
<body>
<my:navbar />
<div class="container">
	<h1>글 목록</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
				<th>수정일시</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.bno}</td>
					<td>
						<a href="${appRoot}/board/get?bno=${board.bno}">${board.title}</a>
					</td>
					<td>${board.writer}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.regdate}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.updateDate}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<c:choose>
	<c:when test="${not empty result}">
		<!-- Modal -->
		<div class="modal fade" id="modal1" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="modal1Label" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modal1Label">알림</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">${result}번 글이 등록되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:when>
	<c:when test="${not empty modify}">
		<!-- Modal -->
		<div class="modal fade" id="modal1" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="modal1Label" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modal1Label">알림</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">${modify}번 글이 수정되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
		</c:when>
	<c:when test="${not empty remove}">
		<!-- Modal -->
		<div class="modal fade" id="modal1" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="modal1Label" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modal1Label">알림</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">${remove.bno}번 글이 삭제되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:when>
</c:choose>

</body>
</html>