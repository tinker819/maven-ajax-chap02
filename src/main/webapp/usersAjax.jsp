<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	th{
		background-color: lightBlue;
	}
	
	tr:NTH-OF-TYPE(odd) {
		background-color: lightGreen;
	}
	
	tr{
		line-height: 32px;
	}
	
	form,table{
		width：80%;
		margin: 0px auto;
		text-align: center;
	}
	.tb2{
		width:500px;
	}
	
	.tb2 td{
		text-align: left;
	}
</style>
</head>
<body>
	<form  method="post">
	选择:<select name="sel">
			<option value="-1">请选择</option>
			<option value="1">选择一</option>
			<option value="2">选择二</option>
			<option value="3">选择三</option>
		</select>
		<h2>用户列表</h2>
		<!-- 显示的所有用户信息 -->
		<table class="tb1">
			<tr>
				<td colspan="6"><a href="add.jsp" style="text-align: right;">录入用户</a></td>
			</tr>
			<tr>
				<th>用户ID</th>
				<th>用户名</th>
				<th>出生日期</th>
				<th>性别</th>
				<th>用户状态</th>
				<th>操作</th>
			</tr>
		</table>
	
		<!--修改界面  -->
		<div id="edit">
			<table class="tb2">
				<tr>
					<th>用户ID</th>
					<td><input type="text" name="uid" id="uid" readonly="readonly"/></td>
				</tr>
				<tr>
					<th>用户名</th>
					<td><input type="text" name="uname" id="uname" /></td>
				</tr>
				<tr>
					<th>出生日期</th>
					<td><input type="date" name="borndate" id="borndate" /></td>
				</tr>
				<tr>
					<th>性别</th>
					<td>
						<input type="radio" name="sex" id="boy" value="0"/>男
						<input type="radio" name="sex" id="girl" value="1"/>女
					</td>
				</tr>
				<tr>
					<th>用户状态</th>
					<td>
						<select name="status" id="status">
							<option value="-1">请选择</option>
							<option value="0">正常</option>
							<option value="1">禁用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="button" value="修改" onclick="updateUser()"/>
						<input type="reset" value="重置"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
	
	
</body>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/userAjax.js"></script>
</html>