<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请登录</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#but").click(function () {
			//alert(1);
			$.ajax(
					{
					url:

				}
				
					)
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
		<h3></h3>
		
	</div>
</body>
</html>