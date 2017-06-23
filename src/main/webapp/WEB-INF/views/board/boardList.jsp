<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".go").click(function() {
			var cur = $(this).attr("id");
			document.frm.curPage.value=$(this).attr("id");
			document.frm.search.value="${listInfo.search}";
			document.frm.find.vlue="${listInfo.find}";
			document.frm.submit();
			/* location.href ="${board}List?curPage="+cur+"&search=${listInfo.search}&find=${listInfo.find}"; */
		})
		
		
	})
</script>
</head>
<body>
	<!-- List 제목  -->
	<h1> ${board}</h1>
	
	<div>
		<form action="${board}List" name="frm">
			<input type="hidden" name="curPage">
			<select name="search">
				<option value="title">TITLE</option>
				<option value="writer">WRITER</option>
				<option value="contents">CONTENTS</option>
			</select>
			<input type="text" name="find">
			<input type="submit" value="검색">
			
		</form>
	</div>
	
	<table>
		<tr>
			<td>num</td>
			<td>title</td>
			<td>writer</td>
			<td>date</td>
			<td>hit</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td>
				<c:catch>
					<c:forEach begin="1"  end="${dto.depth}">
						&nbsp;&nbsp;&nbsp;>>>
					</c:forEach>
				</c:catch>
					<a href="${board}View?num=${dto.num}">${dto.title}</a>
				</td>
				<td>${dto.writer}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.hit}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${listInfo.curBlock >1 }">
		<span class="go" id="${listInfo.startNum-1 }" style="cursor: pointer;">[이전]</span>
	</c:if>
	<c:forEach begin="${listInfo.startNum}" end="${listInfo.lastNum}" var="i">
		<span class="go" id="${i }">${i}</span>
	</c:forEach>
	<c:if test="${listInfo.curBlock < listInfo.totalBlock }">
		<span class="go" id="${listInfo.lastNum+1 }">[다음]</span>
	</c:if>
	
	<a href="${board }Write">WRITE</a>
	<div>
		<p>curPage	: ${listInfo.curPage}</p>
		<p>Search	: ${listInfo.search }</p>
		<p>Find 	: ${listInfo.find }</p>
	</div>
	
</body>
</html>