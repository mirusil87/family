<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- /WebContent/model1/board/updateForm.jsp
	1. num �Ķ���Ϳ� �ش��ϴ� �Խù��� db���� ��ȸ�Ͽ� Board ��ü ����
	2. Board ��ü�� ������ ȭ�鿡 ����ϱ�
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�����丮 ����</title>
<script type="text/javascript">
	function file_delete() {
		document.f.file2.value="";  //file1�� ������ �����.
		file_desc.style.display="none"; //������ �ʵ��� ����
	}
</script>
</head>
<body>
<form action="update.bo?pageNum=${pageNum }&family_num=${board.family_num}" method="post" enctype="multipart/form-data" name="f">
  <input type="hidden" name="family_num" value="${board.family_num}">
  <input type="hidden" name="num" value="${board.num}">
  <input type="hidden" name="name" value="${board.name}">
  <input type="hidden" name="file2" value="${board.file1}">
  <input type="hidden" name="pageNum" value="${pageNum}">
  <table border="1" cellpadding="0" cellspacing="0">
  	<caption>�����丮 ����</caption>
  	<tr><td align="center">�۾���</td><td><input type="text" name="name" value="${board.name}" readonly></td></tr>
  	<tr><td align="center">��й�ȣ</td>
  		<td><input type="password" name="pass"></td></tr>
  	<tr><td align="center">����</td>
  		<td><input type="text" name="subject" value="${board.subject}"></td></tr>
  	<tr><td align="center">����</td>
  		<td><textarea rows="15" cols="80" name="content">${board.content}</textarea></td></tr>
  	<tr><td align="center">÷������</td>
  		<td><c:if test="${!empty board.file1 }">
  		<div id="file_desc">
  			<a href="file/${board.file1}">${board.file1}</a>
  			<a href="javascript:file_delete()">[÷�����ϻ���]</a></div>
  	  </c:if>
  		<input type="file" name="file1" ></td></tr>
  	<tr><td align="center" colspan="2">
  		<a href="javascript:document.f.submit()">[�Խù�����]</a>
  	</td></tr></table></form>
</body>
</html>