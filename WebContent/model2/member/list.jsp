<%@page import="model.Member"%>
<%@page import="java.util.List"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- /WebContent/model2/member/list.jsp --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ��� ����</title>
</head> 
<body>
<input type="hidden" name="num" value="${sessionScope.login}">
<table border="1" cellspacing="0" cellpadding="0" class="w3-table-all w3-centered">
  <caption><h2>���� ���</h2></caption>
  <tr><th>�̸�</th><th>�ּ�</th><th>��ȭ</th><th>����</th><th>����</th><th>��й�ȣ</th>
  	  <th>&nbsp;</th></tr>
<c:forEach var="mem" items="${list }">
<c:if test="${sessionScope.login == mem.family_num }">
  <tr>
  	<td>${mem.name}</td>
  	<td>${mem.address }</td>
  	<td>${mem.tel}</td>
  	<td>${mem.relation}</td>
  	<td>${mem.birth }</td>
  	<td>${mem.pass }</td>
  	<td height="50" width="160">
  	<a href="updateForm.me?name=${mem.name}">[����]</a>
  	<c:if test="${mem.name != sessionScope.login }">
  		<a href="delete.me?name=${mem.name}">[����Ż��]</a>
  	</c:if>
  	</td>
  </tr>
  </c:if>
</c:forEach>
</table></body></html>