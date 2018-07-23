<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- /WebContent/model1/board/updateForm.jsp
	1. num 파라미터에 해당하는 게시물을 db에서 조회하여 Board 객체 저장
	2. Board 객체에 내용을 화면에 출력하기
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>히스토리 수정</title>
<script type="text/javascript">
	function file_delete() {
		document.f.file2.value="";  //file1의 정보를 지우기.
		file_desc.style.display="none"; //보이지 않도록 설정
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
  	<caption>히스토리 수정</caption>
  	<tr><td align="center">글쓴이</td><td><input type="text" name="name" value="${board.name}" readonly></td></tr>
  	<tr><td align="center">비밀번호</td>
  		<td><input type="password" name="pass"></td></tr>
  	<tr><td align="center">제목</td>
  		<td><input type="text" name="subject" value="${board.subject}"></td></tr>
  	<tr><td align="center">내용</td>
  		<td><textarea rows="15" cols="80" name="content">${board.content}</textarea></td></tr>
  	<tr><td align="center">첨부파일</td>
  		<td><c:if test="${!empty board.file1 }">
  		<div id="file_desc">
  			<a href="file/${board.file1}">${board.file1}</a>
  			<a href="javascript:file_delete()">[첨부파일삭제]</a></div>
  	  </c:if>
  		<input type="file" name="file1" ></td></tr>
  	<tr><td align="center" colspan="2">
  		<a href="javascript:document.f.submit()">[게시물수정]</a>
  	</td></tr></table></form>
</body>
</html>