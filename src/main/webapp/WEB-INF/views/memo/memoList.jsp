<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../resources/js/memo.js"></script>
<script type="text/javascript">
	$(function() {
		getList(1,'','');
		$("#btn").click(function() {
			var writer =$("#writer").val();
			var contents = $("#contents").val();
			memoWrite(writer,contents);
		});
		
		$("#btnView").click(function() {
			memoView(1);
		});
		
	});

</script>
</head>
<body>
	<div>
		<form action="" >
			<p><input type="text" id="writer"></p>
			<p><textarea rows="" cols="" id="contents"></textarea> </p>
			<input type="button" id="btn" value="Write">
		</form>
	</div>

	<div id="result"></div>
	<button id="btnView">View</button>
	
</body>
</html>