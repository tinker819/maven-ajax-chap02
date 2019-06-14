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

@WebServlet("/UsersServlet2")
public class UsersServlet2 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//数据模拟
		//创建字符编码格式,防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//创建out输出对象
		PrintWriter out = response.getWriter();
		
		//创建一个用户对象
		String uid = UUID.randomUUID().toString().replace("-", "");
		Users u = new Users(uid, "张三", "1999-10-10 12:12:12", 0, 0);
		
		
		//创建多个用户对象
		List<Users> lUsers = new ArrayList<Users>();
		for(int i = 0;i<5; i++){
			Random r = new Random();
			int ranNum = r.nextInt(2);
			Users user = new Users(UUID.randomUUID().toString().replace("-", ""),
									"张三"+i, "199"+i+"-10-10 12:12:12", ranNum, ranNum);
			lUsers.add(user);
		}
		
		//将获取的单个用户对象和获取的多个用户对象通过使用ajax在前台进行获取
		/**
		 * 强调:因为前台页面不好处理非字符串的数据,所以,后台提出将非字符串的数据转换成类似字符串的数据处理形式
		 * 
		 * 
		 */
		//创建JSONObject对象,用来转换json格式数据
		JSONObject jsonObject = new JSONObject();
		//将需要转换成json格式的数据，直接put放到JSONObject对象中
		jsonObject.put("u", u);
		jsonObject.put("lUsers", lUsers);
	
		//通过out输出对象,将jsonObject写到前台中
		out.println(jsonObject);
		
	}

}







