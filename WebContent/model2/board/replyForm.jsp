<%@page import="model.BoardDao"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/model2/board/replyForm.jsp
	1. ���ۿ� ���� ���� : num, ref, reflevel,refstep
	2. �亯�۷� �Է� �� ���� 
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��2 �Խ��� ��� ����</title>
</head>
<body>
<form action="reply.bo?pageNum=${pageNum}&family_num=${board.family_num}" method="post" name="f">
	<input type="hidden" name="name" value="${sessionScope.login}">
	<input type="hidden" name="family_num" value="${board.family_num}">
	<input type="hidden" name="num" value="${board.num}">
	<input type="hidden" name="ref" value="${board.ref}">
	<input type="hidden" name="reflevel" value="${board.reflevel}">
	<input type="hidden" name="refstep" value="${board.refstep}">
	<input type="hidden" name="pageNum"	value="${pageNum}">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr><td colspan="2" align="center">��2 �Խ���</td></tr>
		<tr><td>��й�ȣ</td><td><input type="password" name="pass"></td></tr>
		<tr><td>����</td><td>
			<input type="text" name="subject" value="Re:${board.subject}">
		</td></tr>
		<tr><td align="center">����</td>
		<td><textarea rows="15" cols="80" name="content"></textarea></td></tr>
		<tr><td align="center" colspan="2">
		<a href="javascript:document.f.submit()">[�亯���]</a>
		<a href="javascript:document.f.reset()">[�ٽ��ۼ�]</a>
		<a href="javascript:history.go(-1)">[�ڷΰ���]</a>
	</table>
</form></body></html>