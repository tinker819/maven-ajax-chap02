$(function() {
	// 隐藏
	$("#edit").hide();

	loadAjax(); // 调用初始加载数据

	// 基于jQuery的单击事件绑定,定义委托事件
	// $(".tb1").on("click",".del",function(){});
	$(".tb1").on("click", ".del", function() {
		// 获取当前要删除的.del的下标
		var _thisIndex = $(".del").index(this);
		// alert(_thisIndex);
		// 获取对应删除的uid
		var uid = $(".uid").eq(_thisIndex).text();
		// alert(uid);
		// 使用ajax进行删除
		$.ajax({
			url : "DelServlet",
			type : "post",
			data : {
				"uid" : uid
			},
			dataType : "text",
			success : function(mes) {
				// alert(mes);
				if (mes.trim() == "1") {
					alert("删除成功");
					// window.location = "usersAjax.jsp";
					loadAjax(); // 调用初始加载的工厂函数
				} else {
					alert("删除失败");
				}
			},
			error : function() {
				alert("DelServlet  err...");
			}
		});
	});

	// 定义基于jQuery封装的委托事件,根据id删除
	$(".tb1").on("click", ".update", function() {
		// 隐藏.tb1
		$(".tb1").hide();
		$("#edit").show();

		var _thisIndex = $(".update").index(this);
		var uid = $(".uid").eq(_thisIndex).text();
		$.ajax({
			url : "QueryOneByUidServlet",
			type : "post",
			data : {
				"uid" : uid
			},
			dataType : "json",
			success : function(obj) {
				console.log(obj);
				// 将服务器端响应的封装json格式之后的Users的数据绑定到修改界面中
				$("#uid").val(obj.u.uid);
				$("#uname").val(obj.u.uname);
				// 将出生日期通过空格进行分割
				var bron = obj.u.borndate.split(" ");
				$("#borndate").val(bron[0]);

				// 用户性别
				var sexId = obj.u.sex;
				// 获取name="sex"的value值,使用属性选择器
				// $("input[name='sex']:eq("+sexId+")").prop("checked",true);
				// //基本选择器
				$("[name='sex']").eq(sexId).prop("checked", true); // 过滤筛选选择器

				// 用户状态
				var statusId = obj.u.status;
				$("#status").val(statusId);

			},
			error : function() {
				alert("QueryOneByUidServlet err...");
			}
		});
	});

});

// 定义初始加载ajax
function loadAjax() {
	$.ajax({
		url : "UsersServlet",
		type : "post",
		data : {},
		dataType : "json",
		success : function(obj) {
			$(".trInfo").remove(); // 移除当前(自身)的数据
			// 使用基于jQuery封装的的循环遍历方法]
			var str = "";
			$.each(obj.lUsers, function(i) {
				var sex = obj.lUsers[i].sex == 0 ? "男" : "女";
				var status = obj.lUsers[i].status == 0 ? "正常" : "禁用";
				// alert(i) ;
				str += " <tr class='trInfo'>             "
						+ " 	<td class='uid'>" + obj.lUsers[i].uid
						+ "</td>    " + " 	<td>" + obj.lUsers[i].uname
						+ "</td>    " + " 	<td>" + obj.lUsers[i].borndate
						+ "</td>    " + " 	<td>" + sex + "</td>    " + " 	<td>"
						+ status + "</td>    " + " 	<td> "
						+ "<a href='javascript:;' class='update'>修改</a> "
						+ "<a href='javascript:;' class='del'>删除</a> "
						+ "</td> " + " </tr>            ";
			});

			$(".tb1").append(str);

		},
		error : function() {
			alert("失败...");
		}
	});
}

// 定义js的修改事件
function updateUser() {
	// 获取修改界面的各个参数
	var uid = $("#uid").val();
	var uname = $("#uname").val();
	var borndate = $("#borndate").val();
	var sex = $("[name='sex']:checked").val();
	var status = $("#status").val();

	// alert(uid+","+uname+","+borndate+","+sex+","+status);
	$.ajax({
		url : "UpdateUserServlet",
		type : "post",
		data : {
			"uid" : uid,
			"uname" : uname,
			"borndate" : borndate,
			"sex" : sex,
			"status" : status
		},
		dataType : "text",
		success : function(mes) {
			// alert(mes);
			if (mes.trim() == "updateOk") {
				alert("修改成功");
				// 隐藏.tb1
				$(".tb1").show();
				$("#edit").hide();
				loadAjax(); // 加载
			} else {
				alert("修改失败")
			}
		},
		error : function() {
			alert("UpdateUserServlet err...");
		}
	});

}
