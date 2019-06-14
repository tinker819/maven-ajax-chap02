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
	//����ҵ����ʲ����
	private UsersServiceImpl uImpl = new UsersServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ַ������ʽ,��ֹ��������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//����out�������
		PrintWriter out = response.getWriter();
		//�������ݿ��л�ȡ�����û���Ϣ�ķ���
		List<Users> lUsers = uImpl.queryAllUsers();
		
		//����JSONObject����,����ת��json��ʽ����
		JSONObject jsonObject = new JSONObject();
		//����Ҫת����json��ʽ�����ݣ�ֱ��put�ŵ�JSONObject������
		jsonObject.put("lUsers", lUsers);
	
		//ͨ��out�������,��jsonObjectд��ǰ̨��
		out.println(jsonObject);
		
	}

}







