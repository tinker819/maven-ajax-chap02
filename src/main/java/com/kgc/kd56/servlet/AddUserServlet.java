package com.kgc.kd56.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgc.kd56.entity.Users;
import com.kgc.kd56.service.UsersService;
import com.kgc.kd56.service.UsersServiceImpl;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UsersService service = new UsersServiceImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建字符编码格式,防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 创建out输出对象
		PrintWriter out = response.getWriter();
		
		String uid = UUID.randomUUID().toString().replace("-", "");
		String uname = request.getParameter("uname");
		String borndate = request.getParameter("borndate");
		int sex = Integer.valueOf(request.getParameter("sex"));
		int status = Integer.valueOf(request.getParameter("status"));

		// 创建Users对象
		Users u = new Users(uid, uname, borndate, sex, status);
		int addRes = service.addUsers(u);
		if(addRes>0){
			out.print("addOk");
		}else{
			out.println("addFail");
		}
	}

}
