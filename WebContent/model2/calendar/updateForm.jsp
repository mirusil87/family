<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>일정 수정</title>
<script type="text/javascript">
	function board_submit() {
		if(document.f.startdate.value=='') {
			alert('시작일을 입력해주세요');
			document.f.name.focus();
			return;
		} 
		if(document.f.enddate.value=='') {
			alert('마침일을 입력해주세요');
			document.f.pass.focus();
			return;
		} 
		if(document.f.subject.value=='') {
			alert('제목을 입력해주세요');
			document.f.subject.focus();
			return;
		} 
		if(document.f.color.value=='') {
			alert('선택주세요');
			document.f.content.focus();
			return;
		} 
		document.f.submit(); 
	}
	
</script>
</head>
<body>
 <form action="update.ca" name="f">
    <input type="hidden" name="family_num" value="${sessionScope.num}">
    <input type="hidden" name="num" value="${calen.num}">
    <table align="center">
    <caption><h3>일정수정</h3></caption>
 <fmt:formatDate value="${calen.start_regdate}" pattern="yyyy-MM-dd" var="start"/>
 <fmt:formatDate value="${calen.end_regdate}" pattern="yyyy-MM-dd" var="end"/>
		<tr><th>날짜</th><td><input type="text" name="startdate" value="${start}">
		~<input type="text" name="enddate" value="${end}"></td></tr>
		<tr><th>제목</th><td><input type="text" name="subject" value="${calen.subject}" ></td></tr>
		<tr><th>선택</th><td><select name="color">
					<option value="lime">일정</option>
					<option value="tomato">기념일</option>
					<option value="yellow">제사</option>
					<option value="pink">생일</option>
		</select>
		<script type="text/javascript">
      document.f.color.value='${calen.color}';
   </script>
		</td></tr>
		<tr align="center"><td colspan="2">
		<a href="javascript:board_submit()">[수정]</a>
		</td></tr></table></form>
</body>
</html>