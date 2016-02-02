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

			<div class="col-md-12">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">내투표들</h3>
						<div class="box-tools pull-right">
							<div class="has-feedback">
								<input type="text" class="form-control input-sm"
									placeholder="Search Mail"> <span
									class="glyphicon glyphicon-search form-control-feedback"></span>
							</div>
						</div>
						<!-- /.box-tools -->
					</div>
					<!-- /.box-header -->
					<div class="box-body no-padding">
						<div class="mailbox-controls">
							<!-- Check all button -->
							<button class="btn btn-default btn-sm checkbox-toggle">
								<i class="fa fa-square-o"></i>
							</button>
							<div class="btn-group">
								<button class="btn btn-default btn-sm" id="trash">
									<i class="fa fa-trash-o"></i>
								</button>
								<button class="btn btn-default btn-sm">
									<i class="fa fa-reply"></i>
								</button>
								<button class="btn btn-default btn-sm">
									<i class="fa fa-share"></i>
								</button>
							</div>
							<!-- /.btn-group -->
							<button class="btn btn-default btn-sm">
								<i class="fa fa-refresh"></i>
							</button>



						</div>
						<div class="table-responsive mailbox-messages">
							<table class="table table-hover table-striped">

								<thead>
									<tr>
										<th></th>
										<th>투표번호</th>
										<th>카테고리</th>
										<th>투표 제목</th>

										<th>등록일자</th>
										<th>진행상황</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${list}" var="list">
										<tr class="basic-table">
											<td><input type="checkbox" value="${list.pno }"></td>
											<td>${list.pno }</td>

											<td class="mailbox-subject"><b> <c:choose>
														<c:when test="${list.categoryCode=='category1'}">
										        선호도
										        <br />
														</c:when>
														<c:when test="${list.categoryCode=='category2'}">
										        세미나
										        <br />
														</c:when>
														<c:when test="${list.categoryCode=='category3'}">
										        강의
										        <br />
														</c:when>
														<c:when test="${list.categoryCode=='category4'}">
										       	마케팅
										        <br />
														</c:when>
														<c:when test="${list.categoryCode=='category5'}">
										        방송
										        <br />
														</c:when>
														<c:when test="${list.categoryCode=='category6'}">
										        스포츠
										        <br />
														</c:when>
														<c:when test="${list.categoryCode=='category7'}">
										        서명운동
										        <br />
														</c:when>
														<c:when test="${list.categoryCode=='category8'}">
										        기타
										        <br />
														</c:when>
													</c:choose>
											</b></td>
											<td class="mailbox-name"><a
												href="/poll/mypollview${pageMaker.makeSearch(cri.page)}&pno=${list.pno }">${list.topic }</a></td>


											<td>${list.updateDate }</td>
											<td><span class="label label-danger">${list.status}</span>
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
							</table>
							<!-- /.table -->


						</div>
						<!-- /.mail-box-messages -->
					</div>
					<!-- /.box-body -->


					<div class="text-center">
						<div class="pagination">

							<c:if test="${pageMaker.prev }">
								<li><a
									href="/poll/list${pageMaker.makeSearch(pageMaker.startPage-1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="paging">
								<li <c:out value="${cri.page==paging?'class=active':'' }"/>>
									<a href="/poll/list${pageMaker.makeSearch(paging) }">${paging }</a>
								</li>

							</c:forEach>


							<c:if test="${pageMaker.next }">
								<li><a
									href="/poll/list${pageMaker.makeSearch(pageMaker.endPage+1) }">&raquo;</a></li>
							</c:if>


						</div>

					</div>


				</div>
				<!-- /. box -->
			</div>
			<!-- /.col -->



			<!-- 페이징할라고... -->







			<div class="col-md-12">
				<!-- Info Boxes Style 2 -->

				<div>
					<button class="btn btn-block btn-warning btn-lg" id="create-Btn">투표만들기</button>
					
				</div>
				<!-- /.info-box -->

			</div>

		</div>
		<!-- /.row -->



		<form class="delForm" action="/poll/list" method="post"></form>
		<a href="http://localhost:3000/user/${mno }">
		<button class="btn btn-block btn-primary btn-lg" id="activate-Btn">투표활성화</button>
		</a>
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->



<!-- Page Script -->
<script>

	var mno= ${cri.mno};

	console.log(mno);
	
	$(function() {
		//Enable iCheck plugin for checkboxes
		//iCheck for checkbox and radio inputs
		$('.mailbox-messages input[type="checkbox"]').iCheck({
			checkboxClass : 'icheckbox_flat-blue',
			radioClass : 'iradio_flat-blue'
		});

		//Enable check and uncheck all functionality
		$(".checkbox-toggle").click(
				function() {
					var clicks = $(this).data('clicks');
					if (clicks) {
						//Uncheck all checkboxes
						$(".mailbox-messages input[type='checkbox']").iCheck(
								"uncheck");
						$(".fa", this).removeClass("fa-check-square-o")
								.addClass('fa-square-o');
					} else {
						//Check all checkboxes
						$(".mailbox-messages input[type='checkbox']").iCheck(
								"check");
						$(".fa", this).removeClass("fa-square-o").addClass(
								'fa-check-square-o');
					}
					$(this).data("clicks", !clicks);
				});

		//Handle starring for glyphicon and font awesome
		$(".mailbox-star").click(function(e) {
			e.preventDefault();
			//detect type
			var $this = $(this).find("a > i");
			var glyph = $this.hasClass("glyphicon");
			var fa = $this.hasClass("fa");

			//Switch states
			if (glyph) {
				$this.toggleClass("glyphicon-star");
				$this.toggleClass("glyphicon-star-empty");
			}

			if (fa) {
				$this.toggleClass("fa-star");
				$this.toggleClass("fa-star-o");
			}
		});

		$('#create-Btn').on("click", function(event) {
			event.preventDefault();
			self.location = "/poll/category";

		});

		
		
		$('#trash')
				.on(
						"click",
						function(event) {
							event.preventDefault();

							var checkNum = $('.mailbox-messages input[type="checkbox"]:checked');

							if (checkNum.length == 0) {
								return;
							}

							var delForm = $('.delForm');

							for (var i = 0; i < checkNum.length; i++) {

								delForm
										.append("<input type='hidden' name='pnos' value='"+checkNum[i].value+"'>");

							}

							delForm.submit();

						});

	});
</script>
<script>
	$(document).ready(function() {

		//포맷데이트를 배열에 담는다.
		var date = new Array();
		var time = new Array();

		<c:forEach items="${formatDate}" var="item">
		var json;
		json = "${item}";
		date.push(json);
		</c:forEach>

		<c:forEach items="${formatDate2}" var="item">
		var json;
		json = "${item}";
		time.push(json);
		</c:forEach>
		//================================================
		console.log(date);
		console.log(time);

		var d = new Date();

		var today = ('0' + (d.getMonth() + 1) + '/' + d.getDate());
		console.log(today);

		for (var i = 0; i < date.length; i++) {
			if (date == today) {
				$(".date").text(time[i]);
			} else {
				$(".date").text(date[i]);
			}
		}

	});
</script>

<%@include file="../include/footer.jsp"%>
</body>
</html>