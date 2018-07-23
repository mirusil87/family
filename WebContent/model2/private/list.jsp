<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%-- /WebContent/model2/private/list.jsp : �Խñ� ��� ��ȸ --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��2 �Խ���</title>
<script type="text/javascript">
function page(page){
	document.sf.pageNum.value=page;
	document.sf.submit();
	
}
</script>
</head>
<body>
	<input type="hidden" name="pageNum" value="1">
	<table border="1" cellpadding="10" cellspacing="0" align="center" width="900" >
		<caption><h2>�� ����?�� ����?</h2></caption>
		<tr><td colspan="4" align="center">������ ��̳���?</td>
		<c:if test="${ boardcount == 0}">
			<td>��ϵ� ���� �����ϴ�.</td></tr>
		</c:if>
		<c:if test="${boardcount != 0 }">
			</tr>
			<tr align="center" valign="middle">
				<th width="10%">��ȣ</th>
				<th width="63%">����</th>
				<th width="27%">��¥</th>
			</tr>
		<c:forEach var="b" items="${list}">
		<tr align="center" valign="middle">
			<td>${boardnum}</td>
			<c:set var="boardnum" value="${boardnum -1}"/>
			<td align="left">
			<a href="info.pv?num=${b.num}&pageNum=${pageNum}&family_num=${b.family_num}&name=${b.name}">
			${b.subject}</a></td>
			
			<jsp:useBean id="today" class="java.util.Date"/>
			<fmt:formatDate var="day" value="${today}" type="date"/>
			<fmt:formatDate var="regdate" value="${b.regdate}" type="date"/>
			<c:if test="${regdate == day}">
			<td><fmt:formatDate value="${b.regdate}" pattern="HH:mm:ss"/></td>
			</c:if>
			<c:if test="${regdate != day}">
			<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm"/></td>
			</c:if>
		</tr>
		</c:forEach>
		
		<%-- ������ �κ� ����ϱ� --%>
		<tr align="center">
			<td colspan="5">
			<c:if test="${pageNum<=1}">
			[����]&nbsp;
			</c:if>
			<c:if test="${pageNum > 1}">
			<a href="javascript:page(${pageNum-1})">
			[����]</a>&nbsp;
			</c:if>
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
			<c:if test="${pageNum==a}">[${a}]
			</c:if>
			<c:if test="${pageNum!=a}">
			<a href="javascript:page(${a})">[${a}]</a>
			</c:if>
			</c:forEach>
			<c:if test="${pageNum >= maxpage }">[����]&nbsp;</c:if>
			<c:if test="${pageNum < maxpage }">&nbsp;
				<a href="javascript:page(${pageNum+1})">[����]</a>
			</c:if>
			</td>
		</tr> 
	</c:if>
		<tr align="right">
			<td colspan="5"><a href="writeForm.jsp">[�۾���]</a></td></tr>
	</table></body></html>