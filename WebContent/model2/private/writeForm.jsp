<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ���� �Դϴ�.</title>
<script type="text/javascript">
	function board_submit() {
		if(document.f.name.value=='') {
			alert('�۾��̸� �Է����ּ���');
			document.f.name.focus();
			return; //�Լ�����.
		} 
		if(document.f.subject.value=='') {
			alert('������ �Է����ּ���');
			document.f.subject.focus();
			return;
		} 
		if(document.f.content.value=='') {
			alert('������ �Է����ּ���');
			document.f.content.focus();
			return;
		} 
		document.f.submit(); 
	} 
	
</script>
</head>
<body>
<form action="write.pv" method="post" name="f">
  	<input type="hidden" name="name" value="${sessionScope.login }">
  	<input type="hidden" name="family_num" value="${sessionScope.num }">
  <table border="1" cellpadding="0" cellspacing="0" align="center">
  	<caption><h2>������ �ϱ���</h2></caption>
  	<tr><td align="center">����</td>
  		<td><input type="text" name="subject"></td></tr>
  	<tr><td align="center">����</td>
  		<td><textarea rows="15" cols="80" name="content"></textarea></td></tr>
  	<tr><td align="center" colspan="2">
  		<a href="javascript:board_submit()">[�Խù����]</a>
  	</td></tr></table></form>
</body>
</html>