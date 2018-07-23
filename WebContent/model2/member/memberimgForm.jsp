<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/model2/member/memberimgForm.jsp --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사진등록</title>
</head>
<body>
<h3>업로드 위치 : model2/member/img 폴더</h3>
<form name="f" action="memberimg.me" method="post"
	enctype="multipart/form-data">
	<input type="file" name="picture">
	<input type="submit" value="사진등록">
</form>
</body>
</html>