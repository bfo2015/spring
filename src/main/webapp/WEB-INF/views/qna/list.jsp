<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../include/header.jsp" %>
    
    
    
 <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->


        <!-- Main content -->
        <section class="content">
            <div class="row">

                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Q&A</h3>
                            <div class="box-tools pull-right">
                                <div class="has-feedback">
                                    <input type="text" class="form-control input-sm" placeholder="Search Mail">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </div><!-- /.box-tools -->
                        </div><!-- /.box-header -->
                        <div class="box-body no-padding">
                            
                            <div class="table-responsive mailbox-messages">
                                <table class="table table-hover table-striped">

                                    <thead>
                                    <tr>
                                        
                                        <th>No</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>공개여부</th>
                                        <th>등록일자</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach items="${list}" var="list">
                                    <tr class="basic-table">
                                       
                                        <td>${list.qnano }</td>
                                        <td class="mailbox-name"><a href="/qna/view${pageMaker.makeSearch(cri.page)}&qnano=${list.qnano }">${list.title }</a></td>
                                        <td>${list.nickname }</td>
                                        <td>
                                        
                                        <c:choose>
											 <c:when test="${list.pw==null}">
											        <i class="fa  fa-unlock"></i>
											        <br />
											 </c:when>    
											 <c:when test="${list.pw!=null}">
											        <i class="fa  fa-lock"></i>
											        <br />
											 </c:when>
									
										</c:choose>
                                        
                                        
                                        </td>
                                        <td><fmt:formatDate value="${list.updateDate}" pattern="yyyy-MM-dd"/></td>
                                        
                                        </td>
                                    </tr>
                                    
                                    </c:forEach>
                                    
                                    <!-- <tr>
                                        <td><input type="checkbox"></td>
                                       <td>000</td>
                                        <td class="mailbox-subject"><b>방송</b></td>                                       
                                        <td class="mailbox-name"><a href="read-mail.html">오늘 가장 재밌던 프로그램은?</a></td>
                                        <td>12</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td>2015-12-20</td>
                                        <td><span class="label label-success">마감</span></td>
                                    </tr> -->
                                    
                                    </tbody>
                                </table><!-- /.table -->
                                
                                
                            </div><!-- /.mail-box-messages -->
                        </div><!-- /.box-body -->

                        
                        <div class="text-center">
						<div class="pagination">

							<c:if test="${pageMaker.prev }">
								<li>
								
								<a
									href="/qna/list${pageMaker.makeSearch(pageMaker.startPage-1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="paging">
								<li
									<c:out value="${cri.page==paging?'class=active':'' }"/>>
									<a href="/qna/list${pageMaker.makeSearch(paging) }">${paging }</a>
								</li>

							</c:forEach>


							<c:if test="${pageMaker.next }">
								<li><a
									href="/qna/list${pageMaker.makeSearch(pageMaker.endPage+1) }">&raquo;</a></li>
							</c:if>


						</div>

					<div >
					
						<button type="submit" class="btn btn-info" id="create-Btn"> Q&A글쓰기</button>
                        
                    </div><!-- /.info-box -->
                    
					</div>
                        
                        
                    </div><!-- /. box -->
                </div><!-- /.col -->



				<!-- 페이징할라고... -->
				
				
                        




                

            </div><!-- /.row -->




        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->


<!-- Page Script -->
<script>

	var str ='${msg}';
	
	if(str == "REGIST"){
		alert("등록되었습니다 ");
	}
	else if(str =="DELETE"){
		alert("삭제되었습니다");
	}


	$(document).ready(function(){
		
		
        console.log('${pageMaker.cri.page}');
        console.log('${pageMaker.cri.perPageNum}'); 
		
		$('#create-Btn').on("click",function(event){
        	console.log("등록페이지 갈라고 자스")
        	event.preventDefault();
        	self.location="/qna/regist";
        	
        });
		
	});


    $(function () {
        //Enable iCheck plugin for checkboxes
        //iCheck for checkbox and radio inputs
        $('.mailbox-messages input[type="checkbox"]').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });

        
        
        
        
        
        //Enable check and uncheck all functionality
        $(".checkbox-toggle").click(function () {
            var clicks = $(this).data('clicks');
            if (clicks) {
                //Uncheck all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
            } else {
                //Check all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("check");
                $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
            }
            $(this).data("clicks", !clicks);
        });

        
        
        
        
        
        $('#trash').on("click",function(event){
        	event.preventDefault();
        	alert("쓰헤기통 눌러떠"); 
        	
        	 var num = $('.mailbox-messages input[type="checkbox"]:checked').length;
        	 
        	 console.log("num: "+num);
        	 
        	 var value = $('.mailbox-messages input[type="checkbox"]:checked');
        	 
        	 console.log("되는거니");
        	 
        	 var arr = new Array();
        	 
        	 for(var i=0;i<num;i++){
        		 console.log("for루프 되는거니2");
        		 var target = value.val();
        		 console.log(value);
        		 
        		 var target = value[i];
        		 
        		console.log(target);
        	 
        		var real = target.value;
        		
        		console.log(real);
        		
        		arr[i]=real;
        	 }
        	 
        	 console.log(arr);
        	 
        	 $.ajax({
        		 
        		 type:'post',
        		 url:'/test/removes',
        		 headers:{
        			 "Content-Type":"application/json",
        			 "X-HTTP-Method-Override":"POST"
        		 },
        		 data:JSON.stringify({
        			 length:num,
        			 arr:arr
        		 })
        		
        	 });
        	 
        });
        
        
    });





</script> 

<%@include file="../include/footer.jsp" %>
  </body>
</html>