<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ����</title>
<script type="text/javascript">
	function board_submit() {
		if(document.f.startdate.value=='') {
			alert('�������� �Է����ּ���');
			document.f.name.focus();
			return;
		} 
		if(document.f.enddate.value=='') {
			alert('��ħ���� �Է����ּ���');
			document.f.pass.focus();
			return;
		} 
		if(document.f.subject.value=='') {
			alert('������ �Է����ּ���');
			document.f.subject.focus();
			return;
		} 
		if(document.f.color.value=='') {
			alert('�����ּ���');
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
    <caption><h3>��������</h3></caption>
 <fmt:formatDate value="${calen.start_regdate}" pattern="yyyy-MM-dd" var="start"/>
 <fmt:formatDate value="${calen.end_regdate}" pattern="yyyy-MM-dd" var="end"/>
		<tr><th>��¥</th><td><input type="text" name="startdate" value="${start}">
		~<input type="text" name="enddate" value="${end}"></td></tr>
		<tr><th>����</th><td><input type="text" name="subject" value="${calen.subject}" ></td></tr>
		<tr><th>����</th><td><select name="color">
					<option value="lime">����</option>
					<option value="tomato">�����</option>
					<option value="yellow">����</option>
					<option value="pink">����</option>
		</select>
		<script type="text/javascript">
      document.f.color.value='${calen.color}';
   </script>
		</td></tr>
		<tr align="center"><td colspan="2">
		<a href="javascript:board_submit()">[����]</a>
		</td></tr></table></form>
</body>
</html>