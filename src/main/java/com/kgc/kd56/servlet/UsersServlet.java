package com.kgc.kd56.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.kgc.kd56.entity.Users;
import com.kgc.kd56.service.UsersServiceImpl;

@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	//创建业务访问层对象
	private UsersServiceImpl uImpl = new UsersServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建字符编码格式,防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//创建out输出对象
		PrintWriter out = response.getWriter();
		//调用数据库中获取所有用户信息的方法
		List<Users> lUsers = uImpl.queryAllUsers();
		
		//创建JSONObject对象,用来转换json格式数据
		JSONObject jsonObject = new JSONObject();
		//将需要转换成json格式的数据，直接put放到JSONObject对象中
		jsonObject.put("lUsers", lUsers);
	
		//通过out输出对象,将jsonObject写到前台中
		out.println(jsonObject);
		
	}

}







