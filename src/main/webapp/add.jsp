<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
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
</style>
</head>
<body>
	<form id="addForm" method="post">
		<table>
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
						<input type="button" value="新增" onclick="addUser()"/>
						<input type="reset" value="重置"/>
					</td>
				</tr>
			</table>
	</form>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	//定义addUser()添加方法
	function addUser(){
		//通过表单序列化获取from组件中所有的name属性的对应value值
		var addForm = $("#addForm").serialize();
		//新增ajax
		$.ajax({
			url:"AddUserServlet",
			type:"post",
			data:addForm,
			dataType:"text",
			success:function(mes){
				//alert(mes);
				if(mes.trim()=="addOk"){
					alert("新增成功");
					window.location = "usersAjax.jsp";
				}else{
					alert("新增失败");
				}
			},
			error:function(){
				alert("AddUserServlet err...");
			}
		});
	}
</script>
</html>