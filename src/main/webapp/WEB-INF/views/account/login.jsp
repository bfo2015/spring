<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../include/header.jsp"%>

<div class="content-wrapper">



<section class="content">

<div class="row">
	<div class="col-md-12">
		<div class="box box-info">
			<div class="box-header">
				<h3 class="box-title">
					로그인 <small>로그인이 필요합니다</small>
				</h3>

				<body class="hold-transition login-page">
					<div class="login-box">
						<div class="login-logo">
							<a href="/account/login"><b>Poll</b>InLuv</a>
						</div>
						<!-- /.login-logo -->
						<div class="login-box-body">
							<p class="login-box-msg">Sign in to start your session</p>
							
							
							<form role="form" action="/account/loginPost" method="post">
								<input type="hidden" value="${login }" name="MemberVO">
								
								<div class="form-group has-feedback">
									<input type="email" class="form-control" placeholder="Email"
									name="userMail">
									<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
								</div>
								
								<div class="form-group has-feedback">
									<input type="password" class="form-control"
										placeholder="Password" name="userPw"> 
									<span class="glyphicon glyphicon-lock form-control-feedback"></span>
								</div>
								<div class="row">
									<div class="col-xs-8">
										<div class="checkbox icheck">
											<label> <input type="checkbox"> Remember Me
											</label>
										</div>
									</div>
									<!-- /.col -->
									<div class="col-xs-4">
										<button type="submit"
											class="btn btn-primary btn-block btn-flat"
											id="loginBtn">Sign In</button>
									</div>
									<!-- /.col -->
								</div>
							</form>

							<div class="social-auth-links text-center">
								<p>- OR -</p>
								<a href="#"
									class="btn btn-block btn-social btn-facebook btn-flat"><i
									class="fa fa-facebook"></i> Sign in using Facebook</a> <a
									href="#" class="btn btn-block btn-social btn-google btn-flat"><i
									class="fa fa-google-plus"></i> Sign in using Google+</a>
							</div>
							<!-- /.social-auth-links -->

							<a href="#">I forgot my password</a><br> 
							<a href="/account/createAccount" class="text-center">Register a new
								membership</a>

						</div>
						<!-- /.login-box-body -->
					</div>
					<!-- /.login-box -->
			</div>
		</div>
	</div>
</div>
</section>
</div>

<%@include file="../include/footer.jsp"%>
<script>
	$(function() {
		$('input').iCheck({
			checkboxClass : 'icheckbox_square-blue',
			radioClass : 'iradio_square-blue',
			increaseArea : '20%' // optional
		});
	});
</script>

<script>
$(document).ready(function(){
	$("#loginBtn").on("click",function(){
		/* alert("로그인 되다."); */
		$("#dropNickname").text("${login.nickName}");
  	    $("#sidebarNickname").text("${login.nickName}");
	})
});

</script>


</body>

</html>


