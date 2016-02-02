<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>


<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
   <!-- Content Header (Page header) -->
   <section class="content-header">
      <h1>
         General Form Elements <small>Preview</small>
      </h1>
      <ol class="breadcrumb">
         <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
         <li><a href="#">Forms</a></li>
         <li class="active">General Elements</li>
      </ol>
   </section>

   <!-- Main content -->
   <section class="content">
      <div class="row">

         <!-- left column -->
         <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">
               <div class="box-header with-border">
                  <h3 class="box-title">Q&A페이지</h3>
               </div>
               <!-- /.box-header -->
               <!-- form start -->
               <form role="form" action="/qna/regist" method="post">
                  
         
                  <div class="box-body">
                     <div class="form-group">
                        <label>제목</label> <input type="text" class="form-control" name="title"
                           placeholder="제목...">
                     </div>
                     <div class="form-group">
                        <label>내용</label>
                        <textarea class="form-control" rows="3" name="content" placeholder="내용을 입력하세요"></textarea>
                     </div>
					<div class="form-group">
					    <label for="pwd">비밀번호(숫자)</label>
					    <input type="password" class="form-control" id="pwd" name="pw">
					  </div>
                     <div class="form-group">
                        <label>작성자</label> <input type="text" class="form-control" name="mno"
                           placeholder="mno">
                     </div>
                     
                     <div class="form-group">
                        <label for="exampleInputFile">파일첨부</label> <input type="file"
                           id="exampleInputFile">
                     </div>
                  </div>
                  <!-- /.box-body -->

                  
                  
                  <div class="box-footer">
                     <button class="btn btn-default" id="cancleBtn">Cancel</button>
                     <button type="submit" id="registBtn"
                        class="btn btn-info pull-right">등록하기</button>
                  </div>
                  <!-- /.box-body -->
               </form>
            </div>
            <!-- /.box -->
         </div>
         <!--/.col (right) -->
      </div>
      <!-- /.row -->
   </section>
   <!-- /.content -->
</div>
<!-- /.content-wrapper -->


 <script>
   $(document).ready(function(){
      var formObj = $("form[role='form']");
      
      console.log(formObj);
      
       /* $("#cancleBtn").on("click",function(){
    	   
    	   console.log("취소할라고");
         self.location = "/qna/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
               + "&searchType=${cri.searchType}&keyword=${cri.keyword}";
      });  */
      
      $("#cancleBtn").on("click", function() {
			//self.location = "/board/list";
			formObj.attr("method", "get");
			formObj.attr("action", "/qna/list");
			formObj.submit();

		});
      
      
      
      $("#registBtn").on("click",function(){
         formObj.submit();
      });      
   });
</script> 





<%@include file="../include/footer.jsp"%>

</body>
</html>