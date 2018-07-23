<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- /WebContent/model1/member/updateForm.jsp --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>가족 정보 수정</title>
</head>
<body>
<form action="update.me" name="f" method="post">
  <input type="hidden" name="family_num" value="${mem.family_num}">
  <table border="1" cellpadding="0" cellspacing="0" align="center">
		<caption>가족 정보 수정</caption>
		<tr><td>이름</td>
		<td><input type="text" name="name" value="${mem.name}" readonly></td>
	</tr>
	<tr><td>비밀번호</td><td><input type="password" name="pass" value="${mem.pass}"></td></tr>
	<tr><td>관계</td><td><input type="text" name="relation" value="${mem.relation}"></td></tr>
	<tr><td>주소</td><td><input type="text" name="address" value="${mem.address}"></td></tr>
	<tr><td>전화번호</td><td>
		<input type="text" name="tel" value="${mem.tel}"></td></tr>
	<tr><td colspan="3" align="center">
		<input type="submit" value="회원수정">
	</td></tr>
  </table>
</form>
</body>
</html>
