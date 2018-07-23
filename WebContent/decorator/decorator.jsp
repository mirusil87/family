<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<sql:setDataSource var="conn" driver="org.mariadb.jdbc.Driver"
				   url="jdbc:mariadb://localhost:3306/jisdb"
				   user="jis" password="jis" /> 
<sql:query var="rs" dataSource="${conn}">
	select name from member where family_num like ?
	<sql:param>${sessionScope.num}</sql:param>
</sql:query>
<jsp:useBean id="today" class="java.util.Date"/>
<fmt:formatDate value="${today}" pattern="yyyy" var="years"/>
<fmt:formatDate value="${today}" pattern="MM" var="months"/>
<!DOCTYPE html>
<html>
<head>
<title><decorator:title/></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
</script>
	
<script>
function myFunction() {
    var x = document.getElementById("Demo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}
function hello() {
	$(".textbox").show();
	
}
</script>
<style>
* {
    box-sizing: border-box;
}

body {
    font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
.header {
    background-color: #f1f1f1;
    padding: 5px;
    text-align: center;
}

/* Create three unequal columns that floats next to each other */
.column {
    float: left;
}

/* Left and right column */
.column.side {
    width: 15%;
}

/* Middle column */
.column.middle {
    width: 70%;
}
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    width: 100%;
    border: none;
    cursor: pointer;
}

/* .dropdown {
    position: relative;
    display: inline-block;
    
} */

.dropdown-content {
    display: block;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 	300px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* .dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
} */
</style>
<decorator:head/>
</head>
<body>

<div class="header">
<img src="${path}/model2/img/main.png" style="width:40%">
</div>

<div class="row">
  <div class="column side">
	<div class="w3-bar-block w3-black">
	<c:if test="${!empty sessionScope.login }">
  <a href="${path}/model2/member/logout.me" class="w3-bar-item w3-button">
  	그만보실거에요?</a>
  <a href="#" class="w3-bar-item w3-button">앨범</a>
  <a href="${path}/model2/board/list.bo?family_num=${sessionScope.num}" class="w3-bar-item w3-button">히스토리</a>
  <a href="${path}/model2/calendar/calendar.ca?year=${years}&month=${months}&family_num=${sessionScope.num}" class="w3-bar-item w3-button">일정</a>
  <a href="${path}/model2/private/list.pv?family_num=${sessionScope.num}&name=${sessionScope.login}" class="w3-bar-item w3-button">내마음</a>
<c:if test="${!empty sessionScope.login && sessionScope.login.equals(sessionScope.num)}">
  	<a href="${path}/model2/member/joinForm.jsp" class="w3-bar-item w3-button">등록</a>
	</c:if></c:if>
	 </div>
  </div>
  <div class="column middle"><decorator:body/></div>
  <div class="column side">
  	<c:if test="${!empty sessionScope.login }">
  		<div class="dropbtn">가족 목록</div>
  			<div class="dropdown-content">
	  <c:forEach var="data" items="${rs.rows}">
	  <c:if test="${sessionScope.num != data.name}">
	  <c:if test="${sessionScope.login != data.name}">
        <a href="#" class="w3-bar-item w3-button">${data.name}</a>
	  </c:if>	  
	  </c:if>	  
      </c:forEach>
      </div>
  	</c:if>
  </div>
</div>

</body>
</html>
