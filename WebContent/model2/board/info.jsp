<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>추억 상세 보기</title>
<script type="text/javascript">
	function deletereply(renum){
		var yn = confirm("확인을 누르면 선택된 댓글이 지워집니다");
		if(yn == true){
			location.href="deletereply.me?family_num=${board.family_num}"
				+"&num=${board.num}&renum="+renum+"&pageNum=${param.pageNum}";
		}
	}
</script>
</head>
<body>
  <input type="hidden" name="num" value="${board.num}">
<table align="center" border="1" cellpadding="0" cellspacing="0">
  <tr><td colspan="2" align="center">상세보기</td></tr>
  <tr><td>글쓴이</td><td>${board.name}</td></tr>
  <tr><td>제목</td><td>${board.subject}</td></tr>
  <fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm:ss E a" var="start"/>
  <tr><td>작성시간</td><td>${start}</td></tr>
  <tr><td>내용</td><td>
  	  <table border="0" width="490" height="250">
  	  <tr><td>${board.content}</td></tr>
  	  </table></td></tr>
  <tr><td>첨부파일</td>
  	  <td>&nbsp;
  	  <c:if test="${!empty board.file1 }">
  	      <a href="file/${board.file1}">${board.file1}</a>
  	  </c:if>&nbsp;</td></tr>
  <tr><td colspan="2" align="center">
  	<a href="replyForm.bo?num=${board.num}&pageNum=${pageNum}&family_num=${board.family_num}">[답변]</a>
  	<a href="updateForm.bo?num=${board.num}&pageNum=${pageNum}&family_num=${board.family_num}">[수정]</a>
  	<a href="list.bo?family_num=${sessionScope.num}">[목록]</a>
  	</td></tr>
</table>


<form name = "f" action="replylist.me?num=${board.num}&pageNum=${param.pageNum}" method="POST">
<input type="hidden" name="writer" value="${sessionScope.login }">
<table width="80%" border="1" align="center" cellspacing="0" cellpadding="0">
		<input type="hidden" name="bnum" value="${board.num}">
		<input type="hidden" name="renum" value="${param.renum}">
<caption><h1>댓글</h1></caption>
	<tr><td colspan ="2" rowspan="2"><textarea cols="100" name="reply_content"></textarea></td>
	</tr>
	<tr><td><input type="submit" value="등록하기" size="4"></td></tr>
    <tr><td colspan="3">
    <table width="100%">
    <tr><th>작성자</th><th>내용</th><th>시간</th><th>기능</th>
	<c:forEach var="b" items = "${list }">
			<input type="hidden" name="writer" value="${b.writer }">
           <tr valign="middle">
                <td align="center" width="15%">${b.writer }</td>
                <td align="center" width="51%"><u>${b.content }</u></td>
                <fmt:formatDate var ="rdate" value="${b.regdate }" pattern="yyyyMMdd"/> <%--today패턴과 여기 pattern이 맞아야 한다. --%>
                     <c:if test="${rdate == today }">
                           <td align="center" width="15%"><fmt:formatDate value = "${b.regdate }" pattern="HH:mm:ss"/></td>
                     </c:if>
                     <c:if test="${rdate != today }">
                           <td align="center"><fmt:formatDate value="${b.regdate }" pattern ="yyyy-MM-dd HH:mm"/></td>
                     </c:if>
                <c:if test="${b.writer == sessionScope.login}">
                <td align="center" width="12%"><a href="javascript:deletereply('${b.renum}');">삭제</a></td></c:if>
                </tr>
		</c:forEach>
</table>
</td></tr>
</table>
</form>

</body>
</html>