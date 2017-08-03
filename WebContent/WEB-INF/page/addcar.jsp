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
			//alert(1);
			if ($("#name").val() != ""){
				alert(1);
				$.ajax({
					url:"car_addCarInfo.html",
					type:"post",
					data:{
					"name":$("#name").val(),
					"price":$("#price").val(),
					"color":$("#color").val(),
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
		
		
		
		$("#name").blur(function () {
			
			//alert(1);
			//
			$.ajax({
				url:"car_checkCarName.html",
				type:"post",
				data:{
				"name":$("#name").val()
				},
				dataType:"text",
				success:function (data){
					//alert(data);
					if (data == 1){
						$("#result").html("该车名已存在");
						$("#name").val("");
						$("#result").show(2000);
					} else if (data == 0){
						$("#result").html("该名可以使用!");
						$("#result").show(2000);
						$("#result").hide(4000);
					}
				}
			});
			//
		});
		
		
	
	});
</script>
<title>车辆添加!</title>
</head>
<body>
	<div align="center">
		<h1>车辆添加界面!</h1>
		
		<table>
			<tr>
				<td>车辆名称</td>
				<td>车辆价格</td>
				<td>车辆颜色</td>
			</tr>
			<tr>
				<td><input type="text" id="name"></td>
				<td><input type="text" id="price"></td>
				<td><input type="text" id="color"></td>
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