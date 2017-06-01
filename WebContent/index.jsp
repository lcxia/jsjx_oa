<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background:url(images/jinshang.jpg);background-size:cover;">
		<h2 style="margin:50px 5px 5px 400px;font-size:50px">井上机械办公自动化系统</h2>
    	<form action="LoginServlet" method="post" style="margin:200px 200px 5px 800px;font-size:25px;background:">
    			<br>
				<label>用户名：</label>
				<input name="employeeName" style="width:200px;height:25px">
				<br><br>
				<label>密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
				<input name="employeePass" type="password" style="width:200px;height:25px">
				<br><br>
			</div>
			<!-- <div class="fitem">
				<label>验证码：</label>
				<input name="checkCode" class="easyui-textbox" required="true">
			</div> -->
				&nbsp;&nbsp;<input type="submit" value="登录" style="font-size:20px">&nbsp;&nbsp;
				<input type="reset" value="重置" style="margin:0px 0px 40px 0px;font-size:20px">
		</form>
</body>
</html>