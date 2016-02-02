<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<!------------------------------ Main content -------------------------------->

<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
                    내가 만든 투표
      <small>preview sample</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
      <li><a href="#">Charts</a></li>
      <li class="active">Flot</li>
    </ol>
  </section>

<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">

			<!-- general from elements -->
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">수정 페이지</h3>

					<form role="form" method="post">

					  <input type="hidden" name="page" value="${cri.page}">
					  <input type="hidden" name="perPageNum" value="${cri.perPageNum }">
					  <input type="hidden" name="searchType" value="${cri.searchType }">
					  <input type="hidden" name="keyword" value="${cri.keyword }">
					  <input type="hidden" name="qnano" value="${VO.qnano }">
					  
						<div class="box-body">
							
							<div class="form-group">
								<label for="exampleInputEmail1">Q&A번호</label> 
								<input type="text" name="qnano" class="form-control" value="${VO.qnano }" readonly="readonly">
							</div>
							
							
							<div class="form-group">
								<label for="exampleInputEmail1">Title</label> 
								<input type="text"
									name="title" class="form-control" value="${VO.title }">
							</div>
							
							
							<div class="form-group">
								<label for="exampleInputPassword1">Content</label>
								<textarea class="form-control" name="content" rows="3"> ${VO.content}</textarea>
							</div>
							
							
							<div class="form-group">
								<label for="exampleInputEmail1">Writer</label> <input type="text"
									name="nickname" class="form-control" value="${VO.nickname}" readonly="readonly">
							</div>
							
							<div class="form-group">
						    <label for="pwd">비밀번호(숫자)</label>
						    <input type="password" class="form-control" id="pwd" name="pw" value="${VO.pw}">
						  </div>

						</div>
						
						<div class="box-footer">
						<button type="submit" class="btn btn-primary"> 저장 </button>
						<button type="submit" class="btn btn-warning"> 취소 </button>
						
						</div>


					</form>




				</div>

			</div>

		</div>
		<!-- /.col(left) -->

	</div>
	<!-- /.row -->

</section>
<!-- /.content -->

</div>

<%@include file="../include/footer.jsp"%>
<script>

	console.log("${cri.page}");

	$(document).ready(function(){
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		$(".btn-warning").on("click", function() {
			//self.location = "/board/list";
			formObj.attr("method", "get");
			formObj.attr("action", "/qna/view?qnano=${VO.qnano}");
			formObj.submit();

		});
		
		
		$(".btn-primary").on("click",function(){
			
			formObj.submit();
			
		});
		
	});
	
	
</script>
</body>
</html>