package com.kgc.kd56.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.alibaba.fastjson.JSONObject;
import com.kgc.kd56.entity.Users;
import com.kgc.kd56.service.UsersService;
import com.kgc.kd56.service.UsersServiceImpl;

@WebServlet("/QueryOneByUidServlet")
public class QueryOneByUidServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsersService service = new UsersServiceImpl();

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 创建字符编码格式,防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 创建out输出对象
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		
		Users u = service.queryOneUser(uid);
		
		//创建JSONObject对象
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("u", u);
		System.out.println(jsonObject);  //后台输出
		out.println(jsonObject);		//写到前台客户端
	}

}
