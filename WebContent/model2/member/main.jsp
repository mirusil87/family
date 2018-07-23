<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>메인화면</title>

</head>
<body>
<h2 class="w3-center">우리 가족</h2>

<div class="w3-content w3-display-container">
  <img class="mySlides" src="../img/${param.picture}" style="width:100%">
</div>

<input type="hidden" name="num" value="${sessionScope.num}">
</body>
</html>