<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/model2/member/memberimg.jsp --%>
<script>
<%-- opener : �����츦 open�� �����츦 �ǹ� : joinForm.jsp �����츦 �ǹ���.--%>
	img = opener.document.getElementById("pic");
	img.src = "img/${filename}"; 					<%-- ������ �̹��� ���� --%>
	opener.document.f.picture.value = "${filename}"; <%-- �����ͼ� ������. --%>
	self.close(); //���� â�� �ݱ� 
</script>
