<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>가족 등록 하세요^^</title>
<script type="text/javascript">
	function win_open()	{
		var op = "width=500,height=150,scrollbars=yes,left=50,top=150";
		window.open("memberimgForm.jsp","picture",op);
	}
</script>
<script type="text/javascript">
	function update1() {
		location.href="list.me?family_num=${sessionScope.num}";
	}
</script>
</head>
<body>
<form action="join.me?family_num=${sessionScope.num}" name="f" method="post">
<input type="hidden" name="num" value="${sessionScope.login}">
<table border="1" cellpadding="0" cellspacing="0" align="center">
	<caption><h2>가족 이용자 등록</h2></caption>
		<tr><td>이름</td><td><input type="text" name="name"></td>
	</tr>
	<tr><td>비밀번호</td><td><input type="password" name="pass"></td></tr>
	<tr><td>관계</td><td><input type="text" name="relation"></td></tr>
	<tr><td>전화번호</td><td><input type="text" name="tel"></td></tr>
	<tr><td>주소</td><td><input type="text" name="address"></td></tr>
	<tr><td>생년월일</td><td><input type="date" name="birth"></td></tr>
	<tr><td colspan="3" align="center">
		<input type="submit" value="가족등록"><input type="reset" value="다시작성">
		<input type="button" value="가족 목록" onclick="update1()">
	</td></tr>
  </table>
</form>
</body>
</html>