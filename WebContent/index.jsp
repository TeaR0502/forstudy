<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请登录</title>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function () {
		
		$("#but").click(function () {
			//alert($("#username").val());
			
			//
			$.ajax({
				url:"user_userLogin.html",
				type:"post",//以post方式请求
				data:{
					"username":$("#username").val(),
					"password":$("#password").val()
					},//传参
				dataType:"text",//服务器返回的数据类型
				success:function(data){
					//alert(data);
					if (data == 1){
						//alert("密码错误请重试!");
						$("#result").html("密码错误请重试!");
						$("#password").val("");
						$("#username").val("");
					} else{
						//window.location.href="showcar.jsp";
						//alert("登陆成功!欢迎访问<a herf='showcar.jsp'>车辆界面!</a>");
						$("#result").html("登陆成功!欢迎访问<a href='showcar.jsp'>车辆界面!</a>");
					}
					
				},
				error:function(e){
					alert("错误"+e);
				}
			});

			//
		});
	});
</script>
</head>
<body>
	<div align="center">
		<h1>请先登录</h1>
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" id="username"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" id="password"></td>
			</tr>
			<tr>
				<td> </td>
				<td><input type="button" id="but" value="登陆"></td>
			</tr>
		</table>
		<h3 id="result">汽车管理!</h3>
		
	</div>
</body>
</html>