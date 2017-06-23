<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../resources/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
    //������������
    var editor_object = [];
     
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: editor_object,
        elPlaceHolder: "smarteditor",
        sSkinURI: "../resources/SE2/SmartEditor2Skin.html", 
        htParams : {
            // ���� ��� ���� (true:���/ false:������� ����)
            bUseToolbar : true,             
            // �Է�â ũ�� ������ ��� ���� (true:���/ false:������� ����)
            bUseVerticalResizer : true,     
            // ��� ��(Editor | HTML | TEXT) ��� ���� (true:���/ false:������� ����)
            bUseModeChanger : true, 
        }
    });
     
    //���۹�ư Ŭ���̺�Ʈ
    $("#savebutton").click(function(){
        //id�� smarteditor�� textarea�� �����Ϳ��� ����
        editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
         
        // �̺κп� ������ validation ����
         
        //�� submit
        $("#frm").submit();
    })
})
</script>
</head>

<body>
	
	<form id="frm" action="notice${path}" method="post" >
		<p><input type="hidden" name="num" value="${dto.num}"> </p> 
		<p>�ۼ���:<input type="text" name="writer" value="${dto.writer}"> </p>
		<p>����:<input type="text" name="title" value="${dto.title}"> </p>
		<p>����: <textarea  id="smarteditor" rows="" cols="">${dto.contents}</textarea></p>
		
		<p><input id="savebutton" type="button" name="WRITE" value="����"> </p>	
	</form>
	
</body>


</html>