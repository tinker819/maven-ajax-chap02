package com.kgc.kd56.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgc.kd56.service.UsersServiceImpl;

@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//创建业务访问层对象
	private UsersServiceImpl uImpl = new UsersServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建字符编码格式,防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 创建out输出对象
		PrintWriter out = response.getWriter();
		//获取前台传递的uid
		String uid = request.getParameter("uid");
		
		int delRes = uImpl.delUsersById(uid);
		
		out.println(delRes);
	}
}
