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
		background-color: pink;
	}
</style>
</head>
<body>
	<h2>获取单个用户对象</h2>
	<ul id="u"></ul>
	
	<hr/>
	<table>
		<tr>
			<th>用户ID</th>
			<th>用户名</th>
			<th>出生日期</th>
			<th>性别</th>
			<th>用户状态</th>
			<th>操作</th>
		</tr>
	</table>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"UsersServlet",
			type:"post",
			data:{},
			dataType:"json",
			success:function(obj){
				console.log(obj);
				//alert(obj.u.borndate);
				var sex = obj.u.sex == 0 ? "男":"女";
				var status = obj.u.status == 0?"正常":"禁用";
				var oneU =  " <li>"+obj.u.uid+"</li>  "+
							" <li>"+obj.u.uname+"</li>  "+
							" <li>"+obj.u.borndate+"</li>  "+
							" <li>"+sex+"</li>  "+
							" <li>"+status+"</li>  ";
				$("#u").html(oneU);
				
				
				//使用基于jQuery封装的的循环遍历方法]
				var str = "";
				$.each(obj.lUsers,function(i){
					var sex = obj.lUsers[i].sex == 0 ? "男":"女";
					var status = obj.lUsers[i].status == 0?"正常":"禁用";
					//alert(i)	;
					 str += 	" <tr>             "+  
								" 	<td>"+obj.lUsers[i].uid+"</td>    "+
								" 	<td>"+obj.lUsers[i].uname+"</td>    "+
								" 	<td>"+obj.lUsers[i].borndate+"</td>    "+
								" 	<td>"+sex+"</td>    "+
								" 	<td>"+status+"</td>    "+
								" </tr>            ";
				});
				
				$("table").append(str);
			},
			error:function(){
				alert("失败...");
			}
		});
	})
</script>
</html>