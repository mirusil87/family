<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>추억 상세 보기</title>
</head>
<body>
<table align="center" border="1" cellpadding="0" cellspacing="0">
  <tr><td colspan="2" align="center">내가 쓴 말</td></tr>
  <tr><td>제목</td><td>${board.subject}</td></tr>
  <tr><td>내용</td><td>
  	  <table border="0" width="490" height="250">
  	  <tr><td>${board.content}</td></tr>
  	  </table></td></tr>
  	  <fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm:ss E a" var="start"/>
  <tr><td>작성시간</td><td>${start}</td></tr>
  <tr><td colspan="2" align="center">
  	<a href="delete.pv?num=${board.num}&pageNum=${pageNum}&family_num=${board.family_num}&name=${board.name}">[삭제]</a>
  	<a href="list.pv?pageNum=${pageNum}&family_num=${board.family_num}&name=${board.name}">[목록]</a>
  	</td></tr>
</table>

</body>
</html>