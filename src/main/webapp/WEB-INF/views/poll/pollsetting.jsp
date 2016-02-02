<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	
	<form role="form" method="post" action="/poll/pollsetting">
	
	<input type="hidden" value="${newPno }" name="pno"> 
	<input type="hidden" value="${login.mno }" name="mno"> 
	
	<section class="content">
	
		<div class="row">
			<div class="col-md-12">
				<div class="box box-info">
					<div class="box-header">
						<h3 class="box-title">
							설정하기 <small>투표 설정을 잡으세요</small>
						</h3>
						
					</div>
					<!-- /.box-header -->

					<div class="box-body">
						
						<!-- ----------------------------------------- -->
				
						
						
					
						<div class="form-group" id="categoryDiv">
						<label>카테고리</label> 
						 <select name="categoryCode" class="form-control select1" id="caSelect">
						
					 		 <c:forEach items="${categoryList}" var="ca">
								<option value="${ca.categoryCode }" 
								<c:out value="${settings.categoryCode eq ca.categoryCode? 'selected':'' }"/>>
								${ca.categoryName}</option>
									
							 </c:forEach>  						
											
							</select>
								
						</div>
						<!-- /.form-group -->

						<div class="form-group" id="answerType">
							<label>투표형식</label>
							<div class="radio">
								<label> <input type="radio" name="answerCode" id="multiple"
									value="answer1" <c:out value="${settings.answerCode eq 'answer1'? 'checked':'' }"/>> 선다형
								</label> <label> <input type="checkbox" name="multiOpt"
									id="multiCheck" value="t" disabled > 다중선택
								</label> <label> <input type="radio" name="answerCode" id="ox"
									 value="answer2" <c:out value="${settings.answerCode eq 'answer2'? 'checked':'' }"/>> 찬반형
								</label> <label> <input type="radio" name="answerCode" id="short"
									 value="answer4" <c:out value="${settings.answerCode eq 'answer4'? 'checked':'' }"/>> 문답형
								</label> <label> <input type="radio" name="answerCode" id="long"
									 value="answer5" <c:out value="${settings.answerCode eq 'answer5'? 'checked':'' }"/>> 서술형
								</label>
							</div>
						</div>
						<!--------------------------------------------------------------------------------------------------------------------------------------------------------------->

						<div class="form-group">
							<label>예약 설정</label>
							<div class="form-group">
                       <label>시작일시</label>
                        <div class="input-group" style="width: 100%">
                            <div class="input-group-addon">
                                 <i class="fa fa-clock-o"></i>
                              </div>
                            <input type="text" class="form-control pull-right" id="datetimepicker" name="startDate">
                        </div>
                    </div>

                    <div class="form-group">
                       <label>종료일시</label>
                        <div class="input-group" style="width: 100%">
                           <div class="input-group-addon">
                                  <i class="fa fa-clock-o"></i>
                              </div>
                            <input type="text" class="form-control pull-right" id="datetimepickerend" name="endDate">
                        </div>
                    </div>
							<!--<div id="popedOpt1" style="display:none">-->
							<!--<label>기간설정</label>-->
							<!--<select  >-->
							<!--<option selected="selected">&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;</option>-->
							<!--<option>30분</option>-->
							<!--<option>1시간</option>-->
							<!--<option>6시간</option>-->
							<!--<option>하 루</option>-->
							<!--<option>1 주일</option>-->
							<!--<option>보 름</option>-->
							<!--<option>1 달</option>-->

							<!--</select>-->
				

							
						</div>
						
						
						
						
					

						<div class="form-group">
							<label>공개 여부</label>
							<div class="radio">

								<label> <input type="radio" name="publicCode" id="unsecretPoll"
									value="public1" <c:out value="${settings.publicCode eq 'public1'? 'checked':'' }"/>> 공개
								</label> 
								
								<label> <input type="radio" name="publicCode" id="secretPoll"
									 value="public2" <c:out value="${settings.publicCode eq 'public2'? 'checked':'' }"/>> 비공개
								</label> 
								
								<label> <input type="password" id="publicPw"
									name="pollPw" placeholder="enter password" disabled>

								</label>

							</div>

						</div>

						<div class="form-group">
							<label>로그인 여부</label>
							<div class="radio">
								<label> <input type="radio" name="loginCode"
									value="login2" <c:out value="${settings.loginCode eq 'login2'? 'checked':'' }"/>> 회원만
								</label> <label> <input type="radio" name="loginCode"
									value="login1" <c:out value="${settings.loginCode eq 'login1'? 'checked':'' }"/>> 전체
								</label>

							</div>

						</div>

						<div class="box-footer">
									<a href="/poll/list"><button type="button" class="btn btn-default">Cancel</button></a>
									<button type="submit" id="registBtn"
										class="btn btn-info pull-right">Next</button>
						</div>
						
						
						
						<!-- --------------------------------------- -->


					</div>
					<!-- /.box-body -->

				</div>
				<!-- /.box -->

			</div>
			<!-- /.col-->
		</div>
		<!-- ./row -->
	</section>
	
	</form>


