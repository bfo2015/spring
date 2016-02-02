<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>

<style>
iframe {
   width: 0px;
   height: 0px;
   border: 0px
}
</style>

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
               <div class="box-header with-border">
                  <h3 class="box-title">질문 수정 페이지</h3>
               </div>
               <!-- /.box-header -->
                                  
              <!-- /.box-body -->
               <div class="box-body">
                 <form class='registerForm' role="form" action="/poll/pollmodify" method="post">
                   <input type="hidden" name="pno" value="${pollVO.pno}">
                   <div class="form-group">
                     <label>주제</label> <input type="text" id="topic" class="form-control" name="topic" placeholder="주제..." value="${pollVO.topic}">
                   </div>
                   <div class="form-group">
                     <label>설명</label>
                     <textarea class="form-control" rows="3" name="intro" placeholder="설명...">${pollVO.intro}</textarea>
                   </div>
                   <div class="form-group">
                     <label>인증번호</label> <input type="text" id="validation" class="form-control" name="validation" placeholder="인증번호">
                   </div>
                   <div class="form-group">
                     <label>파일첨부</label>
                   </div>
                 </form>
              <form action="/poll/uploadForm" method="post" enctype="multipart/form-data" target="zeroFrame">
               <input type='file' name='file' class="files">
               <button type='submit' id="uploadbtn" class="btn btn-info btn-xs">파일올리기</button>
               <small id="itemFile" name="1stFile"></small><button id="fileDelete" class="btn btn-box-tool"><i class="fa fa-times"></i></button>
             </form>
             <iframe name="zeroFrame"></iframe>   
               </div>
            </div>
            <!-- /.box-body -->
                  
           <div class="box-footer">
              <label>항목</label>
              <div id="divItem">
              </div>
           </div>

           <div class="box-footer">
              <a href="/poll/list" class="btn btn-default pull-left" id="cancel_btn">수정취소</a>
              <button type="submit" id="registBtn" class="btn btn-info pull-right">수정하기</button>
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

<%@include file="../include/footer.jsp"%>

<script>
var item = '<div><input type="text" name="itemText" class="form-control" placeholder="항목...">'
    +'<form action="/poll/uploadForm" method="post" enctype="multipart/form-data" target="zeroFrame">'
    +'<button type="button" class="btn btn-default btn-xs pull-right" id="itemDel"><i class="fa fa-times"></i></button>'
    +'<button type="button" class="btn btn-primary btn-xs pull-right" id="criBtn"><i class="fa fa-plus"></i></button>'
    +'<input type="file" name="file" class="files">'
    +'<button type="submit" id="uploadbtn" class="btn btn-info btn-xs">파일올리기</button>'
    +'<small id="itemFile"></small>'
    +'<button id="fileDelete" class="btn btn-box-tool"><i class="fa fa-times"></i></button></form><p></p></div>';

var files = new Array();
var texts = new Array();

<c:forEach items="${itemVO.files}" var="file">
var fileName = "${file}" 
files.push(fileName);
</c:forEach>

<c:forEach items="${itemVO.texts}" var="text">
var itemText = "${text}" 
texts.push(itemText);
</c:forEach>

console.log(files);
console.log(texts);

$("small[name=1stFile]").text(files[0]);

if('${pollVO.answerCode}' != 'answer1'){
	$('#divItem').parent().remove();
}else{
	for(var i=1; i<files.length; i++){
	
		$('#divItem').append('<div><input type="text" name="itemText" class="form-control" placeholder="항목..." value='+texts[i]+'>'
			+'<form action="/poll/uploadForm" method="post" enctype="multipart/form-data" target="zeroFrame">'
		    +'<button type="button" class="btn btn-default btn-xs pull-right" id="itemDel"><i class="fa fa-times"></i></button>'
		    +'<button type="button" class="btn btn-primary btn-xs pull-right" id="criBtn"><i class="fa fa-plus"></i></button>'
		    +'<input type="file" name="file" class="files">'
		    +'<button type="submit" id="uploadbtn" class="btn btn-info btn-xs">파일올리기</button>'
		    +'<small id="itemFile">'+files[i]+'</small>'
		    +'<button id="fileDelete" class="btn btn-box-tool"><i class="fa fa-times"></i></button></form><p></p></div>');
	}
}

 //항목추가
 $(document).on("click","#criBtn",function(event) {
   event.preventDefault();   
   $(this).parent().parent().after(item);
 });
 
 //항목삭제
 $(document).on("click", "#itemDel", function(event) {
   event.preventDefault();
   
   if($("#divItem div").length <= 2){
   	alert("2개 이하는 삭제할 수 업습니다");
   	return;
   };
   
   $(this).parent().parent().remove();
 });

 //파일첨부후 버튼클릭시 화면에 이름생성해줌
 var target;
 
 function addFilePath(itemFile) {

 target.children('#itemFile').text(itemFile);
 }

 //파일 첨부시 파일전송 버튼 눌렀을때 해당 항목 파일 전송
 $(document).on("click", "#uploadbtn", function(event) {
	 event.preventDefault();
	 
	 target = $(this).parent();
	 
	 if(target.children('.files').val() == ""){
	   alert("파일을 선택해 주세요");
	 } else{
	   target.submit(); 
	 }
 }); 
 
 $(document).on("click","#fileDelete",function(event){
   event.preventDefault();
   $(this).parent().children('#itemFile').text("");
 });


//등록하기 버튼 클릭시 항목의 텍스트와 파일명을 히든태그로 만들어서 폼태그를 전송한다
$("#registBtn").on("click",function(event){
	event.preventDefault;
 
	var formObj = $(".registerForm");
	var itemFiles = [];
	var itemTexts = [];
	
    if($("#topic").val() === ""){
    	alert("주제를 입력해 주세요");
    	return false;
    };
    
    if($("#validation").val() === ""){
    	alert("인증번호를 입력해 주세요");
    	return false;
    };
    
	$("small[id=itemFile]").each(function(index){
		itemFiles[index] = $(this).text();
	});
	    
	$("input[name=itemText]").each(function(index){
		itemTexts[index] = $(this).val();
	});
	
    for(var i=0; itemTexts.length > i; i++){
    	
    	if(itemTexts[i] === ""){
    	  alert("빈 항목을 채워주세요");
      	  return false;
        };
    };
/* 	for(var i=0; i<itemTexts.length; i++){
		if(itemTexts[i] == "" && itemFiles[i+1] == ""){
			console.log("둘다 빈 항목은 배열에서 제거합니다.");
			itemFiles.splice(i+1,1);
			itemTexts.splice(i,1);
			i--;//삭제후 해당 인덱스 다시 검사
		}
	} */
	  
	for(var i=0; i<itemFiles.length; i++){
		formObj.append("<input type='hidden' name='files' value='"+itemFiles[i]+"'>");
		console.log(itemFiles[i]);
	}
	for(var i=0; i<itemTexts.length; i++){
		formObj.append("<input type='hidden' name='texts' value='"+itemTexts[i]+"'>");
		console.log(itemTexts[i]);
	}
	formObj.submit();
        
});      
</script>

</body>
</html>