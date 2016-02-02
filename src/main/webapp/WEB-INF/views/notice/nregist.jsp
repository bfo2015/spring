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
						<h3 class="box-title">Regist</h3>
					</div>
					<!-- /.box-header -->

					<form role="form" method="post">
						<input type="hidden" name="mno" value="1">
						<div class="box-body">
							<div class="form-group">
								<label for="exampleInputEmail1">Title</label> <input type="text"
									name="title" class="form-control" placeholder="Input Title">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Content</label>
								<textarea class="form-control" name="content" rows="3"
									placeholder="Input Content"></textarea>
							</div>
							<div class="form-group">
								<label> <input type="radio" name="highlight"
									id="opt0" value="0" checked> None </label>
								<label> <input type="radio" name="highlight"
									id="opt1" value="1"> Highlight </label>
							</div>
						</div>
						<!-- box-body -->

						<div class="box-footer">
							<button type="submit" class="btn btn-primary">Regist</button>
						</div>
					</form>
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

</body>
</html>