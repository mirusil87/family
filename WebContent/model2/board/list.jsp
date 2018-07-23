<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%-- /WebContent/model2/board/list.jsp : 게시글 목록 조회 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>히스토리</title>
<script type="text/javascript">
function page(page){
	document.sf.pageNum.value=page;
	document.sf.submit();
	
}
</script>
</head>
<body>
	<div class="w3-center">
	<form action="list.bo?family_num=${sessionScope.num }" method="post" name="sf" align="center">
		<input type="hidden" name="pageNum" value="1">
		<%-- <input type="hidden" name="family_num" value="${bo.family_num}"> --%>
	게시글 검색 :
		<select name="column">
			<option value="">선택하세요</option>
			<option value="subject">제목</option>
			<option value="content">내용</option>
			<option value="name">작성자</option>
		</select>
		<script type="text/javascript">
			document.sf.column.value="${param.column}";
		</script>
		<input type="text" name="find" size="50" value="${find}">
		<input type="submit" value="검색"> 
	</form>
	</div>

	<table border="1" cellpadding="0" cellspacing="0" align="center">
		<tr><td colspan="4" align="center">어떤 추억이 기록되었을까요?</td>
		<c:if test="${ boardcount == 0}">
			<td>등록된 글이 없습니다.</td></tr>
		</c:if>
		<c:if test="${boardcount != 0 }">
			<td align="right">글개수:${boardcount}</td></tr>
			<tr align="center" valign="middle">
				<th width="8%">번호</th>
				<th width="50%">제목</th>
				<th width="14%">작성자</th>
				<th width="17%">날짜</th>
				<th width="11%">조회수</th>
			</tr>
		<c:forEach var="b" items="${list}">
		<tr align="center" valign="middle">
			<td>${boardnum}</td>
			<c:set var="boardnum" value="${boardnum -1}"/>
			<td align="left">
			
			<%-- 첨부파일이 있는 경우 @ 표시하고, 다운 받도록 프로그램 수정 --%>
			<c:if test="${!empty b.file1}">
			<a href="file/${ b.file1}" >@</a>
			</c:if>
			
			<%-- empty : b.file1==null || b.file1.equals("") --%>
			<c:if test="${empty b.file1}">
			&nbsp;&nbsp;&nbsp;
			</c:if>
		
			<%-- 답변글인 경우 ┗ 표시하고, 안으로 들여 출력하기 --%>
			<c:if test="${b.reflevel>0}">
			<c:forEach begin="1" end="${b.reflevel}">
			&nbsp;&nbsp;</c:forEach>
			┗ </c:if> 
			<a href="info.bo?num=${b.num}&pageNum=${pageNum}&family_num=${b.family_num}">
			${b.subject}</a></td>
			<td>${b.name}</td>
			<%-- 
			<fmt:formatDate var="rdate" value="${b.regdate}" pattern="yyyyMMdd"/>
			<c:if test="${rdate ==today}">
			<td><fmt:formatDate value="${b.regdate}" pattern="HH:mm:ss"/>
			</c:if>
			<c:if test="${rdate != today}">
			<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm"/></td>
			</c:if>
			 --%>
			<jsp:useBean id="today" class="java.util.Date"/>
			<fmt:formatDate var="day" value="${today}" type="date"/>
			<fmt:formatDate var="regdate" value="${b.regdate}" type="date"/>
			<c:if test="${regdate == day}">
			<td><fmt:formatDate value="${b.regdate}" pattern="HH:mm:ss"/></td>
			</c:if>
			<c:if test="${regdate != day}">
			<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm"/></td>
			</c:if>
			<td>${b.readcnt}</td>
		</tr>
		</c:forEach>
		
		<%-- 페이지 부분 출력하기 --%>
		<tr align="center">
			<td colspan="5">
			<c:if test="${pageNum<=1}">
			[이전]&nbsp;
			</c:if>
			<c:if test="${pageNum > 1}">
			<a href="javascript:page(${pageNum-1})">
			[이전]</a>&nbsp;
			</c:if>
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
			<c:if test="${pageNum==a}">[${a}]
			</c:if>
			<c:if test="${pageNum!=a}">
			<a href="javascript:page(${a})">[${a}]</a>
			</c:if>
			</c:forEach>
			<c:if test="${pageNum >= maxpage }">[다음]&nbsp;</c:if>
			<c:if test="${pageNum < maxpage }">&nbsp;
				<a href="javascript:page(${pageNum+1})">[다음]</a>
			</c:if>
			</td>
		</tr> 
	</c:if>
		<tr align="right">
			<td colspan="5"><a href="writeForm.bo">[글쓰기]</a></td></tr>
	</table>
	</body></html>