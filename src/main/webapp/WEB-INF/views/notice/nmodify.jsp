<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
				<div class="box box-primary">
					<div class="box-header">
						<h3 class="box-title">Notice Modify</h3>
					</div>
					<!-- /.box-header -->

					<form role="form" action="nmodify" method="post">
						<input type="hidden" name="nno" value="${noticeVO.nno}">
						<input type="hidden" name="mno" value="${noticeVO.mno}">
						<input type="hidden" name="page" value="${cri.page}"> 
						<input type="hidden" name="perPageNum" value="${cri.perPageNum}">

						<div class="box-body">
							<div class="form-group">
								<label for="exampleInputEmail1">Title</label> <input type="text"
									name='title' class="form-control" value="${noticeVO.title}">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Content</label>
								<textarea id="textarea" class="form-control" name="content" rows="3">${noticeVO.content}</textarea>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Writer</label> <input type="text"
									name="nickName" class="form-control"
									value="${noticeVO.nickName}" readonly="readonly">
							</div>
							<div class="form-group">
								<label> <input type="radio" name="highlight" id="opt0" value="0" > None </label>
								<label> <input type="radio" name="highlight" id="opt1" value="1"> Highlight </label>
							</div>
						</div>
						<!-- /.box-body -->
					</form>

					<div class="box-footer">
						<button type="submit" class="btn btn-primary">SAVE</button>
						<button type="submit" class="btn btn-warning">CANCEL</button>
					</div>

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
						
		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-warning").on("click", function() {
			self.location = "/notice/nlist?page=${cri.page}&perPageNum=${cri.perPageNum}";
		});

		$(".btn-primary").on("click", function() {
			formObj.attr("action", "/notice/nmodify");
			formObj.attr("method", "post");
			formObj.submit();
		});
		
		if ("${noticeVO.highlight}" == 0) {
			$("#opt0").attr("checked", true);
		} else {
			$("#opt1").attr("checked", true);
		}
		
		$("#textarea").wysihtml5();
	});
</script>

</body>
</html>