</div>
<%@include file="../include/footer.jsp"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>




<script>

	$(document).ready(function(){
		
	

	var pno = "${settings.pno}";
	var timePop = $("#dateRange");
	var peoplePop = $("#popedOpt2");
	var peopleInput = $("#peopleInput");
	
	
	
	var cate = "${settings.categoryCode}";
	console.log("cate:"+cate);
	
	//=================================================================================

	
	
		
	console.log(cate);
	
	var cno = cate.substring(8);
	
	
	
	$("#caSelect").change(function() {
		
		var caCode = $("#caSelect option:selected").val();

		console.log(caCode);
		
		var pno = caCode.substring(8);
		
		console.log(pno);
		
		if(pno != 8){
		$.getJSON("/poll/getsetting/" + pno, function(data) {
			
			console.log("바뀐: "+data);

			console.log("바뀐: "+data.categoryCode);

			console.log("바뀐: "+data.answerCode);
			
			
			checked(data);
			   
	       
		});
		}
		else{
			console.log(pno);
			
			$.getJSON("/poll/getsetting/" + pno, function(data) {
			selfChecked(data);
			
			});
		}
		
		
	});	
		
	var selfChecked = function(vo){
		
		
		var radio = document.getElementsByClassName("radio");
		
		console.log(radio)
		
		var input=$(".radio").find("input");
		
		console.log(input);
		
		for (var i = 0; i < input.length; i++) {
			console.log(input[i]);
			if(input[i].checked){
				console.log(input[i]);
				input[i].checked = false;
			}
		}
		
	};
	
	
	var checked = function(vo){
		
		console.log("vo: "+vo.toString);
		
		var answerCode = document.getElementsByName("answerCode");
		  
		console.log(answerCode.length);	
		
        for(var i=0;i<answerCode.length;i++){

        	        	
        	
        	if(answerCode[i].value!=vo.answerCode){
        		
        		continue;
        	}
        	
        	answerCode[i].checked = true;

        	if($("input:radio[id='multiple']").is(":checked")){
    			
    			$("#multiCheck").removeAttr("disabled");
    			
    		}else{
    			$("#multiCheck").attr("checked",false);	
        		$("#multiCheck").attr("disabled",true);
    		}
        	
        }

        var closeCode = document.getElementsByName("closeCode");

        for(var i=0;i<closeCode.length;i++){

        		        	
        	
        	if(closeCode[i].value==vo.closeCode){
        		
	        	closeCode[i].checked = true;	        		
        	}
        	
        	
        	if($("input:radio[id='dateEnd']").is(":checked")){
    			
    			$("#popedOpt1").css('display', 'block');
    			$("#popedOpt2").css('display', 'none');
    			peopleInput.val(null);
    		}
			
        	
        	
        }
        
        
        var loginCode = document.getElementsByName("loginCode");

        for(var i=0;i<loginCode.length;i++){

        	
        	
        	if(loginCode[i].value!=vo.loginCode){
        		continue;
        	}
        	loginCode[i].checked = true;
        	
        }
        
        var publicCode = document.getElementsByName("publicCode");

           for(var i=0;i<publicCode.length;i++){

             
              
              if(publicCode[i].value!=vo.publicCode){
                 
                 continue;
              }
              
              publicCode[i].checked = true;
              
              if($("input:radio[id='unsecretPoll']").is(":checked")){
      			
            	  $("#publicPw").attr("disabled", true);
            	 
      		}
              
           }
		
	};
	
	
	


	
	//=================================================================================
	
		console.log("기본if들");
		
		if($("input:radio[id='multiple']").is(":checked")){
			
			$("#multiCheck").removeAttr("disabled");
			
		}
	
	
		if($("input:radio[id='dateEnd']").is(":checked")){
			
			$("#popedOpt1").css('display', 'block');
			$("#popedOpt2").css('display', 'none');
		}
		
		if($("input:radio[id='unsecretPoll']").is(":checked")){
  			
      	  $("#publicPw").attr("disabled", true);
      	 
		}
		
		
		console.log("onclick들..");
		
		
		$("#dateEnd").on("click",function(){
			
			$("#popedOpt1").css('display', 'block');
			$("#popedOpt2").css('display', 'none');
			peopleInput.val(null);
		});
		
		$("#peopleEnd").on("click",function(){
			$("#popedOpt1").css('display', 'none');
			$("#popedOpt2").css('display', 'block');
			
			
		}); 
		
		$("#multiple").on("click",function(){
			
			$("#multiCheck").removeAttr("disabled");
			
		});
		
		$("#ox").on("click",function(){
			
			$("#multiCheck").attr("disabled",true);
			$("#multiCheck").attr("checked",false);
			
		});
		
		$("#short").on("click",function(){
			
			$("#multiCheck").attr("disabled",true);
			$("#multiCheck").attr("checked",false);
			
		});
		$("#long").on("click",function(){
	
			$("#multiCheck").attr("disabled",true);
			$("#multiCheck").attr("checked",false);
		});
		
		
		$("#unsecretPoll").on("click",function(){
			
			$("#publicPw").attr("disabled", true);
			 $("#publicPw").val(null);
			
		})
		
		$("#secretPoll").on("click", function() {
			$("#publicPw").attr("disabled", false);
			
			$("#publicPw").val = "";
		});

	//-----------------------------------------------------------------------
	});
	
