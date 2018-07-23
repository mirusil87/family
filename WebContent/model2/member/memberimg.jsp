<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/model2/member/memberimg.jsp --%>
<script>
<%-- opener : 윈도우를 open한 윈도우를 의미 : joinForm.jsp 윈도우를 의미함.--%>
	img = opener.document.getElementById("pic");
	img.src = "img/${filename}"; 					<%-- 보여줄 이미지 설정 --%>
	opener.document.f.picture.value = "${filename}"; <%-- 가져와서 보여줌. --%>
	self.close(); //현재 창을 닫기 
</script>
