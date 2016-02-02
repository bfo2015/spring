<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<input type="hidden" value="${memberVO }" name="MemberVO">

<script type="text/javascript">

var vo = {
		mno : "${login.mno}",
		userMail : "${login.userMail}",
		userPw : "${login.userPw}",
		nickName : "${login.nickName}"
};

$.ajax({
	url: "/poll/list",
	type : "GET",
	data : vo,
	success: function(result){
		alert(result);
	}
});


alert("login!");
 self.location = "/poll/list";
</script>

</body>
</html>