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
		
		$("#infobut").click(function () {
			//alert($("#info").val());
			//
			$.ajax({
				url:"car_vagueQuery.html",
				type:"post",
				data:{"info":$("#info").val()},
				dataType:"Json",
				success:function (data){
					//alert(data[0].carId);
					if (data != null && data != ""){
						//alert("获取成功");
						var temp = "<tr>"+
						"<td>车辆编号</td>"
						+"<td>车辆名称</td>"
						+"<td>车辆价格</td>"
						+"<td>车辆颜色</td>" +"</tr>";
							for (var i = 0;i < data.length;i++){
								temp += "<tr>"+
								"<td>" +data[i].carId+"</td>"
								+"<td>"+data[i].name+"</td>"
								+"<td>"+data[i].price+"</td>"
								+"<td>"+data[i].color+"</td>" +"</tr>";
							}
							$("#showcar").html(temp);
					} else {
						alert("获取信息失败,价格只能精确查找");
					}
				
				}
			});
			//
			
		});
		
		//
		$.ajax({
			url:"car_allCar.html",
			type:"post",
			data:{},
			dataType:"Json",
			success:function (data){
				//alert(data[0].carId);
				if (data != null && data != ""){
					//alert("获取成功");
					var temp = "<tr>"+
					"<td>车辆编号</td>"
					+"<td>车辆品牌</td>"
					+"<td>车辆价格</td>"
					+"<td>车辆颜色</td>" +"</tr>";
						for (var i = 0;i < data.length;i++){
							temp += "<tr>"+
							"<td>" +data[i].carId+"</td>"
							+"<td>"+data[i].name+"</td>"
							+"<td>"+data[i].price+"</td>"
							+"<td>"+data[i].color+"</td>" +"</tr>";
						}
						$("#showcar").html(temp);
				} else {
					alert("获取信息失败");
				}
				
			}
		});
		//
	});
</script>
<title>车辆展示!</title>
</head>
<body>
	<div align="center">
		<h1>车辆管理界面!</h1>
		<h5><a href="user_exit.html">退出</a></h5>
		 查询车辆信息:<input type="text" id="info"><input type="button" id="infobut" value="查询">
		<table id="showcar" align="center">
		</table>
		
	</div>
	<c:if test="${sessionScope.user == 'admin' }">
	<div id="addCar" align="center">
		<a href="addcar.html">增加车辆</a>
	</div>
	</c:if>
</body>
</html>