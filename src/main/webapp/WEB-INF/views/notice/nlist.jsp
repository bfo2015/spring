<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->

	<!-- Main content -->
	<section class="content">
		<div class="row">

			<!-- left column -->
			<div class="col-md-12">

				<!-- general form elements -->
				<div class="box">
					<div class="box-header with-border">
						<h3 class="box-title">Notice</h3>
						<small> ${pageMaker.totalCount}</small>
					</div>
					<table class="table table-borderd">
						<tr>
							<th style="width: 10%">NO.</th>
							<th style="width: 55%">TITLE</th>
							<th style="width: 15%">Writer</th>
							<th style="width: 15%">Regdate</th>
							<th style="width: 5%">View</th>
						</tr>
						<c:forEach items="${list}" var="noticeVO">
						<tr style="background-color:${noticeVO.highlight == 1 ? '#FFFF8F' : 'none'}; font-weight:${noticeVO.highlight == 1 ? 'bold' : 'none'}">
							<td>${noticeVO.nno}</td>
							<td><a href="/notice/nview${pageMaker.makeSearch(pageMaker.cri.page)}&nno=${noticeVO.nno}">${noticeVO.title}</a></td>
							<td>${noticeVO.nickName}</td>
							<td><fmt:formatDate pattern="yy-MM-dd HH:mm" value="${noticeVO.regDate}" /></td>
							<td><span class="badge bg-red">${noticeVO.viewCnt}</span></td>
						</tr>
						</c:forEach>
					</table>

					<div class="text-center">
						<ul class="pagination">
							<c:if test="${pageMaker.prev}">
								<li><a href="/notice/nlist${pageMaker.makeSearch(pageMaker.startPage - 1)}">&laquo;</a></li>
							</c:if>
							<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
								<li
								<c:out value="${pageMaker.cri.page == idx?'class=active':''}"/>>
									<a href="/notice/nlist${pageMaker.makeSearch(idx)}"> ${idx}</a>
								</li>
							</c:forEach>
							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a href="/notice/nlist${pageMaker.makeSearch(pageMaker.endPage + 1)}">&raquo;</a></li>
							</c:if>
						</ul>
					</div>

					<div align="center">
						<button id="newBtn">Regist</button>
					</div>
					
					<!-- /.box-body -->
					<div class="box-footer"></div>
					<!-- /.box-footer -->
				</div>
				<!-- /.box -->
			</div>
			<!--/.col (left) -->
		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>

<script>
	$(document).ready(function() {
		$("#newBtn").on("click", function(evt) {
			self.location = "/notice/nregist";
		});
	});
</script>

</body>
</html>