/**
 * 
 */


function memoView(num) {
	
	$.get("memoView?num="+num, function(data) {
		 alert(data.writer);
	})
	
	
}


function memoWrite(writer,contents) {
		$.ajax({
			url : "memoWrite",
			type :"POST",
			data :{
				writer : writer,
				contents : contents
			},
			success : function(data) {
				var result="<table>";
				$(data).each(function() {
					result=result + "<tr>";
					result=result +"<td>"+ this.num + "</td>";
					result=result +"<td>"+ this.contents + "</td>";
					result=result +"<td>"+ this.writer + "</td>";
					result=result +"<td>"+ this.reg_date + "</td>";
					result = result +"</tr>";
				});
				result =result+"</table>";
				$("#result").html(result);
			}
			
		});
}
	
function getList(curPage, find, search) {
		$.ajax({
			url : "getMemoList/"+curPage+"/"+find+"/"+search,
			type : "GET",

			success : function(data) {
			
				var result="<table>";
				$(data).each(function() {
					result=result + "<tr>";
					result=result +"<td>"+ this.num + "</td>";
					result=result +"<td>"+ this.contents + "</td>";
					result=result +"<td>"+ this.writer + "</td>";
					result=result +"<td>"+ this.reg_date + "</td>";
					result = result +"</tr>";
				});
				result =result+"</table>";
				$("#result").html(result);
			}
		});
}

//AJAX
/* $.get("URL?parameter=value",function(data){};
$.post("URL",{parameter : value },function(data){});
$.ajax({
	url : ,
	datatype: get/post,
	data:{
		
	},
	sucess : function(data) {
	}
});
$("#result").load() */