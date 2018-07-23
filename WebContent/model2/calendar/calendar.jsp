<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<title>일정</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>

<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 40%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
</style>
</head>
<body>
<form action="calendar.ca" method="post" name="sf">
   <div align="center">일정 검색
   <input type="text" size="10" name="year" placeholder="년도 입력" value="${param.year }">
  
   <select name="month">
      <option value="" disabled selected>선택하세요</option>
      <option value="1">1월</option>
      <option value="2">2월</option>
      <option value="3">3월</option>
      <option value="4">4월</option>
      <option value="5">5월</option>
      <option value="6">6월</option>
      <option value="7">7월</option>
      <option value="8">8월</option>
      <option value="9">9월</option>
      <option value="10">10월</option>
      <option value="11">11월</option>
      <option value="12">12월</option>
   </select>
   <script type="text/javascript">
      document.sf.month.value="${param.month}";
   </script>
   <input  type="submit" value="검색">
    </div>
</form>

<div>
  <div>
      <h2 align="center">${month }월<button onclick="onClick(this)" >등록</button></h2>
  </div>
  
  <c:set var="a" value="0"></c:set>
  <c:set var="doneLoop" value="false"/> 
  <table border="1" width="100%">
   <tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr>
     <c:forEach var="i" begin="0" end="4" step="1">
     <c:if test="${not doneLoop}">
        <tr>
           <c:forEach var="j" begin="0" end="6" step="1">
              <td width="70" height="120" align="center" valign="top" style="font-size:15px">
              <c:if test="${j==0}"><font color='red'></c:if>
              <c:if test="${j==6}"><font color='blue'></c:if>
              <c:if test="${i==0}">
                 <c:if test="${j>=dd}">
                    <c:set var="a" value="${a+1}"></c:set>
                    <a href="javascript:onClick(this)">${a}</a>
                 </c:if>
                 <c:if test="${j<dd}">
                    &nbsp;
                 </c:if>
              </c:if>
              <c:if test="${i!=0}">
                 <c:if test="${a<lastday}">
                    <c:set var="a" value="${a+1}"></c:set>
                    <a href="javascript:onClick(this)">${a}</a>
                 </c:if>
                 <c:if test="${a>=lastday}">
                    &nbsp;
                 </c:if>
              </c:if>
              <c:if test="${j==0 || j==6}">
                 </font>
              </c:if>
			           
              <c:forEach var="cal" items="${calen}">
                  <fmt:formatDate value="${cal.start_regdate}" pattern="yyyy" var="styear"/>
                  <fmt:formatDate value="${cal.start_regdate}" pattern="MM" var="stmonth"/>
                  <fmt:formatDate value="${cal.start_regdate}" pattern="dd" var="stday"/>
                  <fmt:formatDate value="${cal.end_regdate}" pattern="yyyy" var="enyear"/>
                  <fmt:formatDate value="${cal.end_regdate}" pattern="MM" var="enmonth"/>
                  <fmt:formatDate value="${cal.end_regdate}" pattern="dd" var="enday"/>  
               <c:choose>
                <c:when test="${cal.color=='lime' }">
                <c:if test="${year==styear && month==stmonth && a ==stday && cal.family_num == sessionScope.num}">
                    <div style="background-color: ${cal.color};">
                       <a href="javascript:win_open('${cal.num}')">${cal.subject}</a>
                    </div>
               </c:if> 
                  <c:if test="${year==enyear && month==enmonth && a==enday && cal.family_num == sessionScope.num}">
                    <c:if test="${cal.start_regdate != cal.end_regdate}">
                     <div style="background-color: ${cal.color};">
                        <a href="javascript:win_open('${cal.num}')">${cal.subject}끝</a>
                     </div>
                     </c:if>
               </c:if>
               </c:when>
               <c:otherwise>
               <c:if test="${month==stmonth && a ==stday && cal.family_num == sessionScope.num}">
                    <div style="background-color: ${cal.color};">
                       <a href="javascript:win_open('${cal.num}')">${cal.subject}</a>
                    </div>
               </c:if> 
                  <c:if test="${month==enmonth && a==enday && cal.family_num == sessionScope.num}">
                    <c:if test="${cal.start_regdate != cal.end_regdate}">
                     <div style="background-color: ${cal.color};">
                        <a href="javascript:win_open('${cal.num}')">${cal.subject}끝</a>
                     </div>
                     </c:if>
               </c:if>
               </c:otherwise>
               </c:choose>
               </c:forEach>
              </td>
           </c:forEach>
           </tr>
           <c:if test="${result>=lastday}">
            <c:set var="doneLoop" value="true"/>
           </c:if>
     </c:if>
     </c:forEach>
     </table>
</div>

<!-- The Modal -->
<div id="myModal" class="modal">
  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <form action="write.ca" name="f" >
    <input type="hidden" name="family_num" value="${param.family_num}">
    <table align="center">
    <caption><h3>일정등록</h3></caption>
		<tr><th>날짜</th><td><input type="date" name="startdate">~<input type="date" name="enddate"></td></tr>
		<tr><th>제목</th><td><input type="text" name="subject" ></td></tr>
		<tr><th>선택</th><td><select name="color">
					<option value="lime">일정</option>
					<option value="tomato">기념일</option>
					<option value="yellow">제사</option>
					<option value="pink">생일</option>
		</select>
		<script type="text/javascript">
      document.f.color.value='${param.color}';
   </script>
		</td></tr>
		<tr align="center"><td colspan="2">
		<a href="javascript:board_submit()">[등록]</a>
		</td></tr></table></form>
  </div>
</div>
<script>
function onClick(element){
	document.getElementById("myModal").style.display="block";
}
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
/* var btn = document.getElementById("myBtn"); */

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
/* btn.onclick = function() {
    modal.style.display = "block";
} */

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
<script type="text/javascript">
	function board_submit() {
		if(document.f.startdate.value=='') {
			alert('시작일을 입력해주세요');
			document.f.name.focus();
			return;
		} 
		if(document.f.enddate.value=='') {
			alert('마침일을 입력해주세요');
			document.f.pass.focus();
			return;
		} 
		if(document.f.subject.value=='') {
			alert('제목을 입력해주세요');
			document.f.subject.focus();
			return;
		} 
		if(document.f.color.value=='') {
			alert('선택주세요');
			document.f.content.focus();
			return;
		} 
		document.f.submit(); 
	}
	
</script>
<script type="text/javascript">
	function win_open(num)	{
		var op = "width=500,height=300,scrollbars=yes,left=50,top=150";
			window.open("updateForm.ca?num="+num,"update",op);
	}
</script>
</body>
</html>