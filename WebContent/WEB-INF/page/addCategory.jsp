<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#result").hide(0);
		
		//alert($("#but").val());
		$("#but").click(function () {
			//alert($("#parentCategory").val());
			if ($("#name").val() != ""){
				alert(1);
				$.ajax({
					url:"",
					type:"post",
					data:{
					"name":$("#name").val(),
					"parentCategory":$("#parentCategory").val()
					},
					dataType:"text",
					success:function (data){
						alert(data);
						if (data == 0){
							$("#result").html("添加成功,返回查看");
							$("#result").show(2000);
						} else if (data == 1){
							$("#result").html("添加失败,请稍后重试!");
							$("#result").show(2000);
							$("#result").hide(4000);
						}
					}
				});
				//
			} else {
				$("#result").html("车辆名称为空!")
			}
			//
			
		
		
		
		});
		
		
		
			
			//
			$.ajax({
				url:"category_queryAllParent.html",
				type:"post",
				data:{
				},
				dataType:"Json",
				success:function (data){
					//alert(data);
					var temp = "<option value='根目录'>此品牌为父类</option>";
					for (var i = 0 ;i < data.length ; i++ ){
						temp += "<option value="+data[i].name+">"+data[i].name+"</option>";
					}
					$("#parentCategory").html(temp);
				}
			});
			//
		
		
	
	});
</script>
<title>车辆添加!</title>
</head>
<body>
	<div align="center">
		<h1>品牌添加界面!</h1>
		
		<table>
			<tr>
				<td>品牌名称</td>
				<td>品牌父类</td>
			</tr>
			<tr>
				<td><input type="text" id="name"></td>
				<td>
					<select id="parentCategory">
						
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" id="but" value="添加"></td>
				<td></td>
			</tr>
		</table>
		<h4 id="result">
			
		</h4>
	</div>
	
	
</body>
</html>