</script>


<script>
	$(function() {
		//Initialize Select2 Elements
		var dateNow = new Date();
        
      $('#datetimepicker').datetimepicker({
            defaultDate : dateNow,
            minDate : dateNow,
         format : 'MM/DD/YYYY h:mm A'
        });
      
        $("#datetimepickerend").datetimepicker({
           defaultDate : dateNow,
           minDate : dateNow,
         format : 'MM/DD/YYYY h:mm A',
            //useCurrent: false //Important! See issue #1075
        });
        
        $("#datetimepicker").on("dp.change", function(e) {
            $("#datetimepickerend").data("DateTimePicker").minDate(e.date);
        });

		//iCheck for checkbox and radio inputs
		$('input[type="checkbox"].minimal, input[type="radio"].minimal')
				.iCheck({
					checkboxClass : 'icheckbox_minimal-blue',
					radioClass : 'iradio_minimal-blue'
				});
		//Red color scheme for iCheck
		$('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red')
				.iCheck({
					checkboxClass : 'icheckbox_minimal-red',
					radioClass : 'iradio_minimal-red'
				});
		//Flat red color scheme for iCheck
		$('input[type="checkbox"].flat-red, input[type="radio"].flat-red')
				.iCheck({
					checkboxClass : 'icheckbox_flat-green',
					radioClass : 'iradio_flat-green'
				});

		//Colorpicker
		$(".my-colorpicker1").colorpicker();
		//color picker with addon
		$(".my-colorpicker2").colorpicker();

		//Timepicker
		$(".timepicker").timepicker({
			showInputs : false
		});
	});
</script>




</body>
</html>