<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>추억을 기록해 보세요.</title>
<script type="text/javascript">
	function board_submit() {
		if(document.f.name.value=='') {
			alert('글쓴이를 입력해주세요');
			document.f.name.focus();
			return; //함수종료.
		} 
		if(document.f.pass.value=='') {
			alert('비밀번호를 입력해주세요');
			document.f.pass.focus();
			return;
		} 
		if(document.f.subject.value=='') {
			alert('제목을 입력해주세요');
			document.f.subject.focus();
			return;
		} 
		if(document.f.content.value=='') {
			alert('내용을 입력해주세요');
			document.f.content.focus();
			return;
		} 
		document.f.submit(); //강제로 submit을 실행하기. open은 내용을 담지 않고 바로 열어준다.
	}//자바스크립트는 변수 이름과 메서드 이름의 구별이 없다. 그래서 이름들을 정확히 구분지어줘야 한다. 
	
</script>
</head>
<body>
<form action="write.bo" method="post" enctype="multipart/form-data" name="f">
	<input type="hidden" name="name" value="${sessionScope.login }">
	<input type="hidden" name="family_num" value="${sessionScope.num }">
	
  <table border="1" cellpadding="0" cellspacing="0" align="center">
  	<caption><h2>어떤 추억이 있으셨을까요?</h2></caption>
  	<tr><td align="center">비밀번호</td>
  		<td><input type="password" name="pass"></td>
  		<th>수정하실 때 필요하십니다. </th></tr>
  	<tr><td align="center">제목</td>
  		<td><input type="text" name="subject"></td>
  		<td>날짜와 있었던 일을 위주로 쓰시면 검색하기 좋습니다.</td></tr>
  	<tr><td align="center">내용</td>
  		<td colspan="2"><textarea rows="15" cols="80" name="content"></textarea></td></tr>
  	<tr><td align="center">첨부파일</td>
  		<td><input type="file" name="file1"></td></tr>
  	<tr><td align="center" colspan="3">
  		<a href="javascript:board_submit()">[게시물등록]</a>
  	</td></tr></table></form>
</body>
</html>